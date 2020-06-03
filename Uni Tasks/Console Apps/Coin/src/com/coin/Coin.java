package com.coin;

import java.util.Random;

public abstract class Coin {
    private Random rand;
    private Face face;

    public Coin(Face face){
        this.face = face;
    }

    public Face getFace(){
        return this.face;
    }

    public void setFace(Face face){
        this.face = face;
    }

    public abstract void flip();

    public boolean isHeads(){
        return this.face.toString().equals("HEAD");
    }

    @Override
    public String toString() {
        return "Coin{" +
                "rand=" + rand +
                ", face=" + face +
                '}';
    }
}
