/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.carsimulator.model;

import com.appl.carsimulator.view.IVehicleView;

/**
 *
 * @author C70
 */

public interface IVehicleModel {
    String Name = "";
    int Speed = 0;
    int MaxSpeed = 0;
    int MaxTurnSpeed = 0;
    int MaxReverseSpeed = 0;
    AbsoluteDirection Direction = AbsoluteDirection.North;
    
    String getName();
    void setName(String tmpName);
    
    int getSpeed();
    void setSpeed(int tmpSpeed);
    
    int getMaxSpeed();
    int getMaxTurnSpeed();
    int getMaxReverseSpeed();
    
    AbsoluteDirection getDirection();
    void setDirection(AbsoluteDirection tmpDirection);
    
    void Turn(RelativeDirection tmpDirection);
    
    void Accelerate(int tmpAmount);
    void Decelerate(int tmpAmount);
    void AddObserver(IVehicleView tmpView);
    void RemoveObserver(IVehicleView tmpView);
    void NotifyObservers();
}