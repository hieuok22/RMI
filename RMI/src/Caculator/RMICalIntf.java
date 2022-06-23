package Caculator;

import java.rmi.*;

public interface RMICalIntf extends Remote  {                   
          double add(double a,double b) throws RemoteException;
          double sub(double a,double b) throws RemoteException;
          double mul(double a,double b) throws RemoteException;
          double div(double a,double b) throws RemoteException;
          
          void save(CInterface e) throws RemoteException;
}