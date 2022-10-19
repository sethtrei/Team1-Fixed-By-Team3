import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location

    switch(type){
      case PACMAN:
      //find location of pacman
        Location oldLoc = this.locations.get(name);
        this.field.get(oldLoc).remove(Map.Type.PACMAN);
        this.components.get(name).setLocation(loc.x, loc.y);
        this.locations.put(name, loc);
        this.field.get(loc).add(Map.Type.PACMAN);
        return true;
      case GHOST:
        Location ghostOldLoc = this.locations.get(name);
        this.field.get(ghostOldLoc).remove(Map.Type.GHOST);
        if(field.get(loc).contains(Map.Type.PACMAN)){
          this.field.get(loc).remove(Map.Type.PACMAN);
          this.locations.remove("pacman");
        }
        this.components.get(name).setLocation(loc.x, loc.y);
        this.locations.put(name, loc);
        this.field.get(loc).add(Map.Type.GHOST);
        return true;
      default:
        return false;
    }
  }


  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return field.get(loc);
  }

  public boolean attack(String Name) {
    // update gameOver
    /*this relies on how the ghost attack function was implemented.
	  I will assume that the ghost attack function calls the Map.move function,
	  which will remove pacman from locations and field when a ghost is on top of pacman.
	  This means I will only have to check if pacman is contained in locations
	*/
	if (!locations.containsKey(Name)) {
		return false;
	}
	if (!locations.containsKey("pacman")) {
		gameOver = true;
	}
	return gameOver;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
	
	//If this method was called from pacman-consume(), that means
	//we can assume pac-man is sharing a location with a cookie.
	//name holds the name of the cookie which I'll use to gather
	//other info like location and the JComponent for the cookie.
	Location loc;
	JComponent cookie;
    try {
    	loc = locations.get(name); //loc holds the pac-man/cookie location
        cookie = components.get(name); //cookie holds the cookie
    }
    catch (Exception e) {
    	//If something goes wrong with finding the cookie at the given location
    	return null;
    }
    
    //update variables
    locations.remove(name);
    components.remove(name);
    field.get(loc).remove(Type.COOKIE);
    cookies -= 1;
    
    return cookie;
  }
}
