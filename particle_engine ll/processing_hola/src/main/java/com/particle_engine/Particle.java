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

public class Particle 
{
    PApplet main ; // refers to PApplet
    float x, y ; // position
    float vx, vy ; // velocity
    float size ; // particle size
    int col ; // particle color
    static ArrayList<Particle> particles ; // static list of particles

// constructor for particle
public Particle (PApplet p, float x, float y) 
    {
        this.main = p ;
        this.x = x ;
        this.y = y ;
        this.vx = p.random (-2, 2);
        this.vy = p.random (-2, 2);
        this.size = p.random (10, 60) ;
        this.col = p.color (p.random(255), p.random(255), p.random(255)) ;
    } // end particle 

public static void setParticlesList (ArrayList<Particle> particleList) 
    {
        particles = particleList;
    } // end setParticleList

public void update ()  // particle's position and behavior
    {
        x += vx ;
        y += vy ;

        // bounces off edge of screen
        if (x < 0 || x > main.width)
            {
            vx *= -1;
            } // end if 

        if (y < 0 || y > main.height) 
            {
                vy *= -1;
            } // end if 
    } // end update

public void display () 
    {
        main.fill (col) ;
        main.noStroke () ;
        main.ellipse  (x, y, size, size) ; // display a circle
    } // end display

public void handleKeyPress (char key)  // key press 
    {

    } // end handleKeyPress

    
public void handleMouseClick () // mouse click
    {
        
    } // end handleMouseClick

public void resetVelocity () // reset velocity
    {
        vx = main.random (-2, 2) ;
        vy = main.random (-2, 2) ;
    } // end resetVelocity

    
public void reverseDirection () // change direction
    {
        vx *= -1 ;
        vy *= -1 ;
    } // end reverseDirection

public void checkCollision (Particle other)
    {
        float dx = other.x - this.x ;
        float dy = other.y - this.y ;
        float distance = PApplet.dist(this.x, this.y, other.x, other.y) ;
        
        // if shapes overlap
        if (distance < (this.size / 2 + other.size / 2)) 
            {
                // vector
                float angle = PApplet.atan2(dy, dx) ;
            
                // magnitude 
                float overlap = (this.size / 2 + other.size / 2) - distance ;
            
                // so particles don't overlap
                this.x -= PApplet.cos(angle) * overlap / 2 ;
                this.y -= PApplet.sin(angle) * overlap / 2 ;
                other.x += PApplet.cos(angle) * overlap / 2 ;
                other.y += PApplet.sin(angle) * overlap / 2 ;
    
                // new speeds
                float tempVx = this.vx ;
                float tempVy = this.vy ;
                
                this.vx = other.vx ;
                this.vy = other.vy ;
                
                other.vx = tempVx ;
                other.vy = tempVy ;
                
                // keeping the shapes moving
                this.vx *= 1.1 ; 
                this.vy *= 1.1 ;
                other.vx *= 1.1 ;
                other.vy *= 1.1 ; 
            } // end if
    } // end checkCollision
} // end particle class