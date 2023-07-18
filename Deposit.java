
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
   String pin;
    Deposit(String pin){
        
      this.pin = pin;
      JFrame f4 = new JFrame("AVLANI BANK");
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        f4.getContentPane().setBackground(Color.ORANGE);
        
      l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBackground(Color.BLACK);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
  l1.setBounds(190,320,320,25);
        f4.add(l1);

        t1.setBounds(190,420,320,25);
        f4.add(t1);
        
        b1.setBounds(390,588,150,35);
        f4.add(b1);
        
        b2.setBounds(390,633,150,35);
        f4.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       f4.setLayout(null);
        f4.setSize(850,800);
        f4.setLocation(300,00);
        f4.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
          
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"',  'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(new String(pin)).f3.setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
               new Transactions(new String(pin)).f3.setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
  
}