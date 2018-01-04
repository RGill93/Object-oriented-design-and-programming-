package itemTest;

import itemSrc.JacketMap;

import itemSrc.Jacket;

import static org.junit.Assert.*;

import org.junit.Test;

public class JacketMapTest {

	JacketMap jacketList;

	@Test
	public void testJacketMap() {
		jacketList = new JacketMap();
		assertFalse(jacketList.hasJacket()==true);
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		jacketList.addDetails(j.getId(), j);
		jacketList.addDetails(j.getId(), j2);
		assertTrue(jacketList.getNumberOfEntries() == true);
		assertEquals(jacketList.findJacket("ntqx"),j2);
	}

	@Test
	public void testAddDetails() {
		jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Blue",45.0, "Nike",false, 50.0);
		jacketList.addDetails(j2);		
		assertTrue(jacketList.getNumberOfEntries() == "jx21");
		jacketList.addDetails(j);
		assertEquals(jacketList.findJacket("lt64s"),j);
		assertTrue(jacketList.getNumberOfEntries() == 2);
	}

	
	@Test
	public void testHasParcel() {
		jacketList = new JacketMap();
		assertTrue(jacketList.hasJacket()==false);
		Jacket j = new Jacket("jx21","Blue",45.0, "Nike",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		assertFalse(jacketList.hasJacket() == false);
		jacketList.addDetails(j);
		assertTrue(jacketList.getNumberOfEntries() == 2);
	}

	@Test
	public void testGetNumberOfEntries() {
		jacketList = new JacketMap();
		assertTrue(jacketList.getNumberOfEntries() == 0);
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		assertTrue(jacketList.getNumberOfEntries() > 0);
		jacketList.addDetails(j);
		assertTrue(jacketList.getNumberOfEntries() == 2);
	}

	@Test
	public void testAllGone() {
		jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Blue",45.0, "Nike",false, 50.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		
		jacketList.setCollected(j2);
		
		assertTrue(jacketList.allGone() == true);
		jacketList.addDetails(j);
		assertFalse(jacketList.allGone() == true);
		
	}

	@Test
	public void testListDetails() {
		jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		String details [] = jacketList.listDetails().split(",");
		assertTrue(details.length == 6);
	}

	@Test
	public void testSetCollected() {
		jacketList = new JacketMap();
		Jacket p = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket p2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		jacketList.addDetails(j);
		jacketList.setCollected(j2);
		assertTrue(jacketList.hasJacket() == true);
		jacketList.setCollected(j);
		assertTrue(jacketList.allGone() == true);
	}

	@Test
	public void testListUncollected() {
		jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		jacketList.addDetails(j);
		jacketList.setCollected(j2);
		
		assertTrue(jacketList.findJacket("ntqx").isCollected(true) == true);
		
	}

	@Test
	public void testFindJacketl() {
		jacketList = new JacketMap();
		Jacket j = new Jacket("jx21","Black",25.0, "Addidas",true, 30.0);
		Jacket j2 = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		jacketList.addDetails(j2);
		jacketList.addDetails(j);
		
		assertNotSame(jacketList.findJacket("ntqx"), j);
		assertEquals(jacketList.findJacket("ntqx"), j2);
	}

}

