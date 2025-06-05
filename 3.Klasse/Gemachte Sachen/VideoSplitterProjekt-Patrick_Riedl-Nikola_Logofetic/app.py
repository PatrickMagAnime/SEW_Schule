# Code von Patrick Riedl und Nikola Logofetic

import os                   #betriebssystem funktionen zugriff
import json                 #selbsterklärend
import shutil               #um dateien drag and droppen, verschieben usw.
import subprocess           #um andere programme auszuführen, in unserem fall ffmpeg
import math                 #mathe
import threading            #threads
import platform             #findet heraus auf welchen betriebssystem man ist
import webbrowser           #öffnet URLs 
from datetime import datetime  # Zum Erzeugen von Zeitstempeln
from flask import Flask, render_template, request, jsonify, send_from_directory  # flask framework 
 
app = Flask(__name__)       #erstellen einer Flask app
# Das sieht nur wegen den kommentaren nach viel code aus, ist es aber nicht.

# Pfade
BASE_DIR = r"/home/patrick/Documents/SEW/3.Klasse/VideoSplitter-V4"  # Basisverzeichnis (Pfad zum Projektordner)
INPUT_DIR = os.path.join(BASE_DIR, "input")       # Verzeichnis für die Eingabe-Videodateien
OUTPUT_DIR = os.path.join(BASE_DIR, "output")     # Verzeichnis für die Ausgabedateien nach der Verarbeitung
CONFIG_DIR = os.path.join(BASE_DIR, "config")     # Verzeichnis für Konfigurationsdateien
LOGS_DIR = os.path.join(BASE_DIR, "logs")         # Verzeichnis für Log-Dateien

# erstellen der Verzeichnisse wenn sie nicht existieren
os.makedirs(INPUT_DIR, exist_ok=True)
os.makedirs(OUTPUT_DIR, exist_ok=True)
os.makedirs(CONFIG_DIR, exist_ok=True)
os.makedirs(LOGS_DIR, exist_ok=True)

# Globale variablen
current_progress = 0         #Speichert den Fortschritt in Prozent
processing_active = False    #flag, das angibt, ob eine Verarbeitung gerade aktiv ist wie .lock als Beispiel
current_status = ""          #aktuell laufende Statusmeldung

# Funktion zum schreiben in eine log Datei
def log_message(message):
    with open(os.path.join(LOGS_DIR, "app.log"), "a") as f:  # Öffnet die Log-Datei im "append"-Modus um nichts zu überschreiben
        f.write(f"{datetime.now()}: {message}\n")           # Schreibt die Zeit in die nachricht

#laden von Einstellungen aus einer JSON-Konfigurationsdatei (mit kleiner hilfe von Chatgpt)
def load_settings():
    config_path = os.path.join(CONFIG_DIR, "master_config.json")   #aufbau des Pfads zur Konfigurationsdatei
    if os.path.exists(config_path):                                #prüft ob die Datei existiert
        with open(config_path) as f:
            return json.load(f)                                    #Lädt die Einstellungen
    return {}                                                     #Rückgabe eines leeren Dictionarys wenn keine datei existiert

#Funktion zum Speichern von Einstellungen in einer JSON Datei
def save_settings(settings):
    with open(os.path.join(CONFIG_DIR, "master_config.json"), "w") as f:   #Öffnet die Datei im Schreibmodus
        json.dump(settings, f, indent=4)                                  #Speichert die Einstellungen mit schöner Formatierung

#Funktion, um die Dauer eines Videos ermitteln, verwendet dazu ffprobe (teil von ffmpeg)
def get_video_duration(video_path):
    result = subprocess.run(
        [
            "ffprobe",                   # ffprobe-Programm analysiert Medieninhalte. dauer usw
            "-i", video_path,            # eingabe wo die Videodatei ist
            "-show_entries", "format=duration",  # Gibt die Dauer des Videos aus
            "-v", "quiet",               # Unterdrückt unnötige Log-Ausgaben
            "-of", "csv=p=0"             # Ausgabeformat als CSV ohne zusätzliche Informationen
        ],
        stdout=subprocess.PIPE,         # Leitet die Standardausgabe in eine Variable um
        stderr=subprocess.STDOUT         # Fehler werden mit der Standardausgabe zusammengeführt
    )
    return math.ceil(float(result.stdout))  # Konvertiert die Dauer in float, rundet sie mit math.ceil auf

#fnktion zur asynchronen Verarbeitung von Videos, ausgeführt in einem separaten Thread
def process_video_async(settings):
    global current_progress, processing_active, current_status
    
    try:
        processing_active = True  # Setzt das Flag, dass die Verarbeitung läuft
        current_progress = 0      # Setzt den Fortschritt zurück
        
        # Sucht alle Videodateien im INPUT_DIR, die in unterstützten Formaten vorliegen
        videos = [f for f in os.listdir(INPUT_DIR) if f.lower().endswith(
            ('.mp4', '.mkv', '.avi', '.mov', '.wmv', '.flv', '.webm', '.mpeg', '.mpg', '.ogv', '.3gp', 
             '.ts', '.m2ts', '.mxf', '.rm', '.vob', '.divx', '.f4v', '.h264', '.hevc', '.m4v', '.mts', 
             '.mjpeg', '.ogm', '.dv', '.asf', '.rmvb', '.nsv', '.amv', '.bik', '.drc', '.dpg', '.fli', 
             '.flm', '.mve', '.roq', '.smk', '.str', '.thp', '.vc1', '.vp6', '.yuv'))]
        
        if not videos:  # Falls keine Videos gefunden wurden, wird ein Status gesetzt und die Funktion beendet
            current_status = "Keine Videodateien gefunden"
            return

        total_videos = len(videos)       # Berechnet die Gesamtzahl der Videos
        progress_step = 100 / total_videos  # Ermittelt den Fortschrittsschritt pro Video

        # Schleife über alle gefundenen Videos
        for video in videos:
            video_path = os.path.join(INPUT_DIR, video)  # Vollständiger Pfad zum aktuellen Video
            current_status = f"Verarbeite: {video}"        # Aktualisiert den aktuellen Status
            log_message(current_status)                    # Schreibt den Status in die Log-Datei

            video_duration = get_video_duration(video_path)  # Ermittelt die Videodauer
            segment_duration = int(settings['segment_duration'])  # Segmentlänge aus den Einstellungen
            number_of_segments = math.ceil(video_duration / segment_duration)  # Anzahl der Segmente

            # Schleife über alle Segmente des Videos
            for i in range(number_of_segments):
                start_time = i * segment_duration  # Berechnet den Startzeitpunkt des aktuellen Segments
                segment_length = segment_duration  # Standardsegmentlänge

                # Anpassung des letzten Segments falls der verbleibende Teil kürzer als segment_duration ist
                if i == number_of_segments - 1 and video_duration - start_time < segment_duration:
                    remaining_time = video_duration - start_time
                    padding = segment_duration - remaining_time
                    start_time = max(0, start_time - padding)  # Verschiebt Startzeitpunkt, wenn nötig
                    segment_length = video_duration - start_time  # Passt die Länge des Segments an

                # Bestimmen des Ausgabeformats; wenn 'original' gewählt wird, bleibt das Originalformat erhalten
                output_format = settings.get('output_format', 'mp4')
                if output_format == 'original':
                    output_format = os.path.splitext(video)[1][1:]

                #festlegen des Namens der Ausgabedatei
                if settings.get('keep_original_name', True):
                    base_name = os.path.splitext(video)[0]  #Extrahiert den Basisnamen
                    custom_suffix = settings.get('custom_name', '')
                    suffix = f" {custom_suffix}" if custom_suffix else ""
                    output_file_name = f"{base_name} {i+1}-{number_of_segments}{suffix}.{output_format}"
                else:
                    output_file_name = f"{settings.get('custom_name', 'output')} {i+1}-{number_of_segments}.{output_format}"

                output_file = os.path.join(OUTPUT_DIR, output_file_name)  #Vollständiger Ausgabepfad

                if os.path.exists(output_file):  # Überspringt Segment, falls die Ausgabedatei bereits existiert
                    continue

                #konstruktion des ffmpeg Kommandos zum Schneiden des Videos
                cmd = [
                    "ffmpeg",
                    "-ss", str(start_time),                 # Startzeit des Segments
                    "-i", video_path,                       # Eingabe-Videodatei
                    "-t", str(segment_length),              # Dauer des Segments
                    "-c:v", settings.get('codec', 'copy'),  # Videocodec; "copy" bedeutet ohne Neukodierung
                    "-c:a", settings.get('audio_codec', 'copy')  # Audiocodec; "copy" für direkten Streamcopy
                ]

                # Zusätzliche Optionen werden hinzugefügt, falls in den Einstellungen vorhanden
                if settings.get('bitrate'):
                    cmd.extend(["-b:v", settings['bitrate']])  #setzt die Zielbitrate
                if settings.get('resolution'):
                    cmd.extend(["-s", settings['resolution']])  #Setzt die Auflösung
                if settings.get('fps'):
                    cmd.extend(["-r", str(settings['fps'])])    #Legt die Bildrate fest

                cmd.append(output_file)  # Append des Ausgabe-Dateipfads als letztes Argument
                
                # ausführen des ffmpeg Kommandos und Erfassen des Ergebnisses
                result = subprocess.run(
                    cmd,
                    stdout=subprocess.PIPE,
                    stderr=subprocess.STDOUT,
                    text=True
                )

                # Falls ffmpeg einen Fehler liefert, wird dieser geloggt und mit dem nächsten Segment fortgefahren
                if result.returncode != 0:
                    log_message(f"Fehler bei {video}: {result.stdout}")
                    continue

                # Falls das Extrahieren des Audios aktiviert ist wird ein zusätzlicher ffmpeg-Aufruf getätigt
                if settings.get('extract_audio', False):
                    audio_output = os.path.splitext(output_file)[0] + f".{settings.get('audio_format', 'mp3')}"
                    audio_cmd = [
                        "ffmpeg",
                        "-i", output_file,      # Verwendet die gerade erstellte Videosegmentdatei
                        "-q:a", "0",            # Beste Audioqualität
                        "-map", "a",            # Extrahiert nur den Audiostream
                        audio_output            # Pfad zur Ausgabedatei für den Audiostream
                    ]
                    subprocess.run(audio_cmd)

            os.remove(video_path)         # Löscht die ursprüngliche Videodatei nach der Verarbeitung
            current_progress += progress_step  # Aktualisiert den Fortschritt

        current_status = "Verarbeitung abgeschlossen"   # Setzt den abschließenden Status
        log_message(current_status)                       # Loggt den Abschlussstatus

    except Exception as e:        # Fängt alle möglichen Fehler ab
        log_message(f"Fehler: {str(e)}")  # Loggt beschreibt den Fehler
    finally:
        processing_active = False   # Setzt das Flag zurück, dass keine Verarbeitung mehr aktiv ist

# Route für die Startseite; liefert index.html aus dem Vorlagenverzeichnis
@app.route('/')
def index():
    return render_template('index.html')  # Rendert und liefert die index.html zurück

# API-Route, die die Listen der Eingabe- und Ausgabedateien als JSON zurückgibt
@app.route('/api/files', methods=['GET'])
def get_files():
    input_files = [f for f in os.listdir(INPUT_DIR) if f.lower().endswith(('.mp4', '.mkv', '.avi'))]   # Filtert unterstützte Eingabeformate
    output_files = [f for f in os.listdir(OUTPUT_DIR) if f.lower().endswith(('.mp4', '.mkv', '.avi'))]
    return jsonify({
        'input': input_files,    #rückgabe der Eingabedateien
        'output': output_files   #rückgabe der ausgabedateien
    })

#hat am anfang nicht funktioniert, deswegen musste sich mit AI ein wenig geholfen werden
# API Route um die vidoverarbeitung zu starten
@app.route('/api/process', methods=['POST'])
def process_video():
    global processing_active
    
    if processing_active:  #wenn bereits eine Verarbeitung aktiv ist, wird ein fehler zurückgegeben
        return jsonify({'error': 'Bereits in Bearbeitung'}), 400

    settings = request.json  #liest die Einstellungen aus der Anfrage (im JSON-Format)
    thread = threading.Thread(target=process_video_async, args=(settings,))  # Startet einen neuen Thread für die asynchrone Verarbeitung
    thread.start()  #Startet ein Thread
    
    return jsonify({'status': 'Verarbeitung gestartet'})

# API Route, die den aktuellen Verarbeitungsstatus, Fortschritt und Aktivitäts-Flag als JSON zurückgibt
@app.route('/api/status', methods=['GET'])
def get_status():
    return jsonify({
        'progress': current_progress,      #aktueller Fortschritt in Prozent
        'status': current_status,          #aktuelle Statusmeldungg
        'active': processing_active        #ob ein Vorgang aktiv ist
    })

# API Route zum Abruf und Speichern von Einstellungen
@app.route('/api/settings', methods=['GET', 'POST'])
def handle_settings():
    if request.method == 'POST':
        settings = request.json  #Liest neue Einstellungen aus der Anfrage
        save_settings(settings)  #Speichert die Einstellungen in der Konfigurationsdatei
        return jsonify({'status': 'settings saved'})
    return jsonify(load_settings())  #gibt die aktuell gespeicherten Einstellungen zurück

# API Route zum Hochladen von Dateien in das Eingabe- oder Ausgabe-Verzeichnis
@app.route('/api/upload', methods=['POST'])
def handle_upload():
    target = request.form.get('target', 'input')  # Bestimmt den Zielordner ("input" oder "output")
    file = request.files['file']                  # Liest die hochgeladene Datei
    dest = os.path.join(INPUT_DIR if target == 'input' else OUTPUT_DIR, file.filename)  # Bestimmt den vollständigen Zielpfad
    file.save(dest)                               #speichert die Datei am zielort
    return jsonify({'status': 'success'})

#Route um eine Vorschau einer Datei aus dem Eingabeverzeichnis anzuzeigen
@app.route('/preview/<path:filename>')
def preview_file(filename):
    return send_from_directory(INPUT_DIR, filename)  #Sendet die angeforderte Datei aus dem INPUT_DIR

# API Route zum Öffnen eines Ordners im System Dateimanager
@app.route('/api/open-folder', methods=['POST'])
def open_folder():
    data = request.json
    folder_path = data.get('path')  # liest den Ordnerpfad aus der Anfrage

    if not os.path.exists(folder_path):  # Prüft, ob der ordner existiert
        return jsonify({'error': 'Ordner existiert nicht'}), 404

    try:
        #öffnet den Ordner abhängig vom jeweiligen Betriebssystem
        if platform.system() == 'Windows':
            os.startfile(folder_path)        # Windows: Öffnet den Ordner im Explorer (funktioniert)
        elif platform.system() == 'Darwin':    # macOS: (nicht getestet)
            subprocess.run(['open', folder_path])
        else:                                  # Linux: (funktioniert noch nicht)
            subprocess.run(['xdg-open', folder_path])
        
        return jsonify({'status': 'Ordner geöffnet'})
    except Exception as e:
        return jsonify({'error': str(e)}), 500
    
# Startet den Flask-Webserver, falls die Datei direkt ausgeführt wird
if __name__ == '__main__':
    # Öffnet den Browser nur einmal, um das Projekt im Browser anzuzeigen
    if not os.environ.get("BROWSER_OPENED"):
        webbrowser.open('http://localhost:6969')  # öffnet die URL im Standardbrowser
        os.environ["BROWSER_OPENED"] = "1"          #Setzt eine Umgebungsvariable, um erneutes Öffnen zu verhindern (konnte ihch leider nur mit AI fixen. Es hat sich 8 mal geöffnet)
    app.run(debug=True, port=6969)  #Startet den Server im Debug Modus auf Port 6969