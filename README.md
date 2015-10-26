# problemSolving


This is the source file(s) for the program to validate Bael's Conjecture by brute force search

Author: Vinayak G Nair
This program was tested on a desktop PC and veryfied that Bael's Conjecture is true for all 64 bit calculations
In other words ,
the Conjecture is tested upto C^z for all positive integers upto 92,23,37,20,36,85,47,75,807. and found to be true. There was not a single counterexample in this range.
The java files has to be run one after another
Sequence is 
PuzzlePart1.java -- generates a collection of C^z upto 92,23,37,20,36,85,47,75,807
PuzzlePart2.java -- Checks the Conjecture using the collection generated above
PuzzlePart3.java -- Generates human readable format of all valid solutions

The files have to run separately as they consume large amount of memory.
Recommended: Allocate Java heap space of 1100 mb at runtime
