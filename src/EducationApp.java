import java.util.*;
import java.io.*;

public class EducationApp extends Student {
    public EducationApp() {
        super("null", "null", "null", "null");
    }

    public static void main(String[] args) {
        ArrayList<String> addQuestions = new ArrayList<>();
        ArrayList<String> addAnswer = new ArrayList<>();
        ArrayList<String> subQuestions = new ArrayList<>();
        ArrayList<String> subAnswer = new ArrayList<>();
        ArrayList<String> multQuestions = new ArrayList<>();
        ArrayList<String> multAnswer = new ArrayList<>();
        ArrayList<String> divQuestions = new ArrayList<>();
        ArrayList<String> divAnswers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        Scanner uI = new Scanner(System.in);
        String level = "0";
        String fileNameStudents = "src\\Students.txt";
        String fileNameAdd = "src\\Add.txt";
        String fileNameDiv = "src\\Division.txt";
        String fileNameMult = "src\\Multiplication.txt";
        String fileNameSub = "src\\subtraction.txt";
        String username = "";
        String password = "";
        String name = "";
        String yesNo = "";
        int index = 0;
        MyTimer mT = new MyTimer();
        mT.set(10000);
        test test = new test();
        /*
         ? You need to make a class that hold all of the methods that you use to make readablity better
         *
         *
         *
         *
         ! You still have to make a loop that loops through to see if they hava an account
         ! make sure to make a check to see if the user exist in the student array list
         */
        test.insertStudent(students, fileNameStudents);
        System.out.println(students.get(0).getName());
        System.out.println("Are you a new user?(yes or no)");
        yesNo = uI.nextLine();
        while (yesNo.equals("yes")) {
            /*
             ! make a method that checks is the username or password is already taken
             */

            System.out.println("Please enter your new user name: ");
            username = uI.nextLine();
            System.out.println("Please enteryour new password: ");
            password = uI.nextLine();
            System.out.println("Please enter your name: ");
            name = uI.nextLine();
            Student obj = new Student(username, password, level, name);
            students.add(obj);
            try {
                /*
                 * This takes care of the problem of the Arraylist refreshing
                 */
                FileWriter myWriter = new FileWriter(fileNameStudents, true);
                BufferedWriter bW = new BufferedWriter(myWriter);
                while (index < students.size()) {
                    String studentLine = username + ";" + password + ";" + level + ";" + name;
                    /*
                     * "Line.separator" makes the writer print to next line .
                     */
                    myWriter.write(studentLine + System.getProperty("line.separator"));
                    index++;
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                /*
                 * printStackTrace pinpoints the error in the code
                 */
                e.printStackTrace();
            }
        }
        // System.out.println(students.get(0).getName());
        if (yesNo.equals("no")) {
            /*
             * This if statment will loop through untill the user gives a vaild username and password
             */
            boolean pass = false;
            while (!pass) {
                System.out.println("please enter your username: ");
                username = uI.nextLine();
                System.out.println("Please enter your passowrd: ");
                password = uI.nextLine();
                for (int i = 0; i < students.size(); i++) {
                    /*
                     * This is the if statement that checks the valid username and password
                     */
                    if (students.get(i).getUserName().equals(username) && students.get(i).getPassword().equals(password)) {
                        System.out.println("Welcome back " + students.get(i).getName());
                        pass = true;
                    } else {
                        System.out.println("Your username is password was wrong");
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Would you like to do some math now? (yes or no)");
        yesNo = uI.nextLine();
        index = 0;
        while (yesNo.equals("yes")) {
            int answerCount = 0;
            int wrongAnswer = 0;

            test.menu();
            yesNo = uI.nextLine();
            if (yesNo.equals("1")) {
                test.insertMathQuestions(addQuestions, addAnswer, fileNameAdd);
                /*
                 ? We should add a feature where it randomly give the user a index form the add array(DONE)
                 *
                 * The timer works and such
                 * How the random works:
                 *
                 * I stored the max size of the array in an int varable called max
                 * then you just multiply it by Math.random()
                 */
                mT.start();
                System.out.println("You now have 1 min to answer math questions");
                int max = addQuestions.size();

                while (mT.check() && index < addQuestions.size()) {
                    /*
                     * This loops through the addQuestion Array while the user still has time
                     * the If statement does a check to see if there is time left
                     *
                     *
                     ! (need to add in the wrong and correct answer count into the
                     ! the student class)
                     */
                    int randNum = (int)(Math.random() * max);
                    System.out.println(addQuestions.get(randNum));
                    if (mT.check()) {
                        yesNo = uI.nextLine();
                        index++;
                        if (yesNo.equals(addAnswer.get(randNum))) {
                            answerCount++;
                        } else {
                            wrongAnswer++;
                        }
                    }
                }
            }
            /*
             * Pleas eneter the the code for the program here
             *
             ? Create a menu  for the user to pick what they want to do
             ! need 4> if statments that have loops through
             *
             *
             ? create  method that checks of a answer is correct or not
             ? create variable that hold the ammount of correct answers
             !    * you might need to cereate a new private varble in Student
             !    * maybe one for each txt file or something
             *    *
             *
             *
             *
             */

        }
    }
}