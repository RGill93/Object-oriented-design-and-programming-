package itemSrc;

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
    	return currentCust;
    }    
    public int getNum() 
    {
    	 return numWorker;
    }	
	public boolean getClosed() 
	{
		if(open == true)
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
		open = false;		
	}
	public int getSpeed() 
	{
		return speed;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}	
	public boolean getFinished() 
	{ 
		return finished; 	
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
