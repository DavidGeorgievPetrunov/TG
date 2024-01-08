package com.mycompany.tg.base;

import com.mycompany.tg.base.DTO.DTOAcceleration;
import com.mycompany.tg.base.DTO.DTOPosition;
import com.mycompany.tg.base.DTO.DTOVelocity;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Balls implements VO, Runnable {

    TGM model;
    DTOVelocity velocity;
    DTOAcceleration acceleration;
    DTOPosition position;
    float mass;

    public Balls(TGM model, int x, int y) {
        this.model = model;
        this.velocity = new DTOVelocity();
        this.acceleration = new DTOAcceleration();
        this.position = new DTOPosition();
        this.mass = 0;
        this.position.setPosX(x);
        this.position.setPosY(y);
    }

    @Override
    public void run() {
        int times = 0;
        while (times < 300) {
            times += 1;
            try {
                sleep(32);
            } catch (InterruptedException ex) {
                Logger.getLogger(Balls.class.getName()).log(Level.SEVERE, null, ex);
            }
            move();
        }
        this.model.controller.delete(this.position.getPosX(), this.position.getPosY());
    }

    //To do
    @Override
    public void paint() {
        int x = this.position.getPosX();
        int y = this.position.getPosY();
        this.model.controller.paint(x, y);
    }

    @Override
    public void move() {
        int x = this.position.getPosX();
        int y = this.position.getPosY();
        int x2 = (int) (x + this.velocity.getVelocityX());
        int y2 = (int) (y + this.velocity.getVelocityY());
        this.position.setPosX(x2);
        this.position.setPosY(y2);

        this.model.controller.delete(x, y);
        if (x2 > this.model.controller.getVWXSize() || x2 < 0) {
            bounceX();
        }
        if (y2 < 0 || y2 > this.model.controller.getVMYSize()) {
            bounceY();
        }
        this.model.controller.paint(x2, y2);

    }

//    public void bounce() {
//        this.velocity.setVelocityX(-this.velocity.getVelocityX());
//        this.velocity.setVelocityY(-this.velocity.getVelocityY());
//    }

    private void bounceY() {
        this.velocity.setVelocityY(-this.velocity.getVelocityY());
    }

    private void bounceX() {
        this.velocity.setVelocityX(-this.velocity.getVelocityX());
    }
}
