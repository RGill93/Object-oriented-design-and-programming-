package itemSrc;

import java.util.Iterator;

/**
 *  a Worker is responsible for processing orders in the warehouse
 * @author John Kanyaru
 *
 */

public class Worker   {
	/*
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
    
    // return the number of the current workers
    public int getNum() 
    {
    	 return numWorker;
    }	
    
    // return true or false depending  on whether the parcel processed or not
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
	public  void processOneCustomer()
	{
		currentCust = this.getNext() ;
		if (currentCust != null) {

			
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
			finished = true;
		}
			
	}

}
