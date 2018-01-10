package itemTest;

import itemSrc.JacketMap;

import itemSrc.Jacket;

import static org.junit.Assert.*;

import org.junit.Test;

public class JacketMapTest {

	JacketMap jacketList;

	@Test
	public void testJacketMap() 
	{
		// check that jacketmap is empty
		jacketList = new JacketMap();		
		assertFalse(jacketList.hasJacket() == true);		
		
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		
		jacketList.addDetails(j.getId(), j);
		assertEquals(jacketList.findJacket("jx21"), j);	
		
		// check that there is 1 jacket in
		assertTrue(jacketList.hasJacket() == true);		
		jacketList.addDetails(j2.getId(), j2);
		
		//check theres 2 
		assertEquals(jacketList.findJacket("lt64s"), j2);	
		assertTrue(jacketList.getNumberOfEntries() == 2);	
		
	}

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

