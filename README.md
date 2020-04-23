# CPU Scheduler using Round Robin
Java Program to simulate the working of the round robin scheduling algorithm.

# Statement

In modern computer systems, it is common for users to have many programs running at one time. One of the most basic functions of an operating system is to schedule these processes. This process can actually become quite involved. For this project, we will assume a very simple round-robin scheduler. This simply means that each process gets to run for a set amount of time. If the process does not finish, it goes to the end of the line and the next process gets to run. This policy is very fair and very easy to implement.
One of the best ways to implement this policy is through the use of a circular linked list. Any new job is added to the "back" of the list (the spot directly proceeding the job currently being run). Whenever a job finishes, it is simply removed from the list. If a job does not finish in its allotted time, it is moved to the "back" of the list (this is done by simply moving the current reference ahead in the list by one node).

# Output

The program outputs in the form of a ghantt chart.

# Constraints

- Assign a random CPU Lifetime

- Initialize the scheduler with 3 processes 

- Assign random burst time and serving time  for each process in such a way that the process generation time gap keeps on increasing

- If the certain process requires more time than the remaining lifetime of CPU then don't process this and terminate the scheduler

# Requirements

- Must have java version 8 and above.

# Installation

- Download the class file and run the command `java main` in your terminal and follow the instructions on the screen.
- You can also download the java file and compile it by using the command `javac main.java` and then `java main` to run the application.
