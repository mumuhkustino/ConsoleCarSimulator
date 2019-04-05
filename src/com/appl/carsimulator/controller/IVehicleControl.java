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
public interface IVehicleControl {
    void RequestAccelerate(int tmpAmount);
    void RequestDecelerate(int tmpAmount);
    void RequestTurn(RelativeDirection tmpDirection);
    void setModel(IVehicleModel tmpAuto);
    void setView(IVehicleView tmpAuto);
}
