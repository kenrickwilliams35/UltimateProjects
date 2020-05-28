/**
 * Implementation of the 'go' user command.
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
import java.util.*;
public class GoCommand extends Command
{
    protected HashMap<String, Room> backs;
    /**
     * Constructor for objects of class GoCommand
     */
    public GoCommand()
    {
        super("go");
        
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    //create a way to implement a fight class and a item class into the execute command so that user 
    // can just say fight and it will attack the enemy, or search and it will search the room for loot

    public boolean execute(Player player)
    {
        
        if(hasSecondWord()) {
            String direction = getSecondWord();
            
            if(direction.equals("north")||direction.equals("west")||direction.equals("east")||direction.equals("south")){
                //if(player.
                //player.addBacks(direction);
              
            }
            player.walk(direction);
            
            
           
            
        }
        else {
            // if there is no second word, we don't know where to go...
           
            System.out.println("Go where?");
        }
        return false;
    }
}
