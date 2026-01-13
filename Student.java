
public class Student extends Person implements Loginable, Comparable<Student> 
{
    //instance variables
   private int studentId;
   private String username;
   private String password;
   private static int ID = 1233;
   private ArrayBasedList<Course> myCourse;
   
   //constructors
   public Student(){
       super();
       studentId = 0;
       username = "";
       password = "";
       myCourse = new ArrayBasedList<Course> (10);

   }
   
   //overload contructors
    public Student(String name, String lastName, String bdate){
       super(name,lastName, bdate);
       username = "";
       password = "";
       myCourse = new ArrayBasedList<Course>(10);
   }
   
   
   public Student (String newUsername, String newPassword){
       username = newUsername;
       password = newPassword;
       myCourse = new ArrayBasedList<Course>(10);
   }
   
   public Student(String firstName, String lastName,
               String username, String password) {
       super(firstName, lastName); 
       this.username = username;
       this.password = password;
       this.myCourse = new ArrayBasedList<Course>(10);
   }

   
   public Student(String name, String lastName, String bdate, int newStudentId, String newUsername, String newPassword){
       super(name, lastName, bdate);

        if (newStudentId > 0) {
            this.studentId = newStudentId;
        } else {
            this.studentId = 0;
        }
    
        this.username = newUsername;
        this.password = newPassword;
       myCourse = new ArrayBasedList<Course>(10);
   }
   
   
   public Student ( String newName , int newStudentId, String newUsername, String newPassword){
       super();
       super.setFirstName(newName);
       if (newStudentId > 0 ){
           studentId = newStudentId;
       }
       username = newUsername;
       password = newPassword;
       myCourse = new ArrayBasedList<Course>(10);
   }
   
   //setters & getters
   public void setStudentId(int newStudentId){
       if (newStudentId > 0 ){
           studentId = newStudentId;
       }else{
           studentId = 0;
       }
   }
   
   public int getStudentId (){
       return studentId;
   }
   
   
   public void setUsername(String newUsername){
       username = newUsername;
   }
   
   public String getUsername(){
       return username;
   }
   
   public void setPassword(String newPassword){
       password = newPassword;
   }
   
   public String getPassword (){
       return password;
   }
     
   public ArrayBasedList<Course> getMyCourse() {
       return myCourse;
   }

   
   public String toString(){
       return super.getFirstName() + " Student ID " + studentId + " Username " + username + " Password " + password ;
   }
   
   @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
    
        if (otherObject != null && otherObject instanceof Student) {
            Student otherStudent = (Student) otherObject;
    
               if (this.username != null && this.password != null &&
                otherStudent.username != null && otherStudent.password != null &&
                this.username.equals(otherStudent.username) &&
                this.password.equals(otherStudent.password)) {
            
                areTheyEqual = true;
            }
        }
    
    return areTheyEqual;
    }
   
    public void addCourse(Course newCourse) {

        boolean duplicate = false;
        int i = 0;
    
        
        while (i < myCourse.numberOfItems) { //cause NullPointerException - eleminated
    
            Course c = myCourse.getList(i); 
    
            if (c.getSubjectCode().equals(newCourse.getSubjectCode())) {
    
                duplicate = true;
            }
    
            i++;   
        }
    
        if (!duplicate) {
            myCourse.add(newCourse);
            System.out.println("Class added successfully!");
        } else {
            System.out.println("You already registered for this class!");
        }
 
   }
    
   public void dropCourse(Course myClass) { 
        myCourse.remove(myClass);
   }
    
   public String viewMyCourses() { 
      return myCourse.toString();
   }

   
   public static int getID(){
       ID++;
       return ID;
   }
   
   @Override
   public int compareTo(Student other) {
        // Compare last name first
        int result = this.getLastName().compareTo(other.getLastName());
        if (result != 0) {
            return result;
        }

        // Then first name
        result = this.getFirstName().compareTo(other.getFirstName());
        if (result != 0) {
            return result;
        }

        // Then birthdate (as String is fine if format is the same)
        return this.getBirthdate().compareTo(other.getBirthdate());
   }   


}