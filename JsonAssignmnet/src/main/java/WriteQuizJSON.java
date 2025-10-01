import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteQuizJSON
{
    public static void main(String[] args) throws IOException, ParseException {
        String FilePath = "./src/main/resources/quiz.json";

        //empty array read
        JSONParser jsonParserVar = new JSONParser(); //[]
        JSONArray JsonArrayVar = (JSONArray) jsonParserVar.parse(new FileReader(FilePath));

        // Sample Question 1
        JSONObject q1 = new JSONObject();
        q1.put("question", "Which is not part of system testing?");
        q1.put("option 1", "Regression Testing");
        q1.put("option 2", "Sanity Testing");
        q1.put("option 3", "Load Testing");
        q1.put("option 4", "Unit Testing");
        q1.put("answerkey", 4);

        // Question 2
        JSONObject q2 = new JSONObject();
        q2.put("question", "Which data structure works on the principle of FIFO?");
        q2.put("option 1", "Stack");
        q2.put("option 2", "Queue");
        q2.put("option 3", "Tree");
        q2.put("option 4", "Graph");
        q2.put("answerkey", 2);

        // Question 3
        JSONObject q3 = new JSONObject();
        q3.put("question", "Which keyword in Java is used to inherit a class?");
        q3.put("option 1", "this");
        q3.put("option 2", "extends");
        q3.put("option 3", "implements");
        q3.put("option 4", "super");
        q3.put("answerkey", 2);


        // Question 4
        JSONObject q4 = new JSONObject();
        q4.put("question", "Which protocol is used to send emails?");
        q4.put("option 1", "SMTP");
        q4.put("option 2", "HTTP");
        q4.put("option 3", "FTP");
        q4.put("option 4", "IMAP");
        q4.put("answerkey", 1);


        // Question 5
        JSONObject q5 = new JSONObject();
        q5.put("question", "Which of these is not an OOP principle?");
        q5.put("option 1", "Encapsulation");
        q5.put("option 2", "Polymorphism");
        q5.put("option 3", "Inheritance");
        q5.put("option 4", "Compilation");
        q5.put("answerkey", 4);

        // Question 6
        JSONObject q6 = new JSONObject();
        q6.put("question", "Which SQL command is used to remove a table?");
        q6.put("option 1", "DELETE");
        q6.put("option 2", "DROP");
        q6.put("option 3", "REMOVE");
        q6.put("option 4", "TRUNCATE");
        q6.put("answerkey", 2);

        // Question 7
        JSONObject q7 = new JSONObject();
        q7.put("question", "Which collection in Java does not allow duplicate elements?");
        q7.put("option 1", "List");
        q7.put("option 2", "Map");
        q7.put("option 3", "Set");
        q7.put("option 4", "Queue");
        q7.put("answerkey", 3);



        // Question 8
        JSONObject q8 = new JSONObject();
        q8.put("question", "Which layer of the OSI model is responsible for routing?");
        q8.put("option 1", "Data Link Layer");
        q8.put("option 2", "Network Layer");
        q8.put("option 3", "Transport Layer");
        q8.put("option 4", "Application Layer");
        q8.put("answerkey", 2);

        // Question 9
        JSONObject q9 = new JSONObject();
        q9.put("question", "Which operator is used for logical AND in Java?");
        q9.put("option 1", "&&");
        q9.put("option 2", "&");
        q9.put("option 3", "AND");
        q9.put("option 4", "||");
        q9.put("answerkey", 1);

        // Question 10
        JSONObject q10 = new JSONObject();
        q10.put("question", "Which memory is volatile?");
        q10.put("option 1", "ROM");
        q10.put("option 2", "Flash");
        q10.put("option 3", "RAM");
        q10.put("option 4", "Hard Disk");
        q10.put("answerkey", 3);


        JSONArray quizArray = new JSONArray();
        quizArray.add(q1);
        quizArray.add(q2);
        quizArray.add(q3);
        quizArray.add(q4);
        quizArray.add(q5);
        quizArray.add(q6);
        quizArray.add(q7);
        quizArray.add(q8);
        quizArray.add(q9);
        quizArray.add(q10);

        //Write korbo akhon
        FileWriter writer = new FileWriter(FilePath);
        writer.write(quizArray.toJSONString());
        writer.flush();
        writer.close();
        System.out.println("quiz.json updated successfully!");
    }
}
