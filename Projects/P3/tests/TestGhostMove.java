import java.io.*;
import junit.framework.*;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost ghost = frame.addGhost(new Location(1, 1));
    ghost.move();
    assertFalse(frame.getMap().getloc(new Location(1, 1)) == Map.Type.GHOST);
  }
}
