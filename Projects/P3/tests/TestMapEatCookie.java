import java.awt.Color;
import java.io.*;
import junit.framework.*;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
	  NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

	  //Creating Players
	  Ghost ghost = frame.addGhost(new Location(1, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
	  PacMan pacman = frame.addPacMan(new Location(1, 3)); //Creates PacMan at location x, y
	  
	  //There should already be a cookie underneath eatCookie so consume() should be non-null
	  assertNotNull(frame.getMap().eatCookie("pacman"));
  }
}
