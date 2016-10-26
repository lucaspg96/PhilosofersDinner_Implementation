import java.util.concurrent.Semaphore;


public class Chopsticks {
	
	private Semaphore using;
	
	public Chopsticks() {
		using = new Semaphore(1);
	}
	
	public boolean tryUse(){
		return using.tryAcquire();
	}
	
	public void release() {
		using.release();
	}
	
}
