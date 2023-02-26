/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package superprojeto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class GuiApagar extends JFrame implements Serializable {

    File fObj = new File("starthrive.dat");

    //Atributos
    protected GestorEmpresas StarThrive;
    protected JComboBox jComboCategoria, jComboParametro;
    protected JLabel labelCategoria,labelNome, labelParametro, labelNewValue; 
    protected JTextField textNome, textNewValue;
    protected JButton buttonAdd, buttonSair;
    
    public GuiApagar(GestorEmpresas StarThrive){
        this.StarThrive=StarThrive;
        labelCategoria = new JLabel("Categoria:");    
        labelNome = new JLabel("Nome:");    
        textNome = new JTextField(10);          
        String[] types = {"Cafe", "Pastelaria","RestauranteLocal", "RestaurantesFastFood","Frutaria", "Mercado"};
        jComboCategoria= new JComboBox(types);
        
        buttonAdd = new JButton("Apagar"); //Botão de criar empresa
        buttonSair = new JButton("SAIR"); //Botão de sair
        
        
        JPanel panel = new JPanel();                //Adicionar ao panel1 os elementos
        panel.setLayout(new GridLayout(2, 2));
        panel.add(labelCategoria);
        panel.add(jComboCategoria);
        panel.add(labelNome);
        panel.add(textNome);
        panel.add(buttonAdd);
        
        buttonSair.setBounds(200, 170, 100, 25);
        buttonAdd.setBounds(150,170,100,25);
        JPanel panel2 = new JPanel();    
        panel2.add(buttonAdd);
        panel2.add(buttonSair);
        
        // Main panel - BorderLayout
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.add(panel, BorderLayout.CENTER);
        panelMain.add(panel2, BorderLayout.SOUTH);

        buttonAdd.addActionListener(new ButtonListener());
        buttonSair.addActionListener(new ButtonListener());
        this.add(panelMain);                   
    }
    
    // Inner class
    private class ButtonListener implements ActionListener {    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buttonAdd) {
                try{
                    String categoria="";
                    switch (jComboCategoria.getSelectedIndex ()) {
                        case 0:
                            categoria = "Cafe";
                            break;
                        case 1:
                            categoria = "Pastelaria";
                            break;
                        case 2:
                            categoria = "RestauranteLocal";
                            break;
                        case 3:
                            categoria = "RestauranteLocal";
                            break;
                        case 4:
                            categoria = "RestauranteFastFood";
                            break;
                        case 5:
                            categoria = "Frutaria";
                            break;
                        case 6:
                            categoria =  "Mercado";
                            break;
                    }
                    boolean control = StarThrive.apagarEmpresa(textNome.getText(),categoria);
                    if(control) {
                        StarThrive.atualizaFichObj(fObj);
                        JOptionPane.showMessageDialog(null, "Empresa apagada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "A empresa não está registada no sistema." , "Erro", JOptionPane.ERROR_MESSAGE);
                        textNome.setText("");
                    }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro a apagar a empresa!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else if(e.getSource() == buttonSair){
                if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        }
    }
}
