package oopFinalP;

public class MultipleChoiceQuestion extends Question {

    private String correctAnswer;

    public MultipleChoiceQuestion(
            String text,
            int points,
            String correctAnswer,
            Difficulty difficulty
    ) {
        super(text, points, difficulty);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}