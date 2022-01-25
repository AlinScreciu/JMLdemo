package com.company;

import java.util.Random;

public class Minge {
    private /*@ spec_public @*/ int  x, y;
    private /*@ spec_public @*/ final Random gen;
    public /*@ pure @*/ int getX() {
        return x;
    }

    public /*@ pure @*/ int getY() {
        return y;
    }

    //@ requires (_x >= 0 && _x <= 100) && (_y >= 0 && _y <= 50);
    //@ ensures (_x == x) && (_y == y);
    public Minge(int _x, int _y) {
        this.x = _x;
        this.y = _y;
        this.gen = new Random();
    }

    /*@
    public exceptional_behavior
    requires  (x >= 0 && x <= 100) && (y >= 0 && y <= 50) && (((x == 0) || (x == 100)) && ((y >= 20) && (y <= 30)));
    signals (Gol) (true);
    signals (Out) (false);
    signals (Corner) (false);

    also

    public exceptional_behavior
    requires (x >= 0 && x <= 100) && (y >= 0 && y <= 50) && (((x == 0) || (x == 100)) && !((y >= 20) && (y <= 30)));
    signals (Gol) (false);
    signals (Out) (false);
    signals (Corner) (true);
    also

    public exceptional_behavior
    requires (x >= 0 && x <= 100) && (y >= 0 && y <= 50) && (((y == 0) || y == 100) && !((x == 0) || (x == 100)));
    signals (Gol) (false);
    signals (Out) (true);
    signals (Corner) (false);
    @*/
    public void shoot() throws Gol, Corner, Out {

        if (x == 0 || x == 100)
        {
            if (y >= 20 && y <= 30) {
                throw new Gol();
            }
            else {
                throw new Corner();
            }
        }
        if (y == 0 || y == 100) {
            throw new Out();
        }

    }
    //@ ensures x <= 100 && x >= 0;
    public void makeX() {
        x = 0;
        x = gen.nextInt(100);
        if(x < 5) {
            x = 0;
        } else if(x > 95) {
            x = 100;
        }
    }
    //@ ensures y <= 50 && y >= 0;
    public void makeY() {
        y = 0;
        y = gen.nextInt(50);
        if(y < 5) {
            y = 0;
        }
    }

}
