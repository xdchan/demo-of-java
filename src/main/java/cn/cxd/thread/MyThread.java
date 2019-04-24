package cn.cxd.thread;

public class MyThread extends Thread {

	public static void main(String[] args) {

		MyThread th = new MyThread();
		th.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("一边coding");
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("一边听歌");
		}
	}
}
