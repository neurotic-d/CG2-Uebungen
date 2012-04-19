package shapes;

import material.Material;
import raytracer.Hit;
import raytracer.Ray;
import vecmath.Color;
import vecmath.Vector;

/**
 * Stellt eine Kugel dar.
 */
public class Sphere extends AbstractShape{

    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Der Mittelpunkt der Kugel.
     */
    private Vector middle;
    
    /**
     * Der Radius der Kugel.
     */
    private float radius;
    
    /**
     * #################################
     *          Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt eine schwarze Kugel aus dem Mittelpunkt und dem Radius.
     * 
     * @param middle Mittelpunkt der Kugel
     * 
     * @param radius Radius der Kugel
     */
    public Sphere(final Vector middle, final float radius){
        this.middle = middle;
        this.radius = radius;
        
        super.setMaterial(new Material(new Color(0f, 0f, 0f)));
    }
    
    /**
     * #################################
     *       öffentliche Methoden
     * #################################
     */

    /**
     * Getter für den Mittelpunkt der Kugel.
     * 
     * @return der Mittelpunkt der Kugel
     */
    public Vector getMiddle() {
        return middle;
    }

    /**
     * Setter für den Mittelpunkt der Kugel.
     * 
     * @param middle der neue Mittelpunkt der Kugel
     */
    public void setMiddle(final Vector middle) {
        this.middle = middle;
    }

    /**
     * Getter für den Radius der Kugel.
     * 
     * @return der Radius der Kugel
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Setter für den Radius der Kugel.
     * 
     * @param radius der neue Radius der Kugel
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }
    
    /**
     * #################################
     *        überschriebene Methoden
     * #################################
     */
    
    @Override
    public Hit getNearestIntersectionWith(final Ray ray) {
        
        double a,b,c;
        double diskriminante;
        /**
         * 
         * ray.origin = p
         * ray.direction = q
         * sphere.middle = m
         * sphere.radius = r
         * 
         * p + t*q = x
         * (x - m)^2 - r^2 = 0    
         * 
         * (x - x(m))^2 + (y - y(m))^2 + (z - z(m))^2 - r^2 = 0
         * 
         * x(q)^2*t^2   +   2*(x(p)*x(q)-x(m)*x(q))*t   +   x(m)^2  +   x(p)^2  -   2*x(m)*x(p)
         * y(q)^2*t^2   +   2*(y(p)*y(q)-y(m)*y(q))*t   +   y(m)^2  +   y(p)^2  -   2*y(m)*y(p)
         * z(q)^2*t^2   +   2*(z(p)*z(q)-z(m)*z(q))*t   +   z(m)^2  +   z(p)^2  -   2*z(m)*z(p)
         * - r^2
         *
         * =====================
         * at^2 + bt + c = 0
         * 
         * x1/2 = (-b +- sqrt(b^2-4*a*c)) / 2(a)
         * =====================
         * a == (x(q)^2 + y(q)^2 + z(q)^2)*t^2   
         * b == 2*(x(p)*x(q)-x(m)*x(q)+y(p)*y(q)-y(m)*y(q)+z(p)*z(q)-z(m)*z(q))*t   
         * c == x(m)^2 + x(p)^2 - 2*x(m)*x(p) + y(m)^2 + y(p)^2 - 2*y(m)*y(p) + z(m)^2 + z(p)^2 - 2*z(m)*z(p) - r^2
         * 
         * entspricht
         * 
         * a == q skalar q
         * b == 2 * ((p-m) skalar q)
         * c == m skalar m + p skalar p - 2 * (m skalar p) == (m - p) skalar (m - p)
         * 
         * =====================
         */
        
        a = ray.getNormalizedDirection().dot(ray.getNormalizedDirection());
        b = 2* ((ray.getOrigin().sub(this.middle).dot(ray.getNormalizedDirection())));
        c = (this.middle.sub(ray.getOrigin()).dot(this.middle.sub(ray.getOrigin()))) - Math.pow(this.radius, 2);
        
        diskriminante = Math.pow(b,2)-4*a*c;
        
        Hit hit = null;
        
        if(diskriminante >= 0){
            
            float t1 =(float) ((-b + Math.sqrt(diskriminante)) / 2*a);
            
            if(diskriminante > 0){
                float t2 =(float) ((-b - Math.sqrt(diskriminante)) / 2*a);
                
                hit = t1 > 0 && t2 > 0
                        ? (t1 < t2
                            ? new Hit(ray,this,t1) : new Hit(ray,this,t2))
                        : t1 > 0
                            ? new Hit(ray,this,t1) : (t2 > 0
                                ? new Hit(ray,this,t2) : null);
                
                
            } else {
                hit = t1 > 0 ? new Hit(ray,this,t1) : null;
            }
        }
        
        return hit;
    }
}
