package Caculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CInterface extends Remote {
	
	void printMsg() throws RemoteException;
}
