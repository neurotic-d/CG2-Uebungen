package cg2.uebung1.shapes;

import cg2.uebung1.Hit;
import cg2.uebung1.Ray;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class AxisAlignedBox implements IShape {
   //////////////////////////////// Attributes ////////////////////////////////

   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public AxisAlignedBox() {
   }

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   ///////////////////////////// overridden Methods ///////////////////////////
   @Override
   public Hit intersect(Ray testRay) {
      throw new UnsupportedOperationException("Not supported yet.");
   }
   
   @Override
   public boolean equals(final Object o) {
      boolean retVal = false;
      if (this.getClass().isInstance(o)) {
         AxisAlignedBox obj = (AxisAlignedBox) o;
         //TODO: Check if attributes have the same value
         throw new UnsupportedOperationException("Not supported yet.");
      }
      return retVal;
   }
   
   @Override
   public String toString() {
      return "[ cg2.uebung1.shapes.AxisAlignedBox: \n"
              + "  - "
              + "]";
   }
}
