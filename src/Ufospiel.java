import GLOOP.*;

import javax.swing.*;

public class Ufospiel {
    private GLKamera kamera;
    private GLLicht licht;
    private GLTastatur tastatur;
    private GLHimmel himmel;
    private GLTafel counter, counta, countr, screeen;
    Asteroid[] nbomba;
    Coin[] cashMoneyMula;
    CoinBlue[] cashMoneyMulaB;
    int zahl = 0;
    int p = 0;
    int q = 0;
    int versuch = 0;

    private Ufo dasUfo;


    public Ufospiel() {
        kamera = new GLKamera();
        kamera.verschiebe(0, 200, 500);
        licht = new GLLicht();
        tastatur = new GLTastatur();
        himmel = new GLHimmel("src/img/Sterne.jpg");

        dasUfo = new Ufo();

        nbomba = new Asteroid[20];
        for (int i = 0; i < nbomba.length; i++) {
            nbomba[i] = new Asteroid(dasUfo, 0, 0);
        }
        for (int i = 0; i < nbomba.length; i++) {
            nbomba[i].tp(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        cashMoneyMula = new Coin[10];
        for (int i = 0; i < cashMoneyMula.length; i++) {
            cashMoneyMula[i] = new Coin(dasUfo, nbomba, cashMoneyMulaB, 0, 0);
        }
        for (int i = 0; i < cashMoneyMula.length; i++) {
            cashMoneyMula[i].tePe(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        cashMoneyMulaB = new CoinBlue[2];
        for (int i = 0; i < cashMoneyMulaB.length; i++) {
            cashMoneyMulaB[i] = new CoinBlue(dasUfo, nbomba, cashMoneyMula, 0, 0);
        }
        for (int i = 0; i < cashMoneyMulaB.length; i++) {
            cashMoneyMulaB[i].tePee(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }

        morisaICantMoveItMoveItAnymore();
    }

    public void reset(){
        zahl=0;
        for (int i = 0; i < cashMoneyMula.length; i++) {
            cashMoneyMula[i].tePe(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }
        for (int i = 0; i < cashMoneyMulaB.length; i++) {
            cashMoneyMulaB[i].tePee(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }
        for (int i = 0; i < nbomba.length; i++) {
            nbomba[i].tp(Math.random() * 1000 - 500, 1000 + Math.random() * 1000);
        }
        dasUfo.resetExplodiert();
        counter.setzeText("Deine Punktzahl ist:" + zahl, 100);

    }

    public void clean(){
        counter.setzeSichtbarkeit(false);
        counta.setzeSichtbarkeit(false);
        countr.setzeSichtbarkeit(false);
    }
    public void full(){
        counter.setzeSichtbarkeit(true);
        counta.setzeSichtbarkeit(true);
        countr.setzeSichtbarkeit(true);
    }
    public void morisaICantMoveItMoveItAnymore() {
        counter = new GLTafel(0, 700, 0, 0, 0, "src/img/obaama.jpg");
        counta = new GLTafel(-800, 600, 0, 0, 0, "src/img/wide obama.jpg");
        countr = new GLTafel(-795, 500, 0, 0, 0, "src/img/obbama.jpg");
        while (!tastatur.esc() && versuch<3) {
            versuch++;
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
                for (int i = 0; i < nbomba.length; i++) {
                    nbomba[i].bewegeDich(2.5);
                    if (nbomba[i].gibY() < -1000) {
                        nbomba[i].tp(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }

                zahl = zahl + 1;
                if ((zahl % 10) == 0) {
                    counter.setzeText("Deine Punktzahl ist:" + zahl, 100);
                }
                //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                for (int i = 0; i < cashMoneyMula.length; i++) {
                    cashMoneyMula[i].moveitmoveit(2.5);
                    cashMoneyMula[i].spinnaroo(1.0);
                    if (cashMoneyMula[i].gibY() < -1000) {
                        cashMoneyMula[i].tePe(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }

                for (int i = 0; i < cashMoneyMula.length; i++) {
                    if (cashMoneyMula[i].cashgrab()) {
                        p = p + 1;
                        counta.setzeText("Coins:" + p, 100);
                        cashMoneyMula[i].tePe(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }

                for (int i = 0; i < cashMoneyMula.length; i++) {
                    if (cashMoneyMula[i].touch()) {
                        cashMoneyMula[i].tePe(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }
                //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                for (int i = 0; i < cashMoneyMulaB.length; i++) {
                    cashMoneyMulaB[i].moveitmoveitB(2.5);
                    cashMoneyMulaB[i].spinnarooB(1.0);
                    if (cashMoneyMulaB[i].gibY() < -1000) {
                        cashMoneyMulaB[i].tePee(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }

                for (int i = 0; i < cashMoneyMulaB.length; i++) {
                    if (cashMoneyMulaB[i].cashgrabB()) {
                        q = q + 1;
                        countr.setzeText("*Coins:" + q, 100);
                        cashMoneyMulaB[i].tePee(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }

                for (int i = 0; i < cashMoneyMulaB.length; i++) {
                    if (cashMoneyMulaB[i].touchB()) {
                        cashMoneyMulaB[i].tePee(Math.random() * 1400 - 700, 1000 + Math.random() * 1000);
                    }
                }
                Sys.warte();
                if (dasUfo.explodiert()) {
                    if (zahl > 10000) {
                        reset();
                        clean();
                        screeen = new GLTafel(0, 250, 0, 2000, 1550, "src/img/happy boi.jpg");
                        screeen.setzeText("You Mad Broski",100);
                        Sys.warte(5000);
                        screeen.loesche();
                        full();
                    }
                    if (zahl < 10000) {
                        reset();
                        clean();
                        screeen = new GLTafel(0, 250, 0, 2000, 1550, "src/img/sadbarrack.jpg");
                        screeen.setzeText("You Trash Broski",100);
                        Sys.warte(5000);
                        screeen.loesche();
                        full();
                    }
                }
            }
            Sys.beenden();
        }

    }

}
