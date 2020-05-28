
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends Items
{
    private double Health;
    private String Food;
    private int quantity;
    
    public Food(){
        
    }
    public Food(String Food, double Health)
    {
        this.Food = Food;
        this.Health = Health;
    }
    
  
    // public void setQuantity(int quantity){
        // super.setQuantity(quantity); 
    // }
    
    // @Override
    // public int getQuantity(){
        // return quantity;
    // }
}
