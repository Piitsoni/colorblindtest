public class colorBlind {
    int question = 0;
    int correctAnswers = 0;
    int currentQuestion = 0;

    public void nextQuestion() {
        currentQuestion = currentQuestion + 1;
    }

    public void addCorrectAnswers(int num) {
        correctAnswers = correctAnswers + num;
    }

}
