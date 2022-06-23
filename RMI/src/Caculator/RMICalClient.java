package Caculator;

import javax.swing.*;
import java.awt.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.awt.event.*;
import java.net.MalformedURLException;

public class RMICalClient extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	double n1 = 0.0;
    double n2 = 0.0;
    JButton jb[] = new JButton[21];
    JTextField tf;
    Container con;
    int button,i;
    String str, toantu;
    String num="";
    JPanel tp,bp;   
    RMICalIntf a;
public RMICalClient() {
	
	  try {
		CClass c = new CClass();
		UnicastRemoteObject.exportObject(c, 1100);
		
		a =(RMICalIntf) Naming.lookup("rmi://localhost/hi"); 
		a.save(c);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (RemoteException e) {
		e.printStackTrace();
	} catch (NotBoundException e) {
		e.printStackTrace();
	}
	  setTitle("calculator");
      tp = new JPanel();
      bp = new JPanel();
      tf = new JTextField(22);
      tf.setEditable(false);
      con = getContentPane();
      bp.setLayout(new GridLayout(5,4));
      tp.add(tf);
      con.add(tp,"North");                
      for(int i=0;i<10;i++) {
      jb[i] = new JButton(""+i);
}
      jb[10] = new JButton("+");
      jb[11] = new JButton("-");
      jb[12] = new JButton("*");
      jb[13] = new JButton("/");
      jb[14] = new JButton("clear");
      jb[15] = new JButton(".");
      jb[16] = new JButton("=");
      for(int i = 0;i<17;i++) {
      jb[i].addActionListener(this);
      bp.add(jb[i]);                      
}
      con.add(bp,"Center"); 
      setDefaultCloseOperation(EXIT_ON_CLOSE);
}     
public void actionPerformed(ActionEvent ae) {  
	str = ae.getActionCommand();             
	System.out.println(str);
	switch(str) {
	case "0":
	case "1":
	case "2":
	case "3":
	case "4":
	case "5":
	case "6":
	case "7":
	case "8":
	case "9":
	case ".":
		tf.setText(tf.getText() + str);
		break;
	case "+":
	case "-":
	case "*":
	case "/":
		toantu = str;
		n1 = Double.parseDouble(tf.getText());
		tf.setText("");
		break;
	case "=":
		n2 = Double.parseDouble(tf.getText());
		
		if(toantu.equals("+"))
			try {
				n1 = a.add(n1, n2);
				tf.setText("" + n1);
			} catch (RemoteException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		else 
			if(toantu.equals("-"))
				try {
					n1 = a.sub(n1, n2);
					tf.setText("" + n1);
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			else
				if(toantu.equals("*"))
					try {
						n1 = a.mul(n1,n2);
						tf.setText("" + n1);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
					try {
						n1 = a.div(n1,n2);
						tf.setText("" + n1);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	               break;
	}
	 if(ae.getSource()==jb[14]) 
	 {
	         	tf.setText("");
	             num = "";
	             n1=0.0;
	             n2=0.0;
	             button=0;    	                                     

	 }                                   
}
public static void main(String args[]) {
	    JFrame f = new RMICalClient();
	    f.setSize(350,350);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	}
}