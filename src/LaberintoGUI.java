import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class LaberintoGUI extends JFrame { // CLASE RENOMBRADA

    private char[][] laberinto; // VARIABLE RENOMBRADA
    private LaberintoPanel panelLaberinto; // VARIABLE RENOMBRADA
    private JTextArea areaSalida;
    private JButton botonResolver;
    private JButton botonReiniciar;

    public LaberintoGUI(char[][] laberintoInicial) {
        this.laberinto = laberintoInicial;
        setTitle("Solucionador de Laberintos BFS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     
        panelLaberinto = new LaberintoPanel(laberinto);
        add(panelLaberinto, BorderLayout.CENTER);

        //Área de salida para mensajes
        areaSalida = new JTextArea(3, 20);
        areaSalida.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaSalida);
        add(scrollPane, BorderLayout.SOUTH);

        // Botones
        JPanel panelBotones = new JPanel();
        botonResolver = new JButton("Resolver Laberinto");
        botonReiniciar = new JButton("Reiniciar");

        botonResolver.addActionListener(e -> resolverLaberinto()); 
        botonReiniciar.addActionListener(e -> reiniciarLaberinto()); 

        panelBotones.add(botonResolver);
        panelBotones.add(botonReiniciar);
        add(panelBotones, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void resolverLaberinto() {
        areaSalida.setText("Buscando el camino más corto...\n");
        botonResolver.setEnabled(false);

        //Ejecutar el BFS y obtener el camino
        List<Celda> caminoEncontrado = LaberintoSolver.encontrarCaminoBFS(laberinto);
        if (caminoEncontrado != null) {
            panelLaberinto.setCamino(caminoEncontrado); 
            areaSalida.append("¡Camino encontrado!\n");
            areaSalida.append("Longitud del camino: " + (caminoEncontrado.size() - 1) + " movimientos.");
        } else {
            panelLaberinto.setCamino(null);
            areaSalida.append("No se encontró un camino válido.\n");
        }
    }

    private void reiniciarLaberinto() { 
        areaSalida.setText("Laberinto reiniciado.\n");
        panelLaberinto.reset(); 
        botonResolver.setEnabled(true);
    }

    public static void main(String[] args) {
        // Laberinto de ejemplo:
        char[][] laberinto = {
            {'S', '0', 'X', '0', '0'},
            {'0', '0', 'X', '0', 'X'},
            {'X', '0', '0', '0', '0'},
            {'X', 'X', 'X', '0', 'E'}
        };

        SwingUtilities.invokeLater(() -> new LaberintoGUI(laberinto)); // CLASE GUI RENOMBRADA
    }
}