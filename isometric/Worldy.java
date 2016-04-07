import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Worldy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Worldy extends World {
    double[][] points = {
        {-1, -1, -1},
        {-1, -1,  1},
        {-1,  1, -1},
        {-1,  1,  1},
        { 1, -1, -1},
        { 1, -1,  1},
        { 1,  1, -1},
        { 1,  1,  1}
    };
    
    int[] verts = {
        //back
        1, 3, 2,
        1, 2, 0,
        
        //front
        4, 6, 7,
        4, 7, 5,
        
        //left
        0, 2, 6,
        0, 6, 4,
        
        //right
        5, 7, 3,
        5, 3, 1,
        
        //bottom
        1, 0, 4,
        1, 4, 5,
        
        //top
        6, 2, 3,
        6, 3, 7
    };
    
    Color[] colors = {
        //front
        new Color(255, 0, 0),
        new Color(255, 0, 0),
        
        //back
        new Color(255, 125, 0),
        new Color(255, 125, 0),
        
        //left
        new Color(0, 180, 0),
        new Color(0, 180, 0),
        
        //right
        new Color(0, 0, 255),
        new Color(0, 0, 255),
        
        //top
        new Color(255, 255, 255),
        new Color(255, 255, 255),
        
        //bottom
        new Color(255, 255, 0),
        new Color(255, 255, 0)
    };
    
    int[][] mousePos = new int[5][2];
    boolean mouseUp = true;
    
    double[] vel = {0.01, 0.008, 0.006};
    
    public Worldy() {
        super(600, 400, 1);
        render();
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null) {
            if(Greenfoot.mousePressed(null)) {
                vel = new double[]{0, 0, 0};
            } else if(Greenfoot.mouseDragged(null)) {
                double t = 100;
                double dx = (mouse.getX()-mousePos[mousePos.length-1][0])/t;
                double dy = -(mouse.getY()-mousePos[mousePos.length-1][1])/t;
                turn(dx+dy, dx*2, dy-dx);
            } else if(Greenfoot.mouseDragEnded(null)) {
                double t = 500;
                double dx = (mouse.getX()-mousePos[0][0])/t;
                double dy = -(mouse.getY()-mousePos[0][1])/t;
                vel = new double[]{dx+dy, dx*2, dy-dx};
            }
            for(int i = 0; i < mousePos.length - 1; i++) mousePos[i] = mousePos[i+1];
            mousePos[mousePos.length - 1] = new int[]{mouse.getX(), mouse.getY()};
        }
        
        turn(vel[0], vel[1], vel[2]);
        render();
    }
    
    public void turn(double pitch, double yaw, double roll) {
        for(double[] i:points) {
            double cosα = Math.cos(pitch);
            double sinα = Math.sin(pitch);
            double cosβ = Math.cos(yaw);
            double sinβ = Math.sin(yaw);
            double cosγ = Math.cos(roll);
            double sinγ = Math.sin(roll);
            double nx = cosα*cosβ*i[0] + (cosα*sinβ*sinγ-sinα*cosγ)*i[1] + (cosα*sinβ*cosγ+sinα*sinγ)*i[2];
            double ny = sinα*cosβ*i[0] + (sinα*sinβ*sinγ+cosα*cosγ)*i[1] + (sinα*sinβ*cosγ-cosα*sinγ)*i[2];
            double nz = -sinβ*i[0]     + cosβ*sinγ*i[1]                   + cosβ*cosγ*i[2];
            i[0] = nx;
            i[1] = ny;
            i[2] = nz;
        }
    }
    
    public void render() {
        int[] dverts = verts.clone();
        Color[] dcolors = colors.clone();
        for(int p = 0; p < dverts.length - 3; p+=3) {
            for(int i = 0; i < dverts.length - 3 - p; i+=3) {
                double[] p0 = points[dverts[i  ]];
                double[] p1 = points[dverts[i+1]];
                double[] p2 = points[dverts[i+2]];
                double[] p3 = points[dverts[i+3]];
                double[] p4 = points[dverts[i+4]];
                double[] p5 = points[dverts[i+5]];
                
                double mv1x = (p0[0] + p1[0] + p2[0]) / 3;
                double mv1y = (p0[1] + p1[1] + p2[1]) / 3;
                double mv1z = (p0[2] + p1[2] + p2[2]) / 3;
                
                double mv2x = (p3[0] + p4[0] + p5[0]) / 3;
                double mv2y = (p3[1] + p4[1] + p5[1]) / 3;
                double mv2z = (p3[2] + p4[2] + p5[2]) / 3;
                
                double c1 = mv1y + mv1x - mv1z;
                double c2 = mv2y + mv2x - mv2z;
                
                if(c2 > c1) {
                    int[] temp = {dverts[i], dverts[i+1], dverts[i+2]};
                    Color tempC = dcolors[i/3];
                    dverts[i] = dverts[i+3];
                    dverts[i+1] = dverts[i+4];
                    dverts[i+2] = dverts[i+5];
                    dcolors[i/3] = dcolors[i/3+1];
                    dverts[i+3] = temp[0];
                    dverts[i+4] = temp[1];
                    dverts[i+5] = temp[2];
                    dcolors[i/3+1] = tempC;
                }
            }
        }
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        for(int i = 0; i < dverts.length; i+=3) {
            double[] p0 = points[dverts[i]];
            double[] p1 = points[dverts[i+1]];
            double[] p2 = points[dverts[i+2]];
            
            double[] norm = cross(new double[]{
                p1[0] - p0[0],
                p1[1] - p0[1],
                p1[2] - p0[2]
            }, new double[] {
                p2[0] - p0[0],
                p2[1] - p0[1],
                p2[2] - p0[2]
            });
            
            if(dot(norm, new double[]{-1, -1, 1}) > 0) {
                double x0 = (p0[0] + p0[2]) * Math.cos(Math.PI/6);
                double x1 = (p1[0] + p1[2]) * Math.cos(Math.PI/6);
                double x2 = (p2[0] + p2[2]) * Math.cos(Math.PI/6);
                double y0 = p0[1] + (p0[2] - p0[0]) * Math.sin(Math.PI/6);
                double y1 = p1[1] + (p1[2] - p1[0]) * Math.sin(Math.PI/6);
                double y2 = p2[1] + (p2[2] - p2[0]) * Math.sin(Math.PI/6);
                
                double scale = 60.0;
                double xoff = getWidth() / 2;
                double yoff = getHeight() / 2;
                x0 = x0 * scale + xoff;
                x1 = x1 * scale + xoff;
                x2 = x2 * scale + xoff;
                y0 = y0 * scale + yoff;
                y1 = y1 * scale + yoff;
                y2 = y2 * scale + yoff;
                
                getBackground().setColor(dcolors[i/3]);
                getBackground().fillPolygon(new int[]{(int)x0, (int)x1, (int)x2}, new int[]{(int)y0, (int)y1, (int)y2}, 3);
            }
        }
    }
    
    public double[] cross(double[] a, double[] b) {
        return new double[]{
            a[1]*b[2] - b[1]*a[2],
            a[2]*b[0] - b[2]*a[0],
            a[0]*b[1] - b[0]*a[1]
        };
    }
    
    public double dot(double[] a, double[] b) {
        return a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
    }
}
