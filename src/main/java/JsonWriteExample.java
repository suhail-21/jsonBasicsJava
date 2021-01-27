
/* Java code
   to create a simple json file
   and write it to local directory.
   The json file will look like this :

{
    "firstName": "Sherlock",
    "lastName": "Holmes",
    "age": 23,
    "address": {
        "streetAddress": "21 Baker Street",
        "city": "London",
        "state": "LY",
        "postalCode": 10021
    },
    "phoneNumbers": [
        {
            "type": "home",
            "number": "212 555-1234"
        },
        {
            "type": "fax",
            "number": "646 555-4567"
        }
    ]
}


 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonWriteExample {

    public void writeJsonFile() {
        JSONObject jsonObject = new JSONObject();

        //Putting data into this jsonObject.

        jsonObject.put("firstName", "Sherlock");
        jsonObject.put("lastName", "Holmes");
        jsonObject.put("age", 23);

        //For putting addressing data, we need to create linkedHashMap first

        Map map = new LinkedHashMap(4);
        map.put("streetAddress", "21st baker Street");
        map.put("City", "London");
        map.put("State", "LY");
        map.put("postalCode", 10021);

        //putting this address into jsonObject.

        jsonObject.put("address", map);

        //For phoneNumbers, we first need a JSONArray.

        JSONArray jsonArray = new JSONArray();

        Map map1 = new LinkedHashMap(2);
        map1.put("number", "212 555-1234");
        map1.put("type", "home");


        Map map2 = new LinkedHashMap(2);
        map2.put("number", "646 555-4567");
        map2.put("type", "fax");
        //adding this map to JSONArray


        jsonArray.put(map1);
        jsonArray.put(map2);

        //Putting phoneNumbers into JSONObject

        jsonObject.put("phoneNumbers", jsonArray);

        //writing JSON to file: "JSONExample.json" in "/home/sohail/Documents/".
        try{

            Writer output = null;
            File file = new File("/home/sohail/Documents/JSONExample.json");
            output = new BufferedWriter(new FileWriter(file));
            output.write(jsonObject.toString());
            output.close();
            System.out.println("The file is written successfully!");
            System.out.println("--------------------------------");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
