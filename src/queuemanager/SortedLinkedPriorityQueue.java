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
public class SortedLinkedPriorityQueue <T> implements PriorityQueue<T>
{
    
    //The array that'll contain the data
    private final LinkedList storage;
    
    //How large the array is
    //private final int capacity;
    
    //Current index of the array
    private int tailIndex;
    
    
    
    public SortedLinkedPriorityQueue(int size)
    {
       storage = new LinkedList<>();
       //capacity = size;
       tailIndex = -1;
    }
    
    @Override
    public T head() throws QueueUnderflowException
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException();
        }else{
            return ((PriorityItem<T>) storage.getFirst()).getItem();
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException
    {

        int i = tailIndex;
        
        if(storage.size() < 1)
        {
            storage.add(new PriorityItem<>(item, priority));
        }
        
        int previousValue = 0;

        for(int j = 0; j < storage.size(); j++ )
        {
            if(priority > ((PriorityItem<T>) storage.get(j)).getPriority() && priority < previousValue)
             {
                tailIndex++;
                storage.add(j, new PriorityItem<>(item, priority));
             }else{
                previousValue = ((PriorityItem<T>) storage.get(j)).getPriority();
            }
        }  
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException();
        }else{
            for(int i = 0; i < tailIndex; i++)
            {
                storage.remove(i);
            }
            tailIndex--;
        }
    }
    
    @Override
    public boolean isEmpty()
    {
        return storage.isEmpty();
    }
    
    @Override
    public String toString()
    {
        String result = "[";
        for(int i = 0; i <= tailIndex; i++)
        {
            if(i > 0)
            {
                result = result + ", ";
            }
            result = result + storage.get(i);
        }
        result = result + "]";
        return result;
    }
    
}

