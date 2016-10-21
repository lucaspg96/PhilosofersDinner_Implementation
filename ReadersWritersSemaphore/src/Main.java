
public class Main {

	public static void main(String[] args) {
		
		Item i = new Item();
		(new Thread(new Reader(1, i))).start();
		(new Thread(new Reader(2, i))).start();
		
		(new Thread(new Writer(1, i))).start();
		(new Thread(new Writer(2, i))).start();
		(new Thread(new Writer(3, i))).start();

	}

}
