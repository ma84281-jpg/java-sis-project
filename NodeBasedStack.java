
/**
 * Write a description of class NodeBasedStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeBasedStack<T> extends UnBoundedStack<T>
{
    //instance variables
    private Node<T> top; //reference to a Node object
    
    //constructor
    public NodeBasedStack() {
        top = null;
    }
    
    @Override
    public void push(T item) {
        Node<T> currentNode = new Node<T>(item);
        
        if(top == null) { //if the stack is empty
            top = currentNode;
        }
        else {
            currentNode.setLink(top);
            top = currentNode;
        }
        
    }
    
    @Override
    public  T pop() throws StackEmptyException {
        if(top != null) { //if the stack is empty
            T topItem = top.getData();
            top = top.getLink(); //go ot the next item below the top
            return topItem;
        }
        else {
            throw new StackEmptyException("Pop attempted on an empty stack");
        }
    }
    
    @Override
    public T peek() {
        T topItem = null;
        if (top != null) {
            topItem = top.getData();
        }
        return topItem;
    }
    
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        else {
            return false;
        }
    }
}