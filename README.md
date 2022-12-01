# PizziSalle
The goal of this univeristy project is to implement different design patters with java using MVC as architectural pattern 
The design patterns used are:
* Singleton: To make sure that the data read from the json files is only in one object and not duplicated. Also, to ease its access from different classes.
* Proxy: To load the data from the json files at the beginning of program execution.
* Iterator: To traverse the data loaded from the json files extracting from its data structure implementation.
* Composite: To compose the order as a tree structure having different types of sub-orders such as pizzas or drinks.
* DAO (Data Access Object): To define how the program can access the data in the json files without knowing its implementation.