import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
public class MainTest {

    @Test
    void addieren(){
    int resultat = Main.addieren(3,2);
    int erwartetesErgebniss = 5;
    assertEquals(erwartetesErgebniss, resultat);
    }
}
