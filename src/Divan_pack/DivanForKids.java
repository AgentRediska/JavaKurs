package Divan_pack;

import furniture.GetParametrs;

public class DivanForKids extends Divan implements GetParametrs {
    private final static String type= "Диван Детский";  //у всех есть свой тип

    //Конструктор с параметрами предков
    public DivanForKids(String name, String size, int count, int price, String description, int depth) {
        setName(name);
        setSize(size);
        setCount(count);
        setPrice(price);
        setDescription(description);
        setDepth(depth);
    }


    public  String getType() {
        return type;
    }   //собственно, нужный интерфейс
}
