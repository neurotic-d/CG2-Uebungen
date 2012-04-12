package shapes;

import raytracer.Ray;
import material.Material;
import raytracer.Hit;

public interface IShape {
    
    /**
     * Gibt die Schnittpunkte der Form mit einem Strahl wieder.
     * 
     * @param ray   Der Strahl, welcher die Form eventuell schneidet.
     * 
     * @return  die Schnittpunkte falls sie existieren
     */
    public Hit getNearestIntersectionWith(final Ray ray);
    
    /**
     * Gibt das Material der Form wieder.
     * 
     * @return das Material
     */
    public Material getMaterial();
}