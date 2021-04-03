package com.vladislav.navalfight.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FightCalculationsImpl extends UnicastRemoteObject implements FightCalculations {
    private TurnData[][] field;
    private int shots = 0;

    protected FightCalculationsImpl() throws RemoteException {
    }

    @Override
    public void initGame(SettingsData settingsData) throws RemoteException {
        field = FieldGenerator.generate(settingsData);
        shots = settingsData.getShots();
    }

    @Override
    public TurnData makeTurn(TurnData turnData) throws RemoteException {
        return null;
    }

    @Override
    public int shotsNum() throws RemoteException {
        return shots;
    }

    @Override
    public boolean allTargetsHit() throws RemoteException {
        boolean result = true;
        for(var row: field){
            for(var column: row){
                if (column.isTarget()){
                    result = column.isHit();
                    if (!result) break;
                }
            }
            if (!result) break;
        }
        return result;
    }
}
