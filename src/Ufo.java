import GLOOP.*;
public class Ufo{
    public GLTastatur tast;
    private GLTorus rumpf; 
    private GLKugel cockpit;
    private GLKegel fluegel1, fluegel2;

    public Ufo() {
        cockpit = new GLKugel(0, 0, 0, 25);
        cockpit.setzeMaterial(GLMaterial.GOLD);
    }

        public void bewegeLinks() {
            cockpit.verschiebe(-1,0,0);
        }

        public void bewegeRechts() {
            cockpit.verschiebe(1,0,0);
        }

        public void bewegeHoch() {
            cockpit.verschiebe(0,1,0);
        }

        public void bewegeRunter() {
            cockpit.verschiebe(0,-1,0);
        }

        public void explodiere() {
        }
    }
