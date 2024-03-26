package com.neogiciel.springbatch.model;

import java.util.List;
import java.util.Date;

//import org.json.JSONArray;
//import org.json.JSONObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EXECUTIONJOB")
public class ExecutionJob {
   
    @Id //@GeneratedValue
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDEXECUTIONJOB")
    public long id;
    
    @Column(name="NOM")
    public String nom;

    @Column(name="MESSAGE")
    public String message;

    @Column(name="DTCREATION")
    public Date dtCreation;


    /*
     * Constructeur
    */
    public ExecutionJob(){
    }

    /*
     * Constructeur
    */
    public ExecutionJob(String nom,String message){
        this.nom = nom;
        this.message = message;
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
