package b6_inheritanre.bai_tap;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {

    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float[] array=new float[2];
        array[0]=getX();
        array[1]=getY();
        return array;
    }
    public String toString(){
        return "("+getX()+","+getY()+")"
                +",speed=("+getXSpeed()+","+getYSpeed()+")";
    }
    public MovablePoint move(){
        setX(this.x+=xSpeed);
        setY(this.y+=ySpeed);
        return this;
    }

    public static void main(String[] args) {
        MovablePoint movablePoint=new MovablePoint(5,6,7,3);
        System.out.println(movablePoint.move());
    }
}
