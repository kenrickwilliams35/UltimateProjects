
/**
 * Write a description of class equipCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class equipCommand extends Command
{
    String reply;
    public equipCommand()
    {
        // initialise instance variables
        super("equip");
        String reply = "";
    }

    public boolean execute(Player player){
      
        
        // for(String key : player.getWeapons().keySet()){
            // System.out.println(key);
            // System.out.println("========");
        // }
        if(hasSecondWord()){
        boolean answer = player.getWeapons().containsKey(getSecondWord());
        if(answer != false){
            if(getSecondWord().equals(player.getWeapon().getName())){
                System.out.println("That weapon is already equiped.");
            }else {
                
                    player.setWeapon(getSecondWord(), player.getWeapons().get(getSecondWord()).getStrength(), player.getWeapons().get(getSecondWord()).getWeight());
                    System.out.println("Your equipped weapon is now: " + player.getWeapon().getName());
             
          }
        }else{
            System.out.println("That weapon is not here");
        }
    }else{
        System.out.println("equip what?");
    }
        
        return false;
    }
}
