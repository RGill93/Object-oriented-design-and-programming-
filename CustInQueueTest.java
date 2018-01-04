package itemTest;

import static org.junit.Assert.*;


import org.junit.Test;

import itemSrc.*;
/**
 *  a JUnit test class for the CustInQueue class
 * 
 *
 */
public class CustInQueueTest {

	
	@Test
	public void testCustInQueue() 
	{
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		assertSame(cinqueue.getName(),"Andrew");
		assertEquals(cinqueue.getpId(),"px34");
		
	}

	@Test
	public void testGetName() 
	{
		CustInQueue c1 = new CustInQueue("Andrew", "px34");
		assertSame(c1.getName(),"Andrew");
		c1.setName("Meg");
		assertSame(c1.getName(),"Meg");			
	}
	
	@Test
	public void testSetName() 
	{
		CustInQueue cinqueue = new CustInQueue("Meg", "px34");
		cinqueue.setName("Maggie");
		assertSame(cinqueue.getName(),"Maggie"); //if you test with the old name Andrew, it will fail the test
		assertEquals(cinqueue.getpId(),"px34");//this was not changed in the setName method
		
	}

	@Test
	public void testGetpId() 
	{
		CustInQueue cinqueue = new CustInQueue("Meg", "px34");
		cinqueue.getpId();
		assertSame(cinqueue.getpId(), "px34");		
	}

	@Test
	public void testSetpId() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "pt35");
	    cinqueue.setpId("pt35");
		assertEquals(cinqueue.getpId(),"pt35");
	}

	@Test
	public void testGetqNum() {
		
	}

	@Test
	public void testSetqNum() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setqNum(1);
		assertTrue(cinqueue.getqNum()==1);
		
	}

	@Test
	public void testIsInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		assertFalse(cinqueue.isInQueue()!=false);
	}

	@Test
	public void testSetInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "px34");
		cinqueue.setInQueue(true);
		assertFalse(cinqueue.isInQueue()==false);
	}

}
