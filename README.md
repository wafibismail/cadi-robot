# Running and Compiling Instructions

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

# Complete Class Diagram

<img src=ClassesHierarchy.png>