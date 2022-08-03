# JPaint Application 

** Class: SE 450 – Object Oriented Software Development**

The IPaint Application does the following:

- Draws Rectangle, Ellipse, and Triangle shapes on the canvas
- Draws the shapes with both primary and secondary colors
- Draws the shapes with shading types of either, filled in, filled in and outline, or outline
- Able to select shapes and then perform actions like move,copy,paste and delete
- Able to perform Undo and Redo actions for every action performed on the shape



# Design Patterns used:
[Command Design Pattern](#command)

[Static Factory Design Pattern](#s-fact)

[Strategy Design Pattern](#strat)

[Proxy Design Pattern](#proxy)


---

---

<a name="command"/> 

## Command Design Pattern

The command pattern encapsulates in an object all the data required for performing a given action (command), including what method to call, the method’s arguments, and the object to which the method belongs

The command pattern is used in the application to store all the information required for executing the actions on the canvas. Undo and Redo is also implemented as a part of the command pattern



