/**
 * Write a description of interface ListInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ListInterface<E>
{
  
    public abstract void add(E item);
    

    public abstract boolean remove(E item);
 
    public abstract boolean find(E item);
    

    
}    