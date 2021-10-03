
package phonebook;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;


public class Show extends JFrame{
    JPanel panel=new JPanel();
    JLabel label[]=new JLabel[500];
    Show(){
        super("All Contact");
        setSize(350,800);
        add(panel);
        panel.setVisible(true);
        try{
                File obj=new File("History.txt");
                Scanner sc=new Scanner(obj);
                int i=0;
                while(sc.hasNextLine()){
                    label[i]= new JLabel(sc.nextLine());
                    label[i].setFont(new Font("Times New Roman", 1, 18));
                    panel.add(label[i]);
                    i++;
                }
                sc.close();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }catch(FileNotFoundException e){
                System.out.println("File not Found");
                System.out.println(e);
            }
        }
}
