package Divan_pack;

import furniture.Furniture;

public abstract class Divan extends Furniture {   //Пошла ветка наследования

    protected int Depth=0; //глубина дивана   этот параметр есть у каждого дивана

    public int getDepth() {
        return Depth;
    }
    public void setDepth(int depth) {
        Depth = depth;
    }

}
