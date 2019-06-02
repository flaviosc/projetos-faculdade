/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframe;

import DAO.Country;
import DAO.JDBCCountryDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cynthia
 */
public class Editar extends javax.swing.JFrame {

    private Paises dados;
    
    public Editar() {
        initComponents();
        
    }
    
    public void populaCombobox(String name) throws ClassNotFoundException, SQLException{
        cboxContinentEdit.removeAllItems();
        cboxGovernmentForm.removeAllItems();
        cboxLinguas.removeAllItems();
        JDBCCountryDAO dao = new JDBCCountryDAO();
        List<Country> dados = dao.listarNome(name);
        for (Country list : dados) {
            for(int i = 0;i<list.getContinentesEnum().size(); i++ ){  
                String str = (String) list.getContinentesEnum().get(i);  
                cboxContinentEdit.addItem(str);  
           }
           
           String[] itensSeparados =  list.getGovernmentForm().split(",");
           for (String s : itensSeparados){
               cboxGovernmentForm.addItem(s);
           }
           
           
           String[] itens = list.getConcatenaOficial().split(",");
           for (String s : itens){
               cboxLinguas.addItem(s);
           }
            cboxContinentEdit.setSelectedItem(list.getContinent());
            cboxLinguas.setSelectedItem(list.getLanguagesOfficial());
        } 
    }
      
    
    public void EnviarDados(Paises dados, String localName, String name, 
                            String code2, String continent, String lifeExpectancy, String code) throws ClassNotFoundException, SQLException {
        txtCode2Edit.setEditable(false);
        txtLocalNameEdit.setText(localName);
        txtNameEdit.setText(name);
        txtCode2Edit.setText(code2);
        
        if (txtCode2Edit.getText().isEmpty()) {
            txtCode2Edit.setEditable(true);
        }        
        
        txtLifeExpectancyEdit.setText(lifeExpectancy);
        populaCombobox(name);
        txtCodigoPais.setText(code);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLocalNameEdit = new javax.swing.JTextField();
        txtNameEdit = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboxContinentEdit = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboxGovernmentForm = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtLifeExpectancyEdit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCode2Edit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnCancelarEdit = new javax.swing.JButton();
        lblCodigoPais = new javax.swing.JLabel();
        txtCodigoPais = new javax.swing.JTextField();
        cboxLinguas = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));

        jLabel1.setText("Nome Local: ");

        jLabel2.setText("Nome:");

        txtLocalNameEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalNameEditActionPerformed(evt);
            }
        });

        txtNameEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameEditActionPerformed(evt);
            }
        });

        btnEditar.setText("Ok");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel3.setText("Continente:");

        cboxContinentEdit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        cboxContinentEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxContinentEditActionPerformed(evt);
            }
        });

        jLabel4.setText("Forma de Governo:");

        cboxGovernmentForm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        cboxGovernmentForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxGovernmentFormActionPerformed(evt);
            }
        });

        jLabel5.setText("Expectativa de Vida:");

        txtLifeExpectancyEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLifeExpectancyEditActionPerformed(evt);
            }
        });

        jLabel6.setText("Código Alternativo: ");

        txtCode2Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCode2EditActionPerformed(evt);
            }
        });

        jLabel7.setText("Línguas Oficiais: ");

        btnCancelarEdit.setText("Cancelar");
        btnCancelarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEditActionPerformed(evt);
            }
        });

        lblCodigoPais.setText("Código Pais:");

        txtCodigoPais.setEditable(false);
        txtCodigoPais.setBorder(null);
        txtCodigoPais.setEnabled(false);
        txtCodigoPais.setVerifyInputWhenFocusTarget(false);
        txtCodigoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPaisActionPerformed(evt);
            }
        });

        cboxLinguas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        cboxLinguas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxLinguasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCodigoPais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoPais, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarEdit)
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCode2Edit)
                                .addComponent(cboxLinguas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboxGovernmentForm, 0, 196, Short.MAX_VALUE)
                                .addComponent(cboxContinentEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLifeExpectancyEdit)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(86, 86, 86)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLocalNameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addComponent(txtNameEdit))))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoPais, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lblCodigoPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLocalNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxContinentEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboxGovernmentForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLifeExpectancyEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCode2Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboxLinguas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelarEdit))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocalNameEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalNameEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalNameEditActionPerformed

    private void txtNameEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameEditActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            Country country = new Country();
            
            country.setCode(this.txtCodigoPais.getText());
            
            country.setLocalName(this.txtLocalNameEdit.getText());
            country.setName(this.txtNameEdit.getText());
            country.setContinent(this.cboxContinentEdit.getSelectedItem().toString());
            country.setGovernmentForm(this.cboxGovernmentForm.getSelectedItem().toString());
            country.setLifeExpectancy(Float.parseFloat(this.txtLifeExpectancyEdit.getText()));
            country.setCode2(this.txtCode2Edit.getText());     
            JDBCCountryDAO countryDao = new JDBCCountryDAO();
            int resultado = countryDao.alterar(country);
            System.out.println(resultado);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(rootPane, "País alterado com sucesso!");
            }     
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEditActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarEditActionPerformed

    private void txtLifeExpectancyEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLifeExpectancyEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLifeExpectancyEditActionPerformed

    private void cboxGovernmentFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxGovernmentFormActionPerformed
    
    }//GEN-LAST:event_cboxGovernmentFormActionPerformed

    private void cboxContinentEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxContinentEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxContinentEditActionPerformed

    private void txtCode2EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCode2EditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCode2EditActionPerformed

    private void txtCodigoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPaisActionPerformed

    private void cboxLinguasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxLinguasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxLinguasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarEdit;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox cboxContinentEdit;
    private javax.swing.JComboBox cboxGovernmentForm;
    private javax.swing.JComboBox cboxLinguas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCodigoPais;
    private javax.swing.JTextField txtCode2Edit;
    private javax.swing.JTextField txtCodigoPais;
    private javax.swing.JTextField txtLifeExpectancyEdit;
    private javax.swing.JTextField txtLocalNameEdit;
    private javax.swing.JTextField txtNameEdit;
    // End of variables declaration//GEN-END:variables
}
