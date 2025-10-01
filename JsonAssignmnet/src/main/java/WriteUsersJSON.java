import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteUsersJSON
{
    public static void main(String[] args) throws IOException, ParseException
    {
        String FilePath = "./src/main/resources/quiz.json";

        //empty array read
        JSONParser jsonParserVar = new JSONParser(); //[]
        JSONArray JsonArrayVar = (JSONArray) jsonParserVar.parse(new FileReader(FilePath));

        //JSONArray JsonArrayVar = new JSONArray();

        // For Admin user
        JSONObject admin  = new JSONObject();
        admin.put("username","admin");
        admin.put("password","1234");
        admin.put("role","admin");


        // For Student user
        JSONObject student  = new JSONObject();
        student.put("username", "salman");
        student.put("password", "1234");
        student.put("role", "student");

        // Add to array
        JsonArrayVar.add(admin);
        JsonArrayVar.add(student);


        //Write korbo akhon
        FileWriter Writer = new FileWriter(FilePath);
        Writer.write(JsonArrayVar.toJSONString());
        Writer.flush();
        Writer.close();

    }
}
