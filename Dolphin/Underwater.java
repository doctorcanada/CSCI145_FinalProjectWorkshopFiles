import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Underwater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Underwater extends World
{
    // instance variables
    private Dolphin dolphin;
    
    /**
     * Constructor for objects of class Underwater.
     * 
     */
    public Underwater()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Create the dolphin object and add it to the scenario
        dolphin = new Dolphin();
        addObject( dolphin, 300, 200 );
        
    }
}
