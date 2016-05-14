# First Step #

For those who are quite comfortable with programming, frameworks, etc... go on to the next part

## Framework Working ##
![](../../resources/images/framework-working.png)

Here, the idea is general, and the drawing may not be exhaustive on the number of steps.

###### A game is splitted into several steps: ######

1. The begin step: the entry point of the program.
2. The initialization: used to initialize our variables, to instanciate objects, etc...
3. The update: this step will deal with every computation to make, time-dependant modification (moves, shots, ...).
4. The rendering: called juste after the update, to redraw the screen with the new texture positions, ...
5. The end of the program, called when the user stops the game. It is generally used to dispose our assets.

###### The Game Loop ######
A video game differs from other programs through the **game loop state**.
A game is in constant modification, it is not simply waiting for the user to enter some inputs. I am sure you know what FPS mean, and I am not talking about **First Person Shooter**, but **Frame Per Second** :stuck_out_tongue:

One frame corresponds to the redrawing of the entire screen.
The human eye can interpret a lot of frames, actually it only depends on the training a person has.
A movie is approximately made of 24 frames/second.
Nowadays, video games are usually played at 60 fps.

All those explanations to say that, when a game is running at 60 fps, the update and the drawing functions are called 60 times a second.

###### The Rendering ######

As you know, if you have already coded before (I hope it because you will need some basic stuff to complete this tutorial!), a `while` loop can be long to execute, depending on what computation you are making in it. Here, it works the same, the more you do in your update/drawing, longer it will take to process the current frame, resulting in something famous: **the lag**.

## libGDX Working ##

You are now ready to code! We are going to dive (finally) in the development.
