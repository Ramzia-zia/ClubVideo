package com.videoclub.controller;

import com.videoclub.view.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionController {
    private PanelGestion vue;

    public GestionController(PanelGestion vue) { this.vue = vue; }

    public void executerAjout(String type) {
        DialogForm dialogue = new DialogForm(null, "Ajouter " + type);
        dialogue.btnValider.addActionListener(e -> {
            if (type.equals("Abonne")) {
                vue.modeleAbonne.addRow(new Object[]{vue.modeleAbonne.getRowCount()+1, dialogue.txtNom.getText(), dialogue.txtAdresse.getText(), "2026", 0});
            } else {
                vue.modeleCassette.addRow(new Object[]{vue.modeleCassette.getRowCount()+1, dialogue.txtTitre.getText(), dialogue.txtAuteur.getText(), "90", "500", "Action"});
            }
            dialogue.dispose();
        });
        dialogue.setVisible(true);
    }

    public void executerModification(JTable table, String type) {
        int ligne = table.getSelectedRow();
        if (ligne == -1) { JOptionPane.showMessageDialog(null, "Selectionnez une ligne"); return; }

        DialogForm dialogue = new DialogForm(null, "Modifier " + type);

        if (type.equals("Abonne")) {
            dialogue.txtNom.setText(table.getValueAt(ligne, 1).toString());
            dialogue.txtAdresse.setText(table.getValueAt(ligne, 2).toString());
        } else {
            dialogue.txtTitre.setText(table.getValueAt(ligne, 1).toString());
            dialogue.txtAuteur.setText(table.getValueAt(ligne, 2).toString());
        }

        dialogue.btnValider.addActionListener(e -> {
            if (type.equals("Abonne")) {
                table.setValueAt(dialogue.txtNom.getText(), ligne, 1);
                table.setValueAt(dialogue.txtAdresse.getText(), ligne, 2);
            } else {
                table.setValueAt(dialogue.txtTitre.getText(), ligne, 1);
                table.setValueAt(dialogue.txtAuteur.getText(), ligne, 2);
            }
            dialogue.dispose();
        });
        dialogue.setVisible(true);
    }

    public void executerSuppression(JTable table) {
        int ligne = table.getSelectedRow();
        if (ligne != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Supprimer cet element ?", "Attention", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ((DefaultTableModel)table.getModel()).removeRow(ligne);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selectionnez une ligne");
        }
    }
}