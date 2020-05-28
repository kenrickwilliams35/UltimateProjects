import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes modified by Rodrigo A. Obando (2018)
 * @version 1.0 (February 2002)
 */

class Room 
{
    private organism enemy;
    private float volume;
    private boolean lock;
    private String description;
    private HashMap<String, Items> roomItems;
    private HashMap<String, organism> roomEnemies;
    private HashMap<String, npcs> roomNpc;
    private HashMap<String, Room> exits; // stores exits of this room.
    public ArrayList<organism> roomEnemy ; // stores enemys inside of thsi hash map
    //public HashMap<String, organism> roomEnemies;
    private HashMap<String, orgWeapon> weaponLocker;
    private HashMap<String, Trader> traders;
    private String name;
    
   
    
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String name ,String description) // so I type the description of this room when I create the room
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        roomEnemy = new ArrayList<organism>();
       // roomEnemies = new HashMap<String, organism>();
        roomItems = new HashMap<String, Items>();
        roomNpc = new HashMap<String, npcs>();
        weaponLocker = new HashMap<String, orgWeapon>();
        roomEnemies = new HashMap<String, organism >();
        this.volume = 0;
        lock = false;
        traders = new HashMap<String, Trader>();
        this.name = name;
    }

    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Room neighbor) // i set the exit for the room that i create as soon as the room is created
    {
        exits.put(direction, neighbor);
    }
    // created a name for the room
    public String getName(){
        return name;
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription() // returns the direction of the room 
    {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    
    // put a way for the player to put their name automatically into the get long description.
    public String getLongDescription(String name)
    {
        for(String key : getEnemy().keySet()){
                   System.out.println(getEnemy().get(key).getVoice());
            //System.out.println("\n");
            }
        return name + " " + description + ".\n" + getExitString(); // returns what place you are currently in.
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        for(String exitName : exits.keySet()) // keysets returns the first part fo the hash map , for example ("west")
        {
            returnString += " " + exitName;
        }
        return returnString;
    }
    // aloows me to lock rooms
    public void lock(){
        lock = true;
    }
    public void unlock(){
        lock = false;
    }
    // allows me to add traders
    public void setTrader(String name, Trader trader){
        traders.put(name, trader);
    }
    public HashMap<String, Trader> getTrader(){
        return traders;
    }
    public void addEnemy(String name, organism enemy){
        roomEnemies.put(name, enemy);
        //roomEnemy.add(enemy);
    }
    public void addNpc(String name, npcs npc){
        roomNpc.put(name, npc);
    }
   
    
    // changed from individual enemy to multiple enemies
    public HashMap<String, organism> getEnemy(){
        return roomEnemies;
    }
    public HashMap<String, npcs> getNpc(){
        return roomNpc;
    }
    public HashMap<String, Items> getItems(){
        return roomItems;
    }
    public void removeTrader(String name){
        traders.remove(name);
    }
    
    public void setItems(String name, Items item){
        if(item.getVolume() + this.volume <= 1000){
            this.volume = this.volume + item.getVolume();
            roomItems.put(name, item);
        } else {
            System.out.println("the room is overcapacity");
        }
       
    }
    public void setWeapons(String namee, orgWeapon weaponn){
        weaponLocker.put(namee, weaponn);
    } 
    public HashMap<String, orgWeapon> getWeapons(){
        return weaponLocker;
    }
    

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    public HashMap<String, Room> getExits(){
        return exits;
    }
    
    public boolean hasEnemy(){
       
        if (roomEnemies.size() == 0)
            return false;
         else 
            return true;
        
    } 
    public boolean hasTrader(){
        if(traders.size() == 0)
            return false;
        else
            return true;
    }
    public boolean hasNpc(){
        if (roomNpc.size() == 0)
            return false;
         else 
            return true;
    }
    public boolean hasWeapon(){
        if(weaponLocker.size() == 0)
            return false;
        else
            return true;
    }
    public boolean hasItems(){
        if(roomItems.size() == 0)
            return false;
        else
            return true;
    }
    public boolean lockCheck(){
        if(lock == true)
            return true;
        else
            return false;
    }
   
}

