package oopFinalP;

public abstract class Question implements Gradable {

    protected String text;
    protected int points;
    protected Difficulty difficulty;

    public Question(String text, int points, Difficulty difficulty) {
        this.text = text;
        this.points = points;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public abstract boolean checkAnswer(String answer);
}