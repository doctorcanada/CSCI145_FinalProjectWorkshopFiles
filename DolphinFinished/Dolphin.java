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
    private GreenfootSound squeak;
    
    private boolean directionIsRight;
    
    private int frameCount;
    private int imageIndex;
    
    // declare reference to a SpriteSheet object
    private SpriteSheet spritesheet;
    
    // constructor
    public Dolphin()
    {
        frameCount = 0;
        imageIndex = 0;
        
        directionIsRight = true;
        
        // instantiate the SpriteSheet object itself
        spritesheet = new SpriteSheet();
        
        // assign actual image objects to the reference variables
        // (which are elements of the images array)
        /*
        images[0] = new GreenfootImage("frame0.png");
        images[1] = new GreenfootImage("frame1.png");
        images[2] = new GreenfootImage("frame2.png");
        images[3] = new GreenfootImage("frame3.png");
        images[4] = new GreenfootImage("frame4.png");
        images[5] = new GreenfootImage("frame5.png");
        */
       
        // extract the first row of animation frames
        images[0] = new GreenfootImage( spritesheet.getSprite( new GreenfootImage("eccoSpriteSheet.png"),
                                        0, 0, 160, 70, 160, 70 ) );
        images[1] = new GreenfootImage( spritesheet.getSprite( new GreenfootImage("eccoSpriteSheet.png"),
                                        160, 0, 320, 70, 160, 70 ) );
        images[2] = new GreenfootImage( spritesheet.getSprite( new GreenfootImage("eccoSpriteSheet.png"),
                                        320, 0, 480, 70, 160, 70 ) );
                                        
        // extract the second row of animation frames
        images[3] = new GreenfootImage( spritesheet.getSprite( new GreenfootImage("eccoSpriteSheet.png"),
                                        0, 70, 160, 140, 160, 70 ) );
        images[4] = new GreenfootImage( spritesheet.getSprite( new GreenfootImage("eccoSpriteSheet.png"),
                                        160, 70, 320, 140, 160, 70 ) );
        images[5] = new GreenfootImage( spritesheet.getSprite( new GreenfootImage("eccoSpriteSheet.png"),
                                        320, 70, 480, 140, 160, 70 ) );                                
                                        
        // assign a new GreenfootSound object to the squeak variable
        squeak = new GreenfootSound("dolphinSqueak.mp3");
       
    } // end constructor for Dolphin
    
    /**
     * Act - do whatever the Dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frameCount++;
        //System.out.println("Frame count: " + frameCount );
        
        if ( frameCount == 5 )
        {
            updateImage();
            frameCount = 0;
        }
        
        if ( Greenfoot.isKeyDown("left") && directionIsRight )
        {
            directionIsRight = false; // <-- direction is now LEFT

            // play the squeak sound ONCE
            squeak.stop();
            squeak.play();
            
            // This is an example of an "enhanced for loop"
            // (Sometimes also called a "for-each" loop)
            for ( GreenfootImage image : images )
            {
                image.mirrorHorizontally();
            }
        }
        
        if ( Greenfoot.isKeyDown("right") && !directionIsRight )
        {
            directionIsRight = true; // <-- direction is now RIGHT
            
            // play the squeak sound ONCE
            squeak.stop();
            squeak.play();
            
            // This is an example of an "enhanced for loop"
            // (Sometimes also called a "for-each" loop)
            for ( GreenfootImage image : images )
            {
                image.mirrorHorizontally();
            }
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
