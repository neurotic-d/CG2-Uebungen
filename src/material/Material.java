package material;

import vecmath.Color;

/**
 * Material für Oberflächen im Raytracer
 */
public class Material{
    
    /**
     * #################################
     *            Attribute
     * #################################
     */
    
    /**
     * Die Farbe des Material
     */
    private Color color;
    
    /**
     * #################################
     *         öffentliche Methoden
     * #################################
     */
    
    /**
     * Erzeugt ein neues Material.
     * 
     * @param color die Farbe des Material
     */
    public Material(final Color color){
        this.color = color;
    }

    /**
     * Gibt die Farbe des Materials wieder.
     * 
     * @return die Farbe
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setzt die Farbe des Materials neu.
     * 
     * @param color die neue Farbe
     */
    public void setColor(final Color color) {
        this.color = color;
    }
}
