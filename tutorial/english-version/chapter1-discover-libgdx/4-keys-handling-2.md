# Keys Handling (Part 2/2) #

## Touch Screen ##

Whenever someone creates a smartphone game, he may wants it to detect touch inputs, that's actually better to play when there are no buttons (ok, it is possible to create an accelerometer-only game).

Just as for the **mouse**, you can use a simple check:

* `Gdx.input.isTouched()`

This function will return **true** if the screen is touched, and **false** otherwise.
Simple, isn't it?
Where are not seing anything new here, and that is exactly what is making you stronger. :fist:

We can even go further, using a useful overload:

* `Gdx.input.isTouched(index)`

It basically indicates
