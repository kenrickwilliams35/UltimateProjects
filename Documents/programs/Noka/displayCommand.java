
/**
 * Write a description of class displayCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class displayCommand extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class displayCommand
     */
    public displayCommand()
    {
        super("display");
    }

    
    public boolean execute(Player player){
        // shows the items
        System.out.println("===========================");
        System.out.println("This is what the player has: ");
        System.out.println("===========================");
        System.out.println(player.getName() + "'s Health: " + player.getCurrentHealth());
        System.out.println(player.getName() + " has " + player.getCurrency() + " currency.");
        System.out.println(player.getName() + " has " + player.getWeight() + " left in weight.");
        if(player.hasItems()){
        for(String key : player.getItems().keySet()){
            System.out.println("The player has the following item: " + key + ", Weight: " + player.getItems().get(key).getWeight() + ", Value: " + player.getItems().get(key).getValue() + ", Quantity " + player.getItems().get(key).getQuantity());
        }
    }else{
        System.out.println("There are no items in " + player.getName() + "'s pouch");
    }
    if(player.hasWeapons()){
       
        for(String key : player.getWeapons().keySet()){
            System.out.println("The player has the following weapon: " + key + ", Strength: " + player.getWeapons().get(key).getStrength() + ", Weight: " + player.getWeapons().get(key).getWeight());
            
        }
    }else{
       System.out.println("There are no weapons in " + player.getName() + "'s pouch");
    }
        return false;
    }
}
