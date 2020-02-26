package dining_philosopher;

public class Main {

	public static void main(String[] args) {
		int size = 5;
		int meals = 3;
		Chopstick fork = new Chopstick(size);
		Thread[] philosopherArray = new Thread[size];

		for (int i = 0; i < size; i++) {
			Philosopher p = new Philosopher(i, fork, meals);
			philosopherArray[i] = new Thread(p);
			philosopherArray[i].start();
		}
		for (int i = 0; i < size; i++) {
			try {
				philosopherArray[i].join();
			} catch (InterruptedException e) {
			}
		}

	}

}
