/*
 * Coder: Simone LeFavour
 * Date: Sept. 23, 2024
 * Description: Particle Engine Project II Coding III, update of Particle Engine I with different interactions. 
mouse Pressed:
    circle: changes color random
    square: changes from square to star
    heart: starts spinning
key pressed:
    circle: 'c' doubles the speed moving
    square: 's' increases size
    heart: 'h' changes color to red

    space bar: makes everything disappear and reappear
    r: resets speed of everything
 */

package com.particle_engine ;

import processing.core.PApplet ;
import java.util.ArrayList ;

public class Main extends PApplet 
{
    ArrayList<Particle> particles ; // array list for particles
    boolean particlesVisible = true ; // manage visibility of particles

public static void main (String[] args) 
    {
        PApplet.main("com.particle_engine.Main") ; // sets up 
    } // end main 

    // sets up 
public void settings ()
    {
        size (700, 700) ;
    } // end settings

// sets up
public void setup () 
    {
        particles = new ArrayList<> (); // particle array list

        // initializing diff types of particles
        for (int i = 0; i < 7; i++) 
            { 
                particles.add (new CircleParticle(this, random(width), random(height))) ;
                particles.add (new SquareParticle(this, random(width), random(height))) ;
                particles.add (new HeartParticle(this, random(width), random(height))) ;
            } // end for

        // set the static particles in the particle class
        Particle.setParticlesList (particles) ;
    } // end set up 

public void draw () 
    {
        background (0) ; // black background

        if (particlesVisible) 
            {
                // update and display particles
                for (Particle p : particles) 
                    {
                        p.update();
                        p.display();
                    } // end for 
            } // end if 
    } // end draw 

public void keyPressed () 
    {
        if (key == ' ') // space bar and visibility of shapes 
            { 
                particlesVisible = !particlesVisible ;
            } 

        else if (key == 'r') // resets particle velocity
            { 
                for (Particle p : particles) 
                    {
                        p.resetVelocity(); // reset particle velocity
                    } // end for
            } // end else if

        // key press behaviors in subclass
        for (Particle p : particles) 
            {
                p.handleKeyPress (key) ;
            }
    } // end keypressed 

public void mousePressed () 
    {
        // mouse click behaviors to subclasses
        for (Particle p : particles) 
        {
            p.handleMouseClick();
        } // end for 
    } // enhd mouse press
} // end main class