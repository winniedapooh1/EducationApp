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
        /*
         * You still have to make a loop that loops through to see if they hava an account
         * make sure to make a check to see if the user exist in the student array list
         */
        insertStudent(students, fileNameStudents);
        //System.out.println(students.get(0).getName());
        System.out.println("Are you a new user?(yes or no)");
        yesNo = uI.nextLine();
        while (yesNo.equals("yes")) {
            /*
             * make a method that checks is the username or password is already taken
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

            menu();
            yesNo = uI.nextLine();
            if (yesNo.equals("1")) {
                insertMathQuestions(addQuestions, addAnswer, fileNameAdd);
                /*
                 * We should add a feature where it randomly give the user a index form the add array(DONE)
                 * The timer works and such
                 * How the random works:
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
                     * (need to add in the wrong and correct answer count into the
                     * the student class)
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
             * Create a menu  for the user to pick what they want to do
             * need 4> if statments that have loops through
             *
             *
             * create  method that checks of a answer is correct or not
             * create variable that hold the ammount of correct answers
             *    * you might need to cereate a new private varble in Student
             *    * maybe one for each txt file or something
             *    *
             *
             *
             *
             */

        }
    }

    public static void insertMathQuestions(ArrayList<String> mathEx, ArrayList<String> Answer, String filename) {
        try {
            /*
             * Think of scanner as blank notepads
             */
            FileReader fr = new FileReader(filename);
            Scanner sC = new Scanner(fr);
            /*
             * Makes blank notepad of txt file
             */
            while (sC.hasNext()) {
                /*
                 *Instead of using buffred reader it is easier to use scanners
                 * to insert into an ArrayList
                 */
                String txt = sC.nextLine();
                /*
                 * txt catches the entire first line include the ";"
                 */
                Scanner sCT = new Scanner(txt);
                /*
                 * sCT is a new blank notepad the holds txt String
                 */
                sCT.useDelimiter(";"); // This is the same as .split()
                String mathExpression = "";
                String answer = "";
                //String rate = "";
                mathExpression = sCT.next();
                mathEx.add(mathExpression);
                answer = sCT.next();
                Answer.add(answer);
            }
            sC.close();
        } catch (FileNotFoundException badFile) {
            System.out.println("Trouble finding file");
        } catch (ArrayIndexOutOfBoundsException toofar) {
            System.out.println("index out of bonunds");
        }
    }

    public static void insertStudent(ArrayList<Student> students, String filename) {
        try {
            /*
             * Think of scanner of blank notepads
             */
            FileReader fr = new FileReader(filename);
            Scanner sC = new Scanner(fr);
            /*
             * Makes blank notepad of txt file
             */
            while (sC.hasNext()) {
                /*
                 *Instead of using buffred reader it is easier to use scanners
                 * to insert into an ArrayList
                 */
                String txt = sC.nextLine();
                /*
                 * txt catches the entire first line include the ";"
                 */
                Scanner sCT = new Scanner(txt);
                /*
                 * sCT is a new blank notepad the holds txt String
                 */
                sCT.useDelimiter(";"); // This is the same as .split()
                String username = "";
                String password = "";
                String level = "";
                String name = "";
                username = sCT.next();
                password = sCT.next();
                level = sCT.next();
                name = sCT.next();
                Student obj = new Student(username, password, level, name);
                students.add(obj);
                /*
                 * This basically finds the next string in the line and insersts it into a String and makes
                 * a obj and then adds that into a Arraylist
                 */
            }
            sC.close();
        } catch (FileNotFoundException badFile) {
            System.out.println("Trouble finding file");
        } catch (ArrayIndexOutOfBoundsException toofar) {
            System.out.println("index out of bonunds");
        }
    }

    public static void menu() {
        System.out.println("Please enter the number the number of the tyoe of math problem you want to practice ");
        System.out.println("1. Addition");
        System.out.println("2. subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

    }

    public static boolean taken(String username, String password, ArrayList<Student> Student) {
        /*
         * This method will check to see if the new username is taken
         */
        for (int i = 0; i < Student.size(); i++) {
            if (username.equals(Student.get(i))) {
                System.out.println("Please enter a diffrent username");
            }
        }
        return false;
    }

    public static void write(String fileName) {
        String math = "";
        int answer = 0;
        /*
         * This could work but it could also give us a index out of bounds erro
         * I didnt complete it yet
         * Made on 11/6/22
         * This method is writing to a text file so I dont have too
         *
         */
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            BufferedWriter bW = new BufferedWriter(myWriter);
            for (int i = 1; i < 11; i++) {
                answer = i + i + 1;
                math = Integer.toString(i) + "+" + Integer.toString(i + 1) + ";" + Integer.toString(answer);
                myWriter.write(math + System.getProperty("line.separator"));
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
}