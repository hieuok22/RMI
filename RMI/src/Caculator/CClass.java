package Caculator;

import java.awt.Frame;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CClass extends JFrame implements CInterface {

	@Override
	public void printMsg() throws RemoteException {
		Frame f = new Frame();
		f.setSize(200,200);
		JLabel lb = new JLabel("Nhap loi chia 0");
		f.add(lb);
		f.setVisible(true);
		f.setLocationRelativeTo(null);

	}
}
