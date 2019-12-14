
package hibernateassignment.control;

import hibernateassignment.database.Db;
import hibernateassignment.database.Zaposleni;
import hibernateassignment.userinterface.UserInterface;
import java.sql.SQLException;
import java.util.List;


public class Controller {
    public Db db;
    public UserInterface ui;
    
    
    public void azuriranjeZaposlenog() throws SQLException{
        int id = ui.getZaposleniId();
        Zaposleni zaposleniToUpdate = db.pojedinacniZaposleni(id);
        if(zaposleniToUpdate == null){
            System.out.println("Zaposleni ne postoji u bazi podataka");
            return;
        }else{
            ui.azuriranjeZaposlenog(zaposleniToUpdate);
            db.azuriranjeZaposlenog(zaposleniToUpdate);
        }
    }
    
    public void obrisiZaposlenog() throws SQLException{
        int id = ui.getZaposleniId();
        db.obrisiZaposlenog(id);
    }
    
    public void unesiZasposlenog() throws SQLException{
        Zaposleni toAdd = ui.pojedinacniZaposleni();
        db.unesiZasposlenog(toAdd);
    }
    
    public void listaSvihZaposlenih () throws SQLException{
        List allZaposleni = db.listaSvihZaposlenih();
        System.out.println("id\time\tbroj_godina\tadresa_stanovanja\tvisina_dohotka");
        for(Object o : allZaposleni){
            Zaposleni zaposleni = (Zaposleni)o;
            System.out.println(zaposleni);
        }
    }
}
