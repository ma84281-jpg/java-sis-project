
/**
 * Write a description of class AdminDemo1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class AdminDemo1 {

    public static void adminMenu(Administrator admin,
                                 ArrayBasedList<CourseSection> sectionList,
                                 ArrayBasedList<Faculty> facultyList,
                                 NodeBasedStack<Faculty> facultyStack) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Administrator Menu =====");
            System.out.println("1. Hire new faculty");
            System.out.println("2. Add class (course section)");
            System.out.println("3. Cancel class");
            System.out.println("4. Assign faculty to class");
            System.out.println("5. Remove least senior faculty");
            System.out.println("6. Exit administrator menu");
            System.out.print("Please enter your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine(); 

            //option 1: Hire new faculty,  create acct | emloyeeId auto generate
            if (choice == 1) {
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
                
                admin.addFaculty(newFaculty);

                System.out.println(">> Faculty account created successfully.");
            }

            else if (choice == 2) {
                System.out.println("\n--- Add a new class ---");

                System.out.print("Enter course code (e.g., CS101): ");
                String courseCode = keyboard.nextLine();

                System.out.print("Enter course title: ");
                String courseTitle = keyboard.nextLine();

                System.out.print("Enter section number (e.g., 1): ");
                int sectionNumber = keyboard.nextInt();
                keyboard.nextLine(); 

                System.out.print("Enter time slot (e.g., MWF 10:00–10:50): ");
                String timeSlot = keyboard.nextLine();
                
                System.out.print("Enter max capacity of classroom: ");
                int capacity = keyboard.nextInt();

                Course course = new Course(courseCode, courseTitle);

                CourseSection section = new CourseSection(course, sectionNumber, timeSlot, capacity);

                //admin methods
                admin.addCourse(course);
                admin.addCourseSection(section);

                //add this section in menu list
                sectionList.add(section);

                System.out.println(">> Class added successfully.");

            }
            //option 2: cancel class
            else if (choice == 3) {
                System.out.println("\n--- Cancel a class ---");

                if (sectionList.isEmpty()) {
                    System.out.println("There are no classes to cancel.");
                } else {
                    sectionList.displayAllSections(); //show all sections,called from ArrayBasedList

                    System.out.print("Enter the number of the class to cancel: ");
                    int index = keyboard.nextInt();
                    keyboard.nextLine(); 

                    if (index >= 1 && index <= sectionList.size()) {
                        CourseSection toCancel = (CourseSection) sectionList.getList(index - 1);
                        boolean removed = sectionList.remove(toCancel);
                        
                        if (removed == true) {
                            System.out.println(">> Class canceled successfully.");
                        } else {
                            System.out.println(">> Failed to cancel class.");
                        }
                    } 
                    else {
                        System.out.println("Invalid selection.");
                    }

                }
            }
            //option 3: assign faculty to course
            else if (choice == 4) {
                System.out.println("\n--- Assign faculty to a class ---");
            
                //no course added by admin
                if (sectionList.isEmpty()) {
                    System.out.println("There are no classes available to assign.");
                }
                //no faculty added from faculty login
                else if (facultyList.isEmpty()) {
                    System.out.println("There are no faculty available to assign.");
                }
                else {
                    System.out.println("\nAvailable classes (without instructor):");
                    int availableCount = sectionList.displayUnassignedSections();
            
                    if (availableCount == 0) {
                        System.out.println("There are no unassigned classes.");
                        continue;
                    } else {
                        System.out.print("Enter the number of the class to assign faculty: ");
                        int classIndex = keyboard.nextInt();
                        keyboard.nextLine();   
            
                        if (classIndex >= 1 && classIndex <= availableCount) {
                            CourseSection selectedSection = sectionList.getUnassignedSectionByDisplayNumber(classIndex);
            
                            if (selectedSection == null) {
                                System.out.println("Invalid class selection.");
                            } else {
                                System.out.println("\nAvailable faculty:");
                                facultyList.displayAllFaculty();
            
                                System.out.print("Enter the number of the faculty to assign: ");
                                int facultyIndex = keyboard.nextInt();
                                keyboard.nextLine();
            
                                if (facultyIndex >= 1 && facultyIndex <= facultyList.size()) {
            
                                    Faculty selectedFaculty = (Faculty) facultyList.getList(facultyIndex - 1);
            
                                    //assign faculty to section
                                    admin.assignFacultyToSection(selectedFaculty, selectedSection);
            
                                    //for faculty to see assigned course list in faculty login
                                    boolean ok = selectedFaculty.addSection(selectedSection);
                                    if (!ok) {
                                        System.out.println("Warning: could not add section to faculty's list.");
                                    }
            
                                    System.out.println(">> Faculty assigned to class successfully.");
                                } else {
                                    System.out.println("Invalid faculty selection.");
                                }
                            }
                        } else {
                            System.out.println("Invalid class selection.");
                        }
                    }
                }
            }
            //option 4: remove least senority faculty
            else if (choice == 5) {
                /*
                System.out.println("\n--- Remove least senior faculty ---");

                Faculty least = admin.viewLeastSeniorFaculty();
                if (least == null) {
                    System.out.println("There is no faculty to remove.");
                } else {
                    System.out.println("Least senior faculty: " + least);
                    admin.removeLeastSeniorFaculty();
                    System.out.println(">> Faculty removed from stack.");
                }
                */
                System.out.println("\n--- Remove least senior faculty ---");

                if (facultyStack.isEmpty()) {
                    System.out.println("There is no faculty to remove.");
                } else {
                    
                    Faculty least = facultyStack.peek();
                    System.out.println("Least senior faculty: " + least);
            
                    
                    try {
                        facultyStack.pop();
                    } catch (StackEmptyException e) {
                        System.out.println("Error removing from stack: " + e.getMessage());
                    }
            
                    
                    boolean removedFromList = facultyList.remove(least);
                    if (!removedFromList) {
                        System.out.println("Warning: faculty not found in list.");
                    }
            
                    System.out.println(">> Faculty removed from system.");
                }

            }
            
            else if (choice == 6) {
                System.out.println("Exiting administrator menu...");
            }
            
            else {
                System.out.println("Invalid option. Try again!");
            }

        } while (choice != 6);
    }
}
