
/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Items implements ItemInterface
{
   
   private int quantity;
   private String Type;
   private int total;
   //private String name;
   private float Value;
   private String name;
   private float weight;
   private float volume;
   private float sellValue;
   private float buyValue;
   private ItemInterface decorator;
   private float original;
   
   
   public Items(){
       
    }
   public Items(String name, float weight,  float sellValue){
       this.name = name;
       this.weight = weight;
       //this.volume = volume;
       this.Value = sellValue;
       this.buyValue = buyValue;
       this.decorator = null;
       this.quantity = quantity;
       this.original = quantity;
    }
    
    public String getLongName(){
        return getName() + (decorator == null?"":":" + decorator.getLongName());
    }
    public String getName(){
        return name;
    }
    public float getWeight(){
        return weight;
        
    }
    public void setOrginal(float original){
        this.original = original;
    }
    public float  getVolume(){
        return volume;
    }
    public float getOrginal(){
        return original;
    }
    public void setQuantity(int quantityy){
        this.quantity = quantityy;
    }
    public int getQuantity(){
        return quantity;
    }
    public float getValue(){
        return Value;
    }
    public float getBuyValue(){
        return buyValue;
    }
    public void addDecorator(ItemInterface decorator){
        if(this.decorator == null){
            this.decorator = decorator;
        }else{
            this.decorator.addDecorator(decorator);
        }
    }
    public void getBenefit(Player player){
        if(this.name.equals("Potion")){
            if(player.getCurrentHealth() + 100 <= 1000){
               double healthBoost = player.getCurrentHealth() + 100;
               player.setCurrentHealth(healthBoost);
            }else{
               System.out.println("Sorry, you dont need this!");
            }
        }else if(this.name.equals("Blood")){
            System.out.println("you drink the blood.");
        }else{
            System.out.println("you cannot use this item");
        }
    }
    public boolean isContainer(){
        return false;
    }
    public void addItem(ItemInterface item){
        
    }
    public String toString(){
        return (name + ",weight: " + getWeight());
    }
    
    
   // public Items(int quantity, String Type){
       
    // }
    
   // public void setQuantity(int quantity){
       // this.quantity = quantity;
    // }
   // public int getQuantity(){
       // return this.quantity;
    // }
   // public void setTotalItems(int total){
       // this.total = total;
    // }
   // public int getTotalItems(){
       // return total;
    // }
   // public void setName(){
       // this.name = name;
       
    // }
   // // public String getName(){
       // // return Type;
    // // }

   
   
}
