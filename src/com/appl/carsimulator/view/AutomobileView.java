/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.carsimulator.view;

import com.appl.carsimulator.controller.AutomobileControl;
import com.appl.carsimulator.model.IVehicleModel;
import com.appl.carsimulator.controller.IVehicleControl;
import com.appl.carsimulator.main.HondaCar;
import com.appl.carsimulator.model.RelativeDirection;
import java.io.IOException;

/**
 *
 * @author C70
 */
public class AutomobileView implements IVehicleView {

    private IVehicleControl Control = new AutomobileControl();
    private IVehicleModel Model = new HondaCar("Accord");
    private static int VIEW_LINE = 7;
    private static char ACCELERATE_KEY = 'w';
    private static char DECELERATE_KEY = 's';
    private static char RIGHT_KEY = 'd';
    private static char LEFT_KEY = 'a';
    private static char HELP_KEY = 'h';
    private char keyPressed;

    private boolean stateAccelerate = false;
    private boolean stateDecelerate = false;
    private boolean stateLeft = false;
    private boolean stateRight = false;

    public AutomobileView() {
        InitializeComponent();
        WireUp(Control, Model);
    }

    public void WireUp(IVehicleControl tmpControl, IVehicleModel tmpModel) {
        if (Model != null) {
            Model.RemoveObserver(this);
        }
        Model = tmpModel;
        Control = tmpControl;
        Control.setModel(Model);
        Control.setView(this);
        Model.AddObserver(this);
    }

    public void UpdateInterface(IVehicleModel auto) {
        for (int i = 0; i < VIEW_LINE; i++) {
            System.out.println("");
        }
        System.out.println("Car Name : " + Model.getName()
                + "\nheading "
                + Model.getDirection().toString()
                + "\nat speed: "
                + auto.getSpeed());
        System.out.println("Pressed Key (h to help)");
//        int value = (auto.getSpeed() > 0)
//                ? auto.getSpeed() * 100/ auto.getMaxSpeed()
//                : auto.getSpeed() * 100 / auto.getMaxReverseSpeed();
//        System.out.println("Current Speed : " + value);
    }

    @Override
    public void EnableAcceleration() {
        stateAccelerate = true;
    }

    @Override
    public void DisableAcceleration() {
        stateAccelerate = false;
    }

    @Override
    public void EnableDeceleration() {
        stateDecelerate = true;
    }

    @Override
    public void DisableDeceleration() {
        stateDecelerate = false;
    }

    @Override
    public void EnableTurning() {
        stateLeft = true;
        stateRight = true;
    }

    @Override
    public void DisableTurning() {
        stateLeft = false;
        stateRight = false;
    }

    @Override
    public void Update(IVehicleModel tmpModel) {
        this.UpdateInterface(Model);
    }

    public void AcceleratePressed(int tmpAmount) {
        Control.RequestAccelerate(tmpAmount);
    }

    public void DeceleratePressed(int tmpAmount) {
        Control.RequestDecelerate(tmpAmount);
// Changed AbsoluteDirection        
//        if (Model.getSpeed() < 0) {
//            Control.RequestTurn(RelativeDirection.Back);
//        }
    }

    public void LeftPressed() {
        Control.RequestTurn(RelativeDirection.Left);
    }

    public void RightPressed() {
        Control.RequestTurn(RelativeDirection.Right);
    }

    public void InitializeComponent() {
        System.out.println("Car Name : " + Model.getName()
                + "\nheading "
                + Model.getDirection().toString()
                + "\nmax speed: "
                + Model.getMaxSpeed()
                + "\nreverse speed: "
                + Model.getMaxReverseSpeed()
                + "\nturn speed: "
                + Model.getMaxTurnSpeed());
        System.out.print("Pressed Any Key");
//        int value = (Model.getSpeed() > 0)
//                ? Model.getSpeed() * 100 / Model.getMaxSpeed()
//                : Model.getSpeed() * 100 / Model.getMaxReverseSpeed();
//        * 100
//        System.out.println("Current Speed : " + value);
    }

    public void Help() {
        System.out.print(ACCELERATE_KEY + " to accelerate | " + DECELERATE_KEY + " to decelerate "
                + LEFT_KEY + " to left | " + RIGHT_KEY + " to right");
    }

    public void run() throws IOException {
        boolean start = false;
        while (true) {
            keyPressed = Getch.getCh();
            if(start == false) {
                UpdateInterface(Model);
                start = true;
            }
            if (keyPressed == ACCELERATE_KEY) {
                AcceleratePressed(1);
            } else if (keyPressed == DECELERATE_KEY) {
                DeceleratePressed(1);
            } else if (keyPressed == RIGHT_KEY) {
                RightPressed();
            } else if (keyPressed == LEFT_KEY) {
                LeftPressed();
            } else if (keyPressed == HELP_KEY) {
                Help();
                keyPressed = Getch.getCh();
            }
        }
    }
}
