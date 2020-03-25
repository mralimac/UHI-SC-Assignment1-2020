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
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>
{
    
    //The array that'll contain the data
    private final LinkedList storage;
    private ListNode<T> head;
    
    public SortedLinkedPriorityQueue(int size)
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
        if(isEmpty()){
            head = new ListNode<>(item, priority, head);
        }else{
            ListNode<T> previousNode = head;
            
            for(ListNode<T> node = head; node != null; node = node.getNext())
            { 
                if(node.getPriority() < priority)
                {
                   previousNode.setNext(new ListNode<>(item, priority, head));
                }
                previousNode = node;
            }
        }
    }
    
    public int size()
    {
        ListNode<T> node = head;
        int result = 0;
        
        while(node != null)
        {
            result = result + 1;
            node = node.getNext();
        }
        return result;
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
       if(isEmpty())
        {
          throw new QueueUnderflowException();
        }
       head = head.getNext();
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

