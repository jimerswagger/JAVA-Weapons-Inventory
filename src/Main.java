import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Weapon w = new Weapon(); //this is not asking for parameters because it is assuming I am calling the empty constructor that doesn't require parameters name and power
        //it's saying that the w weapon object is never used which is true, I am just creating a new weapon object at the same time I add that weapon object to the arraylist
        ArrayList<Weapon> m = new ArrayList<>(); //arraylist for MELEE weapons
        ArrayList<Weapon> d = new ArrayList<>(); //arraylist for DEFENSE weapons
        ArrayList<Weapon> r = new ArrayList<>(); //arraylist for RANGE weapons

        Scanner s = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Welcome to your Weapons Inventory! What would you like to do? Input 1 or 2");
                System.out.println("1. Check your collection");
                System.out.println("2. Add a new weapon");
    
                int choice = s.nextInt();
    
                switch (choice) {
                    case 1:
                        checkCollection(s, m, d, r);
                        break;
                    case 2:
                        //method that adds new weapon
                        addWeapon(s, m, d, r);
                        break;
                
                    default:
                        System.out.println("Incorrect Number Option :(");
                        break;
                }
                
            }
        } catch (InputMismatchException e) {
            System.err.println("Bruh give me an integer"); //figure out how to make the program keep running, but maybe after you do the sorting stuff
        }
        
    }

    private static void checkCollection(Scanner s, ArrayList<Weapon> m, ArrayList<Weapon> d, ArrayList<Weapon> r) {
        System.out.println("\nWhat would you like to do? Input 1 or 2");
        System.out.println("1. View your Collection");
        System.out.println("2. View your Strongest Weapons");

        s.nextLine();

        String type = s.nextLine();

        if (type.equals("1")) {
            //method that does the view collection thing
            viewCollection(s, m, d, r);
        }

        if (type.equals("2")) {
            //method that shows strongest weapons in descending order
            strongestWeapons(s, m, d, r);
        }
    }

    private static void viewCollection(Scanner s, ArrayList<Weapon> m, ArrayList<Weapon> d, ArrayList<Weapon> r) {
        System.out.println("\nSelect a weapon collection? Input 1 2 3 or 4");
        System.out.println("1. Melee");
        System.out.println("2. Defense");
        System.out.println("3. Range");
        System.out.println("4. ALL"); //not implemented yet but would be cool.

        s.nextLine(); //figure out why you have to do this, we have to skip a line before I ask the user for another input?

        String type = s.nextLine();


        if (type.equals("1")) {
            System.out.println(" ⚔︎ MELEE ⚔︎");
            System.out.println("/////////////////");
                if (m.size() == 0) {
                    System.out.println("This is empty bruh");
                    System.out.println("/////////////////");
                }
            for (int i = 0; i < m.size(); i++) {
            m.get(i).getInfo();
            }
        }

        else if (type.equals("2")) {
            System.out.println("⛉ ⛊ DEFENSE ⛊ ⛉");
            System.out.println("/////////////////");
                if (d.size() == 0) { //if no items in defense exist then print that its empty bruh
                    System.out.println("This is empty bruh");
                    System.out.println("/////////////////");
                }
            for (int i = 0; i < d.size(); i++) {
            d.get(i).getInfo();
            }
        }

        else if (type.equals("3")) {
            System.out.println(" °˖➴ RANGE °˖➴");
            System.out.println("/////////////////");
                if (r.size() == 0) {
                    System.out.println("This is empty bruh");
                    System.out.println("/////////////////");
                }
            for (int i = 0; i < r.size(); i++) {
            r.get(i).getInfo();
            }
        }
    }

    private static void strongestWeapons(Scanner s, ArrayList<Weapon> m, ArrayList<Weapon> d, ArrayList<Weapon> r) {
        // get all the power levels for each arraylist and then order 
        // them using .sort() by putting all of those power numbers into a new arraylist
        // And then make it look nice by putting the names and weapon type, maybe make like a really long list of the weapons
        ArrayList<Integer> powers = new ArrayList<>();

        for (int i = 0; i < m.size(); i++) {
            powers.add(m.get(i).getPower());
        }

        for (int i = 0; i < d.size(); i++) {
            powers.add(d.get(i).getPower());
        }

        for (int i = 0; i < r.size(); i++) {
            powers.add(r.get(i).getPower());
        }

        Collections.sort(powers, Collections.reverseOrder()); //for largest to weakest going down
        //Collections.sort(powers); if you wanted weakest to largest

        // keep powers arraylist and then just use power values to find their key or the other way around, 
        // the power values are the keys that we can use to print the right names.


        HashMap<Integer, String> powerToName = new HashMap<Integer, String>();

        for (int i = 0; i < m.size(); i++) {
            powerToName.put(m.get(i).getPower(), m.get(i).getName());
        }

        for (int i = 0; i < d.size(); i++) {
            powerToName.put(d.get(i).getPower(), d.get(i).getName());
        }

        for (int i = 0; i < r.size(); i++) {
            powerToName.put(r.get(i).getPower(), r.get(i).getName());
        }

        for (int i = 0; i < powers.size(); i++) {
            System.out.println("///////////////////");
            System.out.println("Weapon Power: " + powers.get(i));
            System.out.println("Name: " + powerToName.get(powers.get(i)));
        }

        if (powerToName.size() == 0) {
            System.out.println("///////////////////");
            System.out.println("This Place Empty bruh");
        }
        System.out.println("///////////////////");
    }

    

    private static void addWeapon(Scanner s, ArrayList<Weapon> m, ArrayList<Weapon> d, ArrayList<Weapon> r) {
        System.out.println("\nWhat type is your weapon? Input 1 2 or 3");
        System.out.println("1. Melee");
        System.out.println("2. Defense");
        System.out.println("3. Range");

        s.nextLine();
    
        String type = s.nextLine();
    
        System.out.println("Please enter a cool weapon name: ");
    
        String name = s.nextLine();
    
        System.out.println("Ok, now enter the weapon's power number or whatever, please only an integer: ");
    
        int power = s.nextInt();
    
            //you can't do type == "1" because String object type is a reference to a place in memory (memory address) where the actual string data "1" is. 
            //"1" is also a String object but this "1" is stored in a different memory address 
            //so by doing: type == "1". You're basically asking if the memory address of type is the exact same memory address as the "1"
            //this is never true because since the "1" in memory that (type) references and the "1" are different objects and aren't stored in the same place in memory, they don't have the same memory address
            //so you must do .equals() to compare the actual contents of the strings instead of seeing if their place in memory is the same (seeing if their memory addresses are the same)
    
    
        if (type.equals("1")) {
            m.add(new Weapon(name, power));
        }
    
        else if (type.equals("2")) {
            d.add(new Weapon(name, power));
        }
    
        else if (type.equals("3")) {
            r.add(new Weapon(name, power));
        }
    
        System.out.println("**WEAPON SUCCESSFULLY ADDED**");
    }


        
}
