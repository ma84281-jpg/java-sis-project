
/**
 * Write a description of class Faculty here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Faculty extends Employee implements Loginable
{
    //instance variable
    private String department;
    private CourseSection[] assignedSections;
    private int sectionCount;
    
    private static final int MAX_SECTIONS = 5;
    private static int facultyId = 2000;
    
    //constructors
    public Faculty() {
        super(); //calls Employee()
        this.department = "";
        this.sectionCount = 0;
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        
    }
    
    public Faculty(String firstName, String lastName, String birtdate) {
        super(firstName, lastName, birtdate, facultyId); // calls Employee()
        facultyId++;
        this.department = "";
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        this.sectionCount = 0;
    }
    
    public Faculty(String username, String password) {
        super(username, password, facultyId); // calls Employee()
        facultyId++;
        this.department = "";
        this.sectionCount = 0;
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        
    }
    
    public Faculty(String firstName, String lastName,
                   String username, String password) {

        super(firstName, lastName, facultyId, username, password);
        facultyId++;
        this.department = "";
        this.sectionCount = 0;
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        
    }
    
    public Faculty(String firstName, String lastName, String birthdate,
                   String username, String password, String department) {

        super(firstName, lastName, birthdate, facultyId, username, password);
        facultyId++;
        this.department = department;
        this.sectionCount = 0;
        this.assignedSections = new CourseSection[MAX_SECTIONS];
        
    }
    
    
    //setter & getters
    public int getFacultyId(){
        facultyId++;
        return facultyId;
    }
    
    public void setDepartment(String facultyDepartment) {
        department = facultyDepartment;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getSectionCount() { //return number of faculty was assigned
        return sectionCount;
    }
    
    public CourseSection getSectionAt(int index) {//return the current section at index, in the list of sections falcuty was assigned
        if (index >= 0 && index < sectionCount) {
            return assignedSections[index];
        } 
        else {
            return null;
        }
    } 
    
    public void displayAssignedSections() {
    if (sectionCount == 0) {
        System.out.println("You have not been assigned to any classes yet.");
    } else {
        int index = 0;

        System.out.println("You are assigned to these classes:");

        for (int i = 0; i < sectionCount; i++) {
            CourseSection sec = assignedSections[i];
            if (sec != null) {
                Course course = sec.getCourse();

                String code;
                String title;

                if (course != null) {
                    code = course.getSubjectCode();   
                    title = course.getCourseTitle();
                    
                } else {
                    code = "Unknown";
                    title = "";
                }

                System.out.println((i + 1) + ". " + code + " " + title
                               + "(" + sec.getSectionNumber() + ")" 
                               + "\nTime: " + sec.getTimeSlot()
                               + "\nInstructor: " + sec.getInstructorName());
                //try to display student that enrolled to course that already assigned to faculty               
                sec.displayEnrolledStudents();

            }
        }
    }
}

    
    //add section 
    public boolean addSection(CourseSection section) {
        for (int i = 0; i < sectionCount; i++) { //check for duplicate
            if (assignedSections[i] == section) { 
                return false; //already assigned section found
            }
        }

        if (sectionCount >= MAX_SECTIONS) { //falculty can't be hold more than 20 sections 
            return false; //cannot add more
        }

        assignedSections[sectionCount] = section;
        sectionCount++;
        return true;
    }

    
    
    
    /*
    public int getTotalCredits() {
        int total = 0;
        for (int i = 0; i < sectionCount; i++) {
            CourseSection s = assignedSections[i];
            if (s != null && s.getCourse() != null) {
                total += s.getCourse().getCreditHours();
            }
        }
        return total;
    }
    */
    
    
    @Override
    public String toString() {
        return super.toString()
             + ", Dept: " + department
             + ", Sections: " + sectionCount;
    }
    
    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject != null && otherObject instanceof Faculty) { //if  there is an object and it is a person
            Faculty otherFaculty = (Faculty)otherObject; //object type casting,new ref of type person
            if(super.equals(otherObject) && this.department.equals(otherFaculty.department)) { //check if tthe two namem are equal
                        areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}