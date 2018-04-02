# Viagogo Coding Challenge

### Requirements ###

* Code in any language you like but please provide clear instructions on how we
should build & run your code.
* The first requirement is your code meets the requirements.
* Secondary requirements are whether your code is idiomatic for the language being
coded in, easy to read, and clearly laid out.

### Scenario ###

* Your program should randomly generate seed data.
* Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10
to +10 (X axis).
* Your program should assume that each co-ordinate can hold a maximum of one
event.
* Each event has a unique numeric identifier (e.g. 1, 2, 3).
* Each event has zero or more tickets.
* Each ticket has a non-zero price, expressed in US Dollars.
* The distance between two points should be computed as the Manhattan distance.

### Instructions ###

* You are required to write a program which accepts a user location as a pair of coordinates,
and returns a list of the five closest events, along with the cheapest ticket
price for each event.
* Please detail any assumptions you have made.
* How might you change your program if you needed to support multiple events at the
same location?
* How would you change your program if you were working with a much larger world
size?

### Example Program Run ##

```
Please Input Coordinates:

>4,2

Closest Events to (4,2):

Event 003 - $30.29, Distance 3
Event 001 - $35.20, Distance 5
Event 006 - $01.40, Distance 12
```

### To Run ###

Navigate to the root of the directory in the terminal:

` > gradle build `

Once built, run

`> gradle run -q`

### Q&A ###

* How might you change your program if you needed to support multiple events at the same location?

Support for multiple events at one location could be handled in many ways. The first that comes to mind is sorting by date; 
If one of the closest locations has multiple events, we can sort these by the date in which they are held, as no two mutually exclusive events can occur at the same time and location. The user will then also be able to compare the date and time with other close events.


* How would you change your program if you were working with a much larger world size?

Working with a larger world size means working with a larger dataset, this means that efficiency starts to take on a huge role. If I was dealing with a larger world size, I would create a database, as storing all the data in a Java class isn’t very useful. I would make calls to this database every time I need to access the information.
