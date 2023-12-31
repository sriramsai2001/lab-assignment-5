/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;
import javax.swing.JOptionPane;
import model.User;
import utils.DatabaseConnector;


/**
 *
 * @author ram
 */
public class CreatePanel extends javax.swing.JPanel {

    /**
     * Creates new form createPanel
     */
    public CreatePanel() {
        initComponents();
    }
 public void clearFields() {
        nameInput.setText("");        
        ageInput.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        nameInput = new javax.swing.JTextField();
        ageInput = new javax.swing.JTextField();

        jLabel1.setText("USER FORM");

        jLabel2.setText("Name:");

        jLabel3.setText("Age:");

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(106, 106, 106)
                                .addComponent(ageInput))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(94, 94, 94)
                                .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(submitButton)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(submitButton)
                .addContainerGap(180, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
      String name = nameInput.getText();            
            String age = ageInput.getText();
            int ageInt; 
            if(name.length() == 0){
                JOptionPane.showMessageDialog(this, "Name cannot be empty", "Cannot create user", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(age.length() == 0){
                JOptionPane.showMessageDialog(this, "Age cannot be empty", "Cannot create user", JOptionPane.ERROR_MESSAGE);
                return;

            }
            try {
               ageInt = Integer.parseInt(age);
               User newUser = new User(); 
               newUser.setAge(ageInt);
               newUser.setName(name);
               DatabaseConnector.addUser(newUser);
               clearFields();
               JOptionPane.showMessageDialog(this, "User created successfully", "Created Successfully", JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Age must be a number", "Cannot create user", JOptionPane.ERROR_MESSAGE);
            }
       // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nameInput;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
