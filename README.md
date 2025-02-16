A Weapons Inventory Program - This was a little program I started working on in December 2024 after finals, to practice on my Java programming :)

This program allows users to add weapons to one of 3 weapon types: Melee, Range and Defense. Users can input weapon name, type, and power level.

It utilizes one Weapon class with the standard getters, setters and a getInfo() method to print out a nice looking view of a weapon and its properties. 

I then create three separate ArrayLists of type 'Weapon' to store the three different weapon types

After user inputs the properties of their weapons, the program takes that data and use them as parameters to create a new Weapon object that is then added to its respective ArrayList of type 'Weapon'

Users can then see the weapons currently in their collection, organized by weapon type.
As well as see what their strongest weapons are, from strongest to weakest, ordered despite the weapon type.
