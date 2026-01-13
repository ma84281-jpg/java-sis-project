
/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee extends Person
{
    
    //instance variable
    private int employeeId; //camel caseing
    private String username;
    private String password;
    //private MyDate hireDate;
    
    /*
    //inner class
    public static class MyDate {
        private int month;
        private int day;
        private int year;

        public MyDate(int month, int day, int year) {
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public boolean isAfter(MyDate other) {
            if (this.year != other.year)
                return this.year > other.year;
            if (this.month != other.month)
                return this.month > other.month;
            return this.day > other.day;
        }

        @Override
        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }
    //end inner class
    */
    
    //constructors
    public Employee() {
        super();
        this.employeeId = 0;
        this.username = "";
        this.password = "";
        //this.hireDate = new MyDate(1, 1, 2000); // default
    }
    
    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        this.employeeId = 0;
        this.username = "";
        this.password = "";
        //this.hireDate = new MyDate(1, 1, 2000);
    }
    
    public Employee(String firstName, String lastName, int employeeId) {
        super(firstName, lastName);
        this.employeeId = employeeId;
        this.username = "";
        this.password = "";
        //this.hireDate = new MyDate(1, 1, 2000);
    }
    
    public Employee(String firstName, String lastName, String birthdate) {
        super(firstName, lastName, birthdate);
        this.employeeId = 0;
        this.username = "";
        this.password = "";
        //this.hireDate = new MyDate(1, 1, 2000);
    }
    
    public Employee(String firstName, String lastName, String birthdate, int employeeId) {
        super(firstName, lastName, birthdate);
        this.employeeId = employeeId;
        this.username = "";
        this.password = "";
        //this.hireDate = new MyDate(1, 1, 2000);
    }
    
    public Employee(String firstName, String lastName,
                    int employeeId, String username, String password) {

        super(firstName, lastName);
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        //this.hireDate = hireDate;
    }

    public Employee(String firstName, String lastName, String birthdate,
                    int employeeId, String username, String password) {

        super(firstName, lastName, birthdate);
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
        //this.hireDate = hireDate;
    }
    
    //setters and getters
    public void setEmployeeId(int newEmployeeId) {
        if (newEmployeeId > 0) {
            employeeId = newEmployeeId;
        }
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username; 
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password; 
    }
    
    /*
    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate;
    }
    
    public MyDate getHireDate() {
        return hireDate;
    }
    */
    
    //authentication
    public boolean authenticate(String username, String password) { //can be use to compare the faculty
        return this.username.equals(username) && this.password.equals(password);
    }
    
    
    @Override
    public String toString() {
        //return "Name: " + super.getFirstName() + " ,Employee ID: " + employeeId;
        return super.toString() + 
                "\nEmployee ID: " + employeeId +
                "\nUsername: " + username;
                
    }
    
    @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false;
        if (otherObject != null && otherObject instanceof Employee) { //if  there is an object and it is a person
            Employee otherEmployee = (Employee)otherObject; //object type casting,new ref of type person
            if(this.getFirstName().equals(otherEmployee.getFirstName()) && //super.equals(otherObject)
                this.employeeId == otherEmployee.employeeId) { //check if id are equal
                    areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
    
    
    
    
    
}