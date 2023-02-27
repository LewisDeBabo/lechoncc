import GLOOP.*;
public class Asteroid{
    public double pX,pY;
    private GLKugel kugel;

    public Asteroid(double pX, double pY){
        kugel = new GLKugel(pX,1000,0, 50, "src/img/Krater.jpg");
    }

    public void bewegeDich(double speed){
        kugel.verschiebe(0,-1 * speed,0);
    }
    public void tp(double pX, double pY){
        kugel.setzePosition(pX,pY,0);
    }
    public double gibX(){
        return kugel.gibX();
    }
    public double gibY(){
        return kugel.gibY();
    }
    public double gibZ(){
        return kugel.gibZ();
    }


}
