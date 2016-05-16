# First Step #

For those who are quite comfortable with programming, frameworks, etc... go on to the next part

## Framework Working ##
<p align="center">
    <img src="../../resources/images/framework-working.png" width=35% />
</p>

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

## libGDX Working Structure ##

###### Before begining to code, let's see how the *libGDX* project tree is organized.######

* **core**: This folder containing the whole code of your game. It will be used by the *libGDX* framework when deploying on the given device(s).
* **android**: folder containing the android related code, such as the AndroidManifest.xml, a file containing information about the app (permissions, ...).
You may have chosen the *android/assets* folder as you global assets folder. In this case, all you assets must be put int it.
* **desktop**: folder containing desktop related code, such as the window size, etc...
* **iOS**: code related to the iOS target.
* **html**: code related to the html target.

Open the *Main.java* file, located in the *core* folder.
You will discover two methods:
* `create()`: can be seen as the initialization state of the above drawing.
* `render()`: can be seen as the update + the drawing.

As the update and the rendering are merged into a single function, you be really careful with the calling order:
```java
@Override
public void render () {
    /* Update your game here */
    // Move the player
    // Handle shots

    /* Render the game here */
    // Draw background
    // Draw enemies
    // Draw player
}

```
This should give you an idea of how your code should be arranged.

There are some missing functions in the given code, useful or not depending on what you are doing:
```java
@Override
 public void dispose() {
     super.dispose();
 }

 @Override
 public void resize(int width, int height) {
     super.resize(width, height);
 }

 @Override
 public void pause() {
     super.pause();
 }

 @Override
 public void resume() {
     super.resume();
 }
```
* `dispose()`: Allows you to free some resources, such as images, sounds,...
* `resize()`: This method is called every time the window's size is modified. This event will only be triggered once on *Android* and *iOS*, when the game is launched, as the user does not have access to any window settings.
* `pause() / resume()`: Triggered only on *Android* and *iOS* when the application is moved to background/foreground.

```
Do not forget to dispose your assets. When building complex game, you should get
rid off the unneeded resources in order to free some memory space and avoid the garbage collector to be used wildly (at least on *Android*, as *iOS* does not use garbage collection).
```

Now that we know the basic code structure, let's dive a bit into the code :smiley:

## Given Code Analysis ##

``` java
public class Main extends ApplicationAdapter     
	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

    @Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
```

Let's try to understand the code piece by piece.

#### The Application ####
``` java
public class Main extends ApplicationAdapter {
...
}
```
Basically, what this piece of code do is just extending the Main class from the *ApplicationAdapter*, which is an implementation of the interface *Application*, handling low level events, such as window resizing, pausing, etc...

#### Variable Declaration / Initialization ####
```java
    SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}
```
Here, we store 2 attributes, the first one is of type *SpriteBatch* and the other one *Texture*, and we intitialize them inside the `create()` function.
The *SpriteBatch* class belongs to the *libGDX* frameowrk and is used to draw polygons and textures over the screen.
The *Texture* class also belongs to *libGDX*, and is used, as you suspected, to store a drawable texture. The constructor is pretty simple and take a **String** containing the path to the image.

#### Rendering: Screen Cleaning ####
```java
@Override
public void render () {
    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    batch.draw(img, 0, 0);
    batch.end();
}
```
With regard to the `render()` function, they are going to surprise you if you did not use any framework neither *OpenGL* for now.
```java
Gdx.gl.glClearColor(1, 0, 0, 1);
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
```
The first one is used to select the color to use when redrawing the screen, and the other one is used to apply this coloring on the current buffer given by the `GL20.GL_COLOR_BUFFER_BIT` parameter.

:exclamation: skip using these two lines will give you a screen full of everything you previously rendered.

:exclamation: the `glClearColor()` function takes values between 0 and 1, not between 0 and 255.

#### Rendering: Screen Drawing ####
```java
batch.begin();
batch.draw(img, 0, 0);
batch.end();
```
We previously instanciated a *SpriteBatch* object, it is now time to use it!
* `batch.begin()`: Sets up the drawing, by doing a lot of things, disabling depth buffer, enabling blending, etc... You do not really need this to use a framework, that's exactly why we use it :smiley:
* `batch.draw(img, 0, 0)`: This function basically draws the given texture at the given coordinates. There are many overloads, you can take a look at them in the [libGDX documentation](https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/SpriteBatch.html#begin--).

We have finally finished this section!

###### Here a recap' of what we discovered: ######

* A game is composed by an entry point, an initialization, a game loop and a final step.
* The *SpriteBatch* class is used to draw polygons/textures on the screen.
* It is necessary to redraw the screen before drawing on it using `glClearColor()` and `glClear()`

<p>
    <a href="../../../SUMMARY.md">
        <img align="left" src="../../resources/images/left-arrow.png">
    </a>
    <a href="2-draw-images.md">
        <img align="right" src="../../resources/images/right-arrow.png">
    </a>
</p>
