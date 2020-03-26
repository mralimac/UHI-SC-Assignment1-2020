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
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T>
{
    private ListNode<T> head;
    
    public SortedLinkedPriorityQueue(int size)
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
        
        ListNode<T> headNode = null;
        int highestPriority = 0;
        
        for(ListNode<T> node = head; node != null; node = node.getNext())
        {
            if(node.getPriority() > highestPriority)
            {
                highestPriority = node.getPriority();
                headNode = node;
            }
        }
        
        return headNode.getItem();
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
                if(node.getPriority() > priority)
                {
                   previousNode = node;
                }
                
            }
            previousNode.setNext(new ListNode<>(item, priority, null));
        }
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
            result = result + "(" +  node.getItem() + ", "+ node.getPriority() +")";
        }
        result = result + "]";
        return result;
    }
    
}

