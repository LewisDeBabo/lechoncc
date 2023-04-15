import GLOOP.*;


public class Coin {
    private GLZylinder coin;
    private Asteroid[] Jerome;
    private CoinBlue[] CashB;
    private Ufo dasUfo;
    private Timer Cooldown;
    private double abstandB;
    double pX, pY;

    Coin(Ufo pUfo, Asteroid[] pAsteroid, CoinBlue[] pCoinBlue, double pX, double pY) {
        coin = new GLZylinder(pX, pY, 0, 20, 10, "src/img/cash.jpg");
        dasUfo = pUfo;
        Jerome = pAsteroid;
        CashB = pCoinBlue;
        Cooldown = new Timer();
    }

    public void shine() {
        Cooldown.coolDown();
        if (Cooldown.coolDownOver() && !shineState) {
            coin.setzeGlanz(1, 1, 1, 10000000);
            Cooldown.resetCoolDown(100);
            Cooldown.coolDown();
            shineState = true;
        } else if (Cooldown.coolDownOver() && shineState) {
            coin.setzeGlanz(1, 1, 1, 0);
            Cooldown.resetCoolDown(100);
            Cooldown.coolDown();
            shineState = false;
        }
    }

    public void blink() {
        coin.setzeGlanz(1, 1, 1, 1);
    }

    public void moveitmoveit(double speed) {
        coin.verschiebe(0, -1 * speed, 0);
        this.shine();
        if (cashgrab()) {
            this.blink();

        }
    }

    public void spinnaroo(double speedo) {
        coin.drehe(0, 1 * speedo, 0);
    }

    public boolean cashgrab() {
        double abstand = Math.sqrt(
                Math.pow(coin.gibX() - dasUfo.gibX(), 2) +
                        Math.pow(coin.gibY() - dasUfo.gibY(), 2) +
                        Math.pow(coin.gibZ() - dasUfo.gibZ(), 2)
        );
        if (abstand < 50) {
            return true;
        } else {
            return false;
        }
    }

    public void tePe(double pX, double pY) {
        coin.setzePosition(pX, pY, 0);
    }

    public double gibY() {
        return coin.gibY();
    }

    public boolean touch() {
        for (int i = 0; i < Jerome.length; i++) {
            abstandB = Math.sqrt(
                    Math.pow(coin.gibX() - Jerome[i].gibX(), 2) +
                            Math.pow(coin.gibY() - Jerome[i].gibY(), 2) +
                            Math.pow(coin.gibZ() - Jerome[i].gibZ(), 2)
            );
            if (abstandB < 70) {
                return true;
            }
        }
        return false;
    }
}
