
package zahlensuchen;
public class Zahlensuchen {
    public static void main(String[] args) {
       
        int[] liste = {11, 22, 9, 6, 35,0,2};
       int index = suchen (liste, 6);
       int zahl = liste[index];
        
        
        
    }
    
     static int suchen (int[] liste, int w){
        int anzahl = liste.length; // Anzahl der Werte im Array
        
        for(int i=0; i<=w+1; i++){
            System.out.println("Zahl "+i+" ist in der Liste die Zahl "+liste[i]);
     }
        
        return 0;
     }
    
    
}
