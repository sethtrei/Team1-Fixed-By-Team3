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
    ArrayList<Location> lst = new ArrayList<Location>();
    Location left = new Location(myLoc.x-1, myLoc.y);
    Location right = new Location(myLoc.x+1, myLoc.y);
    Location up = new Location(myLoc.x, myLoc.y+1);
    Location down = new Location(myLoc.x, myLoc.y-1);
    
    if (!(myMap.getLoc(left).contains(Map.Type.WALL) || myMap.getLoc(left).contains(Map.Type.GHOST))) {
    	lst.add(left);
    }
    if (!(myMap.getLoc(right).contains(Map.Type.WALL) || myMap.getLoc(right).contains(Map.Type.GHOST))) {
    	lst.add(right);
    }
    if (!(myMap.getLoc(up).contains(Map.Type.WALL) || myMap.getLoc(up).contains(Map.Type.GHOST))) {
    	lst.add(up);
    }
    if (!(myMap.getLoc(down).contains(Map.Type.WALL) || myMap.getLoc(down).contains(Map.Type.GHOST))) {
    	lst.add(down);
    }
    return lst;
  }

  public boolean move() {
    if (this.get_valid_moves().size() < 0) {
        myMap.move(myName, this.get_valid_moves().get(0), Map.Type.PACMAN);
        this.myLoc = this.get_valid_moves().get(0);
        return true;
    } else {
      return false;
    }
  }

  public boolean is_ghost_in_range() {
    int x = myLoc.x;
    if (x > 0) { return false; } // <-------------------------- ¯\_(ツ)_/¯
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
    if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
    	String cookie_name = "tok_x" + Integer.toString(myLoc.x) + "_y" + Integer.toString(myLoc.y);
    	return myMap.eatCookie(cookie_name);
    } else {
    	return null;
    }
  }
}
