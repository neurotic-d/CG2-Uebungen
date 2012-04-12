package picture;

import camera.Camera;
import camera.ICamera;
import raytracer.Raytracer;
import raytracer.Scene;
import shapes.AxisAlignedBox;
import shapes.Plane;
import shapes.Sphere;
import vecmath.Color;
import vecmath.Vector;

/**
 * Testet den Raytracer.
 * 
 * @author Bruno Kirschner
 */
public class TestRaytracer {

    public static void main(String[] args) {
        String path = System.getProperty("user.home");
        String filename = path + "/" + "raytracer.png";
        
        // Szene
        Scene scene = new Scene();
        Sphere s1 = new Sphere(new Vector(-30,0,-100), 15);
        s1.getMaterial().setColor(new Color(0,0,1f));
        
        Sphere s2 = new Sphere(new Vector(-10,0,-150), 15);
        s2.getMaterial().setColor(new Color(0,1,0));
        
        Sphere s3 = new Sphere(new Vector(10,0,-200), 15);
        s3.getMaterial().setColor(new Color(1f,0,0));

        Plane p1 = new Plane(new Vector(0,-100,0), new Vector(0,1,0));
        p1.getMaterial().setColor(new Color(0.5f, 0.5f, 0.5f));
        
        Plane p2 = new Plane(new Vector(200,0,0), new Vector(-1,0,0));
        p2.getMaterial().setColor(new Color(0.3f, 0.3f, 0.5f));
        
        Plane p3 = new Plane(new Vector(0,100,0), new Vector(0,-1,0));
        p3.getMaterial().setColor(new Color(0.3f, 0.3f, 0.3f));
        
        Plane p4 = new Plane(new Vector(-200,0,0), new Vector(1,0,0));
        p4.getMaterial().setColor(new Color(0.5f, 0.3f, 0.3f));
        
        Plane p5 = new Plane(new Vector(0,0,-700), new Vector(0,0,1));
        p5.getMaterial().setColor(new Color(0f, 0f, 0f));
        
        AxisAlignedBox aab = new AxisAlignedBox(new Vector(-20,-40,-500), new Vector(100,100,-400));
        aab.getMaterial().setColor(new Color(1f,1f,1f));
        
        scene.addShapeToScene(aab);
        scene.addShapeToScene(p1,p2,p3,p4,p5);
        scene.addShapeToScene(s1,s2,s3);
        
        ICamera cam = new Camera(new Vector(0,0,0), new Vector(0,0,-1), new Vector(0,1,0), 45.0f);
        
        // Raytracer
        Raytracer raytracer = new Raytracer(cam, scene);
        
        // Bildgenerator
        new ImageGenerator(raytracer, 750  , 750, filename, "png");
        ImageGenerator.showImage(filename); 
    }
}
