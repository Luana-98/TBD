/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantovan.progettonuovo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;

/**
 *
 * @author Luana
 */
public class EliminaOrdini extends javax.swing.JPanel {
    Connection conn;
    CheckBoxList eliminaList;
    /**
     * Creates new form EliminaOrdini
     */
    public EliminaOrdini(Connection conn) {
        initComponents();
        this.conn = conn;
        riempiLista();
    }

    public void riempiLista(){
        String queryString = "SELECT COD_ORDINE FROM ORDINE";
        int i = 1;
        eliminaList = new CheckBoxList();
        jScrollPane3.setViewportView(eliminaList);
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);           
            while(rs.next()){
                String s = String.valueOf(i) + "- Ordine: "+rs.getString("COD_ORDINE");
                i++;
                eliminaList.addCheckbox(new JCheckBox(s));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        confirmDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        eliminaButton = new javax.swing.JButton();

        confirmDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel1.setText("Sei sicuro di voler annullare gli ordini selezionati?");

        yesButton.setText("SI");
        yesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesButtonMouseClicked(evt);
            }
        });

        noButton.setText("NO");
        noButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout confirmDialogLayout = new javax.swing.GroupLayout(confirmDialog.getContentPane());
        confirmDialog.getContentPane().setLayout(confirmDialogLayout);
        confirmDialogLayout.setHorizontalGroup(
            confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmDialogLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(noButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yesButton)
                .addGap(60, 60, 60))
            .addGroup(confirmDialogLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        confirmDialogLayout.setVerticalGroup(
            confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmDialogLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(confirmDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesButton)
                    .addComponent(noButton))
                .addGap(89, 89, 89))
        );

        eliminaButton.setText("Elimina");
        eliminaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminaButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(eliminaButton)
                .addGap(59, 59, 59))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(460, Short.MAX_VALUE)
                .addComponent(eliminaButton)
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eliminaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminaButtonMouseClicked
        confirmDialog.setVisible(true);
        confirmDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_eliminaButtonMouseClicked

    private void noButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noButtonMouseClicked
        confirmDialog.dispose();
    }//GEN-LAST:event_noButtonMouseClicked

    private void esegui(){
        //questa procedura serve per eliminare gli elementi selezionati
        java.util.List l = eliminaList.getCheckedItems();
        for(int i = 0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
    }
    
    private void yesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesButtonMouseClicked
        esegui();
        confirmDialog.dispose();
    }//GEN-LAST:event_yesButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog confirmDialog;
    private javax.swing.JButton eliminaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton noButton;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}