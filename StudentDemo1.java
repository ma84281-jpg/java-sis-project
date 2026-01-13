
/**
 * Write a description of class Demo2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class StudentDemo1
{
    public static void StudentMenu(Student currentStudent,
                                    ArrayBasedList<CourseSection> sectionList){
        Scanner sc = new Scanner(System.in);
        
        int option;
        
        do{
            System.out.println("\n  Class Management Menu   ");
            System.out.println("1. Add a class");
            System.out.println("2. Drop a Class");
            System.out.println("3. View your enrolled classes");
            System.out.println("4. Return to the main menu");
            System.out.println("Please enter your choice: ");
        
            option = sc.nextInt();
            sc.nextLine();
            
            if (option == 1){
                try
                {
                    registerForClass(currentStudent, sectionList, sc);
                }
                catch (QueueFullException qfe)
                {
                    qfe.printStackTrace(); //recommend fix from blueJ
                }
            }
            else if(option == 2){
                dropRegisteredClass(currentStudent, sectionList, sc);
            }
            else if(option == 3){
                System.out.println(currentStudent.viewMyCourses());
            }
    
        }while (option != 4);
    }
    
    
    
    
    
    //helper method use only inside StudentDmeo1
    private static void registerForClass(Student currentStudent,
                                     ArrayBasedList<CourseSection> sectionList,
                                     Scanner sc) throws QueueFullException {

        if (sectionList.isEmpty()) {
            System.out.println("There are no classes available.");
            return; //exit out
        } else {
    
            System.out.println("\nAvailable classes:");
            sectionList.displayAllSections(); //display all section opened from admin
        
            System.out.print("Enter the index of the class to register: ");
            int index = sc.nextInt();
            sc.nextLine();
        
            if (index < 1 || index > sectionList.size()) {
                System.out.println("Invalid class selection.");
                return;
            } else {
        
                CourseSection selectedSection = (CourseSection) sectionList.getList(index - 1);
            
                boolean enrolled = selectedSection.registerStudent(currentStudent); //registeredStudent from courseSection
            
                if (enrolled) {
                    Course c = selectedSection.getCourse();
                    currentStudent.addCourse(c);
                }
            }
        }
    }
    
    private static void dropRegisteredClass(Student currentStudent,
                                        ArrayBasedList<CourseSection> sectionList,
                                        Scanner sc) {
        System.out.println("\nYour current registered courses:");
        System.out.println(currentStudent.viewMyCourses()); //display all course enrolled
    
        System.out.print("Enter the subject code of the course to drop: "); //because student wont take two course code at the same semester
        String code = sc.nextLine();
        System.out.print("Enter the section number of the class to drop: ");
        int sectionNum = sc.nextInt();
        sc.nextLine();
    
        Course toDrop = null;
    
        int i = 0;
        ArrayBasedList<Course> myCourseList = currentStudent.getMyCourse();
        while (i < myCourseList.size()) { //check for the course code picked present in enrolled list or not
            Course c = (Course) myCourseList.getList(i);
            if (c.getSubjectCode().equals(code)) {
                toDrop = c;
            }
            i = i + 1;
        }
    
        if (toDrop == null) { //if picked course to drop dont have in enrolled list
            System.out.println("You are not registered in this course.");
            return;
        } else {
            i = 0;
            boolean droppedFromSection = false;
            while (i < sectionList.size()) {
                CourseSection sec = (CourseSection) sectionList.getList(i);
                Course c = sec.getCourse();
        
                if (c != null && c.getSubjectCode().equals(code) && sec.getSectionNumber() == sectionNum) {
                    sec.dropStudent(currentStudent);
                    droppedFromSection = true;
                }
                i = i + 1;
            }
            if(!droppedFromSection) {
                System.out.println("Failure: You registered to this course code but in different section!");
                return;
            }
        
            currentStudent.dropCourse(toDrop); //remove course from myCoure in Student
            System.out.println("Course dropped successfully.");
        }
    }


}