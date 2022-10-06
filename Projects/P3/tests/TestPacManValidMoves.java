import java.io.*;
import java.util.ArrayList;

import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    MainFrame game = new MainFrame();
    game.addPacMan(new Location(1, 1));
    PacMan kaneki = new PacMan("kaneki", new Location(1,1), game.getMap());
    ArrayList<Location> lst = kaneki.get_valid_moves();
    assertTrue(lst.contains(new Location(1, 2)));
    assertTrue(lst.contains(new Location(2, 1)));
    assertFalse(lst.contains(new Location(0,0)));
    
  }
}
