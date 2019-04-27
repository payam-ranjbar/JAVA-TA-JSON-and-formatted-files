package JSONUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Validator {
    public static void validateFile(File file, boolean create) throws IOException {
        if (!file.exists()) {
            if (!create) {
                throw new FileNotFoundException();
            } else {
                file.createNewFile();
            }
        }
    }

    public static boolean validateCharacters(char toCheckChar) {
        switch (toCheckChar) {
            case '\n':
                return false;
            case '\r':
                return false;
            case ' ':
                return false;
            case '}':
                return false;
            case '{':
                return false;
        }

        return true;
    }
}
