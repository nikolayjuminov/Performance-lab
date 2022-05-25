import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task3 {

    private static JSONObject fill(JSONObject obj, JSONObject val){
        JSONObject to_ret = (JSONObject) obj.clone();
        long id = (long) to_ret.get("id");
        JSONArray vls = (JSONArray) val.get("values");
        String value = "";
        for (Object v:vls){
            if ((long)(((JSONObject) v).get("id")) == id){
                value = (String)(((JSONObject) v).get("value"));
                to_ret.replace("value", value);
                break;
            }
        }
        if (to_ret.containsKey("values")){
            JSONArray new_values = new JSONArray();
            JSONArray old_values = (JSONArray) to_ret.get("values");
            for(Object v: old_values){
                new_values.add(fill((JSONObject) v, val));
            }
            to_ret.replace("values", new_values);
        }
        return to_ret;
    }

    public static void main(String[] args) throws IOException, ParseException {
        JSONObject tests = (JSONObject) new JSONParser().parse(new FileReader(args[0]));
        JSONObject values = (JSONObject) new JSONParser().parse(new FileReader(args[1]));
        JSONObject report = fill(tests, values);
        BufferedWriter bw = new BufferedWriter(new FileWriter("report.json"));
        bw.write(report.toJSONString());
        bw.flush();
        bw.close();
    }
}
