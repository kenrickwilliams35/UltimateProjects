
/**
 * Write a description of class GameWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class GameWorld
{
    private static GameWorld instance;
    private Room entrance ;
    private Room traderEntrance;
    // instance variables - replace the example below with your own
    private int x;
    private HashMap<String, Room> rooms;

    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld()
    {
       //System.out.println(Kenrick.word);
       rooms = new HashMap<String, Room>();
       Room bunkerHill = new Room("bunkerHill", "is on bunker hill");
        Room rightFront = new Room("rightFront", "is on right front of bunker hill");
        Room leftFront = new Room("leftFront", "is on left front of bunker hill");
        Room outerRim = new Room("outerRim","is right in front of the bunker walls");
        Room vorgaStrip = new Room("vorgaStrip", "is on the vorgo strip, watch your step");
        Room garage = new Room("garage","is in the abandoned parking garage");
        Room chopShop = new Room("chopShop", "is in the mysterious chop shop");
        Room superMarket = new Room("superMarket", "is in the rugged supermarket");
        Room toxicValue = new Room("toxicValue", "is in the the toxic value store, hope you brought a mask.");
        Room plaza = new Room("plaza", "is on the illuminated plaza, tred carefully");
        Room valhalla = new Room("valhalla", "is in valhalla, only warriors come here");
        Room deathClub = new Room("deathClub","is in death club, let the battle begin");
        Room hailMary = new Room("hailMary","is on hail mary lane, be careful");
        Room thunderDome = new Room("thunderDome", "is in the thunder dome, watch the skies.");
        Room ultraLuxe = new Room("ultraLuxe", "is in the Ultra Luxe Casino, welcome to hell");
        Room wakeValley = new Room("wakeValley", "is in wake valley, demons awaken.");
        
        
        //outside.setExit("west", boulevard);
        // test
        organism gorgon = new organism(300.0, "The Gorgon");
        organism gorgon2 = new organism(500.0, "The Gorgon");
        organism shadow = new organism(500.0, "Shadow");
        organism sniper = new organism(800.0, "Sniper");
        organism bandit = new organism(100.0, "Raged bandit");
        organism cannibal = new organism(100.0, "Cannibal");
        organism mordum = new organism(1000.0, "Mordum");
        organism beast = new organism(800.0, "Beast");
        organism stray = new organism(50.0, "Stray dog");
        organism bloodBeast = new organism(2000.0, "Blood Beast");
        // sets teh voices of the enemies for when the player enters a room
        gorgon.setVoice(" - Argh! you die human!");
        gorgon2.setVoice(" - you watch a Gorgon eating another Gorgon, this isnt good.");
        shadow.setVoice(" - the leaves rustle but you see nothing.... ");
        sniper.setVoice(" - you hear a bang go off in the distance! it hits beside you.");
        bandit.setVoice(" - you see bodies on the ground, and a man ravaging through them.");
        cannibal.setVoice(" - you watch a human eating a corpse of another human");
        mordum.setVoice(" - by the smell of the air, I think this is the layer of Mordum.");
        beast.setVoice(" - *snarls and sniffs* the beast senses you draw near...");
        stray.setVoice(" - you hear a mad bark in the distance!");
        bloodBeast.setVoice(" - Who dares to enter my domain!");
        // creates the items that can be placed in teh rooms
        Items Token = new Items("Token", 0, 15);
        Items Token2 = new Items("Token", 0, 30);
        Items Token3 = new Items("Token", 0, 50);
        Items Token4 = new Items("Token", 0, 100);
        Items Vile = new Items("Vile", 10, 100);
        Items Blood = new Items("Blood", 0, 0);
        Items Potion = new Items("Potion", 10, 15);
        //cretaes the weapons that can be placed in rooms
        orgWeapon killGauntlet = new orgWeapon("killGauntlet", 150.0, 30);
        orgWeapon smg = new orgWeapon("smg", 115.0, 10);
        orgWeapon superClaw = new orgWeapon("superClaw", 200.0, 40);
        orgWeapon rifle = new orgWeapon("rifle", 50.0, 20);
        orgWeapon alienBlaster = new orgWeapon("alienBlaster", 600.0, 20); 
        orgWeapon monsterBlast = new orgWeapon("monsterBlaster", 300.0, 60);
        // assigns a weapon to the enemies
        gorgon.setWeapon("killBlade", 80.0, 20);
        gorgon2.setWeapon("BlackMark", 200.0, 30);
        shadow.setWeapon("50cal", 110.0, 40);
        sniper.setWeapon("ragnorak" , 200.0, 50);
        bandit.setWeapon("GatlingGun", 150.0, 20);
        cannibal.setWeapon("DarkKnife", 50.0, 5);
        mordum.setWeapon("ThunderGauntlet", 800.0, 80);
        beast.setWeapon("DeathClaw", 400.0, 10);
        stray.setWeapon("claw", 20.0, 5);
        bloodBeast.setWeapon("Chaos",900.0, 80);
        //creats a trader
        Trader trader = new Trader("Charlie", ultraLuxe);
        
        npcs MotherTeresa = new npcs(100000.0, "Mother Teresa");
        npcs lostWarrior = new npcs(10000.0, "Lost Warrior");
        npcs loneSniper = new npcs(10000.0, "Lone Sniper");
        npcs generalCutlass = new npcs(10000.0, "General Cutlass");
        // test : assignments being made
        bunkerHill.setExit("west", leftFront);
        bunkerHill.setExit("east", rightFront);
        bunkerHill.setExit("north", outerRim);
        

        bunkerHill.addNpc("Mother Teresa", MotherTeresa);
        Items bossKey = new Items("bossKey", 0, 0);
        MotherTeresa.addItems("bossKey", bossKey);
        
        leftFront.setExit("north", chopShop);
        leftFront.setExit("east", bunkerHill);
        leftFront.setWeapons("smg", smg);
        leftFront.setWeapons("killGauntlet",killGauntlet);
        leftFront.setItems("Token", Token);
        leftFront.addEnemy("Cannibal", new organism(100.0, "Cannibal").setVoice(" - you watch a human eating a corpse of another human")
        .setWeapon("DarkKnife", 50.0, 5));
        leftFront.addEnemy("Stray Dog",new organism(50.0, "Stray dog").setVoice(" - you hear a mad bark in the distance!")
        .setWeapon("claw", 20.0, 5));
            
        leftFront.setItems("Potion", Potion);
        
        rightFront.setExit("north", superMarket);
        rightFront.setExit("west", bunkerHill);
        rightFront.setWeapons("smg", smg);
        rightFront.setWeapons("killGauntlet", killGauntlet);
        rightFront.setItems("Token", Token);
        rightFront.addEnemy("Cannibal", new organism(100.0, "Cannibal").setVoice(" - you watch a human eating a corpse of another human")
        .setWeapon("DarkKnife", 50.0, 5));
        rightFront.addEnemy("Stray Dog",new organism(50.0, "Stray dog").setVoice(" - you hear a mad bark in the distance!")
        .setWeapon("claw", 20.0, 5));
        rightFront.setItems("Potion", Potion);
         
        outerRim.setExit("north", plaza);
        outerRim.setExit("west", chopShop);
        outerRim.setExit("east", superMarket);
        outerRim.setExit("south", bunkerHill);
        outerRim.addEnemy("Cannibal", new organism(100.0, "Cannibal").setVoice(" - you watch a human eating a corpse of another human")
        .setWeapon("DarkKnife", 50.0, 5));
        outerRim.addEnemy("Raged bandit", new organism(100.0, "Raged bandit").setVoice(" - you see bodies on the ground, and a man ravaging through them.")
        .setWeapon("GatlingGun", 150.0, 20));
        
        outerRim.setItems("Token", Token2);
        outerRim.setItems("Potion", Potion);
        
        chopShop.setExit("north", garage);
        chopShop.setExit("east", outerRim);
        chopShop.setExit("south", leftFront);
        chopShop.addEnemy("Raged Bandit", new organism(100.0, "Raged Bandit").setVoice(" - you see bodies on the ground, and a man ravaging through them.")
        .setWeapon("GatlingGun", 150.0, 20));
        chopShop.setItems("Vile", Vile);
        chopShop.setItems("Blood", Blood);
        chopShop.setItems("Token", Token3);
        
        superMarket.setExit("north", toxicValue);
        superMarket.setExit("west", outerRim);
        superMarket.setExit("south", rightFront);
        superMarket.addEnemy("Raged Bandit", new organism(100.0, "Raged Bandit").setVoice(" - you see bodies on the ground, and a man ravaging through them.")
        .setWeapon("GatlingGun", 150.0, 20));
        superMarket.setWeapons("Smg", smg);
        superMarket.setItems("Token", Token3);
        superMarket.setItems("Blood", Blood);
        superMarket.setItems("Potion", Potion);
        
        plaza.setExit("north", vorgaStrip);
        plaza.setExit("west", garage);
        plaza.setExit("east", toxicValue);
        plaza.setExit("south", outerRim);
        plaza.addEnemy("Sniper", new organism(800.0, "Sniper").setWeapon("ragnorak" , 200.0, 50).setVoice(" - you hear a bang go off in the distance! it hits beside you."));
        plaza.setItems("Token",Token4);
        plaza.setWeapons("Rifle", rifle);
        plaza.setItems("Vile", Vile);
        
        garage.setExit("north", valhalla);
        garage.setExit("east", plaza);
        garage.setExit("south", chopShop);
        garage.addEnemy("The Gorgon", new organism(300.0, "The Gorgon").setVoice(" - Argh! you die human!").setWeapon("killBlade", 80.0, 20));
        garage.setItems("Blood", Blood);
        
        
        toxicValue.setExit("north", wakeValley);
        toxicValue.setExit("west", plaza);
        toxicValue.setExit("south", superMarket);
        toxicValue.addEnemy("Stray Dog", new organism(50.0, "Stray dog").setVoice(" - you hear a mad bark in the distance!")
        .setWeapon("claw", 20.0, 5));
        
        vorgaStrip.setExit("north", hailMary);
        vorgaStrip.setExit("west", valhalla);
        vorgaStrip.setExit("east", wakeValley);
        vorgaStrip.setExit("south", plaza);
        vorgaStrip.addEnemy("Sniper", new organism(800.0, "Sniper").setVoice(" - you hear a bang go off in the distance! it hits beside you.")
        .setWeapon("ragnorak" , 200.0, 50));
        vorgaStrip.setItems("Token", Token4);
        vorgaStrip.setItems("Potion", Potion);
        
        
        valhalla.setExit("north", deathClub);
        valhalla.setExit("east", vorgaStrip);
        valhalla.setExit("south", garage);
        valhalla.addEnemy("Gorgon",new organism(500.0, "death gorgon").setVoice(" - you watch a Gorgon eating another Gorgon, this isnt good."));
        valhalla.setItems("Potion", Potion);
        
        wakeValley.setExit("north", thunderDome);
        wakeValley.setExit("west", vorgaStrip);
        wakeValley.setExit("south", toxicValue);
        wakeValley.addEnemy("Raged Bandit", new organism(100.0, "Raged bandit").setVoice(" - you see bodies on the ground, and a man ravaging through them.")
        .setWeapon("GatlingGun", 150.0, 20));
        wakeValley.setItems("Token", Token4);
        wakeValley.setItems("Potion", Potion);
         
        hailMary.setExit("north", ultraLuxe);
        hailMary.setExit("west", deathClub);
        hailMary.setExit("east", thunderDome);
        hailMary.setExit("south", vorgaStrip);
        hailMary.addEnemy("Mordum", new organism(1000.0, "Mordum").setWeapon("ThunderGauntlet", 800.0, 80)
        .setVoice(" - by the smell of the air, I think this is the layer of Mordum."));
        hailMary.setWeapons("AlienBlaster",alienBlaster);
        hailMary.setItems("Potion", Potion);
        
        deathClub.setExit("east", hailMary);
        deathClub.setExit("south", valhalla);
        deathClub.addEnemy("Beast", new organism(800.0, "Beast").setWeapon("DeathClaw", 400.0, 10)
        .setVoice(" - *snarls and sniffs* the beast senses you draw near..."));
        deathClub.addEnemy("Mordum", new organism(1000.0, "Mordum").setWeapon("ThunderGauntlet", 800.0, 80)
        .setVoice(" - by the smell of the air, I think this is the layer of Mordum."));
        deathClub.setItems("Token", Token4);
           
        thunderDome.setExit("west", hailMary);
        thunderDome.setExit("south", wakeValley);
        thunderDome.addEnemy("Mordum", new organism(1000.0, "Mordum").setWeapon("ThunderGauntlet", 800.0, 80)
        .setVoice(" - by the smell of the air, I think this is the layer of Mordum."));
        thunderDome.addEnemy("Beast", new organism(800.0, "Beast").setWeapon("DeathClaw", 400.0, 10)
        .setVoice(" - *snarls and sniffs* the beast senses you draw near..."));
        thunderDome.setWeapons("MonsterBlast", monsterBlast);
        thunderDome.setItems("Token", Token4);
        
        ultraLuxe.setExit("south", hailMary);
        ultraLuxe.addEnemy("Blood Beast",new organism(2000.0, "Blood Beast").setVoice(" - Who dares to enter my domain!")
        .setWeapon("DeathClaw", 400.0, 10));
        ultraLuxe.setItems("Token", Token4);
        ultraLuxe.setItems("Potion", Potion);
        //ultraLuxe.setTrader("Charlie", trader);
        ultraLuxe.lock();
        entrance = bunkerHill;
        traderEntrance = bunkerHill;
        
        rooms.put("bunkerHill", bunkerHill);
        rooms.put("rightFront", rightFront);
        rooms.put("leftFront",leftFront);
        rooms.put("outerRim", outerRim);
        rooms.put("vorgaStrip", vorgaStrip);
        rooms.put("garage", garage);
        rooms.put("chopShop", chopShop);
        rooms.put("superMarket", superMarket);
        rooms.put("toxicValue", toxicValue);
        rooms.put("plaza", plaza);
        rooms.put("valhalla", valhalla);
        rooms.put("deathClub", deathClub);
        rooms.put("hailMary",hailMary);
        rooms.put("thunderDome", thunderDome);
        rooms.put("ultraLuxe", ultraLuxe);
        rooms.put("wakeValley", wakeValley);
        
       
       //entrance = createWorld();
       //NotificationCenter.getInstance().addObserver("Player entered room", this, " playeredEnteredRoom");
    }
    public Room getEntrance()
    {
        
        return entrance;
    }
    public HashMap<String, Room> getRooms(){
        return rooms;
    }
    public Room getTraderEntrance(){
        return traderEntrance;
    }
    
    //public static GameWorld getInstance(){
        
    //}
    //public void playerEnteredRoom(Notification notifcation){
        // Player player = (Player)notifciation.getObject()
        //System.out.println("i got a notifcation");
    //}
   
    
}


