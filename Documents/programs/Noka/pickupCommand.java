
/**
 * Write a description of class pickupCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class pickupCommand extends Command
{
    // instance variables - replace the example below with your own

    public pickupCommand()
    {
        super("pickup");
    }

 public boolean execute(Player player){
     boolean items = false;
     boolean weapons = false;
     if(hasSecondWord()){
        items = player.getCurrentRoom().getItems().containsKey(getSecondWord());
        weapons = player.getCurrentRoom().getWeapons().containsKey(getSecondWord());
        if(items != false){
                if(player.getCurrentRoom().getItems().get(getSecondWord()).getName().equals("Token")){
                    player.setCurrency(player.getCurrency() + player.getCurrentRoom().getItems().get(getSecondWord()).getValue());
                    System.out.println("you have aquired the " + getSecondWord());
                    player.getCurrentRoom().getItems().remove(getSecondWord());
                    
                }else if(player.getItems().containsKey(getSecondWord())){
                    System.out.println(player.getName() + " contains this item already.");
                }else{
                    // if(player.getItems().containsKey(getSecondWord())){
                        // int match = player.getItems().get(getSecondWord()).getQuantity() + 1;
                        // player.getItems().get(getSecondWord()).setQuantity(match);
                        // System.out.println("you have aquired the " + getSecondWord());
                    // }else{
                   
                player.addItem(getSecondWord(), player.getCurrentRoom().getItems().get(getSecondWord()));
                System.out.println("you have aquired the " + getSecondWord());
                player.getCurrentRoom().getItems().remove(getSecondWord());
            // }
             }
                
                     
            }
        if(weapons != false){
                player.addWeapon(getSecondWord(), player.getCurrentRoom().getWeapons().get(getSecondWord()));
                System.out.println("you have aquired the " + getSecondWord());
                player.getCurrentRoom().getWeapons().remove(getSecondWord());
            }
       
        
    
}else{
    System.out.println("pickup what?");
}
return false;
}
}

