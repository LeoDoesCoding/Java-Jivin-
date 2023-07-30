package fileReader;

public class People {
    private String name;
    private int age;
    private char gender;
    private String address;

    public People (String [] details) {
        this.name = details[0];
        this.age = Integer.parseInt(details[1]);
        this.gender = details[2].charAt(0);
        this.address = details[3];
    }

    public String getInfo(){
        String info = this.name + " is a " + this.age + "-year-old ";
        if (this.gender == 'm'){
            info += "man";
        }else if (this.gender == 'f'){
            info += "woman";
        }else{
            info += "person";
        }
        info += " residing at " + this.address + ".";
        return (info);
    }

    //This is the same as the above method, but can be called by calling object without method
    @Override
    public String toString() {
        String info = this.name + " is a " + this.age + "-year-old ";
        if (this.gender == 'm'){
            info += "man";
        }else if (this.gender == 'f'){
            info += "woman";
        }else{
            info += "person";
        }
        info += " residing at " + this.address + ".";
        return (info);
    }
}
