# PizziSalle
PizziSalle is a Java-based implementation of a restaurant order management system that simulates the process of taking orders from customers. The system is designed to be used in a terminal-based environment and provides a range of features for managing orders, including adding, modifying, and deleting orders.
The goal of this university project is to implement different design patters with java using MVC as architectural pattern 
The design patterns used are:
* Singleton: To make sure that the data read from the json files is only in one object and not duplicated. Also, to ease its access from different classes.
* Proxy: To load the data from the json files at the beginning of program execution.
* Iterator: To traverse the data loaded from the json files extracting from its data structure implementation.
* Composite: To compose the order as a tree structure having different types of sub-orders such as pizzas or drinks.
* DAO (Data Access Object): To define how the program can access the data in the json files without knowing its implementation.
