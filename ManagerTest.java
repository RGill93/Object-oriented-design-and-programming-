package itemTest;
import itemSrc.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ManagerTest 
{
	
/**
 * The Manager class is fully implemented 
 * You're to write JUnit tests for it. 
 * This is likely to be possible after implementing 
 * the other classes
 */
	
	@Test
	public void testManager() 
	{
		
		Manager m = new Manager();
		QueueOfCusts Qcusts = new QueueOfCusts();
		JacketMap allJackets = new JacketMap();
		assertTrue(Qcusts.getNumQueueing() == 0);
		assertTrue(allJackets.getNumberOfEntries() == 0);
	}

	
	// check if the queue that was created has 6 items
	@Test
	public void testInitialiseData() 
	{
		Manager m = new Manager();
		m.initialiseData();
		assertTrue(m.getCusts().getNumQueueing() == 6);
	}

	@Test
	public void testInitialiseWorkers()
	{
		Manager m = new Manager();
		m.initialiseData();
		assertTrue(m.getCusts().getNumberOfEntries() == 30);
	}

	// checks if there is a customer file to read
	@Test
	public void testReadCustFile() 
	{
		Manager m = new Manager();
		assertNotNull(m.getCustFile());
	}

	// checks if there is a parcel file to read
	@Test
	public void testReadParcelFile() 
	{
		Manager m = new Manager();
		assertNotNull(m.getParcelFile());
	}

}
