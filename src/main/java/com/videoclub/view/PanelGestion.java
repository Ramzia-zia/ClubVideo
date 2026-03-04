package com.videoclub.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelGestion extends JPanel {
    public DefaultTableModel modeleAbonne, modeleCassette;
    public JTable tableAbonne, tableCassette;

    public PanelGestion() {
        setLayout(new GridLayout(2, 1, 10, 20));
        setBackground(Color.WHITE);

        // Configuration Abonnés
        String[] colA = {"ID", "NOM", "ADRESSE", "DATE ABONN.", "LOCATIONS"};
        modeleAbonne = new DefaultTableModel(colA, 0);
        tableAbonne = initialiserTable(modeleAbonne);

        // Configuration Cassettes
        String[] colC = {"ID", "TITRE", "AUTEUR", "DURÉE", "PRIX", "CATÉGORIE"};
        modeleCassette = new DefaultTableModel(colC, 0);
        tableCassette = initialiserTable(modeleCassette);

        add(new JScrollPane(tableAbonne));
        add(new JScrollPane(tableCassette));
    }

    private JTable initialiserTable(DefaultTableModel model) {
        JTable t = new JTable(model);
        t.setRowHeight(35);
        t.setShowVerticalLines(false);
        t.setSelectionBackground(new Color(0, 113, 227));
        return t;
    }

    // Getters pour le contrôleur
    public JTable getTableAbonne() { return tableAbonne; }
    public JTable getTableCassette() { return tableCassette; }
}