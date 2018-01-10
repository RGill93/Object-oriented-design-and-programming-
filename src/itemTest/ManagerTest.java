package itemTest;
import itemSrc.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class ManagerTest 
{
	
	Worker wareHouseWorker;
	
/**
 * The Manager class is fully implemented 
 * You're to write JUnit tests for it. 
 * This is likely to be possible after implementing 
 * the other classes
 * @see Manager
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

	
	/**
	 * checks that queue created has 6 items in it
	 * @see Manager
	 */
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
		m.initialiseWorkers();
		assertEquals(m.getCusts().getNumberOfEntries() == 30, false);
	}

	/**
	 * checks if there is a customer file to read
	 * if it does
	 * @return the file being read
	 * else null
	 * @see Manager
	 */
	@Test
	public void testReadCustsFile() 
	{
		Manager m = new Manager();	
		
		QueueOfCusts Qcusts = new QueueOfCusts();
		JacketMap allJackets = new JacketMap();		
		assertNotNull(m.getCustsFile());
	}

	/**
	 * checks if there is a parcel file to read
	 * if it does
	 * @return the file being read
	 * else null
	 * @see Manager
	 */
	@Test
	public void testReadParcelFile() 
	{
		Manager m = new Manager();
		assertNotNull(m.getParcelFile());
	}

}
