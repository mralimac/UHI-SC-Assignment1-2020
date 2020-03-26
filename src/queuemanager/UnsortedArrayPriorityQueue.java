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
public class UnsortedArrayPriorityQueue <T> implements PriorityQueue<T>
{
    
    //The array that'll contain the data
    private final Object[] storage;
    
    //How large the array is
    private final int capacity;
    
    //Current index of the array
    private int tailIndex;
    
    
    
    public UnsortedArrayPriorityQueue(int size)
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
            int indexToReturn = 0;
            int highestPriority = 0;
            for(int i = 1; i < tailIndex; i++)
            {
                if(((PriorityItem<T>) storage[i - 1]).getPriority() < highestPriority)
                {
                    highestPriority = ((PriorityItem<T>) storage[i - 1]).getPriority();
                    indexToReturn = i;
                }
            }
            return ((PriorityItem<T>) storage[indexToReturn]).getItem();
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
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException();
        }else{
            int indexToRemove = 0;
            int highestPriority = 0;
            for(int i = 0; i < tailIndex; i++)
            {
                if(((PriorityItem<T>) storage[i]).getPriority() > highestPriority)
                {
                    highestPriority = ((PriorityItem<T>) storage[i]).getPriority();
                    indexToRemove = i;
                }
            }          
            
            for(int j = indexToRemove; j < tailIndex; j++)
            {
                storage[j + 1] = storage[j];
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
