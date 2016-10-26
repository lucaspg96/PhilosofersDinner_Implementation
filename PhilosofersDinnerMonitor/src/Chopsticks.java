
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Chopsticks {
	
	private Lock lock = new ReentrantLock();
	private Condition using = lock.newCondition();
	private boolean isUsing = false;
	
	public Chopsticks() {
	}
	
	public Condition getUsingCondition(){
		return using;
	}
	
	public boolean getUsing(){
		return isUsing;
	}
	
	public boolean tryUse(){
		lock.lock();
		try {
			if (isUsing)
				return false;
			else{
				isUsing = true;
				return true;
			}
		}
		finally{
			lock.unlock();
		}
	}
	
	public void release() {
		//lock.lock();
		isUsing = false;
		//lock.unlock();
		//using.signalAll();
	}
	
}
