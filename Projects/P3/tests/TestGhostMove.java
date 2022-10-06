import java.io.*;
import junit.framework.*;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Ghost = frame.addGhost(new Location(0, 0));
    ghost.move();
    assertFalse(frame.getMap().getloc((new Location(0, 0)) == Map.Type.GHOST);
  }
}
