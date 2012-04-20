package picture;

import camera.Camera;
import camera.ICamera;
import light.Lightsource;
import material.Material;
import raytracer.Raytracer;
import raytracer.Scene;
import shapes.AxisAlignedBox;
import shapes.IShape;
import shapes.Plane;
import shapes.Sphere;
import shapes.Triangle;
import vecmath.Color;
import vecmath.Vector;

/**
 * Testet den Raytracer.
 */
public class TestRaytracer {

    /**
     * #################################
     *      öffentliche Methoden
     * #################################
     */
    
    /**
     * Erzeugt eine Testszene für den Raytracer.
     * 
     * @param args wird ignoriert
     */
    public static void main(final String[] args) {
        
        String path = System.getProperty("user.home");
        String filename = path + "/" + "raytracer.png";
        
        /** Szene die im Testbild darstellt wird **/
        Scene scene = new Scene();
        
        /***********************
         * 
         * Objekte für die Szene
         * 
         ***********************/
        
        /** Kugeln **/
        Sphere s1 = new Sphere(new Vector(-30,0,-100), 15);
        s1.setMaterial(Material.getRandomMaterial());
        
        Sphere s2 = new Sphere(new Vector(-10,0,-150), 15);
        s2.setMaterial(Material.getRandomMaterial());
        
        Sphere s3 = new Sphere(new Vector(10,0,-200), 15);
        s3.setMaterial(Material.getRandomMaterial());

        /** Ebenen **/
        Plane p1 = new Plane(new Vector(0,-50,0), new Vector(0,1,0));
        p1.setMaterial(Material.getRandomMaterial());
        
        Plane p2 = new Plane(new Vector(200,0,0), new Vector(-1,0,0));
        p2.setMaterial(Material.getRandomMaterial());
        
        Plane p3 = new Plane(new Vector(0,200,0), new Vector(0,-1,0));
        p3.setMaterial(Material.getRandomMaterial());
        
        Plane p4 = new Plane(new Vector(-200,0,0), new Vector(1,0,0));
        p4.setMaterial(Material.getRandomMaterial());
        
        Plane p5 = new Plane(new Vector(0,0,-700), new Vector(0,0,1));
        p5.setMaterial(Material.getRandomMaterial());
        
        /** Sonstiges **/
        AxisAlignedBox aab = new AxisAlignedBox(new Vector(30,-20,-250), new Vector(50,-10,-100));   
        aab.setMaterial(Material.getRandomMaterial());
        
        Triangle t1 = new Triangle(new Vector(100, 0,-350), new Vector(0,100,-350), new Vector(0,0,-350));
        t1.setMaterial(Material.getRandomMaterial());
        
        /** Fügt die Objekte der Szene hinzu **/
        scene.addShapeToScene(t1);
        scene.addShapeToScene(aab);
        scene.addShapeToScene(p1,p2,p3,p4,p5);
        scene.addShapeToScene(s1,s2,s3);
        
        /** Lichtquellen **/
        scene.setAmbientLight(new Color(1f, 1f, 1f));
        
        /** Kamera für den Raytracer **/
        ICamera cam = new Camera(new Vector(0f, 0f, 0f), 45.0f);
        
        /** Der zu testende Raytracer **/
        Raytracer raytracer = new Raytracer(cam, scene);
        
        /** Generiert ein Bild aus dem angelegten Raytracer **/
        ImageGenerator myPicture = new ImageGenerator(raytracer, 1680  , 1440, filename, "png");
        ImageGenerator.showImage(filename); 
    }
}
