# RobotFriendFactory

This program was written in an IDE that utilizes Java12
It will probably work with older versions,
but optimal performance is only guaranteed with Java12


from the command line

navigate to the directory containing the program files

from the directory

compile:

javac -d . Robot.java
javac -d . RobotFriend.java
javac -d . Bipedal.java
javac -d . Unipedal.java
javac -d . Quadrupedal.java
javac -d . Arachnid.java
javac -d . Radial.java
javac -d . Aeronautical.java
javac -d . RobotsAtPlay.java

run: 

java botOmat.RobotsAtPlay


This package contains 9 program files. 

Interface: Robot
InterfaceImp Class: RobotFriend
Child class: Quadrupedal
Child class: Bipedal
Child class: Arachnid
Child class: Aeronautical
Child class: Unipedal
Child class: Radial
Main class: RobotsAtPlay



Running RobotsAtPlay initiates and interactive robot game.
You will be greeted by the robot factory staff and asked to input the number of robots you intend to make. 
You can order anywhere between 1 and theoretical infinity. 
There's no real cap, but beware, the more robots you make the longer the program will take to complete. 

The program will then loop through asking for you to name each robot and specify its type. 
A robot can be named anything, but the types manufactured are limited!
 
After your robots have been created, one of two things will occur.
If you have made one robot, it will demonstrate how quickly it can do your chores for you. 
However, if you have made more then one, the robots will be pitted against one another in a game of 
random chance to win your affections! Who can complete their assigned chores the most quickly!

After the race is finished you will be asked if you would like to play again or if you would like to exit the program. 
You can exit, or you can play as many times as you like! there's no limit! 
