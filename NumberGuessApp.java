import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessApp extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private int randomNumber;
    private Random random;

    public NumberGuessApp() {
        // Titel des Fenster
        setTitle("Zahlenraten Spiel");
        //Größe des Fensters
        setSize(400, 650);
        //Fenster per X schließen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Fenster größe nicht änderbar
        setResizable(false);

        random = new Random();

         // CardLayout erstellen
         cardLayout = new CardLayout();
         mainPanel = new JPanel(cardLayout);
 
         // Verschiedene Bildschirme als Panels hinzufügen
         mainPanel.add(createStartScreen(), "StartScreen");
         mainPanel.add(createGameScreen(), "GameScreen");
         mainPanel.add(createWinScreen(), "WinScreen");
         mainPanel.add(createLoseScreen(), "LoseScreen");
 
         // Panel dem JFrame hinzufügen
         add(mainPanel);
 
         // Start mit dem Startbildschirm
         cardLayout.show(mainPanel, "StartScreen");
     }
 
     // Startbildschirm
     private JPanel createStartScreen() {
         JPanel panel = new JPanel();
         panel.setLayout(null);
    //Text 
         JLabel label = new JLabel("Willkommen beim Zahlenraten!");
         label.setBounds(25, 250, 550, 20);
         label.setFont(new Font("Arial", Font.BOLD, 20));
    //ModusButton
         JButton ModusButton = new JButton("Soon");
         ModusButton.setBounds(200, 500, 150, 40);
         ModusButton.setFont(new Font("Arial", Font.BOLD, 16));
    //startButton
         JButton startButton = new JButton("Spiel starten");
         startButton.setBounds(50, 500, 150, 40);
         startButton.setFont(new Font("Arial", Font.BOLD, 16));
 
         startButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                randomNumber = random.nextInt(100) + 1;
                cardLayout.show(mainPanel, "GameScreen");
             }
         });
 
         panel.add(label, BorderLayout.CENTER);
         panel.add(startButton, BorderLayout.SOUTH);
         panel.add(ModusButton, BorderLayout.SOUTH);
         return panel;
     }
 
     // Mid-Game-Bildschirm
     private JPanel createGameScreen() {
         JPanel panel = new JPanel();
         panel.setLayout(null);

//Text in der Mitte
         JLabel label = new JLabel("Errate die Zahl!", JLabel.CENTER);
         label.setBounds(80, 250, 250, 80);
         label.setFont(new Font("Arial", Font.BOLD, 20));

//TextFeld
         JTextField inputField = new JTextField();
         inputField.setBounds(50, 450, 300, 40);
         
//Rate Button         
         JButton guessButton = new JButton("Rate!");
         guessButton.setBounds(125, 490, 150, 40);
         guessButton.setFont(new Font("Arial", Font.BOLD, 16));

         JButton winButton = new JButton("Gewonnen!");
         JButton loseButton = new JButton("Verloren!");
 
         guessButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                    int eingabe = Integer.parseInt(inputField.getText()); // Benutzereingabe aus dem Textfeld
                    if (eingabe < randomNumber) {
                        JOptionPane.showMessageDialog(panel, "Zu niedrig! Versuch es nochmal.");
                    } else if (eingabe > randomNumber) {
                        JOptionPane.showMessageDialog(panel, "Zu hoch! Versuch es nochmal.");
                    } else {
                        cardLayout.show(mainPanel, "WinScreen"); // Zum Gewonnen-Bildschirm wechseln
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Bitte eine gültige Zahl eingeben.");
                }
                inputField.setText(""); // Eingabefeld zurücksetzen
            }
        });

         // Wenn der Spieler gewinnt
         winButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cardLayout.show(mainPanel, "WinScreen");
             }
         });
 
         // Wenn der Spieler verliert
         loseButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cardLayout.show(mainPanel, "LoseScreen");
             }
         });
 
         panel.add(label, BorderLayout.CENTER);
         panel.add(inputField, BorderLayout.SOUTH);
         panel.add(guessButton, BorderLayout.SOUTH);
         panel.add(winButton, BorderLayout.WEST);
         panel.add(loseButton, BorderLayout.EAST);
         return panel;
     }
 
     // Gewinnen-Bildschirm
     private JPanel createWinScreen() {
         JPanel panel = new JPanel();
         JLabel label = new JLabel("Du hast gewonnen!", JLabel.CENTER);
         JButton restartButton = new JButton("Neues Spiel");
 
         restartButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cardLayout.show(mainPanel, "StartScreen");
             }
         });
 
         panel.setLayout(new BorderLayout());
         panel.add(label, BorderLayout.CENTER);
         panel.add(restartButton, BorderLayout.SOUTH);
         return panel;
     }
 
     // Verlieren-Bildschirm
     private JPanel createLoseScreen() {
         JPanel panel = new JPanel();
         JLabel label = new JLabel("Du hast verloren!", JLabel.CENTER);
         JButton restartButton = new JButton("Neues Spiel");
 
         restartButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cardLayout.show(mainPanel, "StartScreen");
             }
         });
 
         panel.setLayout(new BorderLayout());
         panel.add(label, BorderLayout.CENTER);
         panel.add(restartButton, BorderLayout.SOUTH);
         return panel;
     }

    public void start() {
        NumberGuessApp app = new NumberGuessApp();
        app.setVisible(true);
    }
}
