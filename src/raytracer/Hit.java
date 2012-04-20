package raytracer;

import shapes.IShape;
import vecmath.Vector;

/**
 * Stellt einen Treffer eines Strahl und einer Form dar.
 */
public class Hit {
   
    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Der Strahl der die Form getroffen hat.
     **/
    private Ray ray;
    
    /**
     * Die Form die getroffen wurde.
     */
    private IShape shape;
    
    /**
     * Der Faktor t des Strahls am Schnittpunkt.
     */
    private float factorForHitPoint;
    
    /**
     * Die Normale im Schnittpunkt.
     */
    private Vector hitpointNormal;
    
    /**
     * #################################
     *         Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt einen Treffer zwischen einem Strahl und einer Form.
     * 
     * @param ray   der Strahl
     * 
     * @param shape die Form
     * 
     * @param factorForHitPoint de Faktor t des Strahls am Treffer
     */
    public Hit(final Ray ray, final IShape shape,final float factorForHitPoint, final Vector normal){
        this.ray = ray;
        this.shape = shape;
        this.factorForHitPoint = factorForHitPoint;
        this.hitpointNormal = normal;
        
    }
    
    /**
     * #################################
     *         öffentliche Methoden
     * #################################
     */
    
    /**
     * Getter für den dargestellten Faktor t des Strahles für den Treffer.
     * 
     * @return der Treffer
     */
    public float getFactorForHitPoint() {
        return factorForHitPoint;
    }

    /**
     * Setter für den dargestellten Faktor t des Strahles für den Treffer.
     * 
     * @return der Treffer
     */
    public void setFactorForHitPoint(final float factorForHitPoint) {
        this.factorForHitPoint = factorForHitPoint;
    }

    /**
     * Getter für den Strahl des Treffer.
     * 
     * @return der Strahl 
     */
    public Ray getRay() {
        return ray;
    }

    /**
     * Setter für den Strahl des Treffer.
     * 
     * @return der Strahl 
     */
    public void setRay(Ray ray) {
        this.ray = ray;
    }

    /**
     * Getter für die getroffene Form.
     * 
     * @return die Form
     */
    public IShape getShape() {
        return shape;
    }

    /**
     * Setter für die getroffene Form.
     * 
     * @return die Form
     */
    public void setShape(IShape shape) {
        this.shape = shape;
    }

    /**
     * Die Normale an dem Punkt der getroffen wurde.
     *
     * @return Normalenvektor
     */
    public Vector getHitpointNormal() {
        return hitpointNormal;
    }

    /**
     * Setzt die Normale für den Treffer.
     * 
     * @param hitPointNormal die Normale
     */
    public void setHitpointNormal(Vector hitPointNormal) {
        this.hitpointNormal = hitPointNormal;
    }
}
