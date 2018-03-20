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

    private final FahrzeugverleihSoapWebservice ws;
    private final BufferedReader fkey;
    
    
        /**
     * @param args Kommandozeilenparameter
     * @throws java.io.IOException
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */

    public static void main(String[] args) throws IOException, DatatypeConfigurationException {
        Main main = new Main();
        main.runMainMenu();

    }

    public Main() {
        Fahrzeugverleih fahrzeugverleih = new Fahrzeugverleih();
        this.ws = fahrzeugverleih.getFahrzeugverleihSoapWebservicePort();
        this.fkey = new BufferedReader(new InputStreamReader(System.in));
    }
    
    

    public void runMainMenu() throws IOException, DatatypeConfigurationException {
        
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
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
            String command = this.fkey.readLine();
            System.out.println();

            switch (command.toUpperCase()) {
                case "K": //Kunde anlegen
                    this.kundeAnlegen();
                    break;
                case "F": //Fahrzeug anlegen
                    this.fahrzeugAnlegen();
                    break;
                case "A": //Fahrzeug ausleihen
                    this.fahrzeugAusleihen();
                    break;
                case "L": //Leihverträge auflsiten
                    this.leihvertraegeAuflisten();
                    break;
                case "E": //quitten
                    quit = true;
                    break;
                default:
                    System.out.println("Sorry, ich habe dich nicht verstanden …");
                    System.out.println();
            }

        }
    }

    public void kundeAnlegen() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Kunde anlegen");
        System.out.println("================");
        System.out.println();

        System.out.print("Vorname:");
        String vorname = this.fkey.readLine();

        System.out.print("Nachname:");
        String nachname = this.fkey.readLine();

        System.out.print("Straße:");
        String straße = this.fkey.readLine();

        System.out.print("Hausnummer:");
        String hausnummer = this.fkey.readLine();

        System.out.print("Postleitzahl:");
        String plz = this.fkey.readLine();

        System.out.print("Ort:");
        String ort = this.fkey.readLine();

        System.out.print("Land:");
        String land = this.fkey.readLine();

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
        
        System.out.println("Kunde mit der ID" + hKunde.value.getId() + "wurde angelegt.");

    }

    public void fahrzeugAnlegen() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Fahrzeug anlegen");
        System.out.println("================");
        System.out.println();

        System.out.print("Hersteller:");
        String hersteller = this.fkey.readLine();

        System.out.print("Modell:");
        String modell = this.fkey.readLine();

        System.out.print("Baujahr:");
        String baujahr = this.fkey.readLine();

        Fahrzeug fahrzeug = new Fahrzeug();
        fahrzeug.setHersteller(hersteller);
        fahrzeug.setModell(modell);
        fahrzeug.setBaujahr(baujahr);

        Holder<Fahrzeug> hFahrzeug = new Holder<>(fahrzeug);
        ws.createNewFahrzeug(hFahrzeug);
        
        System.out.println("Fahrzeug mit der ID" + hFahrzeug.value.getId() + "wurde angelegt.");

    }

    public void fahrzeugAusleihen() throws IOException, DatatypeConfigurationException {
        System.out.println("================");
        System.out.println("Fahrzeug ausleihen");
        System.out.println("================");
        System.out.println();
        
        System.out.println("Folgende Fahzeuge stehen zur Verfügung:");
        
        List<Fahrzeug> alleFahrzeuge = ws.findAllFahrzeuge();
        
        for (Fahrzeug fahrzeug: alleFahrzeuge) {
            System.out.print(fahrzeug.getHersteller());
            System.out.print(" " + fahrzeug.getModell() + ", Baujahr");
            System.out.print(" " + fahrzeug.getBaujahr() + ", ID");
            System.out.print(" " + fahrzeug.getId());
            System.out.println();   
        }
        
        System.out.print("Kundennummer:");
        Long kundeId = Long.parseLong(this.fkey.readLine());
        Kunde kunde = ws.findKundeById(kundeId);
        
        System.out.print("Fahrzeug-ID:");
        Long fahrzeugId = Long.parseLong(this.fkey.readLine());
        Fahrzeug fahrzeug = ws.findFahrzeugById(fahrzeugId);
        
        
        
        
        System.out.print("Abholung am (yyyy-mm-dd):");
        String loanStartStr = this.fkey.readLine();
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        XMLGregorianCalendar loanStart = dtf.newXMLGregorianCalendar(loanStartStr);
        
        System.out.print("Rückgabe am (yyyy-mm-dd):");
        String loanEndeStr = this.fkey.readLine();
        DatatypeFactory dtf2 = DatatypeFactory.newInstance();
        XMLGregorianCalendar loanEnde = dtf2.newXMLGregorianCalendar(loanEndeStr);
        
        Holder<Leihvertrag> hLeih = new Holder<> (ws.createNewLeihvertrag(loanStart, loanEnde, fahrzeug, kunde));
        
        System.out.println("Alles klar! Leihvertrag mit der ID " + hLeih.value.getId() + " wurde angelegt.");
    }

    public void leihvertraegeAuflisten() throws IOException, DatatypeConfigurationException {

    }
}
