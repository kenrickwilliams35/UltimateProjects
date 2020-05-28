

/**
 * Write a description of class dropCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class dropCommand extends Command
{
   
    public dropCommand()
    {
       super("drop");
    }
    public boolean execute(Player player){
        boolean items = false;
        boolean weapons = false;
     if(hasSecondWord()){
        items = player.getItems().containsKey(getSecondWord());
        weapons = player.getWeapons().containsKey(getSecondWord());

        if(weapons != false){
                
                player.getCurrentRoom().setWeapons(getSecondWord(), player.getWeapons().get(getSecondWord()));
                float weight = player.getWeight() + player.getWeapons().get(getSecondWord()).getWeight();
                player.setWeight(weight);
                player.getWeapons().remove(getSecondWord());
                System.out.println("you have dropped the " + getSecondWord());
                
            }
        if(items != false){
            if(!player.getItems().get(getSecondWord()).equals("Token")){
                
                 player.getCurrentRoom().setItems(getSecondWord(), player.getItems().get(getSecondWord()));
                float weight = player.getWeight() + player.getItems().get(getSecondWord()).getWeight();
                player.setWeight(weight);
                player.getItems().remove(getSecondWord());
                System.out.println("you have dropped the " + getSecondWord());
                
                // if(player.getItems().get(getSecondWord()).getQuantity() == 1){
                    // if(player.getCurrentRoom().getItems().containsKey(getSecondWord())){
                        // int quant = player.getCurrentRoom().getItems().get(getSecondWord()).getQuantity() + 1;
                        // player.getCurrentRoom().getItems().get(getSecondWord()).setQuantity(quant);
                        
                        // float weight = player.getWeight() + player.getItems().get(getSecondWord()).getWeight();
                        // player.setWeight(weight);
                        // player.getItems().remove(getSecondWord());
                // }else{
                    // int quant = 1;
                    // float weight = player.getWeight() + player.getItems().get(getSecondWord()).getWeight();
                    // player.setWeight(weight);
                    // player.getCurrentRoom().setItems(getSecondWord(), player.getItems().get(getSecondWord()));
                   
                // }
               // }else if(player.getItems().get(getSecondWord()).getQuantity() > 1){
                   // if(player.getCurrentRoom().getItems().containsKey(getSecondWord())){
                       // int quant = player.getCurrentRoom().getItems().get(getSecondWord()).getQuantity() + 1;
                       // player.getCurrentRoom().getItems().get(getSecondWord()).setQuantity(quant);
                       
                       // float weight = player.getWeight() + player.getItems().get(getSecondWord()).getWeight();
                       // player.setWeight(weight);
                // }else{
                    // float weight = player.getWeight() + player.getItems().get(getSecondWord()).getWeight();
                    // player.setWeight(weight);
                    // int quantt = 1;
                    // System.out.println(player.getItems().get(getSecondWord()).getQuantity());
                    // System.out.println("more");
                    // player.getCurrentRoom().setItems(getSecondWord(), player.getItems().get(getSecondWord()));
                     // System.out.println(player.getItems().get(getSecondWord()).getQuantity());
                  
                    
                // }
                // }else{
                   // System.out.println("ok"); 
                // }
             
            }else{
                System.out.println("You cannot drop money.");
            }
            }
       
        
    
        }else{
            System.out.println("drop what?");
        }

        return false;
    }
}
