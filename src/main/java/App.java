import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        JsonWriteExample jsonWriteExample = new JsonWriteExample();
        JsonReadExample jsonReadExample = new JsonReadExample();
        jsonWriteExample.writeJsonFile();
        jsonReadExample.readJsonFile();
    }
}
