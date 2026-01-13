
/**
 * Write a description of class FacultyDemo1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class FacultyDemo1
{
    public static void FacultyMenu(Faculty currentFaculty,
                                    NodeBasedStack<Faculty> facultyStack,
                                    ArrayBasedList<CourseSection> sectionList) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Faculty Menu =====");
            System.out.println("1. View my assigned classes");
            System.out.println("2. View waitlist for my classes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = keyboard.nextInt();
            keyboard.nextLine();  

            //opt 1: see assigned class
            if (choice == 1) {
                System.out.println("\n--- Your assigned classes ---");
                currentFaculty.displayAssignedSections();
            }
            
            
            //opt 2: still thinking
            else if (choice == 2) {
                System.out.println("\n--- Waitlist of your assigned classes ---");
            
                // Nếu chưa được assign lớp nào
                if (currentFaculty.getSectionCount() == 0) {
                    System.out.println("You have not been assigned to any classes yet.");
                    return;
                } else{
                
                    int index = 0;
                
                    // Duyệt qua tất cả section mà faculty này được assign
                    while (index < currentFaculty.getSectionCount()) {
                        CourseSection section = currentFaculty.getSectionAt(index);
                
                        if (section != null) {
                            Course course = section.getCourse();
                            String code;
                            String title;
                
                            if (course != null) {
                                code = course.getSubjectCode();  
                                title = course.getCourseTitle();
                            } else {
                                code = "Unknown";
                                title = "";
                            }
                
                            System.out.println("\nClass:\n " 
                                               + (index + 1) + ": " + code + " " + title + " (" + section.getSectionNumber() + ")"
                                               + "\nTime: " + section.getTimeSlot());
                
                            section.displayWaitlist();
                        }
                
                        index = index + 1;
                    }
                }
            }

            
            
            else if (choice == 3) {
                System.out.println("Exiting faculty menu...");
            }
            
            else {
                System.out.println("Invalid option. Try again.");
            }

        } while(choice != 3);
        
    }
}