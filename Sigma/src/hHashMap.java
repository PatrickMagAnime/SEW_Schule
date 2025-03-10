import java.util.HashMap;
import java.util.Map;

public class hHashMap {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Add values to the HashMap
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Access a value in the HashMap
        int value = map.get("Apple");
        System.out.println("Value for 'Apple': " + value);

        // Check if a key exists in the HashMap
        if (map.containsKey("Banana")) {
            System.out.println("The HashMap contains the key 'Banana'.");
        }

        // Remove a value from the HashMap
        map.remove("Orange");

        // Iterate over the HashMap and compare values with a string
        String comparisonString = "2";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().toString().equals(comparisonString)) {
                System.out.println("The key for the value " + comparisonString + " is: " + entry.getKey());
            }
        }

        // Print the entire HashMap
        System.out.println("Contents of the HashMap: " + map);

        // Check if a value exists in the HashMap
        if (map.containsValue(1)) {
            System.out.println("The HashMap contains the value 1.");
        }

        // Get the size of the HashMap
        int size = map.size();
        System.out.println("Size of the HashMap: " + size);

        // Clear all entries in the HashMap
        map.clear();
        System.out.println("Contents of the HashMap after clearing: " + map);
    }
}

// HashMap in relation to methods and classes
class HashMapExample {
    private HashMap<String, Integer> map;

    // Constructor
    public HashMapExample() {
        map = new HashMap<>();
    }

    // Method to add a key-value pair
    public void add(String key, Integer value) {
        map.put(key, value);
    }

    // Method to get a value by key
    public Integer get(String key) {
        return map.get(key);
    }

    // Method to check if a key exists
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    // Method to remove a key-value pair
    public void remove(String key) {
        map.remove(key);
    }

    // Method to get the size of the HashMap
    public int size() {
        return map.size();
    }

    // Method to clear the HashMap
    public void clear() {
        map.clear();
    }

    // Method to print the contents of the HashMap
    public void printContents() {
        System.out.println("Contents of the HashMap: " + map);
    }
}

// Demonstrating inheritance and polymorphism
class AdvancedHashMapExample extends HashMapExample {
    // Overriding the add method to include a print statement
    @Override
    public void add(String key, Integer value) {
        super.add(key, value);
        System.out.println("Added key: " + key + ", value: " + value);
    }

    // New method specific to this class
    public void printSize() {
        System.out.println("Size of the HashMap: " + size());
    }
}

class Main {
    public static void main(String[] args) {
        AdvancedHashMapExample advancedMap = new AdvancedHashMapExample();
        advancedMap.add("Grapes", 4);
        advancedMap.printContents();
        advancedMap.printSize();
    }
}
