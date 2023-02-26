/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Localizacao implements Serializable {
    //Atributos
    private String longitude;
    private String latitude;
    
    /**
    * Construtor da classe por omissão
    */
    public Localizacao(){
    }
    
   /**
    * Método construtor da classe
    * @param longitude Longitude
    * @param latitude Latitude
    */
    public Localizacao(String longitude, String latitude){
        this.longitude=longitude;
        this.latitude=latitude;
    }
    
    /**
    * Método de acesso externo à Longitude
    * @return Longitude
    */
    public String getLongitude() {
        return longitude;
    }
    
    /**
    * Método de alteração externa à Longitude
    * @param longitude Longitude
    */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    /**
    * Método de acesso externo à Latitude
    * @return Latitude
    */
    public String getLatitude() {
        return latitude;
    }
    
    /**
    * Método de alteração externa à Latitude
    * @param latitude Latitude
    */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Localizacao{" + "longitude=" + longitude + ", latitude=" + latitude + '}';
    }
}
