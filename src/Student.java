public class Student {
    private String userName;
    private String password;
    private String level;
    private String name;
    /*
     * MUST change level to int
     * Nake sure you do that at one point
     */

    public Student(String sUserName, String sPassword, String sLevel, String sName) {
        userName = sUserName;
        password = sPassword;
        level = sLevel;
        name = sName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
