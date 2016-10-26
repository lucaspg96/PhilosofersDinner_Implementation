
public class Philosofer implements Runnable {
	
	private Chopsticks left,right;
	private boolean left_using, right_using;
	private String name;
	
	enum State {THINKING,HUNGRY,EATING};
	
	private State state;
	
	public Philosofer(Chopsticks c1, Chopsticks c2, String n) {
		left = c1;
		right = c2;
		name = n;
		
		left_using = false;
		right_using = false;
		
		state = State.THINKING;
	}
	
	public State getState(){
		return state;
	}

	public void run() {
		while(true){
			//state = State.HUNGRY;

			while(!left_using || !right_using){
				left_using = left.tryUse();
				right_using = right.tryUse();
				
				if(left_using && !right_using)
					left.release();
				if(!left_using && right_using)
					right.release();
			}				
					
			eat();
			
			left.release();
			right.release();
			//state = State.THINKING;
		}
	}
	
	public void eat() {
		try {
			Thread.sleep(1000);
			System.out.println("Filosofo "+name+" comeu");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
