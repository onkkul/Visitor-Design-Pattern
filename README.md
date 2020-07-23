# CSX42: Assignment 3
**Name: Onkar Kulkarni**</br>
**Email: okulkar4@binghamton.edu**</br>
**Please note that I am using NOT using any slack day.**</br>

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [visitorsystem/src](./visitorsystem/src/) folder.

## Instruction to clean:

```commandline
    ant -buildfile visitorsystem/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
    ant -buildfile visitorsystem/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
    ant -buildfile visitorsystem/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="commonintsout.txt" -Dmissingintsout="missingintsout.txt" -Ddebug="debug.txt"
```
Note: Arguments accept the absolute path of the files.


## Description:
- DataStructure Used ***ArrayList***

- Complexity of methods:
    add() – takes O(1) time
    add(index, element) – average runs in O(n) time
    all get() methods – constant time O(1) operation
    remove() – runs in linear O(n) time. We have to iterate the entire array to find the element qualifying for removal
    indexOf() – runs in linear O(n) time. We have to iterate the entire array to find the index of element
    contains() – implementation is based on indexOf(). So it will also run in O(n) time

## Source and References:
-    FileProcessor : by Pradyumna Kaushik from Assgn. 1


## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Onkar Kulkarni</br>
Date: 07/22/2020
