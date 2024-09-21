import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizPlatform {
    private List<Question> questions;
    private int score;

    public QuizPlatform() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"}, 1));
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"A. Atlantic", "B. Indian", "C. Arctic", "D. Pacific"}, 3));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz!");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Your answer (A/B/C/D): ");
            String answer = scanner.nextLine().trim().toUpperCase();

            if (answer.equals(String.valueOf((char) ('A' + q.correctAnswerIndex)))) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer was " + q.options[q.correctAnswerIndex]);
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static void main(String[] args) {
        QuizPlatform quiz = new QuizPlatform();
        quiz.startQuiz();
    }
}

