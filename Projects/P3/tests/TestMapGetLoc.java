import java.io.*;
import junit.framework.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(0, 0));
    pacman.move();
    assertFalse(frame.getMap().getloc((new Location(0, 0)) == Map.Type.PACMAN);
  }
}
