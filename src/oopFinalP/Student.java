package oopFinalP;

public class Student {

    private String name;
    private int score = 0;

    public Student(String name) {
        this.name = name;
    }

    public void addScore(int points) {
        score += points;
    }

    public void showResult() {
        System.out.println(name + " toplam puan: " + score);
    }
}