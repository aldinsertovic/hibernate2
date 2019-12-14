
package hibernateassignment.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zaposleni")
public class Zaposleni {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;
    
    @Column(name = "ime")
   public String  ime;
    
    @Column(name = "broj_godina")
   public int broj_godina;
    
    @Column(name= "adresa_stanovanja")
   public String adresa_stanovanja;
    
    @Column(name = "visina_dohotka")
   public double visina_dohotka;

    @Override
    public String toString() {
        return id + "\t" + ime + "\t" + broj_godina + "\t" + adresa_stanovanja + "\t" + visina_dohotka;
    }
   
   
   
}
