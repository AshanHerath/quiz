public class UserScore {
    private String userName;
    private int userScore = 0;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void addMark(int mark) {
        this.userScore += mark;
    }
}
