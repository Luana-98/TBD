/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantovan.progettonuovo;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luana
 */
public class Guadagno extends javax.swing.JPanel {
    Connection conn;
    int q;
    float tot = (float) 0.0;
    /**
     * Creates new form Guadagno
     */
    public Guadagno(Connection conn) {
        initComponents();
        this.conn = conn;
        riempiGuadagnoTable();
    }

    public void riempiGuadagnoTable(){
        String prodottiQuery = "SELECT NOME, PREZZO, QUANTITA, BARCODE FROM PRODOTTO_NEGOZIO";
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(prodottiQuery);
            DefaultTableModel model = (DefaultTableModel) guadagnoTable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                String b = rs.getString("BARCODE");
                String s = rs.getString("NOME");
                double t = rs.getDouble("PREZZO");
                DecimalFormat df = new DecimalFormat("#.00");
                int q = rs.getInt("QUANTITA");   
                model.addRow(new Object[]{b, s, q, df.format(t)});
            }
        }
        catch(SQLException se){
            se.printStackTrace();
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

        guadagnoDialog = new javax.swing.JDialog();
        guadagnoSpinner = new javax.swing.JSpinner();
        okGuadagnoButton = new javax.swing.JButton();
        finaleDialog = new javax.swing.JDialog();
        jTextField1 = new javax.swing.JTextField();
        finaleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        guadagnoTable = new javax.swing.JTable();
        guadagnoButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        guadagnoList = new javax.swing.JList<>();

        okGuadagnoButton.setText("jButton1");
        okGuadagnoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okGuadagnoButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout guadagnoDialogLayout = new javax.swing.GroupLayout(guadagnoDialog.getContentPane());
        guadagnoDialog.getContentPane().setLayout(guadagnoDialogLayout);
        guadagnoDialogLayout.setHorizontalGroup(
            guadagnoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guadagnoDialogLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(guadagnoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guadagnoDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okGuadagnoButton)
                .addGap(51, 51, 51))
        );
        guadagnoDialogLayout.setVerticalGroup(
            guadagnoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guadagnoDialogLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(guadagnoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(okGuadagnoButton)
                .addGap(37, 37, 37))
        );

        jTextField1.setEditable(false);

        finaleButton.setText("Ok");
        finaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finaleButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout finaleDialogLayout = new javax.swing.GroupLayout(finaleDialog.getContentPane());
        finaleDialog.getContentPane().setLayout(finaleDialogLayout);
        finaleDialogLayout.setHorizontalGroup(
            finaleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finaleDialogLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finaleDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finaleButton)
                .addGap(40, 40, 40))
        );
        finaleDialogLayout.setVerticalGroup(
            finaleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finaleDialogLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(finaleButton)
                .addGap(35, 35, 35))
        );

        guadagnoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Barcode", "Nome", "Quantità", "Prezzo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        guadagnoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guadagnoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(guadagnoTable);

        guadagnoButton.setText("Ok");
        guadagnoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guadagnoButtonMouseClicked(evt);
            }
        });

        guadagnoList.setModel(new DefaultListModel()
        );
        jScrollPane2.setViewportView(guadagnoList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guadagnoButton)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(guadagnoButton)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guadagnoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guadagnoTableMouseClicked
        if (evt.getClickCount() == 2 && guadagnoTable.getSelectedRow() != -1) {
            this.setEnabled(false);
            int maximum = (int) guadagnoTable.getValueAt(guadagnoTable.getSelectedRow(), 2);
            SpinnerNumberModel m = new SpinnerNumberModel(0, 0, maximum, 1);
            guadagnoSpinner.setModel(m);
            guadagnoDialog.setVisible(true);
            guadagnoDialog.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_guadagnoTableMouseClicked
    
    private void riempiGuadagnoList(){
        String p = guadagnoTable.getValueAt(guadagnoTable.getSelectedRow(), 3).toString().replace(",", ".");
        float prezzo = Float.parseFloat(p);
        String barcode = (String) guadagnoTable.getValueAt(guadagnoTable.getSelectedRow(), 0);
        DefaultListModel model = (DefaultListModel) guadagnoList.getModel();
        for(int i = 0; i < model.getSize(); i++){
            if(model.get(i).toString().contains(barcode)){
                /*String nq = model.get(i).toString();
                nq = nq.substring(0, nq.indexOf("*"));
                q += Integer.parseInt(nq);*/
                model.remove(i);
                break;
            }
        }
        String s = q+"* " + barcode + ": " + (prezzo*q);
        model.add(WIDTH-1, s);
        guadagnoList.setModel(model);
    }    
    
    private void okGuadagnoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okGuadagnoButtonMouseClicked
        this.setEnabled(true);
        q = (int) guadagnoSpinner.getValue();
        if(q>0)
        riempiGuadagnoList();
        guadagnoDialog.dispose();
    }//GEN-LAST:event_okGuadagnoButtonMouseClicked

    private void aggiornaNegozio(String pr){
        //calo la quantità del barcode
        String prezzo = pr.substring(pr.indexOf(":")+2);
        String quantita = pr.substring(0, pr.indexOf("*"));
        int quant = Integer.parseInt(quantita);
        String barcode = pr.substring(pr.indexOf("*")+2, pr.indexOf(":"));
        String select = "SELECT QUANTITA FROM PRODOTTO_NEGOZIO WHERE "
                + "BARCODE = '" + barcode + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            rs.next();
            int max = rs.getInt("QUANTITA");
            String update;
            if(max == quant){
                update = "DELETE FROM PRODOTTO_NEGOZIO WHERE "
                    + "BARCODE = '" + barcode + "'";
            }
            else{
                update = "UPDATE PRODOTTO_NEGOZIO SET QUANTITA = " 
                    + (max-quant) + " WHERE BARCODE = '" + barcode + "'";
            }
            stmt.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void guadagnoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guadagnoButtonMouseClicked
        DefaultListModel m = (DefaultListModel) guadagnoList.getModel();
        for(int i = 0; i < m.size(); i++){
            String pr = m.get(i).toString();
            String p = pr.substring(pr.indexOf(":")+2);
            float prezzo = Float.parseFloat(p);
            tot += prezzo;
            aggiornaNegozio(pr);
        }
        jTextField1.setText("Hai guadagnato " + tot + "€");
        this.setEnabled(false);
        finaleDialog.setVisible(true);
        finaleDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_guadagnoButtonMouseClicked

    private void finaleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finaleButtonMouseClicked
        this.setEnabled(true);
        guadagnoList.setModel(new DefaultListModel());
        riempiGuadagnoTable();
        finaleDialog.dispose();
    }//GEN-LAST:event_finaleButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finaleButton;
    private javax.swing.JDialog finaleDialog;
    private javax.swing.JButton guadagnoButton;
    private javax.swing.JDialog guadagnoDialog;
    private javax.swing.JList<String> guadagnoList;
    private javax.swing.JSpinner guadagnoSpinner;
    private javax.swing.JTable guadagnoTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okGuadagnoButton;
    // End of variables declaration//GEN-END:variables
}
