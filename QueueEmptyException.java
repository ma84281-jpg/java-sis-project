
/**
 * Write a description of class QueueEmptyException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QueueEmptyException extends Exception
{
    public QueueEmptyException(){
        super();
    }
    
    public QueueEmptyException(String message){
        super(message);
    }    
}