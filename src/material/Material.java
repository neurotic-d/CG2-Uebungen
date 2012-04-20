package material;

import light.Lightsource;
import raytracer.Hit;
import raytracer.Ray;
import raytracer.Scene;
import vecmath.Color;
import vecmath.Vector;

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
     * Anteil an R,G,B der vom Umgebungslicht reflektiert wird.
     */
    private Color ambientColor;
    
    /**
     * Anteil an R,G,B der vom diffusen Licht reflektiert wird.
     */
    private Color difuseColor;
    
    /**
     * Anteil an R,G,B der vom spiegelnden Licht reflektiert wird.
     */
    private Color specularColor;
    
    /**
     * Der Exponent nach Phong für Glanzlicht.
     */
    private float phongExponent;
    
    /**
     * #################################
     *          Konstruktoren
     * #################################
     */
    
    /**
     * Erzeugt ein schwarzes Material ohne Glanzlicht.
     */
    public Material(){
        
        this.ambientColor = new Color(0,0,0);
        this.difuseColor = new Color(0,0,0);
        this.specularColor = new Color(0,0,0);
        this.phongExponent = 0f;
    }

    /**
     * Erzeugt ein neues Material mit den übergebenen Werten.
     * 
     * @param ambient   Farbe für das Umgebungslicht
     * 
     * @param difuse    Farbe für das difuse Licht
     * 
     * @param specular  Farbe für die Spiegelung
     * 
     * @param phong der Phong Exponent für das Glanzlicht
     */
    public Material(final Color ambient, final Color difuse, final Color specular, final float phong){
        this.ambientColor = ambient;
        this.difuseColor = difuse;
        this.specularColor = specular;
        this.phongExponent = phong;
    }
    
    /**
     * #################################
     *       öffentliche methoden
     * #################################
     */

    /**
     * Gibt den Anteil an R,G,B an, der vom Umgebungslicht reflektiert wird.
     * 
     * @return Anteil an R,G,B
     */
    public Color getAmbientColor() {
        return ambientColor;
    }

    /**
     * Setzt den Anteil an R,G,B neu, der vom Umgebungslicht reflektiert wird.
     * 
     * @param Anteil an R,G,B
     */
    public void setAmbientColor(Color ambientColor) {
        this.ambientColor = ambientColor;
    }

    /**
     * Gibt den Anteil an R,G,B an, der vom diffusen Licht reflektiert wird.
     * 
     * @return Anteil an R,G,B
     */
    public Color getDifuseColor() {
        return difuseColor;
    }

    /**
     * Setzt den Anteil an R,G,B neu, der vom diffusen Licht reflektiert wird.
     * 
     * @param Anteil an R,G,B
     */
    public void setDifuseColor(Color difuseColor) {
        this.difuseColor = difuseColor;
    }

    /**
     * Gibt den Phongexponenten für das Glanzlicht wieder.
     * 
     * @return Phongexponent
     */
    public float getPhongExponent() {
        return phongExponent;
    }

    /**
     * Setzt den Phongexponenten für das Glanzlicht neu.
     * 
     * @param phongExponent neuer Phongexponent
     */
    public void setPhongExponent(float phongExponent) {
        this.phongExponent = phongExponent;
    }

    /**
     * Gibt den Anteil an R,G,B an, der vom spiegelnden Licht reflektiert wird.
     * 
     * @return Anteil an R,G,B
     */
    public Color getSpecularColor() {
        return specularColor;
    }

    /**
     * Setzt den Anteil an R,G,B neu, der vom spiegelnden Licht reflektiert wird.
     * 
     * @param Anteil an R,G,B
     */
    public void setSpecularColor(Color specularColor) {
        this.specularColor = specularColor;
    }
    
    /**
     * Berechnet für dieses Material die Farbe in einem Punkt.
     * 
     * @param scene die Szene für die berechnet werden soll
     * 
     * @param hit   der Punkt für den berechnet werden soll
     * 
     * @return die Farbe im Punkt
     */
    public Color shade(final Scene scene, final Hit hit){
     
        Color returnColor = new Color(0,0,0);
        Color sceneAmbient = scene.getAmbientLight();
        Color ambient,difuse,specular;
        
        float r = 0f;
        float g = 0f;
        float b = 0f;
        
        /** Umgebungslicht **/
        r = sceneAmbient.r*this.ambientColor.r;
        g = sceneAmbient.g*this.ambientColor.g;
        b = sceneAmbient.b*this.ambientColor.b;
        ambient = new Color(r,g,b);
        
        
        /** diffuses Licht **/
        r = g = b = 0f;
        
        for(Lightsource light: scene.getLights()){
            
            Vector origin = hit.getRay().getPointAt(hit.getFactorForHitPoint());
            
            Vector directionToLight = light.getPosition().sub(origin);
            
            origin = origin.add(directionToLight.normalize().mult(0.1f));        
            
            Ray rayToLight = new Ray(origin, directionToLight.normalize());
            Hit sceneHit = scene.getNearestIntersectionWith(rayToLight);
            
            if(sceneHit == null || sceneHit.getFactorForHitPoint() > 0f && (rayToLight.getPointAt(sceneHit.getFactorForHitPoint()).sub(origin)).length() > (light.getPosition().sub(origin)).length()){
                float dotProduct = (hit.getHitpointNormal().normalize()).dot(directionToLight.normalize());
                
                dotProduct = Math.abs(dotProduct);
                
                /**
                 * TO-DO
                 * 
                 * KEINERLEI DISTANZ MIT DRIN >>> SORGT FÜR VERWIRRUNG
                 * 
                 * WICHTIG
                 **/
                
                r += light.getColor().r*dotProduct;
                g += light.getColor().g*dotProduct;
                b += light.getColor().b*dotProduct;
            }
        }
        
        r *= this.difuseColor.r;
        g *= this.difuseColor.g;
        b *= this.difuseColor.b;
        
        difuse = new Color(r,g,b);
        
        /** spiegelndes Licht **/
        
        r = g = b = 0f;
        
        r = ambient.r+difuse.r;
        g = ambient.g+difuse.g;
        b = ambient.b+difuse.b;
        
        r = r > 1f ? 1f : r;
        g = g > 1f ? 1f : g;
        b = b > 1f ? 1f : b;
        
        returnColor = new Color(r, g, b);
                
        return returnColor;
    }
    
    /**
     * Erzeugt ein zufälliges Material.
     * 
     * @return das zufällig generierte Material
     */
    public static Material getRandomMaterial(){
        
        Material randomMaterial = new Material();
        
        randomMaterial.ambientColor = Color.randomColor();
        randomMaterial.difuseColor = Color.randomColor();
        randomMaterial.specularColor = Color.randomColor();
        
        randomMaterial.phongExponent = (float)Math.random();
        
        return randomMaterial;
    }
}
