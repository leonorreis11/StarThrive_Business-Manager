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
public class Cafe extends EmpresaRestauracao implements Serializable {
    //Atributos
    private int numCafes;
    
    /**
     * Método construtor por omissão
     */
    public Cafe(){
        
    }
    
   /**
    * Método construtor da classe
    * @param nome Nome da empresa
    * @param distrito Distrito da empresa
    * @param loc Localização da empresa
    * @param valorFaturacao Valor médio de faturação anual
    * @param numEmpregados Número de empregados de mesa
    * @param custoSalario Custo do salário médio anual
    * @param numClientes Número médio de clientes diários
    * @param numCafes Número médio de cafés que vendem por dia
    */
    public Cafe(String nome, String distrito, Localizacao loc, double valorFaturacao,int numEmpregados,double custoSalario,int numClientes, int numCafes) {
        super("Cafe", nome, distrito, loc, valorFaturacao,  numEmpregados, custoSalario, numClientes);
        this.numCafes=numCafes;
    }


    /**
    * Método de acesso externo ao Número médio de cafés que vendem por dia
    * @return Número médio de cafés que vendem por dia
    */
    public int getNumCafes() {
        return numCafes;
    }
    
    /**
    * Método de alteração externa ao Número médio de cafés que vendem por dia
    * @param numCafes Número médio de cafés que vendem por dia
    */
    public void setNumCafes(int numCafes) {
        this.numCafes = numCafes;
    }
    
    /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    @Override
    public double calculaReceita(){
        return numCafes * super.valorFaturacao;
    }
    
    
    @Override
    public String toString() {
        return "\nCafé" + super.toString() + "\nNº de cafés vendidos por dia: " + numCafes;
    }
    
    /**
     * Alterar o parametro do objeto
     * @param parametro parametro que se pretende editar
     * @param value novo valor do parametro
     * @return true - parametro editado, false - parametro não editado
     */
    @Override
    public boolean editarDouble(String parametro, double value){
        if(super.editarDouble(parametro, value))
            return true;
        if(parametro.equalsIgnoreCase("Número de Cafés vendidos por dia")){
            this.setNumCafes((int)value);
            //st.atualizaFichObj(fObj);
            return true;
        }
        return false;
    }
    
   
}
