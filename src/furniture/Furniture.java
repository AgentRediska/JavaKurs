package furniture;

public abstract class Furniture {    //САМЫЙ главный класс , все его параметры есть в мебели

    private String name="NULL"; //модель
    private String size="NULL"; //размеры
    private int count=0;   //количество такой мебели
    private int price=0;   //цена такой мебели
    private String description= new String(); //описание к мебели

    //ГЕТТЕРЫ И СЕТТЕРЫ
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length()>3)
            this.name = name;
    }


    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }


    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }


    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
