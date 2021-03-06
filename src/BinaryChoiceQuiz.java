public class BinaryChoiceQuiz implements Quiz {

    String question;
    String correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public BinaryChoiceQuiz(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void showQuestion() {

    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        if (answer.equals(correctAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}
