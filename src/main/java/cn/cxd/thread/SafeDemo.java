package cn.cxd.thread;

public class SafeDemo {

	public static void main(String[] args) {
		Safe12306 web = new Safe12306();
		new Thread(web, "码    农").start();
		new Thread(web, "程序猿").start();
		new Thread(web, "攻城狮").start();
	}
}

class Safe12306 implements Runnable {

	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test2();
		}
	}

	// 线程安全：尽可能锁定合理的范围（不是指代码而是指数据的完整性）
	// double checking
	public void test5() {
		if (ticketNums <= 0) {
			flag = false;
			return;
		}
		synchronized (this) {
			if (ticketNums <= 0) {
				flag = false;
				return;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "--->" + (ticketNums--));
		}
	}

	// 线程不安全，范围太小锁不住。
	public void test4() {
		synchronized (this) {
			if (ticketNums <= 0) {
				flag = false;
				return;
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "--->" + (ticketNums--));
	}

	// 线程不安全 ticketNums对象在变
	public void test3() {
		synchronized (Integer.valueOf(ticketNums)) {
			if (ticketNums <= 0) {
				flag = false;
				return;
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "--->" + (ticketNums--));
	}

	// 线程安全，范围太大--->效率低下。
	public void test2() {
		synchronized (this) {
			if (ticketNums <= 0) {
				flag = false;
				return;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "--->" + (ticketNums--));
		}
	}

	// 线程安全且同步，但范围太大。
	public synchronized void test1() {
		if (ticketNums <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "--->" + (ticketNums--));
	}

}