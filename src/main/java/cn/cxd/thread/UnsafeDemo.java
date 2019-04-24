package cn.cxd.thread;

public class UnsafeDemo {

	public static void main(String[] args) {

		Unsafe12306 web = new Unsafe12306();
		new Thread(web, "码农").start();
		new Thread(web, "程序猿").start();
		new Thread(web, "攻城狮").start();

	}
}

class Unsafe12306 implements Runnable {

	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
	}

	public void test() {
		if (ticketNums <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + "--->" + (--ticketNums));
	}

}