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
    return false;
  }

  public boolean attack() {
    if (is_pacman_in_range()) {
    	int x = myLoc.x;
        int y = myLoc.y;
        Location pacman_loc;
        if (myMap.getLoc(new Location(x-1, y)).contains(Map.Type.PACMAN)) {
        	pacman_loc = new Location(x-1, y);
        } else if (myMap.getLoc(new Location(x+1, y)).contains(Map.Type.PACMAN)) {
			pacman_loc = new Location(x+1, y);
        } else if (myMap.getLoc(new Location(x, y-1)).contains(Map.Type.PACMAN)) {
        	pacman_loc = new Location(x, y-1);
        } else if (myMap.getLoc(new Location(x, y+1)).contains(Map.Type.PACMAN)) {
        	pacman_loc = new Location(x, y+1);
        } else {
        	//If there was a problem, and pac-man cannot be found in the ghost's range.
        	return false;
        }
    	myMap.move(myName, pacman_loc, Map.Type.GHOST);
    	return myMap.attack(myName);
    }
    else {
    	return false;
    }
  }
}
