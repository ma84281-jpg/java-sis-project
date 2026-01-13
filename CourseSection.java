
/**
 * Write a description of class CourseSection here.
 *
 * @author (your name) a
 * @version (a version number or a date)
 */
public class CourseSection {
    private Course course;
    private int sectionNumber;
    private String timeSlot;
    private Faculty instructor;
    private int capacity;
    
    private ArrayBasedList<Student> enrolledStudents;
    private ArrayBasedQueue<Student> waitlist;

    public CourseSection(Course course, int sectionNumber) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.timeSlot = "";
        this.instructor = null;
        this.capacity = 3;
        enrolledStudents = new ArrayBasedList<Student>();
        waitlist = new ArrayBasedQueue<Student>();
    }
    
    
    public CourseSection(Course course, int sectionNumber, String timeSlot) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.timeSlot = timeSlot;
        this.instructor = null;
        this.capacity = 3;
        enrolledStudents = new ArrayBasedList<Student>();
        waitlist = new ArrayBasedQueue<Student>();
    }
    
    public CourseSection(Course course, int sectionNumber, String timeSlot, int newCapacity) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.timeSlot = timeSlot;
        this.instructor = null;
        this.capacity = newCapacity;
        enrolledStudents = new ArrayBasedList<Student>();
        waitlist = new ArrayBasedQueue<Student>();
    }
    
    public CourseSection(Course course, int sectionNumber, String timeSlot, Faculty instructor) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.timeSlot = timeSlot;
        this.instructor = instructor;
        this.capacity = 3;
        enrolledStudents = new ArrayBasedList<Student>();
        waitlist = new ArrayBasedQueue<Student>();
    }

    
    //getters and setters
    public Course getCourse() {
        return course;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }
    
    public Faculty getInstructor() {
        return instructor;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public String getInstructorName() {
        if (instructor == null) {
            return "No instructor assigned";
        } else {
            String firstName = instructor.getFirstName();
            String lastName = instructor.getLastName();
        
            return firstName + " " + lastName;
        }
    }
    
    /**
     * check for student not already in enrolled list, if found student enrolled, return
     * true and say student enrolled, if return false, will be add to waitlist
     */
    public boolean registerStudent(Student student) throws QueueFullException {
        int i = 0;
        while (i < enrolledStudents.size()) {
            Student enrolledStudent = (Student) enrolledStudents.getList(i);
            if (enrolledStudent == student) { // cùng object
                System.out.println("You are already enrolled in this class.");
                return true; // vẫn xem như enrolled
            }
            i = i + 1;
        }
    
        // 3. kiểm tra capacity
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            System.out.println("Enrolled in the class successfully.");
            return true; // enrolled
        } else {
            waitlist.enqueue(student);
            System.out.println("Class is full. You have been added to the waitlist.");
            return false; // vào waitlist
        }
    }
    
    public boolean dropStudent(Student student) {

        boolean removed = enrolledStudents.remove(student);
    
        if (removed) {
            System.out.println("You have dropped this class.");
    
            //logic is if student in enrolled list removed, front student (dequeued) from the waitlist will add to the enrolled list
            if (!waitlist.isEmpty()) {
                Student nextStudent = waitlist.dequeue();
                enrolledStudents.add(nextStudent);
    
                System.out.println("A student from the waitlist has been enrolled:");
                System.out.println(" -> " + nextStudent.getFirstName() + " "
                                   + nextStudent.getLastName());
            }
    
            return true;
        }
    
        System.out.println("You are not enrolled in this course."); //nếu không nằm trong enrolled, thì không làm gì với queue
        return false;
    }
    
    public void displayWaitlist() { //method for faculty use
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist is empty.");
        } else {
            System.out.println("Waitlist:");
            System.out.println(waitlist.toString()); 
        }
    }
    
    public void displayEnrolledStudents() { //call in faculty inside displayAssignedSections()
        if (enrolledStudents == null || enrolledStudents.size() == 0) {
            System.out.println("*** No students enrolled in this class.");
        } else {
            System.out.println("--- Enrolled students ---");
            
            
            /*
            int index = 0;
            while (index < enrolledStudents.size()) {
                Student s = (Student) enrolledStudents.getList(index);
    
                if (s != null) {
                    System.out.println("\n" + (index + 1) + ". "
                                       + s.getFirstName() + " "
                                       + s.getLastName());
                }
    
                index++;
            }
            */
           
            //check for idea 
            int index = 0;
            while (index < enrolledStudents.size()) {
                Student s = (Student) enrolledStudents.getList(index);
    
                if (s != null) {
    
                    // Ưu tiên in FirstName + LastName, nếu trống thì in Username
                    String displayName;
                    if (s.getFirstName() != null && !s.getFirstName().isEmpty()) {
                        displayName = s.getFirstName() + " " + s.getLastName();
                    } else {
                        displayName = s.getUsername();  // fallback
                    }
    
                    System.out.println((index + 1) + ". " + displayName);
                }
    
                index++;
            }
            System.out.println("---------------------------");
        }
    }





    
}
