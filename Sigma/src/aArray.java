public class aArray {

    // Example of defining an array
    private int[] numbers;

    // Constructor to initialize the array
    public aArray(int size) {
        numbers = new int[size];
    }

    // Method to set a value in the array
    public void setValue(int index, int value) {
        if (index >= 0 && index < numbers.length) {
            numbers[index] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Method to get a value from the array
    public int getValue(int index) {
        if (index >= 0 && index < numbers.length) {
            return numbers[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Method to get the length of the array
    public int getLength() {
        return numbers.length;
    }

    // Static method to demonstrate array usage
    public static void main(String[] args) {
        aArray array = new aArray(5);
        array.setValue(0, 10);
        array.setValue(1, 20);
        array.setValue(2, 30);
        array.setValue(3, 40);
        array.setValue(4, 50);

        for (int i = 0; i < array.getLength(); i++) {
            System.out.println("Value at index " + i + ": " + array.getValue(i));
        }
    }
}
