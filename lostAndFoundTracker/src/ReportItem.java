/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Report extends javax.swing.JFrame {
    
    public void fileWriter( String fileName, String item, String description, String contact, String location) throws FileNotFoundException {
	FileWriter writer = null;
        try {
            // FILE WRITER
            writer = new FileWriter(fileName, true);
            writer.write(item + "\n" + description + "\n" + contact + "\n" + location + "\n\n");
            writer.close();
            System.out.println("You successfuly added a record");
        } catch (IOException ex) {
            Logger.getLogger(ReportItem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ReportItem.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
	
    public void fileReader(String fileName, JTable tableCB) {
	try {
	    Scanner reader = new Scanner(new FileReader(fileName));
	            
	    String contact;
	    String description, location, item;
	            
	    DefaultTableModel model = (DefaultTableModel) tableCB.getModel();
	            
	    while(reader.hasNextLine()) {
	                
	        item = reader.nextLine();
	        description = reader.nextLine();
	        contact = reader.nextLine();
	        location = reader.nextLine();   
	                
	        model.addRow(new Object[]{
	            item,
	            description,
	            contact,
	            location
	        });
	                
	    }
	            
	    reader.close();
	           
	    } catch (FileNotFoundException ex) {
	        Logger.getLogger(ReportItem.class.getName()).log(Level.SEVERE, null, ex);
	    }
    }
	
    public void fileDeleter(File fileName, JTable table) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(" "); // Write an empty string to the file
            writer.close();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Remove all rows from the table model
            JOptionPane.showMessageDialog(this, "deleted!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void fileRowDeleter(JTable fromTable, JTable toTable, String fileName) {
        DefaultTableModel tableModel = (DefaultTableModel) fromTable.getModel();
        int[] indexs = fromTable.getSelectedRows();
        Object[] row = new Object[4];

        DefaultTableModel tableModel1 = (DefaultTableModel) toTable.getModel();

        for (int i = 0; i < indexs.length; i++ ) {
            row[0] = tableModel.getValueAt(indexs[i], 0);
            row[1] = tableModel.getValueAt(indexs[i], 1);
            row[2] = tableModel.getValueAt(indexs[i], 2);
            row[3] = tableModel.getValueAt(indexs[i], 3);

            tableModel1.addRow(row);
            String item = (String) row[0];
            String desc = (String) row[1];
            String loc = (String) row[2];
            String cont = (String) row[3];
            
            try {
                fileWriter(fileName, item, desc, loc, cont);
            } catch (FileNotFoundException ex) {
               JOptionPane.showMessageDialog(this, "failed to transfer to file");
            }
            
        }
        if(fromTable.getSelectedRowCount()== 1) {
            tableModel.removeRow(fromTable.getSelectedRow());

        } else {
            if(fromTable.getSelectedRow() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please choose a row");
            }
        }
    }
}


public class ReportItem extends Report {
    protected String itemF, contactF, descriptionF, locF;
    
    public ReportItem() {
        initComponents();
        
        missingTable.getColumnModel().getColumn(0);
        retTable.getColumnModel().getColumn(0);
        claimedTable.getColumnModel().getColumn(0);
        
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        missingTable = new javax.swing.JTable();
        retrievedBtn = new javax.swing.JButton();
        deleteMissing = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        claimedBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        retTable = new javax.swing.JTable();
        deleteRetrieved = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        claimedTable = new javax.swing.JTable();
        deleteClaimed = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        typeOfReport = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        itemField = new javax.swing.JTextField();
        descriptionField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        locationField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        contactField = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("MISSING ITEMS");

        missingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Description", "Location", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(missingTable);

        retrievedBtn.setText("retrieved");
        retrievedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrievedBtnActionPerformed(evt);
            }
        });

        deleteMissing.setText("delete all");
        deleteMissing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMissingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(deleteMissing)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(retrievedBtn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(211, 211, 211))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retrievedBtn)
                    .addComponent(deleteMissing))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        tabs.addTab("Missing", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("RETRIEVED ITEMS");

        claimedBtn.setText("claim");
        claimedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimedBtnActionPerformed(evt);
            }
        });

        retTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Description", "Location", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(retTable);
        if (retTable.getColumnModel().getColumnCount() > 0) {
            retTable.getColumnModel().getColumn(3).setResizable(false);
        }

        deleteRetrieved.setText("delete all");
        deleteRetrieved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRetrievedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(deleteRetrieved)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(claimedBtn))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(212, 212, 212))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claimedBtn)
                    .addComponent(deleteRetrieved))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        tabs.addTab("Retrieved", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("CLAIMED ITEMS");

        claimedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Description", "Location", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(claimedTable);

        deleteClaimed.setText("delete all");
        deleteClaimed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClaimedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteClaimed)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(223, 223, 223)
                            .addComponent(jLabel3))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(deleteClaimed)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        tabs.addTab("Claimed", jPanel4);

        jLabel4.setText("REPORT");

        typeOfReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Missing", "Retrieve" }));

        jLabel5.setText("Item:");

        jLabel6.setText("Description");

        jLabel7.setText("Location");

        jLabel8.setText("Contact");

        saveBtn.setText("save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeOfReport, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(itemField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeOfReport, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retrievedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrievedBtnActionPerformed
        fileRowDeleter(missingTable, retTable, "retTable.txt");
    }//GEN-LAST:event_retrievedBtnActionPerformed

    private void claimedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimedBtnActionPerformed
        fileRowDeleter(retTable, claimedTable, "claimed.txt");
    }//GEN-LAST:event_claimedBtnActionPerformed

    private void deleteClaimedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClaimedActionPerformed
        File file = new File("claimed.txt");
        fileDeleter(file, claimedTable);
        
    }//GEN-LAST:event_deleteClaimedActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            String fileName;
                            
            JTable tableCB = null;
            
            String type=typeOfReport.getSelectedItem().toString();
            
            if(type.equals("Missing")) {
                tableCB = missingTable;
                fileName = "missingTable.txt";
            } else {
                tableCB = retTable;
                fileName = "retTable.txt";
            }
            
            itemF = itemField.getText();
            contactF = contactField.getText();
            locF = locationField.getText();
            descriptionF = descriptionField.getText();
            
            if (itemF.isBlank() & contactF.isBlank() & locF.isBlank() & descriptionF.isBlank()) {
                JOptionPane.showMessageDialog(rootPane, "please fill all fields");
            } else {
                fileWriter(fileName, itemF, descriptionF, locF, contactF);
            
                DefaultTableModel model = (DefaultTableModel) tableCB.getModel();
            
                model.addRow(new Object[]{
                
                    itemF,
                    descriptionF,
                    locF,
                    contactF
                        
                });
                    
                JOptionPane.showMessageDialog(rootPane, "Item Saved!");
            }
            
            itemField.setText("");
            contactField.setText("");
            locationField.setText("");
            descriptionField.setText("");
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Failed to Save");
            
        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteMissingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMissingActionPerformed
        File file = new File("missingTable.txt");
        fileDeleter(file, missingTable);
    }//GEN-LAST:event_deleteMissingActionPerformed

    private void deleteRetrievedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRetrievedActionPerformed
        File file = new File("retTable.txt");
        fileDeleter(file, retTable);
    }//GEN-LAST:event_deleteRetrievedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton claimedBtn;
    private javax.swing.JTable claimedTable;
    private javax.swing.JTextField contactField;
    private javax.swing.JButton deleteClaimed;
    private javax.swing.JButton deleteMissing;
    private javax.swing.JButton deleteRetrieved;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JTextField itemField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField locationField;
    private javax.swing.JTable missingTable;
    private javax.swing.JTable retTable;
    private javax.swing.JButton retrievedBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JComboBox<String> typeOfReport;
    // End of variables declaration//GEN-END:variables

    
}
