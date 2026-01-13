/**
 * Write a description of class NodeBasedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeBasedList<D> extends Object implements ListInterface<D>
{
    
    private Node list; 
    
    
    public NodeBasedList() {
        super();
        list = null;
    }
    
    @Override
    public void add(D item) {
        Node currentNode = new Node(item);
        if(list == null) { 
            list = currentNode;
        }
        else {
            
            currentNode.setLink(list);
            list = currentNode;
        }
    }
    
    @Override
    public boolean find(D item) {
        boolean found = false;
        Node currentNode = locate (item) ;
        if(currentNode != null) { 
            found = true;
        }   
        return found;
    }
  
    /*
    @Override
    public boolean remove(D item) {
        boolean removed = false;
        Node currentNode = locate(item);
        if(currentNode != null) {
            Node previousNode = list;
        while(previousNode.getLink() != currentNode){
            previousNode = previousNode.getLink();
        }
        previousNode. setLink(currentNode.getLink());
        currentNode.setLink(null);
        removed = true;
        }
    return removed;
    }
    */
    @Override
    public boolean remove(D item) {
        boolean found = false;
        Node currentNode = list;
        while(!found && currentNode != null) {
            if(currentNode.getData().equals(item)) {
                found = true;
            }
            else{
                currentNode = currentNode.getLink();
            }
        }
        
        boolean removed = false;
        if(found) {
            if(currentNode == list) { //if the item your trying to remove is the beginning of the list
                list = list.getLink(); //removes the first item on the list
            }
            
            else{
                Node previousNode = list;
                while(previousNode != null && previousNode.getLink() != currentNode) {
                    previousNode = previousNode.getLink();
                }
                previousNode.setLink(currentNode.getLink());
                //removed = true;
            }
            removed = true;
        }
        return removed;
    }
    
    private class Node extends Object {
        
        private D data;
        private Node link;
        
        //constructor
        public Node(D newData) {
            super();
            data = newData;
            link = null;
        }
        
        
        public void setData(D newData) {
            data = newData;
        }
        
        public D getData() {
            return data;
        }
        
        public void setLink(Node otherNode) {
            this.link = otherNode;
        }
        
        public Node getLink() {
            return link;
        }
    }
    
     private Node locate(D item) {
        boolean found = false;
        Node currentNode = list;
        while(!found && currentNode != null){
            if(currentNode.getData().equals(item)){
                found = true;
            }
            else {
                currentNode = currentNode.getLink();
            }
        }
        return currentNode;
    }
    
    public D getItem(D item) { 
        Node locatedNode = locate(item);
        
        if (locate(item) != null) {  
            return locatedNode.getData();
            }
            else{
                return null;
            }
    }
    
    public boolean login(String username, String password) {
        boolean areTheyEqual = false;
    
        Node currentNode = list;  
    
        while (currentNode != null) { 
            //Student s = (Student)currentNode.getData();
            Loginable s = (Loginable)currentNode.getData();
            
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                areTheyEqual = true;  
            }
    
            currentNode = currentNode.getLink(); 
        }
    
        return areTheyEqual;
    }
    
    

}