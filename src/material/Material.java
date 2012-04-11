package material;

import vecmath.Color;

/**
 * Klasse aller möglichen Materialien.
 * 
 * @author Bruno Kirschner <bruno.kirschner@online.de>
 */
public class Material{
    
    // Die Farbe des Materials
    private Color color;
    
    public Material(final Color color){
        this.color = color;
    }

    /**
     * Gibt die Farbe des Materials an.
     * 
     * @return die Farbe
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setzt die Farbe des Materials
     * 
     * @param color die neue Farbe für das Material
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
