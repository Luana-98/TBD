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
        jScrollPane3 = new javax.swing.JScrollPane();
        guadagnoArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        finaleDialog = new javax.swing.JDialog();
        jTextField1 = new javax.swing.JTextField();
        finaleButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        guadagnoTable = new javax.swing.JTable();
        guadagnoButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        guadagnoList = new javax.swing.JList<>();

        guadagnoDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        guadagnoDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        okGuadagnoButton.setText("Ok");
        okGuadagnoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okGuadagnoButtonMouseClicked(evt);
            }
        });

        guadagnoArea.setColumns(20);
        guadagnoArea.setRows(5);
        guadagnoArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        guadagnoArea.setEnabled(false);
        guadagnoArea.setOpaque(false);
        jScrollPane3.setViewportView(guadagnoArea);

        jLabel1.setText("Quantità vendute: ");

        javax.swing.GroupLayout guadagnoDialogLayout = new javax.swing.GroupLayout(guadagnoDialog.getContentPane());
        guadagnoDialog.getContentPane().setLayout(guadagnoDialogLayout);
        guadagnoDialogLayout.setHorizontalGroup(
            guadagnoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guadagnoDialogLayout.createSequentialGroup()
                .addGroup(guadagnoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guadagnoDialogLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(guadagnoDialogLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(guadagnoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(guadagnoDialogLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guadagnoDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okGuadagnoButton)
                .addGap(53, 53, 53))
        );
        guadagnoDialogLayout.setVerticalGroup(
            guadagnoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guadagnoDialogLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(guadagnoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okGuadagnoButton)
                .addGap(59, 59, 59))
        );

        finaleDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        finaleDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        jTextField1.setEditable(false);
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        jTextField1.setOpaque(false);

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
        guadagnoTable.setMaximumSize(new java.awt.Dimension(2147483647, 20000));
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

    private void riempiGuadagnoDialog(int maximum, String barcode){
        SpinnerNumberModel m = new SpinnerNumberModel(0, 0, maximum, 1);
        guadagnoSpinner.setModel(m);
        String query = "SELECT * "
                + "FROM PRODOTTO_NEGOZIO "
                + "WHERE BARCODE = '" + barcode + "'";
        System.out.println(query);
        Statement stmt;
        try {
            stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                String Nome= rs.getString("NOME");
                String Taglia= rs.getString("TAGLIA");
                String Materiale= rs.getString("MATERIALE");
                String quantita= rs.getString("QUANTITA");
                Double prezzo= rs.getDouble("PREZZO");
                DecimalFormat df = new DecimalFormat("#.00");
                String prima = Nome + "\n";
                String seconda = "Taglia: " + Taglia + "\t Materiale: " + Materiale + "\n";
                String terza = "Quantità in negozio: " + quantita + "\t Prezzo: " + df.format(prezzo);
                guadagnoArea.setText(prima+seconda+terza);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
        
    }
    
    private void guadagnoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guadagnoTableMouseClicked
        if (evt.getClickCount() == 2 && guadagnoTable.getSelectedRow() != -1) {
            this.setEnabled(false);
            int maximum = (int) guadagnoTable.getValueAt(guadagnoTable.getSelectedRow(), 2);   
            String barcode = (String) guadagnoTable.getValueAt(guadagnoTable.getSelectedRow(), 0); 
            riempiGuadagnoDialog(maximum, barcode);
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
    private javax.swing.JTextArea guadagnoArea;
    private javax.swing.JButton guadagnoButton;
    private javax.swing.JDialog guadagnoDialog;
    private javax.swing.JList<String> guadagnoList;
    private javax.swing.JSpinner guadagnoSpinner;
    private javax.swing.JTable guadagnoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okGuadagnoButton;
    // End of variables declaration//GEN-END:variables
}
