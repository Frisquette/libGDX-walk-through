# Draw Images #

You have seen the basic structure of a *libGDX* game, I can feel that you are now ready to add images to enhance your games! :smiley:

## Import an Image ##
Before using an image, we should add it to our assets folder.
In this repository, I decided to keep the *android/assets* folder, as I always did for my project. You could use anything you want, but remember to add the folder in the configuration.

For learning purposes, I decided to use this image for this section:
<p align="center">
    <img src="../../resources/images/github-logo.png" width=40% />
</p>

## Coordinates System ##
Before diving into the drawing, we should talk about the coordinate system, and especially the one in *libGDX*.
All you have to remember is that the *libGDX* coordinate system is defined by the bottom left corner.
In other words:
<p align="center">
    <img src="../../resources/images/coordinate-system.jpg" />
</p>
To sum up, the point of coordinates (0,0) is located at the bottom left corner, the (screenWidth, 0) is located at the bottom right corner, and the (0, screenHeight) is located at the top left corner.

## Display a Texture object ##
