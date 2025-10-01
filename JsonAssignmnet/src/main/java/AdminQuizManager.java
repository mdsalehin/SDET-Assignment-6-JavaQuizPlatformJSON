import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminQuizManager
{
    public static void main(String[] args) throws IOException, ParseException {
        String FilePath = "./src/main/resources/quiz.json";

        Scanner input  = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add New Question");
            System.out.println("2. View All Questions");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(input.nextLine());

            if(choice == 1)
            {
                // Add new question
                System.out.print("Enter question text: ");
                String question = input.nextLine();

                System.out.print("Enter option 1: ");
                String option1 = input.nextLine();
                System.out.print("Enter option 2: ");
                String option2 = input.nextLine();
                System.out.print("Enter option 3: ");
                String option3 = input.nextLine();
                System.out.print("Enter option 4: ");
                String option4 = input.nextLine();

                System.out.print("Enter correct answer key (1-4): ");
                int answerkey = Integer.parseInt(input.nextLine());

                JSONObject newQ = new JSONObject();
                newQ.put("question", question);
                newQ.put("option 1", option1);
                newQ.put("option 2", option2);
                newQ.put("option 3", option3);
                newQ.put("option 4", option4);
                newQ.put("answerkey", answerkey);


                // Read existing quiz.json
                JSONParser parser = new JSONParser();
                JSONArray quizArray = (JSONArray) parser.parse(new FileReader(FilePath));

                // Add new question
                quizArray.add(newQ);

                // Write back to file
                FileWriter writer = new FileWriter(FilePath);
                writer.write(quizArray.toJSONString());
                writer.flush();
                writer.close();
                System.out.println("Question added successfully!");

            }
            else if (choice == 2)
            {
                //View the question
                JSONParser parser = new JSONParser();
                JSONArray quizArray = (JSONArray) parser.parse(new FileReader(FilePath));
                for( int i = 0; i<quizArray.size(); i++)
                {
                    JSONObject jsonObjectVar  = (JSONObject) quizArray.get(i);

                    System.out.println("\nQuestion " + (i + 1) + ": " + jsonObjectVar.get("question"));
                    System.out.println("1. " + jsonObjectVar.get("option 1"));
                    System.out.println("2. " + jsonObjectVar.get("option 2"));
                    System.out.println("3. " + jsonObjectVar.get("option 3"));
                    System.out.println("4. " + jsonObjectVar.get("option 4"));
                    System.out.println("Answer Key: " + jsonObjectVar.get("answerkey"));

                }
            }
            else if (choice == 3)
            {
                System.out.println("Exiting Admin Menu...");
                break;
            }
            else
            {
                System.out.println("Invalid choice! Try again.");
            }
        }
        input.close();
    }
}
