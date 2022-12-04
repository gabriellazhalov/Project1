# Project Part 4
## Aengus Andrew, Gabriella Zhalov

# Q.1
There is as separate input and output class for the client (ClackClient & the Listener respoectively) so that they can run on separate threads and the user can still enter new information while the file listening to the server can continue to process and then print data from other users. If this weren't the case while the user was typing their messages to send to the other users ClackClient wouldn't be able to read the server data and receive real time messages from the server.

# Q.2
You need a separate thread for each client for reasons similar to as explained above. The Server class can only handle one piece of data at a time to send in and out, so multiple users would all be delayed in sending and receiving messages. With multiple threads multiple users can send data to the server for processing before it is sent to the other users by broadcast. ClientSideServerListener exists solely to read in data from the server and tell the user what the server said, ServerSideClientIO takes in and processes data AND prepares to rebroadcast it to all other users. 

# Q.3
broadcast() and remove() are synchronized because one attempted to change data while that function was intermittent in its running it may affect the data. For instance the broadcast() method asks for data to be transmitted, if that data is changed mid-transmission it may alter the message meant to be conveyed. remove() is similar in that it uses the ArrayList.remove() method within it that relies on testing the equality of two objects, if one of these objects has their data changed it may not find the correct object in the list and they may not be removed.

# LISTUSERS
For our implementation of LISTUSERS we came up with something we think is rather clever. Added to the ServerSideClientIO class is a private string data member called UserName, this is the userName of the client that is connected to the server with that instance of ServerSideClientIO. Every time a new ClackClient object is initialized and connects to a server, before its main loop begins it sends a single transmission of a string with its userName included. On the ServerSideClientIO side it reads this from the client before it begins its main loop, and stores it in the class. Added to ClackServer was a method called listusers() that uses a for each loop to scan the serverSideClientIOList and append each userName to a string of all the userNames currently active on the Server delimited by newline characters.



## Gabi Server

## Aengus' Side
Input a command. \
Hi Gabi the server is running on your computer\
User: aengus\
File Contents: Hi Gabi the server is running on your computer\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: gabi\
File Contents: hello aengus can you send me the test file\
Type of Data: 2\
Date: 2022-12-03\
Sure\
User: aengus\
File Contents: Sure\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
SENDFILEtest.txt\
User: aengus\
File Contents: This is a test\
testing\
Type of Data: 3\
Date: 2022-12-03\
Input a command.\
User: gabi\
File Contents: thanks\
Type of Data: 2\
Date: 2022-12-03\
I wonder who else might be here\
User: aengus\
File Contents: I wonder who else might be here\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
LISTUser: gabi\
File Contents: ill check\
Type of Data: 2\
Date: 2022-12-03\
aengus\
gabi\

Looks like it's just us\
User: aengus\
File Contents: Looks like its just us\
Type of Data: 2\
Date: 2022-12-03\
tInput a command.\
talk to you later\
User: aengus\
File Contents: talk to you later\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
DONE

## Gabi's Side:
Input a command.\
User: aengus\
File Contents: Hi Gabi the server is running on your computer\
Type of Data: 2\
Date: 2022-12-03\
hello aengus can you send me the test file\
User: gabi\
File Contents: hello aengus can you send me the test file\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: aengus\
File Contents: Sure\
Type of Data: 2\
Date: 2022-12-03\
User: aengus\
File Contents: This is a test\
testing\
Type of Data: 3\
Date: 2022-12-03\
thanks\
User: gabi\
File Contents: thanks\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: aengus\
File Contents: I wonder who else might be here\
Type of Data: 2\
Date: 2022-12-03\
ill check\
User: gabi\
File Contents: ill check\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
LISTUSERS\
aengus\
gabi

Input a command.\
User: aengus\
File Contents: Looks like its just us\
Type of Data: 2\
Date: 2022-12-03\
User: aengus\
File Contents: talk to you later\
Type of Data: 2\
Date: 2022-12-03\
User: aengus\
File Contents:\
Type of Data: 1\
Date: 2022-12-03\
okay I am leaving too\
User: gabi\
File Contents: okay I am leaving too\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
DONE


## Aengus Server

## Aengus Side
Input a command./
Is anyone here/
User: aengus/
File Contents: Is anyone here\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: gabi\
File Contents: yes gabi is here\
Type of Data: 2\
Date: 2022-12-03\
hi Gabi\
User: aengus\
File Contents: hi Gabi\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: gabi\
File Contents: I will send you the test file you need\
Type of Data: 2\
Date: 2022-12-03\
User: gabi\
File Contents: This is a test\
testing\
Type of Data: 3\
Date: 2022-12-03\
Thank you\
User: aengus\
File Contents: Thank you\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
I needed that\
User: aengus\
File Contents: I needed that\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
Is anyone else connected\
User: aengus\
File Contents: Is anyone else connected\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
LISTUSERS\
aengus\
gabi\

Input a command.\
User: gabi\
File Contents: no\
Type of Data: 2\
Date: 2022-12-03\
Thanks for the file\
User: aengus\
File Contents: Thanks for the file\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
DONE

## Gabi's Side

Input a command.\
User: aengus\
File Contents: Is anyone here\
Type of Data: 2\
Date: 2022-12-03\
yes gabi is here\
User: gabi\
File Contents: yes gabi is here\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: aengus\
File Contents: hi Gabi\
Type of Data: 2\
Date: 2022-12-03\
I will send you the test file you need\
User: gabi\
File Contents: I will send you the test file you need\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
SENDFILEtest.txt\
User: gabi\
File Contents: This is a test\
testing\
Type of Data: 3\
Date: 2022-12-03\
Input a command.\
User: aengus\
File Contents: Thank you\
Type of Data: 2\
Date: 2022-12-03\
User: aengus\
File Contents: I needed that\
Type of Data: 2\
Date: 2022-12-03\
User: aengus\
File Contents: Is anyone else connected\
Type of Data: 2\
Date: 2022-12-03\
gabi\
aengus

no\
User: gabi\
File Contents: no\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
User: aengus\
File Contents: Thanks for the file\
Type of Data: 2\
Date: 2022-12-03\
User: aengus\
File Contents:\
Type of Data: 1\
Date: 2022-12-03\
okay bye\
User: gabi\
File Contents: okay bye\
Type of Data: 2\
Date: 2022-12-03\
Input a command.\
DONE


