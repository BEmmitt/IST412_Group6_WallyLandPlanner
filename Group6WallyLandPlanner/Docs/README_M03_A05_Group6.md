IST 412, Penn State WC Summer 2024

Group 6: Bill Emmitt, Paul Michalek, Praj Turlapati, Jordan Runyon

SW Configuration:
    NetBeans v. 22
    Java JDK 22
    Java Project type: Maven

Project Description:

This Project uses an MVC package structure. 
We built our first use case: User Login.

The classes utilized by this use case include:
    - User( holds user credentials)
    - LoginController (handles login, register, and logout functionality)
    - LoginView (handles window creation, display, and button listeners)
    - PlannerView (creates the planner view window, still under development)
    - Demo (executes the code)
    - Main (executes the Demo.run method)

When the project is run, the user is prompted to enter their credentials in 
order to login or register a new user. New users are saved to a users.json file 
for future logins. When the user successfully logs in,a message confirming 
login success is displayed and the user is brought to the Planner View window. 
The Planner View window is still under development for a future use case. 
It does have the option to logout. 