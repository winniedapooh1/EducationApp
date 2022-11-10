public class Student {
    private String userName;
    private String password;
    private String rightAnswers;
    private String wrongAnswers;
    private String name;

    /*
     * MUST change level to int
     * Nake sure you do that at one point
     */

    public Student(String sUserName, String sPassword, String sRightAnswers, String sWrongAndwers, String sName) {
        userName = sUserName;
        password = sPassword;
        rightAnswers = sRightAnswers;
        wrongAnswers = sWrongAndwers;
        name = sName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRightAnswers(String rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
    public void setWrongAnswers(String wrongAnswers){
        this.wrongAnswers = wrongAnswers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRightAnswers() {
        return rightAnswers;
    }
    public String getWrongAnswers(){
        return wrongAnswers;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        String mesage = "This is you record of right answers: " + getRightAnswers() + "\n"
                + "This is your record of wrong answers: " + getWrongAnswers();
        return mesage;
    }
}
