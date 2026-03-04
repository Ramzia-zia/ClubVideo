package com.videoclub.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelAbonne extends JPanel {
    private JTable table;
    private DefaultTableModel modele;

    public PanelAbonne() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        String[] colonnes = {"N°", "NOM", "ADRESSE", "INSCRIPTION", "LOCATIONS"};
        modele = new DefaultTableModel(colonnes, 0);

        table = new JTable(modele);
        table.setRowHeight(35);
        table.setShowVerticalLines(false);
        table.setSelectionBackground(new Color(0, 113, 227));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        add(scroll, BorderLayout.CENTER);
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getModele() { return modele; }
}