package shapes;

import material.Material;
import raytracer.Ray;
import raytracer.Hit;
import vecmath.Color;
import vecmath.Vector;

/**
 * Definiert eine Ebene im Raum.
 * 
 * @author Bruno Kirschner
 */
public class Plane extends AbstractShape{

    private Vector pointOnPlane;
    private Vector normalVector;
    
    /**
     * Initialisiert eine Ebene mit Hilfe eines Punktes und einem normalen-Vektor.
     * 
     * @param pointOnPlane der Punkt auf der Ebene
     * @param normalVector der normalen-Vektor
     */
    public Plane(final Vector pointOnPlane, final Vector normalVector){
        this.pointOnPlane = pointOnPlane;
        this.normalVector = normalVector.normalize();
        
        super.setMaterial(new Material(new Color(0f,0f,0f)));
    }
    
    /**
     * Initialisiert eine Ebene mit Hilfe  eines Punktes und den beiden Richtungen in
     * dennen sie sich ausbreitet.
     * 
     * @param pointOnPlane  der Punkt auf der Ebene
     * @param direction1    die erte Richtung
     * @param direction2    die zweite Richtung
     */
    public Plane(final Vector pointOnPlane, final Vector direction1, final Vector direction2){
        this.pointOnPlane = pointOnPlane;
        this.normalVector = direction1.cross(direction2);
        
        super.setMaterial(new Material(new Color(0f, 0f, 0f)));
    }

    /**
     * Getter für den normalen-Vektor.
     * 
     * @return der normalen-Vektor
     */
    public Vector getNormalVector() {
        return normalVector.normalize();
    }

    /**
     * Setter für den normalen-Vektor.
     * 
     * @param normalVector die neue Normale der Ebene
     */
    public void setNormalVector(Vector normalVector) {
        this.normalVector = normalVector;
    }

    /**
     * Getter für den Punkt auf der Ebene.
     * 
     * @return der Punkt auf der Ebene
     */
    public Vector getPointOnPlane() {
        return pointOnPlane;
    }

    /**
     * Setter für den Punkt auf der Ebene.
     * 
     * @param pointOnPlane der neue Punkt auf der Ebene
     */
    public void setPointOnPlane(Vector pointOnPlane) {
        this.pointOnPlane = pointOnPlane;
    }
    
    
    @Override
    public Hit getNearestIntersectionWith(Ray ray) {        
        /**
         * Strahl: x(t) = x0 + t*v
         * 
         * Ebene: (x-x0)*n = 0
         * x*n-n*x0 = 0
         * d = n * x0
         * 
         * Hessesche Normalform : n*x - d = 0
         * 
         * x(t) und x gleichsetzen: (x0+t*v)*n - d = 0
         * 
         * x0*n + t*v*n - d = 0
         * t*n*v = -x0*n + d
         * 
         * nach t: t = d - x0*n / n*v
         */
        
        Hit hit = null;
        
        if(this.normalVector.dot(ray.getDirection().normalize()) != 0){
            float d = this.normalVector.dot(this.pointOnPlane);
            
            float hitFactor = (d - ray.getOrigin().dot(this.normalVector)) / this.normalVector.dot(ray.getDirection().normalize());
            hit = new Hit(ray,this,hitFactor);
        }
        
        return hit;
    }
}
