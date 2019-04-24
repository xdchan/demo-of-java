package cn.cxd.compos.chat;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import java.net.*;
import java.text.DateFormat;

public class MyServer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JScrollPane jsp = null;
	JTextField jtf = null;
	JTextArea jta = null;
	JButton jb = null;
	JPanel jp = null, jp_north = null;
	JLabel jl = null;
	ServerSocket ss = null;
	Socket s = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	Date dt = null;
	DateFormat medium = null;
	Timer t = null;

	public static void main(String[] args) {

		new MyServer();
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public MyServer() {

		jp_north = new JPanel();

		t = new Timer(1000, this);
		t.start();
		jl = new JLabel("当前时间:" + Calendar.getInstance().getTime().toLocaleString());
		jp_north.add(jl);

		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jsp.getVerticalScrollBar();

		jp = new JPanel();
		jtf = new JTextField(15);
		jb = new JButton("send");
		jb.addActionListener(this);

		jp.add(jtf);
		jp.add(jb);

		this.add(jp_north, "North");
		this.add(jsp, "Center");
		this.add(jp, "South");
		this.setTitle("server");
		this.setVisible(true);
		this.setBounds(100, 100, 300, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		try {
			s = new Socket();
			ss = new ServerSocket(5005);
			s = ss.accept();

			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());

			while (true) {
				String s = br.readLine();
				dt = new Date();
				medium = DateFormat.getTimeInstance(DateFormat.MEDIUM);
				jta.append(medium.format(dt) + " client: " + s + "\r\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb) {

			pw.println(jtf.getText());
			dt = new Date();
			medium = DateFormat.getTimeInstance(DateFormat.MEDIUM);
			jta.append(medium.format(dt) + " server:" + jtf.getText() + ":" + "\r\n");
			jtf.setText("");
			pw.flush();
		}

		this.jl.setText("当前时间:" + Calendar.getInstance().getTime().toLocaleString());
	}
}