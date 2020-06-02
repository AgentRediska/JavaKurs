package Divan_pack;

import furniture.GetParametrs;

public class DivanWithLayout extends Divan implements GetParametrs {
    private final static String type= "Диван Раскладной";
    private int FullLength=0;


    public DivanWithLayout(String name, String size, int count, int price, String description, int depth, int fullLength) {

        FullLength = fullLength;     //ИМЕЕТ полную длинну, именно это является его отличием от остальных видов диванов
        setFullLength(fullLength);
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

    public void setFullLength(int FullLength) {
        if(FullLength>getDepth()*2)
            this.FullLength = FullLength;
    }

    public int getFullLength() {
        return this.FullLength;
    }


}
