package lab4;

public class HashTableLin {
	//To store all elements
	private Integer[] table;
	//the size of the table
	private int size;
	//the number of elements stored
	private int num;
	//max number of the elements allowed to be stored, max = size*load_fac
	private int max;
	//The max load factor
	private double load_fac;
	
	public HashTableLin(int maxNum, double load) {
		this.max = maxNum;
		this.load_fac = load;
		this.num=0;
		//to get the double result
		double temp1 = max/load_fac;
		//convert the double to integer, but this integer may be smaller than the smallest prime if the double result has decimals
		int temp = (int)temp1;
		//get the smallest integer larger than temp
		if(temp<temp1) {
			temp+=1;
		}
		//use the while loop and call the function to find the smallest prime number
		while(!checkprime(temp)) {
			temp++;
		}
		this.size = temp;
		this.table = new Integer[this.size];
	
	}
	
	//min: theta(1); max: theta(n)
	//this method get from https://www.programiz.com/java-programming/examples/prime-number
	private boolean checkprime(int x) {
		//2 and 3 are all prime
		if(x>3) {
			for (int i = 2;i <= x/2;i++) {
			      if (x % i == 0) {
			    	  return false;
			      }
			      else {
			    	  continue;
			      }
			    }
		}
		return true;
	}
	
	
	//min: theta(1); max: theta(n)
	public void insert(int n) {
		if(!this.isIn(n)) {
			//if the n is inserted then the num is larger than max, the hashing is needed to be rehash()
			if(num+1>load_fac*size) {
				this.rehash();
				}
			//probe = n%M
			int pos = n%size;
			for(int i=0;i<size;i++) {
				if(pos<size) {
					//when the position of the element is occupied by a different value, probe++
					if(table[pos]!=null&&table[pos]!=n) {
						pos++;
					    }
					//otherwise, insert the element into the position
					else {
						break;
					}
				}
				//when the probe get to the last position, the element can't be inserted into this hashing
				else {
					break;
					}
				}
			//this if statement is for the searchCount because I found it will be out of index if I don't add it
			if(pos<size) {
				//insert the n into this position
				table[pos] = n;
				//the number of elements stored should plus 1
				num+=1;
			}
		}
	}
	
	//min: theta(1); max: theta(n)
	private void rehash() {
		//the size should be at least twice larger than the old size
		int new_max = max*2;
		//create a new hash and convert its fields to this hash
		HashTableLin newone = new HashTableLin(new_max,load_fac);
		for(int i=0;i<size;i++) {
			if(this.table[i]!=null) {
				newone.insert(this.table[i]);
			}
		}
		this.table = newone.table;
		this.num = newone.num;
		this.size = newone.size;
		this.max = newone.max;
		
	}
	
	//min: theta(1); max: theta(n)
	public boolean isIn(int n) {
		int index = n%size;
		for(int i=0;i<size;i++) {
			//when the element is not null
			if(table[index]!=null) {
				//if the element is equal to n, it's true
				if(table[index]==n) {
					return true;
					}
				//otherwise we continue to find it
				else {
					index = (index+1)%size;
					}
				}
			//if the position is null, it means the element never exists in the hash before
			else
				break;
		}
		
		return false;
	}
	
	//min: theta(1); max: theta(n)
		public void printKeys() {
			for(int j=0;j<table.length;j++) {
				if(table[j]!=null)
					System.out.println(table[j]+" ");
				else {
					continue;
				}
			}
		}
		
		//min: theta(1); max: theta(n)
		public void printKeysAndIndexes() {
			for(int j=0;j<table.length;j++) {
				if(table[j]!=null)
					System.out.println(j +":"+ table[j]);
				else {
					continue;
				}
			}
		}
	
	//min: theta(1); max: theta(n)
	public int insertCount(int n) {
		if(!this.isIn(n)) {
			if(num+1>load_fac*size) {
				this.rehash();
				}
			int pos = n%size;
			int temp = pos;
			int add = 0;
			for(int i=0;i<size;i++) {
				if(table[temp]!=null) {
					add+=1;
					temp = (pos+add)%size;
					}
				else {
					break;
					}
				}
			//insert n here
			table[temp] = n;
			//the key number plus one
			num++;
			//add plus one because the last probe is counted
			add++;
			return add;
			}
		
		else {
			if(num+1>load_fac*size) {
				this.rehash();
				}
			int pos = n%size;
			int temp = pos;
			int add = 0;
			for(int i=0;i<size;i++) {
				if(table[temp]!=null&&table[temp]!=n) {
					add++;
					temp = (pos+add)%size;
					}
				else {
					break;
					}
				}
			add++;
			return add;
		}
    }
	
	//min: theta(1); max: theta(n)
	 public int searchCount(int n) {
		 if(!this.isIn(n)) {
				int pos = n%size;
				int temp = pos;
				int add = 0;
				for(int i=0;i<size;i++) {
					if(table[temp]!=null) {
						add+=1;
						temp = (pos+add)%size;
						}
					else {
						break;
						}
					}
				num++;
				add++;
				return add;
				}
			
			else {
				if(num+1>load_fac*size) {
					this.rehash();
					}
				int pos = n%size;
				int temp = pos;
				int add = 0;
				for(int i=0;i<size;i++) {
					if(table[temp]!=null&&table[temp]!=n) {
						add++;
						temp = (pos+add)%size;
						}
					else {
						break;
						}
					}
				add++;
				return add;
			}
	    
 }


	
	
	public int getTableSize() {
		return size;
	}
	
	public int getNumKeys() {
		return num;
	}
	
	public double getMaxLoadFactor() {
		return load_fac;
	}


}

