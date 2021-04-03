package com.vladislav.navalfight.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FightCalculations extends Remote {
    public void initGame(SettingsData settingsData) throws RemoteException;
    public TurnData makeTurn(TurnData turnData) throws RemoteException;
    public int shotsNum() throws RemoteException;
    public boolean allTargetsHit() throws RemoteException;
}
