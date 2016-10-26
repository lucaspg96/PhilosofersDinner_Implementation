
public class Philosofer implements Runnable {
	
	private Chopsticks left,right;
	private boolean left_using, right_using;
	private String name;
	
	public Philosofer(Chopsticks c1, Chopsticks c2, String n) {
		left = c1;
		right = c2;
		name = n;
		
		left_using = false;
		right_using = false;
	}

	public void run() {
		while(true){
			while(!left_using || !right_using){	
				left_using = left.tryUse();
				right_using = right.tryUse();
				
				if(!left_using && right_using)
					right.release();
				
				if(!right_using && left_using)
					left.release();
			}
			eat();
			
			left.release();
			right.release();
		}
	}
	
	public void eat() {
		try {
			//Thread.sleep(1000);
			System.out.println("Filosofo "+name+" comeu");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
