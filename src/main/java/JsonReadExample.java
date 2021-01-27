import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

public class JsonReadExample {

    public void readJsonFile() throws IOException {
        //parsing file "JSONExample.json"
        String json = new String(Files.readAllBytes(Paths.get("/home/sohail/Documents/JSONExample.json")));


        JSONObject jsonObject = new JSONObject(json);

        //getting firstName and lastName
        String firstName = (String) jsonObject.get("firstName");
        String lastName = (String) jsonObject.get("lastName");
        System.out.println("The first name is " + firstName);
        System.out.println("The lastName is " + lastName);

        //getting age
        int age = (int) jsonObject.get("age");
        System.out.println("The age is " + age);

        //getting address
        final JSONObject jsonObject1 = jsonObject.getJSONObject("address");
        final Map<String, Object> objectMap = jsonObject1.toMap();

        //iterating through address map
        Iterator itr1 = objectMap.entrySet().iterator();
        while(itr1.hasNext()) {
            Map.Entry pair = (Map.Entry) itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        /*Since phoneNumbers is an array of objects,
        first get inside the array and then go into each objects.
         */

        JSONArray jsonArray = (JSONArray) jsonObject.get("phoneNumbers");
        System.out.println("");
        System.out.println("Contact details: ");
        System.out.println("");


        //iterating phoneNumbers.

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonFinal = jsonArray.getJSONObject(i);
            Iterator<String> iterator = jsonFinal.keys();
            while(iterator.hasNext()){
                String key = iterator.next();
                System.out.println(key + " : " + jsonFinal.get(key));
            }

        }
    }

}
