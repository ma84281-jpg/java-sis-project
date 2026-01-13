
/**
 * adminstrator can log in with username/password
 * can: manage course, sections, and assign faculty
 */
public class Administrator extends Employee
{
    //references
    private UnBoundedStack<Faculty> facultyStack;
    private ListInterface<Course> courseList;
    private ListInterface<CourseSection> sectionCourseList;
    
    private void initCollections() {
        facultyStack = new NodeBasedStack<Faculty>();
        courseList = new NodeBasedList<Course>();
        sectionCourseList = new NodeBasedList<CourseSection>();
    }
    
    //constructors
    public Administrator() {
        super(); 
        initCollections();
    }
    
    public Administrator(String firstName, String lastName) {
        super(firstName, lastName); 
        initCollections();
    }
    
    public Administrator(String firstName, String lastName, int employeeId) {
        super(firstName, lastName, employeeId); 
        initCollections();
    }
    
    public Administrator(String firstname, String lastname, int employeeId,
                         String username, String password) {
        super(firstname, lastname, employeeId, username, password);
        initCollections();
    }
    
    
    //Course Management
    /**
     * Add a course to the administrator's course list
     */
    public void addCourse(Course course) {
        if (course != null) {
            courseList.add(course);     //add() from ListInterface
        }
    }
    
    /**
     * Remove a course (if present).
     * return true if the course was found and removed
     */
    public boolean removeCourse(Course course) {
        return courseList.remove(course);   
    }
    
    /**
     * Check if a course is managed by this administrator
     */
    public boolean hasCourse(Course course) {
        return courseList.find(course);     
    }
    
    //course section management
    public void addCourseSection(CourseSection section) {
        if (section != null) {
            sectionCourseList.add(section);
        }
    }
    
    public boolean cancelCourseSection(CourseSection section) {
        return sectionCourseList.remove(section);
    }
    
    public boolean hasSection(CourseSection section) {
        return sectionCourseList.find(section);
    }
    
    //faculty management
    public void addFaculty(Faculty faculty) {
        if (faculty != null) {
            facultyStack.push(faculty);   
        }
    }
    
    public void removeLeastSeniorFaculty() {
        try {
            facultyStack.pop();          
        } catch (StackEmptyException e) {
            System.out.println("No faculty to remove: " + e.getMessage());
        }
    }
    
    public Faculty viewLeastSeniorFaculty() {
        return facultyStack.peek();   
    }
    
    
    public void assignFacultyToSection(Faculty faculty, CourseSection section) {
        section.setInstructor(faculty);
        //faculty.addSection(section);
    }
    
    public void unassignFacultyFromSection(CourseSection section) {
        section.setInstructor(null);
    }
    
    
    
    //getter in case future use
    public UnBoundedStack<Faculty> getFacultyStack() {
        return facultyStack;
    }

    public ListInterface<Course> getCourseList() {
        return courseList;
    }

    public ListInterface<CourseSection> getSectionCourseList() {
        return sectionCourseList;
    }
    
    @Override
    public String toString() {
        return "Administrator: " + getFirstName() + " " + getLastName();
    }
}