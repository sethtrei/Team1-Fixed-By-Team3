# PacMan Game (Team1)
Group members: Brandon Gormley, Brian Hopkins, Matthew Day, Maxwell Myers
## Pacman Class

### consume()
consume() calls the eatCookie() method from the Map class, only if there is a cookie token located in the same tile as Pacman.
It is implemented using an if statement that checks Pacman's location for a cookie. It then calls eatCookie() on a Map object.

consume() is tested by instantiating a Pacman object and asserting that consume() returns a non-null value. This works because
by default there should be a cookie at the same location as Pacman, and consume() only returns a non-null value when there
is a cookie on the same location as Pacman.

### move()
move() attempts to move Pacman to the first valid move if there are any valid moves. It is tested by creating an instance of Pacman, then using move(), and then checking to see if it moved with getLoc().

## Ghost Class

### move()
move() attempts to move the ghost to the first valid move if there are any valid moves. It is tested by creating an instance of a ghost, then using move(), and then checking to see if it moved with getLoc().

## Map Class

### getLoc()
getLoc() gets the type of what is at the location by using getting what is at loc in the field HashMap.
