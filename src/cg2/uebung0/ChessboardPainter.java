package cg2.uebung0;

import cg2.vecmath.Color;
import cg2.warmup.ImageGenerator;
import cg2.warmup.Painter;

/**
 * Implementation of the Painter interface for a 8x8 field chessboard in black and white
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  29.03.2012
 */
public class ChessboardPainter implements Painter {
   //////////////////////////////// Attributes ////////////////////////////////
   private static final Color BLACK      = new Color( 0.0f, 0.0f, 0.0f );
   private static final Color WHITE      = new Color( 1.0f, 1.0f, 1.0f );
   private static final int   NUM_FIELDS = 8;
   

   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public ChessboardPainter() {
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   public static void main( String[] args ) {
      // get the user's home directory - should work on all operating systems
		String path = System.getProperty("user.home");
		
		{
		   String filename = path + "/Documents/Beuth/cg2uebung0/" + "chessboard.png";
         new ImageGenerator(new ChessboardPainter(), 750, 750, filename, "png");
         ImageGenerator.showImage(filename);
		} 
   }
   
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public Color pixelColorAt(int x, int y, int resolutionX, int resolutionY) {
      Color retColor = WHITE; // start with assuming a white field
      
      // divide height and width by 8, save the value and divide the specified point by it.
      float fieldWidth  = ( resolutionX * 1f ) / NUM_FIELDS;
      float fieldHeight = ( resolutionY * 1f ) / NUM_FIELDS;
      
      int fieldX = (int) Math.floor( x / fieldWidth );
      int fieldY = (int) Math.floor( y / fieldHeight );
      
      // start with the width, if it is an odd number, it's black, otherwise white
      if( fieldX % 2 == 1 ) {
         retColor = BLACK;
      } 
      
      // now add the height: if it is odd, switch the color
      if( fieldY % 2 == 1 ) {
         retColor = ( retColor == WHITE ? BLACK : WHITE );
      }
      
      return retColor;
   }
}
