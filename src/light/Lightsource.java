package light;

import vecmath.Color;
import vecmath.Vector;

/**
 * Stellt eine Lichtquelle für den Raytracer dar.
 */
public class Lightsource {
    
    /**
     * #################################
     *          Attribute
     * #################################
     */
    
    /**
     * Farbe der Lichtquelle
     */
    private Color color;
    
    /**
     * Position der Lichtquelle
     */
    private Vector position;
    
    /**
     * #################################
     *          Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt eine Lichtquelle.
     * 
     * @param pos Position der Lichtquelle
     * 
     * @param col Farbe der Lichtquelle
     */
    public Lightsource(final Vector pos, final Color col){
        this.position = pos;
        this.color = col;
    }

    /**
     * #################################
     *      öffentliche Methoden
     * #################################
     */
    
    /**
     * Gibt die Farbe des Lichts an.
     * 
     * @return Farbe des Lichts
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setzt die Farbe des Lichts neu.
     * 
     * @param color neue Farbe des Lichts
     */
    public void setColor(final Color color) {
        this.color = color;
    }

    /**
     * Gibt die Position des Lichts an.
     * 
     * @return Position des Lichts
     */
    public Vector getPosition() {
        return position;
    }
    /**
     * Setzt die Position des Lichtes neu.
     * 
     * @param position neue Position
     */
    public void setPosition(final Vector position) {
        this.position = position;
    }
}
