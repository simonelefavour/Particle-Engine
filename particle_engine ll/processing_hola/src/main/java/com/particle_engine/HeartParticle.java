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

public class HeartParticle extends Particle 
{
    private float angle ; // angle for spinning 
    private boolean spinning = false ; // state for spinning

 // constructor for heart
public HeartParticle (PApplet p, float x, float y) 
    {
        super (p, x, y) ;
        angle = 0 ; // starting angle 
    } // end heart 

public void display () 
    {
        main.fill (col) ;
        main.noStroke () ;

        if (spinning) 
            {
                angle += 0.05   ; // angle for spinning
            }

        main.pushMatrix () ; // current transformation matrix 
        main.translate (x, y) ; // move particle position 
        main.rotate (angle) ; // heart rotating 
        drawHeart (0, 0, size / 2) ; // draw heart 
        main.popMatrix () ; // restore transformation matrix
    } // end display
 

public void handleKeyPress (char key) 
    {
        if (key == 'h') // change color to red 
            {
                col = main.color (255, 0, 0) ;
            } // end if 
    } // end key press

public void handleMouseClick () // spinning on mouse click 
    {
       
        spinning = true ;
        reverseDirection () ; // should reverse 
    } // end mouse click 


private void drawHeart (float x, float y, float size) 
    {
        main.beginShape () ;
        main.vertex (x, y) ;
        main.bezierVertex (x - size, y - size, x - size, y + size, x, y + size); 
        main.bezierVertex (x + size, y + size, x + size, y - size, x, y) ; 
        main.endShape (PApplet.CLOSE) ;
    } // end draw 
} // end heart class
