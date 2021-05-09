package lab4;

import java.util.Random;

public class TestbyMyselfLin {
	
	public static void main(String[] args) {
		HashTableLin testlin = new HashTableLin(14,0.4);
		System.out.println("Size: "+ testlin.getTableSize());
		testlin.printKeysAndIndexes();
		System.out.println("****");
		testlin.insert(0);
		testlin.printKeysAndIndexes();
		System.out.println("****");
		testlin.insert(32);
		testlin.printKeysAndIndexes();
		System.out.println("****");
		testlin.insert(55);
		testlin.printKeysAndIndexes();
		System.out.println("****");
		testlin.insert(37);
		testlin.printKeysAndIndexes();
		System.out.println("****");
		testlin.insert(23);
		testlin.printKeysAndIndexes();
		System.out.println("****");
		testlin.insert(74);
		testlin.printKeysAndIndexes();
		System.out.println("****");
		System.out.println("**Duplicated Insert**");
		testlin.insert(55);
		testlin.printKeysAndIndexes();
		System.out.println("**InsertCount**");
		testlin.insertCount(58);
		testlin.printKeysAndIndexes();
		System.out.println("**Duplicated InsertCount**");
		testlin.insertCount(23);
		testlin.printKeysAndIndexes();
		System.out.println("**Test isIn()**");
		if(testlin.isIn(44)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println("**Test Duplicated isIn()**");
		if(testlin.isIn(32)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println("**SearchCount**");
		System.out.println(testlin.searchCount(58));
		testlin.printKeysAndIndexes();
		System.out.println("**Duplicated SearchCount**");
		System.out.println(testlin.searchCount(23));
		testlin.printKeysAndIndexes();
		double loadFactor;
		int numKeys = 10000;
		Random r = new Random();
        int val, runs = 100, duplicates;
        double countLoop, unsL, sL, probeCount = 0,probeunsucces = 0;
		for(loadFactor = 0.1; loadFactor <= 0.9; loadFactor += 0.1){
			
			HashTableLin HTestb = new HashTableLin(numKeys, loadFactor);
		        
		        while(HTestb.getNumKeys()<numKeys)
		        {
		        	val= r.nextInt();
		        	 if(val<0)
	            		 val*=-1;
		        	HTestb.insert(val);
		        }
		        System.out.println("# of Keys = " + HTestb.getNumKeys());
		        System.out.println("Table Size = " + HTestb.getTableSize());
		        
		        int total=0, success=0;
	            
		        for(int i=0; i<HTestb.getTableSize(); i++)
		        {
		        	val = r.nextInt(Integer.MAX_VALUE);  
		        	 if(val<0)
	            		 val*=-1;
		        	 
		         if(HTestb.isIn(val))
		         {   success++;           
		           }	 
		         else {
		         total+= HTestb.searchCount(val);
		         }
		        }
		        
		        probeunsucces=(double)total/(HTestb.getTableSize()-success);
		        unsL=0.5*(1+(1/((1-loadFactor)*(1-loadFactor))));
		        
		        if ((Math.abs(probeunsucces-unsL)<.1*unsL)) {          
	    			System.out.printf("for Load Factor: %.1f\n", loadFactor);
	    			System.out.println("Bonus: pass(+1)");
	    		
	    		}
	    		else {
	    			System.out.printf("for Load Factor: %.1f\n", loadFactor);
	
	    		}
		        
		      System.out.printf("Load Factor : %.1f,  Average # probes : %.3f,  Theoretical # probes (LP) : %.3f \n", loadFactor,probeunsucces, unsL);
		    }
	}
	}
	