/*
 * Coder: Simone LeFavour
 * Date: Sept. 16, 2024
 * Description: Particle Engine Project for Coding III, using array lists, 500+ shapes bouncing within the screen with mouse and keyboard interactions.
 */

 package com.particle_engine;

 import processing.core.PApplet;
 
 public class Particle 
 {
    PApplet main ; // refers to PApplet
     float x, y ; // position
     float vx, vy ; // velocity
     float size ; // star size
     int col ; // star color
 
// constructor for Particle
public Particle(PApplet p, float x, float y) 
    {
        this.main = p ;
        this.x = x ;
        this.y = y ;
        this.vx = p.random (-2, 2) ;
        this.vy = p.random (-2, 2) ;
        this.size = p.random (10, 30) ; 
        this.col = p.color (p.random(255), p.random(255), p.random(255)) ;
    } // end particle
 
// mouse pressed timer  
long mousePressStartTime = -1 ; // puts it at -1 to for no press

// particle's position and behavior
public void update () 
    {
        if (!((Main)main).stopParticles) 
            {
                x += vx ;
                y += vy ;
            } 

        // bounces off edge of screen
        if (x < 0 || x > main.width) 
            {
                vx *= -1 ;
            } // end if

        if (y < 0 || y > main.height) 
            {
                vy *= -1 ;
            }

        // mouse interactions
        if (main.mousePressed)
            {
                if (mousePressStartTime == -1) 
                    {
                        mousePressStartTime = main.millis(); // starts timing when mouse is pressed
                    }

        long heldDuration = main.millis () - mousePressStartTime ;

            // changes color when mouse is only held more than 3 sec
            if (heldDuration >= 3000) 
                {
                    col = main.color(main.random(255), main.random(255), main.random(255));
                } // end if

            // changes direction of star movement when star is clicked
            if (PApplet.dist(main.mouseX, main.mouseY, x, y) < size / 2) 
                {
                    vx = main.random (-5, 5) ;
                    vy = main.random (-5, 5) ;
                } // end if 

            // moves quicker
            if (Math.abs (main.mouseX - main.pmouseX) > 10 || Math.abs(main.mouseY - main.pmouseY) > 10) 
                {
                    vx *= 4 ;
                    vy *= 4 ;
                } // end if 
            } // end if main mouse pressed  

            else 
                {
                    mousePressStartTime = -1; // Reset the timer when the mouse is released
                } // end else
    } // end void update

// star particles 
public void display() 
    {
        main.fill (col) ;
        main.noStroke () ;
        main.pushMatrix () ;
        main.translate (x, y) ;
        drawStar(0, 0, size / 2.5f, size, 5) ; // draws a 5-pointed star
        main.popMatrix () ;
    } // end void display
 
// draws star
void drawStar (float x, float y, float radius1, float radius2, int npoints) 
    {
        float angle = PApplet.TWO_PI / npoints ;
        float halfAngle = angle / 2.0f ;
        main.beginShape () ;
            for (float a = 0; a < PApplet.TWO_PI; a += angle) 
                {
                    float sx = x + PApplet.cos(a) * radius2 ;
                    float sy = y + PApplet.sin(a) * radius2 ;
                    main.vertex (sx, sy) ;
                    sx = x + PApplet.cos (a + halfAngle) * radius1 ;
                    sy = y + PApplet.sin (a + halfAngle) * radius1 ;
                    main.vertex (sx, sy) ;
                } // end for
         main.endShape (PApplet.CLOSE) ;
    } // end void draw star
 
// resets particle velocity
public void resetVelocity() 
    {
        vx = main.random (-2, 2) ;
        vy = main.random (-2, 2) ;
    } // end void reset 
} // end particle class