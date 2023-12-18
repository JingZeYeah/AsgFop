/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lecarsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import static lecarsystem.LeCarSystem.employeeStatus;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 *
 * @author jze20
 */
public class CustomerPage extends javax.swing.JFrame {

    /**
     * Creates new form CustomerPage
     */
    public CustomerPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        File cust_csv = new File("cust.csv");
        File sale_csv = new File("sales.csv");
        DefaultTableModel cust_data = new DefaultTableModel();

        try{
            int start = 0;
            ArrayList<String> custList = new ArrayList<>();
            InputStreamReader inputstreamreader = new InputStreamReader(new FileInputStream(cust_csv));
            CSVParser csvParser = CSVFormat.DEFAULT.parse(inputstreamreader);

            InputStreamReader inputstreamreadersale = new InputStreamReader(new FileInputStream(sale_csv));
            CSVParser csvParserSale = CSVFormat.DEFAULT.parse(inputstreamreadersale);

            for(CSVRecord csvSale:csvParserSale){
                if(LeCarSystem.employeeID.equals(csvSale.get(4))){
                    custList.add(csvSale.get(3));
                }
            }

            for(CSVRecord csvRecord:csvParser){
                if(start == 0){
                    start =1;
                    cust_data.addColumn(csvRecord.get(0));
                    cust_data.addColumn(csvRecord.get(1));
                    cust_data.addColumn(csvRecord.get(2));
                    cust_data.addColumn(csvRecord.get(3));
                }
                else
                {
                    if(LeCarSystem.employeeStatus.equals("0")){
                        if(custList.contains(csvRecord.get(0))){
                            Vector row = new Vector();
                            row.add(csvRecord.get(0));
                            row.add(csvRecord.get(1));
                            row.add(csvRecord.get(2));
                            row.add(csvRecord.get(3));
                            cust_data.addRow(row);
                        }
                    }else{
                        Vector row = new Vector();
                        row.add(csvRecord.get(0));
                        row.add(csvRecord.get(1));
                        row.add(csvRecord.get(2));
                        row.add(csvRecord.get(3));
                        cust_data.addRow(row);
                    }

                }
            }
        }catch (Exception e){
            System.out.print("Error");
        }
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(cust_data);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Customer");
        jLabel1.setFont(new Font("Sans-Serif",Font.BOLD,18));

        jButton1.setText("Add Customer");
        jButton1.setBackground(Color.ORANGE);
        jButton1.setFont(new Font("Serif",Font.PLAIN,13));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(Color.BLUE);
        jButton4.setForeground(Color.WHITE);
        jButton4.setFont(new Font("Serif",Font.PLAIN,13));
        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Name :");

        jMenu1.setText("Tables");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setText("Sales");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem2.setText("Customer");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem3.setText("Vehicle");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        if(LeCarSystem.employeeStatus == "1"){
            jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
            jMenuItem4.setText("Employee");
            jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem4ActionPerformed(evt);
                }
            });
            jMenu1.add(jMenuItem4);
        }

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AddCustomer().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == jMenuItem1){
            new SalesPages().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == jMenuItem3){
            new VehiclePage().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == jMenuItem4){
            new EmployeePage().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == jButton4) 
        {
            int clear = JOptionPane.showConfirmDialog(null, "Logout ?");
            if (clear == JOptionPane.YES_OPTION)
            {  
                JOptionPane.showMessageDialog(null,"Logout Successful");
                employeeStatus = "0";
                new LeCarSystem().setVisible(true);
                this.dispose();
                
            } 
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == jButton2){
            String word = jTextField1.getText();
            try{
                search(word);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPage().setVisible(true);
            }
        });
    }
    
    private void search(String word) throws Exception{
        File cust_name = new File("cust.csv");
        File sale_name = new File("sales.csv");
        DefaultTableModel NEW_CUST = new DefaultTableModel();

        try{
            int start = 0;
            ArrayList<String> custList = new ArrayList<>();
            InputStreamReader inputstreamreader = new InputStreamReader(new FileInputStream(cust_name));
            CSVParser csvParser = CSVFormat.DEFAULT.parse(inputstreamreader);

            InputStreamReader inputstreamreadersale = new InputStreamReader(new FileInputStream(sale_name));
            CSVParser csvParserSale = CSVFormat.DEFAULT.parse(inputstreamreadersale);

            for(CSVRecord csvSale:csvParserSale){
                if(LeCarSystem.employeeID.equals(csvSale.get(4))){             
                    custList.add(csvSale.get(3));
                }
            }

            for(CSVRecord csvRecord:csvParser){
                if(start == 0){
                    start =1;
                    NEW_CUST.addColumn(csvRecord.get(0));
                    NEW_CUST.addColumn(csvRecord.get(1));
                    NEW_CUST.addColumn(csvRecord.get(2));
                    NEW_CUST.addColumn(csvRecord.get(3));
                }
                else
                { 
                    if(LeCarSystem.employeeStatus.equals("0")){
                        if(custList.contains(csvRecord.get(0))){
                            if(csvRecord.get(0).contains(word) || csvRecord.get(1).contains(word) || csvRecord.get(2).contains(word) || csvRecord.get(3).contains(word)){
                                Vector row = new Vector();
                                row.add(csvRecord.get(0));
                                row.add(csvRecord.get(1));
                                row.add(csvRecord.get(2));
                                row.add(csvRecord.get(3));
                                NEW_CUST.addRow(row);
                            }
                            
                        }
                    }else{
                        if(csvRecord.get(0).contains(word) || csvRecord.get(1).contains(word) || csvRecord.get(2).contains(word) || csvRecord.get(3).contains(word)){
                            Vector row = new Vector();
                            row.add(csvRecord.get(0));
                            row.add(csvRecord.get(1));
                            row.add(csvRecord.get(2));
                            row.add(csvRecord.get(3));
                            NEW_CUST.addRow(row);
                        }  
                    }


                }
            }
        }catch (Exception e){
            System.out.print("Error");
        }
        
        jTable1.setModel(NEW_CUST);
        jScrollPane1.setViewportView(jTable1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
