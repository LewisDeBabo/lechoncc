import GLOOP.*;
public class Points {
    private GLTafel Counter;
    double zahl=0;

    public void PunkteCounter() {
        Counter = new GLTafel(0,0,0,0,0);
        Counter.setzeText("Deine Punktzahl ist:"+ zahl,14);
    }

    public void Punkte(){
        for (int i=0; i<100000;i++){
            zahl=zahl+1;
            Sys.warte(10);
        }
        Counter.setzeText("Deine Punktzahl ist:"+ zahl,14);
    }











}
