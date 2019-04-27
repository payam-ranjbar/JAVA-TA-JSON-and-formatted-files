package Heros;

import JSONUtils.JsonFormatter;
import JSONUtils.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class SaveAndLoadService {
    public static void saveAsFile(Hero hero, String filename) {
        String path = "./assets/" + filename + ".json";

        JsonFormatter formatter = new JsonFormatter(path, hero.generateStatusMap());

        try {

            formatter.format();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveAsFile(Hero hero) {
        saveAsFile(hero, hero.getName());
    }

    public static Hero load(String filePath) throws IOException{

        Hashtable<String, String> loadedData = generateDataMap(filePath);

            String name = loadedData.get("name");
            String nickName = loadedData.get("nickName");
            String race = loadedData.get("race");
            int agility = Integer.parseInt(loadedData.get("agility"));
            int strength = Integer.parseInt(loadedData.get("strength"));
            int intelligence = Integer.parseInt(loadedData.get("intelligence"));

        return new Hero(name, nickName,race, agility, strength, intelligence);


    }

    private static Hashtable<String, String> generateDataMap(String path) throws IOException {
        JsonParser parser = new JsonParser(path);

        return parser.parse();
    }

}
