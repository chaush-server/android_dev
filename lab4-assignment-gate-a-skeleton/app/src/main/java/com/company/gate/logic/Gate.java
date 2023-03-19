package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    static final int IN = 1;
    static final int OUT = -1;
    static final int CLOSED = 0;
    int mSwing;
    public boolean setSwing(int direction){
        if (direction > 1 || direction <-1){
            return false;
        }
        mSwing = direction;
        return true;
    }
    public boolean open(int direction){
        if (direction == 0){
            setSwing(direction);
            return false;
        }
        setSwing(direction);
        return true;
    }
    public void close(){
        mSwing = 0;
    }
    public int getSwingDirection(){
        return mSwing;
    }
    public int thru(int count){
        if (mSwing == 0){
            return 0;
        }
        else if (mSwing == 1){
            return count;
        }
        else if (mSwing == -1){
            return - count;
        }
        else{
            return 1231123;
        }
    }
    public String toString(){
        if (mSwing == 0){
            return "This gate is closed";
        }
        else if (mSwing == 1){
            return "This gate is open and swings to enter the pen only";
        }
        else if (mSwing == -1){
            return "This gate is open and swings to exit the pen only";
        }
        else{
            return "This gate has an invalid swing direction";
        }
    }

}
