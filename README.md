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

- `void mousePressed(double x, double y)` - Invoked when the mouse has been pressed, with the cursor's coordinates passed as double values `x` and `y` as its arguments.

## Part 2 - Newer (for us) programming concepts

### Interface

Interface is a type, just as a class is a type. It is used:
- to define a protocol of behavior that can be implemented by any class anywhere in the class hierarchy, or
- for capturing similarities among unrelated classes without artificially forcing a class relationship.

Example:

<img src=PUML/InterfaceExample.png>

Notice that the classes `Basin`, `Water`, and `Torso` all implement the `Touchable` interface.

What this results in is the three classes will be required to implement the methods `isTouched`, `isHTouched` and `isVTouched` as declared in the interface.

Also, any object derived from `Basin`, `Water`, or `Torso` can be passed as argument to the method `bothHandsCanFit(Touchable obj)`.

```Java
private boolean bothHandsCanFit(Touchable obj) {
  double leftHandX = getArm(0).getExtremityXEnd()-0.25;
  double rightHandX = getArm(1).getExtremityXEnd()+0.25;

  // Check that both hands are within the x range covered by the object
  return obj.isHTouched(leftHandX) && obj.isHTouched(rightHandX);
}
```

### Abstract Class

Data abstraction is the process of hiding certain details and showing only essential information to the user.

Abstraction can be achieved with either abstract classes or interfaces (which you will learn more about in the next chapter).

The abstract keyword is a non-access modifier, used for classes and methods:

- Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).

- Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

To access the abstract class, it must be inherited from another class.

In our case, `DrawableCircle` and `DrawableRectangle` are abstract classes. They cannot be instantiated (create objects derived directly from them). 

<img src=PUML/AbstractClasses.png>

### Enum



## Part 3 - Abiding by programming best practices

### The Open-Closed Principle

> "Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."

Example:

<img src=PUML/OcpExample.png>

Here, the superclass CompleteRobot is written in a way that it should not need to be modified even in the case of introduction of either:

- new behaviour e.g., different way of moving the robot's limbs for an existing task e.g., walking.
- new tasks for the robot to do, e.g., performing squats, or soaking the robot's hands

These new features can be added by creating new subclasses of `CompleteRobot`, as shown in these examples:

```Java
// CrabCompleteRobot.java
public class CrabCompleteRobot extends CompleteRobot{
  // This subclass is almost an exact copy of CompleteRobot,
  // but with a different way of walking, i.e., Crabstep
  public CrabCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeMoveAction(new ActionCrabstep(this));
    say("And I am the crab-walking robot.");
  }
}
```

```Java
// SquattingCompleteRobot.java
public class SquattingCompleteRobot extends CompleteRobot{
  // This subclass has a different Action i.e. ActionSquat.
  // It "performs squats" as its additional activity
  public SquattingCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    this.changeAction(new ActionSquat(this));
    say("Hello! I am a squatting robot.");
  }

  public void squat() {
    act();
    say("I am performing SQUATS");
  }
}
```

And these subclasses can have further subclasses, e.g.:

```Java
// HandWashingSquattingCompleteRobot.java
public class HandWashingSquattingCompleteRobot extends SquattingCompleteRobot{
  // This subclass has three more methods
  // which are required for it to "soak hands in water"
  // in addition to squatting (activity belonging to its superclass)
  public HandWashingSquattingCompleteRobot(double x, double y, double radius) {
    super(x, y, radius);
    say("Hello! I am a robot who can both squat and soak my hands!");
  }

  private boolean bothHandsCanFit(Touchable obj) {
    double leftHandX = getArm(0).getExtremityXEnd()-0.25;
    double rightHandX = getArm(1).getExtremityXEnd()+0.25;

    // Check that both hands are within the x range covered by the object
    return obj.isHTouched(leftHandX) && obj.isHTouched(rightHandX);
  }

  private void soakHands() {
    act(Direction.DOWN);
    say("Soaking my hands!");
  }

  public void useBasin(Basin basin) {
    if (bothHandsCanFit(basin)) soakHands();
    else goToX(basin.getX(), "THE WATER BASIN");
  }
}
```

More behaviours can be introduced by creating simple subclasses of either `CompleteRobot`, `CrabCompleteRobot`, `SquattingCompleteRobot` or `HandWashingSquattingCompleteRobot` as their superclass, instead of modifying the four directly which would break the *Open-Close Principle*.

- `CompleteRobot` - The most basic functional robot - walks normally and can neither "soak hands" nor "perform squats"
- `CrabCompleteRobot` - A robot that is still basic, but walks differently i.e. crab-walk
- `SquattingCompleteRobot` - A basic robot which can also "perform squats"
- `HandWashingSquattingCompleteRobot` - A robot which can "soak hands" and "perform squats"

### The Don't Repeat Yourself Principle (DRY)

> ... the DRY principle forbids duplicating information or code across different locations in a codebase.

By making use of inheritance, such as seen in the *Open-Close Principle* example, the *Don't Repeat Yourself Principle (Dry)* is also abided by, as methods and fields common to all robots are encapsulated within the superclass `CompleteRobot`.

```Java
// CompleteRobot.java
public class CompleteRobot extends HeadTorsoArmsLegs{
  private ActionStep moveAction;
  private Action currentAction;
  private Speech speech;
  
  public CompleteRobot(double x, double y, double radius) {
    super(x, y, radius);

    this.moveAction = new ActionStep(this);
    this.currentAction = new Action(this);
    this.moveAction.groundRobot();
    this.speech = new Speech(x, getForeHeadY() + radius);
    addChild(speech);
  }

  protected void changeMoveAction(ActionStep newMoveAction) {
    this.moveAction = newMoveAction;
  }

  protected void changeAction(Action newAction) {
    this.currentAction = newAction;
  }

  protected void act() {
    this.currentAction.act();
  }

  protected void act(Direction dir) {
    this.currentAction.act(dir);
  }

  public void goToX(double destX, String destLabel) {
    if (this.getX() < destX) {
      moveRight();
      say("I am moving right towards " + destLabel);
    }
    else {
      moveLeft();
      say("I am moving left towards " + destLabel);
    }
  }

  private void moveLeft() {
    this.moveAction.act(Direction.LEFT);
  }

  private void moveRight() {
    this.moveAction.act(Direction.RIGHT);
  }

  protected void say(String speechText) {
    speech.changeText(speechText);
  }
}
```

Without inheritance, there would be an additional 50 lines of code for each new type of robot.

### The Single Responsibility Principle

> The Single Responsibility Principle (SRP) is a fundamental principle in software design that states that **a class or module** should have only one reason to change, meaning it **should have only one responsibility**.

>*Each class or function should do one thing and do it well.*

As demonstrated in the case of `CompleteRobot` and its subclasses, each of the subclasses are responsible of changing only aspect of the superclass's behaviour:

- `CompleteRobot` - Direct superclass of the two below
  - `CrabCompleteRobot` - Changes only the `CompleteRobot`'s walk style
  - `SquattingCompleteRobot` - Enables the `CompleteRobot` to perform squats, and nothing more
    - `HandWashingSquattingCompleteRobot` - A subclass of `SquattingCompleteRobot`. It enables the `SquattingCompleteRobot` to wash its hands, and nothing more

Class diagram to demonstrate the above (also shown earlier for OCP):

<img src=PUML/OcpExample.png>

## Part 3 - The Robot's Body Composition

As has been done with constructing the robot's abilities, in composing the robot's bodyparts, the above concepts mentioned previously are also applied.

Here is the class diagram of just the classes that compose the `CompleteRobot`'s visible body

<img src=PUML/RobotComposition.png>

# Complete Class Diagram

<img src=PUML/ClassesHierarchy.png>