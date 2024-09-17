/*
 * Coder: Simone LeFavour
 * Date: Sept. 16, 2024
 * Description: Particle Engine Project for Coding III, using array lists, 500+ shapes bouncing within the screen with mouse and keyboard interactions.
 */

package com.particle_engine ;

import processing.core.PApplet ;
import java.util.ArrayList ;

public class Main extends PApplet 
{
  ArrayList <Particle> particles ; // array list for particles
  int particleCount = 500 ; // 500 particles
  boolean stopParticles = false ; // stopping particles with a spacebar
  boolean colorChanged = false ;  // track color change

public static void main (String[] args) 
  {
    PApplet.main ("com.particle_engine.Main") ; // tells it to run the class
  } // end void main

// sets up the screen
public void settings () 
  {
    size (800, 800) ;
  } // ent void settings

public void setup ()   
  {
    particles = new ArrayList <Particle> ();

    // initializing the particles
    for (int i = 0; i < particleCount; i++) 
      {
        particles.add (new Particle(this, random(width), random(height))) ;
      }
  } // end void set up

public void draw () 
  {
    background (0) ; // black background

    // update and display particles
    for (Particle p : particles) 
      {
        p.update ();
        p.display ();
      } // end for 
  } // end void draw

public void keyPressed () 
  {
    if (key == ' ') // space bar stops 
      { 
        stopParticles = !stopParticles ;
      } // end if
        else if (key == 'r') // resets the particles speed
          { 
            for (Particle p : particles) 
              {
                p.resetVelocity ();
              } // end for 
          } // end else if 
  } // end void keypressed
} // end main

