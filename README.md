# travelGo
**Final Program for Organization**
Here is the link to all of the project tasks we have to complete (organized):
[Project Tasks Doc Link](https://docs.google.com/document/d/1bNOieihMCGUcXW06Y7ec1a0M1JouxbGHAMaItOKCehM/edit?usp=sharing)

## Mila's Edits
**Main Prog.java** was originally newFunct.java or something like that, but I renamed it.
- This is because I decided to put the main() in here. 
Why is that you ask? 
- Well in that program the class TravelPackage is defined. 
- That brings me to my next point:
Originally, we had a Hashmap keeping track of all the details defined as: **<String, String>**
- however this sucks bc we have to keep on changing the price and stock to floats/ints
- so, now we have 2 things that keep track of all the travel packages:
##### _public static HashMap<String, TravelPackage> travelPackages = new HashMap<>();_
- this is where we actually do all the operations to the variables (edit etc)
##### _database.csv_
- This is where we keep record of all the actual travel packages, even after running the program

### TL;DR
- new formatting of the system. the HashMap keeping all the info is formatted as:
<String, Travelpackage>
- String: The randomly generated ID of the Travel Package 
- TravelPackage: holds the price, desc, name, all that crap



