/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.carsimulator.controller;

import com.appl.carsimulator.model.IVehicleModel;
import com.appl.carsimulator.model.RelativeDirection;
import com.appl.carsimulator.view.IVehicleView;

/**
 *
 * @author C70
 */
public class AutomobileControl implements IVehicleControl {

    private IVehicleModel Model;
    private IVehicleView View;

    public AutomobileControl(IVehicleModel tmpModel, IVehicleView tmpView) {
        this.Model = tmpModel;
        this.View = tmpView;
    }

    public AutomobileControl() {
    }

    @Override
    public void setView(IVehicleView tmpAuto) {
        this.View = tmpAuto;
    }

    @Override
    public void setModel(IVehicleModel tmpAuto) {
        this.Model = tmpAuto;
    }

    @Override
    public void RequestAccelerate(int tmpAmount) {
        if (Model != null) {
            Model.Accelerate(tmpAmount);
            if (View != null) {
                setView();
            }
        }
    }

    @Override
    public void RequestDecelerate(int tmpAmount) {
        if (Model != null) {
            Model.Decelerate(tmpAmount);
            if (View != null) {
                setView();
            }
        }
    }

    @Override
    public void RequestTurn(RelativeDirection tmpDirection) {
        if (Model != null) {
            if (Model.getSpeed() <= Model.getMaxTurnSpeed()) {
                Model.Turn(tmpDirection);
                if (View != null) {
                    setView();
                }
            }
        }
    }

    public void setView() {
        if (Model.getSpeed() >= Model.getMaxSpeed()) {
            View.DisableAcceleration();
            View.EnableDeceleration();
        } else if (Model.getSpeed() <= Model.getMaxReverseSpeed()) {
            View.DisableDeceleration();
            View.EnableAcceleration();
        } else {
            View.EnableAcceleration();
            View.EnableDeceleration();
        }
        if (Model.getSpeed() >= Model.getMaxTurnSpeed()) {
            View.DisableTurning();
        } else {
            View.EnableTurning();
        }
    }
}
