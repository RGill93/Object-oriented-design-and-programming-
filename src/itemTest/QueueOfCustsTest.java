package itemTest;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;

public class QueueOfCustsTest {
	
	QueueOfCusts qOfCusts;
	/**
	 * Tests whether the queueing number of the customer 
	 * is 0 
	 * @see QueueOfCusts
	 */
	@Test
	public void testQueueOfCusts() 
	{
		 qOfCusts = new QueueOfCusts();
		 assertTrue(qOfCusts.getNumQueueing() == 0);
	}
/**
 * A test to see if the details that match 
 * have been added to the queue 
 * @see QueueOfCusts
 */
	@Test
	public void testAddDetails() 
	{
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		assertSame(qOfCusts.get(0),cinqueue);
	
	}
/**
 * a test to show that the count of customers 
 * changes when a customer is added to the queue
 * @see QueueOfCusts
 */
	@Test
	public void testGetNumberOfEntries() 
	{
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		assertTrue(qOfCusts.getNumberOfEntries() == 1);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		assertTrue(qOfCusts.getNumberOfEntries() == 2);
	}
/**
 * a test method to check how many customers
 * have been added to the queue
 * @see QueueOfCusts
 */
	@Test
	public void testGetNumQueueing() 
	{
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing() == 1);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing() == 2);
		
	}
/**
 * a method to test that a customer in a 
 * specific location in the collection can be obtained 
 * @see QueueOfCusts
 */
	@Test
	public void testGet() 
	{
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertSame(qOfCusts.get(0),cinqueue);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.get(1),cinqueue2);
		
	}
/**
 * a method to test that you can find 
 * the next customer in the queue. 
 * @see QueueOfCusts
 */
	@Test
	public void testGetNext() 
	{
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertSame(qOfCusts.getNext(), cinqueue);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "px335");
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.getNext(),cinqueue2);
	}

	/**
	 * A method that uses the string override function
	 * to test that the customer matches is added
	 * to the queue. 
	 * @see QueueOfCusts
	 */
	@Test
	public void testGetQueueString() 
	{
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();		
		System.out.println(qOfCusts.getQueueString());
		assertEquals("CustInQueue [name=Andrew, pId=px34, qNum=0queueing :  true)" + '\n', qOfCusts.getQueueString());		
	}
/**
 * tests if the customer has been added to the queue
 * adds the details and checks if there queueing number matches 
 * @see QueueOfCusts
 */
	@Test
	public void testAddToQueue() 
	{
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing() > 0);			
	}

}
