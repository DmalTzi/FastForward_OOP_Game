package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler  implements ActionListener{
    GamePanal gp ; 
    public ActionHandler(GamePanal gp){
        this.gp = gp ;
    }


    @Override

    public void actionPerformed(ActionEvent e){
        String yourchoice = e.getActionCommand();

    }
   
}
