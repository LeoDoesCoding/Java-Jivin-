package MyZoo;

import java.util.ArrayList;

public class NOISETIME <T extends Animal> {
    ArrayList<T> myAnimals = new ArrayList<>();

    //Constructor
    public NOISETIME (T myAnimal){
        this.myAnimals.add(myAnimal);
    }

    //Add more
    public void addAnother (T myAnimal){
        this.myAnimals.add(myAnimal);
    }

    public void lessgo(){
        for (T animal : myAnimals){
            animal.sound();
            animal.sound();
            animal.sound();
        }
    }
}
