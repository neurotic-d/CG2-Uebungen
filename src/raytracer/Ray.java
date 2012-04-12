package raytracer;

import vecmath.Vector;

/**
 * Simuliert einen Strahl.
 * @author Bruno Kirschner
 */
public class Ray {
    
    private Vector origin;
    private Vector direction;
    
    public Ray(final Vector origin, final Vector direction){
        this.origin = origin;
        this.direction = direction;
    }

    public Vector getDirection() {
        return this.direction;
    }
    
    public Vector getNormalizedDirection() {
        return this.direction.normalize();
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public Vector getOrigin() {
        return this.origin;
    }

    public void setOrigin(Vector origin) {
        this.origin = origin;
    }
    
    
    /**
     * Gibt einen Punkt auf diesem Strahl wieder.
     * 
     * @param directionFactor der Factor für die Richtung
     * 
     * @return 
     */
    public Vector getPointAt(final float directionFactor){
        return (this.origin.add((this.direction.normalize()).mult(directionFactor)));
    }
}