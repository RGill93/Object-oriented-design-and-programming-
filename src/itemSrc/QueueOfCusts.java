package itemSrc;

import java.util.LinkedList;

/**
 * this is the map class, its on the of the data structures used in this program
 * in this class i am using my jacket class provided
 * in place of the original parcel map
 * i have added comments above all the function explaining them
 */
public class QueueOfCusts 
{
	/**
	 * Storage for an arbitrary number of details for the customers in queue
	 */	
    private LinkedList <CustInQueue> queue;
    
    /**
     * Initialises the number of customers
     */
    public QueueOfCusts()
    {
    	queue = new LinkedList<CustInQueue>();
    }
   
    /**
     * Adds the customers details to the queue
     * 
     */
    public  void addDetails(CustInQueue details) 
    {
    	queue.add(details);
    }

    /**
     * @return the number of entries currently in the list
     */
    public int getNumberOfEntries()
    {
    	return queue.size();
    }  
    
    /**
     * finds the number of the customers queueing 
     * and what there number is
     * @return the number of queueing customer
     */
    public  int getNumQueueing()    
    {
    	int count = 0;
    	
    	for (CustInQueue cq : queue)
    	{
    		if(cq.isInQueue() == true)
    		{
    			count++;
    		}
    	}    	
    	
    	return count;
    }      
    /**
     * @param (i) which is the location of the
     * customer in the list
     * @return the location
     */
    public CustInQueue get(int i) 
    {    	
    	return queue.get(i);
    }
   
    /**
     * this function gets the next customer in the queue
     * by checking if there number is greater than 0
     * if so they are added to the list 
     * @return the customer in the queue
     */
    public CustInQueue getNext()
    {    	
    	CustInQueue cq = null;
    	if(getNumQueueing() > 0)
    	{
    		cq = queue.getFirst();
    		queue.remove(0);
    		
    		return cq;
    	}   
    	
    	  return cq;
    }  
    
    /**
     * this is a method used to obtain the string value
     * of an object in the list/queue
     * because there could be a number of item they are stored as a string buffer
     * @return the content of the string buffer
     */
    public String getQueueString() 
    {    	
    	StringBuffer sb = new StringBuffer();
		for (CustInQueue cq : queue) 
		{
			if (cq.isInQueue()) 
			{
				sb.append(cq.toString() + "\n");
			}
		}	
		return sb.toString();
    } 
    
    /**
     * this methods adds a new item to the list
     * i have used a for each loop for the logic
     */
    public  void  addToQueue()
    {    	
    	for (CustInQueue cq : queue) 
    	{
			if (!cq.isInQueue())
			{
				cq.setInQueue(true);
				break;
			}
		}	
    }
    
}
