package Divan_pack;

import furniture.GetParametrs;

public class DivanStandart extends Divan implements GetParametrs {
    private final static String type= "Диван Стандарт";

    public DivanStandart(String name, String size, int count, int price, String description, int depth) {
        setName(name);
        setSize(size);
        setCount(count);
        setPrice(price);
        setDescription(description);
        setDepth(depth);
    }


    public  String getType() {
        return type;
    }
}
