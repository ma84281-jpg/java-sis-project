
/**
 * Write a description of class UnBoundedStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class UnBoundedStack<T> extends Stack<T>
{
    //instance variables
    //none
    
    //constructor
    public UnBoundedStack() {
        super();
    }
    
    public UnBoundedStack(String name) {
        super(name);
    }
    
    //non-static, concrete methods
    //none
    
    //abstract methods
    /**
     * overriding or replacing the abstract method heading from
     * Stack class with a new heading that does not throw
     * StackFullException
     * 
     * this method will always push the item to the top of the stack
     */
    @Override
    public abstract void push(T item);
}