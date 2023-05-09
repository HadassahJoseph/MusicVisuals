# Music Visualiser Project

Student 1: 
Name: Hadassah Joseph
Student Number: C21382216

Student 2 : 
Name: Cecilia Luan
Student Number: C21379843 

Student 3: 
Name: Molly McGuire
Student Number: C21486544

Student 4: 
Name: Grace Ojo
Student Number: C21486544

Student 5: 
Name: Aisha Adebimpe
Student Number: C21351293

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
We created an audio visual project we have created is an innovative & interactive multimedia  project created using java and the processing library


# Instructions
1. Press f5 to load the program. 
2. The song will start immediately on pressing f5.
3. To view the different visuals press number key 1-6.
4. To replay the song press the spacebar.

# How it works
Our MyVisual class is our main class that it running our files.
There are several objects declared in teh beginning of our class. Thes objects represent different visual elements in our project.
An integer variable called mode is initialized to 1, which will determine the active part of the visual to be rendered. 
keyPressed() Method:
This method is overridden from the Visual class and is called whenever a key is pressed.
If a numeric key between '0' and '7' is pressed, the mode variable is updated accordingly.
If the spacebar is pressed, it cues the audio player to the start (position 0) and plays the song.
draw() Method:
This method is overridden from the Visual class and is the main drawing loop for the sketch.
It uses a switch statement on the mode variable to determine which part of the visual to render.Depending on the value of mode, it calls the corresponding part_*() methods.

part_*() Methods:
These methods are custom-defined and handle the rendering of different visual parts based on the current mode.
Each method first attempts to calculate the Fast Fourier Transform (FFT) using the calculateFFT() method. If an exception occurs, it is caught and printed.
The calculateFrequencyBands() method is called to calculate the frequency bands for visualization.
Finally, the corresponding visual element (h_idea2, mNote, s, db, hj, ss, end) is rendered using its respective render() method.
Overall, this code structure allows you to switch between different visual parts and render them based on the selected mode. Each part seems to have its own unique visualization logic implemented in the respective part_*() methods.


# What I am most proud of in the assignment
Aisha: I am proud that I was able to make a visual that responds well to the amplitude of the song. My visual is the last one to be shown as the musics fades out my 3d spheres get smaller and look like stars.I take pride in the collaborative effort between my teammate and me. Together, we crafted a cohesive and innovative vision for our project. The synergy and open communication we maintained throughout the process allowed us to overcome challenges, brainstorm ideas, and ultimately bring our collective vision to life.

Molly:

Cecilia: 

Hadassah: I'm most proud of my half globe visual that fulfills our abstract theme. The visual captures the essence of the track, creating a mesmerizing and immersive experience for the viewer.I am proud of the abstract theme and the decision to incorporate the disco ball concept, as it aligns seamlessly with the overall vision of our work. By adhering to this theme, we were able to maintain a consistent aesthetic and effectively convey the mood and energy of the song through our visuals. I am especially proud of persevering through the obstacles we faced, such as rendering issues and difficulties with merging files on Git. Despite these setbacks, we remained determined and dedicated to producing a high-quality end result.

Grace:



# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

