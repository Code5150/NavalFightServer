package com.vladislav.navalfight.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FightCalculations extends Remote {
    void initGame(SettingsData settingsData) throws RemoteException;
    TurnData makeTurn(TurnData turnData) throws RemoteException;
    int shotsNum() throws RemoteException;
    boolean allTargetsHit() throws RemoteException;
}
