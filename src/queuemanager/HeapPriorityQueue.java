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
    
    public int getParentIndex(int childIndex)
    {
        return (int) Math.floor(childIndex/2);
    }
    
    public int swap(int source, int target)
    {
        Object tempObject = storage[target];
        storage[target] = storage[source];
        storage[source] = tempObject;
        System.out.println(toString());
        return target;
    }
    
    public boolean isSwapNeeded(int childIndex)
    {
        if(((PriorityItem<T>) storage[getParentIndex(childIndex)]).getPriority() > ((PriorityItem<T>) storage[childIndex]).getPriority()){
            return false;
        }
        if(((PriorityItem<T>) storage[childIndex]) == null){
            return false;
        }
        
        if(((PriorityItem<T>) storage[getParentIndex(childIndex)]) == null){
            return false;
        }
        return true;
        
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

            while(isSwapNeeded(childIndex)){
                //get parent index, then child index. and swap them
                
                childIndex = swap(childIndex, getParentIndex(childIndex));
            }
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
       //Remove the number at index zero then cycle through the heap using the methods until heap is achieved
       //Need to find the lowest value
        
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
                result = result +" , ";
            }
            result = result + i + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
