import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    int x = myLoc.x;
    int y = myLoc.y;
    if (myMap.getLoc(new Location(x-1, y)).contains(Map.Type.GHOST) ||
    	myMap.getLoc(new Location(x+1, y)).contains(Map.Type.GHOST) ||
    	myMap.getLoc(new Location(x, y-1)).contains(Map.Type.GHOST) ||
    	myMap.getLoc(new Location(x, y+1)).contains(Map.Type.GHOST)) {
    	return true;
    } else {
    	return false;
    }
  }

  public JComponent consume() {
    return null;
  }
}
