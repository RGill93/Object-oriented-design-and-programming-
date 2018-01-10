package itemTest;

import static org.junit.Assert.*;

import itemSrc.Jacket;

import org.junit.Test;



public class jacketTest 
{
	
	Jacket j;
	
	@Test
	public void testgetSize()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getSize() == 30.0);
	}
	
	@Test
	public void testColour()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getColour() == "Black");
	}
	
	@Test
	public void testPrice()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getPrice() == 25.00);
	}
	
	@Test
	public void testBrand()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getBrand() == "Addidas");
	}
	
	@Test
	public void testID()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getId() == "lt64s");
	}

}
