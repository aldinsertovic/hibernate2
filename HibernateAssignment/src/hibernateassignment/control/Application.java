
package hibernateassignment.control;

import hibernateassignment.database.Db;
import hibernateassignment.userinterface.UserInterface;
import java.sql.SQLException;


public class Application {
    public static void launch() throws SQLException{
        Controller ctrl = new Controller();
        ctrl.db = new Db();
        ctrl.ui = new UserInterface();
        
        mainLoop:
        while(true){
            switch(ctrl.ui.menu()){
                case UserInterface.Azurirajzaposlenog:
                    ctrl.azuriranjeZaposlenog();
                    break;
                case UserInterface.Obrisizaposlenog:
                    ctrl.obrisiZaposlenog();
                    break;
                    
                case UserInterface.Dodajzaposlenog:
                    ctrl.unesiZasposlenog();
                    break;
                case UserInterface.Prikazisvezaposlene:
                    ctrl.listaSvihZaposlenih();
                    break;
                    
                case UserInterface.Napustiaplikaciju:
                    System.out.println("Goodbye");
                    break mainLoop;
            }
        }
    }
}
