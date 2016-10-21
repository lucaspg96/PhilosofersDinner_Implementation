
public class Reader implements Runnable {
	private Item item;
	private int id;
	
	public Reader(int i, Item x){
		id = i;
		item = x;
	}
	
	private void read(){
		item.Read(id);
	}

	public void run() {
		while(true){
			read();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}
		
	}
}
