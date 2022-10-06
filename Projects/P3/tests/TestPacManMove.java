import java.io.*;
import junit.framework.*;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    PacMan pacman = frame.addPacMan(new Location(1, 1));
    pacman.move();
    assertFalse(frame.getMap().getloc((new Location(0, 0)) == Map.Type.PACMAN);
  }
}
