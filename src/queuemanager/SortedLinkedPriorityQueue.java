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
    private final LinkedList<T> storage;
    
    //How large the array is
    private final int capacity;
    
    //Current index of the array
    private int tailIndex;
    
    
    
    public SortedLinkedPriorityQueue(int size)
    {
       storage = new LinkedList<>();
       capacity = size;
       tailIndex = -1;
    }
    
    @Override
    public T head() throws QueueUnderflowException
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException();
        }else{
            return storage.getFirst();
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException
    {
        tailIndex++;
        if(tailIndex >= capacity)
        {
            tailIndex--;
            throw new QueueOverflowException();
        }else{
           int i = tailIndex;
           
            
            
           storage.add(item);
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
                storage[i] = storage[i + 1];
            }
            tailIndex--;
        }
    }
    
    @Override
    public boolean isEmpty()
    {
        return tailIndex < 0;
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
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}

