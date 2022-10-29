# Project Part 1
## Aengus Andrew, Gabriella Zhalov


Currently, in the test classes when one provides a null value for a userName the program throws a runtime error when it attempts to run the hashCode() function. To fix this we would have to either put an exception handler into the code or make it impossible for the object to be created with a null username.
When you construct a ClackServer or ClackClient object with a negative port number currently the class cannot tell the difference and continues running like normal. This would need to be handled inside to code to ensure that a ClackClient or ClackServer object could not be constructed with a negative port value. Most likely in this case a simple if statement inside the constructor could ensure that it does not construct with a negative value.

Part 2


Input a command.

SENDFILEtest.txt

fileContents for readFileContents() method: This is a test

testing

User: zhalovgv

File Name: test.txt

File Contents: This is a test

testing

Type of Data: 3

Date: 2022-10-28

******************************

Testing for clients 1-4

zhalovgv

gabi

2000

Hash Value: -1429508146

User: zhalovgv

Host: gabi

Port: 2000

Data to Send: null

Data to Receive: null

zhalovgv

gabi

7000

Hash Value: -1050556157

User: zhalovgv

Host: gabi

Port: 7000

Data to Send: User: zhalovgv

File Name: test.txt

File Contents: This is a test

testing

Type of Data: 3

Date: 2022-10-28

Data to Receive: User: zhalovgv

File Name: test.txt

File Contents: This is a test

testing

Type of Data: 3

Date: 2022-10-28

zhalovgv

localhost

7000

Hash Value: 1657836187

User: zhalovgv

Host: localhost

Port: 7000

Data to Send: null

Data to Receive: null

Anon

localhost

7000

Hash Value: -1200875240

User: Anon

Host: localhost

Port: 7000

Data to Send: null

Data to Receive: null

true

true

false

false

Process finished with exit code 0
