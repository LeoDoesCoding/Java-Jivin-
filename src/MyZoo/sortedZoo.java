package MyZoo;

import java.util.Collections;
import java.util.ArrayList;
/*
Program description:
Console program.
uses: Generics, interfaces, Objects, sorting
Creates a group of animals and orders them by size using the compareTo interface.
 */

public class sortedZoo {
    public static void main(String[] args) {
        //MyZoo.Animal[] myAnimals = new MyZoo.Animal[3]; DOES NOT WORK WITH ARRAYS
        ArrayList<Animal> myAnimals = new ArrayList<>();
        myAnimals.add(new Animal(7F));
        myAnimals.add(new Insect(1.2F, false));
        myAnimals.add(new Dog(5.5F));
        myAnimals.add(new Insect(2F, true));

        //Print information of animals
        System.out.println("Welcome to our zoo. We have:");
        Collections.sort(myAnimals);
        myAnimals.stream().forEach(Animal -> {System.out.println(Animal.getInfo());});

        //Let's make an animal choir...
        System.out.println("\nAnd now... A performance from our choir group.");
        NOISETIME<Animal> myChoir = new NOISETIME<Animal>(myAnimals.get(0));
        myChoir.addAnother(myAnimals.get(1));
        myChoir.lessgo(); //Noise time!
    }
}

//MyZoo.Animal class. All animals have an ID, size and sound
class Animal implements Comparable<Animal>{
    protected int ID;
    protected float size;
    protected String type = "unknown";
    static int IDincrement = 0;
    protected String sound = "Uhhh meow?";

    //Must enter size. ID set automatically
    public Animal(float size){
        this.size = size;
        this.ID = IDincrement;
        IDincrement += 1;
    }

    //Get values of Object
    public float getSize(){return (this.size);}
    public int getID() {return(this.ID);}
    public void sound() {System.out.println(this.sound);}
    public String getInfo() {return ("#" + this.ID + " is a " + this.type + " and is " + this.size + " units big.");}

    @Override
    public int compareTo(Animal animal) {
        /* "proper" way:
        if (this.size == animal.getSize()) {
            return 0;
        } else if (this.size > animal.getSize()) {
            return 1;
        } else {return -1;}*/

        //Shorthand:
        return (int) (this.getSize() - animal.getSize());
    }
}


//Insect class (new: wing bool, soundSet)
class Insect extends Animal {
    private boolean wings;

    //Must enter size and wing. Sound and type set automatically.
    public Insect(float size, boolean wings) {
        super(size);
        this.wings = wings;
        this.type = "insect";
        this.sound = "honk."; //Look man, I don't know what a fly says!
    }
}

//Dog class (new: soundSet)
class Dog extends Animal {

    //Must enter size. Sound and type set automatically.
    public Dog(float size) {
        super(size);
        this.type = "dog";
        this.sound = "Woof.";
    }
}