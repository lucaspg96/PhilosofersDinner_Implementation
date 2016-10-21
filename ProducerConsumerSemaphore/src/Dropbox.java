import java.util.concurrent.Semaphore;

public class Dropbox {
	private int number;
	
	@SuppressWarnings("unused")
	private boolean evenNumber = false;
	
	private Semaphore sem_even, sem_odd, sem_prod;
	
	public Dropbox() {
		this.sem_even = new Semaphore(0);
		this.sem_odd = new Semaphore(0);
		this.sem_prod = new Semaphore(1);
	}
	
	public int take(final boolean even) {
		System.out.format("%s CONSUMIDOR obtem %d.%n", even ? "PAR" : "IMPAR",
		number);
		return number;
	}
	public void put(int number) {
		this.number = number;
		evenNumber = number % 2 == 0;
		System.out.format("PRODUTOR gera %d.%n", number);
	}
	
	public void acquireEven() {
		try {
			sem_even.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void acquireOdd() {
		try {
			sem_odd.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void acquireProd() {
		try {
			sem_prod.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void releaseEven() {
		sem_even.release();
	}
	
	public void releaseOdd() {
		sem_odd.release();
	}
	
	public void releaseProd() {
		sem_prod.release();
	}
}
