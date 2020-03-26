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
public class UnsortedArrayPriorityQueueTest {
    
    private UnsortedArrayPriorityQueue<Person> queue;
    
    public UnsortedArrayPriorityQueueTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of head method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        this.queue = new UnsortedArrayPriorityQueue<Person>(5);
        this.queue.add(new Person("Four"), 4);
        this.queue.add(new Person("Seven"), 7);
        this.queue.add(new Person("Five"), 5);
        this.queue.add(new Person("Two"), 2);
        
        
        String expectedResult = "Four";
        String actualResult = this.queue.head().getName();
        
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testAdd() throws Exception {
        this.queue = new UnsortedArrayPriorityQueue<Person>(5); 
        this.queue.add(new Person("Four"), 4);
        this.queue.add(new Person("Five"), 5);
        boolean actualResult = this.queue.isEmpty();
        
        boolean expectedResult = false;        
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
       this.queue = new UnsortedArrayPriorityQueue<Person>(5);
       this.queue.add(new Person("Four"), 4);
       this.queue.add(new Person("Five"), 5);
       this.queue.remove();
       
       String actualResult = this.queue.toString();

       String expectedResult = "[(Four, 4)]";        
       assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        this.queue = new UnsortedArrayPriorityQueue<Person>(5); 
        boolean actualResult = this.queue.isEmpty();
        
        boolean expectedResult = true;
        
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testToString() throws Exception {
       this.queue = new UnsortedArrayPriorityQueue<Person>(5); 
       this.queue.add(new Person("Four"), 4);
       this.queue.add(new Person("Five"), 5);
       String actualResult = this.queue.toString();
       String expectedResult = "[(Four, 4), (Five, 5)]";
       assertEquals(expectedResult, actualResult);
    }
    
}
