import GLOOP.*; 
public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    Asteroid[] nbomba;

    private Ufo dasUfo;


    public Ufospiel() {
        kamera = new GLKamera(800, 600);
        kamera.verschiebe(0, 200, 500);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();
        nbomba = new Asteroid[20];
        for (int q=0; q < nbomba.length; q++) {
            nbomba[q] = new Asteroid(dasUfo, 0, 0);
        }

        for (int i=0 ;i < nbomba.length; i++) {
            nbomba[i].tp(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }





        morisaICantMoveItMoveItAnymore();
    }

    public void morisaICantMoveItMoveItAnymore() {
        while (!tastatur.esc()) {
            if (tastatur.links() && dasUfo.gibX() > -475) {
                dasUfo.bewegeLinks();
            }
            if (tastatur.rechts() && dasUfo.gibX() < 475) {
                dasUfo.bewegeRechts();
            }
            if (tastatur.oben() && dasUfo.gibY() < 200) {
                dasUfo.bewegeHoch();
            }
            if (tastatur.unten() && dasUfo.gibY() > -200) {
                dasUfo.bewegeRunter();
            }
            for (int i=0 ;i < nbomba.length; i++){
                nbomba[i].bewegeDich(2.5);
                if (nbomba[i].gibY() < -1000) {
                    nbomba[i].tp(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
                }
            }
           /*
            if (asteroid2.gibY() < -1000) {
                asteroid2.tp(-330,1200);
            }
            if (asteroid3.gibY() < -1000) {
                asteroid3.tp(430,1350);
            }
            */Sys.warte();
        }
        Sys.beenden();
    }


}