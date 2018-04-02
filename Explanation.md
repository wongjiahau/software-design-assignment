# Explanation of architecture

This project is using Model-View-Controller (MVC) pattern instead of Model-View-Presenter(MVP). In MVP, the Presenter delegates call to Controllers, whereas in MVC the Controllers delegates calls to View. The job of each layer is explained below:

- **Model** - Handles connection to persistence (e.g. database). 

- **View** - Display data, get user input and validating user input. It knows nothing about the flow of the app.

- **Controllers** - Handle business logic, control the flow of the app  



## Why is the DAO interface necessary?
This interface is introduced in this project so that developers can focus on building the front-end modules without concerning how the data persistence are actually connected to the app. They can achieve this by swapping the actual DAO with MockDAO.

## Why is the IStream interface necessary?
This interface is introduced in this project so that UI testing can be done using a spy, which is the MockStream object. By using this object, we can define a set of predefined user inputs, then we can use it to test if we get the expected output based on those inputs.
