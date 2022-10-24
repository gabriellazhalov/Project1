# Project Part 1
## Aengus Andrew, Gabriella Zhalov


Currently, in the test classes when one provides a null value for a userName the program throws a runtime error when it attempts to run the hashCode() function. To fix this we would have to either put an exception handler into the code or make it impossible for the object to be created with a null username.
When you construct a ClackServer or ClackClient object with a negative port number currently the class cannot tell the difference and continues running like normal. This would need to be handled inside to code to ensure that a ClackClient or ClackServer object could not be constructed with a negative port value. Most likely in this case a simple if statement inside the constructor could ensure that it does not construct with a negative value.