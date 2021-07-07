package HomeWork1_Java3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    public Box(){  }

    // получим вес коробки
    public float getWeight(){
        float weight = 0.0f;
        for(T o : box){
            weight += o.getWeight();
        }
        return weight;
    }

    // сравним коробки
    public boolean compare(Box anotherBox) {
        if(getWeight() == anotherBox.getWeight()){
            return true;
        } else {
            return false;
        }
    }

    // перемещаем из коробки в коробку
    public void moveToBox(Box<T> anotherBox){
        anotherBox.box.addAll(box);
        box.clear();
    }

    // добавляем заданное количество фруктов в коробку
    public void addFruit(T fruit, int amount){
        for(int i=0;i<amount;i++){
            box.add(fruit);
        }
    }
}