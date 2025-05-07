# Exercise 2: Structured values

Values can have additional structure, for example an engine value consists of a manufacturer and a fuel type, separated 
by a comma, and a wheels value consists of a manufacturer, a tire type, and the number of wheels.

Extend your standardiser/processor to identify split values that contain commas into lists of strings.  Whitespace 
adjacent to a comma can also be ignored, and comma-separated values should be standardised so that there is no whitespace 
immediately before the comma and exactly one space after it.  Whitespace in between words or other characters (not 
adjacent to a comma) should still be preserved.  For example:

```
  A  comma,   separated,     l i s t
```
should become
```
A  comma, separated, l i s t
```

In addition, whereas before the text of a value containing commas was preserved exactly (except for leading or trailing 
whitespace), now we will standardise values that correspond to integers, by removing any leading zeros.

Using the example from exercise 1 as input, we should now obtain output like this:
```
vehicle_id: 1
color: silver
engine: Goliath Inc., electric
manufacturer: Goliath Inc.
type: truck, pickup
wheels: ACME, all-weather, 6

vehicle_id: 2
color: blue
engine: ACME, diesel
manufacturer: ACME
type: car, convertible
wheels: ACME, all-weather, 4
```

The order of the values in a comma separated list is significant should not be changed.

While it is perfectly possible to implement this behavior by reading the input a little at a time, and outputting a little at a time,
at this point you are encouraged to try to first read the input data into a more structured form (e.g. using some kind of Map for the
mappings from vehicle ids to records, and for the mappings from record fields to values, and using List<String> to
represent the internal form of the comma-separated values.)

Doing this is not required, but will make life easier later on, when you will need to do more involved things with the
data besides printing it back out again.
