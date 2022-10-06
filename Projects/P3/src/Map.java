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
    HashSet<Type> s = new HashSet<Type>();
    s.add(type);

    switch(type){
      case EMPTY:
      this.components.get(name).setLocation(loc.x, loc.y);
      this.locations.put(name, loc);
      this.field.put(loc, s);
      return true;
      case PACMAN:
      PacMan pm = new PacMan(name, loc, this);
      if(pm.get_valid_moves().contains(loc)){
        this.components.get(name).setLocation(loc.x, loc.y);
        this.locations.put(name, loc);
        this.field.put(loc, s);
      }else{
        return false;
      }
      return true;
      case GHOST:
      Ghost g = new Ghost(name, loc, this);
      if(g.get_valid_moves().contains(loc)){
        this.components.get(name).setLocation(loc.x, loc.y);
        this.locations.put(name, loc);
        this.field.put(loc, s);
      }else{
        return false;
      }
      return true;
      default:
      return false;
    }
    // if (name.equals("pacman")) {
    //   this.components.get(name).setLocation(loc.x, loc.y);
    //   this.locations.put(name, loc);
    //   HashSet<Type> s = new HashSet<Type>();
    //   s.add(type);
    //   this.field.put(loc, s);
    //   return true;
        
    // } else if (name.equals("ghost")) {
    //   this.components.get(name).setLocation(loc.x, loc.y);
    //   this.locations.put(name, loc);
    //   HashSet<Type> s = new HashSet<Type>();
    //   s.add(type);
    //   this.field.put(loc, s);
    //   return true;
    // } else  {
    //   return false;
    // }
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return null;
  }

  public boolean attack(String Name) {
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    return null;
  }
}
