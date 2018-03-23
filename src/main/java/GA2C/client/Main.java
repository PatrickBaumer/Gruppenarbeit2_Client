/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA2C.client;

import ga2.soap.FahrzeugverleihSoapWebservice;
import ga2.soap.Kunde;
import ga2.soap.Fahrzeug;
import ga2.soap.Fahrzeugverleih;
import ga2.soap.Leihvertrag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

/**
 *
 * @author Patrick Baumer
 */
public class Main {

    public static Fahrzeugverleih fahrzeugverleih = new Fahrzeugverleih();
    public static FahrzeugverleihSoapWebservice ws = fahrzeugverleih.getFahrzeugverleihSoapWebservicePort();
    public static BufferedReader fkey = new BufferedReader(new InputStreamReader(System.in));
    public static String hilf;

    /**
     * @param args Kommandozeilenparameter
     * @throws java.io.IOException
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    public static void main(String[] args) throws IOException, DatatypeConfigurationException {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        runMainMenu();
    }

    public static void runMainMenu() throws IOException, DatatypeConfigurationException {


        System.out.println("Bester Fahrzeugverleih!");
        System.out.println("░░█▀░░░░░░░░░░░▀▀███████░░░░░");
        System.out.println("░░█▌░░░░░░░░░░░░░░░▀██████░░░");
        System.out.println("░█▌░░░░░░░░░░░░░░░░███████▌░░");
        System.out.println("░█░░░░░░░░░░░░░░░░░████████░░");
        System.out.println("▐▌░░░░░░░░░░░░░░░░░▀██████▌░░");
        System.out.println("░▌▄███▌░░░░▀████▄░░░░▀████▌░░");
        System.out.println("▐▀▀▄█▄░▌░░░▄██▄▄▄▀░░░░████▄▄░");
        System.out.println("▐░▀░░═▐░░░░░░══░░▀░░░░▐▀░▄▀▌▌");
        System.out.println("▐░░░░░▌░░░░░░░░░░░░░░░▀░▀░░▌▌");
        System.out.println("▐░░░▄▀░░░▀░▌░░░░░░░░░░░░▌█░▌▌");
        System.out.println("░▌░░▀▀▄▄▀▀▄▌▌░░░░░░░░░░▐░▀▐▐░");
        System.out.println("░▌░░▌░▄▄▄▄░░░▌░░░░░░░░▐░░▀▐░░");
        System.out.println("░█░▐▄██████▄░▐░░░░░░░░█▀▄▄▀░░");
        System.out.println("░▐░▌▌░░░░░░▀▀▄▐░░░░░░█▌░░░░░░");
        System.out.println("░░█░░▄▀▀▀▀▄░▄═╝▄░░░▄▀░▌░░░░░░");
        System.out.println("░░░▌▐░░░░░░▌░▀▀░░▄▀░░▐░░░░░░░");
        System.out.println("░░░▀▄░░░░░░░░░▄▀▀░░░░█░░░░░░░");
        System.out.println("░░░▄█▄▄▄▄▄▄▄▀▀░░░░░░░▌▌░░░░░░");
        System.out.println("░░▄▀▌▀▌░░░░░░░░░░░░░▄▀▀▄░░░░░");
        System.out.println("▄▀░░▌░▀▄░░░░░░░░░░▄▀░░▌░▀▄░░░");
        System.out.println("░░░░▌█▄▄▀▄░░░░░░▄▀░░░░▌░░░▌▄▄");
        System.out.println("░░░▄▐██████▄▄░▄▀░░▄▄▄▄▌░░░░▄░");
        System.out.println("░░▄▌████████▄▄▄███████▌░░░░░▄");
        System.out.println("░▄▀░██████████████████▌▀▄░░░░");
        System.out.println("▀░░░█████▀▀░░░▀███████░░░▀▄░░");
        System.out.println("░░░░▐█▀░░░▐░░░░░▀████▌░░░░▀▄░");
        System.out.println("░░░░░░▌░░░▐░░░░▐░░▀▀█░░░░░░░▀");
        System.out.println("░░░░░░▐░░░░▌░░░▐░░░░░▌░░░░░░░");
        System.out.println("░╔╗║░╔═╗░═╦═░░░░░╔╗░░╔═╗░╦═╗░");
        System.out.println("░║║║░║░║░░║░░░░░░╠╩╗░╠═╣░║░║░");
        System.out.println("░║╚╝░╚═╝░░║░░░░░░╚═╝░║░║░╩═╝░");

        boolean quit = false;

        while (!quit) {
            System.out.println("=========");
            System.out.println("Hauptmenü");
            System.out.println("=========");
            System.out.println();

            System.out.println("  [K] Kunde anlegen");
            System.out.println("  [F] Fahrzeug anlegen");
            System.out.println("  [A] Fahrzeug ausleihen");
            System.out.println("  [L] Leihverträge auflisten");
            System.out.println("  [E] Ende");
            System.out.println();

            System.out.print("Deine Auswahl: ");

            try {
                hilf = fkey.readLine();
            } catch (IOException ex) {
                System.out.println("Sorry, ich habe dich nicht verstanden.");
                runMainMenu();
            }
            System.out.println();

            switch (hilf.toUpperCase()) {
                case "K": //Kunde anlegen
                    kundeAnlegen();
                    break;
                case "F": //Fahrzeug anlegen
                    fahrzeugAnlegen();
                    break;
                case "A": //Fahrzeug ausleihen
                    fahrzeugAusleihen();
                    break;
                case "L": //Leihverträge auflsiten
                    leihvertraegeAuflisten();
                    break;
                case "E": //quitten
                    quit = true;
                    break;
                default:
                    System.out.println("Sorry, ich habe dich nicht verstanden.");
                    System.out.println();
            }

        }
    }

    public static void kundeAnlegen() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Kunde anlegen");
        System.out.println("================");
        System.out.println();

        String vorname = "";
        String nachname = "";
        String straße = "";
        String hausnummer = "";
        String plz = "";
        String ort = "";
        String land = "";

        while (vorname.equals("")) {
            System.out.print("Vorname:");
            try {
                vorname = fkey.readLine();
                if (vorname.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {

                System.out.println("Vorname darf nicht leer sein.");
            }
        }
        while (nachname.equals("")) {
            System.out.print("Nachname:");
            try {
                nachname = fkey.readLine();
                if (nachname.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {

                System.out.println("Nachname darf nicht leer sein.");
            }
        }

        while (straße.equals("")) {
            System.out.print("Straße:");
            try {
                straße = fkey.readLine();
                if (straße.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {

                System.out.println("Straße darf nicht leer sein.");
            }
        }

        while (hausnummer.equals("")) {
            System.out.print("Hausnummer:");
            try {
                hausnummer = fkey.readLine();
                if (hausnummer.equals("")) {
                    throw new Exception();
                }
                Integer.parseInt(hausnummer);
            } catch (Exception ex) {
                System.out.println("Hausnummer darf nicht leer und muss eine Zahl sein.");
                hausnummer = "";
            }
        }

        while (plz.equals("")) {
            System.out.print("Postleitzahl:");
            try {
                plz = fkey.readLine();
                if (plz.equals("")) {
                    throw new Exception();
                }
                Integer.parseInt(plz);
            } catch (Exception ex) {

                System.out.println("Postleitzahl darf nicht leer und muss eine Zahl sein.");
                plz = "";
            }
        }

        while (ort.equals("")) {
            System.out.print("Ort:");
            try {
                ort = fkey.readLine();
                if (ort.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {

                System.out.println("Ort darf nicht leer sein.");
            }
        }

        while (land.equals("")) {
            System.out.print("Land:");
            try {
                land = fkey.readLine();
                if (land.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {

                System.out.println("Land darf nicht leer sein.");
            }
        }

        Kunde kunde = new Kunde();
        kunde.setVorname(vorname);
        kunde.setNachname(nachname);
        kunde.setStraße(straße);
        kunde.setHausnummer(hausnummer);
        kunde.setPlz(plz);
        kunde.setOrt(ort);
        kunde.setLand(land);

        Holder<Kunde> hKunde = new Holder<>(kunde);
        ws.createNewKunde(hKunde);
        System.out.println("");
        System.out.println("");
        System.out.println("Kunde mit der ID: " + hKunde.value.getId() + " wurde angelegt.");

    }

    public static void fahrzeugAnlegen() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Fahrzeug anlegen");
        System.out.println("================");
        System.out.println();

        String hersteller = "";
        String baujahr = "";
        String modell = "";

        while (hersteller.equals("")) {
            System.out.print("Hersteller:");
            try {
                hersteller = fkey.readLine();
                if (hersteller.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Hersteller darf nicht leer sein.");
            }
        }

        while (modell.equals("")) {
            System.out.print("Modell:");
            try {
                modell = fkey.readLine();
                if (modell.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Modell darf nicht leer sein.");
            }
        }

        while (baujahr.equals("")) {
            System.out.print("Baujahr:");
            try {
                baujahr = fkey.readLine();
                if (baujahr.equals("")) {
                    throw new Exception();
                }
                Integer.parseInt(baujahr);
            } catch (Exception ex) {
                System.out.println("Baujahr darf nicht leer sein und muss eine Zahl sein.");
                baujahr = "";
            }
        }

        Fahrzeug fahrzeug = new Fahrzeug();
        fahrzeug.setHersteller(hersteller);
        fahrzeug.setModell(modell);
        fahrzeug.setBaujahr(baujahr);

        Holder<Fahrzeug> hFahrzeug = new Holder<>(fahrzeug);
        ws.createNewFahrzeug(hFahrzeug);

        System.out.println("");
        System.out.println("");
        System.out.println("Fahrzeug mit der ID: " + hFahrzeug.value.getId() + " wurde angelegt.");

    }

    public static void fahrzeugAusleihen() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Fahrzeug ausleihen");
        System.out.println("================");
        System.out.println();

        System.out.println("Folgende Fahzeuge stehen zur Verfügung:");

        List<Fahrzeug> alleFahrzeuge = ws.findAllFahrzeuge();

        if (alleFahrzeuge.isEmpty()) {
            System.out.println("Es stehen keine Fahrzeuge zur Verfügung.");
            runMainMenu();
        }

        for (Fahrzeug fahrzeug : alleFahrzeuge) {
            System.out.print(fahrzeug.getHersteller());
            System.out.print(" " + fahrzeug.getModell() + ", Baujahr");
            System.out.print(" " + fahrzeug.getBaujahr() + ", ID:");
            System.out.print(" " + fahrzeug.getId());
            System.out.println();
        }

        long kundeId = 0;
        long fahrzeugId = 0;
        String loanStartStr = "";
        String loanEndeStr = "";
        XMLGregorianCalendar loanStartGC = null;
        XMLGregorianCalendar loanEndeGC = null;

        while (kundeId == 0) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Kundennummer:");
                try {
                    kundeId = Long.parseLong(fkey.readLine());
                    if (ws.findKundeById(kundeId) == null) {
                        throw new Exception();
                    }
                    else i=5;
                    
                } catch (Exception ex) {
                    System.out.println("Kundennummer falsch!");
                    if (i==2) {
                        runMainMenu();
                    }
                }
            }
            
        }

        //3 Versuche für die Eingabe
        while (fahrzeugId == 0) {
            for (int i = 0; i < 3; i++) {
                System.out.print("Fahrzeug-ID:");
                try {
                    fahrzeugId = Long.parseLong(fkey.readLine());
                    if (ws.findFahrzeugById(fahrzeugId) == null) {
                        throw new Exception();
                    }
                    else i=5;
                } catch (Exception ex) {
                    System.out.println("Fahrzeug-ID falsch!");
                    fahrzeugId = 0;
                    if (i==2) {
                        runMainMenu();
                    }
                }
            }
        }

        while (loanStartStr.equals("")) {
            System.out.print("Abholung am (yyyy-mm-dd):");
            try {
                loanStartStr = fkey.readLine();
                loanStartGC = DatatypeFactory.newInstance().newXMLGregorianCalendar(loanStartStr + "T00:00:00+01:00");
            } catch (Exception ex) {
                System.out.println("Datum bitte in der Form: yyyy-mm-dd");
                loanStartStr = "";
            }
        }

        while (loanEndeStr.equals("")) {
            System.out.print("Rückgabe am (yyyy-mm-dd):");
            try {
                loanEndeStr = fkey.readLine();
                loanEndeGC = DatatypeFactory.newInstance().newXMLGregorianCalendar(loanEndeStr + "T00:00:00+01:00");
            } catch (Exception ex) {
                System.out.println("Datum bitte in der Form: yyyy-mm-dd");
                loanEndeStr = "";
            }
        }
        
        System.out.println("");
        Kunde kunde = ws.findKundeById(kundeId);
        Fahrzeug fahrzeug = ws.findFahrzeugById(fahrzeugId);
        Leihvertrag leih;
        

        try {
        leih = ws.createNewLeihvertrag(loanStartGC, loanEndeGC, fahrzeug, kunde);
        System.out.println("Leihvertrag mit der ID " + leih.getId() + " wurde angelegt.");
        } catch (Exception e) {
            System.out.println("Entschuldigen Sie. Das Fahrzeug ist schon ausgeliehen.");
            runMainMenu();
        }
    }
    

    public static void leihvertraegeAuflisten() throws IOException, DatatypeConfigurationException {
        long kundenId = 0;
        
        System.out.println("======================");
        System.out.println("Leihverträge auflisten");
        System.out.println("======================");
        System.out.println();
        
        while (kundenId == 0) {
            System.out.println("Bitte geben Sie ihre Kundennummer ein:");
            
            try {
                kundenId = Long.parseLong(fkey.readLine());
                if (ws.findKundeById(kundenId) == null) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Keine bekannte Kundennummer.");
            }
        }
        
        Kunde kunde = ws.findKundeById(kundenId);
        List<Leihvertrag> listeLeih = ws.findLeihvertragByKunde(kunde);
        SimpleDateFormat sDF = new SimpleDateFormat("dd.MM.yyyy");
        
        for (Leihvertrag hilf : listeLeih) {
            System.out.println();
            System.out.println("ID: " + hilf.getId());
            System.out.println("Fahrzeug:" + hilf.getFahrzeugId().getHersteller() + " " + hilf.getFahrzeugId().getModell() + ", " + hilf.getFahrzeugId().getBaujahr());
            System.out.println("Beginn der Leihe " + sDF.format(hilf.getBeginnDatum().toGregorianCalendar().getTime()));
            System.out.println("Ende der Leihe " + sDF.format(hilf.getEndeDatum().toGregorianCalendar().getTime()));
            System.out.println();
        }

    }
}
