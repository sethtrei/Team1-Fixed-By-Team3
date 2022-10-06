import java.awt.Color;
import java.io.*;
import junit.framework.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    MainFrame game = new MainFrame();
    game.addGhost(new Location(1, 1), "Blinky", Color.cyan);
    Ghost kaneki = new Ghost("kaneki", new Location(1, 1), game.getMap());
    ArrayList<Location> lst = kaneki.get_valid_moves();
    assertTrue(lst.contains(new Location(1, 2)));
    assertTrue(lst.contains(new Location(2, 1)));
    assertFalse(lst.contains(new Location(0,0)));
  }
} 