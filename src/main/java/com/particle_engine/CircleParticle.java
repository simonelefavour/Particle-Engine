/*
 * Coder: Simone LeFavour
 * Date: Sept. 23, 2024
 * Description: Particle Engine Project II Coding III, update of Particle Engine I with different interactions. 
mouse pressed:
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

public class CircleParticle extends Particle  
{

// constructor for circle
public CircleParticle (PApplet p, float x, float y) 
    {
        super (p, x, y) ;
    } // end circle

public void update() 
    {
        super.update() ; // call to update

        // particle collision
        for (Particle p : particles) //static list of particles
            { 
                if (p != this && p instanceof CircleParticle) 
                    {
                        checkCollision (p) ;
                    } // end if 
            } // end for 
    } // end update 


public void display () 
    {
        main.fill (col) ;
        main.noStroke () ;
        main.ellipse (x, y, size, size) ; // draw circle 
    } // end display


public void handleKeyPress (char key) // c press doubles speed
    {
        if (key == 'c')
            {
                vy *= 2 ;
            } // end if 
    } // end key press

    public void handleMouseClick () // chance color 
    {
        col = main.color (main.random (255), main.random (255), main.random (255)) ;
    } // end mouse click
} // end circle class
