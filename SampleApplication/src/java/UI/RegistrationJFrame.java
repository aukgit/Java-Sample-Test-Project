/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import BusinessLogic.RegisterCourseController;
import Global.AppConfig;
import ObserverPattern.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.*;

/**
 *
 * @author Md. Alim Ul Karim
 * RegistrationJFrame is now a subscriber or observer or reader or listener which gets updated when publisher/subject publishes/notifies something.
 * 
 */
public class RegistrationJFrame extends javax.swing.JFrame implements IObserverable{

    private RegisterCourseController rcc;
    private Publisher publisher;
    private BeeperObserver beeperObserver;
    /**
     * Creates new form RegistrationJFrame
     */
    public RegistrationJFrame() {
        initComponents();
        rcc = new RegisterCourseController(jTable1);

        if (AppConfig.Configuration.getExtraPaymentAdapterClassNames().length > 0) {
            String[] list = AppConfig.Configuration.getExtraPaymentAdapterClassNames().clone();
            int i = 0;
            for (String adapterName : list) {
                String[] namesArray = adapterName.split("\\.");
                adapterName = namesArray[namesArray.length - 1];
                int feesPercent = (int) Math.floor(AppConfig.Configuration.getExtraFeesPercentages()[i] * 100);
                adapterName += "(" + feesPercent + "%)";
                list[i] = adapterName;
                i++;
            }

            String labelDisplay = String.join(" + ", list);
            TaxLabel.setText(labelDisplay);
        } else {
            TaxLabel.setText("No extra fees");
        }
        
        // register this subscriber or observer to the publisher
        // so that when a data is updated it can see it.
        publisher.register(this);
        publisher.register(beeperObserver);
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CourseIDTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        TaxTextBox = new javax.swing.JTextField();
        TaxLabel = new javax.swing.JLabel();
        GrandTotalTextBox = new javax.swing.JTextField();
        TaxLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SL#", "Course ID", "Course Title", "Credit", "Tution / Credit", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setLabel("New Registration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Course ID");

        CourseIDTextField.setName("CourseIDTextBox"); // NOI18N

        jButton2.setText("Add Course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNewCourseAction(evt);
            }
        });

        TaxTextBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TaxTextBox.setToolTipText("");

        TaxLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TaxLabel.setText("Tax and Fees");
        TaxLabel.setToolTipText("");

        GrandTotalTextBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        GrandTotalTextBox.setToolTipText("");

        TaxLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TaxLabel1.setText("Grand Total");
        TaxLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CourseIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TaxLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GrandTotalTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TaxLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TaxTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CourseIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaxTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaxLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GrandTotalTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaxLabel1))
                .addGap(15, 15, 15))
        );

        jButton1.getAccessibleContext().setAccessibleName("NewRegistrationButton");
        CourseIDTextField.getAccessibleContext().setAccessibleName("");
        jButton2.getAccessibleContext().setAccessibleName("AddCourseButton");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // new registration
        rcc.makeNewRegistration();
        GrandTotalTextBox.setText("0");
        TaxTextBox.setText("0");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void AddNewCourseAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewCourseAction
        try {
            // TODO add your handling code here:
            // Add course by id from course factory
            rcc.addCourse(this.CourseIDTextField.getText());
        } catch (Exception ex) {
            Logger.getLogger(RegistrationJFrame.class.getName()).log(Level.SEVERE, null, ex);

        }

        TaxTextBox.setText(Integer.toString(rcc.getRegistration().getExtraFeeAmount()));

        GrandTotalTextBox.setText(Integer.toString(rcc.getRegistration().getGrandTotal()));

    }//GEN-LAST:event_AddNewCourseAction

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
            java.util.logging.Logger.getLogger(RegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CourseIDTextField;
    private javax.swing.JTextField GrandTotalTextBox;
    private javax.swing.JLabel TaxLabel;
    private javax.swing.JLabel TaxLabel1;
    private javax.swing.JTextField TaxTextBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(IObserverable source, String propertyName, int value) {
        if("sale.total".equals(propertyName)){
            
        }
    }
}
