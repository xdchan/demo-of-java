package cn.cxd.rob.toutiao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import cn.cxd.tools.FileTools;

public class DownLoadToutiaoPicture {

	public static void main(String[] args) throws Exception {

		String srcPath = "D:/name/url.txt";// 保存了各个文章URL地址
		String dstPath = "D:/name/content.txt";// 保存了文章中各个图片的URL
		String dstDir = "D:/name/";// 最终图片存放的目录
		File srcFile = new File(srcPath);
		File dstFile = new File(dstPath);

		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(dstFile));

		String line = null;

		while ((null) != (line = br.readLine())) {
			getContent(bw, line);
		}

		line = null;

		BufferedReader br1 = new BufferedReader(new FileReader(dstFile));
		ArrayList<String> totalPicUrlList = new ArrayList<>();// 存放各个图片的URL
		while ((null) != (line = br1.readLine())) {
			ArrayList<String> tmpList = parse(line);// 一篇文章中图片的URL地址。
			totalPicUrlList.addAll(tmpList);// 加入到总list里面。
		}

		for (int index = 0; index < totalPicUrlList.size(); index++) {
			// 使用了Apache第三方的common io，既然别人把轮子都造好了，那就发扬拿来主义吧！哈哈哈。。。
			FileUtils.copyURLToFile(new URL(totalPicUrlList.get(index)), new File(dstDir + index + ".jpg"));
		}

		FileTools.close(br1, bw, br);
	}

	/**
	 * 根据文章的URL地址获取各个图片的URL。通过分析网页的源码可知，一个图片的URL完整地址可能分行显示。而全部图片的URL都包含在articleInfo里面，
	 * 因此，本文的方案是把articleInfo里面的内容全部获取到本地，然后再解析，即后面的parse()函数。
	 * 
	 * @param bw
	 * @param line
	 *            文章的URL地址链接
	 * @throws Exception
	 */
	private static void getContent(BufferedWriter bw, String line) throws Exception {

		URL url = new URL(line);
		// 头条做了反爬机制，必须将程序伪装成浏览器访问才行。
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		// 将articleInfo里面的内容组装成一行，方便后面的解析工作。
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		// 这里建议不要用while((null) !=
		// (line=br.readLine()))来做，极有可能还没有读到articleInfo时就为空，导致程序退出。
		for (int i = 0; i < 2000; i++) {
			String input = br.readLine();

			if (null != input) {
				System.out.println(input);
				if (input.contains("articleInfo")) {
					System.out.println(input);
					flag = true;
				}

				if (flag == true) {
					sb.append(input);
					System.out.println(input);
				}

				if (input.contains("groupId")) {// groupId为articleInfo结束后的第一行内容，读到这表示articleInfo内容已经读完，则将i置为200以退出循环。
					i = 2000;
				}
			}
		}
		bw.write(sb.toString());

		bw.newLine();
		sb = new StringBuilder();
		FileTools.close(br);
	}

	/**
	 * 解析出里面的URL地址，存入list并返回。
	 * 
	 * @param line
	 *            上面提到的articleInfo里面的内容。
	 * @return
	 */
	private static ArrayList<String> parse(String line) {

		int len = line.length();
		char[] ch = line.toCharArray();

		StringBuilder sb = new StringBuilder();

		ArrayList<String> picUrlList = new ArrayList<>();
		for (int i = 0; i < len - 4; i++) {
			String tmp = line.substring(i, i + 4);
			if (tmp.equals("http")) {
				for (int j = i; j < len; j++) {
					if (ch[j] != '&') {
						sb.append(ch[j]);
					} else {
						j = len;
					}
				}

				picUrlList.add(sb.toString());
				sb = new StringBuilder();
			}

		}
		return picUrlList;
	}
}
