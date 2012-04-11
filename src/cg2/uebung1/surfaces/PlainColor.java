package cg2.uebung1.surfaces;

import cg2.vecmath.Color;

/**
 * A simple surface in a single color
 * 
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class PlainColor implements ISurface {
   //////////////////////////////// Attributes ////////////////////////////////
   private Color color;
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes a black Color
    */
   public PlainColor() {
      this.color = new Color( 0, 0, 0 );
   }

   public PlainColor( Color color ) {
      this.color = color;
   }
   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public boolean equals(final Object o) {
      boolean retVal = false;
      if (this.getClass().isInstance(o)) {
         PlainColor obj = (PlainColor) o;
         //TODO: Check if attributes have the same value
         throw new UnsupportedOperationException("Not supported yet.");
      }
      return retVal;
   }
   
   @Override
   public String toString() {
      return "[ cg2.uebung1.surfaces.PlainColor: \n"
              + "  - "
              + "]";
   }
}
