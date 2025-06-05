import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ToDoJsonManager {
    private static final String FILE_PATH = "todos.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveToDos(ArrayList<ToDoItem> todos) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(todos, writer);
        }
    }

    public static ArrayList<ToDoItem> loadToDos() throws IOException {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<ToDoItem>>(){}.getType();
            ArrayList<ToDoItem> todos = gson.fromJson(reader, listType);
            if (todos == null) return new ArrayList<>();
            return todos;
        }
    }
}