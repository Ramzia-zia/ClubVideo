package com.videoclub.view;
import javax.swing.*;
import java.awt.*;

public class DialogForm extends JDialog {
    public JTextField txtNom = new JTextField(15), txtAdresse = new JTextField(15);
    public JTextField txtTitre = new JTextField(15), txtAuteur = new JTextField(15);
    public JButton btnValider = new JButton("Valider");

    public DialogForm(Frame parent, String titre) {
        super(parent, titre, true);
        setLayout(new FlowLayout());
        setSize(300, 300);

        // Ajout des composants selon le titre
        if(titre.contains("Abonné")) {
            add(new JLabel("Nom :")); add(txtNom);
            add(new JLabel("Adresse :")); add(txtAdresse);
        } else {
            add(new JLabel("Titre :")); add(txtTitre);
            add(new JLabel("Auteur :")); add(txtAuteur);
        }
        add(btnValider);
        setLocationRelativeTo(parent);
    }
}