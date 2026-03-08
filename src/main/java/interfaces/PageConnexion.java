package interfaces;

import javax.swing.*;
import java.awt.*;

public class PageConnexion extends JFrame {

    private JTextField txtUtilisateur;
    private JPasswordField txtMotDePasse;

    public PageConnexion() {
        setTitle("Club Video - Connexion");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Titre
        JLabel lblTitre = new JLabel("CLUB VIDEO", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitre.setForeground(new Color(50, 50, 50));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitre, gbc);

        // Separateur
        JSeparator sep = new JSeparator();
        gbc.gridy = 1;
        panel.add(sep, gbc);

        // Utilisateur
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Utilisateur :"), gbc);

        gbc.gridx = 1;
        txtUtilisateur = new JTextField(15);
        panel.add(txtUtilisateur, gbc);

        // Mot de passe
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Mot de passe :"), gbc);

        gbc.gridx = 1;
        txtMotDePasse = new JPasswordField(15);
        panel.add(txtMotDePasse, gbc);

        // Bouton
        JButton btnConnecter = new JButton("Se connecter");
        btnConnecter.setBackground(new Color(60, 60, 60));
        btnConnecter.setForeground(Color.WHITE);
        btnConnecter.setFont(new Font("Arial", Font.BOLD, 13));
        btnConnecter.setFocusPainted(false);
        btnConnecter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(btnConnecter, gbc);

        btnConnecter.addActionListener(e -> seConnecter());
        txtMotDePasse.addActionListener(e -> seConnecter());

        setVisible(true);
    }

    private void seConnecter() {
        String user = txtUtilisateur.getText().trim();
        String pass = new String(txtMotDePasse.getPassword()).trim();

        if (user.equals("admin") && pass.equals("ramzia123")) {
            new PageAccueil();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects !",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}