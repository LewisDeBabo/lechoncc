import GLOOP.*;
public class Coin {
    private GLZylinder c;
    private Ufo dasUfo;
    double pX, pY;

    public void Dublone(Ufo pUfo, double pX, double pY) {
        c = new GLZylinder(pX, pY,0,20,10,"src/img/cash.jpg");
        dasUfo = pUfo;
    }

    public void Spinnaroo(double speedo){
        c.drehe(0,1 * speedo,0);
    }
    public void moveitmoveit(double speed) {
        c.verschiebe(0, -1 * speed, 0);
        if (cashgrab()){
            dasUfo.shine(); //shine macht ufo blinke blinke
        }
    }
    public boolean cashgrab() {
        double abstand = Math.sqrt(
                Math.pow(c.gibX() - dasUfo.gibX(), 2) +
                        Math.pow(c.gibY() - dasUfo.gibY(), 2) +
                        Math.pow(c.gibZ() - dasUfo.gibZ(), 2)
        );
        if (abstand < 50) {
            return true;
        }
        else{
            return false;
        }

    }
}
