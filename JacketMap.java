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
	
	public JacketMap()
	{		
		allJackets = new TreeMap<String, Jacket>();		 //creating a new TreeMap to store the id as a string to get mapped to a jacket object
	}		
	 	
	public void addDetails(String id, Jacket aJacket)   //checks whether there are any items and if they have been added to the treemap
	{
		allJackets.put(id, aJacket);
	}	 
	public boolean hasJacket()							//checks whether the item has been collected
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
	public int getNumberOfEntries()	//a method to check where the jackets have been collected
	{
		return allJackets.size();
	}	 
	 
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
	public String listDetails()
	{		
		StringBuffer stringBuffer = new StringBuffer();
		
		for(Jacket aJacket : allJackets.values())
		{
			stringBuffer.append(aJacket.toString());
		}
		
			return stringBuffer.toString();
	}
	public void setCollected(Jacket j)
	{
		j.setCollected(true);
	}
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
	public Jacket findJacket(String id)
	{
		return allJackets.get(id);
	}
	
	
}
