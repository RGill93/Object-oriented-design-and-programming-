package itemTest;

import itemSrc.JacketMap;

import itemSrc.Jacket;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * this is the JUnit test for my map class
 * i have implemented all the test
 * i have added additional comments above each test
 * @see JacketMap class
 */
public class JacketMapTest
{

	JacketMap jacketList;

	/**
	 * check that the jacket map is empty
	 * initially it is
	 * then it checks that theres one jacket in there, then 2
	 * @see JacketMap class
	 */
	@Test
	public void testJacketMap() 
	{
		
		jacketList = new JacketMap();		
		assertFalse(jacketList.hasJacket() == true);		
		
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		
		jacketList.addDetails(j.getId(), j);
		assertEquals(jacketList.findJacket("jx21"), j);			
		
		assertTrue(jacketList.hasJacket() == true);		
		jacketList.addDetails(j2.getId(), j2);		
		
		assertEquals(jacketList.findJacket("lt64s"), j2);	
		assertTrue(jacketList.getNumberOfEntries() == 2);	
		
	}

	/**
	 * creates a jacketMap object, assigns values
	 * add the details and gets the id 
	 * it then checks the number of number of entries
	 * @see JacketMap class
	 */
	@Test
	public void testAddDetails() 
	{
		jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);		
		
		jacketList.addDetails(j.getId(), j);		
		assertTrue(jacketList.getNumberOfEntries() == 1);
		
		jacketList.addDetails(j2.getId(), j2);	
		assertTrue(jacketList.getNumberOfEntries() == 2);		
	}

	/**
	 * this method tests whether the parcel has been collected by the customer
	 * it will first add the details taken from the jacket map object
	 * checks if the item has been collected
	 * @see JacketMap class
	 */
	@Test
	public void testHasParcel() 
	{
		jacketList = new JacketMap();
		assertFalse(jacketList.hasJacket() == true);
		
		Jacket j = new Jacket("jx21","Blue",45.0, "Nike",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
		jacketList.addDetails(j.getId(), j);
		assertTrue(jacketList.hasJacket() == true);
		
		jacketList.addDetails(j2.getId(), j2);		
		assertTrue(jacketList.hasJacket() == true);
	}

	/**
	 * this method checks the number of entries in the map
	 * creates the map object
	 * add the contents and the details
	 * checks if the number of entries is greather than 0
	 * and equal to 2
	 * @see JacketMap class
	 */
	@Test
	public void testGetNumberOfEntries()
	{
		jacketList = new JacketMap();	
				
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
		jacketList.addDetails(j.getId(), j);
		assertTrue(jacketList.getNumberOfEntries() > 0);
		
		jacketList.addDetails(j2.getId(), j2);
		assertTrue(jacketList.getNumberOfEntries() == 2);
	}

	/**
	 * a method to test if all the the items have gone
	 * initially the allGone() function 
	 * if true 
	 * @return true
	 * else false. in the test i have tested both against false
	 * @see JacketMap class
	 */
	@Test
	public void testAllGone() 
	{
		jacketList = new JacketMap();
		assertTrue(jacketList.allGone() == true);
		
		Jacket j = new Jacket("jx21","Blue",45.0, "Nike",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
		jacketList.addDetails(j.getId(), j);
		jacketList.setCollected(j);	
		assertFalse(jacketList.allGone() == false);		
		
		jacketList.addDetails(j2.getId(), j2);
		jacketList.setCollected(j2);
		assertFalse(jacketList.allGone() == false);		
		
	}

	/**
	 * test the details list
	 * creates a map object and adds it contents
	 * adds the id to the details
	 * checks how many items there are in the map
	 * the lenght of the two im using is 16
	 * @see JacketMap class
	 */
	@Test
	public void testListDetails() 
	{
		jacketList = new JacketMap();
		
		Jacket j = new Jacket("jx21","Blue",45.0, "Addidas",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
		jacketList.addDetails(j.getId(), j);
		jacketList.addDetails(j2.getId(), j2);		
		
		
		String details [] = jacketList.listDetails().split(",|\\.");
		System.out.println(jacketList.listDetails());
		System.out.println(details.length);
		
		assertTrue(details.length == 16);
	}

	/**
	 * this method checks the status of the collected item
	 * @see JacketMap class 
	 */
	@Test
	public void testSetCollected() 
	{
		jacketList = new JacketMap();
		
		Jacket j = new Jacket("jx21","Blue",45.0, "Addidas",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
		jacketList.addDetails(j.getId(), j);
		jacketList.setCollected(j);
		assertTrue(jacketList.hasJacket() == true);	
		
		jacketList.addDetails(j2.getId(), j2);
		jacketList.setCollected(j2);
		assertFalse(jacketList.allGone() == false);		
		
	}

	/**
	 * this checks the items that are uncollected
	 * i have tested it against two different maps
	 * j and j2
	 * @see JacketMap class
	 */
	@Test
	public void testListUncollected() 
	{
		jacketList = new JacketMap();	
		
		Jacket j = new Jacket("jx21","Blue",45.0, "Addidas",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
			
		jacketList.addDetails(j.getId(), j);
		jacketList.setCollected(j);
		assertTrue(jacketList.findJacket("jx21").isCollected() == true);	
		
		
		jacketList.addDetails(j2.getId(), j2);		
		jacketList.setCollected(j2);
		assertFalse(jacketList.findJacket("lt64s").isCollected() == false);
		
	}

	/**
	 * this method tests if the jacket has been found
	 * @return the id
	 * @see JacketMap class
	 */
	@Test
	public void testFindJacket() 
	{
		jacketList = new JacketMap();
		
		Jacket j = new Jacket("jx21","Blue",45.0, "Addidas",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		
		jacketList.addDetails(j.getId(), j);
		assertEquals(jacketList.findJacket("jx21"), j);
		
		jacketList.addDetails(j2.getId(), j2);
		assertEquals(jacketList.findJacket("lt64s"), j2);	
		
	}

}

