import GLOOP.*;


public class CoinBlue {
    private GLZylinder coinB;
    private Asteroid[] JeromeB;
    private Coin[] Cash;
    private Ufo dasUfoB;
    private Timer CooldownB;
    private double abstandB;
    double pX, pY;
    boolean shineStateB = false;

    CoinBlue(Ufo pUfo, Asteroid[] pAsteroid, Coin[] pCoin, double pX, double pY) {
        coinB = new GLZylinder(pX, pY, 0, 20, 10, "src/img/cobalt.jpg");
        dasUfoB = pUfo;
        JeromeB = pAsteroid;
        Cash = pCoin;
        CooldownB = new Timer();
    }

    public void shineB() {
        CooldownB.coolDown();
        if (CooldownB.coolDownOver() && !shineStateB) {
            coinB.setzeGlanz(1, 1, 1, 10000000);
            CooldownB.resetCoolDown(100);
            CooldownB.coolDown();
            shineStateB = true;
        } else if (CooldownB.coolDownOver() && shineStateB) {
            coinB.setzeGlanz(1, 1, 1, 0);
            CooldownB.resetCoolDown(100);
            CooldownB.coolDown();
            shineStateB = false;
        }
    }

    public void blinkB() {
        coinB.setzeGlanz(1, 1, 1, 1);
    }

    public void moveitmoveitB(double speed) {
        coinB.verschiebe(0, -1 * speed, 0);
        this.shineB();
        if (cashgrabB()) {
            this.blinkB();

        }
    }

    public void spinnarooB(double speedo) {
        coinB.drehe(0, 1 * speedo, 0);
    }

    public boolean cashgrabB() {
        double abstand = Math.sqrt(
                Math.pow(coinB.gibX() - dasUfoB.gibX(), 2) +
                        Math.pow(coinB.gibY() - dasUfoB.gibY(), 2) +
                        Math.pow(coinB.gibZ() - dasUfoB.gibZ(), 2)
        );
        if (abstand < 50) {
            return true;
        } else {
            return false;
        }
    }

    public void tePee(double pX, double pY) {
        coinB.setzePosition(pX, pY, 0);
    }

    public double gibY() {
        return coinB.gibY();
    }

    public boolean touchB() {
        for (int i = 0; i < JeromeB.length; i++) {
            abstandB = Math.sqrt(
                    Math.pow(coinB.gibX() - JeromeB[i].gibX(), 2) +
                            Math.pow(coinB.gibY() - JeromeB[i].gibY(), 2) +
                            Math.pow(coinB.gibZ() - JeromeB[i].gibZ(), 2)
            );
        }
        if (abstandB < 70) {
            return true;
        }
        else {
            return false;
        }
    }
}

