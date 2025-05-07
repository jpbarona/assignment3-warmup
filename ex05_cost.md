# Exercise 5: Costs

We will now consider the second part of the output, namely the cost estimate.  For this warmup exercise, the cost will 
be computed in a very simple way: each component and vehicle type has an associated cost and
we simply sum the vehicle cost and the cost of all components.  For components that have a quantity, like wheels/tyres,
this also needs to be taken into account.


Base costs by vehicle type:

| Vehicle            | Cost  |
|--------------------|-------|
| Hatchback          | 8000  |
| Sedan              | 12000 |
| Convertible        | 20000 |
| Sport Motorcycle   | 16000 |
| Touring Motorcycle | 9000  |
| Pickup Truck       | 20000 |
| Eighteen Wheeler   | 35000 |

Engine costs by fuel:

| Engine   | Cost |
|----------|------|
| Petrol   | 1000 |
| Diesel   | 2000 |
| Electric | 5000 |


Wheel costs by type:

| Tire        | Cost per tire |
|-------------|---------------|
| summer      | 100           |
| winter      | 120           |
| all-weather | 150           |

Also, naturally if there are `n` tyres on a given vehicle then the total cost of wheels for the vehicle is `n` times the 
cost per tyre.

Extend your implementation to handle costs.  Each object that represents a vehicle or vehicle part should have
its cost represented somehow, and there should be a way to sum up all of the costs associated with a particular vehicle.
This cost should be calculated for each vehicle provided in the input and the resulting cost (an integer) should be 
printed out in place of the dummy `cost: 0` field produced in exercise 2.

Vehicles do not have to be valid in order for it to be possible to compute their cost: for example it may make no sense 
to have a motorcycle with seven wheels, but if it did the cost of the wheels would be calculated by 
multiplying the cost per wheel by 7.  If a vehicle specification is invalid because of missing fields, the missing components 
are omitted from the cost.  If a specification is invalid due to repeated fields, you only need to include the cost of the first
repeated field.  (In practice we are not usually going to be interested in the costs of invalid vehicles.)

The final output of the running example provided in exercise 1 should be:


```
vehicle_id: 1
color: silver
cost: 25900
engine: Goliath Inc., electric
manufacturer: Goliath Inc.
type: truck, pickup
wheels: ACME, all-weather, 6
valid: false

vehicle_id: 2
color: blue
cost: 17600
engine: ACME, diesel
manufacturer: ACME
type: car, convertible
wheels: ACME, all-weather, 4
valid: true
```