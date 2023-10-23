import java.util.ArrayList;
import java.util.Scanner;

class QuizQuestion {
    private String question;
    private ArrayList<String> options;
    private int correctAnswer;

    public QuizQuestion(String question, ArrayList<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private ArrayList<QuizQuestion> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    public String conductQuiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());

            ArrayList<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ": " + options.get(j));
            }

            System.out.println();

            System.out.print("Enter your answer (1 or 2 or 3 or 4): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + currentQuestion.getCorrectAnswer());
            }
        }

        int totalQuestions = questions.size();
        int percentageScore = (score * 100) / totalQuestions;

        String performanceFeedback;
        if (percentageScore >= 0 && percentageScore <= 40) {
            performanceFeedback = "Your performance is poor";
        } else if (percentageScore >= 41 && percentageScore <= 75) {
            performanceFeedback = "Your performance is intermediate";
        } else {
            performanceFeedback = "Your performance is excellent";
        }

        return "Your score is: " + score + "/" + totalQuestions + " (" + percentageScore + "%). " + performanceFeedback;
    }
}

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding sample quiz questions
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Both are the same");
        options1.add("== compares object references while .equals() compares object values");
        options1.add(".equals() compares object references while == compares object values");
        options1.add(" Both compare object values");
        QuizQuestion question1 = new QuizQuestion(" What is the difference between == and .equals() in Java?", options1, 2);
        quiz.addQuestion(question1);

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("45");
        options2.add("13");
        options2.add("25");
        options2.add("14");
        QuizQuestion question2 = new QuizQuestion("What will be the output of the following code" +
                "" +
                "public class Test {\n" +
                "    public static void main(String[] args) {\n" +
                "        int x = 5;\n" +
                "        System.out.println(x++ + ++x);\n" +
                "    }\n" +
                "}", options2, 2);
        quiz.addQuestion(question2);

        ArrayList<String> options3 = new ArrayList<>();
        options3.add("true");
        options3.add("false");
        options3.add("compilation error");
        options3.add("none of these");
        QuizQuestion question3 = new QuizQuestion("What will be the output of the following code?" +
                "" +
                "public class Test {\n" +
                "    public static void main(String[] args) {\n" +
                "        String s1 = \"Hello\";\n" +
                "        String s2 = \"Hello\";\n" +
                "        System.out.println(s1 == s2);\n" +
                "    }\n" +
                "}\n",options3,1);
        quiz.addQuestion(question3);

        ArrayList<String> options4 = new ArrayList<>();
        options4.add("ArrayList is faster for insertion and deletion, while LinkedList is faster for random");
        options4.add("ArrayList is faster for random access, while LinkedList is faster for insertion and deletion");
        options4.add(" Both have similar performance characteristics");
        options4.add("ArrayList is a synchronized collection, while LinkedList is not");
        QuizQuestion question4 = new QuizQuestion("What is the difference between ArrayList and LinkedList in Java?",options4,2);
        quiz.addQuestion(question4);

        ArrayList<String> options5 = new ArrayList<>();
        options5.add("Both are used to handle exceptions");
        options5.add("throw is used to declare an exception, while throws is used to throw an exception explicitly");
        options5.add(" throw is used to throw an exception explicitly, while throws is used to declare an exception");
        options5.add("Both are used interchangeably to throw exceptions");
        QuizQuestion question5 = new QuizQuestion("What is the difference between throw and throws in Java?",options5,3);
        quiz.addQuestion(question5);



        // Conduct the quiz and generate the report
        String report = quiz.conductQuiz();

        // Print the report
        System.out.println("Quiz Report:\n");
        System.out.println(report);
    }
}
