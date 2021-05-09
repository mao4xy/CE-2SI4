package lab5;

public class MaxHeap {
	//field
	//To store all elements
	private Integer[] heap;
	//the size of the table
	private int size;
	//the number of elements stored
	private int num;

	//Constructor
	public MaxHeap(int size) {
		this.size = size;
		this.num = 0;
		this.heap = new Integer[this.size];
		
	}
	// O(n*log(n)) O(n)
	public MaxHeap(Integer[] someArray) {
		this.size = someArray.length;
		this.heap = new Integer[size];
		this.num = 0;
		for(int i = 0; i < size; i++) {
			this.insert(someArray[i]);
		}
		
	}
	
	// O(log(n)) O(n)
	public void insert(int n) {
		if(size==num) {
			size*=2;
			Integer[] temp = new Integer[size];
			for(int i=0; i<heap.length; i++) {
				temp[i] = this.heap[i];
			}
			heap = temp;
		}
		//make the last ele in array is n
		heap[num]=n;
		//call the index method
		insert_index(num);
		num++;
 


	}
	
	// O(n*log(n)) O(n)
	private int deleteMax() {
		size--;
		num--;
		//decide which element be deleted
		int root = heap[0];
		//create a new integer array
		Integer[] temp = new Integer[size];
		//transfer the elements except the root from the original one
		for(int i=0; i<size; i++) {
			temp[i] = heap[i+1];
		}
		MaxHeap store = new MaxHeap(temp);
		this.heap = store.heap;
		return root;
	}
	
	//O(n); O(n)
	public String toString() {
        String out = new String();
        for (int i = 0; i < num; i++) {
            out+=heap[i];
            out+=",";
        }
        return out;
	    }
	
	// O(n^2*log(n)) O(n)
	public static void heapsort(Integer[] arrayToSort) {
		MaxHeap temp = new MaxHeap(arrayToSort);
		for(int i=0 ;i<arrayToSort.length; i++) {
			arrayToSort[i] = temp.deleteMax();
		}
	}
	
	public int getSizeHeap() {
		return num;
	}
	
	public int getSizeArr() {
		return size;
	}
	
	public Integer[] getHeap() {
		return heap;
	}
	
	
	private int parent(int pos) {
        return (pos-1) / 2;
    }

    private void insert_index(int index) {
    	//temp is the value of the element of heap[index]
    	int temp = heap[index];
    	//if the temp is larger than its parent, it should exchange its position with its parent
        while(index>0 && temp > heap[parent(index)]){
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = temp;
    }
        
        
            
  
        
    



}
