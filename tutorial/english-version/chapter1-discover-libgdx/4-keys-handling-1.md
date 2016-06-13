# Keys Handling (Part 1/2) #

In order to make your game more dynamic, you are going to learn how to poll given
keys.

## Polling Vs Events ##

There are two ways to handle inputs in *libGDX*:
* **Polling**: Consist in checking, at a given rate, the state of the key that
we are interested in. **For instance**, *Is the state of the Z-key pressed?*, if so,
move the player forward, else, do nothing.
* **Event**: This method is a bit different, as it is based on a listener system.
You will have a binded interface that is listening to some actors, and whenever
the actor changes, it will notify the listening interface and your code will be triggered. Here, you are not permanently checking for some changes, but rather called when a change happened.

## Handle Keys With Polling ##

In order to handle key state changes, we are going to use the *Gdx* **static** class.

**For instance**, to know if a key is **pressed**, you just have to use the `isKeyPressed` method, like this:

```java
if (Gdx.input.isKeyPressed(myKey)) {
    // Do some actions
}
```

###### Ok, and what do we have to give as an argument:grey_question: ######

You have to give to this **method** a keycode, which is a simple **integer**.
However, in order for you to write more meaningful code, you can (I would say you have to) use the *Keys* **static class**, containing each possible key.

So, for instance, if you want to move your player thanks to the **Z** key, you could write something like:

```java
if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
     // Moves the player
 }
```

#### Let's create a movable player ####

We will use the **chapter-3/mario.png** asset for this small example. You will have to make the player go **up**, **down**, **left**, and **right**, using a *Sprite* instance.
Try to make it by yourself, without looking directly at what I did.

...

...

...

##### Correction #####
This is how I did it:

```java
public void update() {
    if (Gdx.input.isKeyPressed(Input.Keys.D))
        logoSprite_.translateX(1.5f);
    if (Gdx.input.isKeyPressed(Input.Keys.A))
        logoSprite_.translateX(-1.5f);
    if (Gdx.input.isKeyPressed(Input.Keys.W))
        logoSprite_.translateY(1.5f);
    if (Gdx.input.isKeyPressed(Input.Keys.S))
        logoSprite_.translateY(-1.5f);
}
```

For those who did not understand the principle, I am, here, checking which key is **pressed** between the basic keys used to move in video games. When a key is **pressed**, the `isKeyPressed()`method will return **true** and the code inside the body of the **if** is going to be executed. For the **left** and **right**, I am translating the *Sprite* along the **x-axis**, for the up and down, along the **y-axis**.

However, there is a little error in this code.
Here, the animation is time **dependent**.

###### What does it mean:grey_question: ######

If you remember the **Framework Drawing** I showed you, you will remember that the `update()` is called each **frame**, and the number of **frames** executed by second is dependent of the computer capacities.
However, here, we are always moving **Mario** by **1.5**, regardless of the the framerate. On a very good computer, your `update()` method is going to be called more times, and you **Mario** will move faster than on a slowest machine.

In order to fix that, we are going to use the `getDeltaTime()` method given by *libGDX*, which simply represents the elapsed time between the **current** and the **last frame**.

Change the `update()` method like this :

```java
public void update() {
    if (Gdx.input.isKeyPressed(Input.Keys.D))
        logoSprite_.translateX(100f * Gdx.graphics.getDeltaTime());
    if (Gdx.input.isKeyPressed(Input.Keys.A))
        logoSprite_.translateX(-100f * Gdx.graphics.getDeltaTime());
    if (Gdx.input.isKeyPressed(Input.Keys.W))
        logoSprite_.translateY(100f * Gdx.graphics.getDeltaTime());
    if (Gdx.input.isKeyPressed(Input.Keys.S))
        logoSprite_.translateY(-100f * Gdx.graphics.getDeltaTime());
}
```

Now, the player moves relative to the machine framerate, which allows us to make the player moves at the same speed on every target devices.

## Handle The Mouse ##

To deal with the mouse, you have king of the same **methods**:

* `isButtonPressed()`

This allows you to check if one of the mouse button is pressed.
For instance, you could check the **left** and **right** click like this:

```java
if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
          // ...
else if ((Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
          // ...
```

So, what you basically should know to handle the mouse is:

* `Gdx.input.isButtonPressed()`
* `Gdx.input.getX()` and `Gdx.input.getY()` to get mouse **x** and **y** position.

```
Be very careful with the getX() and getY() methods.
Do not forget that libGDX is based on a top left corner coordinate system. You will have to take it into account when using the mouse position.
```

Now that you now how to get back information from the mouse, try to do this little exercise:

* Move the **Mario** at the mouse position. Be careful, the mouse should always be centered on the sprite.

* Add the **left button** moving the bottom left corner of **Mario** at the bottom left corner of the screen, and moving the top right corner of **Mario** at the top right corner of the screen.

Write the `moveToMouse()` **method** doing this, and do not forget to call it inside your `update()` method if you want to see any changes.

...

...

...

##### Correction #####

```java
public void moveToMouse() {
    logoSprite_.setPosition(Gdx.input.getX() - logoSprite_.getOriginX(),
            Gdx.graphics.getHeight() - Gdx.input.getY() - logoSprite_.getOriginY());

    if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
        logoSprite_.setPosition(0f, 0f);
    }
    else if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
        float xPos = Gdx.graphics.getWidth() - logoSprite_.getWidth();
        float yPos = Gdx.graphics.getHeight() - logoSprite_.getHeight();
        logoSprite_.setPosition(xPos, yPos);
    }
}
```

In order to understand how it works here, you have to really understand how the mouse position is obtained, and to remember that mouse position is relative to the **origin point**, located at the top left corner of the screen.
So, basically, you have to subtract the origin for the **x-axis** but, for the **y-axis** you have to reverse the coordinates system by subtracting the current **y position** and the **origin** to the total **height** of the screen.

This small chapter is now over, let's continue to the next chapter, introducing the **polling** on smartphones.
