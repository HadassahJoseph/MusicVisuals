# Music Visualiser Project

Student 1: 
Name: Aisha Adebimpe
Student Number: C21351293

Student 2: 
Name: Hadassah Joseph
Student Number: C21382216

Student 3 : 
Name: Cecilia Luan
Student Number: C21379843 

Student 4: 
Name: Molly McGuire
Student Number: C21486544

Student 5: 
Name: Grace Ojo
Student Number: C21486544

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
Our MyVisual class is our main class that it rendering our visuals.
There are several objects declared in teh beginning of our class. Thes objects represent different visual elements in our project.
An integer variable called mode is initialized to 1, which will determine the active part of the visual to be rendered.

keyPressed() Method:
```Java
public void keyPressed()
    {
        if(key >= '0' && key <= '7')
        {
            mode = key - '0';
        }
        if(keyCode == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }
```

This method is overridden from the Visual class and is called whenever a key is pressed.
If a numeric key between '0' and '7' is pressed, the mode variable is updated accordingly.
If the spacebar is pressed, it cues the audio player to the start (position 0) and plays the song.

draw() Method:
```Java
  @Override
    public void draw()
    {
        switch (mode) 
        {
	    case 1://first to play key 1 (opening screen)
           
                part_one();
                
                    break;
            case 2://When you press key 2 (molly)
             
                part_two();
                
                break;

            case 3:// when you press key 3 (cece)
        
               part_three();

                break;

            case 4://when you press key 4 (grace)

                part_four();

                break;

            case 5://when you press key 5 (hadassah)

                part_five();
                break;
            
            case 6://when you press key 6 (aisha)

                part_six();
                break;

            case 7://when you press key 7(ending screen)

                part_seven();
                break;
            default:
                break;

        }
        
    }
```
This method is overridden from the Visual class and is the main drawing loop for the sketch.
It uses a switch statement on the mode variable to determine which part of the visual to render.Depending on the value of mode, it calls the corresponding part_*() methods.

part_*() Methods:
```Java
void part_six()
    {
        try {
            calculateFFT();
        } 
        
        catch (VisualException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         calculateFrequencyBands();
         ss.render();
        colorMode(HSB);
    }
```
These methods are custom-defined and handle the rendering of different visual parts based on the current mode.
Each method first attempts to calculate the Fast Fourier Transform (FFT) using the calculateFFT() method. If an exception occurs, it is caught and printed.
The calculateFrequencyBands() method is called to calculate the frequency bands for visualization.
Finally, the corresponding visual element (h_idea2, mNote, s, db, hj, ss, end) is rendered using its respective render() method.
Overall, this code structure allows you to switch between different visual parts and render them based on the selected mode. Each part seems to have its own unique visualization logic implemented in the respective part_*() methods. Above is an example of one of these methods.


# What I am most proud of in the assignment
Aisha: I am proud that I was able to make a visual that responds well to the amplitude of the song. My visual is the last one to be shown as the musics fades out my 3d spheres get smaller and look like stars.I take pride in the collaborative effort between my teammate and me. Together, we crafted a cohesive and innovative vision for our project. The synergy and open communication we maintained throughout the process allowed us to overcome challenges, brainstorm ideas, and ultimately bring our collective vision to life.

Molly:

Cecilia: I am most proud that i was able to create particles falling from the top of the screen that was able to respond to the amplitude of the song , and that i was able to incorperate lerp into my code to make the stem of the flower and the center of the flower react smoothedly to the music.

Hadassah: I'm most proud of my half globe visual that fulfills our abstract theme. The visual captures the essence of the track, creating a mesmerizing and immersive experience for the viewer.I am proud of the abstract theme and the decision to incorporate the disco ball concept, as it aligns seamlessly with the overall vision of our work. By adhering to this theme, we were able to maintain a consistent aesthetic and effectively convey the mood and energy of the song through our visuals. I am especially proud of persevering through the obstacles we faced, such as rendering issues and difficulties with merging files on Git. Despite these setbacks, we remained determined and dedicated to producing a high-quality end result.

Grace:




