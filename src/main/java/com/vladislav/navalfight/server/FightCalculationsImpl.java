package com.vladislav.navalfight.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FightCalculationsImpl extends UnicastRemoteObject implements FightCalculations {
    private CellData[][] field;
    private static ArrayList<Target> targets;
    private int shots = 0;
    private int hit = 0;
    private int shotsTotal = 0;

    public static void addTarget(Target t){
        targets.add(t);
    }

    protected FightCalculationsImpl() throws RemoteException {
    }

    @Override
    public void initGame(SettingsData settingsData) throws RemoteException {
        targets = new ArrayList<>();
        hit = 0;
        shotsTotal = 0;
        field = FieldGenerator.generate(settingsData);
        shots = settingsData.getShots();
        FieldGenerator.printField(field);
    }

    @Override
    public boolean makeTurn(int x, int y) throws RemoteException {
        field[x][y].setHit(true);
        shots--;
        if (field[x][y].isTarget()) {hit++;}
        shotsTotal++;
        return field[x][y].isTarget();
    }

    @Override
    public int shotsNum() throws RemoteException {
        return shots;
    }

    @Override
    public int targetsDestroyed() throws RemoteException {
        return (int) targets.stream().filter(Target::isDestroyed).count();
    }

    @Override
    public boolean allTargetsHit() throws RemoteException {
        return ((int) targets.stream().filter(Target::isDestroyed).count()) == targets.size();
    }

    @Override
    public int hitMissPercent() throws RemoteException {
        return (hit*100/shotsTotal);
    }

    @Override
    public int shotsTotal() throws RemoteException {
        return shotsTotal;
    }
}
