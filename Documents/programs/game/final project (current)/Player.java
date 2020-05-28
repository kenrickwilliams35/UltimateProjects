
/**
 * This class represents players in the game. Each player has 
 * a current location.
 * 
 * @author Michael Kolling modified by Rodrigo A. Obando (2018)
 * @version 1.0 (December 2002)
 */
import java.util.*;


public class Player 
{
    private Room currentRoom;
    private HashMap<String, Items> pouch;
    private organism player;
    private String name;
    private HashMap<String, orgWeapon> weaponSack;
    private ArrayList<String> directions;
    private orgWeapon stick;
    private ArrayList<String> backs;
    private float weight;
   private Room baseRoom;
    private Trader trader;
    private Stack<Room> rooms;
    private float currency;
    private boolean loadCheck;
    
    /**
     * Constructor for objects of class Player
     */
    
    public Player(String name, Room startingRoom)
    {
        player = new organism(500.0, name);
        rooms = new Stack<Room>();
        weaponSack = new HashMap<String, orgWeapon>();
        directions = new ArrayList<String>();
        pouch = new HashMap<String, Items>();
        backs = new ArrayList<String>();
        this.currentRoom = startingRoom;
        stick = new orgWeapon("stick", 50.0, 0);
        GameWorld gameWorld = new GameWorld();
        baseRoom = gameWorld.getRooms().get("bunkerHill");
        this.name = name;
        weaponSack.put("stick", stick);
        player.setWeapon("stick", 50.0, 0);
       
        this.weight = 100;
        trader = new Trader("trader", currentRoom);
        this.currency = 100;
         this.name = name;
         this.currentRoom = startingRoom;
   }
    public Player(String name, double health,float currency, float weight, String items, String weapons, Room startingRoom){
        GameWorld gameWorld = new GameWorld();
        baseRoom = gameWorld.getRooms().get("bunkerHill");
        directions = new ArrayList<String>();
        rooms = new Stack<Room>();
        pouch = new HashMap<String, Items>();
         weaponSack = new HashMap<String, orgWeapon>();
         this.name = name;
         this.currentRoom = startingRoom;
         this.currency = currency;
         this.weight = weight;
         player = new organism(health, name);
         player.setWeapon("stick", 50.0, 0);
         
         String[] itemss = items.split("!");
            
            for(int i = 0; i < itemss.length; i ++){
                String[] item = itemss[i].split("/");
             
                    String itemName = item[0];
                    float itemWeight = Float.valueOf(item[1]);
                   
                    float itemValue = Float.valueOf(item[2]);
                    Items itemr = new Items(itemName, itemWeight, itemValue);
                 
                    pouch.put(item[0], itemr);
                
            }
            
             String[] weaponss = weapons.split("!");
            
            for(int i = 0; i < weaponss.length; i ++){
                String[] weapon = weaponss[i].split("/");
             
                    String weaponName = weapon[0];
                    double weaponDamage = Double.valueOf(weapon[1]);
                    
                    float weaponWeight = Float.valueOf(weapon[2]);
                    orgWeapon weaponr = new orgWeapon(weaponName, weaponDamage, weaponWeight);
                    weaponSack.put(weapon[0], weaponr);
                
            }
    }
    
    // public void setLoader(){
        // loadCheck = true;
    // }
    // public void removeLoader(){
        // loadCheck = false;
    // }
    // would have to store the room into this array
    public void setMove(String direction){
        directions.add(direction);
    }
    
    /**
     * Return the current room for this player.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public void goHome(){
        this.currentRoom = baseRoom;
        System.out.println(currentRoom.getLongDescription(name));
    }
    
    public double getCurrentHealth(){
        return player.getHealth();
    }
    public void setCurrentHealth(double health){
        player.setHealth(health);
    }
    public double getCurrentWeight(){
        return this.weight;
    }
    public void addBacks(String room){
        backs.add(room);
    }
    public void addRooms(Room room){
        rooms.push(room);
    }
    public Stack<Room> getRooms(){
        return rooms;
    }
    public ArrayList<String> getBacks(){
        return backs;
    }
    public void setRooms(Stack<Room> newRoom){
        rooms = newRoom;
    }
    /**
     * Set the current room for this player.
     */
    
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }
    public void setCurrent(Room room){
        currentRoom = room;
       System.out.println(currentRoom.getLongDescription(name));
    }
    
    /**
     * Try to walk in a given direction. If there is a door
     * this will change the player's location.
     */
    public void walk(String direction)
    {
        // Try to leave current room.
        addRooms(currentRoom);
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else if(nextRoom.lockCheck() == true) {
            System.out.println("This room is locked.");
        }else{
            setCurrentRoom(nextRoom);
            //Notification notification = new Notification("PlayedEnteredRoom", this);
            //NotifcationCenter.getInstance().postNotifcation(notification);
            
            //if(!getCurrentRoom().hasEnemy())
                System.out.println(nextRoom.getLongDescription(name));
            
            
        }
    }
    public void moveTrader(){
        trader.walk();
    }
    // gets teh name of teh player
    public String getName(){
        return name;
    }
   // sets teh name of the player
    public void setName(String name){
       this.name = name;
    }
    
    public void setWeapon(String name, double strength, float weight){
        player.setWeapon(name, strength, weight);
       
     }
    public void addWeapon(String name, orgWeapon weapon){
        if((this.weight - weapon.getWeight()) >= 0) {
            this.weight = weight - weapon.getWeight();
            weaponSack.put(name, weapon);
        }else{
            System.out.println("You are overrcumbered");
        }
    }
    
    public  orgWeapon getWeapon(){
        return player.getWeapon();
    }
    public void setCurrency(float current){
        this.currency = current;
    }
    
    public float getCurrency(){
        return currency;
    }
    
    public void setWeight(float weightt){
        this.weight = weightt;
    }
    
    public float getWeight(){
        return weight;
    }
   
    // will return the weapon of the player
    
    public HashMap<String, orgWeapon> getWeapons(){
        return weaponSack;
    }
    public void setItems(HashMap<String, Items> map){
        this.pouch = map;
    }
    // will allow you to view the contents in the item pouch
    
    public HashMap<String, Items> getItems(){
        return pouch;
    }
    
    public void removeWeapon(String key){
        weaponSack.remove(key);
    }
    
    // this allows you to add an item to the pouch.
    public void addItem(String name, Items item){
        if((this.weight - item.getWeight()) >= 0){
            this.weight = weight - item.getWeight();
            pouch.put(name, item);
           
        }else{
            System.out.println("You are overrcumbered");
        }
    }
    
    public boolean hasWeapons()
    {
        if(weaponSack.size() == 0)
            return false;
        else
            return true;
    }
    
    public boolean hasItems(){
        if(pouch.size() == 0)
            return false;
        else
            return true;
    }
   
}
