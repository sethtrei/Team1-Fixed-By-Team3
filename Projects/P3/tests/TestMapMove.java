import java.io.*;
import junit.framework.*;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
	  NoFrame game = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
    game.addPacMan(new Location(1, 1));
    PacMan kaneki = new PacMan("pacman", new Location(1,1), game.getMap());
    game.getMap().move("pacman", new Location(1,2), Map.Type.PACMAN);
    assertFalse(game.getMap().getLoc(new Location(1, 1)).contains(Map.Type.PACMAN));
    assertTrue(game.getMap().getLoc(new Location(1, 2)).contains(Map.Type.PACMAN));
  }
}
