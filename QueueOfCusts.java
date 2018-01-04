package itemSrc;

import java.util.LinkedList;


public class QueueOfCusts 
{
    
    private LinkedList <CustInQueue> queue;
    
    public QueueOfCusts()
    {
    	queue = new LinkedList<CustInQueue>();
    }
   
    public  void addDetails(CustInQueue details) 
    {
    	queue.add(details);
    }

    public int getNumberOfEntries()
    {
    	return queue.size();
    }  
  
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
    public CustInQueue get(int i) 
    {    	
    	return queue.get(i);
    }
   
    public CustInQueue getNext()
    {    	
    	CustInQueue cq = null;
    	while(getNumQueueing() == 0)
    	{
    		cq = queue.getFirst();
    		queue.removeFirst();
    	}
    	
    	   return cq; 
    }  
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
