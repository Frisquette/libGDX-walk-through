# Keys Handling (Part 2/2) #

## Touch Screen ##

#### Checks if the screen is touched ####
Whenever someone creates a smartphone game, he may wants it to detect touch inputs, that's actually better to play when there are no buttons (ok, it is possible to create an accelerometer-only game).

Just as for the **mouse**, you can use a simple check:

* `Gdx.input.isTouched()`

This function will return **true** if the screen is touched, and **false** otherwise.
Simple, isn't it?
Where are not seing anything new here, and that is exactly what is making you stronger. :fist:

We can even go further, using a useful overload:

* `Gdx.input.isTouched(index)`

It basically indicates wehther the selected finger is touching the screen or not.

Take a look at the following image:

<p align="center">
    <img src="../../resources/images/finger-index.jpg" width=50% />
</p>

The first finger to touch the screen was the left one, it has been attributed the smallest index, this is why it contains the **0** value.
The second one that has been put on the screen is the right one, this is why it has the **1** value (the following index).

```
Be careful here, indexes are attributed according to the fingers that are already touching the screen.
Whenever a finger is raised, its indexed is released. The indexing is made such that the following finger touching the screen is going to be assigned the smallest free index.
```

Look at this small example:
* I put my first finger on the screen. It has now **index 0**.
* I put a second finger (without raising up the first one). It has now **index 1**
* I raise up the first finger, **index 0** is free.
* I put another finger (let's say the third one), it is attributed **index 0**.

#### Checks if the screen is quickly touched ####

To check if the screen has been touch quicly (during a small amount of time), you can use the following method:

* `Gdx.input.justTouched()`

You can use it just like every other **method** I showed you above.

#### Touch position ####

In order to obtain the **x** and **y** value associated to the screen touch, you will use the following getters:

* `Gdx.input.getX()` and `Gdx.input.getY()`

Here, nothing is new for you, it is exactly the same as the **mouse** position.

But you can go even further, knowing the position of a special index:

* `Gdx.input.getX(index)` and `Gdx.input.getY(index)`

This overload allows you to focus only on a special finger index.

```
Be careful here, when using the getX() and getY() methods without the index parameter, it takes the 0 index for the position.
```

## Going Further With The Accelerometer ##

*libGDX* offers you a **wrapper** arround the device **Accelerometer**.
