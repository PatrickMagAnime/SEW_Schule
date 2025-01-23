import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProduktManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveProdukte(ArrayList<Produkt> produkte, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(produkte, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Produkt> loadProdukte(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Produkt>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Leere Liste zurückgeben, falls Fehler
        }
    }
}
