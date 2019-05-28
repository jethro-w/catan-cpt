import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class ssmtest implements ActionListener{
	// Properties
	JFrame theframe;
	JPanel thepanel;
	
	JTextArea thearea;
	JScrollPane thescroll;
	JMenuBar thebar;
	JTextField thefield;
	JButton thebutton;
	SuperSocketMaster ssm;
	String strText;
	JTextField thefield2;
	String strUser;
	int intPlayers;
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == thefield2){
			strUser = thefield2.getText();
			ssm.sendText(strUser+","+ "!Player");
			thearea.append(strUser+","+ "!Player"+"\n");
			thefield2.setVisible(false);
		}
	if(evt.getSource() == thebutton){
	ssm.sendText(thefield.getText());
	strText= thefield.getText();
	thearea.append(strUser+  " "+strText+"\n");
		}else if(evt.getSource() == ssm){
			thearea.append(ssm.readText() + "\n");
			}
		}
	
	// Constructor
	public ssmtest(){
		theframe = new JFrame("Noob Chat");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		thepanel = new JPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		
		thearea = new JTextArea();
		
		thescroll = new JScrollPane(thearea);
		thescroll.setBounds(0,50,400,250);
		
		thefield = new JTextField("");
		thefield.setSize(400,50);
		thefield.setLocation(0,310);
		
		thefield2 = new JTextField("");
		thefield2.setSize(400,50);
		thefield2.setLocation(0,500);
		thefield2.addActionListener(this);
		
		thebutton = new JButton("Send");
		thebutton.setSize(400, 50);
		thebutton.setLocation(0, 370);
		thebutton.addActionListener(this);
		
		thepanel.add(thescroll);
		thepanel.add(thefield);
		thepanel.add(thefield2);
		thepanel.add(thebutton);
		
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setResizable(false);
		theframe.setVisible(true);
		
		ssm = new SuperSocketMaster(3000, this);
		
		//~ ssm = new SuperSocketMaster(657, this);
		ssm.connect();
		System.out.println(ssm.getMyAddress());
	}
	
	
	// Main Method
	public static void main(String[] args){
		ssmtest thegui = new ssmtest();
		
		
	}

}
