import GLOOP.*;
public class Ufo{
    public GLTastatur tast;
    private GLKugel cockpit;

    double pX,pY;

    public Ufo() {
        cockpit = new GLKugel(0, 0, 0, 25);
        cockpit.setzeMaterial(GLMaterial.GOLD);
    }

        public void bewegeLinks() {
            cockpit.verschiebe(-2,0,0);
        }

        public void bewegeRechts() {
            cockpit.verschiebe(2,0,0);
        }

        public void bewegeHoch() {
            cockpit.verschiebe(0,2,0);
        }

        public void bewegeRunter() {
            cockpit.verschiebe(0,-2,0);
        }

    public void explodiere() {
        double z = Math.random();
        for (int i=0; i<2000; i++){

        }
    }

        public double gibX(){
            return cockpit.gibX();
        }
        public double gibY(){
            return cockpit.gibY();
        }
        public double gibZ(){
            return cockpit.gibZ();
        }
}
