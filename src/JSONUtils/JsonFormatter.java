package JSONUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class JsonFormatter {
    private Hashtable<String, String> map;
    private File formtInFile;

    public JsonFormatter(String filePath, Hashtable<String, String> inputMap) {
        map = inputMap;
        formtInFile = new File(filePath);


        try {

            Validator.validateFile(formtInFile, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String LineBuilder(String key, String value) {
        String line = "";
        line += key;
        line += " : ";
        line += value;
        line += ",";
        return line;
    }
    public void format() throws IOException {

        FileWriter writer = new FileWriter(formtInFile);

        writer.write("{\n");

        for(String key : map.keySet()) {
            String toWriteLine = LineBuilder(key, map.get(key));
            writer.write(toWriteLine + "\n");
        }
        writer.write('}');

        writer.close();

    }
}
