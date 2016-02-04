
package model;

import database.Database;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author lars
 */
public class Profile {
    private String naam;
    private String straat;
    private int huisnummer;
    private String plaats;
    Database db;
    
    // private [type] image;
    public Profile() throws SQLException
    {
        this.naam = naam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.plaats = plaats;
        this.db = new Database();
    }
    public Profile(String naam, String straat, int huisnummer, String plaats) {
        this.naam = naam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.plaats = plaats;
    }
    
    /**
     * 
     * @param naam
     * @param straat
     * @param huisnummer
     * @param plaats
     * @return 
     */
    public void makeProfile(String naam, String straat, int huisnummer, String plaats, String path_to_logo) throws SQLException
    {
        Profile pf = new Profile(naam,straat,huisnummer, plaats);
        this.addProfileToDB(naam,straat,huisnummer, plaats, path_to_logo);
        System.out.println(pf.toString());
    }
     
    public void addProfileToDB(String naam, String straat, int huisnummer, String plaats, String path_to_logo) throws SQLException
    { 
        List<Pair> mPairs = new ArrayList<Pair>();
        mPairs.add(new Pair("String", naam));
        mPairs.add(new Pair("String", straat));
        mPairs.add(new Pair("Int",huisnummer));
        mPairs.add(new Pair("String", plaats));
        mPairs.add(new Pair("String", path_to_logo));
         
        db.makeDBConnection();
        db.insertData
        ("INSERT INTO profiel(Naam,Straat,Huisnummer,Plaats,Logo) VALUES (?,?,?,?,?)", mPairs);
        db.closeDB();
    }

    @Override
    public String toString() {
        return "Profile{" + "naam=" + naam + ", straat=" + straat + ", huisnummer=" + huisnummer + ", plaats=" + plaats + '}';
    }

    
    
    
}
