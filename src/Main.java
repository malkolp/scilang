import tool.Sci;
import tool.component.api.Commander;
import tool.component.api.OS;

/*
    Author  : Malko
    Project : Scilang

*/

public class Main {

    public static void main(String[] args) {
        //CODE YOUR IMAGINATION HERE
        Sci.getComponent().init();
        Commander cmd = Sci.getComponent().commander();
        cmd.setOS(OS.UBUNTU);
        cmd.setCompileBash("scilangc");
        cmd.setRunBash("scilang");
        cmd.renderCommand();
        cmd.create();
    }

}
