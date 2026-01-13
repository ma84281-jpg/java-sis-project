
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree<E extends Comparable> extends Object implements TreeInterface<E>
{
    private TreeNode<E> root;
    private boolean found;
    
    public Tree(){
        super();
        root = null;
    }
    
    public void add(E item){
        root = recursiveAdd(root,item);
    }
    
    private TreeNode<E> recursiveAdd(TreeNode<E> currentNode, E item){
        if (currentNode == null){
            currentNode = new TreeNode(item);
        }
        
        else if (item.compareTo(currentNode.getData()) > 0){
            currentNode.setRight(recursiveAdd(currentNode.getRight(), item));
        }
        
        else if (item.compareTo(currentNode.getData()) < 0){
            currentNode.setLeft(recursiveAdd(currentNode.getLeft(), item));
        }
        
        return currentNode;
    }
    
    public boolean find(E item){
        return recursiveFind(root , item);
    }
    
    private boolean recursiveFind(TreeNode<E> currentNode , E item){
        if (currentNode == null){
            return false;
        }
        
        else if (item.compareTo(currentNode.getData()) > 0){
            return recursiveFind(currentNode.getRight(), item);
        }
        
        else if (item.compareTo(currentNode.getData()) < 0){
            return recursiveFind(currentNode.getLeft(), item);
        }
        
        else{
            return true;
        }
        //return currentNode;
    }
    
    public  boolean remove(E item) {
        found = false;
        root = recursiveRemove(root,item);
        
        return found;
        
    }
    
    private TreeNode<E> recursiveRemove(TreeNode<E> currentNode , E item){
        if (currentNode == null){
            found = false;
        }
        else if(item.compareTo(currentNode.getData()) > 0){
            currentNode.setRight(recursiveRemove(currentNode.getRight(), item));
        }
        
        else if (item.compareTo(currentNode.getData()) < 0){
            currentNode.setLeft(recursiveRemove(currentNode.getLeft(), item));
        } 
        else{
            currentNode = removeNode(currentNode);
            
        }
        
        return currentNode;
    }
    
    private TreeNode<E> removeNode(TreeNode<E> currentNode){
        if (currentNode.getRight() == null && currentNode.getLeft() == null){
            return null;
        }
        else if(currentNode.getRight() == null){
            return currentNode.getLeft();
        }
        
        else if (currentNode.getLeft() == null){
            return currentNode.getRight();
        }
        
        else{
            E data = getPredecessor(currentNode.getLeft());
            currentNode.setData(data);
            currentNode.setLeft(recursiveRemove(currentNode.getLeft(), data));
            return currentNode;
        }
    }
    
    private E getPredecessor(TreeNode<E> currentNode){
        while(currentNode.getRight() != null){
            currentNode = currentNode.getRight();
        }
        
        return currentNode.getData();
    }
}