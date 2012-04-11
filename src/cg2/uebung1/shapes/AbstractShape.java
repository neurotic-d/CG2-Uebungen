package cg2.uebung1.shapes;

import cg2.uebung1.Hit;
import cg2.uebung1.Ray;
import cg2.uebung1.surfaces.ISurface;

/**
 * Abstract implementation of the IShape interface, defining a field for a single surface.
 * 
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public abstract class AbstractShape implements IShape {
   //////////////////////////////// Attributes ////////////////////////////////
   private ISurface surface;

   /////////////////////////////// Constructors ///////////////////////////////

   ///////////////////////////// internal Methods /////////////////////////////
   /////////////////////////////// public Methods /////////////////////////////
   public ISurface getSurface() {
      return surface;
   }   

   
   void setSurface(ISurface surface) {
      this.surface = surface;
   }
   ///////////////////////////// overridden Methods ///////////////////////////


}
