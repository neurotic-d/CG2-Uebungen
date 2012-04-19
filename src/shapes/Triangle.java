package shapes;

import material.Material;
import raytracer.Hit;
import raytracer.Ray;
import vecmath.Color;
import vecmath.Vector;

/**
 * Stellt eine Dreieck dar.
 */
public class Triangle extends AbstractShape {

    /**
     * #################################
     *             Attribute
     * #################################
     */
    
    /**
     * Erster Punkt des Dreieck
     */
    private Vector p1;
    
    /**
     * Zweiter Punkt des Dreieck
     */
    private Vector p2;
    
    /**
     * Dritter Punkt des Dreieck
     */
    private Vector p3;
	
    /**
     * #################################
     *          Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt ein schwarzes Dreieck aus drei Punkten.
     * 
     * @param p1    erster Punkt
     * 
     * @param p2    zweiter Punkt
     * 
     * @param p3    dritter Punkt
     */
    public Triangle(final Vector p1, final Vector p2, final Vector p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        
        super.setMaterial(new Material(new Color(0f, 0f, 0f)));
    }
    
    /**
     * #################################
     *      öffentliche Methoden
     * #################################
     */

    /**
     * Gibt den ersten Punkt wieder.
     * 
     * @return erster Punkt
     */
    public Vector getP1() {
        return p1;
    }

    /**
     * Setzt den ersten Punkt neu.
     * 
     * @param p1 neuer erster Punkt
     */
    public void setP1(final Vector p1) {
        this.p1 = p1;
    }

    /**
     * Gibt den zweiten Punkt wieder.
     * 
     * @return zweiter Punkt
     */
    public Vector getP2() {
        return p2;
    }

    /**
     * Setzt den zweiten Punkt neu.
     * 
     * @param p2 neuer zweiter Punkt.
     */
    public void setP2(final Vector p2) {
        this.p2 = p2;
    }

    /**
     * Gibt den dritten Punkt wieder.
     * 
     * @return dritter Punkt
     */
    public Vector getP3() {
        return p3;
    }

    /**
     * Setzt den dritten Punkt neu.
     * 
     * @param p3 neuer dritter Punkt
     */
    public void setP3(Vector p3) {
        this.p3 = p3;
    }
    
    /**
     * #################################
     *      überschriebene Methoden
     * #################################
     */
	
    @Override
    public Hit getNearestIntersectionWith(Ray ray) {
       /**
         * http://www.matheboard.de/archive/467676/thread.html
         * Post von riwe: 29.09.2011 12:35
         * 
         * g: X = P + delta*R
         * 
         * Dreieck ABC
         * 
         * B = Vektor(ab) C = Vektor(AC) N = B x C
         * 
         * A = Vektor(0A)
         * 
         * S = P - ( (P-A)*N / R*N )*R
         * 
         * S = alpha + beta * B + gamma * C
         * 
         * beta = ((S-A)*B*C^2 - (B*C) * ((S-A)*C)) / (B x C)^2
         * 
         * gamma = ((S-A)*C*B^2 - (B*C) * ((S-A)*B)) / (B x C)^2
         * 
         * S liegt im Dreieck wenn gilt:
         * 
         * 0 ≤ beta,gamma ≤ 1 und 0 ≤ beta+gamma ≤ 1
         * 
         */
        Plane trianglePlane = new Plane(this.p1, this.p2.sub(this.p1), this.p3.sub(this.p1));
        Hit trianglePlaneHit = trianglePlane.getNearestIntersectionWith(ray);
        Vector hitPoint = null;
        
        if(trianglePlaneHit != null){
            hitPoint = ray.getPointAt(trianglePlaneHit.getFactorForHitPoint());
             
            Vector a = this.p1;
            Vector b = this.p2.sub(this.p1);
            Vector c = this.p3.sub(this.p1);
            Vector n = b.cross(c);

            if(n.dot(ray.getNormalizedDirection()) != 0){
                Vector s = ray.getOrigin().sub( ray.getNormalizedDirection().mult((ray.getOrigin().sub(a)).dot(n) / (ray.getNormalizedDirection().dot(n))));

                double beta = (s.sub(a).dot(b) * c.dot(c) - (b.dot(c)) * ((s.sub(a)).dot(c))) / (b.cross(c).dot(b.cross(c)));
                double gamma = (s.sub(a).dot(c) * b.dot(b) - (b.dot(c)) * ((s.sub(a)).dot(b))) / (b.cross(c).dot(b.cross(c)));

                if(beta >= 0 && gamma >= 0 && beta+gamma <= 1){
                    trianglePlaneHit = new Hit(ray,this,trianglePlaneHit.getFactorForHitPoint());
                } else {
                    trianglePlaneHit = null;
                }
            } else {
                trianglePlaneHit = null;
            }
             
        }
               
        return trianglePlaneHit;
	}

}
