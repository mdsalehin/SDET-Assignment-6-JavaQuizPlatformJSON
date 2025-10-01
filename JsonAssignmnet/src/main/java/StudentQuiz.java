/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentQuiz
{
    public static void main(String[] args) throws IOException, ParseException
    {
        String FilePath = "./src/main/resources/quiz.json";

        //Read the Question From quiz.json
        JSONParser parser = new JSONParser();
        JSONArray quizArray = (JSONArray) parser.parse(new FileReader(FilePath));

        Scanner input  = new Scanner(System.in);
        int score = 0;
        int totalQuestion = Math.min(10, quizArray.size()); // Limit to 10 questions

        System.out.println("Welcome to the quiz! There are " + totalQuestion + " questions. Each question carries 1 mark. No negative marking.");

        System.out.println("Press 's' to start:");
        String start = input.nextLine();

        //if this is press without s or any latter it will be cencelled out
        if(!start.equalsIgnoreCase("s"))
        {
            System.out.println("Quiz cancelled.");
            return;
        }

        // Loop through questions
        for (int i = 0; i<totalQuestion; i++)
        {
            JSONObject questionObj = (JSONObject) quizArray.get(i);

            System.out.println("\nQuestion " + (i + 1) + ": " + questionObj.get("question"));

            System.out.println("1. " + questionObj.get("option 1"));
            System.out.println("2. " + questionObj.get("option 2"));
            System.out.println("3. " + questionObj.get("option 3"));
            System.out.println("4. " + questionObj.get("option 4"));

            System.out.print("Your answer (1-4): ");
            int answer = Integer.parseInt(input.nextLine());

            int correctAnswer = ((Long) questionObj.get("answerkey")).intValue(); // JSON stores numbers as Long

            if(answer == correctAnswer)
            {
                score++;
            }
        }
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + " out of " + totalQuestion);


        //  Scoring Result Implemented Now
        if(score >= 8 && score <= 10)
        {
            System.out.println("Excellent! You have got " + score + " out of " + totalQuestion);
        }
        else if(score >= 5 && score <= 7)
        {
            System.out.println("Good. You have got " + score + " out of " + totalQuestion);
        }
        else if(score >= 3 && score <= 4)
        {
            System.out.println("Very poor! You have got " + score + " out of " + totalQuestion);
        }
        else if(score >= 0 && score <= 2)
        {
            System.out.println("Very sorry you are failed. You have got " + score + " out of " + totalQuestion);
        }
        input.close();
    }
}
*/

//same but few changes here..Here i only add random the question part 2-3 line change and rest of the part is same.........

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentQuiz
{
    public static void main(String[] args) throws IOException, ParseException
    {
        String FilePath = "./src/main/resources/quiz.json";

        // Read the Question From quiz.json
        JSONParser parser = new JSONParser();
        JSONArray quizArray = (JSONArray) parser.parse(new FileReader(FilePath));

        // ---------- Randomization Part ----------
        // Convert JSONArray to List<JSONObject> to shuffle
        List<JSONObject> quizList = new ArrayList<>();
        for (Object obj : quizArray) {
            quizList.add((JSONObject) obj);
        }
        Collections.shuffle(quizList); // Shuffle the order
        int totalQuestion = Math.min(10, quizList.size()); // Limit to 10 questions
        // ---------------------------------------

        Scanner input  = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the quiz! There are " + totalQuestion + " questions. Each question carries 1 mark. No negative marking.");
        System.out.println("Press 's' to start:");
        String start = input.nextLine();

        if(!start.equalsIgnoreCase("s")) {
            System.out.println("Quiz cancelled.");
            return;
        }

        // Loop through randomized questions
        for (int i = 0; i < totalQuestion; i++)
        {
            JSONObject questionObj = quizList.get(i);

            System.out.println("\nQuestion " + (i + 1) + ": " + questionObj.get("question"));
            System.out.println("1. " + questionObj.get("option 1"));
            System.out.println("2. " + questionObj.get("option 2"));
            System.out.println("3. " + questionObj.get("option 3"));
            System.out.println("4. " + questionObj.get("option 4"));

            System.out.print("Your answer (1-4): ");
            int answer = Integer.parseInt(input.nextLine());

            int correctAnswer = ((Long) questionObj.get("answerkey")).intValue();

            if(answer == correctAnswer) {
                score++;
            }
        }

        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + " out of " + totalQuestion);

        // ---------- Scoring Result ----------
        if(score >= 8) {
            System.out.println("Excellent! You have got " + score + " out of " + totalQuestion);
        } else if(score >= 5) {
            System.out.println("Good. You have got " + score + " out of " + totalQuestion);
        } else if(score >= 3) {
            System.out.println("Very poor! You have got " + score + " out of " + totalQuestion);
        } else {
            System.out.println("Very sorry you are failed. You have got " + score + " out of " + totalQuestion);
        }
        input.close();
    }
}



















