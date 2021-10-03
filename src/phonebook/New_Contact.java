
package phonebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


public class New_Contact extends JFrame implements ActionListener {
    JFrame frame=new JFrame("Sorry");
    
    JButton button1;
    JPanel panel=new JPanel();
    JLabel label1=new JLabel("First Name");
    JTextField field1=new JTextField(20);
    JLabel label2=new JLabel("Last Name");
    JTextField field2=new JTextField(20);
    JLabel label3=new JLabel("Contact Number");
    JTextField field3=new JTextField(17);
    
    New_Contact(){
        super("Add new contact");
        
        setSize(450,240);
        add(panel);
        
        label1.setFont(new Font("Times New Roman", 1, 18));
        field1.setFont(new Font("Times New Roman", 1, 18));
        panel.add(label1);
        panel.add(field1);
        
        label2.setFont(new Font("Times New Roman", 1, 18));
        field2.setFont(new Font("Times New Roman", 1, 18));
        panel.add(label2);
        panel.add(field2);
        
        label3.setFont(new Font("Times New Roman", 1, 18));
        field3.setFont(new Font("Times New Roman", 1, 18));
        panel.add(label3);
        panel.add(field3);
        
        button1=new JButton("Save");
        panel.add(button1);
       button1.setFont(new Font("Times New Roman", 1, 28));
       button1.setBackground(Color.cyan);
        button1.setFocusable(false);
        button1.setLocation(230,100);
        button1.setPreferredSize(new Dimension(150, 50));
       button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String input=button1.getText();
        //System.out.println(input);
        if("Save".equals(input)){
            try {
                FileWriter f = new FileWriter("History.txt",true);
                if((field3.getText().length())==11){
                    //System.out.println(field3.getText().length());
                    int number=Integer.parseInt(field3.getText());
                    if( String.valueOf(number).length()==10){
                        //System.out.println(String.valueOf(number).length());
                f.write(field1.getText()+" "+field2.getText()+" "+field3.getText()+"\n");
                f.close();
                }else{
                    frame.setVisible(true);
                    frame.setSize(400,120);
                    JLabel label=new JLabel("Not a Bangladeshi number");
                    label.setFont(new Font("Times New Roman", 1, 32));
                    frame.add(label);
                }
                } else{
                    frame.setVisible(true);
                    frame.setSize(400,120);
                    JLabel label=new JLabel("Not a Bangladeshi number");
                    label.setFont(new Font("Times New Roman", 1, 32));
                    frame.add(label);
                }
                
            } catch (IOException ex) {
                System.out.println(ex);
            }
    }
            dispose();
    }
}
