package itemSrc;

/*
 * created on 15/11/2017
 * 
 * a class about the jacket class that i have to implement
 * i have initialized all the of the instance variables#
 * An id to check the customer id using an int and not a String
 * The size, colour, price, the brand and whether or not the customer has collected it
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
	
	public boolean isCollected() 
	{
		return collected;
	}

	public void setCollected(boolean collected) 
	{
		this.collected = collected;
	}
	
	public String getId() 
	{		
		return id;		
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
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
	public int compareTo(Jacket otherDetails) 
	{
		return brand.compareTo(otherDetails.getBrand());
		
	}

	
	

}
