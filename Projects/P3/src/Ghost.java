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
    ArrayList<Location> lst = new ArrayList<Location>();
    if(myMap.getLoc(new Location(myLoc.x, myLoc.y+1)).contains(Map.Type.WALL)){//down
    lst.add(new Location(myLoc.x+1, myLoc.y)); // right
    lst.add(new Location(myLoc.x-1, myLoc.y)); // left
    lst.add(new Location(myLoc.x, myLoc.y-1)); // up
    return lst;
  }else if(myMap.getLoc(new Location(myLoc.x, myLoc.y-1)).contains(Map.Type.WALL)){//up
    lst.add(new Location(myLoc.x+1, myLoc.y)); // right
    lst.add(new Location(myLoc.x, myLoc.y+1)); // down
    lst.add(new Location(myLoc.x-1, myLoc.y)); // left
    return lst;
  }else if(myMap.getLoc(new Location(myLoc.x+1, myLoc.y)).contains(Map.Type.WALL)){//right
    lst.add(new Location(myLoc.x-1, myLoc.y)); // left
    lst.add(new Location(myLoc.x, myLoc.y-1)); // up
    lst.add(new Location(myLoc.x, myLoc.y+1)); // down
    return lst;
  }else if(myMap.getLoc(new Location(myLoc.x-1, myLoc.y)).contains(Map.Type.WALL)){//left
    lst.add(new Location(myLoc.x, myLoc.y-1)); // up
    lst.add(new Location(myLoc.x+1, myLoc.y)); // right
    lst.add(new Location(myLoc.x, myLoc.y+1)); // down
    return lst;
  }
    lst.add(new Location(myLoc.x+1, myLoc.y));
    lst.add(new Location(myLoc.x-1, myLoc.y));
    lst.add(new Location(myLoc.x, myLoc.y+1));
    lst.add(new Location(myLoc.x, myLoc.y-11));
    return lst;
  }

  public boolean move() {
    if (this.get_valid_moves().size() > 0) {
        myMap.move(myName, this.get_valid_moves().get(0), Map.Type.GHOST);
        myLoc = this.get_valid_moves().get(0);
        return true;
    } else {
      return false;
    }
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
