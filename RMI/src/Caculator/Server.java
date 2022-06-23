package Caculator;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
public class Server implements RMICalIntf{
	
	
	public static void main(String[] args) throws AlreadyBoundException {
    	try {
    	Server c = new Server();
    	LocateRegistry.createRegistry(1099);
    	UnicastRemoteObject.exportObject(c, 0);
    	
        Naming.rebind("rmi://192.168.1.23/hi", c);
        System.out.println("Server Started");
    } catch (RemoteException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

		  CInterface c;
	
          public double add(double a, double b)throws RemoteException{
        	return(a+b);
             }
          public double sub(double a,double b)throws RemoteException{
                   return(a-b);
          }
          public double mul(double a,double b)throws RemoteException{
            return(a*b);
          }    
          public double div(double a,double b)throws RemoteException{
        
            if ( b==0) {
            	c.printMsg();
            } else {
            	return a/b;
            	}
            return 0;
            }

		@Override
		public void save(CInterface e) throws RemoteException {
			c = e;
		} 
}
