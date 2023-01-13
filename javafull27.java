import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;

/** @see http://stackoverflow.com/questions/3617326 */
public class MarqueeTest {

    private void display() {
        JFrame f = new JFrame("MarqueeTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String s = "thank you for using this website "
        + "creeps in this petty pace from day to day, "
        + "to the last syllable of recorded time; ... "
        + "It is a tale told by an idiot, full of "
        + "sound and fury signifying nothing.";
        MarqueePanel mp = new MarqueePanel(s, 32);
        f.add(mp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        mp.start();
    }

   
public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MarqueeTest().display();
            }
        });

new Reg();
    }

}

/** Side-scroll n characters of s. */
class MarqueePanel extends JPanel implements ActionListener {

    private static final int RATE = 12;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private final String s;
    private final int n;
    private int index;

    public MarqueePanel(String s, int n) {
        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
        label.setFont(new Font("Serif", Font.ITALIC, 36));
        label.setText(sb.toString());
        this.add(label);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        label.setText(s.substring(index, index + n));
    }
}




/* create table login(name varchar(15),age number(4),username varchar(30),password varchar(30),address varchar(60));    for admin
create table ulogin(name varchar(15),age number(4),username varchar(30),password varchar(30));    for user
create table stock(itemid number(7),iname varchar(20),quantity number(7),iprice number(7),details varchar(40));  for stocks insertion
create table ques(name varchar(30),ans varchar(30));     for forgotten password
create table paydetails(name number(30),card number(20),cvv number(5),my number(7));
create table ques(name varchar(30),feed varchar(100));
*/





class Reg implements ActionListener
{                                                   //first user,admin login page1
Frame f;
JLabel l2;
JButton l1,l3,l4;
Reg()
{
f=new Frame("USER,ADMIN LOGIN");
l1=new JButton("Admin ");
l2=new JLabel(new ImageIcon("screen11.jpgh"));
l3=new JButton("user ");
l4=new JButton("exit");
f.setVisible(true);
f.setSize(700,700);
f.add(l2);
l2.add(l1);
l2.add(l3);
l2.add(l4);

l1.setBounds(30,70,304,56);
l3.setBounds(30,150,304,56);
l4.setBounds(30,230,304,56);
l1.addActionListener(this);
l3.addActionListener(this);
l4.addActionListener(this);
}
public void actionPerformed(ActionEvent aa)
{
if(aa.getSource().equals(l1))
{f.setVisible(false);
new Login4();
}
else if(aa.getSource().equals(l3))
{f.setVisible(false);
new Login3();
}
else
{
f.setVisible(false);
}
}

}






class Login3 implements ActionListener
{JFrame f;                                                      //login page for user
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2;
JPasswordField p1;
JButton b1,b2,b3,b4;
ImageIcon i1,i2;
Login3()
{
f=new JFrame("USER LOGIN");

l5=new JLabel(new ImageIcon("screen11.jhpg"));
l1=new JLabel("username");
l6=new JLabel("security question)when is your birthday");
l4=new JLabel(new ImageIcon("screen2.jphg"));
l2=new JLabel("password");
l3=new JLabel("forgotten the password...!!!click the button");
t1=new JTextField(10);
t2=new JTextField(10);
p1=new JPasswordField(10);
b1=new JButton("sign up");
b2=new JButton("Login");
b3=new JButton("click here");
b4=new JButton("exit");
f.setVisible(true);
f.setSize(700,700);
f.add(l4);
l4.add(l1);
l4.add(t1);

l4.add(l2);
l4.add(p1);
l4.add(b1);
l4.add(b2);
l4.add(l3);
l4.add(b3);
l4.add(b4);
l4.add(l5);
l1.setBounds(30,70,304,56);
l2.setBounds(30,150,304,56);
b1.setBounds(30,230,304,56);
t1.setBounds(350,70,304,56);
p1.setBounds(350,150,304,56);
l3.setBounds(30,300,304,56);
b2.setBounds(350,230,304,56);
b3.setBounds(350,300,304,56);
b4.setBounds(230,400,304,56);
l5.setBounds(501,0,1200,1100);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b1))
{
new Regis(f,t1,p1);
f.setVisible(false);
}
else if(ae.getSource().equals(b2))
{
try
{
String s1=t1.getText();
String s2=p1.getText();
//System.out.println(s1+"  "+s2);
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select username,password from Ulogin");
int i=1;
while(rs.next())
{
String s3=rs.getString(1);
String s4=rs.getString(2);
// System.out.println("the name \n"+s3+" the password is"+s4);
if(s3.equals(s1))
{if(s4.equals(s2))
{//System.out.println("equal");
JOptionPane.showMessageDialog(null,"logined successfully");
new SSt(t1);
f.setVisible(false);
}
}
}

}
catch(Exception eee)
{}


}
else if(ae.getSource().equals(b3))
{new PassWo();
f.setVisible(false);
}
else
{f.setVisible(false);
}
}

}

class Login4 implements ActionListener
{JFrame f;                                                 //login page for admin
JLabel l1,l2,l3,l4;
JTextField t1;
JPasswordField p1;
Button b1,b2,b3,b4;
Login4()
{
f=new JFrame("ADMIN LOGIN");
l1=new JLabel("username");
l4=new JLabel(new ImageIcon("screen2.jphg"));
l2=new JLabel("password");
l3=new JLabel("forgotten the password...!!!click the button");
t1=new JTextField(10);
p1=new JPasswordField(10);
b1=new Button("sign up");
b2=new Button("login");
b3=new Button("click here");
b4=new Button("exit");
f.setVisible(true);
f.setSize(700,700);
f.add(l4);
l4.add(l1);
l4.add(t1);
l4.add(l2);
l4.add(p1);
l4.add(b1);
l4.add(b2);
l4.add(l3);
l4.add(b3);
l4.add(b4);
l1.setBounds(30,70,304,56);
l2.setBounds(30,150,304,56);
b1.setBounds(30,230,304,56);
t1.setBounds(350,70,304,56);
p1.setBounds(350,150,304,56);
l3.setBounds(30,300,304,56);
b2.setBounds(350,230,304,56);
b3.setBounds(350,300,304,56);
b4.setBounds(230,400,304,56);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b1))
{
new Regis1(f,t1,p1);
f.setVisible(false);
}
else if(ae.getSource().equals(b2))
{
try
{
String s1=t1.getText();
String s2=p1.getText();
System.out.println(s1+"  "+s2);
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select username,password from login");
int i=1;
while(rs.next())
{
String s3=rs.getString(1);
String s4=rs.getString(2);
// System.out.println("the name \n"+s3+" the password is"+s4);
if(s3.equals(s1))
{if(s4.equals(s2))
{
JOptionPane.showMessageDialog(null,"login successfully");
new Stock();
f.setVisible(false);
}
}
}
}
catch(Exception eee)
{}

}
else if(ae.getSource().equals(b3))
{new PassWo1();
f.setVisible(false);
}
else
{f.setVisible(false);
}
}
}


class Regis1 implements ActionListener 
{JFrame m1,f1;                                                            //registration page for admin
JLabel l1,l2,l3,l4,l5,l6,ll,l7;
JPasswordField p1,p2;
JTextArea a1;
JRadioButton r1,r2;
ButtonGroup g1;
Button b1,b2;
JTextField t1,t2,t3,t4,t5,t7;

Regis1(JFrame f2,JTextField t6,JPasswordField p3)
{ m1=f2;
p2=p3;

 t3=t6;
m1.setVisible(false);

f1=new JFrame("registration ADMIN");
g1=new ButtonGroup();
l1=new JLabel("name");
l7=new JLabel("Q1)whats your birthday month");
ll=new JLabel(new ImageIcon("screen.jphg"));
l2=new JLabel("age");
l3=new JLabel("gender");
l6=new JLabel("address");
a1=new JTextArea();
b1=new Button("submit");
b2=new Button("cancel");
l4=new JLabel("username");
l5=new JLabel("password");
r1=new JRadioButton("male");
r2=new JRadioButton("female");
p1=new JPasswordField(10);
t1=new JTextField(10);
t2=new JTextField(10);
t7=new JTextField(10);
t4=new JTextField(10);
t5=new JTextField(10);
f1.setVisible(true);
f1.setSize(700,700);
f1.add(ll);
g1.add(r1);
g1.add(r2);
ll.add(l1);
ll.add(t1);
ll.add(l7);
ll.add(t7);
ll.add(l2);
ll.add(t2);
ll.add(l3);
ll.add(r1);
ll.add(r2);
ll.add(l4);
ll.add(t4);
ll.add(l5);
ll.add(t5);
ll.add(l6);
ll.add(a1);
ll.add(b1);
ll.add(b2);

l1.setBounds(30 ,70,250,56);
t1.setBounds(350,70,250,56);
l2.setBounds(30,150,250,56);
t2.setBounds(350,150,250,56);
l3.setBounds(230,230,250,56);
r1.setBounds(30,300,250,56);
r2.setBounds(350,300,250,56);
l4.setBounds(30,370,250,56);
t4.setBounds(350,370,250,56);
l5.setBounds(30,450,250,56);
t5.setBounds(350,450,250,56);
l7.setBounds(30,530,250,56);
t7.setBounds(350,530,250,56);
l6.setBounds(30,600,250,56);
a1.setBounds(350,600,250,56);
b1.setBounds(30,670,250,56);
b2.setBounds(350,670,250,56);

b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b1))
{
try
{
String s1=t1.getText();
int s2=Integer.parseInt(t2.getText());
String s3=t4.getText();
String s4=t5.getText();
String s5=a1.getText();
//System.out.println(t7.getText());
String s6=t7.getText();
//System.out.println("the text is"+s6);

DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c.prepareStatement("insert into login values(?,?,?,?,?)");
PreparedStatement ps1=c.prepareStatement("insert into ques values(?,?)");
ps.setString(1,s1);
ps.setInt(2,s2);
ps.setString(3,s3);
ps.setString(4,s4);
ps.setString(5,s5);
ps1.setString(2,s6);
ps1.setString(1,s3);
int m=ps.executeUpdate();
int mu=ps1.executeUpdate();
if(m==1)
{
JOptionPane.showMessageDialog(null,"registration is completed");
new Login4();
f1.setVisible(false);

}

ps.close();
ps1.close();
c.close();

}
catch(Exception aa)
{}


}
else
{f1.setVisible(false);
}
}


}





class Regis implements ActionListener
{JFrame m,f1;                                         //registration for user

JLabel l1,l2,l3,l4,l5,ll,l7;
JPasswordField p1,p2;
JRadioButton r1,r2;
ButtonGroup g1;
Button b1,b2;
JTextField t1,t2,t3,t4,t5,t7;
Regis(JFrame f2,JTextField t6,JPasswordField p3)
{m=f2;
p2=p3;
t3=t6;
m.setVisible(false);
f1=new JFrame("registration USER");
g1=new ButtonGroup();
l1=new JLabel("name");
l7=new JLabel("Q)whats your birthday month??");
ll=new JLabel(new ImageIcon("screen.jphg"));
l2=new JLabel("age");
l3=new JLabel("gender");
b1=new Button("submit");
b2=new Button("cancel");
l4=new JLabel("username");
l5=new JLabel("password");
r1=new JRadioButton("male");
r2=new JRadioButton("female");
p1=new JPasswordField(10);
t1=new JTextField(10);
t2=new JTextField(10);
t4=new JTextField(10);
t7=new JTextField(10);
t5=new JTextField(10);
f1.setVisible(true);
f1.setSize(700,700);
f1.setBackground(Color.red);

f1.add(ll);
g1.add(r1);
g1.add(r2);
ll.add(l1);
ll.add(t1);
ll.add(l7);
ll.add(t7);
ll.add(l2);
ll.add(t2);
ll.add(l3);
ll.add(r1);
ll.add(r2);
ll.add(l4);
ll.add(t4);
ll.add(l5);
ll.add(t5);
ll.add(b1);
ll.add(b2);

l1.setBounds(30 ,70,250,56);
t1.setBounds(350,70,250,56);
l2.setBounds(30,150,250,56);
t2.setBounds(350,150,250,56);
l3.setBounds(230,230,250,56);
r1.setBounds(30,300,250,56);
r2.setBounds(350,300,250,56);
l4.setBounds(30,370,250,56);
t4.setBounds(350,370,250,56);
l7.setBounds(30,450,250,56);
t7.setBounds(350,450,250,56);
l5.setBounds(30,530,250,56);
t5.setBounds(350,530,250,56);
b1.setBounds(30,600,250,56);
b2.setBounds(350,600,250,56);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b1))
{
try
{
String s1=t1.getText();
int s2=Integer.parseInt(t2.getText());
String s3=t4.getText();
String s4=t5.getText();
String s5=t7.getText();
//System.out.println(s1+s2+s3+s4+s5);
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c.prepareStatement("insert into ulogin values(?,?,?,?)");
PreparedStatement ps1=c.prepareStatement("insert into ques values(?,?)");
ps.setString(1,s1);
ps.setInt(2,s2);
ps.setString(3,s3);
ps.setString(4,s4);
ps1.setString(2,s5);
ps1.setString(1,s3);
int m=ps.executeUpdate();
ps1.executeUpdate();
if(m==1)
{
JOptionPane.showMessageDialog(null,"successfully registered");
new Login3();
f1.setVisible(false);
}
ps.close();
ps1.close();
c.close();

}
catch(Exception aa)
{}


}

else
{f1.setVisible(false);
}
}
}


class Stock implements ActionListener
{                                                                   //admin stock
JFrame f;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4;
JLabel l1,l2,l3,l4,l5,ll;
ImageIcon i;
JTextArea tt1;
Stock()
{
f=new JFrame("Stock:");
b1=new JButton("insert ");
b2=new JButton("delete ");
b3=new JButton("Exit ");
l1=new JLabel("ItemId");
ll=new JLabel(new ImageIcon("screen.jphg"));
l2=new JLabel("Item Name ");
l3=new JLabel("quantity (in KGs) ");
l4=new JLabel(" Item Price(Rs/kg)");
l5=new JLabel("stock details");
t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);
tt1=new JTextArea();
f.setVisible(true);
f.setSize(700,700);
f.add(ll);
ll.add(l1);
ll.add(t1);
ll.add(l2);
ll.add(t2);
ll.add(l3);
ll.add(t3);
ll.add(l4);
ll.add(t4);
ll.add(l5);
ll.add(tt1);
ll.add(b1);
ll.add(b2);
ll.add(b3);
l1.setBounds(30 ,70,250,56);
t1.setBounds(350,70,250,56);
l2.setBounds(30,150,250,56);
t2.setBounds(350,150,250,56);

l3.setBounds(30,300,250,56);
t3.setBounds(350,300,250,56);
l4.setBounds(30,370,250,56);
t4.setBounds(350,370,250,56);
l5.setBounds(30,450,250,56);
tt1.setBounds(350,450,250,56);
b1.setBounds(30,600,250,56);
b2.setBounds(350,600,250,56);
b3.setBounds(230,670,250,56);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource().equals(b1))
{
try
{
String s2=t2.getText();
int s1=Integer.parseInt(t1.getText());
int s3=Integer.parseInt(t3.getText());
int s4=Integer.parseInt(t4.getText());
String s5=tt1.getText();
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c.prepareStatement("insert into Stock values(?,?,?,?,?)");
ps.setInt(1,s1);
ps.setString(2,s2);
ps.setInt(3,s3);
ps.setInt(4,s4);
ps.setString(5,s5);
int m=ps.executeUpdate();
if(m==1)
JOptionPane.showMessageDialog(null,"inserted");
ps.close();
c.close();
}
catch(Exception eee)
{}

}
else if(ae.getSource().equals(b2))
{
try
{
String s2=t2.getText();
int s1=Integer.parseInt(t1.getText());
int s3=Integer.parseInt(t3.getText());
int s4=Integer.parseInt(t4.getText());
String s5=tt1.getText();
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c.prepareStatement("delete from Stock where itemid= ? ");
ps.setInt(1,s1);
int m=ps.executeUpdate();
if(m==1)
JOptionPane.showMessageDialog(null,"deleted");
ps.close();
c.close();
}
catch(Exception eee)
{}

}
else
{f.setVisible(false);
}
}




}



class SSt implements ActionListener
{                                                                     //Stocks selecting
Frame f;
JButton b1,b2,b3;
JLabel l1,l2,l3,l4,l5,ll,l6;
JTextField t1,t2,t3,t4;
JTextArea t11;
int total;
SSt(JTextField tt1)
{t4=tt1;
f=new Frame("Selecting stock");
ll=new JLabel(new ImageIcon("screen.jphg"));
b1=new JButton("payment");
b2=new JButton("Exit");
l1=new JLabel("stock name");
l6=new JLabel("stock holder");
l2=new JLabel("quantity(in KGs)");
l3=new JLabel("details");
l5=new JLabel("the amounnt of the stock is");
l4=new JLabel("after showing the details only u have to go the payment option");
b3=new JButton("stock details");
t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);
t11=new JTextArea();
f.setVisible(true);
f.setSize(700,700);
f.add(ll);
ll.add(l1);
ll.add(t1);
ll.add(l2);
ll.add(t2);
ll.add(b3);
ll.add(l3);
ll.add(t11);
ll.add(l5);
ll.add(t3);
ll.add(l4);
ll.add(l6);
ll.add(t4);
ll.add(b1);
ll.add(b2);
ll.add(t11);
l1.setBounds(30 ,70,250,56);
t1.setBounds(350,70,250,56);
l2.setBounds(30,150,250,56);
t2.setBounds(350,150,250,56);
b3.setBounds(130,230,250,56);
l3.setBounds(30,300,250,56);
t11.setBounds(350,300,250,56);
l5.setBounds(30,370,250,56);
t3.setBounds(350,370,250,56);
l4.setBounds(30,450,250,56);
b1.setBounds(30,600,250,56);
b2.setBounds(350,600,250,56);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b3))
{
try
{
String s1=t1.getText();
int s2=Integer.parseInt(t2.getText());
System.out.println(s1);
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select iname,quantity,details,iprice from Stock");
while(rs.next())
{String s3=rs.getString(1);
int s4=rs.getInt(2);
String s5=rs.getString(3);
int s6=rs.getInt(4);
//System.out.println(s3+"  "+s4+"  "+s5+"  "+s6);

 if(s1.equals(s3))
{JOptionPane.showMessageDialog(null,"stock is selected");
if(s2<s4)
{JOptionPane.showMessageDialog(null,"quantity is selected");
t11.setText(s5);
int t=s2*s6;
int mun=s4-s2;
t3.setText(String.valueOf(s2*s6));
String s7=t3.getText();
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c1.prepareStatement("insert into spurchase values(?,?,?)");
PreparedStatement ps1=c1.prepareStatement("update stock set quantity=? where iname=?");
ps.setString(1,s1);
ps.setInt(2,s2);
ps.setInt(3,t);
ps1.setInt(1,mun);
ps1.setString(2,s1);

int m1=ps.executeUpdate();
int m2=ps1.executeUpdate();
if(m1==1)
{if(m2==1)
{
JOptionPane.showMessageDialog(null,"going for payment");
}}







}
else
JOptionPane.showMessageDialog(null,"not that much quantity but,we have (in KGs) "+s4);

} 
}

rs.close();
c.close();
}
catch(Exception aa)
{}

}
else if(ae.getSource().equals(b1))
{new Pay(total);
f.setVisible(false);
}
else
{
f.setVisible(false);
}
}

}

class Pay implements ActionListener
{                                                                   //payment process
Frame f;
int sum;
JButton b1,b2,b3;
JLabel l1,l2,l3,l4,l5,ll;
JTextField t1,t2,t3,t4,t5;
Pay(int tot)
{f=new Frame("Payment Process");
b1=new JButton("pay");
b2=new JButton("Exit");
b3=new JButton("feedback");
sum=tot;
l1=new JLabel("enter card number");
l2=new JLabel("enter cvv number");
l3=new JLabel("enter month and year");
l4=new JLabel("enter card holder name");
ll=new JLabel(new ImageIcon("screen.jphg"));
t1=new JTextField(10);
t2=new JTextField(3);
t3=new JTextField(5);
t4=new JTextField(10);
f.setVisible(true);
f.setSize(700,700);
f.add(ll);
ll.add(l4);
ll.add(t4);
ll.add(l1);
ll.add(t1);
ll.add(l2);
ll.add(t2);
ll.add(l3);
ll.add(t3);
ll.add(b1);
ll.add(b2);
ll.add(b3);

l4.setBounds(30 ,70,250,56);
t4.setBounds(350,70,250,56);
l1.setBounds(30,150,250,56);
t1.setBounds(350,150,250,56);

l2.setBounds(30,300,250,56);
t2.setBounds(350,300,250,56);
l3.setBounds(30,370,250,56);
t3.setBounds(350,370,250,56);
b1.setBounds(30,450,250,56);
b2.setBounds(350,450,250,56);
b3.setBounds(230,530,250,56);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{ if(ae.getSource().equals(b1))
{
try
{String s4=t4.getText();
int s2=Integer.parseInt(t2.getText());
int s3=Integer.parseInt(t3.getText());
int s1=Integer.parseInt(t1.getText());

System.out.println(s4+"  "+s1+"  "+s2+"  "+s3);
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c.prepareStatement("insert into paydetails values(?,?,?,?)");
ps.setString(1,s4);
ps.setInt(2,s1);
ps.setInt(3,s2);
ps.setInt(4,s3);

int m=ps.executeUpdate();
if(m==1)
JOptionPane.showMessageDialog(null,"go to payment option, the orders will deliver to the address of the user");
ps.close();
c.close();
}
catch(Exception eee)
{}
}
else if(ae.getSource().equals(b3))
{new Feed();
f.setVisible(false);
}
else
{f.setVisible(false);
}
}
}


class Feed implements ActionListener
{
JFrame f;
JLabel ll,l1,l2,l3,l4,l5;
Button b1,b2,b3;
JTextField t1;
JTextArea a1;
Feed()
{
f=new JFrame("feedback");
l1=new JLabel("feedback");
l4=new JLabel("stock name");
l5=new JLabel("no need to mention the stock name if yoou dont want to return");
ll=new JLabel(new ImageIcon("screen.jpvg"));
l2=new JLabel("if you wants to returns the stock...click here");
l3=new JLabel("thanking you for using this website");
a1=new JTextArea();
t1=new JTextField(10);
b1=new Button("return or sent");
b2=new Button("exit");
f.setVisible(true);
f.setSize(700,700);

f.add(ll);
ll.add(l5);
ll.add(l4);
ll.add(t1);
ll.add(l1);
ll.add(a1);
ll.add(l2);
ll.add(b1);
ll.add(b2);
ll.add(l3);
l4.setBounds(30,70,250,50);
l5.setBounds(650,70,250,50);
t1.setBounds(330,70,250,50);
l1.setBounds(30,150,250,50);
a1.setBounds(330,150,250,50);
l2.setBounds(30,280,250,50);
b1.setBounds(30,350,250,50);
b2.setBounds(330,350,250,50);
l3.setBounds(230,450,250,50);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource().equals(b1))
{try
{
String s1=t1.getText();
String s2=a1.getText();
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
PreparedStatement ps=c.prepareStatement("insert into feedback values(?,?)");
ps.setString(1,s1);
ps.setString(2,s2);

int m=ps.executeUpdate();
if(m==1)
JOptionPane.showMessageDialog(null,"feedback is successfully sent");
ps.close();
c.close();
}
catch(Exception ee)
{}
}
else
{
f.setVisible(false);
}
}

}











class Page implements ActionListener
{                                                         //logout page
JFrame f1,f;
JLabel l1,ll;
TextField t1,t2;
Button b1,b2;
JPasswordField p1;
Page()
{
f=new JFrame("THANKING YOU");
b1=new Button("logout");
b2=new Button("cancel");
ll=new JLabel(new ImageIcon("screen.jpgh"));
l1=new JLabel("you entered this  page successfully");
f.setVisible(true);
f.setSize(700,700);
f.add(ll);
f.add(l1);
f.add(b1);
f.add(b2);
l1.setBounds(230 ,70,250,56);
b1.setBounds(230,70,250,56);
b2.setBounds(230,70,250,56);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource().equals(b1))
{f.setVisible(false);
f1.setVisible(true);
}
else
{f.setVisible(false);
}
}
}


class PassWo  implements ActionListener
{Frame f,f2;                                           //retriving password
JLabel l1,l2,l3,ll,l4;
JTextField t1,t2;
Button b1,b2;
JPasswordField p1,p2;
PassWo()
{

f=new Frame("change password");
l3=new JLabel("enter name");
t1=new JTextField(10);
t2=new JTextField(10);
l1=new JLabel("reset password");
l4=new JLabel("Q)whats your birthday month");
ll=new JLabel(new ImageIcon("screen.jphg"));
l2=new JLabel("confirm password");
b1=new Button("submit");
b2=new Button("cancel");
p1=new JPasswordField(10);
p2=new JPasswordField(10);
f.setVisible(true);
f.add(ll);
f.setSize(700,700);
ll.add(l3);
ll.add(t1);
ll.add(l4);
ll.add(t2);
ll.add(l1);
ll.add(p1);
ll.add(l2);
ll.add(p2);
ll.add(b1);
ll.add(b2);

l3.setBounds(30 ,70,250,56);
t1.setBounds(350,70,250,56);
l4.setBounds(30 ,150,250,56);
t2.setBounds(350,150,250,56);
l1.setBounds(30,230,250,56);
p1.setBounds(350,230,250,56);

l2.setBounds(30,300,250,56);
p2.setBounds(350,300,250,56);
b1.setBounds(30,370,250,56);
b2.setBounds(350,370,250,56);

b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b1))
{try
{
String s1=p1.getText();
String s2=p2.getText();
String an=t2.getText();
System.out.println(s1+"   "+s2);
String s3=t1.getText();
if(s1.equals(s2))
{
 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select name,ans from ques");
while(rs.next())
{String s4=rs.getString(1);
String s5=rs.getString(2);
//System.out.println(s4+"   "+s5);
//System.out.println("yes");
if(s4.equals(s3))
{//System.out.println("yes");
if(s5.equals(an))
{//System.out.println("yes");
PreparedStatement ps=c.prepareStatement("update  Ulogin set password=? where username=?");
ps.setString(1,s1);
ps.setString(2,s3);
int m=ps.executeUpdate();
if(m==1)
{
JOptionPane.showMessageDialog(null,"your password is successfully reset");
new Login3();
}

}}
}
}
else
{JOptionPane.showMessageDialog(null,"invalid data");
}
}
catch(Exception eee)
{}


}
else
{f.setVisible(false);
}
}}

class PassWo1  implements ActionListener
{Frame f,f2;                                           //retriving password
JLabel l1,l2,l3,ll,l4;
JTextField t1,t2;
Button b1,b2;
JPasswordField p1,p2;
PassWo1()
{

f=new Frame("change password");
l3=new JLabel("enter name");
t1=new JTextField(10);
t2=new JTextField(10);
l1=new JLabel("reset password");
l4=new JLabel("Q)whats your birthday month");
ll=new JLabel(new ImageIcon("screen.jphg"));
l2=new JLabel("confirm password");
b1=new Button("submit");
b2=new Button("cancel");
p1=new JPasswordField(10);
p2=new JPasswordField(10);
f.setVisible(true);
f.add(ll);
f.setSize(700,700);
ll.add(l3);
ll.add(t1);
ll.add(l4);
ll.add(t2);
ll.add(l1);
ll.add(p1);
ll.add(l2);
ll.add(p2);
ll.add(b1);
ll.add(b2);

l3.setBounds(30 ,70,250,56);
t1.setBounds(350,70,250,56);
l4.setBounds(30 ,150,250,56);
t2.setBounds(350,150,250,56);
l1.setBounds(30,230,250,56);
p1.setBounds(350,230,250,56);

l2.setBounds(30,300,250,56);
p2.setBounds(350,300,250,56);
b1.setBounds(30,370,250,56);
b2.setBounds(350,370,250,56);

b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{if(ae.getSource().equals(b1))
{try
{
String s1=p1.getText();
String s2=p2.getText();
String an=t2.getText();
//System.out.println(s1+"   "+s2);
String s3=t1.getText();
if(s1.equals(s2))
{
 DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password");
Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select name,ans from ques");
while(rs.next())
{String s4=rs.getString(1);
String s5=rs.getString(2);
//System.out.println(s4+"   "+s5);
//System.out.println("yes");
if(s4.equals(s3))
{System.out.println("yes");
if(s5.equals(an))
{//System.out.println("yes");
PreparedStatement ps=c.prepareStatement("update  login set password=? where username=?");
ps.setString(1,s1);
ps.setString(2,s3);
int m=ps.executeUpdate();
if(m==1)
{
JOptionPane.showMessageDialog(null,"your password is successfully reset");
new Login4();
}

}}
}
}
else
{JOptionPane.showMessageDialog(null,"invalid data");
}
}
catch(Exception eee)
{}


}
else
{f.setVisible(false);
}
}


}


