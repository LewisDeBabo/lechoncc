import GLOOP.*;
public class Asteroid{
    public double pX;
    private GLKugel kugel;

    public Asteroid(double pX){
        kugel = new GLKugel(pX,1000,0, 50, "src/img/Krater.jpg");
    }

    public void bewegeDich(){
        kugel.verschiebe(0,-0.5,0);
    }

}
