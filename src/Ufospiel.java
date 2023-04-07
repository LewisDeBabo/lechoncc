import GLOOP.*; 
public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLTafel counter;
    Asteroid[] nbomba;
    Coin[] cashMoneyMula;
    int zahl=0;

    private Ufo dasUfo;


    public Ufospiel() {
        kamera = new GLKamera(1920, 1080);
        kamera.verschiebe(0, 200, 500);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();

        nbomba = new Asteroid[20];
        for (int i=0; i < nbomba.length; i++) {
            nbomba[i] = new Asteroid(dasUfo, 0, 0);
        }
        for (int i=0 ;i < nbomba.length; i++) {
            nbomba[i].tp(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }

        cashMoneyMula = new Coin[10];
        for (int i=0; i < cashMoneyMula.length; i++) {
            cashMoneyMula[i] = new Coin(dasUfo, nbomba, 0, 0);
        }
        for (int i=0 ;i < cashMoneyMula.length; i++) {
            cashMoneyMula[i].tePe(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }

        morisaICantMoveItMoveItAnymore();
    }

    public void morisaICantMoveItMoveItAnymore() {
        counter = new GLTafel(-800,700,0,0,0);
        while (!tastatur.esc()) {
            if (tastatur.links() && dasUfo.gibX() > -575) {
                dasUfo.bewegeLinks();
            }
            if (tastatur.rechts() && dasUfo.gibX() < 575) {
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
                    nbomba[i].tp(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                }
            }

            zahl=zahl+1;
            if ((zahl%10) == 0){
            counter.setzeText("Deine Punktzahl ist:"+ zahl,25);
            }

            for (int i=0; i < cashMoneyMula.length; i++) {
                cashMoneyMula[i].moveitmoveit(2.5);
                cashMoneyMula[i].spinnaroo(1.0);
                if (cashMoneyMula[i].gibY() < -1000) {
                    cashMoneyMula[i].tePe(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                }
            }

            Sys.warte();
        }
        Sys.beenden();
    }


}