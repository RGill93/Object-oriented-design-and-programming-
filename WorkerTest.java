package itemTest;

import static org.junit.Assert.*;

import itemSrc.*;

import org.junit.*;

public class WorkerTest 
{

	Worker wareHouseWorker;
/**
 * This tests the Worker constructor
 * 
 */

	@Test
	public void testWorker()
	{
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing()==0);
		CustInQueue cin = new CustInQueue("Andrew", "jx21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		JacketMap jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);		
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		jacketList.addDetails(j.getId(), j);
		jacketList.addDetails(j.getId(), j2);
		wareHouseWorker = new Worker( qOfCusts, jacketList, 5, 4);
		
		assertTrue(wareHouseWorker.getNum()==4);
		assertEquals(wareHouseWorker.getNext().getName(), "Andrew");
		wareHouseWorker.setClosed();
		assertEquals(wareHouseWorker.getNext().getName(), "Janice");
	}
/*
 * This tests whether the current customer can be obtained
 * 
 */
	@Test
	public void testGetCurrentCust()
	{
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing()==0);
		CustInQueue cin = new CustInQueue("Andrew", "jx21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		JacketMap jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		jacketList.addDetails(j.getId(), j);
		jacketList.addDetails(j.getId(), j2);
		
		wareHouseWorker = new Worker( qOfCusts, jacketList, 5, 4);
		assertEquals(qOfCusts.getNext(),cin);
		wareHouseWorker.setClosed();
		assertEquals(qOfCusts.getNext(),cin2);
	}

/**
 * This has already been tested with the constructor
 * 
 */
	@Test
	public void testGetNum()
	{
		
		QueueOfCusts qOfCusts = new QueueOfCusts();
		
		CustInQueue cin = new CustInQueue("Andrew", "jx21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		JacketMap jacketList = new JacketMap();		
		Jacket j = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);	
		
	}
/**
 * This tests whether a worker has closed processing a customer's job
 * 
 */
	@Test
	public void testGetClosed() 
	{
		QueueOfCusts qOfCusts = new QueueOfCusts();
		
		CustInQueue cin = new CustInQueue("Andrew", "jx21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		JacketMap jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		jacketList.addDetails(j.getId(), j);
		jacketList.addDetails(j.getId(), j2);
		
		wareHouseWorker = new Worker( qOfCusts, jacketList, 5, 4);
		assertEquals(qOfCusts.getNext(),cin);
		wareHouseWorker.setClosed();
		assertFalse(wareHouseWorker.getCurrentCust()==cin);
		assertFalse(wareHouseWorker.getCurrentCust()==cin2);
	}
/**
 * this has been tested alongside the getClosed method
 * 
 */
	@Test
	public void testSetClosed() 
	{
		QueueOfCusts qOfCusts = new QueueOfCusts();
		
		CustInQueue cin = new CustInQueue("Andrew", "jx21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
	}

/**
 * working implementation of this method
 * 
 * 
 */
	@Test
	public void testprocessOneCustomer() 
	{
		QueueOfCusts qOfCusts = new QueueOfCusts();
		
		CustInQueue cin = new CustInQueue("Andrew", "jx21");
		CustInQueue cin2 = new CustInQueue("Janice", "lt64s");
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
	}

}
