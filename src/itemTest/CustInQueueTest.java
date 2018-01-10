package itemTest;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;
/**
 *  a JUnit test class for the CustInQueue class
 * @author John Kanyaru
 *
 */
public class CustInQueueTest {

	/**
	 * the constructor is tested below
	 * it first assigns two string in a new object
	 * then it checks of the name and the id are the same
	 * @see CustInQueue
	 */
	@Test
	public void testCustInQueue() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		assertSame(cinqueue.getName(),"Andrew");
		assertEquals(cinqueue.getpId(),"px34");
		
	}

	/**
	 * this method test the name given
	 * it assigns two names to the object 
	 * i have gave assigned andrew to the get name
	 * @see CustInQueue
	 */
	@Test
	public void testGetName() 
	{
		CustInQueue c1 = new CustInQueue("Andrew", "px34");
		assertSame(c1.getName(),"Andrew");
		c1.setName("Meg");
		assertSame(c1.getName(),"Meg");			
	}
	
	/**
	 * this tests whether the value of the name changes 
	 * if you test with the old name Andrew, it will fail the test
	 * this was not changed in the setName method
	 * @see CustInQueue
	 */
	@Test
	public void testSetName() 
	{
		CustInQueue cinqueue = new CustInQueue("Meg", "px34");
		cinqueue.setName("Maggie");
		assertSame(cinqueue.getName(),"Maggie"); 
		assertEquals(cinqueue.getpId(),"px34");
		
	}

	/**
	 * this tests whether the value of the name changes
	 * i have set the getId() method to a string "px34"
	 * @see CustInQueue
	 */
	@Test
	public void testGetpId() 
	{
		CustInQueue cinqueue = new CustInQueue("Meg", "px34");
		cinqueue.getpId();	
		assertSame(cinqueue.getpId(), "px34");		
	}

	/**
	 * this test if the name that was used in the 
	 * getId() function matches
	 * because its a get function and not a set the value can be 
	 * changed and will still succeed
	 * @see CustInQueue
	 */
	@Test
	public void testSetpId() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "pt35");
	    cinqueue.setpId("pt35");
		assertEquals(cinqueue.getpId(),"pt35");
	}

	/**
	 * this test the queue number of the customer
	 * the number has been set to 1
	 * so when u get the value it will be 1
	 * @see CustInQueue
	 */
	@Test
	public void testGetqNum() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setqNum(1);
		assertTrue(cinqueue.getqNum() == 1);		
	}

	/**
	 * this tests the setting of the value
	 * the value was set to 1 
	 * so the test succeeds
	 * @see CustInQueue
	 */
	@Test
	public void testSetqNum() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setqNum(1);
		assertTrue(cinqueue.getqNum() == 1);		
	}

	/**
	 * this tests the customer in the queue
	 * i have put andrew in the queue and 
	 * said that it is != false meaning its true
	 * @see CustInQueue
	 */
	@Test
	public void testIsInQueue() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		assertFalse(cinqueue.isInQueue() != false);
	}

	/**
	 * when set it matches the above test and succeeds
	 * @see CustInQueue
	 */
	@Test
	public void testSetInQueue() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setInQueue(true);
		assertFalse(cinqueue.isInQueue() == false);
	}

}
