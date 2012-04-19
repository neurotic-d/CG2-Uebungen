package raytracer;

import shapes.IShape;

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
    public Hit(final Ray ray, final IShape shape,final float factorForHitPoint){
        this.ray = ray;
        this.shape = shape;
        this.factorForHitPoint = factorForHitPoint;
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
}
