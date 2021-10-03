
package phonebook;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PhoneMemory extends JFrame implements ActionListener{
    JPanel panel=new JPanel();
    JButton button1=new JButton("Add New Contact");
    JButton button2=new JButton("Search");
    JButton button3=new JButton("Show all contact");
    JButton button4=new JButton("Exit");
    PhoneMemory(){
        super("Phonebook");
        add(panel);
        
        button1.setBounds(100, 160, 200, 40);
        button1.setFocusable(false);
        button1.setLocation(230,100);
        button1.setFont(new Font("Times New Roman", 1, 18));
        button1.setPreferredSize(new Dimension(400, 50));
        
        button2.setBounds(100, 160, 200, 40);
        button2.setFocusable(false);
        button2.setLocation(230,100);
        button2.setFont(new Font("Times New Roman", 1, 18));
        button2.setPreferredSize(new Dimension(400, 50));
        
        button3.setBounds(100, 160, 200, 40);
        button3.setFocusable(false);
        button3.setLocation(230,100);
        button3.setFont(new Font("Times New Roman", 1, 18));
        button3.setPreferredSize(new Dimension(400, 50));
        
        button4.setBounds(100, 160, 200, 40);
        button4.setFocusable(false);
        button4.setLocation(230,100);
        button4.setFont(new Font("Times New Roman", 1, 18));
        button4.setPreferredSize(new Dimension(400, 50));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,600);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String input=event.getActionCommand();
        //System.out.println(input);
        if("Add New Contact".equals(input)){
            //frame.dispose();
           New_Contact obj=new New_Contact();
           obj.setVisible(true);
        }
        else if("Search".equals(input)){
            Search obj=new Search();
           obj.setVisible(true);
        }
        else if("Show all contact".equals(input)){
            Show obj=new Show();
            obj.setVisible(true);
        }
        else if("Exit".equals(input)){
            dispose();
        }
    }
}
