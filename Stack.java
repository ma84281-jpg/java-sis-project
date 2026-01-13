
/**
 * Abstract classes cannot have have objects constructed
 * of them. Instead they can be parent classes to concrete 
 * child classes which can have objects constructed of them.  The
 * main purpose of an abstract class is inheritance and to be
 * parent class to concrete child class.  
 * 
 * Abstract classes can have abstract methods which are just
 * method headings with no implementation.  These methods
 * must be implemented by a concrete child class.  These
 * abstract methods function like requirements for the child class.
 * Sometimes this referred to as overriding an abstract method.
 * 
 * T is a type parameter where type argument is sent to the type parameter
 * to allow objects of a specific type to be used in the context of the class
 * 
 * A class that uses type parameters is sometimes referred as a generic class
 * or just generics.  It also sometimes referred as a class that is parameterized over types.
 */
public abstract class Stack<T> extends Object
{
    //instance variable
    private String name;
    
    //constructors can be ony be called by the child class
    public Stack() {
        super();
        name = "";
    }
    
    public Stack(String stackName) {
        super();
        name = stackName;
    }
    
    //nonstatic methods
    public void setName(String newName) {
        name = newName;
    }
    
    public String getName() {
        return name;
    }
    
    
    /**
     * push adds an item to the top of the stack if there room
     * and otherwise throws StackFullException
     */
    public abstract void push(T item) throws StackFullException; //method heading or abstract method
    
    /**
     * removes the item at the top of the stack if there is one 
     * and otherwise throws StackEmptyException
     */
    public abstract T pop() throws StackEmptyException; //method heading or abstract method
    
    /**
     * returns the item at the top of the stack without 
     * changing the stack
     */
    public abstract T peek(); //method heading or abstract method
    
    
    
    
    
}