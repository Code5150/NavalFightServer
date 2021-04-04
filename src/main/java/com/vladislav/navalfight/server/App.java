package com.vladislav.navalfight.server;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class App
{
    private static final String HOST = "rmi://localhost";
    private static final int PORT = 1099;
    private static final String METHODS_NAME = "FightCalculations";

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        var field = FieldGenerator.generate(
                new SettingsData(15, 100, 5, 4, 3, 2)
        );
        FieldGenerator.printField(field);

        rmiInit();
    }

    private static void rmiInit() {
        try {
            var fightCalcImpl = new FightCalculationsImpl();
            var context = new InitialContext();
            context.rebind(HOST + ":" + PORT + "/" + METHODS_NAME, fightCalcImpl);
            while (true) {
                System.out.println("Server is working");
                Thread.sleep(60000);
            }
        } catch (RemoteException | NamingException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
