import java.util.ArrayList;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
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

  public boolean is_pacman_in_range() {
	int x = myLoc.x;
    int y = myLoc.y;
    if (myMap.getLoc(new Location(x-1, y)).contains(Map.Type.PACMAN) ||
    	myMap.getLoc(new Location(x+1, y)).contains(Map.Type.PACMAN) ||
    	myMap.getLoc(new Location(x, y-1)).contains(Map.Type.PACMAN) ||
    	myMap.getLoc(new Location(x, y+1)).contains(Map.Type.PACMAN)) {
    	return true;
    } else {
    	return false;
    }
  }

  public boolean attack() {
    return false;
  }
}
