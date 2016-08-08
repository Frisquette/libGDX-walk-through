# Practical Work : (Ping) Pong! #

Welcome to this Practical session, through which you are going to create your first pong! (at least with *libGDX*).

Until now, we did not try to make the game run on **Android** (maybe you did it), because we did not really see how to handle several resolution.

Next chapter will be very detailled regarding multiresolutions, cameras, viewports, etc...

So, for this practical session, we are going to follow these "rules":

* The game will be designed for desktop for learning purposes. All the given images are made to run on a **x** resolution. You can try it on your **Android**/**iOS** device but with large black bands.
* Do not be afraid to modify it as you want, modifying/adding every single features you want.
* Even if the game can be create only using shapes (*libGDX* has a good API to draw procedural shapes),
we are going to use **Sprites**, in order for you to use them a bit. But obviously, pong is a game that can easily be created without sprites, using only rectangles.
Using images brings also other difficulties, as we can not resize them easily, unlike shapes that can easily be modified using a bit of maths.

## A Bit Of Design ##

There are plenty of architectures games can be based on, some are very good, some
are very bad. Depending on the game type (cards game, RPG), the game architecture
will be submitted to a lot of change.
Here, as it is our first practical work and as the game is pretty simple, we are not going to make a huge OOP modelisation.
I chose to split the game like this:
* A **Ball** class, used as a *Model*, containing the ball data and how it should be updated
* A **Racket** class, working as the **Ball** class.
* A **PongScreen** class, containing the game logic (rackets, ball, scores, ...)
* And just for simplicity, we will add a **Const** class in order to avoid hardcoding some useful values (move speed, etc...). It will allows us to easily change settings without going through each class.

## A Bit Of Maths ##
In our **Pong** game, we are going to use pretty basic maths. You can use something better for the physics, but I wanted to keep it simple. You could use a lot of things, like vector reflection, acceleration, etc... But this is not the point here.

#### The Ball ####

<p align="center">
    <img src="../../resources/images/pong-exp1.png" width=60% />
</p>
