# Exercise 4: Validation

We will now move on to validation, one of the two main tasks of this assignment.  Validation simply means checking that 
the data being read in follows certain rules, which we will outline below.  Some of these rules amount to higher-level 
syntactic checks, for example ensuring that all vehicles have suitable parts specified, a color, a manufacturer and so 
on, and checking that the values of these fields are sensible (e.g. we cannot have an electric motor in a motorcycle 
at present).  Others are more domain specific, for example checking that cars have 4 wheels, trucks have 6 or 18 wheels, 
etc.



## RULES

The following rules describe valid input data for the various vehicles.

1. All vehicles have a `color` field.  Valid colors are `red`, `green`, `blue`, `orange`, `yellow`, `purple`, `pink`, 
   `black`, `white`, `silver`, `gold`.
2. There are three manufacturers, ACME, Consolidated Products, and Goliath Inc, which should be specified in the 
   `manufacturer` field.
3. A vehicle's `type` field specifies the general kind of vehicle (`car`, `truck`, `motorcycle`) and after a comma, a 
   subtype which conforms to the following rules;
   * cars can be `hatchback`, `sedan`, or `convertible`;
   * trucks can be `pickup` or `eighteen wheeler`, and
   * motorcycles can be `sport` or `touring`.
4. An `engine` field specifies its manufacturer followed by its fuel type. Fuel types include `diesel`, `petrol`, and 
   `electric`, all other fuel type values should be rejected.
   * Cars can have any engine fuel while motorcycles can only be petrol fueled and trucks cannot be electric.
5. A `wheels` field specifies its manufacturer, type, and number.  Numbers must be positive integers.  Wheel types are 
   either `winter`, `summer`, or `all-weather`.
   * Cars must have 4 wheels.
   * Pickup trucks which have 4 or 6 wheels and eighteen wheeler trucks must have 18 wheels. 
   * Motorcycles must have 2 wheels.
6. All of the fields mentioned above (`type`, `color`, `manufacturer`, `engine`, `wheels`) must be present in the input, 
along with the `vehicle_id`.   
7. No fields should be repeated.

For this exercise, implement validation for the data and add the actual result of validation (true/false) to the output, 
replacing the dummy `valid: true` output added in exercise 2.

After having implemented validation and wiring it up to the output, the output of the running example from exercise 1 
should look like this:
```
vehicle_id: 1
color: silver
cost: 1
engine: Goliath Inc., electric
manufacturer: Goliath Inc.
type: truck, pickup
wheels: ACME, all-weather, 6
valid: false

vehicle_id: 2
color: blue
cost: 1
engine: ACME, diesel
manufacturer: ACME
type: car, convertible
wheels: ACME, all-weather, 4
valid: true
```

You are strongly encouraged at this point to sketch out a class hierarchy for the vehicles and their subtypes, and
identify appropriate fields and methods for meeting this requirement.  You will then want to define classes and/or
methods for converting input data structures into instances of appropriate classes, and perhaps identifying general
operations that multiple classes use and collecting these into abstract methods in abstract superclasses.

You **don't have to do it this way**: it is perfectly possible to program the validation checks just by maintaining the data in
an intermediate data structure and crawling over it to check each entry, or indeed by maintaining the input as a string
and analyzing it or modifying it using string operations.  But as the number and level of complexity of requirements grows, maintaining
and adding to such an approach may become painful.  