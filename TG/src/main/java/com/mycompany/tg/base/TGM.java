package com.mycompany.tg.base;

public class TGM {

    TGCT controller;

    public TGM(TGCT controller) {
        this.controller = controller;
    }

    public void addBall(int x, int y) {
        Balls ballCreator = new Balls(this, x, y);
        Thread thread = new Thread(ballCreator);
        thread.start();
    }

    public void collideDetection(Balls ball) {

    }

    public void lostBall(Balls ball) {

    }
}
