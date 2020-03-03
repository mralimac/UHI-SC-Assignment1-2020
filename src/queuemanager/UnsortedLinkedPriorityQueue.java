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
    private final Object[] storage;
    
    //How large the array is
    private final int capacity;
    
    //Current index of the array
    private int tailIndex;
    
    
    
    public UnsortedLinkedPriorityQueue(int size)
    {
       storage = new Object[size];
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
            return ((PriorityItem<T>) storage[0]).getItem();
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
            while(i > 0 && ((PriorityItem<T>) storage[i - 1]).getPriority() < priority)
            {
                storage[i] = storage[i - 1];
                i--;
            }
            storage[i] = new PriorityItem<>(item, priority);
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
