package raytracer;

import java.util.ArrayList;
import vecmath.Vector;

/**
 * Stellt das mathematische Model eines Strahls dar.
 */
public class Ray {
    
    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Der Ursprung des Strahls
     */
    private Vector origin;
    
    /**
     * Die Richtung des Strahls
     */
    private Vector direction;
    
    /**
     * #################################
     *           Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt einen Strahl.
     * 
     * @param origin der Ursprung
     * 
     * @param direction die Richtung
     */
    public Ray(final Vector origin, final Vector direction){
        this.origin = origin;
        this.direction = direction;
    }

    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Gibt die Richtung des Strahls wieder.
     * 
     * @return die Richtung
     */
    public Vector getDirection() {
        return this.direction;
    }
    
    /**
     * Gibt die normalisierte Richtung des Strahls wieder.
     * 
     * @return die normalisierte Richtung
     */
    public Vector getNormalizedDirection() {
        return this.direction.normalize();
    }

    /**
     * Setzt für den Strahl eine neue Richtung.
     * 
     * @param direction die neue Richtung
     */
    public void setDirection(final Vector direction) {
        this.direction = direction;
    }

    /**
     * Gibt den Ursprung des Strahles wieder.
     * 
     * @return der Ursprung
     */
    public Vector getOrigin() {
        return this.origin;
    }

    /**
     * Setzt den Ursprung des Strahles neu.
     * 
     * @param origin der neue Ursprung
     */
    public void setOrigin(final Vector origin) {
        this.origin = origin;
    }
    
    /**
     * #################################
     *      Öffentliche Methoden
     * #################################
     */
    
    /**
     * Gibt einen Punkt auf dem Strahl anhand eines faktors t und der
     * normalisierten Richtung an.
     * 
     * @param directionFactor der Factor t
     * 
     * @return der Punkt auf dem Strahl
     */
    public Vector getPointAt(final float directionFactor){
        return (this.origin.add((this.direction.normalize()).mult(directionFactor)));
    }
}