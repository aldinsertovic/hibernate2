
package hibernateassignment.userinterface;

import hibernateassignment.database.Zaposleni;
import java.util.Scanner;


public class UserInterface {
    
    public final static int InvalidCommand = 0;
    public final static int Prikazisvezaposlene = 1;
    public final static int Dodajzaposlenog = 2;
    public final static int Azurirajzaposlenog = 3;
    public final static int Obrisizaposlenog = 4;
    public final static int Napustiaplikaciju =5;
    
    public void azuriranjeZaposlenog(Zaposleni zaposleni){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ukucajte ime zaposlenog: ");
        String ime = scanner.nextLine();
        if(!ime.isEmpty()){
            zaposleni.ime = ime;
            
        }
        System.out.println("Ukucaj broj godina zaposlenog: ");
        String brojGodina = scanner.nextLine();
        int brojGodinaParsiran = Integer.parseInt(brojGodina);
        
            zaposleni.broj_godina = brojGodinaParsiran;
        
        System.out.println("Ukucaj adresu stanovanja zaposlenog: ");
        String adresaStanovanja = scanner.nextLine();
        if(!adresaStanovanja.isEmpty()){
            zaposleni.adresa_stanovanja = adresaStanovanja;
        }
        
        System.out.println("Unesi visinu dohotka zaposlenog: ");
        String visinaDohotka = scanner.nextLine();
        double visinaDohotkaParsiran = Double.parseDouble(visinaDohotka);
        
            zaposleni.visina_dohotka = visinaDohotkaParsiran;
        
        
        
    }
    
    
    public Zaposleni pojedinacniZaposleni(){
        Zaposleni res = new Zaposleni();
        Scanner scanner = new Scanner(System.in);
        while(res.ime == null){
            System.out.println("Ukucaj ime zaposlenog: ");
            String ime = scanner.nextLine();
            if(ime.isEmpty()){
                System.out.println("Ime ne smije biti prazno");
                continue;
            }
            res.ime = ime;
            System.out.println("Ukucaj broj godina zaposlenog: ");
            String brojGodina = scanner.nextLine();
            int brojGodinaparsiran = Integer.parseInt(brojGodina);
            res.broj_godina = brojGodinaparsiran;
            
            System.out.println("Ukucaj adresu stanovanja zaposlenog: ");
            res.adresa_stanovanja = scanner.nextLine();
            
            System.out.println("Ukucaj visinu dohotka zaposlenog: ");
            String visinaDohotka = scanner.nextLine();
            double visinaDohotkaParsiran = Double.parseDouble(visinaDohotka);
            res.visina_dohotka = visinaDohotkaParsiran;
        }
        return res;
    }
    
    public int getZaposleniId(){
        int selectedId = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Ukucaj id zaposlenog: ");
            try{
                selectedId = Integer.parseInt(scanner.nextLine());
                break;
            }catch(Exception ex){
                System.out.println("Id zaposlenog nije validan");
            }
        }
        return selectedId;
    }
    
    public int menu(){
        System.out.println("1. Prikazi sve zaposlene, 2. Dodaj zaposlenog, 3. Azuriraj zaposlenog, 4. Obrisi zaposlenog, 5. Napusti aplikaciju");
        Scanner scanner = new Scanner(System.in);
        int selectedOption = 0;
        while(true){
            try{
                selectedOption = Integer.parseInt(scanner.nextLine());
                if(selectedOption<1 || selectedOption>5){
                    System.out.println("Izabrali ste nepostojecu opciju, pokusajte ponovno");
                    continue;
                }
                break;
            }catch(Exception ex){
                System.out.println("Unesite validni broj aplikacije: ");
            }
        }
        return selectedOption;
    }
    
    
}
