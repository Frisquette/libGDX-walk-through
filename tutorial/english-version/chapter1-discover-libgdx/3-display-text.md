# Display Some Text #

In this section, you will learn how to display simple text with *libGDX*.

## Bitmap fonts ##

*libGDX* can handle only one type of font: **Bitmap Font**.
For those who do not know what it actually is, **Bitmap Font** is a format containing characters in a png file.
As opposed, you can come across the **Outline Font** or **Vector Font**. These fonts are not composed by a pixel array (an image), but simply by using bezier curves and instructions to describe the shape of the glyph. The advantage compared to the **Bitmap Font** is the size, you can scale **Vector Font** as much as you like, as it is not rasterized, you will never see the pixels or an **aliasing effect**. However, it needs more computing to be render and so, they appear to be less efficient than the first type.

### Create you own Bitmap Fonts ###

The *libGDX* tool allowing us to create our own **Bitmap Font** is called *Hiero* and is located in the **tools/** folder.
You can also download it from the official [*libGDX* website.](https://libgdx.badlogicgames.com/tools.html)

First, let's launch the *hiero.jar* file, you can either do it by double clicking on it (only if you are on *Windows*), or by using the **java** command with the **jar** option:

`java -jar hiero.jar`

You should obtain something like that:

<p align="center">
    <img src="../../resources/images/hiero.jpg" width=60% />
</p>

1. This window allows you to select the font you want to use.
2. You should write here all the characters that you need. If you forget some of them, you will not be able to display them in your game.
3. Add small effect, such as shadows, text coloring...

#### Let's try to create the most beautiful font ####

* First, choose the **Times New Roman**

<p align="center">
    <img src="../../resources/images/hiero_font.jpg" width=25% />
</p>

* After that, just below, choose the size of the police you want. For this tutorial, I will enter **26**.

<p align="center">
    <img src="../../resources/images/hiero_font_size.jpg" width=10% />
</p>

* Normally, some characters already appeared by themselves in the **Sample Text** window. Let every character you want and delete the other (you can keep everything).
* You can click below, on **ASCII** or **NEHE**. **NEHE** makes some **Unicode** characters show.

<p align="center">
    <img src="../../resources/images/hiero_font_chars.jpg" width=35% />
</p>

* Finally, click on **File->Save BMFont file (text)** and choose where you want to save it (it is a good idea to save it in our *assets/* folder).

## Draw Text with libGDX ##

Let's begin by creating the object holding the text data: the **BitmapFont** object.

As usual, go to the create method to instanciate it:

```java
    font = new BitmapFont(Gdx.files.internal("font.fnt"));
```

Now that we have our **BitmapFont** instanciated, go to the `render()` method to draw it:

```java
public void render(SpriteBatch batch) {
    font.draw(batch, "Hello World!",
                Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight / 2);
}
```

The `draw()` method belonging to the *BitmapFont* class acts like the *Sprite* one.
1. The **first** argument specifies the batch to use.
2. The **second** argument the string to display
3. The **third** and **fourth** arguments the **x** and **y** position on the screen. Here, we gave the center of the screen as a position to draw it.

And this is the result:

/* image *


###### Obviously, you forgot to take the text width and height into account, no:grey_question: ######

You're right!
Let's create two variables, holding the **width** and the **height** of the text.

In order to do this, we are going to use the *GlyphLayout* **class**, allowing us to get the bounds of a given string, according to the font properties. Go in the `create()` method and add the following lines:

```java
public void create () {
    ...
    glyphLayout_ = new GlyphLayout(); // Instanciantes a new GlyphLayout
    glyphLayout_.setText(font_, "Hello World!"); // Set the current text
}
```

As you can see, I used the `setText()` method from the *GlyphLayout* class.
This is used to set the current of which we want to determine the **width**
and **height**.

Now, you can go to the `render()` method, and, as usual, subtract **half of the
width** and **half of the height**:

```java
public void render(SpriteBatch batch)
{
    font_.draw(batch, "Hello World!", Gdx.graphics.getWidth() / 2 - glyphLayout_.width / 2,
                        Gdx.graphics.getHeight() / 2 - glyphLayout_.height / 2);
}
```

Now, you should obtain what we fought for!
/ image /

###### Here a recap' of what we learned: ######

* We can draw in *libGDX* using a *BitmapFont*
* We can create our own *BitmapFont* using the small **Hiero** utilitary.
* In order to obtain the text **dimensions**, we have to use the *GlyphLayout*
class and call the `setText()` method to set the *String* of which we want to obtain the size.

<p>
    <a href="2-draw-images.md">
        <img align="left" src="../../resources/images/left-arrow.png">
    </a>
    <a href="4-keys-handling-1.md">
        <img align="right" src="../../resources/images/right-arrow.png">
    </a>
</p>
