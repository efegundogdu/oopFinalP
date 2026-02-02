package oopFinalP;

public class TrueFalseQuestion extends Question {

    private boolean correctAnswer;

    public TrueFalseQuestion(String text, int points, boolean correctAnswer, Difficulty difficulty) {
        super(text, points, difficulty);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {

        answer = answer.trim().toLowerCase();

        boolean userAnswer;

        if (answer.equals("true") || answer.equals("t")) {
            userAnswer = true;
        } else if (answer.equals("false") || answer.equals("f")) {
            userAnswer = false;
        } else {
            return false; // gecersiz giris
        }

        return userAnswer == correctAnswer;
    }
}