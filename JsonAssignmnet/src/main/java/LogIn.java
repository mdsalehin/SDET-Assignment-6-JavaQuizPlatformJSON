import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LogIn
{
    public static void main(String[] args) throws IOException, ParseException
    {
        String FilePath = "./src/main/resources/users.json";

        //Read User Json
        JSONParser jsonParserVar = new JSONParser();
        JSONArray jsonArrayVar = (JSONArray) jsonParserVar.parse(new FileReader(FilePath));

        // Taking Input
        Scanner varInput = new Scanner(System.in);
        System.out.println("Enter your username");
        String inputUser = varInput.nextLine();


        System.out.println("Enter password");
        String inputPass = varInput.nextLine();

        boolean loginSuccess = false;

        for(Object obj: jsonArrayVar)
        {
            JSONObject user  = (JSONObject) obj;

            String username  =   (String) user.get("username");
            String password   =  (String) user.get("password");
            String role  = (String) user.get("role");


            if(inputUser.equals(username) && inputPass.equals(password))
            {
                loginSuccess = true;

                if(role.equals("admin"))
                {
                    System.out.println("Welcome admin! Please create new questions in the question bank.");
                    AdminQuizManager.main(null); // Add this line
                }
                else if (role.equals("student"))
                {
                    System.out.println("Welcome " + username + " to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
                    StudentQuiz.main(null); // Add this line
                }
                break;
            }



        }

        if (!loginSuccess)
        {
            System.out.println("System:> Invalid username or password.");
        }

    }
}
