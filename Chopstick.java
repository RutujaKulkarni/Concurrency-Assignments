package dining_philosopher;

public class Chopstick {

	public boolean[] forks;
	public int size = 0;

	public Chopstick(int size) {
		this.forks = new boolean [size];
		this.size = size;
		for (int i = 0; i < size; i++) {
			forks[i] = true; // available
		}
	}

	public synchronized void pickUpRightFork(int id) {
		while (!forks[(id + 1) % size]) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		forks[(id + 1) % size] = false;
	}

	public synchronized void pickUpLeftFork(int id) {
		while (!forks[id]) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		forks[id] = false;
	}

	public synchronized void putDownRightFork(int id) {
		forks[(id + 1) % size] = true;
		notifyAll();
	}

	public synchronized void putDownLeftFork(int id) {
		forks[id] = true;
		notifyAll();
	}
}
