package com.example.euroapesetas;

/**
 * com.example.euroapesetas
 * Nombre_project: EuroaPesetas
 * CalculadoraEurosPesetas
 * Created by: sheng
 * Date : 10/02/2022
 * Description:
 **/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class CalculadoraEurosPesetas extends JPanel {
    private JTextField cantidad;
    private JTextField resultado;
    private final double TASA_CAMBIO = 166.386;
    private double cambioEfectivo = TASA_CAMBIO;

    public CalculadoraEurosPesetas() {
        add(new JLabel("Cantidad a convertir"));
        cantidad = new JTextField("0.0", 6);
        add(cantidad);
        add(new JLabel("Resultado"));
        resultado = new JTextField("0.0", 6);
        resultado.setEditable(false);
        add(resultado);

        JToggleButton moneda = new JToggleButton("Euros a pesetas", false);
        add(moneda);
        moneda.addActionListener(new OyenteBotonConmutador());
        JButton cambio = new JButton("Cambiar");
        add(cambio);
        cambio.addActionListener(new OyenteCambio());
    }

    class OyenteCambio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double dinero = Double.parseDouble(cantidad.getText());
            dinero = dinero * cambioEfectivo;
            String cadena = String.format("%6.2f", dinero);
            resultado.setText(cadena);
        }

    }
    class OyenteBotonConmutador implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JToggleButton boton = (JToggleButton) e.getSource();
            if (boton.isSelected()) {
                boton.setText("Pesetas a Euros");
                cambioEfectivo = 1 / TASA_CAMBIO;
            } else {
                boton.setText("Euros a pesetas");
                cambioEfectivo = TASA_CAMBIO;
            }
        }

    }


    public void ventana() {
        JFrame ventana = new JFrame("Calculadora cambio de monedas");
        CalculadoraEurosPesetas calc = new CalculadoraEurosPesetas();
        ventana.add(calc);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 200);
        ventana.setVisible(true);
    }


    public static void main(String[] args) {
        CalculadoraEurosPesetas calculadoraEurosPesetas = new CalculadoraEurosPesetas();
        calculadoraEurosPesetas.ventana();


    }

}