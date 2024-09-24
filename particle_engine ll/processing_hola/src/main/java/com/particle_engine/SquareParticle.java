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

public class SquareParticle extends Particle  
{
    private boolean isStar = false ; // not star 

// constructor 
public SquareParticle (PApplet p, float x, float y) 
    {
        super (p, x, y) ;
    } // end square 


public void display () 
    {
        main.fill (col) ;
        main.noStroke () ;
        
        if (isStar) // draw star 
            {
                drawStar (x, y, size / 2.5f, size, 5) ; // calls star drawing method
            } // end if 
        else // draw square 
            {
                main.rect (x, y, size, size) ;
            } // end else 
    } // end display


public void handleKeyPress (char key) // changes size 
    {
        if (key == 's') 
            {
                size *= 1.0 ;
            } // end if 
    } // end key press

public void handleMouseClick () 
    {
        // square or star 
        isStar = !isStar ;
        reverseDirection () ;
    }

// draws star 
private void drawStar (float x, float y, float radius1, float radius2, int npoints) 
    {
        float angle = PApplet.TWO_PI / npoints ;
        float halfAngle = angle / 2.0f ;
           main.beginShape () ;

        for (float a = 0; a < PApplet.TWO_PI; a += angle) 
            {
                float sx = x + PApplet.cos (a) * radius2 ;
                float sy = y + PApplet.sin (a) * radius2 ;
                main.vertex (sx, sy) ;
                sx = x + PApplet.cos (a + halfAngle) * radius1 ;
                sy = y + PApplet.sin (a + halfAngle) * radius1 ;
                main.vertex (sx, sy) ;
            } // end for 
            
            main.endShape (PApplet.CLOSE) ;
    } // end draw star 
} // end square class
