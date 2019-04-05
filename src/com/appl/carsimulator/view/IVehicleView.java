/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.carsimulator.view;

import com.appl.carsimulator.model.IVehicleModel;

/**
 *
 * @author C70
 */
public interface IVehicleView {
    void EnableAcceleration();
    void DisableAcceleration();
    void EnableDeceleration();
    void DisableDeceleration();
    void EnableTurning();
    void DisableTurning();
    public void Update(IVehicleModel aThis);
}