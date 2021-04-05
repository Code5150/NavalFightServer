package com.vladislav.navalfight.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class App
{
    private static final String HOST = "rmi://localhost";
    private static final int PORT = 1099;
    private static final String METHODS_NAME = "FightCalculations";

    public static void main( String[] args ) {
        rmiInit();
    }

    private static void rmiInit() {
        System.out.println( "Starting server" );
        try {
            var fightCalcImpl = new FightCalculationsImpl();
            Naming.rebind(HOST + ":" + PORT + "/" + METHODS_NAME, fightCalcImpl);
            while (true) {
                System.out.println("Server is working");
                Thread.sleep(60000);
            }
        } catch (RemoteException | InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
