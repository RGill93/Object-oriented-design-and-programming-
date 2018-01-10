package itemSrc;

import itemSrc.Jacket;

import java.util.Scanner;

import java.io.*;

/**
 * This class puts everything together, it is the applications entry point
 * You can have your main method here if you wish.
 * @author John Kanyaru
 *
 */
public class Manager
{
	/**
	 * instance fields brief overview:
	 * workers - a number of workers in the warehouse. An  array is used here, feel free to use 
	 * an alternative data structure
	 * numWorkers - starting with with one worker. That is, this simulation is for one worker
	 * custQ - the collection of queueing customers
	 * allParcels - collection of items/parcels being processed
	 * wSpeed - work speed
	 */
	private Worker workers[];
	private int numWorkers = 1;
	private QueueOfCusts custQ;
    private JacketMap allJackets;
   
   private int wSpeed [];
   
   /**
    * the constructor is done
    * instantiate it and use methods following it to perform unit tests
    */
    public Manager()
    {
    	custQ = new  QueueOfCusts();
    	allJackets = new JacketMap();
    }
    
    public void setQCusts(QueueOfCusts c)
    {
    	custQ = c;
    }
    
    public QueueOfCusts getCusts()
    {
    	return custQ;
    } 
       

/**
 * this method is responsible for reading relevant files such as
 * item/parcefile, customerfile
 * also, initialise a number of customers to be in the queue, e.g., 6 customers
 * perform a simple println of all parcel details, and queueing customers details
 * Logic of initialisation:
 * 1) read customer file
 * 2) read items/parcel file
 * 3) put 6 or so customers in the queue by:
 * 3.1) use for loop to repeat 6 times
 * 3.2) declare a reference of CustInQue and put in it the ith value of custQ.
 * 3.3) Now set the CustIQue reference to be in inQueue (setInQueue()).
 * 4) print all parcel details to the console
 * 5) print all queing customers to the console
 */
    public void initialiseData() 
    {    	
    	
    	readCustFile();
    	readParcelFile();    	
    	
    	for (int i = 0; i < 6; i++ )
    	{
    		CustInQueue c = custQ.get(i);
    		c.setInQueue(true);
    	}

    	System.out.println(" parcel details"+allJackets.listDetails());

    	System.out.println(custQ.getQueueString());    	
    	
    }
    
    /**
     * this method is implemented for you
     * write unit tests to determine it works correctly
     */
    public void initialiseWorkers()
    {
    	
    	workers = new Worker[numWorkers];
    	wSpeed = new int [numWorkers];
    	for (int tind = 0; tind <numWorkers; tind ++)
    	{
    		wSpeed[tind] = 1000 * (tind+1) * 2 ;
    		workers[tind] = new Worker(custQ, allJackets, wSpeed[tind], tind + 1);
    		
    	}
    }
/**
 * a method to read cust.csv file.
 * use an object of Scanner to read the file
 * You will need to use the split method of String class to read input appropriately
 * catch appropriate exceptions
 */
    public void readCustFile() 
    {
    	
    	try 
    	{
    		Scanner scanner = new Scanner (new File("Custs.csv"));
    		System.out.println("Scanning");
        	while(scanner.hasNext()){  
            	String inputLine = scanner.nextLine();
            	System.out.println(inputLine);
        		processCustLine(inputLine);

        	}
    	}
    	catch (Exception e) 
    	{
    		System.out.println("Exception occured during runtime");    		
    	}
    }
    
    /**
     * this is a function that will read the 
     * "Custs.csv" file
     * if the file exists
     * @return the file
     * else it returns null
     */
    public File getCustsFile()
    {
    	File f = new File("Custs.csv");
    	
    	if(f.exists())
    	{
    		return f;
    	}
    	else
    	{
    		return null;
    	}
    }
    /**
     * 
     *this is to do the nitty gritty business of reading the file by splitting content
     *based on used delimeter.
     *its a private method because it is called in the readCustFile above.
     *You can keep it, that way or do all the work in the method above
     *once splitting has happened, identify which one is id, and which one is pid.
     *use the id and pid to create an object of CustInque
     *Add the object of CustinQue to custQ
     */
   
    private void processCustLine (String inputLine) 
    {
//to remove
		try 
		{
			String parts [] = inputLine.split(",");			
			
			String id =  parts[0].trim();			
			
			String pid = parts[1].trim();
						
			CustInQueue c= new CustInQueue (id, pid);
    		
            custQ.addDetails(c);
		}			
			
			catch (NumberFormatException nfe) 
			{
				String error = "Number conversion error in '"
	                   + inputLine + "'  - " + nfe.getMessage();
				System.out.println(error);
			}
			
			catch (ArrayIndexOutOfBoundsException air)
			{
				String error = "Not enough items in  : '" + inputLine
				            + "' index position : " + air.getMessage();
				System.out.println(error);
			}
		}
    
    /**
     * similar functionality as readcustomer file
     * follow same concept
     */
    public void readParcelFile() 
    {
    	try 
    	{
    		Scanner scanner = new Scanner (new File("Parcels.csv"));
    		System.out.println("Scanning");
        	while(scanner.hasNext())
        	{  
            	String inputLine = scanner.nextLine();
            	System.out.println(inputLine);
        		processParcelLine(inputLine);

        	}
    	}
    	catch (Exception e)
    	{
    		System.out.println("Exception occurred during runtime");
    	}
    }
    	
    /**
     * this is a function that will read the 
     * "Parcel.csv" file
     * if the file exists
     * @return the file
     * else it returns null
     */
    	public File getParcelFile()
    	{
    		File f = new File("Parcel.csv");
        	
        	if(f.exists())
        	{
        		return f;
        	}
        	else
        	{
        		return null;
        	}
    	
    } 
    
    /**
     * similar to processCutline
     * simply, breakdown file content into appropriate data 
     * items using String's split() method 
     * once you obtain all parcel details, create a parcel object, and add 
     * it to allParcels collection
     */
    	
    	 
     /*
      * i have also removed the variables i don't need for my parcel
      * i have added the relevant ones to match mine
      */
    
    private void processParcelLine (String inputLine) 
    {
	
		 
    	try 
    	{
    		
			String parts [] = inputLine.split(",");
			String id = parts[0].trim();
			
			String colorString = parts[6].trim();
			
			String priceDoubleString = parts[7].trim();
			double priceDouble = Double.parseDouble(priceDoubleString);
			
			String brandString = parts[8].trim();
			
			String collectedBoolString = parts[9].trim();
			boolean collectedBool = Boolean.parseBoolean(collectedBoolString);
			
			String sizeDoubleString = parts[10].trim();
			double sizeDouble = Double.parseDouble(sizeDoubleString);
				
						
			// creates and object of the jacket and adds to the list and then adds it to the list
			Jacket j = new Jacket(id, colorString, priceDouble, brandString, collectedBool, sizeDouble);
            allJackets.addDetails(j.getId(), j);
            
		}
			
			catch (NumberFormatException nfe)
			{
				String error = "Number conversion error in '"
	                   + inputLine + "'  - " + nfe.getMessage();
				System.out.println(error);
			}
			
			catch (ArrayIndexOutOfBoundsException air) 
			{
				String error = "Not enough items in  : '" + inputLine
				            + "' index position : " + air.getMessage();
				System.out.println(error);
			}
		}

public void run() 
{
	System.out.println("Writing log file");

    	this.initialiseData();
    	this.initialiseWorkers();
    	
    	
    	 	try 
        	{
        		File f = new File("Log.txt");
        		FileWriter fw = new FileWriter(f);
        		Log log = Log.getInstance();
        		fw.write(log.toString());
        		fw.close();
        	}
        	catch (IOException e)
        	{
        		e.printStackTrace();
        	}
        	System.exit(0);
	} 
    
    
    /**
     * Print to text file*/

    public void print() 
    {
    	FileWriter fw = null;
    	try 
    	{
        	fw = new FileWriter("ItemDetails.txt");
        	fw.write(custQ.getNext().getName() +", " +custQ.getNext().getpId().toString());
        	fw.close();
    	}
    	catch (FileNotFoundException e) 
    	{
    		System.out.println(e.getMessage());
    		System.exit(1);
    	}
    	
    	catch (IOException ioe)
    	{
    		System.exit(1);
    	}

    }
    
}

