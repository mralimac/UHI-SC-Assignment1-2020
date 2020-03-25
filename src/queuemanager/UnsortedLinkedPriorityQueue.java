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
    
    //How large the array is
    //private final int capacity;
    
    //Current index of the array
    private int tailIndex;
    
    
    
    public UnsortedLinkedPriorityQueue(int size)
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
        tailIndex++;
        storage.add(new PriorityItem<>(item, priority));
        
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException();
        }else{
           
           storage.remove(storage.getFirst()); 
            
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

