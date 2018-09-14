import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;


public class Caculate extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public Caculate() {	

		JButton btnNewButton = new JButton("1");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton.setBounds(1, 80, 114, 78);
		btnNewButton.addActionListener(new NumberListener());
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(1, 2, 114, 78);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(115, 2, 114, 78);
		add(label_1);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		textField.setBounds(1, 2, 456, 78);
		textField.setText("0");
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(343, 2, 114, 78);
		add(label_2);
		add(btnNewButton);
		
		JButton button = new JButton("2");
		button.setBackground(Color.YELLOW);
		button.setFont(new Font("宋体", Font.PLAIN, 26));
		button.setBounds(115, 80, 114, 78);
		button.addActionListener(new NumberListener());
		add(button);
		
		JButton button_1 = new JButton("3");
		button_1.setBackground(Color.YELLOW);
		button_1.setFont(new Font("宋体", Font.PLAIN, 26));
		button_1.setBounds(229, 80, 114, 78);
		button_1.addActionListener(new NumberListener());
		add(button_1);
		
		JButton button_7 = new JButton("+");
		button_7.setBackground(Color.PINK);
		button_7.setFont(new Font("宋体", Font.PLAIN, 26));
		button_7.setBounds(343, 80, 114, 78);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				s = textField.getText();
				if(textField.getText().equals("0")){
					textField.setText("0+");
				}
				else{
					textField.setText(s+"+");
				}
			}
		});
		add(button_7);
		
		JButton btnNewButton_3 = new JButton("6");
		btnNewButton_3.setBackground(Color.YELLOW);
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton_3.setBounds(229, 158, 114, 78);
		btnNewButton_3.addActionListener(new NumberListener());
		
		JButton btnNewButton_2 = new JButton("5");
		btnNewButton_2.setBackground(Color.YELLOW);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton_2.setBounds(115, 158, 114, 78);
		btnNewButton_2.addActionListener(new NumberListener());
		
		JButton btnNewButton_1 = new JButton("4");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton_1.setBounds(1, 158, 114, 78);
		btnNewButton_1.addActionListener(new NumberListener());
		add(btnNewButton_1);
		add(btnNewButton_2);
		add(btnNewButton_3);
		
		JButton button_8 = new JButton("-");
		button_8.setBackground(Color.PINK);
		button_8.setFont(new Font("宋体", Font.PLAIN, 26));
		button_8.setBounds(343, 158, 114, 78);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				s = textField.getText();
				if(textField.getText().equals("0")){
					textField.setText("0-");
				}
				else{
					textField.setText(s+"-");
				}
			}
		});
		add(button_8);
		
		JButton button_3 = new JButton("9");
		button_3.setBackground(Color.YELLOW);
		button_3.setFont(new Font("宋体", Font.PLAIN, 26));
		button_3.setBounds(229, 236, 114, 78);
		button_3.addActionListener(new NumberListener());
		
		JButton button_2 = new JButton("8");
		button_2.setBackground(Color.YELLOW);
		button_2.setFont(new Font("宋体", Font.PLAIN, 26));
		button_2.setBounds(115, 236, 114, 78);
		button_2.addActionListener(new NumberListener());
		
		JButton btnNewButton_4 = new JButton("7");
		btnNewButton_4.setBackground(Color.YELLOW);
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton_4.setBounds(1, 236, 114, 78);
		btnNewButton_4.addActionListener(new NumberListener());
		add(btnNewButton_4);
		add(button_2);
		add(button_3);
		
		JButton button_9 = new JButton("*");
		button_9.setBackground(Color.PINK);
		button_9.setFont(new Font("宋体", Font.PLAIN, 26));
		button_9.setBounds(343, 236, 114, 78);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				s = textField.getText();
				if(textField.getText().equals("0")){
					textField.setText("0*");
				}
				else{
					textField.setText(s+"*");
				}
			}
		});
		add(button_9);
		
		JButton button_5 = new JButton(".");
		button_5.setBackground(Color.PINK);
		button_5.setFont(new Font("宋体", Font.PLAIN, 26));
		button_5.setBounds(115, 314, 114, 78);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				s = textField.getText();
				if(textField.getText().equals("0")){
					textField.setText("0.");
				}
				else{
					textField.setText(s+".");
				}
			}
		});
		
		JButton button_4 = new JButton("0");
		button_4.setBackground(Color.YELLOW);
		button_4.setFont(new Font("宋体", Font.PLAIN, 26));
		button_4.setBounds(1, 314, 114, 78);
		button_4.addActionListener(new NumberListener());
		add(button_4);
		add(button_5);
		
		JButton button_6 = new JButton("=");
		button_6.setBackground(Color.PINK);
		button_6.setFont(new Font("宋体", Font.PLAIN, 26));
		button_6.setBounds(229, 314, 114, 78);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().indexOf("+")!=-1){
					String s[] = textField.getText().split("[+]");
					Double d1 = Double.parseDouble(s[0]);
					Double d2 = Double.parseDouble(s[1]);
					double d3 = d1+d2;
					String answer = String.valueOf(d3);
					textField.setText(answer);
				}
				else if(textField.getText().indexOf("-")!=-1){
					String s[] = textField.getText().split("[-]");
					Double d1 = Double.parseDouble(s[0]);
					Double d2 = Double.parseDouble(s[1]);
					double d3 = d1-d2;
					String answer = String.valueOf(d3);
					textField.setText(answer);
				}
				else if(textField.getText().indexOf("*")!=-1){
					String s[] = textField.getText().split("[*]");
					Double d1 = Double.parseDouble(s[0]);
					Double d2 = Double.parseDouble(s[1]);
					double d3 = d1*d2;
					String answer = String.valueOf(d3);
					textField.setText(answer);
				}
				else if(textField.getText().indexOf("/")!=-1){
					String s[] = textField.getText().split("[/]");
					Double d1 = Double.parseDouble(s[0]);
					Double d2 = Double.parseDouble(s[1]);
					double d3 = d1/d2;
					String answer = String.valueOf(d3);
					textField.setText(answer);
				}
				else
					textField.setText(textField.getText());
			}
		});
		add(button_6);
		
		JButton button_10 = new JButton("/");
		button_10.setBackground(Color.PINK);
		button_10.setFont(new Font("宋体", Font.PLAIN, 26));
		button_10.setBounds(343, 314, 114, 78);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String();
				s = textField.getText();
				if(textField.getText().equals("0")){
					textField.setText("0/");
				}
				else{
					textField.setText(s+"/");
				}
			}
		});
		add(button_10);
		
		JButton btnBackspace = new JButton("Backspace");
		btnBackspace.setBackground(Color.CYAN);
		btnBackspace.setFont(new Font("宋体", Font.PLAIN, 26));
		btnBackspace.setBounds(1, 392, 228, 78);
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() == 0){
					textField.setText("0");
				}
				else{
					int i = textField.getText().length();
					String str = new String();
					str = textField.getText().substring(0,i-1);
					textField.setText(str);		
					}
				}
		});
		add(btnBackspace);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(115, 392, 114, 78);
		add(label_3);
		
		JButton btnNewButton_5 = new JButton("C");
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 26));
		btnNewButton_5.setBounds(229, 392, 228, 78);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
			}
		});
		add(btnNewButton_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(343, 392, 114, 78);
		add(label_4);

	}
	public static void main(String[] args) {
		JFrame jf = new JFrame("计算器");
		jf.setBounds(550,300,476,520);
		jf.getContentPane().add(new Caculate());
		jf.setVisible(true);
	}
	//数字键的事件监听器
	public class NumberListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand()){
				case "1":
					String s = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("1");
					}
					else{
						textField.setText(s+"1");
					}
					break;
				case "2":
					String s1 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("2");
					}
					else{
						textField.setText(s+"2");
					}
					break;
				case "3":
					String s2 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("3");
					}
					else{
						textField.setText(s+"3");
					}
					break;
				case "4":
					String s3 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("4");
					}
					else{
						textField.setText(s+"4");
					}
					break;
				case "5":
					String s4 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("5");
					}
					else{
						textField.setText(s+"5");
					}
					break;
				case "6":
					String s5 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("6");
					}
					else{
						textField.setText(s+"6");
					}
					break;
				case "7":
					String s6 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("7");
					}
					else{
						textField.setText(s+"7");
					}
					break;
				case "8":
					String s7 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("8");
					}
					else{
						textField.setText(s+"8");
					}
					break;
				case "9":
					String s8 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("9");
					}
					else{
						textField.setText(s+"9");
					}
					break;
				case "0":
					String s9 = new String();
					s = textField.getText();
					if(textField.getText().equals("0")){
						textField.setText("0");
					}
					else{
						textField.setText(s+"0");
					}
					break;
				default:
					textField.setText(textField.getText());
					break;
			}
		}
		
	}
}
