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
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class GuiMercado extends GuiCriarEmpresa implements Serializable {
    //Atributos
    private JLabel labelTipo, labelArea, labelCustoLimpeza, labelVazia;
    private JTextField textTipo, textArea, textCustoLimpeza;

    public GuiMercado(GestorEmpresas StarThrive){
        super(StarThrive);
        labelFat = new JLabel("Valor médio de faturação anual\n por metro quadrado: ");
        labelTipo = new JLabel("Tipo de mercado: ");
        textTipo = new JTextField(10);
        labelArea = new JLabel("Area do mercado (m2): ");
        textArea = new JTextField(10);
        labelCustoLimpeza = new JLabel("Custo anual de limpeza do estabelecimento: ");
        textCustoLimpeza = new JTextField(10);


        JPanel panel = new JPanel();                //Adicionar ao panel1 os elementos
        panel.setLayout(new GridLayout(9, 3));
        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelDistrito);
        panel.add(textDistrito);
        panel.add(labelAlt);
        panel.add(textAlt);
        panel.add(labelLong);
        panel.add(textLong);
        panel.add(labelFat);
        panel.add(textFat);
        panel.add(labelTipo);
        panel.add(textTipo);
        panel.add(labelArea);
        panel.add(textArea);
        panel.add(labelCustoLimpeza);
        panel.add(textCustoLimpeza);



        buttonSair.setBounds(200, 170, 100, 25);
        buttonSair.setBounds(200, 170, 100, 25);
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
                    if(!(textNome.getText().equals("")) && !(textDistrito.getText().equals(""))
                            && !(textAlt.getText().equals("")) && !(textLong.getText().equals(""))
                            && !(textFat.getText().equals("")) && !(textTipo.getText().equals(""))
                            && !(textArea.getText().equals("")) && !(textCustoLimpeza.getText().equals("")) ){

                        String nome = textNome.getText();
                        if(StarThrive.verificaNome("Mercado", nome)){

                            String valAl = textAlt.getText();
                            String valLong = textLong.getText();
                            double valFat = Double.parseDouble(textFat.getText());
                            String tipo = textTipo.getText();
                            int numArea = Integer.parseInt(textArea.getText());
                            int numCustoLimpeza = Integer.parseInt(textCustoLimpeza.getText());

                            Mercado merc = new Mercado(nome, textDistrito.getText(), new Localizacao(valAl, valLong), valFat, numCustoLimpeza, tipo, numArea);
                            StarThrive.adicionarEmpresa(merc);
                            StarThrive.atualizaFichObj(fObj);
                            JOptionPane.showMessageDialog(null, "Empresa registada com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                        }else
                            JOptionPane.showMessageDialog(null, "Não é possível a utilização do nome inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Todos os parâmetros são de preenchimento obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException ex) {
                    textAlt.setBackground(Color.red);
                    textLong.setBackground(Color.red);
                    textFat.setBackground(Color.red);
                    textArea.setBackground(Color.red);
                    textAlt.setText("");
                    textLong.setText("");
                    textAlt.setText("");
                    textArea.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Valores inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro na criação da empresa.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else if(e.getSource() == buttonSair){
                if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                    System.exit(0);
                }
            }
        }
    }

}
