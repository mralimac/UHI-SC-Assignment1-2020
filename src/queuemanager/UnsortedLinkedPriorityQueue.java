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
public class UnsortedLinkedPriorityQueue <T> implements PriorityQueue<T>
{
    
    //The array that'll contain the data
    
    private ListNode<T> head;
    
    public UnsortedLinkedPriorityQueue(int size)
    {
       head = null;
       
    }
    
    @Override
    public T head() throws QueueUnderflowException
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException();
        }
        return head.getItem();
    }
    
    @Override
    public void add(T item, int priority)
    {
        head = new ListNode<>(item, priority, head);
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
       if(isEmpty())
        {
          throw new QueueUnderflowException();
        }
       
       int currentHighestPriority = 0;
       
       ListNode<T> savedNode = null;
       
       for(ListNode<T> node = head; node != null; node = node.getNext())
        { 
            if(node.getPriority() >= currentHighestPriority)
            {
               currentHighestPriority = node.getPriority();
               savedNode = node;
            }
        }
       savedNode.setNext(savedNode);
       
       //Override the previous node with the next node around the removed object
       
       //previousNode.setNext(node.getNext());
    }
    
    
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }
    
    @Override
    public String toString()
    {
        String result = "[";
        for(ListNode<T> node = head; node != null; node = node.getNext())
        {
            if(node != head)
            {
                result = result + ", ";
            }
            result = result + "(" +  node.getItem() + ", "+ node.getPriority() +")";
        }
        result = result + "]";
        return result;
    }
    
}

