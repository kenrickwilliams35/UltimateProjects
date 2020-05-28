
/**
 * Write a description of class fightCommand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class fightCommand extends Command
{
    public fightCommand(){
        super("fight");
    }
    public boolean execute(Player player){
        String secondWord = "";
        String reply;
        /// if the user eneters two words it gtes the two worded enemy
        if(hasSecondWord() & hasThirdWord()){
            String fullName = "";
            
            fullName = getSecondWord() + " " + getThirdWord();
           
            boolean enemy = player.getCurrentRoom().getEnemy().containsKey(fullName);
            if(enemy != false){
                System.out.println("You attack the " + player.getCurrentRoom().getEnemy().get(fullName).getName());
                double weaponDamage  = player.getCurrentRoom().getEnemy().get(fullName).getHealth() - player.getWeapon().getStrength();
                player.getCurrentRoom().getEnemy().get(fullName).setHealth(weaponDamage);
                System.out.println("The enemy's health is now " + player.getCurrentRoom().getEnemy().get(fullName).getHealth());
                if(player.getCurrentRoom().getEnemy().get(fullName).getHealth() < 0){
                    System.out.println("The enemy is dead. good job!\n");
                    player.getCurrentRoom().setWeapons(player.getCurrentRoom().getEnemy().get(fullName).getWeapon().getName(), player.getCurrentRoom().getEnemy().get(fullName).getWeapon());
                    player.getCurrentRoom().getEnemy().remove(fullName);
                }else{
                    System.out.println("The enemy attacks!");
                    double enemyDamage = player.getCurrentHealth() - player.getCurrentRoom().getEnemy().get(fullName).getWeapon().getStrength();
                    player.setCurrentHealth(enemyDamage);
                    System.out.println(player.getName() + " Health is now " + player.getCurrentHealth() + "\n");
                     if(player.getCurrentHealth() < 0){
                        System.out.println("you have died.\n");
                        
                        Iterator<String> it = player.getWeapons().keySet().iterator();
 
                        // Iterate over all the elements
                        while (it.hasNext()) {
                            String key = it.next();
                            // Check if Value associated with Key is ODD
                            if (!key.equals("stick") ){
                                player.getCurrentRoom().getWeapons().put(key, player.getWeapons().get(key));
                                float weight = player.getWeight() + player.getWeapons().get(key).getWeight();
                                player.setWeight(weight);
                                // Remove the element
                                it.remove();
                            }
                        }
                        
                       
                        player.setCurrentHealth(200.0);
                        player.goHome();
                        
                    }
                }
            }else{
                System.out.println("you fight air");
            }
        // if(player.getCurrentRoom().hasEnemy().contains(getSecondWord())){
               
           // for(String enemy : player.getCurrentRoom().getEnemy().keySet()){
            // if(secondWord.equals(player.getCurrentRoom().getEnemy().get(enemy))){
                // Scanner scan = new Scanner(System.in);
                // System.out.println("you are fighting: " + player.getCurrentRoom().getEnemy().get(enemy).getName());
                // System.out.println("-----------------------------");
                // System.out.println("which weapon will you use?");
                
                // for(String key : player.getWeapons().keySet()){
                    // System.out.println(key);
                    // System.out.println("-------------------");
                // }
                // reply = scan.nextLine();
                // for(String key : player.getWeapons().keySet()){
                    // if(reply.equals(player.getWeapons().get(key)));
                        // weaponDamage = player.getCurrentRoom().getEnemy().get(enemy).getHealth() - player.getWeapons().get(key).getStrength();
                // }
            // }
        // }
    // }  else{
        // System.out.println("the room has no enemies");
    // }
    // if it is just one word then it will get the one worded enemy
}else if(hasSecondWord()){
    boolean enemy = player.getCurrentRoom().getEnemy().containsKey(getSecondWord());
            if(enemy != false){
                System.out.println("You attack the " + player.getCurrentRoom().getEnemy().get(getSecondWord()).getName());
                double weaponDamage  = player.getCurrentRoom().getEnemy().get(getSecondWord()).getHealth() - player.getWeapon().getStrength();
                player.getCurrentRoom().getEnemy().get(getSecondWord()).setHealth(weaponDamage);
                System.out.println("The enemy's health is now " + player.getCurrentRoom().getEnemy().get(getSecondWord()).getHealth());
                if(player.getCurrentRoom().getEnemy().get(getSecondWord()).getHealth() < 0){
                    System.out.println("The enemy is dead. good job!\n");
                    double bonus = player.getCurrentHealth() + 20.0;
                    player.setCurrentHealth(bonus);
                    player.getCurrentRoom().setWeapons(player.getCurrentRoom().getEnemy().get(getSecondWord()).getWeapon().getName(), player.getCurrentRoom().getEnemy().get(getSecondWord()).getWeapon());
                    player.getCurrentRoom().getEnemy().remove(getSecondWord());
                }else{
                    System.out.println("The enemy attacks!");
                    double enemyDamage = player.getCurrentHealth() - player.getCurrentRoom().getEnemy().get(getSecondWord()).getWeapon().getStrength();
                    player.setCurrentHealth(enemyDamage);
                    System.out.println(player.getName() + " Health is now " + player.getCurrentHealth() + "\n");
                    
                    // if player health is below a certain point then it will check if he player is dead
                    if(player.getCurrentHealth() <= 0){
                        System.out.println("you have died.\n");
                        
                        Iterator<String> it = player.getWeapons().keySet().iterator();
 
                        // Iterate over all the elements
                        while (it.hasNext()) {
                            String key = it.next();
                            // Check if Value associated with Key is ODD
                            if (!key.equals("stick") ){
                                player.getCurrentRoom().getWeapons().put(key, player.getWeapons().get(key));
                                float weight = player.getWeight() + player.getWeapons().get(key).getWeight();
                                player.setWeight(weight);
                                // Remove the element
                                it.remove();
                            }
                        }
                        
                        // for(String key : player.getWeapons().keySet()){
          
                            // if(key != "smg"){
                                // player.getCurrentRoom().getWeapons().put(key, player.getWeapons().get(key));
                                // //player.getWeapons().remove(key);
                                
                            // }
                        // }
                        // sends the player home with minimal health
                        player.setCurrentHealth(200.0);
                        player.goHome();
                        
                    }
                }
            }else{
                System.out.println("you fight air");
            }
}else{
    System.out.println("fight what?");
}
      return false;   
    }
}





