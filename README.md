# JPaint Application

** Class: SE 450 – Object Oriented Software Development**

The JPaint Application does the following:

- Draws Rectangle, Ellipse, and Triangle shapes on the canvas
- Draws the shapes with both primary and secondary colors
- Draws the shapes with shading types of either, filled in, filled in and outline, or outline
- Able to select shapes and then perform actions like move,copy,paste and delete
- Able to perform Group functionality where it can group the selected shapes and can add groups on top of the existing groups to form a new group and can also form multiple independent groups.
- Able to perform Select,Move,Copy,Paste,Delete functionalities on selected group.
- Able to replicate all the actions on the pasted shapes as well in both grouped shapes and ungrouped shapes.
- Able to UnGroup the Selected Groups.
- Able to perform Undo and Redo actions for every action performed on the shape



# Design Patterns used:
[Command Design Pattern](#command)

[Static Factory Design Pattern](#staticfact)

[Strategy Design Pattern](#strat)

[Proxy Design Pattern](#proxy)

[Singleton Design Pattern](#singleton)

[ProtoType Design Pattern](#prototype)


---

---

<a name="command"></a> 

## Command Design Pattern

The command pattern encapsulates in an object all the data required for performing a given action (command), including what method to call, the method’s arguments, and the object to which the method belongs

The command pattern is used in the application to store all the information required for executing the actions on the canvas. Undo and Redo is also implemented as a part of the command pattern.


**Interface Used** : 
*                ICommand.java

Classes Used : 
*                CreateShapeCommand.java
*                SelectShapeCommand.java
*                MoveShapeCommand.java
*                CopyShapeCommand.java
*                PasteShapeCommand.java
*                GroupShape.java
*                UnGroupShapeCommand.java

<a name="staticfact"></a>

## Static Factory Design Pattern

Static factory method is simply a static method that returns an instance of a class.In this Case we have Used ICommand Interface and used it in Static Factory to Create new Instances of the Classes like Create,Select,Move.

**Interfaces Used** : 
*                ICommand.java 

**Classes Used** : 

*                CreateShapeCommand.java
*                SelectShapeCommand.java
*                MoveShapeCommand.java
*                CopyShapeCommand.java
*                PasteShapeCommand.java
*                GroupShape.java
*                UnGroupShapeCommand.java

**Methods Created in Static Factory** : 

1. public static ICommand DrawCommand
2. public static ICommand SelectCommand
3. public static ICommand moveCommand
4. public static ICommand copyCommand
5. public static ICommand pasteCommand
6. public static ICommand deleteCommand
7. public static ICommand groupCommand
8. public static ICommand ungroupCommand

<a name="strat"></a>
## Strategy Design Pattern

**Interfaces Used** : 

*                      IDrawShape.java

**Classes Used**:

* Draw Strategy Class uses IDrawShape Interface to switch between different Strategies.

**Strategies implementing IDrawShape**  : 
*                     DrawEllipse.java
*                     DrawRectangle.java
*                     DrawTriangle.java

<a name="proxy"></a>
## Proxy Design Pattern

Proxy Pattern is used to add functionality to another class.In this Case we are using the proxy design pattern for Drawing an Outline to the selected Shape.

**Interfaces Used** : 

*                    ISelectedShapeOutline.java

**Classes Implementing Interface** : 

*                    SelectedShapeOutline.java(Subject)
*                    SelectedShapeOutlineProxy.java(Subject Proxy)

**Classes Using Interface**

*                    DrawRectangleOutline.java
*                    DrawEllipseOutline.java
*                    DrawTriangleOutline.java

<a name="singleton"></a>
## Singleton Design Pattern

Singleton Pattern has been used to Initialize the Color Instance for all the Shapes drawn on paintCanvas and this Pattern has a built in method called getInstance,which can be used in any Class to implement a Color to a Shape.

**Classes Created for Singleton Pattern** : 

*                    ColorSingleton.java

**Classes Using Singleton Pattern** : 

*                    ShapeConfig.java


<a name="prototype"></a>
## ProtoType Design Pattern

The prototype pattern is a creational design pattern.It allows us to hide the complexity of making new instances from the client.For this purpose we are using a Clone Method to replicate the properties of an existing shapes.In Our Code the prototype pattern has been used to Implement Copy,Paste Functionalities.

**Classes Using ProtoType Pattern** : 

*                    CreateShapeCommand

**Classes Implementing ProtoType Pattern** :

*                    PasteShapeCommand

# Link to GitHub repo
<a href="https://github.com/Satya-22/SE450-Group-18-Project-Repo.git" target="_blank">GitHub Link</a>


# Extra Credit :

A Total of 6 Design Patterns has been Implemented.

# List of Missing Features :

All the Functionalities are up and working.

# Miscellaneous Notes :

When we are creating a group,the shapes in the group are selected only by clicking on one of the shapes,but not the bounding box of the group.

# Bug Report : 

* While executing the Select Command on Drawn shape and groupShape,Sometimes all the Shapes from the group are not being selected,but the group bounding box is being generated, Due to this the Undo,Redo and Move Shaped are not being executed.

**Scenario** :
*  Suppose when we are dragging the imaginary box between DrawnShape and GroupShape but when we are dragging the imaginary box from GroupShape to DrawnShape this issue will not exist.
