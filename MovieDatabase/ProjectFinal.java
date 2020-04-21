import java.sql.*;
import java.util.Properties;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

class flag {
	static int flag;
	static Boolean closed,booked;

	static void setflag(int fl) {
		flag = fl;
	}
}

class page extends Canvas {
	Connection con;
	page m, m2, m3;
	JFrame frame = new JFrame("Movie Booking System");
	JFrame frame2;
	Popup p;
	static String error_message = "";
	JTextField t1 = new JTextField("Enter Username here");
	JPasswordField t2 = new JPasswordField("password");
	JButton login = new JButton("Login");
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel(),panel3 = new JPanel();
	JLabel lb = new JLabel("Now showing...");
	ImageIcon icon1 = new ImageIcon("img/interstellarr.jpg");
	JButton button1 = new JButton(icon1);
	ImageIcon icon2 = new ImageIcon("img/dunkirk.jpg");
	JButton button2 = new JButton(icon2);
	ImageIcon icon3 = new ImageIcon("img/avengers.jpg");
	JButton button3 = new JButton(icon3);
	ImageIcon icon4 = new ImageIcon("img/lotr.png");
	JButton button4 = new JButton(icon4);
	ImageIcon icon5 = new ImageIcon("img/bigil.jpg");
	JButton button5 = new JButton(icon5);
	ImageIcon icon6 = new ImageIcon("img/godfather.jpg");
	JButton button6 = new JButton(icon6);
	ImageIcon icon7 = new ImageIcon("img/terminator.jpg");
	JButton button7 = new JButton(icon7);
	ImageIcon icon8 = new ImageIcon("img/hp.jpg");
	JButton button8 = new JButton(icon8);
	ImageIcon icon9 = new ImageIcon("img/fc.jpg");
	JButton button9 = new JButton(icon9);
	JButton signup = new JButton("New User? Signup!");
	JTextField t1s = new JTextField("Enter Username here ");
	JTextField t3s = new JTextField("Enter Name here ");
	JTextField t4s = new JTextField("Enter Mobile Number here ");
	JPasswordField t2s = new JPasswordField("Password");
	JPasswordField t5s = new JPasswordField("Password");
	JButton signups = new JButton("Sign Up");
	JLabel lb1 = new JLabel(),lbb = new JLabel("Now Showing...");
	JButton[] sts = new JButton[200];
	JPanel stpan = new JPanel();
	JPanel bkpan = new JPanel();
	JButton bkbut = new JButton("Confirm Seats");
	String uname = new String();
	DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Random rand = new Random();
	ArrayList<String> booklist;

	void dbcnt() {
		m = new page();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Password0");
		} catch (Exception evv) {
			System.out.println(evv);
		}
	}

	public void paint(Graphics g) {
		if (flag.flag == 0) {
			Toolkit t = Toolkit.getDefaultToolkit();
			Image i = t.getImage("img/bgimage.jpg");
			g.drawImage(i, 0, 0, this);
		}

		if (flag.flag == 2 || flag.flag == 3) {
			g.setColor(Color.white);
			g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
			Image i = Toolkit.getDefaultToolkit().getImage("img/signup1.jpg");
			g.drawImage(i, 0, 0, this);
			g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 30));
			g.setColor(Color.white);
			g.drawString("Your Details", 350, 230);
			g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 22));
			g.drawString("Name:", 70, 310);
			g.drawString("Username:", 70, 370);
			g.drawString("Password:", 70, 430);
			g.drawString("Confirm Password:", 70, 490);
			g.drawString("Mobile Number:", 70, 550);
			g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 22));
			g.setColor(Color.red);
			if (flag.flag == 3)
				g.drawString(error_message, 340, 588);
		}

		if(flag.flag == 4){
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage("img/fffs.jpg");
		Image qr = t.getImage("img/download.jpg");
		String font = g.getFont().getFontName();
		g.drawImage(i, 0, 0, this);
		g.setFont(new Font("Calibri", Font.PLAIN, 60));
		g.setColor(new Color(0, 0, 0, 230));
		g.fillRect(615, 280, 340, 400);
		g.drawImage(qr, 690, 320, this);
		g.setColor(Color.white);
		g.drawString("Booking Placed!", 590, 170);
		g.setFont(new Font(font, Font.PLAIN, 25));
		g.drawString("Scan the QR code to Pay", 640, 560);
		g.drawString("    And confirm booking", 640, 600);
		String str = "";
		for(int j = 0; j < 10; j++){
			int a = (int) (Math.random() * 10) % 3;
			if (a == 0) {
				int b = (int) (Math.random() * 100) % 26;
				str += (char) (b + 65);
			} else if (a == 1) {
				int c = (int) (Math.random() * 100) % 26;
				str += (char) (c + 97);
			} else {
				int d = (int) (Math.random() * 10) % 10;
				str += (char) (d + 48);
			}
		}
		g.drawString("Booking ID: "+ str, 660, 660);
		}
	}

	void signuppg() {
		frame2 = new JFrame("Signup Page");
		frame2.setSize(1000, 800);
		frame2.setVisible(true);
		flag.setflag(2);
		m2 = new page();
		t1s.setBounds(340, 350, 380, 30);
		t2s.setBounds(340, 410, 380, 30);
		t3s.setBounds(340, 290, 380, 30);
		t4s.setBounds(340, 530, 380, 30);
		t5s.setBounds(340, 470, 380, 30);
		signups.setBounds(450, 600, 130, 30);
		frame2.getContentPane().add(t1s);
		frame2.add(t2s);
		frame2.add(t3s);
		frame2.add(t4s);
		frame2.add(t5s);
		frame2.add(signups);	
		frame2.add(m2);
		frame2.validate();
		frame2.repaint();
		signups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					uname = t1s.getText().trim();
					String pwds = String.valueOf(t2s.getPassword());
					String cnf = String.valueOf(t5s.getPassword());
					String names = t3s.getText();
					String mbnum = t4s.getText();
					Statement stms = con.createStatement();
					Boolean error = false;
					if (stms.executeUpdate("select * from user1 where uname = \'" + uname + "\'") > 0) {
						error = true;
						error_message = "Username already taken";
					} else if (pwds.compareTo(cnf) != 0) {
						error = true;
						error_message = "Passwords Do not match";
					} else if (mbnum.length() != 10) {
						error = true;
						error_message = "Invalid Mobile Number";
					} else if (mbnum.length() == 10) {
						for (int i = 0; i < 10; i++)
							if (!(mbnum.charAt(i) >= '0' && mbnum.charAt(i) <= '9')) {
								error = true;
								error_message = "Invalid Mobile Number";
								break;
							}
					}
					if (error) {
						frame2.dispose();
						flag.setflag(3);
						frame2 = new JFrame("Signup Page");
						frame2.setSize(1000, 800);
						frame2.setVisible(true);
						m2 = new page();
						t1s.setBounds(340, 350, 380, 30);
						t2s.setBounds(340, 410, 380, 30);
						t3s.setBounds(340, 290, 380, 30);
						t4s.setBounds(340, 530, 380, 30);
						t5s.setBounds(340, 470, 380, 30);
						signups.setBounds(450, 600, 130, 30);
						frame2.getContentPane().add(t1s);
						frame2.add(t2s);
						frame2.add(t3s);
						frame2.add(t4s);
						frame2.add(t5s);
						frame2.add(signups);
						// frame2.add(ms);
						frame2.add(m2);
						frame2.validate();
						frame2.repaint();

					} else {
						if (stms.executeUpdate("insert into user1 values(\'" + uname + "\',\'" + pwds + "\',\'" + names
								+ "\'," + mbnum + ")") > 0){
							frame2.dispose();
							lb1.setText("Signup successful!");
					}
					}
				} catch (Exception ev) {
					System.out.println(ev);
				}
			}
		});
	}

	void login() {
		frame.setSize(1000, 800);
		login.setBounds(125, 180, 80, 30);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stm = con.createStatement();
					uname = t1.getText();
					ResultSet res = stm.executeQuery("select password from user1 where uname=\'" + uname + "\'");
					String dbpwd = "";
					String pwd = String.valueOf(t2.getPassword());
					while (res.next()) {
						dbpwd = res.getString(1);
					}
					if (dbpwd.compareTo(pwd) == 0) {
						res = stm.executeQuery("select name from user1 where uname = \'" + uname + "\'");
						String x = "";
						while (res.next())
							x = res.getString(1);
						mov(x);
					} else {
						flag.setflag(1);
						lb1.setText("Invalid Username or Password");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				signuppg();
			}
		});
		signup.setBounds(80, 220, 160, 30);
		t2.setBounds(80, 140, 180, 30);
		t1.setBounds(80, 100, 180, 30);
		lb1.setBounds(80, 78, 200, 20);
		lb1.setBackground(Color.black);
		lb1.setOpaque(true);
		lb1.setForeground(Color.red);
		frame.getContentPane().add(t1);
		frame.getContentPane().add(t2);
		frame.getContentPane().add(login);
		frame.getContentPane().add(signup);
		frame.getContentPane().add(lb1);
		frame.getContentPane().add(m);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}


	void seats(int movid) {
		frame.dispose();
		frame = new JFrame("Select seats");
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		String movvid = String.valueOf(movid);
		String dat = "";
		booklist = new ArrayList<String>();
		try {
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery("select seat from booking where screenid=" + movvid);
			while (res.next()) {
				dat += "$";
				dat += res.getString(1);
			}
		} catch (Exception exx) {
			System.out.println(exx);
		}
		char ch='A';
        for(int i=0,num=1;i<200;i++,num++)
        {
            if(i%17==0)
            {
                ch++;
                num=1;
            }
           
            String s1 = "";
            if(ch == 'I')
            s1 += "  ";
            if(ch =='J'||ch == 'F')
            s1+=" ";
            s1 += ch;
            s1 += num;
			sts[i] = new JButton(s1);
			sts[i].setBackground(Color.white);
			stpan.setBackground(Color.gray);
			if (dat.contains(s1.trim())) {
				sts[i].setBackground(Color.gray);
				sts[i].setEnabled(false);
			} else {
				sts[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent rx) {
						JButton source = (JButton)rx.getSource();
						if (source.getBackground() == Color.white) {
							source.setBackground(Color.green);
							booklist.add(source.getText().trim());
						} else {
							source.setBackground(Color.white);
							booklist.remove(source.getText().trim());
						}
					}
				});
			}
			stpan.add(sts[i]);
			bkbut.setFont(new Font(bkbut.getFont().getFontName(),0,33));
			bkbut.setBounds(270,600,400,60);
			JLabel eyes = new JLabel("                                                           All eyes this way please");
			eyes.setBackground(Color.white);
			eyes.setForeground(Color.red);
			eyes.setOpaque(true);
			eyes.setFont(new Font(bkbut.getFont().getFontName(),Font.ITALIC,22));
			eyes.setBounds(0, 735, 1000, 30);
			
			frame.getContentPane().add(bkbut);
			frame.getContentPane().add(eyes);
			flag.closed = true;
			frame.getContentPane().add(BorderLayout.CENTER,stpan);
			flag.booked = false;
			bkbut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent wx){
					if(booklist.size()==0 && flag.closed)
					{
						JFrame warn = new JFrame("Warning");
						flag.closed = false;
						warn.setSize(400,150);
						warn.setVisible(true);
						warn.setResizable(false);
						JButton choice = new JButton("OK");
						JLabel msg = new JLabel("No Seats Selected!");
						msg.setFont(new Font(bkbut.getFont().getFontName(),Font.ITALIC,30));
						choice.setFont(new Font(bkbut.getFont().getFontName(),0,18));
						JPanel buttonpanel = new JPanel();
						JPanel msgpanel = new JPanel();
						String temp = "                          ";
						buttonpanel.add(choice);
						msgpanel.add(new JLabel(temp));
						msgpanel.add(new JLabel(temp));
						msgpanel.add(new JLabel(temp));
						msgpanel.add(msg);
						warn.getContentPane().add(BorderLayout.SOUTH,buttonpanel);
						warn.getContentPane().add(BorderLayout.CENTER,msgpanel);
						choice.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent ae){
								warn.dispose();
								flag.closed = true;
							}
						});
					}
					else if(booklist.size()>0 && !flag.booked){
					try{
					Statement stm = con.createStatement();
					stm.executeUpdate("alter session set NLS_DATE_FORMAT = \'yyyy/mm/dd hh24:mi:ss\'");
						for (int i = 0; i < booklist.size(); i++) {
								stm.executeUpdate("insert into booking values(\'" + uname + "\'," 
								+ movid + ",\'" + booklist.get(i)+"\',\'"+df.format(new java.util.Date())+"\')");
							}
							frame.dispose();
							flag.flag = 4;
							bkbut.removeAll();
							flag.booked = true;
							payment();
						}
					catch(Exception e){
						System.out.println(e);
					}
					}
				}
			});
		}
	}

	void mov(String user) {
		frame.remove(t1);
		frame.remove(t2);
		frame.remove(login);
		frame.remove(lb1);
		frame.remove(m);
		frame.remove(signup);
		lb.setFont(new Font(lb.getFont().getFontName(), Font.ITALIC, 30));
		lbb.setFont(new Font(lb.getFont().getFontName(), Font.TRUETYPE_FONT, 30));
		lb.setForeground(Color.red);
		lbb.setForeground(Color.red);
		lb.setText("Welcome, " + user + "!");
		panel2.add(lb);
		panel.setBackground(Color.black);
		panel2.setBackground(Color.black);
		panel3.add(lbb);
		panel3.setBackground(Color.black);
		panel.setBackground(Color.black);
		button1.setBackground(Color.black);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button2.setBackground(Color.black);
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button3.setBackground(Color.black);
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false);
		button4.setBackground(Color.black);
		button4.setBorderPainted(false);
		button4.setContentAreaFilled(false);
		button5.setBackground(Color.black);
		button5.setBorderPainted(false);
		button5.setContentAreaFilled(false);
		button6.setBackground(Color.black);
		button6.setBorderPainted(false);
		button6.setContentAreaFilled(false);
		button7.setBackground(Color.black);
		button7.setContentAreaFilled(false);
		button7.setBorderPainted(false);
		button8.setBackground(Color.black);
		button8.setBorderPainted(false);
		button8.setContentAreaFilled(false);
		button9.setBackground(Color.black);
		button9.setBorderPainted(false);
		button9.setContentAreaFilled(false);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov1) {
				seats(1);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov2) {
				seats(2);
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov3) {
				seats(3);
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov4) {
				seats(4);
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov5) {
				seats(5);
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov6) {
				seats(6);
			}
		});
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov7) {
				seats(7);
			}
		});
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov8) {
				seats(8);
			}
		});
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent mov1) {
				seats(9);
			}
		});
		frame.add(BorderLayout.NORTH, panel2);
		frame.add(BorderLayout.CENTER, panel);
		frame.add(BorderLayout.SOUTH, panel3);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void payment()
	{
		frame = new JFrame();
		m2 = new page();
		frame.add(m2);
		frame.setSize(1000,800);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.validate();
		frame.repaint();
	}
}
public class ProjectFinal {
	public static void main(String args[]) {
		flag.setflag(0);
		page pg = new page();
		pg.dbcnt();
		pg.login();

	}
}