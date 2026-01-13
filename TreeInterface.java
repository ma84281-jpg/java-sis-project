
/**
 * Write a description of interface TreeInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface TreeInterface<E>
{
    public abstract void add(E item);
    
    public abstract boolean find(E item);
    
    public abstract boolean remove(E item);
    
}