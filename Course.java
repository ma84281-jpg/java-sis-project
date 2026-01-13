
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Course extends Object
{    
    
    private String subjectCode;
    private String courseNumber;
    private String courseTitle;
    
    public Course(String newSubjectCode, String newCourseTitle){
        super();
        subjectCode = newSubjectCode;
        courseNumber = "";
        courseTitle = newCourseTitle;
    }
    
    public Course(String newSubjectCode, String newCourseNumber, String newCourseTitle){
        super();
        subjectCode = newSubjectCode;
        courseNumber = newCourseNumber;
        courseTitle = newCourseTitle;
    }
    
    public void setSubjectCode(String newSubjectCode){
        subjectCode = newSubjectCode;
    }
    
    public String getSubjectCode(){
        return subjectCode;
    }
    
    public void setCourseNumber(String newCourseNumber){
        courseNumber = newCourseNumber;
    }
    
    public String getCourseNumber(){
        return courseNumber;
    }
    
    public void setCourseTitle(String newCourseTitle){
        courseTitle = newCourseTitle;
    }
    
    public String getCourseTitle(){
        return courseTitle;
    }
    
    public String toString(){
        return subjectCode + " - " + courseNumber +" "+ courseTitle;
    }
    
      public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;

        if (otherObject != null && otherObject instanceof Course) {
            Course otherCourse = (Course) otherObject;

               if (this.subjectCode.equals(otherCourse.subjectCode) &&
                this.courseNumber.equals(otherCourse.courseNumber) && this.courseTitle.equals(otherCourse.courseTitle)){
            
                areTheyEqual = true;
            }
        }

    return areTheyEqual;
    }
}