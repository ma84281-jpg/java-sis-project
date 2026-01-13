/**
 * Write a description of interface QueueInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface QueueInterface<E>
{
    public abstract void enqueue ( E item) throws QueueFullException;
    
    
    public abstract E dequeue();
    
   
    public abstract String look();
}    
