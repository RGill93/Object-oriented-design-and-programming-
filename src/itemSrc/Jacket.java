package itemSrc;

/**
 * created on 15/11/2017
 * 
 * a class about the jacket class that i have to implement
 * i have initialized all the of the instance variables#
 * An id to check the customer id using an int and not a String
 * The size, colour, price, the brand and whether or not the customer has collected it
 * 
 * Javadoc comments 10/01/2018
 * 
 * This is my jacket class provided to me by John
 * in this class i have implemented it with the <Jacket> map class since it uses it
 * i have then given it some attributes
 * @param - id, colour, price, brand, collected (if the parcel has been collected by the customer)and size  
 * all the getters and setters have been implemented
 * @return the id, colour, price, brand, collected and size
 * uses the "this." specifier so that the values aren't
 * set in stone, so basically these values are subject to change and can be used in many ways
 * for the data storage implementation
 * @see JacketMap class
 * 
 */

public class Jacket implements Comparable <Jacket>
{
	
	private double size;
	private String colour;
	private double price;
	private String brand;
	private String id;
	private boolean collected = false;
	
	public Jacket(String id, String colour, double price, String brand, boolean collected, double size)
	{
		this.id = id;
		this.colour = colour;
		this.price = price;
		this.brand = brand;
		this.collected = collected;
		this.size = size;		
	}
	
	public double getSize() 
	{
		return size;
	}
	
	public void setSize(double size) 
	{
		this.size = size;
	}
	
	public String getColour() 
	{
		return colour;
	}
	
	public void setColour(String colour) 
	{
		this.colour = colour;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public String getBrand() 
	{
		return brand;
	}
	
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}	
	
	public String getId() 
	{		
		return id;		
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public boolean isCollected() 
	{
		return collected;
	}

	public void setCollected(boolean collected) 
	{
		this.collected = collected;
	}
	
	/**
	 * Test for content equality between two objects
	 * @param other object to compare to this one
	 * @return true if the argument has the same id 
	 */
	public boolean equals(Object other)
    {
       
    	if(other instanceof Jacket)
    	{
            Jacket otherItem = (Jacket) other;
            return brand.equals(otherItem.getBrand());       
            
    	}    	
        else
        {
            return false;
        }
    }
	
	/**
	 * compare this object against another, for the purpose of sorting
	 * @param otherDetails - the object to be compared against
	 * @return a negative integer if this id comes before the paramter's id
	 * zero if they are equal and positive if this comes after the other
	 */
	public int compareTo(Jacket otherDetails) 
	{
		return brand.compareTo(otherDetails.getBrand());		
	}
	
	/**
	 * return appropriate details of the jacket and an informative message
	 * e.g. Jacket id, color, price, brand, if its been collected and the size
	 * 
	 */
	@Override
	public String toString()
	{		
		return "Jacket [id=" + this.id + ", color=" + this.colour + ", price=" + this.price + ", brand=" + this.brand + 
				", collected:" + this.collected + ", size=" + this.size + "].";
	}


	
	

}
