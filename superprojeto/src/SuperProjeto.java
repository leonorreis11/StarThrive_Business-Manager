/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//NOTA: SE FOR NULL
//NOTA: maior capacidade das empresas restauração: 2 restaurantes com maior nº de mesas
//NOTA: localização e verificação da localização
 //NOTAS: ASSEGURAR ISTO DUAS EMPRESAS PODEM TER O MESMO NOME SE NÃO FOREM DA MESMA CATEGORIA

//package superprojeto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author User
 */
public class SuperProjeto extends JFrame implements Serializable {
    //Atributos
    private GestorEmpresas starThrive;
    private GuiCafe guiCafe;    //interface inserir um café
    private GuiPastelaria guiPast;  //interface inserir uma pastelaria
    private GuiFrutaria guiFrutaria;    //interface inserir uma frutaria
    private GuiMercado guiMercado;    //interface inserir um mercado
    private GuiRestauranteLocal guiRestL; //interface inserir um restaurante local
    private GuiRestauranteFastFood guiRestFf; //interface inserir um restaurante fast food
    private GuiEditarEmpresa guiEditar; //interface para editar empresa
    private GuiApagar guiApagar; //interface para editar empresa
    private JLabel label1, label2, result;
    private JTextField text1, text2;
    private JButton buttonAction, buttonSair;
    private JPanel panel;
    private JComboBox jComboBoxAction;
    
    public SuperProjeto() {
        super();
        //Gestor de empresas
        starThrive = new GestorEmpresas();
        File fObj = new File("starthrive.dat");

        if (fObj.exists() && fObj.isFile()) {
            starThrive.adicionaFichObj(fObj);
        } else {
            starThrive.fichTextoEmpresas(fObj);
        }
        //Adicionar empresas
        /*
        Empresa c= new Cafe("Cartola", "Coimbra", new Localizacao(20.0, 30.0), 400,30,7200,650,500);
        Cafe c1= new Cafe("Beira Mar", "Aveiro", new Localizacao(20.0, 30.0), 305,5,3000,100,50);
        Pastelaria p= new Pastelaria( "Vénus", "Coimbra", new Localizacao(20.0, 30.0), 600,8,9600,200,150);
        Pastelaria p1= new Pastelaria("Pão Doce", "Coimbra", new Localizacao(20.0, 30.0),600,12,9600,200,150);
        RestauranteLocal rl = new RestauranteLocal("SeaFood", "Leiria", new Localizacao(20.0, 30.0), 10,15,7800,15,330,20,10,100);
        RestauranteLocal rl1 = new RestauranteLocal("Caldo Verde", "Seixal", new Localizacao(20.0, 30.0), 10,15,7800,15,330,20,10,100);
        RestauranteLocal rl2 = new RestauranteLocal("Marquês", "Leiria", new Localizacao(20.0, 30.0), 10,15,7800,15,330,50,50,100);
        RestauranteFastFood rff = new RestauranteFastFood("TacoBells", "Lisboa", new Localizacao(20.0, 30.0), 20,50,9600,1000,360,30,500,30);
        RestauranteFastFood rff1 = new RestauranteFastFood("Pizza Hut", "Porto", new Localizacao(20.0, 30.0), 20,25,10800,50,365,5,300,20);
        RestauranteFastFood rff2 = new RestauranteFastFood("McDonalds", "Vilamoura", new Localizacao(20.0, 30.0), 20,25,10800,60,365,50,600,20);
        starThrive.adicionarEmpresa(c);
        starThrive.adicionarEmpresa(c1);
        starThrive.adicionarEmpresa(p);
        starThrive.adicionarEmpresa(p1);
        starThrive.adicionarEmpresa(rff);
        starThrive.adicionarEmpresa(rff1);
        starThrive.adicionarEmpresa(rff2);
        starThrive.adicionarEmpresa(rl);
        starThrive.adicionarEmpresa(rl1);
        starThrive.adicionarEmpresa(rl2);
        */
        //label
        label2 = new JLabel("Escolha a operação pretendida"); 
        label2.setBounds(50,50,200,25);
        
        //Action type list
        String[] types = {"Listar empresas", "Criar café","Criar pastelaria", "Criar restaurante local", 
         "Criar restaurante fast-food","Criar frutaria", "Criar mercado", "Editar empresa", "Apagar empresa", "Listar os 2 maiores restaurantes", 
        "Relatório cafés", "Relatório pastelarias","Relatório restaurantes locais",
        "Relatório restaurantes fast-food","Relatório frutaria", "Relatório mercado"};
        jComboBoxAction= new JComboBox(types);
        jComboBoxAction.setBounds(50, 75, 300,25);
        
        //Botão de ação
        buttonAction = new JButton("Escolher"); 
        buttonAction.setBounds(50, 110, 100,25);
        
        //Botão de sair
        buttonSair = new JButton("SAIR"); 
        buttonSair.setBounds(160, 110, 100,25);
        
        
        JPanel panel = new JPanel();                //Adicionar ao panel1 os elementos
        panel.setLayout(null);
        panel.add(label2);
        panel.add(jComboBoxAction);  
        panel.add(buttonAction);
        panel.add(buttonSair);
        
        buttonAction.addActionListener(new ButtonListener());
        buttonSair.addActionListener(new ButtonListener());
        this.add(panel);                //Adicionar o panel à frame

    }
    
    public static void main(String[] args) {
        /*int escolha;
        Scanner stdin = new Scanner(System.in);
        System.out.println("\nBem-vindo ao MELHOR gestor de empresas StarThrive!\n");
        do {// Menu
            System.out.println("1 - Listar TODAS as empresas");
            System.out.println("2 - Listar as PASTELARIAS com maior receita anual, com menor despesa anual e maior lucro anual");
            System.out.println("3 -  Listar os CAFÉS com maior receita anual, com menor despesa anual e maior lucro anual");
            System.out.println("4 -  Listar os Restaurante Locais com maior receita anual, com menor despesa anual e maior lucro anual");
            System.out.println("5 -  Listar os Restaurantes FastFood com maior receita anual, com menor despesa anual e maior lucro anual");
            System.out.println("6 -  Listar os dois MAIORES restaurantes");     
            System.out.println("0 - Sair");
            escolha = stdin.nextInt();
            switch (escolha) {
                case 1: StarThrive.listarEmpresas(); break;
                case 2: StarThrive.relatorio("Pastelaria"); break;
                case 3: StarThrive.relatorio("Café"); break;
                case 4: StarThrive.relatorio("Restaurante Local"); break;
                case 5: StarThrive.relatorio("Restaurante Fast Food"); break;
                case 6: StarThrive.apresentarMaioresRestaurantes(); break;
                case 0: System.exit(0);
            }
        } while (escolha != 0);       
        stdin.close();*/
        
        // Mensage
        if(JOptionPane.showConfirmDialog(null, "Bem-vindo à StarThrive!\nDeseja começar?", "Mensagem", JOptionPane.YES_NO_OPTION)==0){ 
            SuperProjeto janela = new SuperProjeto();
            janela.setTitle("StarThrive - Gestor de empresas");
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            janela.setSize(400, 300); 
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        }else{
            System.exit(0);
        }
    }
    // Inner class
    private class ButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonAction) {
                String str; //auxiliar
                try{
                    switch (jComboBoxAction.getSelectedIndex ()) {
                        case 0: //listar empresas
                            JTextArea textArea = new JTextArea(30, 50);
                            textArea.setText(str=starThrive.listarEmpresas());
                            textArea.setEditable(false);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Lista de empresas",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas no sistema.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 1:
                            guiCafe = new GuiCafe(starThrive);
                            guiCafe.setTitle("Criar um Café");
                            guiCafe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            guiCafe.setSize(700, 350);
                            guiCafe.setLocationRelativeTo(null);
                            guiCafe.setVisible(true);
                            break;
                        case 2:
                            guiPast = new GuiPastelaria(starThrive);
                            guiPast.setTitle("Criar uma pastelaria");
                            guiPast.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            guiPast.setSize(700, 400); 
                            guiPast.setLocationRelativeTo(null);
                            guiPast.setVisible(true);
                            break;
                        case 3:
                            guiRestL = new GuiRestauranteLocal(starThrive);
                            guiRestL.setTitle("Criar um restaurante local");
                            guiRestL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            guiRestL.setSize(600, 400); 
                            guiRestL.setLocationRelativeTo(null);
                            guiRestL.setVisible(true);
                            break;
                        case 4:
                            guiRestFf = new GuiRestauranteFastFood(starThrive);
                            guiRestFf.setTitle("Criar um restaurante fast-food");
                            guiRestFf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            guiRestFf.setSize(700, 450);
                            guiRestFf.setLocationRelativeTo(null);
                            guiRestFf.setVisible(true);
                            break;
                        case 5:
                            guiFrutaria = new GuiFrutaria(starThrive);
                            guiFrutaria.setTitle("Criar uma frutaria");
                            guiFrutaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            guiFrutaria.setSize(400, 300);
                            guiFrutaria.setLocationRelativeTo(null);
                            guiFrutaria.setVisible(true);
                            break;
                        case 6:
                            guiMercado = new GuiMercado(starThrive);
                            guiMercado.setTitle("Criar um mercado");
                            guiMercado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            guiMercado.setSize(700, 400);
                            guiMercado.setLocationRelativeTo(null);
                            guiMercado.setVisible(true);
                            break;
                            
                        case 7:
                            guiEditar = new GuiEditarEmpresa(starThrive);
                            guiEditar.setTitle("Editar Empresa");
                            guiEditar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            guiEditar.setSize(500, 200);
                            guiEditar.setLocationRelativeTo(null);
                            guiEditar.setVisible(true);
                            break;
                        case 8:
                            guiApagar = new GuiApagar(starThrive);
                            guiApagar.setTitle("Apagar Empresa");
                            guiApagar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                            guiApagar.setSize(400, 150);
                            guiApagar.setLocationRelativeTo(null);
                            guiApagar.setVisible(true);
                            break;
                        case 9:
                            textArea = new JTextArea(5, 40);
                            textArea.setText(str=starThrive.apresentarMaioresRestaurantes());
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals("0"))
                                JOptionPane.showMessageDialog(null, scrollPane,"MAIORES restaurantes",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "A empresa não está registada no sistema.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 10:
                            textArea = new JTextArea(10, 40);
                            textArea.setText(str=starThrive.relatorio("Cafe"));
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Café com maior receita, menor despesa e maior lucro",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas da categoria café.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 11:
                            textArea = new JTextArea(10, 40);
                            textArea.setText(str=starThrive.relatorio("Pastelaria"));
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Pastelaria com maior receita, menor despesa e maior lucro",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas da categoria pastelaria.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 12:
                            textArea = new JTextArea(10, 40);
                            textArea.setText(str=starThrive.relatorio("RestauranteLocal"));
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Restaurante Local com maior receita, menor despesa e maior lucro",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas da categoria restaurante local.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 13:
                            textArea = new JTextArea(10, 40);
                            textArea.setText(str=starThrive.relatorio("RestauranteFastFood"));
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Restaurante fast-food com maior receita, menor despesa e maior lucro",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas da categoria restaurante fast-food.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 14:
                            textArea = new JTextArea(10, 40);
                            textArea.setText(str=starThrive.relatorio("Frutaria"));
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Frutaria com maior receita, menor despesa e maior lucro",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas da categoria frutaria.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                        case 15:
                            textArea = new JTextArea(10, 40);
                            textArea.setText(str=starThrive.relatorio("Mercado"));
                            textArea.setEditable(false);
                            scrollPane = new JScrollPane(textArea);
                            if(!str.equals(""))
                                JOptionPane.showMessageDialog(null, scrollPane,"Mercado com maior receita, menor despesa e maior lucro",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Não existem empresas registadas da categoria mercado.", "Erro", JOptionPane.ERROR_MESSAGE); 
                            break;
                    }
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Os campos têm que ser numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro a fazer as contas!", "Erro", JOptionPane.ERROR_MESSAGE);
                    result.setText("");
                }
            }else if(e.getSource() == buttonSair){
                if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        }
    }
}
    
