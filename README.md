# Mars Rover

![Mars Rover UML diagram](https://github.com/debnon/Mars-Rover/blob/main/MarsRoverUML.png?raw=true)

## Overview
The Mars Rover program takes initial values for the size of a plateau and position of a rover on it. An instruction composed of the letters M (move forward), L (turn left) and R (turn right) can be used to control the rover. The resulting position and orientation of the rover can then be returned. As many rovers as desired can be instantiated on a plateau so long as they remain within the plateau's limits and don't intersect with any other rovers. 

## Architecture
The methods used to implement this functionality are split into two main abstract classes, the Rover and the Plateau. Each has a set of interfaces which defines the methods which each must handle. In the case of the Plateau this is RoverInformation and PlateauInformation. As we want it to be possible to reuse our code in the future for differently shaped plateaus and coordinate systems, those methods that can be abstracted from a Cartesian coordinate system are defined in the abstract class. For the Plateau class that is those methods dealing with the HashMap that stores the rovers present on a particular plateau instance. The remaining methods are defined in the more specific implementation RectPlateau. 

This is in contrast to the Rover, where all methods contain reference to Cartesian coordinates, and so implementation details are left to the RectPlateauRover. The abstract class functions as a way to group interfaces and enable easier inheritance in the future. A different design choice could have been made to have an abstract class representing any vehicle operating on a grid, although in this case we may have the reverse situation where all methods could be handled by the abstract class. 

## Other Features
Exception handling exists for a number of edge cases such as attempting to instantiate a plateau with negative size, instantiating a rover outside of the plateau or on top of another rover, and for movement instructions which cause one rover to intersect another. All of these terminate the program immediately apart from the last. An instruction will be executed until the rovers are actually at the point of intersection, where an exception is thrown returning a relevant message and the intersecting rover's current position. This could easily be changed to check the instruction for possible intersections before execution. 

Each class has a number of unit tests which ensure edge cases are handled properly and the program runs as described. The command `mvn test` can be used to check they are still passing if the code is changed or extended. 

## Further Outlook
* End-to-end testing
* Custom exception classes
* Frontend integration with visual representation of rover
