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
    private GreenfootSound bgMusic;
    
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
        
        // Initialize the GreenfootSound object that will
        // be used for background music
        bgMusic = new GreenfootSound("ecco_music.mp3");
        
    }
    
    /**
     * This is the "game loop" for the scenario
     */
    public void act()
    {
        if ( Greenfoot.isKeyDown("space") )
        {
            if ( bgMusic.isPlaying() )
            {
                // Pause the music so that when it plays again,
                // it picks up where it left off
                bgMusic.pause();
            }
            else
            {
                // if the background music isn't already 
                // playing, then start playing it
                bgMusic.playLoop();
            } // end if/else
        } // end outer if
    } // end act method
    
    /**
     * This method specifies what happens when we click 
     * the "pause" button in the Greenfoot window
     */
    public void stopped()
    {
        System.out.println("Game is paused");
        if ( bgMusic.isPlaying() )
        {
            bgMusic.pause();
        }
    } // end method stopped
    
    /**
     * This method specifies what happens when we click
     * the "run" button in the Greenfoot window
     */
    public void started()
    {
        System.out.println("Game is now running");
        if ( !bgMusic.isPlaying() )
        {
            bgMusic.playLoop();
        }
    } // end method started
    
}
 