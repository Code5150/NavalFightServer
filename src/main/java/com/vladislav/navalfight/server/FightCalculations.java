package com.vladislav.navalfight.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FightCalculations extends Remote {
    void initGame(SettingsData settingsData) throws RemoteException;
    boolean makeTurn(int x, int y) throws RemoteException;
    int shotsNum() throws RemoteException;
    int targetsDestroyed() throws RemoteException;
    boolean allTargetsHit() throws RemoteException;
    int hitMissPercent() throws RemoteException;
    int shotsTotal() throws RemoteException;
}
