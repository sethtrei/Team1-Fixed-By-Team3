# PacMan Game (Team1)

## Pacman Class

### consume()
consume() calls the eatCookie() method from the Map class, only if there is a cookie token located in the same tile as Pacman.
It is implemented using an if statement that checks Pacman's location for a cookie. It then calls eatCookie() on a Map object.

consume() is tested by instantiating a Pacman object and asserting that consume() returns a non-null value. This works because
by default there should be a cookie at the same location as Pacman, and consume() only returns a non-null value when there
is a cookie on the same location as Pacman.

## Ghost Class


## Map Class

