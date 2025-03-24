import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Programmed by PatrickMagAnime
// https://github.com/PatrickMagAnime/VideoSplitter

/*
 * STEP-BY-STEP EXPLANATION OF THIS MASTERPIECE (aka the program is written in Java :) )
 *                               (It’s actually not)
 *
 * 1. Check and create input/output folders:
 *    - First things first, the program checks if there's a folder called "Eingabe" (Input).
 *    - No folder? No problem. It'll create one for you like a good little helper.
 *    - Same deal with the "Ausgabe" (Output) folder, where your sweet, chopped-up video segments will land.

 * 2. Check for a single video in the input folder:
 *    - It peeks into "Eingabe" to make sure there's exactly ONE video. Not two, not zero. Just one.
 *    - If there's no video or too many, the program throws a fit (aka an error) and shuts itself down.
 *      You gotta play by the rules, bud.

 * 3. Ask the user to configure their masterpiece:
 *    - Wanna split your video into 59-second chunks? Cool, just tell it the duration.
 *    - Got fancy plans like copying the codec (`copy`) to keep quality high? No worries, the program’s got you.
 *    - Need to mess with the FPS (frames per second)? Sure, but only if you *really* know what you’re doing.
 *      Otherwise, it defaults to whatever FPS the video already has.

 * 4. Get a "yes" or "no" from you (because consent is important):
 *    - Before it starts slicing and dicing, it’ll ask: “Are you ready to process this video? (yes/no)”.
 *    - Say "no," and it’ll chill out, reset, and re-ask the questions. (It’s patient like that.)
 *    - Say "yes," and boom—it’s go time.

 * 5. Actually processing the video:
 *    - This is where the magic happens. The program calls `splitVideo`, which uses ffmpeg (the video wizard)
 *      to chop your video into segments.
 *    - If the last chunk of the video ends up too short (like 4 seconds), the program is like, “Nope, not today,”
 *      and makes it longer by repeating a small part from the previous chunk. No tiny clips allowed.

 * 6. Save the segments in the output folder:
 *    - Your glorious new video files will show up in the "Ausgabe" folder.
 *    - File names are snazzy, like: `OriginalFilename_Part1_ofX.mp4`. Yep, fancy numbering included.

 * 7. Rinse and repeat:
 *    - Once it’s done processing, it’ll ask, “Wanna do another video? (yes/no)”.
 *    - Say "yes," and the whole shebang starts over.
 *    - Say "no," and the program peaces out.

 * IMPORTANT STUFF YOU CAN’T IGNORE:
 * - Make sure ffmpeg is installed and properly set up in your PATH. Otherwise, this bad boy ain’t doing squat.
 * - The original video in "Eingabe" stays untouched. We’re not barbarians here.
 * - Keep your segment duration reasonable. Splitting into 1-second chunks is a surefire way to chaos.
 *
 * The program slices your video like a boss, asks for your input like a polite friend, and makes sure
 * everything ends up neatly in the output folder. Just don’t mess up, and you’re golden.
 * Totally not written by chat GPT,nahh nahhh jk bye.
 */

public class VideoSplitter {
    public static void main(String[] args) {

        File eingabeOrdner = new File("eingabe");
        File ausgabeOrdner = new File("ausgabe");

        if (!eingabeOrdner.exists()) {
            eingabeOrdner.mkdir();
            System.out.println("Eingabeordner erstellt: " + eingabeOrdner.getAbsolutePath());
        }
        if (!ausgabeOrdner.exists()) {
            ausgabeOrdner.mkdir();
            System.out.println("Ausgabeordner erstellt: " + ausgabeOrdner.getAbsolutePath());
        }

        Scanner scanner = new Scanner(System.in);
        boolean weiter = true;

        while (weiter) {

            File[] videos = eingabeOrdner.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp4") || name.toLowerCase().endsWith(".mkv"));
            if (videos == null || videos.length != 1) {
                System.out.println("Es muss genau eine Videodatei im Eingabeordner vorhanden sein.");
                break;
            }

            File video = videos[0];
            System.out.println("Gefundene Videodatei: " + video.getName());

            // Ask user for settings
            System.out.print("Geben Sie die Segmentdauer in Sekunden an (Standard: 59): ");
            int segmentDauer;
            try {
                segmentDauer = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                segmentDauer = 59; // Default value
                System.out.println("Ungültige Eingabe. Standardwert 59 wird verwendet.");
            }

            System.out.print("Geben Sie den Codec an (Standard: copy): ");
            String codec = scanner.nextLine().trim();
            if (codec.isEmpty()) {
                codec = "copy"; // Default value
            }

            System.out.print("Geben Sie die gewünschte FPS-Rate an (Standard: unverändert): ");
            int fps;
            try {
                fps = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                fps = -1; // Default for unchanged
                System.out.println("Ungültige Eingabe. FPS wird unverändert übernommen.");
            }

            System.out.print("Sind Sie bereit, die Videodatei zu verarbeiten? (ja/nein): ");
            String antwort = scanner.nextLine().trim().toLowerCase();
            if (antwort.equals("ja")) {
                try {
                    VideoSplitterUtils.splitVideo(video, ausgabeOrdner, segmentDauer, codec, fps);
                    System.out.println("Video erfolgreich unterteilt!");
                } catch (IOException e) {
                    System.err.println("Fehler beim Verarbeiten des Videos: " + e.getMessage());
                }
            } else {
                System.out.println("Verarbeitung abgebrochen.");
            }

            System.out.print("Möchten Sie ein weiteres Video verarbeiten? (ja/nein): ");
            String weiterAntwort = scanner.nextLine().trim().toLowerCase();
            weiter = weiterAntwort.equals("ja");
        }

        scanner.close();
        System.out.println("Programm beendet.");
    }
}