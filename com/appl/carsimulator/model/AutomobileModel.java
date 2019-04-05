/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.carsimulator.model;

import com.appl.carsimulator.view.IVehicleView;
import java.util.ArrayList;

/**
 *
 * @author C70
 */
public abstract class AutomobileModel implements IVehicleModel {

    private ArrayList<IVehicleView> list = new ArrayList();
    private int vSpeed = 0;
    private int vMaxSpeed = 0;
    private int vMaxTurnSpeed = 0;
    private int vMaxReverseSpeed = 0;
    private AbsoluteDirection vDirection = AbsoluteDirection.North;
    private String vName = "";

    public AutomobileModel(int tempMaxSpeed, int tempMaxTurnSpeed, int tempMaxReverseSpeed, String tempName) {
        this.vMaxSpeed = tempMaxSpeed;
        this.vMaxTurnSpeed = tempMaxTurnSpeed;
        this.vMaxReverseSpeed = tempMaxReverseSpeed;
        this.vName = tempName;
    }

    public AutomobileModel() {
    }

    @Override
    public void setName(String tmpName) {
        this.vName = tmpName;
    }

    @Override
    public String getName() {
        return this.vName;
    }

    @Override
    public int getSpeed() {
        return this.vSpeed;
    }

    @Override
    public void setSpeed(int tmpSpeed) {
        this.vSpeed = tmpSpeed;
    }

    @Override
    public int getMaxSpeed() {
        return this.vMaxSpeed;
    }

    @Override
    public int getMaxTurnSpeed() {
        return this.vMaxTurnSpeed;
    }

    @Override
    public int getMaxReverseSpeed() {
        return this.vMaxReverseSpeed;
    }

    @Override
    public AbsoluteDirection getDirection() {
        return this.vDirection;
    }

    @Override
    public void setDirection(AbsoluteDirection tmpDirection) {
        this.vDirection = tmpDirection;
    }

    @Override
    public void Turn(RelativeDirection tempDirection) {
        AbsoluteDirection newDirection;
        switch(tempDirection) {
            case Right: 
                if(this.vDirection.equals(AbsoluteDirection.North)) {
                    newDirection = AbsoluteDirection.East;
                } else if (this.vDirection.equals(AbsoluteDirection.East)) {
                    newDirection = AbsoluteDirection.South;
                } else if (this.vDirection.equals(AbsoluteDirection.South)) {
                    newDirection = AbsoluteDirection.West;
                } else {
                    newDirection = AbsoluteDirection.North;
                }
                break;
            case Left: 
                if(this.vDirection.equals(AbsoluteDirection.North)) {
                    newDirection = AbsoluteDirection.West;
                } else if (this.vDirection.equals(AbsoluteDirection.East)) {
                    newDirection = AbsoluteDirection.North;
                } else if (this.vDirection.equals(AbsoluteDirection.South)) {
                    newDirection = AbsoluteDirection.East;
                } else {
                    newDirection = AbsoluteDirection.South;
                }
                break;
            case Back:
                if(this.vDirection.equals(AbsoluteDirection.North)) {
                    newDirection = AbsoluteDirection.South;
                } else if (this.vDirection.equals(AbsoluteDirection.East)) {
                    newDirection = AbsoluteDirection.West;
                } else if (this.vDirection.equals(AbsoluteDirection.South)) {
                    newDirection = AbsoluteDirection.North;
                } else {
                    newDirection = AbsoluteDirection.East;
                }
                break;
            default:
                newDirection = AbsoluteDirection.North;
                break;
        }
        this.vDirection = newDirection;
        this.NotifyObservers();
    }
    
    @Override
    public void Accelerate(int tmpAmount) {
        this.vSpeed += tmpAmount;
        if (vSpeed >= this.vMaxSpeed) {
            vSpeed = vMaxSpeed;
        }
        this.NotifyObservers();
    }

    @Override
    public void Decelerate(int tmpamAmount) {
        this.vSpeed -= tmpamAmount;
        if (vSpeed <= this.vMaxReverseSpeed) {
            vSpeed = vMaxReverseSpeed;
        }
        this.NotifyObservers();
    }
    
    
    @Override
    public void AddObserver(IVehicleView tmpView) {
        list.add(tmpView);
    }

    @Override
    public void RemoveObserver(IVehicleView tmpView) {
        list.remove(tmpView);
    }

    @Override
    public void NotifyObservers() {
        for(IVehicleView view: list) {
            view.Update(this);
        }
    }
}
