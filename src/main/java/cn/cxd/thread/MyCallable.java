package cn.cxd.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Boolean> {

	String url = null;
	String name = null;

	public MyCallable(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		MyCallable t1 = new MyCallable("https://inews.gtimg.com/newsapp_bt/0/5463603493/1000", "silence.jpg");
		MyCallable t2 = new MyCallable(
				"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3508641667,1806124877&fm=26&gp=0.jpg",
				"kobe.jpg");
		MyCallable t3 = new MyCallable(
				"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=33969983,2544753408&fm=26&gp=0.jpg",
				"food.jpg");

		ExecutorService ser = Executors.newFixedThreadPool(3);
		Future<Boolean> res1 = ser.submit(t1);
		Future<Boolean> res2 = ser.submit(t2);
		Future<Boolean> res3 = ser.submit(t3);

		boolean r1 = res1.get();
		boolean r2 = res2.get();
		boolean r3 = res3.get();

		System.out.println(r1 + "," + r2 + "," + r3);

		ser.shutdown();
	}

	@Override
	public Boolean call() throws Exception {
		WebDownloader wd = new WebDownloader();
		wd.download(url, name);
		System.out.println(name);
		return true;
	}

}
