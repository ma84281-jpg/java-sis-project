
/**
 * Write a description of class ArrayBasedQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayBasedQueue<E> extends Object implements QueueInterface<E>
{
    
    private int front;
    public int rear;
    public int numberOfItems;
    private E[] queue; 
    

    public ArrayBasedQueue() {
        front = 0;
        rear = 0;
        numberOfItems = 0;
        queue = (E[])new Object[5];
    }
    
    public ArrayBasedQueue(int size) {
        front = 0;
        rear = 0;
        numberOfItems = 0;
        if(size > 0) {
            queue = (E[])new Object[size];
        }
        else {
            queue = (E[])new Object[5];
        }
    }
    
    @Override
    public void enqueue(E item) throws QueueFullException { 
        if(numberOfItems < queue.length) { 
            queue[rear] = item;
            if(rear == queue.length - 1) {
                rear = 0;
            }
            else {
                rear++;
            }
            numberOfItems++;
        }
        else {
            throw new QueueFullException("Enqueue attempted on a full queue!"); 
        }
    }
    
    @Override
    public String look() {
        String frontItem = "";
        if(numberOfItems > 0) {
            frontItem = queue[front].toString();
        }
        else {
            frontItem = "Queue is empty!";
        }
        return frontItem;
    }
    
    @Override
    public E dequeue() {
        E frontItem = null;
        if(numberOfItems > 0) {
            frontItem = queue[front];
            queue[front] = null;
            numberOfItems--;
            if(front == queue.length - 1) {
                front = 0;
            }
            else {
                front++;
            }
            return frontItem;
        }
        return frontItem;
    }
    
    public int size() {
        return numberOfItems;
    }
    
    public E getQueue(int index){
        int realIndex = (front + index) % queue.length;
        return queue[realIndex];
    }
    
    public boolean isEmpty() {
        if (numberOfItems == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    @Override
    public String toString() {
        String result = "";
    
        if (numberOfItems == 0) {
            return "Waitlist is empty.";
        }
        
        
        //AI help part 
        int i = 0;
        while (i < numberOfItems) {
            E object  = getQueue(i);  
    
            if (object != null) {
                result = result + (i + 1) + ". " + object.toString() + "\n";
            }
    
            i++;
        }
    
        return result;
    }

}