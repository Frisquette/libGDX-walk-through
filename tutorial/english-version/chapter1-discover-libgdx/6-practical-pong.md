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

We want to find the new **direction** after the ball collision with a racket:

* For the *x* component, we will look at the racket that collides. If it is the left one, the *x* component will simply have **1**, because the ball will move toward the right part.
If it is the right one, it will be **-1**, because the ball will move toward the left.
* For the *y* component, I decided to use something that has given good results for me.
We will give the *y* component a value between **-1** and **1**, according to the length between the *y* component of the ball and the center of the racket. If the ball is centered on the racket, it will have a **0** value and go straight forward. If it is close to the top extremity of the racket, it will go at arround **45° North**, otherwise, if it is close to the bottom extremity, it will go at arround **45° South**

Below a little drawing explaning all this strange description:

<p align="center">
    <img src="../../resources/images/pong-exp2.png" width=45% />
</p>

As you can see, the closer the ball is to the middle of the racket, the straighter it is going to move. However, when it collides with the top of the racket, the direction will be close to **(1, 1)**, meaning the vector is going to be oriented North-East.
For the bottom part of the racket, we will keep the same formula, and just take the **opposite** of the *y* component, in order to point toward the South.

All the *"formulas"* I am introducing here are not special formulas for this game, if you look on the internet, you may find very different explanations. I just thought it was simple to implement, and it could make the game fun to be played.
If you have better idea to improve the **physics**, do not hesitate to implement them.

## Let's Code ##

#### Basic screen setup ####

The **PongScreen** class will be used as a **Screen**/**State**, containing our game logic. It will be the major part of the program, linking everything together.
I chose to follow a basic template, our **Screen** will have two major methods: `update()` and `render()`

###### PongScreen.java #######
```java
public class PongScreen {

    public PongScreen() { }

    public void update() { }

    public void render(SpriteBatch batch) { }
```

For now, it should basically looks like that.
I chose to do it like that in order to really split the **Pong** code from the exercises from previous/next chapters. You can directly use the **Main** class if you prefer.
Anyway, if you use this class, do not forget to call it in the **Main** class, which is the entry point of our game.

###### Main.java #######
```java
public class Main extends ApplicationAdapter {
	private SpriteBatch batch_;
	private PongScreen  pongScreen_;

	@Override
	public void create () {
		batch_ = new SpriteBatch();
		pongScreen_ = new PongScreen();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Updates the scene
		pongScreen_.update();
		// Draws the scene
		batch_.begin();
		pongScreen_.render(batch_);
		batch_.end();
	}
}
```

Ok, now that our base is setup, we can begin to create our models, the ball and the racket.

#### The different entities ####
