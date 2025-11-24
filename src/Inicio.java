import javax.swing.SwingUtilities;

public class Inicio {
    public static void main(String[] args) throws Exception {
                // Laberinto de ejemplo:
        char[][] laberinto = {
            {'S', '0', 'X', '0', '0'},
            {'0', '0', 'X', '0', 'X'},
            {'X', '0', '0', '0', '0'},
            {'X', 'X', 'X', 'X', '0'},
            {'X', '0', '0', '0', '0'},
            {'X', 'X', 'X', 'X', 'E'}
        };

        SwingUtilities.invokeLater(() -> new LaberintoGUI(laberinto)); //Clase para la gráfica
    
    }//main
}//Inicio
