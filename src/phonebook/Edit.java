
package phonebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Edit extends JFrame implements ActionListener{
    String f_name,l_name,number,data,item[],name1="temp.txt",name="History.txt",check,dot2,copy;
    JButton button1=new JButton("Edit");
    JButton button2=new JButton("Delete");
    JButton button3=new JButton("Save");
    JPanel panel=new JPanel();
    JLabel label1=new JLabel("First Name");
    JTextField field1=new JTextField(20);
    JLabel label2=new JLabel("Last Name");
    JTextField field2=new JTextField(20);
    JLabel label3=new JLabel("Contact Number");
    JTextField field3=new JTextField(17);
    JFrame frame1=new JFrame();
    JFrame frame2=new JFrame();
    
    Edit(String data){
        super("Edit");
        this.data=data;
        //check save the old data field
        Scanner sc2=new Scanner(data);
                    while(sc2.hasNext()){
                        check=sc2.next();
                        break;
                    }
        JLabel label=new JLabel("       "+data);
        label.setFont(new Font("Times New Roman", 1, 24));
        
        setSize(550,240);
        add(panel);
        panel.add(label);
        
        label1.setFont(new Font("Times New Roman", 1, 18));
        field1.setFont(new Font("Times New Roman", 1, 18));
        
        label2.setFont(new Font("Times New Roman", 1, 18));
        field2.setFont(new Font("Times New Roman", 1, 18));
        
        label3.setFont(new Font("Times New Roman", 1, 18));
        field3.setFont(new Font("Times New Roman", 1, 18));
        
        panel.add(button1);
        panel.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String input=ae.getActionCommand();
        //System.out.println(input);
        if("Edit".equals(input)){
           frame1.setVisible(true);
           frame1.setSize(450,350);
           JPanel panel2=new JPanel();
           frame1.add(panel2);
           panel2.add(label1);
           panel2.add(field1);
           panel2.add(label2);
           panel2.add(field2);
           panel2.add(label3);
           panel2.add(field3);
           panel2.add(button3);
           Scanner sc=new Scanner(data);
            String[] item=new String[3];
                    int i=0;
                    while(sc.hasNext()){
                        item[i]=sc.next();
                        i++;
                    }
            for(int j=0;j<3;j++){
                if(j==0){
                    field1.setText(item[j]);
                }
                else if(j==1){
                    field2.setText(item[j]);
                }
                else{
                    field3.setText(item[j]);
                }
            }
            
            dispose();
        }else if("Save".equals(input)){  
            copy=field1.getText()+" "+field2.getText()+" "+field3.getText();
            try {
                Scanner sc = new Scanner(new File(name));
      StringBuffer buffer = new StringBuffer();
      while (sc.hasNextLine()) {
         buffer.append(sc.nextLine()+System.lineSeparator());
      }
      String fileContents = buffer.toString();
      sc.close();
      String oldLine = data;
      String newLine = copy;
      //Replacing the old line with new line
      fileContents = fileContents.replaceAll(oldLine, newLine);
      FileWriter writer = new FileWriter(name);
      writer.append(fileContents);
      writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
            frame1.dispose();
        }else if("Delete".equals(input)){
            copy="";
            try {
                Scanner sc = new Scanner(new File(name));
      StringBuffer buffer = new StringBuffer();
      while (sc.hasNextLine()) {
         buffer.append(sc.nextLine()+System.lineSeparator());
      }
      String fileContents = buffer.toString();
      sc.close();
      String oldLine = data;
      String newLine = copy;
      //Replacing the old line with new line
      fileContents = fileContents.replaceAll(oldLine, newLine);
      FileWriter writer = new FileWriter(name);
      writer.append(fileContents);
      writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
            frame1.dispose();
            dispose();
        }
    }
    
}
