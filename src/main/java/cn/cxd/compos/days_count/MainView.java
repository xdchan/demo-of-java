package cn.cxd.compos.days_count;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainView extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new MainView();
	}

	private static final long serialVersionUID = 1L;

	JLabel jl_start = null; // 0
	JLabel jl_end = null; // 1
	JLabel jl_year1 = null; // 2
	JLabel jl_year2 = null; // 3
	JLabel jl_month1 = null; // 4
	JLabel jl_month2 = null; // 5
	JLabel jl_day1 = null; // 6
	JLabel jl_day2 = null; // 7
	JLabel jl_res = null; // 8
	JLabel jl_out = null; // 9

	JTextField jtf_year1 = null;
	JTextField jtf_year2 = null;
	JTextField jtf_month1 = null;
	JTextField jtf_month2 = null;
	JTextField jtf_day1 = null;
	JTextField jtf_day2 = null;

	List<JTextField> textFieldList = null;

	JButton jb_sure = null;
	JButton jb_cancel = null;

	static String startDate = "1990-01-01";
	static String endDate = "1990-01-02";
	static int dayCount = 1;
	static String outInfo = "从 " + startDate + " 到 " + endDate + " 共有 " + dayCount + " 天。";

	DaysCompute dc = null;

	public MainView() {

		textFieldList = new ArrayList<JTextField>();

		this.setLayout(null);

		jl_start = new JLabel("开始日期");
		jl_start.setBounds(5, 5, 60, 30);
		jl_end = new JLabel("结束日期");
		jl_end.setBounds(250, 5, 60, 30);
		this.add(jl_start);
		this.add(jl_end);

		jtf_year1 = new JTextField();
		jtf_year1.setBounds(5, 40, 50, 20);
		jtf_year1.setHorizontalAlignment(JTextField.CENTER);
		textFieldList.add(jtf_year1);
		jl_year1 = new JLabel("年");
		jl_year1.setBounds(60, 40, 20, 20);
		this.add(jtf_year1);
		this.add(jl_year1);

		jtf_month1 = new JTextField();
		jtf_month1.setBounds(80, 40, 30, 20);
		jtf_month1.setHorizontalAlignment(JTextField.CENTER);
		textFieldList.add(jtf_month1);
		jl_month1 = new JLabel("月");
		jl_month1.setBounds(115, 40, 20, 20);
		this.add(jtf_month1);
		this.add(jl_month1);

		jtf_day1 = new JTextField();
		jtf_day1.setBounds(135, 40, 30, 20);
		jtf_day1.setHorizontalAlignment(JTextField.CENTER);
		textFieldList.add(jtf_day1);
		jl_day1 = new JLabel("日");
		jl_day1.setBounds(170, 40, 20, 20);
		this.add(jtf_day1);
		this.add(jl_day1);

		jtf_year2 = new JTextField();
		jtf_year2.setBounds(250, 40, 50, 20);
		jtf_year2.setHorizontalAlignment(JTextField.CENTER);
		textFieldList.add(jtf_year2);
		jl_year2 = new JLabel("年");
		jl_year2.setBounds(305, 40, 20, 20);
		this.add(jtf_year2);
		this.add(jl_year2);

		jtf_month2 = new JTextField();
		jtf_month2.setBounds(330, 40, 30, 20);
		jtf_month2.setHorizontalAlignment(JTextField.CENTER);
		textFieldList.add(jtf_month2);
		jl_month2 = new JLabel("月");
		jl_month2.setBounds(365, 40, 20, 20);
		this.add(jtf_month2);
		this.add(jl_month2);

		jtf_day2 = new JTextField();
		jtf_day2.setBounds(390, 40, 30, 20);
		jtf_day2.setHorizontalAlignment(JTextField.CENTER);
		textFieldList.add(jtf_day2);
		jl_day2 = new JLabel("日");
		jl_day2.setBounds(425, 40, 20, 20);
		this.add(jtf_day2);
		this.add(jl_day2);

		jb_cancel = new JButton("清空");
		jb_cancel.setActionCommand("clear");
		jb_cancel.addActionListener(this);
		jb_cancel.setBounds(250, 75, 60, 20);
		jb_sure = new JButton("确定");
		jb_sure.setActionCommand("sure");
		jb_sure.addActionListener(this);
		jb_sure.setBounds(330, 75, 60, 20);
		this.add(jb_cancel);
		this.add(jb_sure);

		jl_res = new JLabel("计算结果如下。。。。");
		jl_res.setBounds(5, 105, 250, 20);
		this.add(jl_res);

		jl_out = new JLabel(outInfo);
		jl_out.setBounds(5, 135, 350, 20);
		this.add(jl_out);

		// 设置JFrame属性
		this.setBounds(400, 250, 450, 300);
		this.setVisible(true);
		this.setTitle("Days count");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("clear")) {

			for (int i = 0; i < textFieldList.size(); i++) {

				textFieldList.get(i).setText("");
			}

		} else if (e.getActionCommand().equals("sure")) {

			startDate = jtf_year1.getText() + "-" + jtf_month1.getText() + "-" + jtf_day1.getText();
			endDate = jtf_year2.getText() + "-" + jtf_month2.getText() + "-" + jtf_day2.getText();
			dc = new DaysCompute();

			long dayCount = dc.compute(startDate, endDate);

			if (dayCount < 0) {
				// 弹出提示信息
				JOptionPane.showMessageDialog(null, "日期输入有误", "输入错误", JOptionPane.ERROR_MESSAGE);
			} else {
				outInfo = "从 " + startDate + " 到 " + endDate + " 共有 " + dayCount + " 天。";
				jl_out.setText(outInfo);
			}
			if (startDate.equals("1935-11-01") || startDate.equals("1935-11-1") || endDate.equals("1935-11-01")
					|| endDate.equals("1935-11-1")) {
				String info = "仅以此软件纪念我逝去的奶奶，1935-11-1是我奶奶出生的日子。";
				JOptionPane.showMessageDialog(null, info, "纪念", JOptionPane.INFORMATION_MESSAGE);
			}

			if (startDate.equals("2017-12-08") || startDate.equals("2017-12-8") || endDate.equals("2017-12-08")
					|| endDate.equals("2017-12-8")) {
				Calendar c = Calendar.getInstance();
				String sDate = "2017-12-8";
				String eDate = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-"
						+ c.get(Calendar.DAY_OF_MONTH);
				long leftCount = dc.compute(sDate, eDate);

				String info = "仅以此软件纪念我逝去的奶奶，2017-12-8是我奶奶永远离开我们的日子。今天是她离开我们的第 " + leftCount + " 天";
				JOptionPane.showMessageDialog(null, info, "纪念", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
