import java.io.*;
import java.util.*;
public class test {
    /*
     * This class is used for testing code and storing methods so the readability of the runner class is better
     */
    public static void main(String []args){

         for(int i = 0; i < 10; i ++){
             int ran = (int)(Math.random() * 10);
             System.out.println(ran);
         }
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
    public static boolean takenUserName(String username, ArrayList<Student> Student) {
        /*
         * This method will check to see if the new username is taken
         */
        for (int i = 0; i < Student.size(); i++) {
            if (username.equals(Student.get(i))) {
                System.out.println("Please enter a diffrent username");
                return true;
            }
        }
        return false;
    }
    public static boolean takenPassword(String password, ArrayList<Student> Student) {
        /*
         * This method will check to see if the new username is taken
         */
        for (int i = 0; i < Student.size(); i++) {
            if (password.equals(Student.get(i))) {
                System.out.println("Please enter a diffrent username");
                return true;
            }
        }
        return false;
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
                String right = "";
                String wrong = "";
                String name = "";
                username = sCT.next();
                password = sCT.next();
                right = sCT.next();
                wrong = sCT.next();
                name = sCT.next();
                Student obj = new Student(username, password, right, wrong, name);
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
}
