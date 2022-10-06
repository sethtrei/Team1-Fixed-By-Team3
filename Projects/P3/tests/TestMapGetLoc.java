import java.io.*;
import junit.framework.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(1, 1));
    pacman.move();
    assertFalse(frame.getMap().getloc(new Location(1, 1)) == Map.Type.PACMAN);
  }
}
