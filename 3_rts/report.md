# Report

Veranika Barkova (s5490871) & Simion Polivencu (s5480183)

## Introduction

> *Very briefly describe what your program does.*
 
>Expected length: ~100 words

This program represents a graph where battle simulation occurs. User has possibility to add and remove nodes, edges, armies and events. Nodes and edges are places where armies
can reside. User selects a node and then selects the type of army they want to add on the selected node (Men, Elves, Dwarves, Isengard or Mordor). There are 2 types of armies: Team 1 and team 2. Team 1 includes: Men, Elves and Dwarves. Team 2 stores the rest: Isengard and Mordor. If there is a conflict between armies on a node or edge -- armies are from conflicting teams, the battle takes place. Armies move randomly on each simulation step. There events can randomly happen that modify armies if there are within a certain node or edge, where the event occurs.

## Program design

> *Here you go over the structure of the program. Try not to go too in-depth here implementation-wise, but rather discuss the important components and relations between them. 
> If you think it can help, feel free to add a simple diagram here. The design of the program should be clear to the reader. 
> 
> In particular, describe the model of the program. How is it structured? How did you make sure to separate the different aspects of the program?
> How do the `model`, `view` and `controller` interact with each other?
> Additionally, you should include some design decisions in here. There is no need to provide an explanation for every single thing, 
> but there are often multiple ways of implementing a feature and in those cases it makes sense to state why you chose one over the other.*

> Expected length: as much as you need to explain the above.

The program is constructed basing on MVC design pattern. There are three main components (packages) Model, View, and Controller. 

Model part contains classes that implement nodes, edges, graph and its functionality. The Item class is an abstract superclass for the classes of Node and Edge and resambles their common methods and field (name, id, Color, etc.). There are also packages that implement armies, battle functionality, and events. Army package contains abstract classes Army and Unit that both have two child classes for two teams respectively in order to simplify the process of identifying if there will be battles (Army branches into --> TeamOneArmy, TeamTwoArmy). Each team has child classes of fractions and concrete classes of fraction armies and units. Package Events contains a super class Events and three different types of events implemented via three different classes (Hurricane, Covernstead and Healer Tower). Package Battle contains two classes: Simulations and Battle. Class Simulation is responsible for implementing simulations that occur after a button "Simulate Tiem Step" is pressed. The functionality needed for battles is implemented in Battle class and is aggregated in Simulation class (runSimualtion()) method.  

View package is packeage responsible for displaying graph on the screen. When the program is launched, a new frame is created. The frame is implemented in Frame class. There will be implemented several buttons within this frame that will be needed for implementation of basic functions, such as adding and removing node or edge, simulation run and exporting in JSON format. The buttons and the whole menu bar are initialized in MenuBar class and are associated in Frame class. The frame contains two panels (split implemented via `JSplitPane`). Left panel is implemented in the SidePanel class and shows details of selected edge or node. If no item was selected, it is empty. Right panel reprsents the graph and its elements and is created via Panel class. The class Painter is a helper class needed for SidePanel to draw more complex elements of interface. 

Controller package contains classes responsible for providing interaction and binding logic between model, view and user. Class MouseAdapter contains methods that allow to click, press, and drag a selected elemnt within a panel and this is a class that is initialized in Panel class to make it responding to mouse actions. There is also an additional Heuristics class that is needed for the implementation of mathematical calculations to determine if the click was on the existing node/edge. The MenuFunctions package implements functionality for each button from MenuBar (sets it as enabled, when the pre-conditions are met (e.g. node is selected --> actiavte the "Remove Node" button)). The Interfaces package contains 3 components: JSONise, Observer and Observable interfaces. JSONise interface is implemented by all elements that should be storeed in JSON file. It converts the class into a JSON string. Observer and Observable interfaces are part of Observer design pattern and were created to notify about changes in graph all classes that depend on information contained in graph (visual components).

The util package contains a TextureLoader class needed to draw complex graphic for visual interface.

The class Game is a class that creates graph and frame and connects them. This class is associated with class Main.

## Evaluation of the program

> *Discuss the stability of your implementation. What works well? Are there any bugs? Is everything tested properly? Are there still features that have not been implemented? Also, if you had the time, what improvements would you make to your implementation? Are there things which you would have done completely differently?*

>Expected length: ~300-500 words

The program works well and no bugs were found during the test session. The program was run for many times with different amounts of nodes and edges. The simulation was also tested many times. The program was developed in many steps and, mostly, all problems were fixed, when they were identified. The only problem that we could not solve properly is that moving nodes is not as smooth as wanted. This problem might be caused by JSwing paintComponent method and how it is called in our program. For the future, we could add sounds and a more sophisticated army generation as there are already implemented classes for all types of warriors. In our program we implemented the texture loading, however were unable to set the theme of the program to FlatDracuLaf. The imports did not work properly on our machines. Thus, given the time it would be nice to play with the themes of the game to provide more appealing interface. 
Speaking of implementations, more time could be dedicated to randomising the units in the armies. For now, we just add a speciifc unit type with fixed damage and health properties. A wiser implementation would be to randomise the unit addition in the army and set different special abilities to different units of the army. For example, in Men fraction unit "Gondor Soldier" could only attack twice as strong after the first battlle (assuming they got tired). Additionally, we could add loading option to have possibility to save game and option to undo last action.

## Questions

Please answer the following questions:

1. In this assignment, the program should follow the Model View Controller (MVC) pattern. Please explain the design of the program in terms of the MVC pattern. Specifically try to answer the following questions:
   - MVC consists of three components: Model, view and controller. Can you please explain the role of each component? Please provide examples of these roles from the assignment. How are these three roles (i.e. Model, view and controller) are implemented in the assignment?
   - MVC enforces special constraints on the dependencies between its three components: Model, view and controller. Please explain these constraints, and why are they important?

___

Answer: MVC is a design pattern, which devides the program in three components. Model component is responsible for containing main functional elements and data of the program that will be manipulated. For instance, node, edge and graph should be created in this component as they are basic elemnts of this program and contain their proper characteristics. View component is a component responsible for visualisation of elemnts that are initialized in Model component. Main frame, panels with graph or information about items, and buttons that user will see on the screen are part of this component. Controller component is component that is responsible for taking user input as adding or removing, selecting and moving items from the graph and changing Model component with respect to changes that user made. 

However, there are some difficulties that might appear during software developing basing on MVC pattern. For instance, adding new functionalities could be difficult as the programme is distributed and adding something in one part will lead to necessary additions in other components. Also linking these components can be quite difficult. Programs based on MVC can require more computation power as the information will always be traversed from Model to View and viceversa via Controller, but not directly. 
___

2. The Swing library provides the ability to create nested user interface components. In this assignment, you created multiple JPanel components on the user interface. These contain other user interface components to build-up a tree of user interface components.
Which design pattern does Swing implement to create a hierarchy of user interface components? Please explain this pattern and how it is implemented in Swing.
___

Answer: Swing library uses Decorator pattern. This pattern enbles to add fields and methods that were not initiallized in class from start. The more "attributes" a class recieves, there lower it is in hierarchy as basic elemnets are at the top. This patterns also enables adding the same type of element in it, which can be useful, when complex graphic intefaces are created.

___

3. The Observer pattern is useful to implement the MVC pattern. Can you please explain the relationship between the Observer pattern and the MVC pattern?
Please provide an example from the assignment on how the Observer pattern supports implementing the MVC pattern.

___

Answer: Observer pattern is programming pattern that enables to notify multiple classes (observers) if there were made some changes in one class (observable). Combination of Observer and MVC pattern can be a  quite efficient soultion. When a controller has changed something in model component, model component as an observable can notify all observers (view) about changes. In our assignment, graph was observable and panel responsible for its drawing was observer. 

___

## Process evaluation

> *Describe shortly the process that led to the final code and the report. What was easy, what was difficult? Did you make interesting mistakes? What have you learned from this assignment?*

> Expected length: ~150 words

The final code was written after we got a feedback that our MVC pattern is not respected. The program was fully restructured and done by the end. It was easy to create Model components. Implementation of View and Controller elements was the most difficult part as we did not have previous experience. This assignment gave us possibility to acquire knowledge in working with visual interface that can be manipulated directly by user input. This assignment demostrated that we actually can learn something new and comparatively difficult during a small period. The learned skills also showed that we are now able to create small projects in Java with real-life applicaiton.

## Conclusions

> *Add a very short summary/concluding remarks here*

- The program can create a graph
- The graph can be placed as user moves it
- The elements of graph can contain armies that will fight with each other if they are enemies
- There is possibility to export data about the graph in JSON format
