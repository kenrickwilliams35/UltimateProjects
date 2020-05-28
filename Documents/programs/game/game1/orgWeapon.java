
/**
 * Write a description of class Weopons here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class orgWeapon
{
    private String type;
    private double Strength;
    private float volume;
    private float weight;
    
    public orgWeapon(){
    }
    public orgWeapon(String type, double Strength, float weight){
        this.Strength = Strength;
        this.type = type;
        this.weight = weight;
    }
    public void setName(String name){
        this.type = name;
    }
    public void setStrength(double Strength){
        this.Strength = Strength;
    }
    public String getName(){
        return type;
    }
    public double getStrength(){
        return Strength;
    }
  
    public float getWeight(){
        return weight;
    }
    public float getVolume(){
        return volume;
  }
}
