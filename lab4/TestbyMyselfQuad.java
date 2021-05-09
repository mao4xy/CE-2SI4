package lab4;

import java.util.Random;

public class TestbyMyselfQuad {
	
	public static void main(String[] args) {
		HashTableQuad testquad = new HashTableQuad(14,0.4);
		System.out.println("Size: "+ testquad.getTableSize());
		testquad.printKeysAndIndexes();
		System.out.println("****");
		testquad.insert(0);
		testquad.printKeysAndIndexes();
		System.out.println("****");
		testquad.insert(32);
		testquad.printKeysAndIndexes();
		System.out.println("****");
		testquad.insert(55);
		testquad.printKeysAndIndexes();
		System.out.println("****");
		testquad.insert(37);
		testquad.printKeysAndIndexes();
		System.out.println("****");
		testquad.insert(23);
		testquad.printKeysAndIndexes();
		System.out.println("****");
		testquad.insert(74);
		testquad.printKeysAndIndexes();
		System.out.println("****");
		System.out.println("**Duplicated Insert**");
		testquad.insert(55);
		testquad.printKeysAndIndexes();
		System.out.println("**InsertCount**");
		testquad.insertCount(58);
		testquad.printKeysAndIndexes();
		System.out.println("**Duplicated InsertCount**");
		testquad.insertCount(23);
		testquad.printKeysAndIndexes();
		System.out.println("**Test isIn()**");
		if(testquad.isIn(44)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println("**Test Duplicated isIn()**");
		if(testquad.isIn(32)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
	}
	}
	