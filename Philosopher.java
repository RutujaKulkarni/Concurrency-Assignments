package dining_philosopher;

public class Philosopher implements Runnable {

	public int id;
	public Chopstick fork;
	public int meals;

	public Philosopher(int id, Chopstick fork, int meals) {
		this.id = id;
		this.fork = fork;
		this.meals = meals;
	}

	@Override
	public void run() {
		while (this.meals > 0) {
			System.out.println("Philosopher " + this.id + " started eating meal no. "+this.meals);
			this.eat();
			System.out.println("Philosopher " + this.id + " started thinking...");
			this.think();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
			this.meals--;
		}
	}

	public void eat() {
		if (this.id % 2 == 0) {
			fork.pickUpLeftFork(id);
			fork.pickUpRightFork(id);
		} else {
			fork.pickUpRightFork(id);
			fork.pickUpLeftFork(id);
		}
	}

	public void think() {
		fork.putDownLeftFork(id);
		fork.putDownRightFork(id);
	}
}
