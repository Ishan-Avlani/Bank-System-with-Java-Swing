
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Balanceenquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;
    JFrame f7;
    
    Balanceenquiry(String pin) {
         
        this.pin = pin;
        
        JFrame f7 = new JFrame("AVLANI BANK");
        f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        f7.getContentPane().setBackground(Color.ORANGE);
ImageIcon img1 = new ImageIcon("Screenshot (80).png"); //image of user
            JLabel background2 = new JLabel("",img1,JLabel.CENTER);
            background2.setIcon(img1);
            background2.setBounds(300,20,250,227);
            f7.add(background2);
        l1 = new JLabel();
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        l1.setBounds(190, 350, 400, 35);
      f7.add(l1);

        b1.setBounds(390, 633, 150, 35);
       f7.add(b1);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

         f7.setLayout(null);
        f7.setSize(850,800);
        f7.setLocation(300,00);
        f7.setVisible(true);
    }

    

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(new String(pin)).f3.setVisible(true);
    }

    public static void main(String[] args) {
        new Balanceenquiry("").setVisible(true);
    }
}