/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.carsimulator.main;

import com.appl.carsimulator.model.AutomobileModel;

/**
 *
 * @author C70
 */
public class HinoCar extends AutomobileModel {
    
    public HinoCar(String tmpName) {
        super(150, 30, -25, tmpName);
    }
    
    public HinoCar(int tmpMaxSpeed, int tmpMaxTurnSpeed, int tmpMaxReverseSpeed, String tmpName) {
        super(tmpMaxSpeed, tmpMaxTurnSpeed, tmpMaxReverseSpeed, tmpName);
    }
    
        
}
