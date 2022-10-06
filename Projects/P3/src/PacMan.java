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
    }else if(myMap.getLoc(new Location(myLoc.x, myLoc.y+1)).contains(Map.Type.GHOST)){//down
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right

        lst.add(new Location(myLoc.x-1, myLoc.y)); // left
    
        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
        return lst;
    }else if(myMap.getLoc(new Location(myLoc.x, myLoc.y-1)).contains(Map.Type.GHOST)){//up
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        lst.add(new Location(myLoc.x-1, myLoc.y)); // left
        return lst;
    }else if(myMap.getLoc(new Location(myLoc.x+1, myLoc.y)).contains(Map.Type.GHOST)){//right
        lst.add(new Location(myLoc.x-1, myLoc.y)); // left

        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
    
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        return lst;
    }else if(myMap.getLoc(new Location(myLoc.x-1, myLoc.y)).contains(Map.Type.GHOST)){//left
        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        return lst;
      }


    lst.add(new Location(myLoc.x+1, myLoc.y)); // right

    lst.add(new Location(myLoc.x-1, myLoc.y)); // left

    lst.add(new Location(myLoc.x, myLoc.y-1)); // up

    lst.add(new Location(myLoc.x, myLoc.y+1)); // down
    return lst;
  }

  public boolean move() {
    if (this.get_valid_moves().size() > 0) {
        myMap.move(myName, this.get_valid_moves().get(0), Map.Type.PACMAN);
        this.myLoc = this.get_valid_moves().get(0);
        return true;
    } else {
      return false;
    }
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
    if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
    	String cookie_name = "tok_x" + Integer.toString(myLoc.x) + "_y" + Integer.toString(myLoc.y);
    	return myMap.eatCookie(cookie_name);
    } else {
    	return null;
    }
  }
}
