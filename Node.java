/**
 * @authors Christopher Bergsveinsson,
 * @version 11/6/2025
 * CSC 223 - Anwar Ahmad
 * Every Tuesday and  Thursday 9:35am → 11:35am
 * Programming Project - College Management System - Node Class
 */

public class Node<E>
{

    private E data;
    private Node<E> link;

    public Node(E newData) {
        data = newData;
        link = null;
    }

    public void setData(E newData) {
        data = newData;
    }
    public E getData() {
        return data;
    }
    public void setLink(Node<E> otherNode) {
        this.link = otherNode;
    }
    public Node<E> getLink() {
        return link;
    }
}
