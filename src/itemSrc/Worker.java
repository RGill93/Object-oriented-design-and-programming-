package itemSrc;

import java.util.Iterator;

/**
 *  a Worker is responsible for processing orders in the warehouse
 * @author John Kanyaru
 *
 */

public class Worker   
{
	/**
	 * the instance fields of a worker.
	 * allCusts - the customers that are in  a queue being processed.
	 * allParcels - a collection of the parcels (or items) that comprise the order. 
	 * speed - an indication of how fast a customer enters and exits the queue.
	 * numWorker - the number of current worker 
	 * currentCust - the customer currently being processed 
	 */
	
	private QueueOfCusts allCusts;
	private JacketMap allJackets;
	private int speed;
	private int numWorker;
	private CustInQueue currentCust;
	private boolean open = true;
	private boolean finished = false;	
	
	/**
	 * constructor class for the worker
	 * @param QueueOfCusts class, JackMap, int speed and int numWorker
	 * assigning speed to this.speed
	 * numWorker to this.numWorker
	 */
    public Worker(QueueOfCusts allCusts, JacketMap allJackets, int speed, int numWorker) 
    {
       	allCusts = new QueueOfCusts();
        allJackets = new JacketMap();
        
       	this.speed = speed;
       	this.numWorker = numWorker;
    	
	}   	
    public CustInQueue getCurrentCust() 
    {
    	return allCusts.get(0);
    }    
    
    /**
     * @return the number of the current worker
     */
    public int getNum() 
    {
    	 return numWorker;
    }	
    
    /**
     * @return whether the parcel has been processed or not
     */
	public boolean getClosed() 
	{
		if(!open)
		{
			return true;
		}
		else
		{
			return false;
		}
	}	
	public void setClosed() 
	{
		/*
		for(Iterator<CustInQueue> iter = this.iterator(); iter.hasNext();)
		{
			CustInQueue data = iter.next();
		}
		*/
		
		this.open = false;
	}
	
	public void setFinished()
	{
		this.finished = true;
	}
	
	public boolean getFinished() 
	{ 
		return finished; 	
	} 
	public int getSpeed() 
	{
		return speed;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}	
	
	/**
	 * @return the next customer in the queue
	 * add the next customer in the queue to a log
	 */
	public  CustInQueue getNext() 
	{		
		CustInQueue c = allCusts.getNext();

		Log log = Log.getInstance();
		if (c!= null)
		{
			log.addEntry("W" + numWorker + " :C" + c.getqNum());
			
		}
		return c;
	}
	/**
	 * this method is for processing one customer's order
	 * it obtains the current customer using the private method getNext()
	 * checks that the current customers value is null
	 * obtains the current customers parcel id as a string
	 * declares the above parcel object, obtains it from the collection of parcel
	 * set the parcel as collected
	 * checks if all the parcels are processed allGone()
	 * @return true if finished
	 * else false
	 */
	public  void processOneCustomer()
	{
		currentCust = this.getNext() ;
		if (currentCust != null) 
		{

			
			String pid = currentCust.getpId();
			Jacket j = allJackets.findJacket(pid);
			allJackets.setCollected(j);
			System.out.println (pid + j);
		    if (allJackets.allGone()) 
		    {
				finished = true;
			}			
		}
		else   
		{
			finished = false;
		}
			
	}

}
