
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

class Signup2 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    JFrame f2;
    
    Signup2(String formno){
        this.formno = formno;
        
        JFrame f2 = new JFrame("AVLANI BANK");
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        f2.getContentPane().setBackground(Color.ORANGE);
       
        l1 = new JLabel("Page 2: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
       
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
    
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
  
        c7 = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
         
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        l11.setBounds(700,10,70,30);
        f2.add(l11);
        
        l12.setBounds(770,10,40,30);
        f2.add(l12);
        
        l1.setBounds(280,40,400,40);
        f2.add(l1); 
        
        l2.setBounds(100,140,200,30);
        f2.add(l2);
        
        r1.setBounds(100,180,150,30);
        f2.add(r1);
        
        r2.setBounds(350,180,300,30);
        f2.add(r2);
        
        r3.setBounds(100,220,250,30);
        f2.add(r3);
        
        r4.setBounds(350,220,250,30);
        f2.add(r4);
        
        l3.setBounds(100,300,200,30);
        f2.add(l3);
        
        l4.setBounds(330,300,250,30);
        f2.add(l4);
        
        l5.setBounds(100,330,200,20);
        f2.add(l5);
    
        l7.setBounds(100,370,200,30);
        f2.add(l7);
        
        l8.setBounds(330,370,200,30);
        f2.add(l8);
        
        l9.setBounds(100,400,200,20);
        f2.add(l9);
    
        c7.setBounds(100,500,600,20);
        f2.add(c7);
        
        b1.setBounds(250,600,100,30);
        f2.add(b1);
        
        b2.setBounds(420,600,100,30);
        f2.add(b2);
        
        f2.setLayout(null);
        f2.setSize(850,850);
        f2.setLocation(200,0);
        f2.setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
         f2.setLayout(null);
        f2.setSize(850,800);
        f2.setLocation(300,00);
        f2.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(r1.isSelected()){ 
            atype = "Saving Account";
        }
        else if(r2.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            atype = "Current Account";
        }else if(r4.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        

        
        try{
            if(ae.getSource()==b1){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signup2 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                   new Transactions(new String(pin)).f3.setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==b2){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new Signup2("").setVisible(true);
    }
    
}

