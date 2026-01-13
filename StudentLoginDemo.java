
/**
 * Write a description of class StudentLoginDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class StudentLoginDemo
{
    public static void runStudentLogin(Tree<Student> studentTree,
                                        NodeBasedList<Student> studentList,
                                        ArrayBasedList<CourseSection> sectionList){
        Scanner sc = new Scanner(System.in);
        
        //Tree<Student> studentTree = new Tree<Student>();
        //NodeBasedList<Student> studentList = new NodeBasedList<Student>();
        Student info; 
        
        int option;
        do{
            System.out.println("\n===== Welcome to Student Registration System =====");
            System.out.println("1. Create a new account ");
            System.out.println("2. Log in to an existing account ");  
            System.out.println("3. Exit the program");
            System.out.println("Please enter your choice: ");
            option = sc.nextInt();
            sc.nextLine();
            
            if (option == 1 ){
                System.out.println("Enter your first name: ");
                String firstName = sc.nextLine();
                            
                System.out.println("Enter your last name: ");
                String lastName = sc.nextLine();
                            
                System.out.println("Enter your birthdate (MM/DD/YYYY): ");
                String birthdate = sc.nextLine();
            
                System.out.println("Create a username: ");
                String username = sc.nextLine();
            
                System.out.println("Create a password: ");
                String password = sc.nextLine();
            
                int newId = Student.getID();
            
                // Tạo 1 student duy nhất, đầy đủ thông tin
                Student newStudent = new Student(firstName, lastName, birthdate,
                                                 newId, username, password);
            
                // Kiểm tra trùng dựa trên student nhà bạn đã tạo hoàn chỉnh
                if (studentTree.find(newStudent)) {
                    System.out.println("An account with this information already exists.");
                    System.out.println("Please log in using your username and password.");
                } 
                else {
                    studentTree.add(newStudent);
                    studentList.add(newStudent);
            
                    System.out.println("\n*** Account Created Successfully ***");
                    System.out.println("Your student account has been created.");
                    System.out.println("Your ID is: " + newStudent.getStudentId());
                }

            }
            
            else if (option == 2){
                    System.out.println("Enter your username: ");
                    String username = sc .next();
                    System.out.println("Enter your password");
                    String password = sc .next();
                    Student account = new Student(username, password);
                    //account.setUsername(username);
                    //account.setPassword(password);
                                     
                    if (studentList.login(username, password)){
                        System.out.println("Login successful! Welcome to the Student Information System (SIS).");
                     
                        Student loggedInStudent = studentList.getItem(account);
                        
                        StudentDemo1.StudentMenu(loggedInStudent, sectionList); //bridge to demo2
                    }
                    else{
                        System.out.println("Invalid username or password. Please try again.");
                    }
            }
               
            else if(option == 3){
                System.out.println("Goodbye");
            }
            
            else{
                System.out.println("Invalid option. Try again!");
            }
            
        }while (option != 3);
        
    }
}