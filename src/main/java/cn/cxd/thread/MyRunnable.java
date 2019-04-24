package cn.cxd.thread;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("一边听歌");
		}
	}

	public static void main(String[] args) {
		MyRunnable run = new MyRunnable();
		Thread th = new Thread(run);
		th.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("一边coding");
		}
	}
}
