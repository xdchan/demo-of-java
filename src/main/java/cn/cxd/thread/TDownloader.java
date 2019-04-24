package cn.cxd.thread;

public class TDownloader extends Thread {

	private String url;
	private String name;

	public TDownloader(String url, String name) {
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.download(this.url, this.name);
	}

	public static void main(String[] args) {
		TDownloader t1 = new TDownloader(
				"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3508641667,1806124877&fm=26&gp=0.jpg",
				"kobe.jpg");
		TDownloader t2 = new TDownloader(
				"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=33969983,2544753408&fm=26&gp=0.jpg",
				"food.jpg");
		TDownloader t3 = new TDownloader("https://inews.gtimg.com/newsapp_bt/0/5463603493/1000", "silence.jpg");
		t1.start();
		t2.start();
		t3.start();
	}
}
