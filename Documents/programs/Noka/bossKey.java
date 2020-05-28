
/**
 * Write a description of class key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class bossKey extends Command implements keyDelegate
{
    // instance variables - replace the example below with your own
    private String name;
    private Room room;
    /**
     * Constructor for objects of class key
     */
    public bossKey()
    {
        super("unlock");
      
    }
    public void unlock(Player player){
        if(player.getItems().containsKey("bossKey")){
        if(player.getCurrentRoom().getExits().containsKey(getSecondWord())){
            if(player.getCurrentRoom().getExits().get(getSecondWord()).lockCheck()){
                player.getCurrentRoom().getExits().get(getSecondWord()).unlock();
                System.out.println("You have unlocked " + getSecondWord());
            }else{
                System.out.println(getSecondWord() + " is already unlocked.");
            }
        }else{
            System.out.println("unlock what?");
        }
    }else{
        System.out.println("You do not have the key");
    }
}
    public boolean execute(Player player){
        unlock(player);
        return false;
    }
  
}
