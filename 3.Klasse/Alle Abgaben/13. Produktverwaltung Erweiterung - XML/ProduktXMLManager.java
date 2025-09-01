import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProduktXMLManager {
    private static final XmlMapper xmlMapper = new XmlMapper();

    //XML saven
    public static void saveProdukte(ArrayList<Produkt> produkte, String filePath) {
        try {
            xmlMapper.writeValue(new File(filePath), produkte);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fehler beim Speichern der Produkte als XML.");
        }
    }

    //XML laden
    public static ArrayList<Produkt> loadProdukte(String filePath) {
        try {
            return xmlMapper.readValue(new File(filePath),
                    xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Produkt.class));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fehler beim Laden der Produkte aus XML.");
            return new ArrayList<>(); //rückgabe einer leeren liste bei Fehler
        }
    }
}
