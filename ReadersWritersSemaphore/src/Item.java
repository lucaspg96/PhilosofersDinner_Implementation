import java.util.Random;
import java.util.concurrent.Semaphore;


public class Item {
	private int val;
	private Semaphore sem_write;
	
	public Item(){
		Random r = new Random();
		val = r.nextInt();
		sem_write = new Semaphore(1);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	public int Read(int id){
		try {
			//Se não houver bloqueio de escrita, ele retorna o valor
			if(sem_write.availablePermits()==0){
				sem_write.acquire();
				sem_write.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Leitor "+id+" leu o valor "+val);
		return val;
	}
	
	public void Write(int v, int id){
		try {
			//Se não houver bloqueio de escrita, ele atualiza o valor
			sem_write.acquire();
			val = v;
			System.out.println("Escritor "+id+" atualizou o valor para "+v);
			sem_write.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
