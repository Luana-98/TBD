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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luana
 */
public class Ordina extends javax.swing.JPanel {
    Connection conn;    
    int q;
    int eliminaq;
    /**
     * Creates new form Ordina
     */
    public Ordina(Connection c) {
        initComponents();
        this.conn = c;        
        ordinaInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eliminaDialog = new javax.swing.JDialog();
        eliminaSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        eliminaOk = new javax.swing.JButton();
        ordinaDialog = new javax.swing.JDialog();
        ordinaSpinner = new javax.swing.JSpinner();
        okOrdinaDialog = new javax.swing.JButton();
        completedDialog = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        completedButton = new javax.swing.JButton();
        magchoice = new javax.swing.JComboBox<>();
        catchoice = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ordinaTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        aggiornaButton = new javax.swing.JButton();
        cart = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordinaList = new javax.swing.JList<>();
        ordinaOk = new javax.swing.JButton();

        eliminaDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        eliminaDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel4.setText("Seleziona quanti elementi vuoi togliere dall'ordine");

        eliminaOk.setText("Ok");
        eliminaOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminaOkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout eliminaDialogLayout = new javax.swing.GroupLayout(eliminaDialog.getContentPane());
        eliminaDialog.getContentPane().setLayout(eliminaDialogLayout);
        eliminaDialogLayout.setHorizontalGroup(
            eliminaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminaDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(eliminaOk)
                .addGap(42, 42, 42))
            .addGroup(eliminaDialogLayout.createSequentialGroup()
                .addGroup(eliminaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminaDialogLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eliminaDialogLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(eliminaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        eliminaDialogLayout.setVerticalGroup(
            eliminaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminaDialogLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addComponent(eliminaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(eliminaOk)
                .addGap(43, 43, 43))
        );

        ordinaDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        ordinaDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        okOrdinaDialog.setText("Ok");
        okOrdinaDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okOrdinaDialogMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ordinaDialogLayout = new javax.swing.GroupLayout(ordinaDialog.getContentPane());
        ordinaDialog.getContentPane().setLayout(ordinaDialogLayout);
        ordinaDialogLayout.setHorizontalGroup(
            ordinaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordinaDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okOrdinaDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(ordinaDialogLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(ordinaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        ordinaDialogLayout.setVerticalGroup(
            ordinaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordinaDialogLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(ordinaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(okOrdinaDialog)
                .addGap(56, 56, 56))
        );

        completedDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel5.setText("Ordine effettuato!");

        completedButton.setText("Ok");
        completedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                completedButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout completedDialogLayout = new javax.swing.GroupLayout(completedDialog.getContentPane());
        completedDialog.getContentPane().setLayout(completedDialogLayout);
        completedDialogLayout.setHorizontalGroup(
            completedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, completedDialogLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(completedDialogLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(completedButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        completedDialogLayout.setVerticalGroup(
            completedDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedDialogLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel5)
                .addGap(57, 57, 57)
                .addComponent(completedButton)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(600, 600));

        magchoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutti i magazzini" }));

        catchoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutte le categorie" }));

        jLabel1.setText("Fai doppio click sull'elemento che vuoi acquistare:");

        ordinaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Magazzino", "Categoria", "Barcode", "Prodotto", "Taglia", "Quantità", "Prezzo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordinaTable.setPreferredSize(new java.awt.Dimension(50, 64));
        ordinaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ordinaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ordinaTable.getTableHeader().setReorderingAllowed(false);
        ordinaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordinaTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ordinaTable);

        jLabel2.setText("Riepilogo ordine:");

        aggiornaButton.setText("Aggiorna");
        aggiornaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aggiornaButtonMouseClicked(evt);
            }
        });

        cart.setEditable(false);
        cart.setText("Carrello: 0");
        cart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setText("Fai doppio click se vuoi eliminare una quantità di elementi già in lista:");

        ordinaList.setModel(new DefaultListModel());
        ordinaList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ordinaList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordinaListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ordinaList);

        ordinaOk.setText("Ordina");
        ordinaOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordinaOkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(magchoice, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(catchoice, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(aggiornaButton))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cart, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ordinaOk)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(cart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(magchoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catchoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aggiornaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordinaOk)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ordinaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordinaTableMouseClicked
        if (evt.getClickCount() == 2 && ordinaTable.getSelectedRow() != -1) {
            this.setEnabled(false);
            int maximum = (int) ordinaTable.getValueAt(ordinaTable.getSelectedRow(), 5);
            SpinnerNumberModel m = new SpinnerNumberModel(0, 0, maximum, 1);
            ordinaSpinner.setModel(m);
            ordinaDialog.setVisible(true);
            ordinaDialog.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_ordinaTableMouseClicked
    public void ordinaInit(){
        String magQuery = "SELECT CODMAG, NOME FROM MAGAZZINO";
        String catQuery = "SELECT CODCAT, NOMECAT FROM CATEGORIA";
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(magQuery);
            DefaultComboBoxModel m = (DefaultComboBoxModel) magchoice.getModel();
            while(rs.next()){
                String s = rs.getString("CODMAG") + ": " + rs.getString("NOME");
                m.addElement(s);
            }
            rs = stmt.executeQuery(catQuery);
            m = (DefaultComboBoxModel) catchoice.getModel();
            while(rs.next()){
                String s = rs.getString("CODCAT") + ": " + rs.getString("NOMECAT");
                m.addElement(s);
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        riempiOrdinaTable();
    }
    
    public void riempiOrdinaTable(){
        String magString = (String) magchoice.getSelectedItem();
        String catString = (String) catchoice.getSelectedItem();
        
        int magIndex = magchoice.getSelectedIndex();
        int catIndex = catchoice.getSelectedIndex();
        String tableQuery = "SELECT MAGAZZINO.CODMAG AS MAG, CATEGORIA.NOMECAT, "
                + "PRODOTTO.NOME AS PROD, PRODOTTO.TAGLIA, PRODOTTO.QUANTITA, "
                + "PRODOTTO.PREZZO, PRODOTTO.BARCODE "
                + "FROM MAGAZZINO, CATEGORIA, PRODOTTO, MAGCAT "
                + "WHERE MAGAZZINO.CODMAG = MAGCAT.CODMAG "
                + "AND CATEGORIA.CODCAT = MAGCAT.CODCAT "
                + "AND CATEGORIA.CODCAT = PRODOTTO.CODCAT ";
        if(magIndex != 0){
            magString = magString.substring(0, magString.indexOf(":"));
            tableQuery += ("AND MAGAZZINO.CODMAG = '" + magString + "'");
        }
        if(catIndex != 0){
            catString = catString.substring(0, catString.indexOf(":"));
            tableQuery += ("AND CATEGORIA.CODCAT = '" + catString + "'");
        }
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(tableQuery);
            DefaultTableModel model = (DefaultTableModel) ordinaTable.getModel();
            model.setRowCount(0);
            while(rs.next()){
                String s = rs.getString("MAG");
                String t = rs.getString("NOMECAT");
                String b = rs.getString("BARCODE");
                String u = rs.getString("PROD");
                String v = rs.getString("TAGLIA");
                int q = rs.getInt("QUANTITA");
                float p = rs.getFloat("PREZZO");
                DecimalFormat df = new DecimalFormat("#.00");         
                model.addRow(new Object[]{s, t,b, u, v, q, df.format(p)});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void aggiornaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aggiornaButtonMouseClicked
        riempiOrdinaTable();
    }//GEN-LAST:event_aggiornaButtonMouseClicked

    private void ordinaListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordinaListMouseClicked
        if (evt.getClickCount() == 2 && ordinaList.getSelectedIndex() != -1) {
            this.setEnabled(false);
            DefaultListModel model = (DefaultListModel) ordinaList.getModel();
            String nq = model.get(ordinaList.getSelectedIndex()).toString();
            nq = nq.substring(nq.indexOf(":")+2, nq.indexOf("*"));
            int maximum = Integer.parseInt(nq);
            SpinnerNumberModel m = new SpinnerNumberModel(0, 0, maximum, 1);
            eliminaSpinner.setModel(m);
            eliminaDialog.setVisible(true);
            eliminaDialog.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_ordinaListMouseClicked

    private void ordinaOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordinaOkMouseClicked
        SimpleDateFormat date = new SimpleDateFormat("dd_MM_yyyy_HHmmss");
        String codOrdine = date.format(new Date());
        String query = "INSERT INTO ORDINE(COD_ORDINE) VALUES ('" + codOrdine + "')";
        String queryOrdine;
        DefaultListModel model = (DefaultListModel) ordinaList.getModel();        
        try{
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(query);
            for(int i = 0; i < model.getSize(); i++){
                String element = model.getElementAt(i).toString();
                String codProd = element.substring(element.indexOf("* ")+2, element.lastIndexOf(":"));
                String magazzino = element.substring(10, element.indexOf(":"));
                String quantita = element.substring(element.indexOf(":")+2, element.indexOf("*"));
                String nome = element.substring(element.lastIndexOf(":")+2);
                queryOrdine = "INSERT INTO PRODOTTO_ORDINE"
                        + "(PK, COD_PROD_ORD, MAGAZZINO, QUANTITA, COD_ORDINE, NOME)"
                        + " VALUES(DEFAULT, '" + codProd + "', '" + magazzino + "',"
                        + quantita + ",'" + codOrdine + "','" + nome + "')";
                stmt.executeUpdate(queryOrdine);
                String select = "SELECT QUANTITA FROM PRODOTTO WHERE BARCODE = '" + codProd+"'";
                ResultSet rs = stmt.executeQuery(select);
                rs.next();
                int maxq = rs.getInt("QUANTITA");
                maxq -= Integer.parseInt(quantita);
                String update = "UPDATE PRODOTTO SET QUANTITA = " + maxq
                        + " WHERE BARCODE = '" + codProd + "'";
                stmt.executeUpdate(update);
                System.out.println("Completato");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.setEnabled(false);
        completedDialog.setVisible(true);
        completedDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_ordinaOkMouseClicked
    
    private void aggiornaOrdinaLista(){
        int index = ordinaList.getSelectedIndex();
        DefaultListModel model = (DefaultListModel) ordinaList.getModel();
        String nuovo = model.get(index).toString();
        String n = nuovo.substring(0, nuovo.indexOf(":")+2);
        nuovo = nuovo.substring(nuovo.indexOf("*"));        
        q -=eliminaq;
        nuovo = n+ String.valueOf(q) + nuovo;        
        model.remove(index);
        if(q >0)
            model.add(WIDTH-1, nuovo);
        ordinaList.setModel(model);
    }
    private void eliminaOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminaOkMouseClicked
        this.setEnabled(true);
        eliminaq = (int) eliminaSpinner.getValue();
        if(q>0)
        aggiornaOrdinaLista();
        int el = ordinaList.getModel().getSize();
        cart.setText("Carrello: " + String.valueOf(el));
        eliminaDialog.dispose();
    }//GEN-LAST:event_eliminaOkMouseClicked
    
    private void riempiOrdinaLista(){
        String prod = (String) ordinaTable.getValueAt(ordinaTable.getSelectedRow(), 3);
        String barcode = (String) ordinaTable.getValueAt(ordinaTable.getSelectedRow(), 2);
        String magazzino = (String) ordinaTable.getValueAt(ordinaTable.getSelectedRow(), 0);
        DefaultListModel model = (DefaultListModel) ordinaList.getModel();
        for(int i = 0; i < model.getSize(); i++){
            if(model.get(i).toString().contains(barcode)){
                String nq = model.get(i).toString();
                nq = nq.substring(nq.indexOf(":")+2, nq.indexOf("*"));
                q += Integer.parseInt(nq);
                model.remove(i);
                break;
            }
        }
        String s ="Magazzino " + magazzino + ": "+q+"* " + barcode + ": " + prod;
        model.add(WIDTH-1, s);
        ordinaList.setModel(model);
    }
    
    private void okOrdinaDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okOrdinaDialogMouseClicked
        this.setEnabled(true);
        q = (int) ordinaSpinner.getValue();
        if(q>0)
        riempiOrdinaLista();
        int el = ordinaList.getModel().getSize();
        cart.setText("Carrello: " + String.valueOf(el));
        ordinaDialog.dispose();
    }//GEN-LAST:event_okOrdinaDialogMouseClicked
    
    private void svuotaLista(){
        ordinaList.setModel(new DefaultListModel());
    }
    
    private void completedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completedButtonMouseClicked
        svuotaLista();
        riempiOrdinaTable();
        this.setEnabled(true);
        completedDialog.dispose();
    }//GEN-LAST:event_completedButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiornaButton;
    public javax.swing.JTextField cart;
    private javax.swing.JComboBox<String> catchoice;
    private javax.swing.JButton completedButton;
    private javax.swing.JDialog completedDialog;
    private javax.swing.JDialog eliminaDialog;
    private javax.swing.JButton eliminaOk;
    private javax.swing.JSpinner eliminaSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> magchoice;
    private javax.swing.JButton okOrdinaDialog;
    private javax.swing.JDialog ordinaDialog;
    private javax.swing.JList<String> ordinaList;
    private javax.swing.JButton ordinaOk;
    private javax.swing.JSpinner ordinaSpinner;
    private javax.swing.JTable ordinaTable;
    // End of variables declaration//GEN-END:variables
}
