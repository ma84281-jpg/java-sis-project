import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Write a description of class ArrayBasedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayBasedList<E> extends Object implements ListInterface<E>
{
    
    public int numberOfItems;
    public E[] list; 
    
    ArrayBasedQueue<E> waitList;
    
    public ArrayBasedList() {
        super();
        numberOfItems = 0;
        list = (E[])new Object[5];
        waitList = new ArrayBasedQueue<E>(3);
    }
    
    public ArrayBasedList(int size) {
        super();
        if(size > 0) {
            list = (E[])new Object[size];
        }
        else {
            list = (E[])new Object[5];
        }
        waitList = new ArrayBasedQueue<E>(3);
    }
    
    @Override
    public void add(E item) {
        if(numberOfItems < list.length) {
            list[numberOfItems] = item;
            numberOfItems++;
        }
        else {
            try{
                waitList.enqueue(item);
                System.out.println("Class is full. You have been added to the wait list");
            }catch(QueueFullException e){
                System.out.println("The waitlist is full. No more students can be added.");
            }
            
        }
    }
    
    @Override
    public boolean find(E item) {
        
        boolean found = false;
        int index = locate(item);
        if(index != -1) { 
            found = true;
        }
        return found;
    }

    
    private int locate(E item) { 
        boolean found = false;
        int index = 0;
        while(!found && index < numberOfItems) { 
            if(list[index].equals(item)) {
                found = true;
            }
            else {
                index++;
            }
        }
        
        if(!found) { 
            index = -1;  
        }
        return index;
    }
    
    @Override
    public boolean remove(E item) {
        int index = locate(item);
        boolean removed = false;
        if(index != -1) { 
            list[index] = null; 
            numberOfItems--;
            list[index] = list[numberOfItems]; 
            list[numberOfItems] = null; 
            removed = true;
            
            if (removed && waitList.size() > 0) {
                list[numberOfItems] = waitList.dequeue();
                numberOfItems++;
                System.out.println("A student moved from waitlist into the class.");
            }
        }
        return removed;
    }
    
    @Override
    public String toString() {
        String allItems = "";
        for(int index = 0; index < numberOfItems; index++) {
            allItems = allItems + "\n" + list[index].toString(); 
        }
        return allItems;
    }
    
    public Iterator<E> iterator() {
        return new ArrayBasedListIterator();
    }
    

    private class ArrayBasedListIterator extends Object implements Iterator<E>  {
     
        private int currentLocation;
        
        
        public ArrayBasedListIterator() {
            super();
            currentLocation = 0; 
        }
        
        @Override
        public boolean hasNext() {
            return currentLocation < numberOfItems;
        }
        
        @Override
        public E next() throws NoSuchElementException {
            if(currentLocation >= numberOfItems) { 
                throw new NoSuchElementException("Reached the end of the list!");
            }
            else {
                E currentItem = list[currentLocation];
                currentLocation++;
                return currentItem;
            }
        }
        
        
    }
    
    
    public boolean isEmpty() {
        if (numberOfItems == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int size() {
        return numberOfItems;
    }
    
    public void displayAllSections() {
        if (numberOfItems == 0) {
            System.out.println("No classes available.");
            return;
        }
        for (int i = 0; i < numberOfItems; i++) {
            CourseSection section = (CourseSection) list[i];
            Course course = section.getCourse();
    
            String code;
            String title;
    
            if (course != null) {
                code = course.getSubjectCode();
                title = course.getCourseTitle();
                
            } else {
                code = "Unknown";
                title = "";
            }
    
            System.out.println((i + 1) + ". " + code + " " + title
                               + "(" + section.getSectionNumber() + ")" 
                               + "\nTime: " + section.getTimeSlot()
                               + "\nInstructor: " + section.getInstructorName());
        }
    }
    
    public int displayUnassignedSections() {
        if (numberOfItems == 0) {
            System.out.println("No classes available.");
            return 0;
        }
    
        int displayIndex = 1;
        boolean any = false;
    
        for (int i = 0; i < numberOfItems; i++) {
            CourseSection section = (CourseSection) list[i];
    
            if (section.getInstructor() == null) {
                any = true;
    
                Course course = section.getCourse();
                String code;
                String title;
    
                if (course != null) {
                    code = course.getSubjectCode();  
                    title = course.getCourseTitle();
                } else {
                    code = "Unknown";
                    title = "";
                }
    
                System.out.println(displayIndex + ". "
                                   + code + " " + title
                                   + "(" + section.getSectionNumber() + ")" 
                                   + "\nTime: " + section.getTimeSlot()
                                   + "\nInstructor: " + section.getInstructorName());
    
                displayIndex = displayIndex + 1;
            }
        }
    
        if (!any) {
            System.out.println("There are no unassigned classes.");
            return 0;
        }
    
        //number of unassign class return
        return displayIndex - 1;
    }
    
    //AI help
    public CourseSection getUnassignedSectionByDisplayNumber(int displayNumber) {
        int displayIndex = 1;
    
        for (int i = 0; i < numberOfItems; i++) {
            CourseSection section = (CourseSection) list[i];
    
            if (section.getInstructor() == null) {
                if (displayIndex == displayNumber) {
                    return section;
                }
                displayIndex = displayIndex + 1;
            }
        }
    
        
        return null;
    }



    
    public void displayAllFaculty() {
        if (numberOfItems == 0) {
            System.out.println("No faculty available.");
            return;
        }
    
        int i = 0;
        while (i < numberOfItems) {
            E item = list[i];
    
            System.out.println((i + 1) + ". " + item);
    
            i = i + 1;
        }
    }

    
    public E getList(int index){
            return list[index];
    }
    
}