import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonExternalLib {

    public static void main(String[] args) throws IOException, ParseException {
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        obj.put("nickName", "fooli");
        obj.put("race", "wizard");
        obj.put("agility", 21);
        obj.put("strength", 213);
        obj.put("intelligence", 21319);

        System.out.println(obj);

        JSONObject myobj = (JSONObject) new JSONParser().parse(new FileReader("./assets/newJson.json"));

        System.out.println(myobj.get("race"));


    }
}
