/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.util.LinkedList;

/**
 *
 * @author mralimac
 */
public class UnsortedLinkedPriorityQueue <T> implements PriorityQueue<T>
{
    
    //The array that'll contain the data
    private final LinkedList storage;
    private ListNode<T> head;
    
    public UnsortedLinkedPriorityQueue(int size)
    {
       head = null;
       storage = new LinkedList<>();
       
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
       
       for(ListNode<T> node = head; node != null; node = node.getNext())
        { 
            if(node.getPriority() > currentHighestPriority)
            {
               currentHighestPriority = node.getPriority();
            }
        }
       
       
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
            result = result + node.getItem();
        }
        result = result + "]";
        return result;
    }
    
}

