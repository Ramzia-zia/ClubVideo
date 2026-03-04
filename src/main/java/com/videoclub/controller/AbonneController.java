package com.videoclub.controller;

import com.videoclub.view.PanelAbonne;
import com.videoclub.view.DialogAjout;
import javax.swing.JOptionPane;

public class AbonneController {
    private PanelAbonne vuePrincipale;

    public AbonneController(PanelAbonne vue) {
        this.vuePrincipale = vue;
    }

    public void executerModification() {
        int ligne = vuePrincipale.getTable().getSelectedRow();

        if (ligne != -1) {
            String ancienNom = vuePrincipale.getModele().getValueAt(ligne, 1).toString();
            String ancienneAdresse = vuePrincipale.getModele().getValueAt(ligne, 2).toString();

            DialogAjout diag = new DialogAjout(null);
            diag.txtNom.setText(ancienNom);
            diag.txtAdresse.setText(ancienneAdresse);
            diag.btnValider.setText("Modifier");

            diag.btnValider.addActionListener(e -> {
                vuePrincipale.getModele().setValueAt(diag.txtNom.getText(), ligne, 1);
                vuePrincipale.getModele().setValueAt(diag.txtAdresse.getText(), ligne, 2);
                diag.dispose();
            });
            diag.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selectionnez un abonne a modifier");
        }
    }

    public void ouvrirFormulaire() {
        DialogAjout diag = new DialogAjout(null);

        diag.btnValider.addActionListener(e -> {
            String nom = diag.txtNom.getText();
            String adresse = diag.txtAdresse.getText();
            vuePrincipale.getModele().addRow(new Object[]{"Auto", nom, adresse, "2026", "0"});
            diag.dispose();
        });

        diag.setVisible(true);
    }
}