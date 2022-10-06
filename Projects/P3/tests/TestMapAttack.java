import java.awt.Color;
import java.io.*;
import org.junit.Test;
import junit.framework.*;

public class TestMapAttack extends TestCase {
  @Test
  public void testMapAttack() throws FileNotFoundException {
	  NoFrame frame = new NoFrame();
	  
	  PacMan pacman = frame.addPacMan(new Location(2,3));
	  assertFalse(frame.getMap().attack("fanasdcfudicxk"));
	  assertFalse(frame.getMap().isGameOver());
	  //Should be noted that you shouldn't ever really call Map.attack directly,
	  //it should be called after a Ghost.attack to see if it was successful,
	  //so instead of testing Map.attack, im going to call Map.isGameOver, since
	  //the only way that will return true is if Map.attack returned true.
	  Ghost ghost1 = frame.addGhost(new Location(1,1), "Blinky", Color.red);
	  ghost1.attack();
	  //if this worked (which it shouldn't) it would automatically call Map.attack("Blinky")
	  assertFalse(frame.getMap().isGameOver());
	  
	  Ghost ghost2 = frame.addGhost(new Location(3,3), "Clyde", Color.orange);
	  ghost2.attack();
	  //this should work, so it will automatically call Map.attack("Clyde")
	  assertTrue(frame.getMap().isGameOver());
  }
}
