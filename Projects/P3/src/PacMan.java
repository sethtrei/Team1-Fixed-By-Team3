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
      if (myLoc.x == 23){// right side of board, cant move right
        lst.add(new Location(myLoc.x-1, myLoc.y)); // left

        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
    
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        return lst;
      }else if(myLoc.x == 23 && myLoc.y == 1){//top right corner
        lst.add(new Location(myLoc.x-1, myLoc.y)); // left
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        return lst;
      }else if (myLoc.y == 1){// top of board
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        lst.add(new Location(myLoc.x-1, myLoc.y)); // left
        return lst;
      }else if (myLoc.y == 1 && myLoc.x == 1){ //cant go left or up
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        return lst;
      }else if (myLoc.x == 1){ // dont go left
        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
        lst.add(new Location(myLoc.x, myLoc.y+1)); // down
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right
        return lst;
      }else if (myLoc.x == 1 && myLoc.y == 23){// dont go down or left
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right
        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
        return lst;
      }else if (myLoc.y == 23){// dont go down
        lst.add(new Location(myLoc.x+1, myLoc.y)); // right

        lst.add(new Location(myLoc.x-1, myLoc.y)); // left
    
        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
        return lst;
      }else if(myLoc.y == 23 && myLoc.x == 23){// dont go right or down
        lst.add(new Location(myLoc.x-1, myLoc.y)); // left
        lst.add(new Location(myLoc.x, myLoc.y-1)); // up
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
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
