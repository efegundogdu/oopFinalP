package oopFinalP;

import java.util.Scanner;

public class mainC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();

        // Giris
        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        if (!userManager.login(u, p)) {
            System.out.println("Giris basarisiz!");
            sc.close();
            return;
        }

        System.out.println("Giris basarili!");

        // QUIZ
        Quiz quiz = new Quiz();

        // KOLAY SORULAR
        quiz.addQuestion(new MultipleChoiceQuestion(
                "What does RAM stand for?\nA) Random Access Memory\nB) Read Access Memory\nC) Run All Memory\nD) Rapid Access Module",
                10, "A", Difficulty.EASY));

        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which symbol is used for logical AND?\nA) ||\nB) &&\nC) !\nD) ==",
                10, "B", Difficulty.EASY));

        quiz.addQuestion(new TrueFalseQuestion(
                "A stack follows the LIFO principle.",
                10, true, Difficulty.EASY));

        // ORTA SORULAR
        quiz.addQuestion(new MultipleChoiceQuestion(
                "What is the time complexity of binary search?\nA) O(n)\nB) O(log n)\nC) O(n²)\nD) O(1)",
                20, "B", Difficulty.MEDIUM));

        quiz.addQuestion(new TrueFalseQuestion(
                "Big-O notation describes the efficiency of an algorithm.",
                20, true, Difficulty.MEDIUM));

        // ZOR SORULAR
        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which data structure is best for implementing recursion?\nA) Queue\nB) Heap\nC) Stack\nD) Linked List",
                30, "C", Difficulty.HARD));

        quiz.addQuestion(new TrueFalseQuestion(
                "A compiler translates the entire program before execution.",
                30, true, Difficulty.HARD));

        quiz.start();

        sc.close();
    }
}