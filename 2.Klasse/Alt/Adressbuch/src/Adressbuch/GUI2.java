package Adressbuch;

import java.util.ArrayList;

public class GUI2 extends javax.swing.JFrame {

    public static ArrayList<PI> liste = new ArrayList<>();

    public GUI2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jVorname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jInformationsArea = new javax.swing.JTextArea();
        jBsuchen = new javax.swing.JButton();
        jNachname = new javax.swing.JTextField();
        jNummer = new javax.swing.JTextField();
        jAdresse = new javax.swing.JTextField();
        jBadd = new javax.swing.JButton();
        jAnzeigen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Vorname");

        jLabel2.setText("Nachname");

        jLabel3.setText("Telefonnummer");

        jVorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVornameActionPerformed(evt);
            }
        });

        jLabel4.setText("Adresse");

        jLabel5.setText("Informationen");

        jInformationsArea.setColumns(20);
        jInformationsArea.setRows(5);
        jInformationsArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jInformationsArea);

        jBsuchen.setText("Suchen");
        jBsuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsuchenActionPerformed(evt);
            }
        });

        jNachname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNachnameActionPerformed(evt);
            }
        });

        jNummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNummerActionPerformed(evt);
            }
        });

        jAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdresseActionPerformed(evt);
            }
        });

        jBadd.setText("Add");
        jBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaddActionPerformed(evt);
            }
        });

        jAnzeigen.setText("Anzeigen");
        jAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnzeigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jAdresse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addComponent(jNummer, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jNachname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jVorname, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBsuchen)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBsuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAnzeigen)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jVornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVornameActionPerformed

    }//GEN-LAST:event_jVornameActionPerformed

    private void jNachnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNachnameActionPerformed

    }//GEN-LAST:event_jNachnameActionPerformed

    private void jNummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNummerActionPerformed

    }//GEN-LAST:event_jNummerActionPerformed

    private void jAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdresseActionPerformed

    }//GEN-LAST:event_jAdresseActionPerformed

    private void jBsuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsuchenActionPerformed
        String gg = jVorname.getText();
        suchen(gg);
    }//GEN-LAST:event_jBsuchenActionPerformed

    private void jBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaddActionPerformed
        int x = 0;
        if (jVorname.getText().length() < 1) {
            jInformationsArea.setText("Fehler");
            x--;
        } else {
            if (jNachname.getText().length() < 1) {
                jInformationsArea.setText("Fehler");
                x--;
            } else {
                if (jNummer.getText().length() < 1) {
                    jInformationsArea.setText("Fehler");
                    x--;
                } else {
                    if (jAdresse.getText().length() > 0 && x == 0) {

                        PI pi = new PI(jVorname.getText(), jNachname.getText(), jNummer.getText(), jAdresse.getText());
                        liste.add(pi);
                        jVorname.setText("");
                        jNachname.setText("");
                        jNummer.setText("");
                        jAdresse.setText("");
                        jInformationsArea.setText("Erfolgreich Hinzgefügt");
                    } else {
                        jInformationsArea.setText("Fehler");

                    }
                }
            }
        }
    }//GEN-LAST:event_jBaddActionPerformed

    private void jAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnzeigenActionPerformed
        anzeigen();
    }//GEN-LAST:event_jAnzeigenActionPerformed

    public void suchen(String name) {
        for (int i = 0; i < liste.size(); i++) {
            PI person = liste.get(i);
            if (person.getNachname().equalsIgnoreCase(name)) {

                String info = "Vorname: " + person.getVorname()
                        + "\nNachname: " + person.getNachname()
                        + "\nTelefonnummer: " + person.getTelefonnummer()
                        + "\nAdresse: " + person.getAdresse() + "\n";
                jInformationsArea.setText(info);
                return;
            }
        } 
        jInformationsArea.setText("Keine Person mit diesem Nachnamen gefunden.");
    }

    public void anzeigen() {
    String output = "Liste\n";

    if (liste.isEmpty()) {
        output += "Die Liste ist leer.";
    } else {
        for (int i = 0; i < liste.size(); i++) {
            PI person = liste.get(i);
            output += person.getText() + "\n";
            jInformationsArea.setText(output);
        }
    }

    
}


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAdresse;
    private javax.swing.JButton jAnzeigen;
    private javax.swing.JButton jBadd;
    private javax.swing.JButton jBsuchen;
    private javax.swing.JTextArea jInformationsArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jNachname;
    private javax.swing.JTextField jNummer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jVorname;
    // End of variables declaration//GEN-END:variables
}
