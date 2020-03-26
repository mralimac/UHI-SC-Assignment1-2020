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
public class HeapPriorityQueue <T> implements PriorityQueue<T>
{
    private final Object[] storage;
    private final int capacity;
    private int tailIndex;
    
    public HeapPriorityQueue(int size)
    {
       //Heap is an array
       //Position 1 is the root
       //Postition 2 and 3 are the root's children
       //Position 4 and 5 are 2's childrens
       storage = new Object[size];
       capacity = size;
       tailIndex = -1;
       
    }
    
    @Override
    public T head() throws QueueUnderflowException
    {
        return ((PriorityItem<T>) storage[0]).getItem();
    }
    
    public int getLeftChildIndex(int parentIndex)
    {
        return (parentIndex*2);
    }
    
    public int getRightChildIndex(int parentIndex)
    {
        return (parentIndex*2) + 1;
    }
    
    public boolean isChildBigger(int parentIndex)
    {
        if(((PriorityItem<T>) storage[getLeftChildIndex(parentIndex)]).getPriority() > ((PriorityItem<T>) storage[parentIndex]).getPriority())
        {
            return true;
        }
        
        if(((PriorityItem<T>) storage[getRightChildIndex(parentIndex)]).getPriority() > ((PriorityItem<T>) storage[parentIndex]).getPriority())
        {
            return true;
        }
        return false;
    }
    
    public int getParentIndex(int childIndex)
    {
        return (int) Math.floor(childIndex/2);
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException
    {
        tailIndex++;
        if(tailIndex >= capacity)
        {
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        }
        else
        {
             //Add to end of array and keep checking the parents until cycle is achived
            storage[tailIndex] = new PriorityItem(item, priority);
            int childIndex = tailIndex;
            
            while(((PriorityItem<T>) storage[getParentIndex(childIndex)]).getPriority() < ((PriorityItem<T>) storage[childIndex]).getPriority()){
                //get parent index, then child index. and swap them
                
                Object tempObject = storage[getParentIndex(childIndex)];
                storage[getParentIndex(childIndex)] = storage[childIndex];
                storage[childIndex] = tempObject;
                childIndex = getParentIndex(childIndex);
                
            }
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
        storage[1] = storage[tailIndex];
        
        int objectIndex = 1;
        
        while(isChildBigger(objectIndex)){
            
            if(((PriorityItem<T>) storage[getLeftChildIndex(objectIndex)]).getPriority() > ((PriorityItem<T>) storage[objectIndex]).getPriority()){
                
                Object tempObject = storage[getLeftChildIndex(objectIndex)];
                storage[getLeftChildIndex(objectIndex)] = storage[objectIndex];
                storage[objectIndex] = tempObject;
                
            }else if(((PriorityItem<T>) storage[getRightChildIndex(objectIndex)]).getPriority() > ((PriorityItem<T>) storage[objectIndex]).getPriority()){
                
                Object tempObject = storage[getRightChildIndex(objectIndex)];
                storage[getLeftChildIndex(objectIndex)] = storage[objectIndex];
                storage[objectIndex] = tempObject;
            }
            objectIndex = getParentIndex(objectIndex);
        }
        
       //Remove the number at index zero then cycle through the heap using the methods until heap is achieved
       //Need to find the lowest value
        tailIndex--;
    }
    
    @Override
    public boolean isEmpty()
    { 
        return storage[1] == null;
    }
    
    @Override
    public String toString()
    {
        String result = "[";
        for(int i = 0; i <= tailIndex; i++)
        {
            if(i > 0)
            {
                result = result +", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
