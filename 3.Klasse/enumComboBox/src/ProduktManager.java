import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProduktManager {
    private static final String FILE_PATH = "produkt.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveProdukt(Produkt produkt) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(produkt, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Produkt loadProdukt() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Produkt.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}