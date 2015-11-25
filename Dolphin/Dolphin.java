import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dolphin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dolphin extends Actor
{
    // instance variables and fields
    private GreenfootImage[] images = new GreenfootImage[6];
    
    private int frameCount;
    private int imageIndex;
    
    // constructor
    public Dolphin()
    {
        frameCount = 0;
        imageIndex = 0;
        
        images[0] = new GreenfootImage("frame0.png");
        images[1] = new GreenfootImage("frame1.png");
        images[2] = new GreenfootImage("frame2.png");
        images[3] = new GreenfootImage("frame3.png");
        images[4] = new GreenfootImage("frame4.png");
        images[5] = new GreenfootImage("frame5.png");
        
    } // end constructor for Dolphin
    
    /**
     * Act - do whatever the Dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frameCount++;
        System.out.println("Frame count: " + frameCount );
        
        if ( frameCount == 5 )
        {
            updateImage();
            frameCount = 0;
        }
    } 
    
    /**
     * When this method is called, it updates the actor object's
     * image to whatever is the next frame in the images array
     * 
     * if the imageIndex exceeds the highest index in the array,
     * then the imageIndex is reset to zero.
     * 
     */
    public void updateImage()
    {
        // imageIndex is the array index that corresponds 
        // to the current image that we want to display
        setImage( images[imageIndex] );
        
        // We pre-increment imageIndex, and then we check
        // to see if the incremented value is greater than 
        // the highest available index in the array
        if ( ++imageIndex > (images.length-1) )
        {
            imageIndex = 0;
        } // end if
        
    } // end method updateImage
}
