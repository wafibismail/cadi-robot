# Instructions for Running and Compiling

Run these commands in the working directory:

To compile:

```
javac RobotClient.java
```

To run:

```
java RobotClient
```

In case of any changes updates to the code base, before recompiling the client, delete all existing .class files via the command

```
del *.class
```

# Assignment Instructions:

Design and develop a robot simulation application by incorporating object oriented principles such as method overloading, composition and inheritance. Use UML diagrams for your design specification(s). Use Java and <a href=https://algs4.cs.princeton.edu/home/>relevant reusuble libraries offered by Princeton</a>.

The class library should provide methods that could be incorporated to simulate some actions of the robot. For example a robot demonstrating some simple exercises. Keep the library, client and data in separate files. Generalize the class using suitable parameters so that objects can be instantiated by the client in a user friendly manner.

In other words the client should look as simple as possible. Be creative and use efficient application design and implementation principles which are stated in Assignment 1, e.g.:

- Key principles
  - The Open-Closed Principle
  - The Don't Repeat Yourself Principle (DRY)
  - The Single Responsibility Principle
  - Composite Reuse Design Principle
- In general, implementing loose coupling to maintain codebase modularity

# Parts

## Part 1 - Dependencies from Princeton:

### `StdDraw.java`

Standard drawing library. This class provides a basic capability for creating drawings with your programs. It uses a simple graphics model that allows you to create drawings consisting of geometric shapes (e.g., points, lines, circles, rectangles) in a window on your computer and to save the drawings to a file.

This is a dependency of `Draw.java`

### `Draw.java`

Drawing library. This class provides a basic capability for creating drawings with your programs. It uses a simple graphics model that allows you to create drawings consisting of points, lines, and curves in a window on your computer and to save the drawings to a file. This is the object-oriented version of standard draw; it supports multiple independent drawing windows.

Used methods:

- `void setPenColor(Color color)` - Sets the pen color to the given color.
- `void clear(Color color)` - Clears the screen to the given color.
- `void rectangle(double x, double y, double halfWidth, double halfHeight)` - Draws a rectangle of the specified size, centered at `(x, y)`.
- `void filledRectangle(double x, double y, double halfWidth, double halfHeight)` - Draws a filled rectangle of the specified size, centered at `(x, y)`.
- `void circle(double x, double y, double radius)` - Draws a circle of the specified radius, centered at `(x, y)`.
- `void filledCircle(double x, double y, double radius)` - Draws a filled circle of the specified radius, centered at `(x, y)`.

### `DrawListener.java`

Interface that accompanies `Draw.java`. This interface provides a basic capability for responding to keyboard in mouse events from `Draw` via callbacks.

`RobotClient` implements this interface.

Method used in `RobotClient`:

- `void mousePressed(double x, double y)` - Invoked when the mouse has been pressed.

# Part 2 - Used Java concepts

## Interface

Interface is a type, just as a class is a type. It is used:
- to define a protocol of behavior that can be implemented by any class anywhere in the class hierarchy, or
- for capturing similarities among unrelated classes without artificially forcing a class relationship.

Example:

<img src=PUML/InterfaceExample.png>

# Complete Class Diagram

<img src=PUML/ClassesHierarchy.png>