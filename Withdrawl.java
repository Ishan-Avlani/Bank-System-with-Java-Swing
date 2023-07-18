
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    JFrame f5;
    Withdrawl(String pin){
        this.pin = pin;
        
        JFrame f5 = new JFrame("AVLANI BANK");
        f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        f5.getContentPane().setBackground(Color.ORANGE);
        
        l1 = new JLabel("Maximum withdraw is as per your balance");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        l1.setBounds(190,350,600,20);
        f5.add(l1);
        
        l2.setBounds(190,400,400,20);
        f5.add(l2);
        
        t1.setBounds(190,450,330,30);
        f5.add(t1);
        
        b1.setBounds(390,588,150,35);
        f5.add(b1);
        
        b2.setBounds(390,633,150,35);
        f5.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
         f5.setLayout(null);
        f5.setSize(850,800);
        f5.setLocation(300,00);
        f5.setVisible(true);
    } 

    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(new String(pin)).f3.setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
               new Transactions(new String(pin)).f3.setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
             
    }
    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
