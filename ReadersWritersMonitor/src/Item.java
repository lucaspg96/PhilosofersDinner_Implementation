import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Item {
	private int val;
	
	private Lock lock = new ReentrantLock();
	private Condition read = lock.newCondition();
	private Condition write = lock.newCondition();
	
	private boolean canRead,canWrite;
	
	
	public Item(){
		Random r = new Random();
		val = r.nextInt();
		canRead = true;
		canWrite = true;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	public int Read(int id){
		try {
			//Esperando poder realizar leitura
			while (!canRead)
				read.await();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Leitor "+id+" leu o valor "+val);
		return val;
	}
	
	public void Write(int v, int id){
		try {
			//Esperando poder realizar escrita
			while(!canWrite)
				write.await();
			lock.lock();
			canWrite = false;
			canRead = false;
			val = v;
			System.out.println("Escritor "+id+" atualizou o valor para "+v);
			
			canWrite = true;
			canRead = true;
			read.signalAll();
			write.signalAll();
			lock.unlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
