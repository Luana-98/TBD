/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantovan.progettonuovo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luana
 */
public class Home extends javax.swing.JFrame {
    Connection conn;
    Prodotti p;
    Inizio in;
    Ordina ordina;
    VediOrdini vedi;
    EstinguiOrdini estingui;
    /**
     * Creates new form Home
     */
    public Home() {
        try{            
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            System.out.println("connecting");
            String url = "jdbc:db2://55fbc997-9266-4331-afd3-888b05e734c0.bs2io90l08kqb1od8lcg.databases.appdomain.cloud:31929/bludb:user=trd74291;password=TtqUOVMDN5woGzpe;sslConnection=true;";
            this.conn = DriverManager.getConnection(url);
            System.out.println("Connected!");
        }
        catch(Exception se){
            se.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        in = new Inizio();
        jTabbedPane2.addTab("Principale", in);
        p = new Prodotti(conn);
        jTabbedPane2.addTab("Prodotti", p);
        ordina = new Ordina(conn);
        jTabbedPane2.addTab("Ordina", ordina);
        vedi = new VediOrdini(conn);
        jTabbedPane2.addTab("Visualizza Ordini", vedi);
        estingui = new EstinguiOrdini(conn);
        jTabbedPane2.addTab("Estingui ordini", estingui);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 600));

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(750, 600));
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        int index = jTabbedPane2.getSelectedIndex();
        switch(index){
            case 0:
                in = new Inizio();
                break;
            case 1:
                p = new Prodotti(conn);
                break;
            case 2:                
                ordina = new Ordina(conn);
                break;
            case 3:
                vedi.riempiOrdiniList();
                break;
            case 4:
                estingui = new EstinguiOrdini(conn);
                break;
        }
    }//GEN-LAST:event_jTabbedPane2MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
