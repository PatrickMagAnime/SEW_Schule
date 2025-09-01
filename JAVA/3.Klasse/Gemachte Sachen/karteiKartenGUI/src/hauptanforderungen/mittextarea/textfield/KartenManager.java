package hauptanforderungen.mittextarea.textfield;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class KartenManager {
    private static final String FILE_PATH = "karten.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveKarten(ArrayList<Karte> karten) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(karten, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Karte> loadKarten() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Karte>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}