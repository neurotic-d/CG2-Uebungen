package cg2.uebung1.shapes;

import cg2.uebung1.Hit;
import cg2.uebung1.Ray;
import cg2.uebung1.Scene;

/**
 *
 * @author Marius Hentschel - marius.hentschel@web.de
 * @since  06.04.2012
 */
public interface IShape {
   Hit intersect( Ray testRay );
}
