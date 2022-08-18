# JPaint Application

** Class: SE 450 – Object Oriented Software Development**

The JPaint Application does the following:

- Draws Rectangle, Ellipse, and Triangle shapes on the canvas
- Draws the shapes with both primary and secondary colors
- Draws the shapes with shading types of either, filled in, filled in and outline, or outline
- Able to select shapes and then perform actions like move,copy,paste and delete
- Able to perform Undo and Redo actions for every action performed on the shape



# Design Patterns used:
[Command Design Pattern](#command)

[Static Factory Design Pattern](#staticfact)

[Strategy Design Pattern](#strat)

[Proxy Design Pattern](#proxy)

[Singleton Design Pattern](#Singleton)


---

---

<a name="command"/> 

## Command Design Pattern

The command pattern encapsulates in an object all the data required for performing a given action (command), including what method to call, the method’s arguments, and the object to which the method belongs

The command pattern is used in the application to store all the information required for executing the actions on the canvas. Undo and Redo is also implemented as a part of the command pattern.

**List of Classes or Interfaces Used** :

**Interface Used** : 
*                ICommand Interface

Classes Used : 
*                CreateShapeCommand
*                SelectShapeCommand
*                MoveShapeCommand
*                CopyShapeCommand
*                PasteShapeCommand
*                GroupShape
*                UnGroupShapeCommand

<a name="staticfact"/>

## Static Factory Design Pattern

Static factory method is simply a static method that returns an instance of a class.In this Case we have Used ICommand Interface and used it in Static Factory to Create new Instances of the Classes like Create,Select,Move.

**Interfaces Used** : 
*                ICommand Interface

**Classes Used** : 

*                CreateShapeCommand
*                SelectShapeCommand
*                MoveShapeCommand
*                CopyShapeCommand
*                PasteShapeCommand
*                GroupShape
*                UnGroupShapeCommand

**Methods Created in Static Factory** : 

1. public static ICommand DrawCommand
2. public static ICommand SelectCommand
3. public static ICommand moveCommand
4. public static ICommand copyCommand
5. public static ICommand pasteCommand
6. public static ICommand deleteCommand
7. public static ICommand groupCommand
8. public static ICommand ungroupCommand


## Strategy Design Pattern

**Interfaces Used** : 

*                      IDrawShape

**Classes Used**:

Draw Strategy Class uses IDrawShape Interface to switch between different Strategies.

**Strategies implementing IDrawShape**  : 
*                     Draw Ellipse
*                     Draw Rectangle
*                     Draw Triangle

## Proxy Design Pattern

Proxy Pattern is used to add functionality to another class.In this Case we are using the proxy design pattern for Drawing an Outline to the selected Shape.

**Interfaces Used** : 

*                    ISelectedShapeOutline

**Classes Implementing Interface** : 

*                    SelectedShapeOutline(Subject)
*                    SelectedShapeOutlineProxy(Subject Proxy)

**Classes Using Interface**

*                    DrawRectangleOutline
*                    DrawEllipseOutline
*                    DrawTriangleOutline

## Singleton Design Pattern




