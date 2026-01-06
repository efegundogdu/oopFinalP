package oopFinalP;

import java.util.ArrayList;
import java.util.Scanner;

//interface
interface Gradable {
    int checkAnswer(String answer);
}

//abstract class
abstract class Question implements Gradable {

    protected String text;
    protected int points;

    public Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public void showQuestion() {
        System.out.println(text);
    }
}

//multiple class
class MultipleChoiceQuestion extends Question {

    private String correctAnswer;

    public MultipleChoiceQuestion(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

//true false
class TrueFalseQuestion extends Question {

    private boolean correct;

    public TrueFalseQuestion(String text, int points, boolean correct) {
        super(text, points);
        this.correct = correct;
    }

    @Override
    public int checkAnswer(String answer) {
        boolean userAnswer = Boolean.parseBoolean(answer);
        return userAnswer == correct ? points : 0;
    }
}

//students
class Student {

    private String name;
    private int score;

    public Student(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore(int points) {
        score += points;
    }

    public void showResult() {
        System.out.println(name + " total score: " + score);
    }
}

//quiz
class Quiz {

    private ArrayList<Question> questions = new ArrayList<>();

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void start(Student student) {
        Scanner sc = new Scanner(System.in);

        for (Question q : questions) {
            q.showQuestion();
            System.out.print("Answer: ");
            String answer = sc.nextLine();

            int gained = q.checkAnswer(answer); // polymorphism
            student.addScore(gained);
        }
    }
}

//main
public class mainC {

    public static void main(String[] args) {

        Student student = new Student("Mefe");

        Quiz quiz = new Quiz();

        quiz.addQuestion(
            new MultipleChoiceQuestion(
                "Creatine sac doker mi? (A) Evet (B) Hayir",
                10,
                "A"
            )
        );

        quiz.addQuestion(
            new TrueFalseQuestion(
                "Lol eglenceli oyundur. (true / false)",
                10,
                false
            )
        );

        quiz.start(student);

        student.showResult();
    }
}