package com.coin;

public class MonetaryCoin extends Coin {

    public MonetaryCoin(Face face){
        super(face);
    }

    @Override
    public void flip() {
        if (this.getFace().toString().equals("HEAD"))
            this.setFace(Face.TAIL);
        else
            this.setFace(Face.HEAD);
    }
}
