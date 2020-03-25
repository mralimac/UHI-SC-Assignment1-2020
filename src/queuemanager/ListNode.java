/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author mralimac
 */
public class ListNode<T> 
{
    private T item;
    private int priority;
    private ListNode<T> next;
    
    public ListNode(T item, int priority, ListNode<T> next)
    {
        this.item = item;
        this.next = next;
        this.priority = priority;
    }
    
    public T getItem()
    {
       return item;
    }
    
    public ListNode<T> getNext()
    {
        return next;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void setNext( ListNode<T> next)
    {
        this.next = next;
    }
}
