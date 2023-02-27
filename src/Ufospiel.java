import GLOOP.*; 
public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;

    private Ufo dasUfo;
    private Asteroid asteroid1, asteroid2, asteroid3;
    //[...]

    public Ufospiel() {
        kamera = new GLSchwenkkamera(800, 600);
        kamera.verschiebe(0, 200, 500);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();

        asteroid1 = new Asteroid(-70,1070);
        asteroid2 = new Asteroid(-330,1200);
        asteroid3 = new Asteroid(430,1350);



        morisaICantMoveItMoveItAnymore();
    }

    public void morisaICantMoveItMoveItAnymore() {
        while (!tastatur.esc()) {
            asteroid1.bewegeDich(5);
            asteroid2.bewegeDich(5);
            asteroid3.bewegeDich(5);
            if (tastatur.links() && dasUfo.gibX() > -475) {
                dasUfo.bewegeLinks();
            }
            if (tastatur.rechts() && dasUfo.gibX() < 475) {
                dasUfo.bewegeRechts();
            }
            if (tastatur.oben() && dasUfo.gibY() < 200) {
                dasUfo.bewegeHoch();
            }
            if (tastatur.unten() && dasUfo.gibY() > -600) {
                dasUfo.bewegeRunter();
            }
            if (asteroid1.gibY() < -1000) {
                asteroid1.tp(-70,1070);
            }
            if (asteroid2.gibY() < -1000) {
                asteroid2.tp(-330,1200);
            }
            if (asteroid3.gibY() < -1000) {
                asteroid3.tp(430,1350);
            }
            Sys.warte();
        }
        Sys.beenden();
    }

}
