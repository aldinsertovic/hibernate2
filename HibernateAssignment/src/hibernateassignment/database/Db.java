
package hibernateassignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Db {
    
    public Connection connect() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/firma", "root", "prozor");
        return conn;
    }
    public void unesiZasposlenog(Zaposleni zaposleni) throws SQLException{
        Connection conn = connect();
        Statement st = conn.createStatement();
        String query = "insert into zaposleni values (null,'"+zaposleni.ime+"', '"+zaposleni.broj_godina+"', '"+zaposleni.adresa_stanovanja+"','"+zaposleni.visina_dohotka+"')";
        st.execute(query);
        st.close();
    }
    
    public void obrisiZaposlenog(int id) throws SQLException{
        Connection conn = connect();
        Statement st = conn.createStatement();
        String query = "delete from zaposleni where id = "+id;
        st.execute(query);
        st.close();
    }
    
    public void azuriranjeZaposlenog(Zaposleni zaposleni) throws SQLException{
        Connection conn = connect();
        PreparedStatement st = conn.prepareStatement("update zaposleni set ime=?, broj_godina=?, adresa_stanovanja=?, visina_dohotka=? where id = ? ");
        st.setString(1, zaposleni.ime);
        st.setInt(2, zaposleni.broj_godina);
        st.setString(3, zaposleni.adresa_stanovanja);
        st.setDouble(4, zaposleni.visina_dohotka);
        st.execute();
        st.close();
        conn.close();
    }
    
    public List listaSvihZaposlenih() throws SQLException{
        List res = new ArrayList();
        Connection conn = connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from zaposleni");
        while(rs.next()){
            Zaposleni zaposleni = new Zaposleni();
            zaposleni.id = rs.getInt("id");
            zaposleni.ime = rs.getString("ime");
            zaposleni.broj_godina = rs.getInt("broj_godina");
            zaposleni.adresa_stanovanja = rs.getString("adresa_stanovanja");
            zaposleni.visina_dohotka = rs.getDouble("visina_dohotka");
            res.add(zaposleni);
            
        }
        conn.close();
        return res;
    }
    
    public Zaposleni pojedinacniZaposleni(int id) throws SQLException{
        Zaposleni zaposleni = null;
        Connection conn = connect();
        PreparedStatement st = conn.prepareStatement("select * from zaposleni where id = ?");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            zaposleni = new Zaposleni();
            zaposleni.id = rs.getInt("id");
            zaposleni.ime = rs.getString("ime");
            zaposleni.broj_godina = rs.getInt("broj_godina");
            zaposleni.adresa_stanovanja = rs.getString("adresa_stanovanja");
            zaposleni.visina_dohotka = rs.getDouble("visina_dohotka");
        }
        st.close();
        return zaposleni;
    }
    
}
