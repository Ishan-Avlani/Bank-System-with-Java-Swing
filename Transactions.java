import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.ImageIcon;

 class Transactions implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
   JFrame f3;
 
    Transactions(String pin){
        this.pin = pin;
        
        JFrame f3 = new JFrame("AVLANI BANK");
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        f3.getContentPane().setBackground(Color.ORANGE);
        
        ImageIcon img1 = new ImageIcon("Screenshot (80).png"); //image of user
            JLabel background2 = new JLabel("",img1,JLabel.CENTER);
            background2.setIcon(img1);
            background2.setBounds(300,20,250,227);
            f3.add(background2);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 16));
     
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("WITHDRAWL");
        b3 = new JButton("PIN CHANGE");
        b4 = new JButton("BALANCE ENQUIRY");
        b5 = new JButton("EXIT");
   
        l1.setBounds(235,400,700,35);
        f3.add(l1);
        
        b1.setBounds(170,499,150,35);
        f3.add(b1);
        
        b2.setBounds(390,499,150,35);
        f3.add(b2);
        
        b3.setBounds(170,543,150,35);
        f3.add(b3);
        
        b4.setBounds(390,543,150,35);
        f3.add(b4);
        
        b5.setBounds(170,588,150,35);
        f3.add(b5);
   
       b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        f3.setLayout(null);
        f3.setSize(850,800);
        f3.setLocation(300,00);
        f3.setVisible(true);
      
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
     
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){ 
       
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){ 
            
            new Pin(pin).setVisible(true);
        }else if(ae.getSource()==b4){ 
             new Balanceenquiry(pin).setVisible(true);
            //new Balanceenquiry(new String(pin)).setVisible(true);
        }else if(ae.getSource()==b5){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transactions("");
    }

    
}