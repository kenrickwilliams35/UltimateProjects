
/**
 * Write a description of class saveCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class saveCommand extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class saveCommand
     */
    public saveCommand()
    {
        super("save");
       
    }

    
    public boolean execute(Player player){
        try{
        File file = new File("./saves/"+  player.getName() +"Save.txt");
        
        FileWriter write = new FileWriter(file);
        
     
        write.write(player.getName() + "\n");
        write.write(String.valueOf(player.getCurrentHealth()) + "\n");
        write.write(String.valueOf(player.getCurrency()) + "\n");
        write.write( String.valueOf(player.getCurrentWeight()) + "\n");
        for(Items item : player.getItems().values()){
            write.write(item.getName() + "/" + item.getWeight() + "/" + item.getValue() + "!");
        }
        write.write("\n");
        for(orgWeapon weapon : player.getWeapons().values()){
            write.write(weapon.getName() + "/" + weapon.getStrength() + "/" + weapon.getWeight() + "!"); 
        }
        write.write("\n" + player.getCurrentRoom().getName());
        
        write.flush();
      
    }catch(IOException e){
            System.out.println("Error has occured.");
            e.printStackTrace();        
        }
        return false;
    }
}
