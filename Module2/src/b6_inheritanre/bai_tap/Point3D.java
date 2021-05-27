package b6_inheritanre.bai_tap;

public class Point3D extends Point2D {
    private float z=0.0f;
    public Point3D(float z){
        this.z=z;

    }
    public Point3D(float x,float y,float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
        super.setXY(x,y);
       this.z=z;
    }
    public float[] getXYZ(){
        float [] array={getX(),getY(),z};
        return array;
    }
    public String toString(){
        return "{"+getX()+";"+getY()+";"+getZ()+"}";
    }

    public static void main(String[] args) {
        Point3D point3D =new Point3D(3,4,5);
        System.out.println(point3D);
    }
}
