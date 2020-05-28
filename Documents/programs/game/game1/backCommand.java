
/**
 * Write a description of class backCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class backCommand extends Command
{
    // instance variables - replace the example below with your own
  
    public backCommand()
    {
      super("back");
    }

  
    public boolean execute(Player player)
    {
       // try{
        if(player.getRooms().size() != 0){
            player.setCurrent(player.getRooms().pop());
            player.setRooms(player.getRooms());
     }else{
        System.out.println("There are no more backs.");
    }
      
        // if(player.getBacks().get(player.getBacks().size() - 1).equals("north")){
            // player.walk("south");
            // player.getBacks().remove(player.getBacks().size() -1);
        // }else if(player.getBacks().get(player.getBacks().size() - 1).equals("east")){
            // player.walk("west");
            // player.getBacks().remove(player.getBacks().size() -1);
        // }else if(player.getBacks().get(player.getBacks().size() - 1).equals("west")){
            // player.walk("east");
         // player.getBacks().remove(player.getBacks().size() -1);
        // }else if(player.getBacks().get(player.getBacks().size() - 1).equals("south")){
            // player.walk("north");
      // player.getBacks().remove(player.getBacks().size() -1);
        // }
    // }catch(EmptyStackException e){
         // System.out.println("There are no backs left.");
    // }
      return false;
    }
}
