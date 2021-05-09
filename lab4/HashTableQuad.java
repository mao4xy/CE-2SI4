package lab4;

public class HashTableQuad {
	//To store all elements
		private Integer[] table;
		//the size of the table
		private int size;
		//the number of elements stored
		private int num;
		//max number of the elements allowed to be stored
		private int max;
		//The max load factor
		private double load_fac;
	
	public HashTableQuad(int maxNum, double load) {
		this.max = maxNum;
		this.load_fac = load;
		this.num=0;
		double temp1 = max/load_fac;
		int temp = (int)temp1;
		if(temp<temp1) {
			temp+=1;
		}
		while(!checkprime(temp)) {
			temp++;
		}
		this.size = temp;
		this.table = new Integer[this.size];
	
	}
	
	private boolean checkprime(int x) {
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
			int pos = n%size;
			int temp = pos;
			int add = 1;
			if(num+1>load_fac*size) {
				this.rehash();
				}
			for(int i=0;i<size;i++) {
				if(temp<size&&table[temp]!=null) {
					temp = (pos+add*add)%size;
					add++;
					}
				else {
					break;
					}
				}
			if(temp<size) {
				table[temp] = n;
				num+=1;
				}
			}
	}
	
	//min: theta(1); max: theta(n)
	private void rehash() {
		int new_max = max*2;
		HashTableQuad newone = new HashTableQuad(new_max,load_fac);
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
		int temp = index;
		int add = 1;
		for(int i=0;i<table.length;i++) {
			if(temp<size&&table[temp]!=null) {
				if(table[temp]==n) {
					return true;
					}
				else {
					temp = index + add*add;
				    add++;
				    }
				}
			else
				break;
		}
		
		return false;
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
					add+=1;;
					temp= (pos+add*add)%size;
					}
				else {
					break;
					}
				}
			table[temp] = n;
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
				if(table[temp]!=n) {
					add++;
					temp = (pos+add*add)%size;
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
