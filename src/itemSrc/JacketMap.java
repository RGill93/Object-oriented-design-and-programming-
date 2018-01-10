package itemSrc;

import java.util.Iterator;

import java.util.LinkedList;

import java.util.TreeMap;

import java.util.HashMap;

public class JacketMap
{	
	/*
	 * storing the details of my jacket class as a map
	 * 
	 */	
	private TreeMap <String, Jacket>allJackets;	
	
	//creating a new TreeMap to store the id as a string to get mapped to a jacket object
	public JacketMap()
	{		
		allJackets = new TreeMap<String, Jacket>();		 
	}	 
	/**
	 * check whether there are any items and if they have been added to the TreeMap
	 * @param id and the jacket reference "aJacket"
	 */
	
	public void addDetails(String id, Jacket aJacket)   
	{
		allJackets.put(id, aJacket);
	}	 
	
	/**
	 * checks if the customer has there item
	 * @return false if empty
	 * else true
	 */
	public boolean hasJacket()							
	{
		if(allJackets.isEmpty())
		{
			return false;
		} 
		else
		{
			return true;
		}
	} 	
	/**
	 *  a method to determine how many items are in the collection
	 *  @return the number of items if any
	 */
	public int getNumberOfEntries()
	{
		return allJackets.size();
	}	 
	 
	/**
	 * a method to check whether all the parcels have been collected
	 * @return true if all collected, else false
	 */
	public boolean allGone()
	{
		boolean collected = true;
		
		for(Jacket aJacket : allJackets.values())
		{
			if(aJacket.isCollected() == false)
			{
				collected = false;
			}				
		}	
		
		return collected;		
	}	
	/**
	 * a method to obtain all parcel in the collection
	 * add them to a string buffer
	 * @return the content of the string buffer
	 */
	public String listDetails()
	{		
		StringBuffer stringBuffer = new StringBuffer();
		
		for(Jacket aJacket : allJackets.values())
		{
			stringBuffer.append(aJacket.toString());
		}
		
			return stringBuffer.toString();
	}
	/**
	 * a method to mark the jacket as collected
	 */
	public void setCollected(Jacket j)
	{
		j.setCollected(true);
	}
	/**
	 * a method to check if the package has been collected
	 * @param Jacket j (j is a reference to jacket)
	 * if the item is collected
	 * @return true
	 * else false
	 */
	public boolean getCollected(Jacket j)
	{
		if(j.isCollected() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * a method that lists the uncollected jackets
	 * @return the string content of the uncollected ones
	 */
	public String listUncollected()
	{
		StringBuffer sb = new StringBuffer();
		for(Jacket aJacket : allJackets.values())
		{
			if(aJacket.isCollected() == true)
			sb.append(aJacket.getId());
		}
		
		return sb.toString();
	}
	/**
	 * a method for finding the parcel who id is known
	 * @param id - the jackets id
	 * @return - the parcel matching the id
	 */
	public Jacket findJacket(String id)
	{
		return allJackets.get(id);
	}
	
	
}
