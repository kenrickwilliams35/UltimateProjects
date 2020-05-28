
/**
 * Write a description of class Monsters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class organism implements organs

{
    private String Name;
    private double healthLevel;
    private String Weapon;
    private orgWeapon weapon;
    private Items pouch;
    private int Level;
    private ArrayList<orgWeapon> weaponSack;
    private orgWeapon bloodsack;
    private String test = "";
    private orgWeapon dark;
    private String voice;
    private HashMap<String, Items> itemSack;
    public organism(){
        
    }
    public organism(double Health, String Name){
  
        this.healthLevel = Health;
        this.Name = Name;
        weaponSack = new ArrayList<orgWeapon>();
        // weapons = new orgWeapon("kil roy", 100.0);
        
        // bloodsack = new orgWeapon("killsd", 300.0);
        // dark = new orgWeapon("more", 300.0);
        // weaponSack.add(weapons);
        // weaponSack.add(bloodsack);
        // weaponSack.add(dark);
        itemSack = new HashMap<String, Items>();
    }
    // sets the strength and name of the weapom
    public organism setWeapon(String name, double strength, float weight){
         this.weapon = new orgWeapon(name, strength, weight);
         return this;
    }
   
    public orgWeapon getWeapon(){
        return weapon;
    }

    public double getHealth(){
        return healthLevel;
    }
    public void setHealth(double Health){
        this.healthLevel = Health;
    }
    public void setName(String name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
 public void addWeapon(){
        
        weaponSack.add(weapon);
   
    }
    public ArrayList<orgWeapon> getWeapons(){
        return weaponSack;
    }
    //public abstract String Dialogue();
    public organism setVoice(String sentence){
        this.voice = sentence;
        return this;
    }
    public String getVoice(){
        return voice;
    }
    public void addItems(String name, Items item){
        itemSack.put(name, item);
    }
    public HashMap<String, Items> getItems(){
        return itemSack;
    }
}
