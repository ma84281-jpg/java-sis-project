
/**
 * Write a description of class Person here.
 *
 * @author (your firstName)
 * @version (a version number or a date)
 */
public class Person extends Object
{
    
    private String firstName; 
    
    private String lastName;
    
    private String birthdate;

    public Person() {
        super();
        firstName = "";
        lastName = "";
        birthdate = "";
        
    }
    
    public Person(String newFirstName, String newLastName) { 
        super();
        firstName = newFirstName;
        lastName = newLastName;
        birthdate = "";
    }
    
    public Person(String newFirstName, String newLastName, String newBirthdate) { 
        super();
        firstName = newFirstName;
        lastName = newLastName;
        birthdate = newBirthdate;
    }

    
    public void setFirstName(String newName) {
        firstName = newName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setBirthdate(String newBirthdate) {
        birthdate = newBirthdate;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public String toString(){
        return "\nFirst name: " + firstName + " Last name: " + lastName + 
                "\nBirthdate: " + birthdate;
    }
    
       @Override
    public boolean equals(Object otherObject) {
        boolean areTheyEqual = false; 
        if(otherObject != null && otherObject instanceof Person) { //if there is an object and it is a person
            Person otherPerson = (Person)otherObject; //object type casting, new reference of type person
            if(this.firstName.equals(otherPerson.firstName) && this.lastName.equals(otherPerson.lastName) && this.birthdate.equals(otherPerson.birthdate)) { //check if the two firstNames are equal
                areTheyEqual = true;
            }
        }
        return areTheyEqual;
    }
}