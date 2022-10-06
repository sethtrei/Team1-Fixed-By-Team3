# PacMan Game (Team1)
Group members: Brandon Gormley, Brian Hopkins, Matthew Day, Maxwell Myers

![Alt text](Projects/P3/start-menu.png)

To run the game from the command line, run the following commands from the project directoy:
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```
## Pacman Class

### consume()
consume() calls the eatCookie() method from the Map class, only if there is a cookie token located in the same tile as Pacman. It is implemented using an if statement that checks Pacman's location for a cookie. It then calls eatCookie() on a Map object and returns the cookie component if successful (null otherwise).

consume() is tested by instantiating a Pacman object and asserting that consume() returns a non-null value. This works because by default there should be a cookie at the same location as Pacman, and consume() only returns a non-null value when there is a cookie on the same location as Pacman.

### move()
move() attempts to move Pacman to the first valid move if there are any valid moves. It is tested by creating an instance of Pacman, then using move(), and then checking to see if it moved with getLoc().

### is_ghost_in_range()
This function simply checks every space adjacent to (not including diagonals), to see if any of those spaces contain a ghost. If they do, the function returns true, otherwise it returns false.

### get_valid_moves()
get_valid_moves() is responsible for returning an arraylist of coordinates which show you which direction PacMan can move in. This function takes into account the ghosts on the map as well as the walls/borders.

## Ghost Class

### move()
move() attempts to move the ghost to the first valid move if there are any valid moves. It is tested by creating an instance of a ghost, then using move(), and then checking to see if it moved with getLoc().

### attack()
ghost.attack() tests to ensure that a ghost is within 1 tile of Pacman. If this is the case, this function uses Map.move to move the Ghost onto Pacman's location. The Map.move() function then makes the necessary changes to end the game. This method calls Map.attack(), which will return True if the attack was successful and False otherwise.

ghost.attack() is tested by creating a Pacman and Ghost object next to eachother, and then ensuring that ghost.attack() returns True. This works because the function should return True when a ghost successfully attacked Pacman.

### get_valid_moves()
get_valid_moves() for ghosts is responsible for making sure that the ghosts do not run into the borders or walls of the map. It returns an arraylist of locations next to the ghost that are not currently blocked by a wall.

### is_pacman_in_range()
This functions works almost the same as PacMan,is_ghost_in_range(). It checks every space adjacent to the ghost (not including diagonals), to see if any of those contains pacman. If they do, the function returns true, otherwise it returns false.

## Map Class

### move()
move() is responsible for actually changing where pacman and the ghosts on the map are located.

### getLoc()
getLoc() gets the type of what is at the location by using getting what is at loc in the field HashMap.

### eatCookie()
map.eatCookie() is only called when Pacman is above a cookie, from the Pacman.consume() function. eatCookie() removes the cookie token from various instance variables of the Map. It takes as a parameter the string ID of the pacman object, and returns the cookie component if Pacman successfully ate the cookie (null otherwise).

map.eatCookie() is tested by creating a new Pacman object sharing a tile with a cookie token. Since the function should return the cookie component, a not-null assertion is used on the value of the function.

### attack()
This functions relies on the way that Ghost.attack() is implemented. Map.attack() will only be called by Ghost.attack(), and only after calling Map.move(). So all it does is first do a quick check to see if the input name provided is an existing name, otherwise it returns false. Then it checks to see if pacman still exists in the locations data structure. If pacman does exist, then the attack was not successfull, but if pacman does not exist, then the attack must have been successfull to gameOver is updated to be true, and the fucntion returns true.
