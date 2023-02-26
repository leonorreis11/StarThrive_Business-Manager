/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Empresa implements Serializable {


    File fObj = new File("starthrive.dat");

    //Atributos
    private String categoria;
    private String nome;
    private String distrito;
    private Localizacao loc;      
    protected double valorFaturacao;
    
    /**
    * Construtor da classe por omissão
    */
    public Empresa(){
    }
    
    /**
     * Método construtor da classe
     * @param categoria Categoria da empresa
     * @param nome Nome da empresa
     * @param distrito Distrito da empresa
     * @param loc Localização da empresa
     * @param valorFaturacao Valor médio de faturação anual
     */
    public Empresa(String categoria, String nome, String distrito, Localizacao loc, double valorFaturacao){
        this.categoria=categoria;
        this.nome=nome;
        this.distrito=distrito;
        this.loc=loc;
        this.valorFaturacao=valorFaturacao;
    }
    
    /**
    * Método de acesso externo à categoria da empresa
    * @return Categoria da empresa 
    */
    public String getCategoria() {
        return categoria;
    }
    
    /**
    * Método de alteração externa à categoria
    * @param categoria Categoria da Empresa
    */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    /**
    * Método de acesso externo ao nome
    * @return Nome da empresa 
    */
    public String getNome() {
        return nome;
    }
    
    /**
    * Método de alteração externa ao nome
    * @param nome Nome da Empresa
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
    * Método de acesso externo ao distrito
    * @return Distrito da empresa 
    */
    public String getDistrito() {
        return distrito;
    }
    
    /**
    * Método de alteração externa ao distrito
    * @param distrito Distrito da Empresa
    */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    
    /**
    * Método de acesso externo à localização
    * @return Localização da empresa 
    */
    public Localizacao getLoc() {
        return loc;
    }
    
    /**
    * Método de alteração externa à localização
    * @param loc Localização da Empresa
    */
    public void setLoc(Localizacao loc) {
        this.loc = loc;
    }
    
    /**
    * Método de acesso externo ao valor de faturação
    * @return Valor médio anual de faturação da empresa 
    */
    public double getValorFaturacao() {
        return valorFaturacao;
    }
    
    /**
    * Método de alteração externa ao valor de faturação
    * @param valorFaturacao Valor médio anual de faturação da empresa 
    */
    public void setValorFaturacao(double valorFaturacao) {
        this.valorFaturacao = valorFaturacao;
    }
    
    /**
     * Calcula a despesa anual da empresa 
     * @return Despesa anual
     */
    public double calculaDespesa(){
        return -1;
    }
    
   /**
     * Calcula a receita anual da empresa 
     * @return Receita anual
     */
    public double calculaReceita(){
        return -1;
    }
    
    /**
     * Método utilizado no método LucrotoString() que auxilia no cálculo do lucro da empresa
     * @return lucro da Empresa
     */
    public double calculaLucro(){
        double lucro = calculaReceita() - calculaDespesa();
        return lucro;
    }
    
    /**
     * Devolve uma String que indica se a empresa teve lucro
     * @return "SIM" - teve lucro, "NÃO" - não teve lucro
     */
    private String lucroToString(){
        double lucro = calculaLucro();
        if(lucro>0)
            return "SIM";
        else
            return "NÃO";                
    }
    
    @Override
    public String toString() {
        return  "\nNome: " + nome + 
                "\nDistrito: " + distrito +
                "\nDespesa: " + calculaDespesa()+ '€'+ 
                "\nReceita: " + calculaReceita() + '€' + 
                "\nLucro: " +  lucroToString();
    }
    
    /**
     * Calcula a capacidade de clientes por dia do restaurante 
     * @return capacidade de clientes
     */
    public int devolveCapacidade(){
        return -1;
    }
    
    
    /**
     * Alterar o parametro do objeto
     * @param parametro parametro que se pretende editar
     * @param value novo valor do parametro
     * @return true - parametro editado, false - parametro não editado
     */
    public boolean editarDouble(String parametro, double value){
        if(parametro.equalsIgnoreCase("Valor Faturação")){
            this.setValorFaturacao(value);
            return true;
        }
        return false;

    }
    
    public boolean editarString(String parametro, String value){
        if(parametro.equalsIgnoreCase("Nome")){
            this.setNome(value);
            return true;
        }
        if(parametro.equalsIgnoreCase("Distrito")){
            this.setDistrito(value);
            return true;
        }
        return false;
    }
    
}
