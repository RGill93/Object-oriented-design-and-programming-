package itemTest;

import static org.junit.Assert.*;

import itemSrc.*;

import org.junit.Test;

/**
 * this class tests my jacket parcel 
 * that was emailed to me by john
 * all the getters and setters have been implemented
 * and the tests succeed
 * below i have added some additional comments
 * @see Jacket
 */

public class jacketTest 
{
	
	Jacket j;
	
	/**
	 * this method test the getSize() function
	 * u have set the size in the constructor as 30.0
	 * and have asserted true that its 30.0
	 * each method has been run against two sets of the same constructor
	 * using different asserts and changing the values
	 * @see Jacket
	 */
	@Test
	public void testgetSize()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getSize() == 30.0);
		
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 50.0);
		assertTrue(j.getSize() != 30.0);
	}
	
	/**
	 * this method tests the testColour() function
	 * the string for the colour has been set to black so the test will succeed
	 * each method has been run against two sets of the same constructor
	 * using different asserts and changing the values
	 * @see Jacket
	 */
	@Test
	public void testColour()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getColour() == "Black");
		
		j = new Jacket("lt64s","Blue",25.0, "Addidas",true, 30.0);
		assertTrue(j.getColour() == "Blue");
	}
	

	/**
	 * this method tests the testPrice() function
	 * the value for the price has been set to 25.0 so the test will succeed
	 * each method has been run against two sets of the same constructor
	 * using different asserts and changing the values
	 * @see Jacket
	 */
	@Test
	public void testPrice()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getPrice() == 25.00);
		
		j = new Jacket("lt64s","Black",55.0, "Addidas",true, 30.0);
		assertTrue(j.getPrice() == 55.00);
	}
	
	/**
	 * this method tests the testBrand() function
	 * the String for the brand has been set to 25.0 so the test will succeed
	 * each method has been run against two sets of the same constructor
	 * using different asserts and changing the values
	 * @see Jacket
	 */
	@Test
	public void testBrand()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getBrand() == "Addidas");
		
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertFalse(j.getBrand() == "Nike");
		
	}
	
	/**
	 * this method tests the testID() function
	 * the String for the brand has been set to "lt64s" so the test will succeed
	 * each method has been run against two sets of the same constructor
	 * using different asserts and changing the values
	 * @see Jacket
	 */
	@Test
	public void testID()
	{
		j = new Jacket("lt64s","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getId() == "lt64s");
		
		j = new Jacket("pt64x","Black",25.0, "Addidas",true, 30.0);
		assertTrue(j.getId() != "lt64s");
	}

}
