
/**
 * Write a dekeyboardription of class FacultyDemoLogin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class FacultyDemoLogin
{
    public static void runFacultyLogin(NodeBasedStack<Faculty> facultyStack,
                                        ArrayBasedList<Faculty> facultyList,
                                        ArrayBasedList<CourseSection> sectionList) {

        Scanner keyboard = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n===== Faculty System =====");
            //System.out.println("1. Create a new faculty account");
            System.out.println("1. Log in to an existing faculty account");
            System.out.println("2. Exit");
            System.out.print("Please enter your choice: ");

            option = keyboard.nextInt();
            keyboard.nextLine();   

            //opt 1: create acct | emloyeeId auto generate //updated: replace the option to admin menu 
            /*
            if (option == 1) {
                System.out.println("\n--- Create a new faculty account ---");

                System.out.print("Enter first name: ");
                String firstName = keyboard.nextLine();

                System.out.print("Enter last name: ");
                String lastName = keyboard.nextLine();

                System.out.print("Enter birthdate (MM/DD/YYYY): ");
                String birthdate = keyboard.nextLine();

                System.out.print("Enter username: ");
                String username = keyboard.nextLine();

                System.out.print("Enter password: ");
                String password = keyboard.nextLine();

                System.out.print("Enter department: ");
                String department = keyboard.nextLine();

                Faculty newFaculty = new Faculty(firstName, lastName, birthdate,
                                                    username, password, department);
                
                facultyStack.push(newFaculty);
                
                facultyList.add(newFaculty);

                System.out.println(">> Faculty account created successfully.");
            }
            */

            //acct created -> login
            if (option == 1) {
                System.out.println("\n--- Faculty login ---");

                System.out.print("Enter username: ");
                String username = keyboard.nextLine();

                System.out.print("Enter password: ");
                String password = keyboard.nextLine();

                Faculty loggedInFaculty = findFacultyByLogin(facultyStack, username, password);

                if (loggedInFaculty != null) {
                    System.out.println("Login successful. Welcome, "
                                       + loggedInFaculty.getFirstName()
                                       + " " + loggedInFaculty.getLastName() + "!");
                                       
                    FacultyDemo1.FacultyMenu(loggedInFaculty, facultyStack, sectionList);

                }
                else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            }
            

            else if (option == 2) {
                System.out.println("Goodbye");
            }

            
            else {
                System.out.println("Invalid option. Try again!");
            }

        } while (option != 2);
    }
    
    
    //AI content
    private static Faculty findFacultyByLogin(NodeBasedStack<Faculty> facultyStack,
                                              String username, String password) {

        NodeBasedStack<Faculty> tempStack = new NodeBasedStack<Faculty>();
        Faculty foundFaculty = null;

        
        while (!facultyStack.isEmpty()) {
            Faculty current;

            try {
                current = facultyStack.pop();
            }
            catch (StackEmptyException e) {
                
                break;
            }

            tempStack.push(current);

            if (current.getUsername().equals(username) &&
                current.getPassword().equals(password)) {
                foundFaculty = current;
                
            }
        }

        
        while (!tempStack.isEmpty()) {
            try {
                Faculty f = tempStack.pop();
                facultyStack.push(f);
            }
            catch (StackEmptyException e) {
                break;
            }
        }

        return foundFaculty;
    }
}