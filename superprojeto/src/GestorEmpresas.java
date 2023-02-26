/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;
import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */
public class GestorEmpresas implements Serializable {

    /**
     * Lista de empresas
     */
    private ArrayList<Empresa> listaEmpresas;


    /**
     * Construtor da classe que inicializa o ArrayList
     */
    public GestorEmpresas() {
        listaEmpresas = new ArrayList<>();
        //addListaEmpresas();
    }

    /**
     * Obter lista de empresas
     *
     * @return empresas
     */
    protected ArrayList<Empresa> getEmpresas() {
        return listaEmpresas;
    }


    /**
     * Definir lista de empresas
     *
     * @param listaEmpresas Lista de empresas
     */
    protected void setEmpresas(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }




    /**
     * Adicionar dados provenientes dos ficheiros de objetos
     *
     * @param fObj Ficheiro de objetos de empresas
     */
    protected void adicionaFichObj(File fObj) {
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream(fObj);
            ois = new ObjectInputStream(fis);
            setEmpresas((ArrayList<Empresa>) ois.readObject());
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro de objetos.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro de objetos.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }


    /**
     * Adicionar dados provenientes dos ficheiros de texto
     *
     * @param fObj Ficheiro de objetos de empresas
     */


    public void fichTextoEmpresas(File fObj){
        File f;
        FileOutputStream fos;
        ObjectOutputStream oos;

        f = new File("starthrive.txt");

        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;


                while((line = br.readLine()) != null) {
                    String[] parts = line.split(";");

                    Empresa e;


                    if(parts[0].compareTo("Cafe") == 0){

                        e = new Cafe(parts[1], parts[2], new Localizacao(parts[3], parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]));
                        adicionarEmpresa(e);
                    }

                    else if(parts[0].compareTo("Pastelaria") ==0){
                        e = new Pastelaria(parts[1], parts[2], new Localizacao(parts[3], parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]));
                        adicionarEmpresa(e);
                    }

                    else if(parts[0].compareTo("Mercado") == 0){

                        e = new Mercado(parts[1], parts[2], new Localizacao(parts[3], parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), parts[7], Integer.parseInt(parts[8]));
                        adicionarEmpresa(e);
                    }

                    else if(parts[0].compareTo("Frutaria") == 0){

                        e = new Frutaria(parts[1], parts[2], new Localizacao(parts[3], parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                        adicionarEmpresa(e);
                    }

                    else if(parts[0].compareTo("RestauranteLocal") == 0){

                        e = new RestauranteLocal(parts[1], parts[2], new Localizacao(parts[3], parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10]), Integer.parseInt(parts[11]), Integer.parseInt(parts[12]));
                        adicionarEmpresa(e);
                    }

                    else if(parts[0].compareTo("RestauranteFastFood") == 0){

                        e = new RestauranteFastFood(parts[1], parts[2], new Localizacao(parts[3], parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10]), Integer.parseInt(parts[11]), Integer.parseInt(parts[12]));
                        adicionarEmpresa(e);
                    }

                    //escrever o produto no ficheiro objeto
                    //assert e != null;
                    //System.out.println(e.getNome());
                    //oos.writeObject(e);
                    //System.out.println(e.getNome());
                    //System.out.println(e.getDistrito());
                    //System.out.println(e.getCategoria());
                    //System.out.println(e.getLoc());
                    //System.out.println(e.getValorFaturacao());

                    //aux.add(e);


                }
                //System.out.println(aux.get(1).getNome());
                //for(int i = 0; i < aux.size(); i++){
                //oos.writeObject(aux);
                //}

                //fechar
                br.close();

            } catch (IOException e) {
                System.out.println("Erro a ler ficheiro de empresas!");
            }
            try {
                fos = new FileOutputStream(fObj);
                oos = new ObjectOutputStream(fos);
                //System.out.println(getEmpresas().get(1));
                oos.writeObject((ArrayList<Empresa>) getEmpresas());
                oos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a criar ficheiro de objetos");
            } catch (IOException ex) {
                System.out.println("Erro a escrever para o ficheiro de objetos");
            }
        } else {
            System.out.println("Ficheiro de empresas não existe!");
        }
    }


    /**
     * Atualizar o ficheiro de objetos
     *
     * @param fObj Ficheiro de objetos
     */
    protected void atualizaFichObj(File fObj) {
        fObj.delete();
        File f = new File("starthrive.dat");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject((ArrayList<Empresa>) getEmpresas());
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro de objetos");
        } catch (IOException ex) {
            System.out.println("Erro 2 a escrever para o ficheiro de objetos");
        }
    }


/*
    public void addListaEmpresas(){


        File f = new File("starthrive.dat");
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            //Percorrer o ficheiro de objeto
            while(fis.available()>0){
                Empresa e = (Empresa) ois.readObject();
                //listaEmpresas.addAll((ArrayList<Empresa>)ois.readObject());
                //System.out.println(listaEmpresas.get(1).getNome());
                System.out.println(e.getNome());
                //adicionar à lista de produtos
                listaEmpresas.add(e);

            }
            //fechar ambos o ficheiro
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }
*/









    
    /**
     * Método: recebe a empresa e adiciona-a à lista de empresas
     * @param e Empresa a adicionar
     */
    public void adicionarEmpresa(Empresa e){
        //adicionar empresa à lista
        listaEmpresas.add(e);
        System.out.println("Empresa adicionada com sucesso.");
    }
    
    /**
     * Método que verifica se existe alguma empresa da mesma categoria com o mesmo nome
     * @param categoria Categoria da empresa
     * @param nome Nome da empresa
     * @return true - não existe nenhuma empresa da mesma categoria com o nome dado; false - caso contrário
     */
    public boolean verificaNome(String categoria, String nome){
        for(Empresa e : listaEmpresas){
            if(e.getNome().compareToIgnoreCase(nome)==0)
                if(e.getCategoria().equals(categoria)){
                    return false;
                }

        }
        return true;
    }
    
    /**
     * Método que recebe o nome e categoria de uma empresa e apaga da lista de empresas
     * @param categoria Categoria da empresa
     * @param nome Nome da empresa
     * @return TRUE-empresa apagada, FALSE - empresa não apagada
     */
    public boolean apagarEmpresa(String nome, String categoria){
        for(Empresa e : listaEmpresas){
            if(e.getNome().compareToIgnoreCase(nome)==0)
                if(e.getCategoria().equals(categoria)){
                    apagarEmpresaAux(e);
                    return true;
                }
        }
        return false;
    }
    
    /**
     * Método: recebe a empresa e adiciona-a à lista de empresas
     * @param e Empresa a adicionar
     */
    private void apagarEmpresaAux(Empresa e){
        //adicionar empresa à lista
        listaEmpresas.remove(e);
        System.out.println("Empresa apagada com sucesso.");
    }
    
    /**
     * Método: Recebe o nome e categoria da empresa e devolve o objeto empresa correspondente
     * @param categoria Categoria da empresa
     * @param nome Nome da empresa
     * @return Empresa
     */
    public Empresa devolveEmp(String nome, String categoria){
        for(Empresa e : listaEmpresas){
            if(e.getNome().compareToIgnoreCase(nome)==0)
                if(e.getCategoria().equals(categoria)){
                    return e;
                }
        }
        return null;
    }
    
    
    /**
     * Método: devolve uma String com a lista de todas as empresas do StarThrive
     * @return String com a lista de todas as empresas do StarThrive
     */
    public String listarEmpresas(){ 
        String output="";
        //apresentar a lista de empresas
        for(Empresa e : listaEmpresas){
            output= output + e.toString();
            output= output + "\n";
        }
        return output;
    }
    

    /**
     * Método: apresenta o aior restaurante para além do restaurante dado como argumento
     * @param emp Restaurante com  a maior capacidade; Se for 1x, =null
     * @return Maior restaurante para além de emp
     */
    private Empresa apresentarMaiorRestaurante(Empresa emp){ 
        int capacidade=-1;
        Empresa maiorEmp=null;
        //Empresa maiorEmp = listaEmpresas.get(0); //inicializar
        for(Empresa e : listaEmpresas)
            if(e!=emp && e.devolveCapacidade()>capacidade){
                capacidade = e.devolveCapacidade();
                maiorEmp=e;
            }
        return maiorEmp;
    }
    
    /**
     * Método: apresenta as 2 empresas do tipo restauração com maior capacidade de clientes
     * @return 0 - não existem restuarantes; String com os 2 restaurantes com maior capacidade de clientes
     */
    public String apresentarMaioresRestaurantes(){ 
        Empresa maiorEmp = apresentarMaiorRestaurante(null);
        if(maiorEmp == null)
            return "0";
        Empresa segMaiorEmp = apresentarMaiorRestaurante(maiorEmp);
        
        String output="";
        output = output.concat("\nO 1º restaurante com maior capacidade é: "+  maiorEmp.getNome()+ " (" + maiorEmp.devolveCapacidade() + " lugares)\n");
        if(segMaiorEmp==null)
            return output;
        output = output.concat("O 2º restaurante com maior capacidade é: "+  segMaiorEmp.getNome()+ " (" + segMaiorEmp.devolveCapacidade() + " lugares)\n");
        
        return output;
    }
    
    /**
     * Método: apresenta a empresa com maior lucro anual
     * @param categoria Categoria da empresa
     */
    public String apresentaMaiorLucro(String categoria){
        String output="";
        boolean control=false; 
        double maiorLuc=0; 
        Empresa maiorlucEmp=null;
        for(Empresa e : listaEmpresas)
            if(e.getCategoria().equals(categoria)){ //encontrada empresa da mesma categoria
                if(!control){
                    maiorLuc=e.calculaLucro(); //se for a 1x
                    maiorlucEmp=e;
                    control=true;
                }
                if(control && e.calculaLucro() > maiorLuc){
                   maiorLuc = e.calculaLucro();
                   maiorlucEmp=e;
                }
            }
        
        if(maiorlucEmp!=null)
            output= output.concat("\n* " + categoria + " com maior lucro anual: "+  maiorlucEmp.getNome()+ " ("+ maiorLuc+ "€)\n");
        return output;
    }
    
    
    /**
     * Método: apresenta a empresa com menor despesa anual
     * @param categoria Categoria da empresa
     * @return 
     */
    public String apresentaMenorDespesa(String categoria){
        String output="";
        boolean control=false; 
        double minDesp=0; 
        Empresa minDespEmp=null;
        for(Empresa e : listaEmpresas)
            if(e.getCategoria().equals(categoria)){ //encontrada empresa da mesma categoria
                if(!control){
                    minDesp=e.calculaDespesa(); //se for a 1x
                    minDespEmp=e;
                    control=true;
                }
                if(control && e.calculaDespesa() < minDesp){
                   minDesp = e.calculaDespesa();
                   minDespEmp=e;
                }
            }
        
        if(minDespEmp!=null)
            output= output.concat("\n* " + categoria + " com menor despesa anual: "+  minDespEmp.getNome()+ " ("+ minDesp + "€)\n");
        return output;
    }
    
    /**
     * Método: apresenta a empresa com maior receita anual
     * @param categoria Categoria da empresa
     * @return 
     */
    
    /* 1.Percorremos a lista de empresas
     * 2. Encontramos pela 1x alguma empresa da mesma categoria inicializamos a minDesp
     * 3. Se encontrarmos alguma empresa da mesma categoria com menor despesa, atualizamos a minDesp*/
    public String apresentaMaiorReceita(String categoria){
        String output="";
        boolean control=false; 
        double maxRec=0; 
        Empresa maxRecEmp=null;
        for(Empresa e : listaEmpresas)
            if(e.getCategoria().equals(categoria)){ //encontrada empresa da mesma categoria
                if(!control){
                    maxRec=e.calculaReceita(); //se for a 1x
                    maxRecEmp=e;
                    control=true;
                }
                if(control && e.calculaReceita() > maxRec){
                   maxRec = e.calculaReceita();
                   maxRecEmp=e;
                }
            }
        
        if(maxRecEmp!=null)
            output=output.concat("\n* " + categoria + " com maior receita anual: "+  maxRecEmp.getNome()+ " ("+ maxRec+ "€)\n");
        return output;
    }
    
    
    /**
     * Apresenta a empresa com mais receita, com mais lucro e com menor despesa de acordo com a categoria
     * @param categoria Categoria da empresa
     */
    public String relatorio(String categoria){
        String output="";
        output = output.concat(apresentaMaiorReceita(categoria));
        output = output.concat(apresentaMenorDespesa(categoria));
        output = output.concat(apresentaMaiorLucro(categoria));
        return output;
    }
    
}
