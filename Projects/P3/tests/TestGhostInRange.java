import java.awt.Color;
import java.io.*;

//import org.junit.Test;
import junit.framework.*;

public class TestGhostInRange extends TestCase {
  //@Test
  public void testGhostInRange() throws FileNotFoundException {
	  NoFrame frame = new NoFrame();
	  
	  PacMan pacman = frame.addPacMan(new Location(2,3));
	  assertFalse(pacman.is_ghost_in_range());
	  
	  //This ghost will be diagonally from pacman, so it should still be false
	  Ghost ghost = frame.addGhost(new Location(1, 2), "Blinky", Color.red);
	  assertFalse(pacman.is_ghost_in_range());
	  
	  Ghost ghost2 = frame.addGhost(new Location(1,3), "Clyde", Color.orange);
	  assertTrue(pacman.is_ghost_in_range());
  }
}
