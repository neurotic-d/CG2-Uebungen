package raytracer;

import shapes.IShape;

/**
 * Stellt einen Schnittpuntk zwischen einem Strahl
 * und einer Form dar.
 * 
 * @author Bruno Kirschner
 */
public class Hit {
   
    private Ray ray;
    private IShape shape;
    
    // t für den Punkt wo der Strahl die Form traf
    private float factorForHitPoint;

    public Hit(final Ray ray, final IShape shape,final float factorForHitPoint){
        this.ray = ray;
        this.shape = shape;
        this.factorForHitPoint = factorForHitPoint;
    }
    
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
    public void setFactorForHitPoint(float factorForHitPoint) {
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
}
