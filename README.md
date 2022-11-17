# GameOfLife
This private project of mine was created with **Test Driven Developement** (TDD) in mind, to showcase my knowledge about **Kotlin** and **Object oriented programming**.
That is also why I decided to use data class to represent cells in the 2d array instead of just ones and zeros.
Classic example for TDD is Conway's Game Of Life.


## About Game Of Life
If you are unfamiliar with Game Of Life, please refer to this link: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

## How does it work?
It is very simple. The program runs in the console displaying alive cells as hashes and dead ones as zeros. You are able to see every step of the game in the console.

## How to run it?
If you are interested in running it I recommend installing Intellij IDE and forking the project from VCS. File -> New -> project from version control.
JDK is Corretto 16 and I used Gradle for build.
After opening the project there is a file StartConditions.kt in which are starting conditions for the game with explanations how to use them. Default 2d array is with beacon oscillator, visible below.

![image](https://user-images.githubusercontent.com/78445032/202552251-daa4927b-1371-4b34-9fec-8cd97f3460c3.png)

I of course encourage to browse files on GitHub in case of lack of desire to run the software itself. :)

### Future
I plan to expand this project.
I want to create a interface to easily setup the starting conditions. 
I also want to create 2d array without boundaries (it would loop itself when reaching certain size.)
