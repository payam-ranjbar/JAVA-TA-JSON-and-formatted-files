import Heros.Hero;
import Heros.SaveAndLoadService;
import JSONUtils.JsonFormatter;
import JSONUtils.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonParser parser = new JsonParser("./assets/file.json");

        Hashtable<String, String> data = parser.parse();

        for(String key: data.keySet()) {
            System.out.println("key:  " + key);
            System.out.println("value:  " +data.get(key));
        }


        JsonFormatter formatter = new JsonFormatter("./assets/newfile.json", data);
        formatter.format();


        Hero hero1 = new Hero("dragtor", "dady", "orc",
                10, 1000, 1);
        Hero hero2 = new Hero("man-jiq", "lobster", "human",
                108, 345, 30);
        Hero hero3 = new Hero("laktop", "ordake-taktak", "bird",
                10, 10, 1);
        Hero hero4 = new Hero("soori", "lakposth", "human",
                900, 490, 22);

        System.out.println(hero1);

        SaveAndLoadService.saveAsFile(hero1);
        SaveAndLoadService.saveAsFile(hero2);
        SaveAndLoadService.saveAsFile(hero3, "ejdeha");
        SaveAndLoadService.saveAsFile(hero4);
//
        Hero newHero = SaveAndLoadService.load("./assets/ejdeha.json");

        System.out.println(newHero);
    }
}
