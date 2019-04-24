package cn.cxd.thread;

public class DeamonThread {

	public static void main(String[] args) {
		// Thread god = new Thread();
		// Thread you = new You();
		// new Thread(god).start();
		// new Thread(you).start();

		God god = new God();
		You you = new You();
		god.setDaemon(true);
		god.start();

		you.start();
	}
}

class You extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 365 * 100; i++) {
			System.out.println("happy life ...");
		}
		System.out.println("oooooo......");
	}
}

class God extends Thread {

	@Override
	public void run() {
		for (; true;) {
			System.out.println("God bless you");
		}
	}
}