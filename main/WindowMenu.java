package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.Data;
import main.Main;
import main.Result;
import main.Simulation;
import main.Simulator;

public class WindowMenu {
    static JFrame asd = new JFrame("MixTipsz simulator");
    static int y = 600;
    static int x = 800;
    
    public static void mainMenu() {
        
        JPanel panle = new JPanel();
        panle.setVisible(true);
        panle.setBounds(0, 0, x, y);
        asd.setVisible(true);
        asd.setBounds(0, 0, x, y);
        asd.setDefaultCloseOperation(3);
        asd.setLayout(null);
        panle.setLayout(null);
        JButton start = new JButton("START");
        start.setBounds(x / 2 - 100 / 2, y / 2 - 30 / 2, 100, 30);
        JButton quit = new JButton("QUIT");
        quit.setBounds(x / 2 - 100 / 2, y / 2 + 65 / 2, 100, 30);
        panle.add(start);
        panle.add(quit);
        asd.add(panle);
        ActionListener clickbutton = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("START")) {
                    panle.setVisible(false);
                    subMenu();

                }
                if (e.getActionCommand().equals("QUIT")) {
                    System.exit(1);

                }
            }
        };
        start.addActionListener(clickbutton);
        quit.addActionListener(clickbutton);
    }

    public static void subMenu () {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, x, y);
        asd.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);
        JButton button = new JButton("STATISTICS");
        JButton mixtipsz = new JButton("MIXTIPSZ");
        JButton simulation = new JButton("SIMULATION");
        JButton back = new JButton("BACK");
        button.setBounds(x / 2 - 100 / 2, y / 2 - 100 / 2, 100, 30);
        mixtipsz.setBounds(x / 2 - 100 / 2, y / 2 - 35 / 2, 100, 30);
        simulation.setBounds(x / 2 - 100 / 2, y / 2 + 31 / 2, 100, 30);
        back.setBounds(x / 2 - 100 / 2, y / 2 + 100 / 2, 100, 30);
        panel.add(button);
        panel.add(mixtipsz);
        panel.add(simulation);
        panel.add(back);
        ActionListener clickbutton = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("BACK")) {
                    panel.setVisible(false);
                    mainMenu();
                }
                else if (e.getActionCommand().equals("MIXTIPSZ")) {
                    panel.setVisible(false);
                    mixszTipsz();
                }
            }
        };
        back.addActionListener(clickbutton);
        mixtipsz.addActionListener(clickbutton);
    }

    public static void mixszTipsz() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, x, y);
        asd.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);
        JButton back = new JButton("BACK");
        JButton generate = new JButton("GENERATE");
        JTextField input = new JTextField("0");
        
        
        Team[] teams = Data.getTeams("csv/teams.csv");
        String[] strTeams = new String[teams.length];
        for (int i = 0; i < teams.length; i++) {
            strTeams[i] = teams[i].getName();
        }
        
        JComboBox tA = new JComboBox(strTeams);
        JComboBox tB = new JComboBox(strTeams);
        JTextField output = new JTextField();
        
        output.setBounds(10, 120, 700, 100);
        tA.setBounds(10, 10, 300, 100);
        tB.setBounds(350, 10, 300, 100);
        
        
        input.setBounds(x / 2 - 305 / 2, y / 2 - 100 / 2, 100, 30);
        generate.setBounds(x / 2 - 100 / 2, y / 2 - 100 / 2, 100, 30);
        back.setBounds(x / 2 - 100 / 2, y / 2 + 50 / 2, 100, 30);
       
        panel.add(back);
        panel.add(generate);
        panel.add(input);
        panel.add(tA);
        panel.add(tB);
        panel.add(output);

        
        ActionListener clickButton = new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("BACK")) {
                    panel.setVisible(false);
                    subMenu();
                }
                else if (e.getActionCommand().equals("GENERATE")) {
                    int rounds = Integer.parseInt(input.getText());
                    
                    String teamFirst = tA.getSelectedItem().toString();
                    String teamSecond = tB.getSelectedItem().toString();
                    Team a1 = teams[0];
                    Team b1 = teams[1];
                    for (int i = 0; i < teams.length; i++) {
                        if (teams[i].getName().equals(teamFirst)) {
                            a1 = teams[i];
                        }
                        if (teams[i].getName().equals(teamSecond)) {
                            b1 = teams[i];
                        }
                    }
                   
                    Simulation sim = Main.generateSimulation(rounds, a1, b1);
                    Simulator simulator = new Simulator(sim, new Logger(true));
                    Result result = simulator.run();
                    output.setText(result.getWinner().getName() + "'s chance to win: " + Math.round(result.getProbability()) + " %.");
                    
                }
            }
        };
        back.addActionListener(clickButton);
        generate.addActionListener(clickButton);
    }

}