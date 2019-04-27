package JSONUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class JsonParser {
    private String key;
    private String value;
    private Hashtable<String, String> map;
    private File toParseFile;

    public JsonParser(String pathOfToParseFile)  {
        key = "";
        value = "";

        map = new Hashtable<>();
        toParseFile = new File(pathOfToParseFile);


        try {
            Validator.validateFile(toParseFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void resetKeyandValue(){
        key = "";
        value = "";
    }


    public Hashtable<String, String> parse() throws IOException {
        FileReader reader = new FileReader(toParseFile);

        int pointer = reader.read();
        boolean keyFinding = true;
        while (pointer != -1) {
            char character = (char)pointer;

            switch (character) {
                case ':':
                    keyFinding = false;

                    pointer = reader.read();
                    character = (char)pointer;
                    break;

                case ',':
                    keyFinding = true;
                    pointer = reader.read();
                    character = (char)pointer;
                    map.put(key, value);
                    resetKeyandValue();
                    break;
            }


            if (keyFinding) {

                if (Validator.validateCharacters(character)) {
                    if (character != '\n')
                    key += character;
                }
            } else {
                if (Validator.validateCharacters(character)) {
                    if (character != '\n')
                        value += character;
                }
            }

            pointer = reader.read();


        }
        return map;
    }
}
