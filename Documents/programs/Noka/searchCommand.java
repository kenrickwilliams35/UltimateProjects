
/**
 * Write a description of class searchCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class searchCommand extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class searchCommand
     */
   public searchCommand(){
       super("search");
    }

    public boolean execute(Player player){
        if(player.getCurrentRoom().hasNpc() == false){
            System.out.println("The room has no NPC's");
        }else{
            for(String key : player.getCurrentRoom().getNpc().keySet()){
                System.out.println("The room has the following NPC: " + key);
            }
        }
        if(player.getCurrentRoom().hasEnemy() == false){
            System.out.println("There are no enemies in this room");
        }else{
            for(String key : player.getCurrentRoom().getEnemy().keySet()){
                System.out.println("The room has the enemy: " + key);
            }
        }
        if(player.getCurrentRoom().hasItems() == false){
            System.out.println("There are no Items in this room");
        }else{
            for(String key : player.getCurrentRoom().getItems().keySet()){
                System.out.println("The room has the item: " + key +", Weight: " +  player.getCurrentRoom().getItems().get(key).getWeight()+ ", Quantity: " + player.getCurrentRoom().getItems().get(key).getQuantity());
            }
        }
        if(player.getCurrentRoom().hasWeapon() == false){
            System.out.println("The room has no weapons");
                
            }else{
                 for(String key : player.getCurrentRoom().getWeapons().keySet()){
                System.out.println("The room has the following weapon: " + key + ", " + player.getCurrentRoom().getWeapons().get(key).getStrength());
        }
       
    }
    if(player.getCurrentRoom().hasTrader() == false){
        System.out.println("The room has no traders.");
        
    }else{
        for(String key : player.getCurrentRoom().getTrader().keySet()){
            System.out.println("The trader " + player.getCurrentRoom().getTrader().get(key).getName() + " is here. ");
        }
    }
    return false;
} 
}
