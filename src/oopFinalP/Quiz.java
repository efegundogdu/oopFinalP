package oopFinalP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions = new ArrayList<>();

    public void addQuestion(Question q) {
        questions.add(q);
    }

    // SEVIYE SORMA
    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Zorluk seviyesi sec:");
        System.out.println("1 - EASY");
        System.out.println("2 - MEDIUM");
        System.out.println("3 - HARD");

        int choice = Integer.parseInt(sc.nextLine());

        Difficulty selected;
        if (choice == 1) selected = Difficulty.EASY;
        else if (choice == 2) selected = Difficulty.MEDIUM;
        else selected = Difficulty.HARD;

        Student student = new Student("Default");
        start(student, selected);
        student.showResult();
    }

    // QUIZ MAIN
    public void start(Student student, Difficulty selectedDifficulty) {

        Scanner sc = new Scanner(System.in);
        long startTime = System.currentTimeMillis();

        Collections.shuffle(questions);

        int tfCount = 0;
        int mcCount = 0;

        for (Question q : questions) {

            if (q.getDifficulty() != selectedDifficulty) continue;

            if (q instanceof TrueFalseQuestion && tfCount >= 10) continue;
            if (q instanceof MultipleChoiceQuestion && mcCount >= 10) continue;

            System.out.println(q.getText());
            System.out.print("Cevap: ");
            String answer = sc.nextLine();

            if (q.checkAnswer(answer)) {
                student.addScore(q.getPoints());
            }

            if (q instanceof TrueFalseQuestion) tfCount++;
            if (q instanceof MultipleChoiceQuestion) mcCount++;

            if (tfCount == 10 && mcCount == 10) break;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Quiz suresi: " + (endTime - startTime) / 1000 + " saniye");
    }
}