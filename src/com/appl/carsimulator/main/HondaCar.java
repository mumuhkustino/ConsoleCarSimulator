package com.appl.carsimulator.main;

import com.appl.carsimulator.model.AutomobileModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author C70
 */
public class HondaCar extends AutomobileModel {

    public HondaCar(String tmpName) {
        super(35, 20, -25, tmpName);
    }
    
    public HondaCar(String tmpName, int tmpMaxSpeed, int tmpMaxTurnSpeed, int tmpMaxReverseSpeed) {
        super(tmpMaxSpeed, tmpMaxTurnSpeed, tmpMaxReverseSpeed, tmpName);
    }
}
