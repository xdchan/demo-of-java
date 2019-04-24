package cn.cxd.compos.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * 
 * @author cxd
 *
 */
public class MyClient extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JScrollPane jsp = null;
	JTextField jtf = null;
	JTextArea jta = null;
	JButton jb = null;
	JPanel jp = null, jp_north = null;
	JLabel jl = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	Socket s = null;
	Date dt = null;
	DateFormat medium = null;
	Timer t = null;

	public static void main(String[] args) {

		new MyClient();
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	public MyClient() {

		jp_north = new JPanel();
		t = new Timer(1000, this);
		t.start();
		jl = new JLabel("当前时间" + Calendar.getInstance().getTime().toLocaleString());
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
		this.setTitle("client");
		this.setVisible(true);
		this.setBounds(500, 150, 300, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		try {

			s = new Socket("127.0.0.1", 5005);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());

			while (true) {
				String s = br.readLine();
				dt = new Date();
				medium = DateFormat.getTimeInstance(DateFormat.MEDIUM);
				jta.append(medium.format(dt) + " server: " + s + "\r\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == jb) {
			pw.println(jtf.getText());
			dt = new Date();
			medium = DateFormat.getTimeInstance(DateFormat.MEDIUM);
			jta.append(medium.format(dt) + " client" + jtf.getText() + ":" + "\r\n");
			jtf.setText("");
			pw.flush();
		}

		this.jl.setText("当前时间" + Calendar.getInstance().getTime().toLocaleString());
	}
}
