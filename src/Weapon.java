public class Weapon {
    
    private String name; //properties of the Weapon
    private int power; //properties of the Weapon

    public Weapon(String name, int power){ //so you can make multiple constructors with different parameters, can be same number of parameters too
        this.name = name;
        this.power = power;
    }

    public Weapon() {} 
    //empty constructor, so we can make a Weapon object in Main without having to enter some parameters from the getgo


    public void setName(String name) { //so these are setters, makes more sense now
        this.name = name; 
        //we're essentially saying that the 'name' parameter in Weapon...
        //will now equal the 'name' parameter in this setName() method.
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public void getInfo() {
        //System.out.println("/////////////////");
        System.out.println("Weapon Info:");
        System.out.println("Name: " + this.name);
        System.out.println("Power:" + this.power);
        System.out.println("/////////////////");

    }

    // new method that will have a for loop 
    // that gets each power that exists in its respective weapon type arraylist 
    // and puts them into a newly created arraylist and then that arraylist gets sorted

    //just use .sort to sort the new arraylist lol
    

    

}
