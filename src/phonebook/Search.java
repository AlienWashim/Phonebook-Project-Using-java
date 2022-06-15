
package phonebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;


public class Search extends JFrame implements ActionListener{
    JFrame frame=new JFrame("Search Result");
    JButton button1;
    JPanel panel=new JPanel();
    JLabel label1=new JLabel("Name or Number");
    JTextField field1=new JTextField(17);
    
    Search(){
        super("Searching");
        setSize(450,200);
        add(panel); 
        
        JButton button1=new JButton("Search");
        button1.setBackground(Color.cyan);
        
        panel.add(label1);
        label1.setFont(new Font("Times New Roman", 1, 18));
        field1.setFont(new Font("Times New Roman", 1, 18));
        field1.setBounds(100, 100, 200, 30);
        panel.add(field1);
        panel.add(button1);
        
        button1.addActionListener(this);
        
        //buttond.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String input=ae.getActionCommand();
        //System.out.println(input);
        if("Search".equals(input)){
            try{
                File obj=new File("History.txt");
                Scanner sc=new Scanner(obj);
                while(sc.hasNextLine()){
                    String data=sc.nextLine();
                    Scanner sc2=new Scanner(data);
                    while(sc2.hasNext()){
                        String item=sc2.next();
                        if(field1.getText().equalsIgnoreCase(item)){
                            Edit ob=new Edit(data);
                            ob.setVisible(true);
                        }
                    }
                    sc2.close();
                }
                sc.close();
            }catch(FileNotFoundException e){
                System.out.println("File not Found");
                System.out.println(e);
            }
            dispose();
        }
    }
    
}
