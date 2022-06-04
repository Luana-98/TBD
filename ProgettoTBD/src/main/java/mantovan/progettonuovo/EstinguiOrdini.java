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
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;

/**
 *
 * @author Luana
 */
public class EstinguiOrdini extends javax.swing.JPanel {
    Connection conn;
    CheckBoxList ordiniLista;
    /**
     * Creates new form EstinguiOrdini
     * @param conn
     */
    public EstinguiOrdini(Connection conn) {
        initComponents();
        this.conn = conn;        
        riempiList();
    }

    public void riempiList(){
        String queryString = "SELECT COD_ORDINE FROM ORDINE";
        int i = 1;
        ordiniLista = new CheckBoxList();
        jScrollPane3.setViewportView(ordiniLista);
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);           
            while(rs.next()){
                String s = String.valueOf(i) + "- Ordine: "+rs.getString("COD_ORDINE");
                i++;
                ordiniLista.addCheckbox(new JCheckBox(s));
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

        ordiniEstinti = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        ordiniEstinti.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        ordiniEstinti.setMinimumSize(new java.awt.Dimension(400, 300));

        jButton2.setText("Ok");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel1.setText("Gli ordini selezionati sono stati estinti. \nLa merce è ora presente nel tuo negozio");

        javax.swing.GroupLayout ordiniEstintiLayout = new javax.swing.GroupLayout(ordiniEstinti.getContentPane());
        ordiniEstinti.getContentPane().setLayout(ordiniEstintiLayout);
        ordiniEstintiLayout.setHorizontalGroup(
            ordiniEstintiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordiniEstintiLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
            .addGroup(ordiniEstintiLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ordiniEstintiLayout.setVerticalGroup(
            ordiniEstintiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordiniEstintiLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addComponent(jButton2)
                .addGap(84, 84, 84))
        );

        setPreferredSize(new java.awt.Dimension(750, 600));

        jButton1.setText("Ricevuti");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setText("Seleziona gli ordini da estinguere:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void estingui(){
        java.util.List l = ordiniLista.getCheckedItems();
        for(int i = 0; i < l.size(); i++){
            String ord = l.get(i).toString().substring(l.get(i).toString().indexOf(":")+2);
            String select = "SELECT PRODOTTO_ORDINE.COD_PROD_ORD AS BARCODE, "
                    + "PRODOTTO.NOME AS N, PRODOTTO.TAGLIA AS T, "
                    + "PRODOTTO.MATERIALE AS M, PRODOTTO.PREZZO AS P, "
                    + "PRODOTTO_ORDINE.QUANTITA AS Q "
                    + "FROM PRODOTTO, PRODOTTO_ORDINE "
                    + "WHERE PRODOTTO.BARCODE = PRODOTTO_ORDINE.COD_PROD_ORD AND "
                    + "PRODOTTO_ORDINE.COD_ORDINE = '" + ord + "'";
            try {
                Statement stmt = this.conn.createStatement();
                ResultSet rs = stmt.executeQuery(select);
                while(rs.next()){
                    String barcode = rs.getString("BARCODE");
                    String n = rs.getString("N");
                    String t = rs.getString("T");
                    String m = rs.getString("M");
                    Float p = rs.getFloat("P");
                    int q = rs.getInt("Q");
                    String cerca = "SELECT BARCODE, QUANTITA FROM PRODOTTO_NEGOZIO "
                        + "WHERE BARCODE = '" + barcode + "'";
                    Statement stmt2 = this.conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(cerca);
                    int nRows = 0;
                    int presente = 0;
                    while(rs2.next()){
                        nRows++;
                        presente = rs2.getInt("QUANTITA");
                    }
                    String update;
                    if(nRows == 0){
                        p = (float) (p*1.25);
                        update = "INSERT"
                            + " INTO PRODOTTO_NEGOZIO"
                            + "(BARCODE, NOME, TAGLIA, MATERIALE, QUANTITA, PREZZO) "
                            + "VALUES('"+ barcode+"','"+n+"', '"+t+"', '"+m+"', "+q+","+p+")";
                        
                    }
                    else{
                        q += presente;
                        update = "UPDATE PRODOTTO_NEGOZIO SET QUANTITA = " + q
                            + " WHERE BARCODE = '" + barcode +"'";
                    }
                    Statement stmt3 = this.conn.createStatement();
                    stmt3.executeUpdate(update);
                    String delete = "DELETE FROM PRODOTTO_ORDINE "
                        + "WHERE COD_PROD_ORD = '" + barcode + "' "
                        + "AND COD_ORDINE = '" + ord + "'";
                    stmt3.executeUpdate(delete);
                }
                String delete = "DELETE FROM ORDINE WHERE COD_ORDINE = '" + ord + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            estingui();
            ordiniEstinti.setVisible(true);
            ordiniEstinti.setLocationRelativeTo(null);        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        ordiniEstinti.dispose();
        riempiList();
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JDialog ordiniEstinti;
    // End of variables declaration//GEN-END:variables
}
