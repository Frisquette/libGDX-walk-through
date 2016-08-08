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

##### Terrain collisions #####

<p align="center">
    <img src="../../resources/images/pong-exp1.png" width=60% />
</p>

As you can see on the above drawing, terrain collisions are going to be simply handled by keeping the same *x* direction and getting the **opposite** value of the *y* coordinate.
We are going to store the direction as a 2D vector.
For those who don't know what is a vector, you should **Google** it in order to know some basic maths. If you are here, I think that there is a lot of chance you know what is a vector, but anyway, it is better for the others to understand it.

In pseudocode, we will obtain something like:
```
direction = (oldDirection.x, - oldDirection.y);
```

##### Racket collisions #####

If you do not know it, a vector has a direction and a magnitude. Basically, a normalized vector is described by a direction and a magnitude equals to 1.
We want to find the new **direction** after the ball collision with a racket:

* For the *x* component, we will look at the racket that collides. If it is the left one, the *x* component will simply have **1**, because the ball will move toward the right part.
If it is the right one, it will be **-1**, because the ball will move toward the left.
* For the *y* component, I decided to use something that has given good results for me.
We will give the *y* component a value between **-1** and **1**, according to the length between the *y* component of the ball and the center of the racket. If the ball is centered on the racket, it will have a **0** value and go straight forward. If it is close to the top extremity of the racket, it will go at arround **45° North**, otherwise, if it is close to the bottom extremity, it will go at arround **45° South**

Below a little drawing explaning all this strange description:

<p align="center">
    <img src="../../resources/images/pong-exp2.png" width=60% />
</p>
