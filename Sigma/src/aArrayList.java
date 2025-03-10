import java.util.HashMap;

// Main class demonstrating the usage of AdvancedHashMapExample
public class hHashMap {
    public static void main(String[] args) {
        AdvancedHashMapExample mapExample = new AdvancedHashMapExample();
        
        // Adding entries to the HashMap
        mapExample.add("First", 1);
        mapExample.add("Second", 2);
        mapExample.add("Third", 3);
        
        // Printing contents and size of the HashMap
        mapExample.printContents();
        mapExample.printSize();
        
        // Removing an entry from the HashMap
        mapExample.remove("Second");
        
        // Printing contents and size of the HashMap after removal
        mapExample.printContents();
        mapExample.printSize();
        
        // Clearing the HashMap
        mapExample.clear();
        
        // Printing contents and size of the HashMap after clearing
        mapExample.printContents();
        mapExample.printSize();
    }
}

// Class encapsulating a HashMap with basic operations
class HashMapExample {
    protected HashMap<String, Integer> map = new HashMap<>();

    // Method to add a key-value pair to the HashMap
    public void add(String key, Integer value) {
        map.put(key, value);
    }

    // Method to get the value associated with a key
    public Integer get(String key) {
        return map.get(key);
    }

    // Method to check if the HashMap contains a key
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    // Method to remove a key-value pair from the HashMap
    public void remove(String key) {
        map.remove(key);
    }

    // Method to get the size of the HashMap
    public int size() {
        return map.size();
    }

    // Method to clear all entries in the HashMap
    public void clear() {
        map.clear();
    }

    // Method to print the contents of the HashMap
    public void printContents() {
        System.out.println("Map contents: " + map);
    }
}

// Class extending HashMapExample with additional functionality
class AdvancedHashMapExample extends HashMapExample {
    // Overriding the add method to include a print statement
    @Override
    public void add(String key, Integer value) {
        super.add(key, value);
        System.out.println("Added: " + key + " -> " + value);
    }

    // Method to print the size of the HashMap
    public void printSize() {
        System.out.println("Map size: " + size());
    }
}
