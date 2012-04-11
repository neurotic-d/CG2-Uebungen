package cg2.uebung1.shapes;

import cg2.uebung1.Hit;
import cg2.uebung1.Ray;
import cg2.uebung1.surfaces.ISurface;
import de.bht.fb6.cg1.math.IColumnVector;

/**
 * Implementation of a sphere shape.
 * 
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public class Sphere extends AbstractShape {
   //////////////////////////////// Attributes ////////////////////////////////
   /**
    * the center point of the sphere
    */
   private IColumnVector<Float> center;
   
   /**
    * the sphere's radius 
    */
   private float radius;
   
   /////////////////////////////// Constructors ///////////////////////////////
   /**
    * Default constructor, initializes attributes with values.
    */
   public Sphere( IColumnVector<Float> center, float radius, ISurface surface ) {
      super.setSurface( surface );
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
         Sphere obj = (Sphere) o;
         //TODO: Check if attributes have the same value
         throw new UnsupportedOperationException("Not supported yet.");
      }
      return retVal;
   }
   
   @Override
   public String toString() {
      String retVal = "[ cg2.uebung1.shapes.Sphere: center = (";
      for( int i=0; i < this.center.getRows(); i++ ) {
         retVal = retVal.concat( this.center.get( i, 0 ) + "|" );
      }
      retVal = retVal.substring(0, retVal.length()-2 );
      retVal = retVal.concat( "), radius = " + this.radius + "]" );
      return retVal;
   }
}
