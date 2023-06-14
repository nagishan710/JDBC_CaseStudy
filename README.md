# JDBC_CaseStudy
Write a program that handles or stores the following details in an object of the class Member: -
1) MemberID (integer)
2) MemberName(String)
3) MemberType (String)
4) MembershipFees (float)
Membership type can be Gold, Silver, Platinum, Diamond
Generate the appropriate getter and setter methods for this class.
Generate a constructor also that takes memberid, name, type and fees as the parameter and stores those values in the appropriate fields.
Generate a default constructor also.
Create a table called Member in mysql or oracle database with the following structure :-
memberid int primary key
membername and membertype must be varchar type and must not support nulls.
Membership fees must be float and not null.
The program must perform the following operations: -
a) accept the above data from the user and insert the same into the member table
b) Update the membership type in the table by using memberid as the criteria. User enters memberid and membership type.
c) update the membershipfees also in the table by using memberid as the criteria. User enters memberid and membership fees.
d) Delete the membership details using memberid as the criteria. User enters membershpid from console.
e) Retrieve all the records from the Member table and display it on the screen.
Write separate functions for each of the above operations in the Member class itself.
The program must be menu driven and it should display the following options :-
a) Insert a new member into the table
b) Update membership type
c) Update membership fees
d) Delete memberhsip details
e) Display details of all members
f) Exit
Upon selection of an option, it should call appropriate functions.
