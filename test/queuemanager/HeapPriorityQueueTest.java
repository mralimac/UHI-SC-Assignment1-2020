/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mralimac
 */
public class HeapPriorityQueueTest {
    
    private HeapPriorityQueue<Person> queue;
    
    public HeapPriorityQueueTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of head method, of class HeapPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        this.queue = new HeapPriorityQueue<Person>(5);
        this.queue.add(new Person("Four"), 4);
        this.queue.add(new Person("Seven"), 7);
        this.queue.add(new Person("Five"), 5);
        this.queue.add(new Person("Two"), 2);
        
        
        String expectedResult = "Seven";
        String actualResult = this.queue.head().getName();
        
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of add method, of class HeapPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        this.queue = new HeapPriorityQueue<Person>(5); 
        this.queue.add(new Person("Four"), 4);
        this.queue.add(new Person("Five"), 5);
        boolean actualResult = this.queue.isEmpty();
        
        boolean expectedResult = false;        
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of remove method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
       this.queue = new HeapPriorityQueue<Person>(5);
       this.queue.add(new Person("Four"), 4);
       this.queue.add(new Person("Six"), 6);
       this.queue.add(new Person("Nine"), 9);
       this.queue.add(new Person("Three"), 3);
       this.queue.remove();
       
       String actualResult = this.queue.toString();

       String expectedResult = "[(Nine, 9), (Four, 4), (Three, 3)]";        
       assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        this.queue = new HeapPriorityQueue<Person>(5); 
        boolean actualResult = this.queue.isEmpty();
        
        boolean expectedResult = true;
        
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of toString method, of class HeapPriorityQueue.
     */
    @Test
    public void testToString() throws Exception {
       this.queue = new HeapPriorityQueue<Person>(5); 
       this.queue.add(new Person("Four"), 4);
       this.queue.add(new Person("Five"), 5);
       String actualResult = this.queue.toString();
       String expectedResult = "[(Five, 5), (Four, 4)]";
       assertEquals(expectedResult, actualResult);
    }
    
}
