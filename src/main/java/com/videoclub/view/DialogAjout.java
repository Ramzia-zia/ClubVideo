package com.videoclub.view;

import javax.swing.*;
import java.awt.*;

public class DialogAjout extends JDialog {
    public JTextField txtNom = new JTextField(15);
    public JTextField txtAdresse = new JTextField(15);
    public JButton btnValider = new JButton("Ajouter");

    public DialogAjout(Frame parent) {
        super(parent, "Nouvel Abonne", true);
        setSize(300, 250);
        setLayout(new GridLayout(0, 1, 10, 10));
        setLocationRelativeTo(parent);

        add(new JLabel("Nom de l'abonne :"));
        add(txtNom);
        add(new JLabel("Adresse :"));
        add(txtAdresse);
        add(btnValider);
    }
}