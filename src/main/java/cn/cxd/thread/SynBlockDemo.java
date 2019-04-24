package cn.cxd.thread;

public class SynBlockDemo {

	public static void main(String[] args) {
		Account acc = new Account(100, "礼金");
		SynDrawing you = new SynDrawing(acc, 80, "我");
		SynDrawing wife = new SynDrawing(acc, 90, "她");
		you.start();
		wife.start();

	}
}

class SynDrawing extends Thread {

	Account account;
	int drawingMoney;
	int packetTotal;

	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}

	private void test() {
		if (account.money <= 0) {
			return;
		}
		synchronized (account) {
			if (account.money - drawingMoney < 0) {
				return;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			account.money -= drawingMoney;
			packetTotal += drawingMoney;
			System.out.println(this.getName() + "--->账号余额为" + account.money);
			System.out.println(this.getName() + "--->口袋余额为" + packetTotal);
		}
	}
}

class Account {
	int money;
	String name;

	public Account(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}