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
    if (this.get_valid_moves().size() > 0) {
        myMap.move(myName, this.get_valid_moves().get(0), Map.Type.GHOST);
        myLoc = this.get_valid_moves().get(0);
        return true;
    } else {
      return false;
    }
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}
