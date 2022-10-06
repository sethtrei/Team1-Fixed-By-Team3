import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestAttack extends TestCase {

  public void testAttack() throws FileNotFoundException {
	  NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

	  //Creating Players
	  Ghost ghost = frame.addGhost(new Location(1, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
	  PacMan pacman = frame.addPacMan(new Location(1, 3)); //Creates PacMan at location x, y
	  
	  //Since the ghost and pacman are next to eachother, this should return True.
	  assertTrue(ghost.attack());
  }
}
