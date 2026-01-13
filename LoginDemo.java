
/**
 * Write a dekeyboardription of class LoginDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class LoginDemo
{
    public static void main(String [] args) {
        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        
        //administrators reference
        ArrayBasedList<CourseSection> sectionList = new ArrayBasedList<CourseSection>();
        Administrator admin = new Administrator("System", "Admin");
        
        //student reference
        Tree<Student> studentTree = new Tree<Student>();
        NodeBasedList<Student> studentList = new NodeBasedList<Student>();
        Student info;
        
        //faculty reference
        ArrayBasedList<Faculty> facultyList = new ArrayBasedList<Faculty>();
        NodeBasedStack<Faculty> facultyStack = new NodeBasedStack<Faculty>();
    
        
        do{
            System.out.println("Are You....");
            System.out.println("1. Adminstrator");
            System.out.println("2. Student");
            System.out.println("3. Faculty");
            System.out.println("4. To Exit");
            option = keyboard.nextInt();
            keyboard.nextLine();
            if(option == 1) { //login system for administrator
                AdminLoginDemo.runAdminLogin(admin,sectionList,facultyList, facultyStack);
                
            }
            else if(option == 2) {  //login system for student
                StudentLoginDemo.runStudentLogin(studentTree, studentList, sectionList);
            }
            
            
            else if(option == 3) {  //login system for faculty
                FacultyDemoLogin.runFacultyLogin(facultyStack, facultyList, sectionList);
            }
            else if(option == 4){
                System.out.println("Goodbye");
            }
            else{
                System.out.println("Invalid option.");
            }
            
        }while(option != 4);
    }
}