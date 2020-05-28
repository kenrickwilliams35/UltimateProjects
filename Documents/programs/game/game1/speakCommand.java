
/**
 * Write a description of class speakCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class speakCommand extends Command
{
  
    public speakCommand()
    {
        super("speak");
      
    }

    
    public boolean execute (Player player){
        String fullName = "";
        if(player.getCurrentRoom().hasNpc() || player.getCurrentRoom().hasTrader()){
          if(hasSecondWord() & hasThirdWord()){
              fullName = getSecondWord() + " " + getThirdWord();
            for(String key : player.getCurrentRoom().getNpc().keySet() ){
                
                if(fullName.equals(key)){
                        System.out.println("you talk to the survivor " + key);
                        player.getCurrentRoom().getNpc().get(key).Dialouge(player);
                    }
                }
             
        
        }else if(hasSecondWord()){
            
            for(String key : player.getCurrentRoom().getNpc().keySet()){
                
                if(getSecondWord().equals(key)){
                        System.out.println("you talk to the survivor " + key);
                        player.getCurrentRoom().getNpc().get(getSecondWord()).Dialouge(player);
                        
                    }
            
        
        }
         for(String key : player.getCurrentRoom().getTrader().keySet()){
                 if(getSecondWord().equals(key)){
                        System.out.println("you talk to the survivor " + key);
                        player.getCurrentRoom().getTrader().get(getSecondWord()).getTrade(player);
                        
                    }
        }
    }
    }else{
        System.out.println("Speak to who?");
    }
            return false;
    }
}

