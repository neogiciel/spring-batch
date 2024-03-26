package com.neogiciel.springbatch.model;

import java.util.List;
import java.util.Date;

import jakarta.persistence.Access;
//import org.json.JSONArray;
//import org.json.JSONObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "PROCESSUS")
//@Access(value=AccessType.FIELD)
public class Processus {

    @Id //@GeneratedValue
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDPROCESSUS")
    public long id;
    
    @Column(name="ACTIF")
    public String actif;


    /*
     * Constructeur
    */
    public Processus(){
    }

    /*
     * Constructeur
    */
    public Processus(String isActif){
        this.actif = isActif;
    }

    /*
     * toJSON
     */
    /*public JSONObject toJSON(Message m) {

        JSONObject obj = new JSONObject();
        obj.put("id", m.id);
        obj.put("message", m.message);
            
        return obj;
    } */   



    /*
     * totListeJSON
     */
    /*public JSONArray totListeJSON( List<Message> liste ) {

        JSONArray jsonArray = new JSONArray();


        for (int i= 0; i < liste.size(); i++ ){
            Message m = liste.get(i);
            JSONObject obj = new JSONObject();
            obj.put("id", m.id);
            obj.put("message", m.message);
            jsonArray.put(obj);
        }
        return jsonArray;
    } */


}
