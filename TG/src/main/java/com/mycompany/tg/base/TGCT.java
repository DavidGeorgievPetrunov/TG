package com.mycompany.tg.base;

public class TGCT {

    public void addBall(int x, int y) {
        model.addBall(x, y);
    }

    TGM model;
    TGV view;

    public TGCT() {
        this.view = new TGV(this);
        this.model = new TGM(this);
    }

    public void paint(int x, int y) {
        this.view.paint(x, y);
    }

    void delete(int x, int y) {
        this.view.delete(x, y);
    }

    int getVWXSize() {
        return this.view.viewer.xSize;
    }

    int getVMYSize() {
        return this.view.viewer.ySize;
    }

}
