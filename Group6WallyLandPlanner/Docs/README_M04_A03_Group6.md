IST 412, Penn State WC Summer 2024

Group 6: Bill Emmitt, Paul Michalek, Praj Turlapati, Jordan Runyon

SW Configuration:
    NetBeans v. 22
    Java JDK 22
    Java Project type: Maven

Project Description:

This Project uses an MVC package structure. 
We combined our second and third use case into: Attraction Reservations.

The classes utilized by this use case include:

Model:
- Planner(added serialization so Planners persist between runs)
- Attraction
- Ride
- Show

Controller:
- PlannerController (handles functionality between Planner and PlannerView)
- AttractionController (handles attraction list functionality) 
- AttractionAdapter (helps with serialization of abstract objects in Planner)
- AttractionNotFoundException (handles a custom error with searching attractions)

View:
- PlannerView (creates the planner view window, still under development)
- AttractionView (displays the list of avialable Attractions and user 
                  interaction for reservations)
- AttractionCellRender (renders the view list with formatting)

Description:    
    When the project is run, the user is prompted to enter their credentials in 
order to login or register a new user. At the PlannerView, the next window after
logging in, the user can see there reservations and click the "Add a Reservation"
button to view available attractions. When an attraction in the list is selected,
the user can click "add reservation" to add the attraction to their planner list.
Attractions can also be deleted from the planner view. Attractions are read from
a comma delimited txt file, allowing for new attractions to be easily added. 
Users planners are serialzed into a Json file so they persist across runs.