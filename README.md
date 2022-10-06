# PacMan Game (Team1)
Group members: Brandon Gormley, Brian Hopkins, Matthew Day, Maxwell Myers
## Pacman Class

### consume()
consume() calls the eatCookie() method from the Map class, only if there is a cookie token located in the same tile as Pacman. It is implemented using an if statement that checks Pacman's location for a cookie. It then calls eatCookie() on a Map object and returns the cookie component if successful (null otherwise).

consume() is tested by instantiating a Pacman object and asserting that consume() returns a non-null value. This works because by default there should be a cookie at the same location as Pacman, and consume() only returns a non-null value when there is a cookie on the same location as Pacman.

### move()
move() attempts to move Pacman to the first valid move if there are any valid moves. It is tested by creating an instance of Pacman, then using move(), and then checking to see if it moved with getLoc().

## Ghost Class

### move()
move() attempts to move the ghost to the first valid move if there are any valid moves. It is tested by creating an instance of a ghost, then using move(), and then checking to see if it moved with getLoc().

### attack()
ghost.attack() tests to ensure that a ghost is within 1 tile of Pacman. If this is the case, this function uses Map.move to move the Ghost onto Pacman's location. The Map.move() function then makes the necessary changes to end the game. This method calls Map.attack(), which will return True if the attack was successful and False otherwise.

ghost.attack() is tested by creating a Pacman and Ghost object next to eachother, and then ensuring that ghost.attack() returns True. This works because the function should return True when a ghost successfully attacked Pacman.

## Map Class

### getLoc()
getLoc() gets the type of what is at the location by using getting what is at loc in the field HashMap.

### eatCookie()
map.eatCookie() is only called when Pacman is above a cookie, from the Pacman.consume() function. eatCookie() removes the cookie token from various instance variables of the Map. It takes as a parameter the string ID of the pacman object, and returns the cookie component if Pacman successfully ate the cookie (null otherwise).

map.eatCookie() is tested by creating a new Pacman object sharing a tile with a cookie token. Since the function should return the cookie component, a not-null assertion is used on the value of the function.
