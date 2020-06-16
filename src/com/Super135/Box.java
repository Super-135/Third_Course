package com.Super135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> fruts = new ArrayList<>();

    public Box(){
    }

    public Box(List<T> fruts) {
        this.fruts = fruts;
    }

    public int getSizeBox() {
        return fruts.size();
    }

    public void setFrut(T frut) {
            this.fruts.add(frut);
    }

    public void setFrutBox(Box box) {
        for (int i = 0; i < box.getSizeBox() ; i++) {
            this.fruts.addAll(box.fruts);
        }
    }

    public float getWeight(){
        return  fruts.size()*fruts.get(0).getWEIGHT();
    }

    public boolean compare(Box boxFrut) {
        return Math.abs(this.getWeight()-boxFrut.getWeight())  < 0.0000001;
    }

    public void intersperse(Box boxFrut){
        if(! this.equals(boxFrut)){
            boxFrut.setFrutBox(this);
            this.fruts.clear();
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruts=" + fruts.toString() +
                '}';
    }
}
