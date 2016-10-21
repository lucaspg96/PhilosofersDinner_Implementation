import java.util.Random;


public class Writer implements Runnable {
	private Item item;
	private int id;
	
	public Writer(int i, Item x){
		id = i;
		item = x;
	}
	
	private void write(int v){
		item.Write(v, id);
	}

	public void run() {
		while(true){
			Random r = new Random();
			write(r.nextInt());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}
		
	}
}
