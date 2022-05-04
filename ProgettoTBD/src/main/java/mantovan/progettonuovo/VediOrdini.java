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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Luana
 */
public class VediOrdini extends javax.swing.JPanel {
    Connection conn;
    /**
     * Creates new form VediOrdini
     */
    public VediOrdini(Connection conn) {
        initComponents();
        this.conn= conn;
        riempiOrdiniList();
    }

    public void riempiOrdiniList(){
        String queryString = "SELECT COD_ORDINE FROM ORDINE";
        int i = 1;
        DefaultListModel model = new DefaultListModel();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);           
            while(rs.next()){
                String s = String.valueOf(i) + "- Ordine: "+rs.getString("COD_ORDINE");
                i++;
                model.addElement(s);
            }
            numeroOrdine.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        contenutoOrdine = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        numeroOrdine = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(750, 600));

        contenutoOrdine.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        contenutoOrdine.setEnabled(false);
        jScrollPane1.setViewportView(contenutoOrdine);

        numeroOrdine.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        numeroOrdine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroOrdineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(numeroOrdine);

        jLabel1.setText("Ordini effettuati:");

        jLabel2.setText("Contenuto dell'ordine selezionato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void riempiContenutoList(){
        String codOrdine = numeroOrdine.getSelectedValue()
                .substring(numeroOrdine.getSelectedValue().indexOf(":")+2);
        String queryString = "SELECT COD_PROD_ORD AS COD, QUANTITA, NOME "
                + "FROM PRODOTTO_ORDINE WHERE PRODOTTO_ORDINE.COD_ORDINE = '" 
                + codOrdine + "'";
        DefaultListModel model = new DefaultListModel();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);           
            while(rs.next()){
                String cod = rs.getString("COD");
                int quantita = rs.getInt("QUANTITA");
                String nome = rs.getString("NOME");
                String s = String.valueOf(quantita) + "x: " + cod + " - " + nome;                
                model.addElement(s);
            }
            contenutoOrdine.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void numeroOrdineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroOrdineMouseClicked
       riempiContenutoList();
    }//GEN-LAST:event_numeroOrdineMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> contenutoOrdine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> numeroOrdine;
    // End of variables declaration//GEN-END:variables
}
