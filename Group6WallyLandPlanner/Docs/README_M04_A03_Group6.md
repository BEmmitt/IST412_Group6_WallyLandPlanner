IST 412, Penn State WC Summer 2024

Group 6: Bill Emmitt, Paul Michalek, Praj Turlapati, Jordan Runyon

SW Configuration:
    NetBeans v. 22
    Java JDK 22
    Java Project type: Maven

Project Description:

This Project uses an MVC package structure. 
Our fourth Use Case is Adding a Reservation at a Restaurant in the park.
Our fifth Use Case is Entering a mobile order at a FoodStand in the park.

The classes utilized by this use case include:

Model:
- Planner(added serialization so Planners persist between runs)
- Restaurant
- FoodStand
- FoodItem
- Order

Controller:
- RestaurantController (handles available restaurants list functionality) 
- FoodOrderController (handles FoodStand list, adding foodItems to FoodStand 
    menu list, and mobile ordering functionality including checkout and adding
    items to Order from menu)

View:
- PlannerView (creates the planner view window, still under development)
- RestaurantView (displays the list of avialable restaurants and user 
                  interaction for reservations)
- FoodOrderView (displays list of available food stands and gives the option to
                 place a mobile food order)
- MobileOrderView (displays selected food stands menu and handles user input for
                   adding menu items to Order)
- PlannerView (Added navigation buttons to new use cases)
- AttractionCellRender (added formatting for restaurant time slots, food stands,
                        and menu items)

Description:    
    When the project is run, the user is prompted to enter their credentials in 
order to login or register a new user. At the PlannerView, the next window after
logging in, the user can see their reservations and click the new 
"Add a Restaurant Reservation" button to view available restaurants and their 
times. When an restaurant in the list is selected, the user can click 
"reserve table" to add the restaurant reservation to their planner list. The
RestaurantView functions similarly to the AttractionsView. There is also a new 
Mobile Food Order button that brings the user to the Food Stand view which 
displays available food stands to order from. When a food stand is selected the 
user is brought to the MobileOrderView which displays the menu on the left and 
the order on the right, menu items can be selected and added to the order. When 
a user check out a dialog box pops up confirming their order and displays the 
total cost and pick up time. The user is then rerouted to the plannerView if an 
order was placed, or back to the FoodOrderView to select another food stand. On 
the PlannerView page, the user cannot place another order until after their 
current order is complete. The user can check their order by clicking the 
"Check Order" button, which displays a dialog containing the order items, total 
price, and pickup times. The Planner can also be managed from the PlannerView,
which was our original 5th Use Case, however, we were able to complete this use
case while working through the other use cases. This includes the ability to add
new reservations and delete reservations, which is fully functional.