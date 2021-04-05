package OOP.Bai_tap;

public class ClassFan<toString> {
    final int SLOW=1;
    final int MeDIUm=2;
    final int FASt=3;
    int speed=SLOW;
    boolean on=false;
    private double radius=5;
    private String color="blue";

    public int getSLOW() {
        return SLOW;
    }

    public int getMeDIUm() {
        return MeDIUm;
    }

    public int getFASt() {
        return FASt;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
    public String toString(){
        if(this.on) {
            return "speed: " + speed + " color: " + color + " radius: " + radius + " fan is on";

        }else {
            return "color: "+color+" radius: "+radius+" fan is off";
    }

    }

    public static void main(String[] args) {
        ClassFan fan1=new ClassFan();
//        fan1.speed=fan1.FASt;
        fan1.radius=10;
        fan1.color="red";
        fan1.on=true;
        System.out.println(fan1.toString());
        ClassFan fan2=new ClassFan();
        fan2.speed=fan2.MeDIUm;
        fan2.on=true;
        fan2.color="yellow";
        fan2.radius=7;

        System.out.println(fan2.toString());

    }
}
