package cn.cxd.thread;

public class Web12306 implements Runnable {

	private int ticketsNum = 99;

	@Override
	public void run() {

		while (ticketsNum > 0) {
			System.out.println(Thread.currentThread().getName() + "--->" + (--ticketsNum));
		}
	}

	public static void main(String[] args) {
		Web12306 web = new Web12306();
		new Thread(web, "th1").start();
		new Thread(web, "th2").start();
		new Thread(web, "th3").start();
	}
}
