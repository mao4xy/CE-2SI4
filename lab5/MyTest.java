package lab5;


public class MyTest {
	
	public static void main(int x) {
		int a = 1;
		int b = 4;
		int c = 2000;
		int d = -9;
		MaxHeap test = new MaxHeap(8);
		test.insert(a);
		test.insert(b);
		test.insert(c);
		test.insert(d);
		test.toString();
	}
}