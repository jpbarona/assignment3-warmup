# Exercise 1 : Input format

Input to EVE is read from the standard input stream which you can access using `System.in` with the `Scanner` or 
`BufferedReader` classes.  Input should **only** be read from `System.in` and **only** be written to `System.out`.  It 
is fine to also allow reading from files whose names are passed as command line arguments, but for the assessed stage,
your solution should be possible to run with no command line arguments, and reading only from `System.in` and writing to
`System.out`.

Input files can look like the following example (which intentionally has some inconsistent formatting that is 
allowed in the input):

```
vehicle_id: 2
type: car, convertible
engine:   Goliath Inc.,  diesel   
color: blue
manufacturer: ACME
wheels: ACME,   all-weather,  4



vehicle_id:     01
type: truck, pickup
 color  :  silver
engine: ACME, electric
manufacturer:  Goliath Inc.
wheels: ACME, all-weather, 6
```

Each input consists of a sequence of vehicle entries, consisting of  a contiguous block of lines of the 
form `key: value`..  Consecutive blocks are separated by at least one blank line.  More than one blank line in the 
sequence is treated the same as a single blank line.  Keys are always a single word with no spaces or special characters, 
just letters a-z, A-Z.  Whitespace at the beginning of the value after the colon, or at the end of the value before the 
newline, is not meaningful and should be ignored as well.  There should be exactly one colon per line.

There can be multiple vehicle entries, starting with the `vehicle_id` field.  The `vehicle_id` fields in a given 
input need to be distinct positive integers, but they don't need to be consecutive.

Implement a class that reads in data of this form, checks that it matches the required format, and then prints it back 
out in a standardised form.  

The required standardised form is as follows:

1.  The vehicle entries have to be printed out in increasing order of the vehicle id.
2.  The fields are printed in alphabetical order.
3.  Each entry is separated by exactly one blank line, even if there were multiple blank lines in the input.
4.  Keys should be printed with no whitespace before the beginning of the key or after the key and before the `:`symbol, 
    then there should be exactly one whitespace character after the `:` and before the value, then the value itself 
    (including any non-ignored whitespace in it), and then a newline.
5.  Numerical values should be standardised to remove any leading zeros.

In addition, the vehicle id field should always appear first.

For example, the small example given above should be transformed to this standard form:

```
vehicle_id: 1
color: silver
engine: Goliath Inc., electric
manufacturer: Goliath Inc.
type: truck, pickup
wheels: ACME, all-weather, 06

vehicle_id: 2
color: blue
engine: ACME,  diesel
manufacturer: ACME
type: car, convertible
wheels: ACME,   all-weather,  04
```

Notice that stray whitespace and extra lines have all been removed, there is exactly one space after each colon, and the 
value strings are also otherwise unchanged.  However, spaces inside the value part of a key-value pair are still 
preserved.

HINT: Besides `Scanner`, Java standard library classes such as `HashMap` and `List`, and methods such as `sort`, are 
very helpful for this exercise.
