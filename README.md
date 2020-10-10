# Visitor Design Pattern - VisitorSystem

-----------------------------------------------------------------------
## Description:
- Implement visitor pattern to find missing values in an input
    - Create visitors to find missing values in an input
    - one visitor for each of the input type - string, int etc
    - visit the input to find out what is missing
    
- DataStructure Used ***ArrayList***

- Complexity of methods:
    add() – takes O(1) time
    add(index, element) – average runs in O(n) time
    all get() methods – constant time O(1) operation
    remove() – runs in linear O(n) time. We have to iterate the entire array to find the element qualifying for removal
    indexOf() – runs in linear O(n) time. We have to iterate the entire array to find the index of element
    contains() – implementation is based on indexOf(). So it will also run in O(n) time
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.
Note: build.xml is present in [visitorsystem/src](./visitorsystem/src/) folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
    ant -buildfile visitorsystem/src/build.xml clean
```
Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instructions to compile:

```commandline
    ant -buildfile visitorsystem/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instructions to run:

```commandline
    ant -buildfile visitorsystem/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="commonintsout.txt" -Dmissingintsout="missingintsout.txt" -Ddebug="debug.txt"
```
Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
