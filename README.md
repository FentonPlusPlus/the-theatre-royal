# theTheatreRoyal

## This repository contains the code for the Theatre Royal booking system application. It was created with the purpose to solidify our understanding of Java and MySQL, and how to build an application from the ground up.
This project took us the course of 6 working days to build.
Created by Fenton & Hiten.

###Instructions to run project

To start the project first initialise the SQL database. There are two ways to do this:
1. Run the SCRIPTtheatrebooking SQL file in the main folder, or import one of the SQL databases in the SQL Files folder. There are two databases within this folder. One contains spoof data for testing and the other is without spoof data

For database files:
location: theTheatreRoyal\SQL Files
a. without spoof data = theatreRoyalvanilla.sql
b. spoof data = theatreRoyalwithData.sql

1. Open MySQL workbench, either create a new MYSQL connection or click on Local instance

2. There are two ways in which you can insert the chosen SQL(a or b) file into the database:
	- Right click on the sql file to open with a note editor and copy the enitre code and insert it into a blank query tab
	- Double click the sql file to open it in MySQL workbench (this may open in an unconnected session so copy the code and insert into a connection created from step 1
	
3. Run sql script with the execute button (yellow lightning bolt)
(database should now be initialised)

Java Project
4. Now open the java project in an IDE of your choice, file location: theTheatreRoyal\theTheatreRoyal

5. First change the credentials.txt file to match your MYSQL workbench URL, Username and password

6. Run the FrontEndController.java as a java application


There are some known bugs in the program:
- Some search results might return an error message. The reason is not clear why, as sometimes repeating the same search that previously displayed an error message will work. More testing and debugging is needed.
- Some Strings printed in the console might present 'odd' characters or symbols. We believe this to be a translation era when jumping on the program between MacOS and Windows.
- Shows in the database could still be listed if the performance has already finished or started. This is because there is no feature to make sure SQL only pulls performances from todays date and time onward. This is definitely not an ideal scenario for the program to operate on, but to implement this feature by the deadline would take more time than we currently have.

We hope you enjoy our program. 
