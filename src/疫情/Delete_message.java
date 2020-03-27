package 疫情;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

import 疫情.Query;  

public class Delete_message extends JPanel implements ActionListener{
	Box box1,box2,baseBox;  
    Query query;  
    JButton button;  
    JTextField field[]=null;  
    String a[]=null;  
    int n,mark;  
    Delete delete;  
    String tableName;  
    Delete_message(){  
        query=new Query();  
        setBackground(Color.white);  
        query.setTableName("message");  
        a=query.getField();  
        box1=Box.createVerticalBox();  
        box2=Box.createVerticalBox();  
        n=a.length;  
        field =new JTextField[n];  
        for(int i=0;i<n;i++){  
            field[i]=new JTextField(10);  
            if(a[i].equals("学号")==true)  
                box1.add(new JLabel("* "+a[i]));  
            else  
            box1.add(new JLabel("  "+a[i]));  
            box1.add(Box.createVerticalStrut(8));  
            box2.add(field[i]);  
            box2.add(Box.createVerticalStrut(8));  
        }  
        box1.add(new JLabel("  单击删除"));  
        button=new JButton("删除");  
        button.addActionListener(this);  
        box2.add(button);  
        baseBox=Box.createHorizontalBox();  
        baseBox.add(box1);  
        baseBox.add(Box.createHorizontalStrut(8));  
        baseBox.add(box2);  
        add(baseBox);  
    }  
    
    
    public void actionPerformed(ActionEvent e){  
        if(field[mark].getText().toString().equals("")==true)  
            JOptionPane.showMessageDialog(this, "带*号为必填内容","消息对话框",JOptionPane.WARNING_MESSAGE);  
        else  
        {  
            Delete delete=new Delete();  
            delete.setTableName("message");  
            delete.setField(field);  
            delete.setA(a);  
            delete.Execute_Delete(mark);  
        }  
    }  
}
