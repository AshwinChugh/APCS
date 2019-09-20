This application uses two classes. The reason for this because I had initially planned to use structs to organize the quiz however Java does not support structs. As a result, I 
kept the same design flow except I used a class instead. Becuase of this choice, you will see another class file however please ignore it. The main file is the TriviaQuiz.java file
and this is all that you have to compile and run.

I have added a few try-catch blocks scattered around the code. For example, if you were to enter in a word like "car" for a number in the math section, the program would not throw
and exception into the console but rather output and error message and exit. Furthermore, if you were to not select a valid category so for example you entered something like "space"
even though the program specifies "math" and "geography", the program would simply restart and ask you to choose the category again through a recursive call.

As per inputs, math has been rounded. Even though everything math is calculated in doubles, you can enter an integer like "5" and the program will properly grade it. 
As per geography, tt is not case-sensitive. For example, if the answer was "Indian Ocean", you could enter "INdiaN OcEaN" or any other variation but as long as the answer
is correct, the program will grade it as correct. 


To run, please open command in the right are and type "javac TestQuiz.java && java TestQuiz". Ignore the quotes and ignore the Geography.class file. That is needed but does not
contain the entry point of the application. 