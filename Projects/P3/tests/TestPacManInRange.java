import java.awt.Color;
import java.io.*;
import org.junit.Test;
import junit.framework.*;

public class TestPacManInRange extends TestCase {
  @Test
  public void testPacManInRange() throws FileNotFoundException {
	  NoFrame frame = new NoFrame();
	  
	  PacMan pacman = frame.addPacMan(new Location(2,3));
	  //ghost1 is diagonal from pacman so this should be false
	  Ghost ghost1 = frame.addGhost(new Location(1,2), "Blinky", Color.red);
	  assertFalse(ghost1.is_pacman_in_range());
	  //ghost2 is right above pacman, so this should return true for ghost2
	  //but still be false for ghost1
	  Ghost ghost2 = frame.addGhost(new Location(1,3), "Clyde", Color.orange);
	  assertFalse(ghost1.is_pacman_in_range());
	  assertTrue(ghost2.is_pacman_in_range());
  }
}
