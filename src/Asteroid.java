import GLOOP.*;
public class Asteroid{
    public double pX,pY;
    private GLKugel kugel;
    private Ufo dasUfo;

    public Asteroid(Ufo pUfo, double pX, double pY){
        kugel = new GLKugel(pX,1000,0, 50, "src/img/Krater.jpg");
        dasUfo = pUfo;
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

    public boolean getroffen(){
        double abstand = math.sqrt(
                Math.pow(kugel.gibX()-dasUfo.gibX)
        )
    }


}
