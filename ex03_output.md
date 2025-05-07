# Exercise 3: Output format

**Reminder: When run with no command line arguments, your implementation must read from `System.in` and write to 
`System.out`.**

The output format of EVE is very simple; it is similar to the standardised input format discussed in the previous 
exercise.  The main difference is that each entry is augmented with two fields: `valid` whose value is true or false, 
and `cost` whose value is a positive integer.  


This exercise is very simple, it just involves adding code to the standardiser implemented in exercise 1 to add dummy 
fields to the output, specifically `valid: true` and `cost: 0`.  These should also be standardised as per the rules in 
the previous exercise, for example trimming any whitespace aside from the space after the colon, and alphabetizing the 
fields.  (If these fields happen to already exist in the input, they should be
ignored and replaced with the default values below.)

For example the output after making this change should be:

```
vehicle_id: 1
color: silver
cost: 0
engine: Goliath Inc., electric
manufacturer: Goliath Inc.
type: truck, pickup
wheels: ACME, all-weather, 6
valid: true

vehicle_id: 2
color: blue
cost: 0
engine: ACME, diesel
manufacturer: ACME
type: car, convertible
wheels: ACME, all-weather, 4
valid: true
```

If you have already implemented an internal data structure for representing the entries and fields, this should be very 
easy.  If you have not done that yet, now is a good time.
