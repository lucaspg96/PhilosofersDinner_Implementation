
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Spock","Newton","Decartes","Platao","Socrates"};
		Chopsticks[] chopsticks = {new Chopsticks(),new Chopsticks(),new Chopsticks(),new Chopsticks(),new Chopsticks()};
		
		(new Thread(new Philosofer(chopsticks[0], chopsticks[1], names[0]))).start();
		(new Thread(new Philosofer(chopsticks[1], chopsticks[2], names[1]))).start();
		(new Thread(new Philosofer(chopsticks[2], chopsticks[3], names[2]))).start();
		(new Thread(new Philosofer(chopsticks[3], chopsticks[4], names[3]))).start();
		(new Thread(new Philosofer(chopsticks[4], chopsticks[0], names[4]))).start();	
	}
}
