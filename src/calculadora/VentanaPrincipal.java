/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Usuario DAM 2
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    Container container;
    JPanel panelSuperior, panelInferior, panelCentral;
    JPanel panelCientifica;
    TextField pantalla;
    JButton estandar, cientifica;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton bSen, bCos, bTan, bLog, bLn;
    JButton ac, masMenos, porcentaje, division, multiplicacion, resta, suma, igual, vacio, punto;
    ActionEvent e = null;
    boolean operando = false;
    Double op1 = 0.0, op2 = 0.0;
    int tipoOperacion;
    Double resultado = 0.0;

    public void initGUI() {
        this.setTitle("Calculadora");
        this.setBounds(50, 50, 500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instancias();
        configurarContainer();
        acciones();
        pack();
    }

    private void instancias() {
        container = this.getContentPane();
        panelCentral = new JPanel();
        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelCientifica = new JPanel();
        pantalla = new TextField();
        pantalla.setEditable(false);
        bSen = new JButton("sin");
        bSen.setActionCommand(Constantes.TAG_sen);
        bCos = new JButton("cos");
        bCos.setActionCommand(Constantes.TAG_cos);
        bTan = new JButton("tan");
        bTan.setActionCommand(Constantes.TAG_tan);
        bLog = new JButton("log");
        bLog.setActionCommand(Constantes.TAG_log);
        estandar = new JButton("Estandar");
        bLn = new JButton("ln");
        bLn.setActionCommand(Constantes.TAG_ln);
        estandar.setActionCommand(Constantes.TAG_estandar);
        cientifica = new JButton("Cientifica");
        cientifica.setActionCommand(Constantes.TAG_cientifica);
        ac = new JButton("AC");
        ac.setActionCommand(Constantes.TAG_ac);
        masMenos = new JButton("+/-");
        masMenos.setActionCommand(Constantes.TAG_masMenos);
        porcentaje = new JButton("%");
        porcentaje.setActionCommand(Constantes.TAG_porcentaje);
        division = new JButton("/");
        division.setActionCommand(Constantes.TAG_division);
        division.setBackground(Color.ORANGE);
        b7 = new JButton("7");
        b7.setActionCommand(Constantes.TAG_b7);
        b8 = new JButton("8");
        b8.setActionCommand(Constantes.TAG_b8);
        b9 = new JButton("9");
        b9.setActionCommand(Constantes.TAG_b9);
        multiplicacion = new JButton("*");
        multiplicacion.setActionCommand(Constantes.TAG_multiplicacion);
        multiplicacion.setBackground(Color.ORANGE);
        b4 = new JButton("4");
        b4.setActionCommand(Constantes.TAG_b4);
        b5 = new JButton("5");
        b5.setActionCommand(Constantes.TAG_b5);
        b6 = new JButton("6");
        b6.setActionCommand(Constantes.TAG_b6);
        resta = new JButton("-");
        resta.setActionCommand(Constantes.TAG_resta);
        resta.setBackground(Color.ORANGE);
        b1 = new JButton("1");
        b1.setActionCommand(Constantes.TAG_b1);
        b2 = new JButton("2");
        b2.setActionCommand(Constantes.TAG_b2);
        b3 = new JButton("3");
        b3.setActionCommand(Constantes.TAG_b3);
        suma = new JButton("+");
        suma.setActionCommand(Constantes.TAG_suma);
        suma.setBackground(Color.ORANGE);
        b0 = new JButton("0");
        b0.setActionCommand(Constantes.TAG_b0);
        vacio = new JButton("");
        vacio.setActionCommand(Constantes.TAG_vacio);
        punto = new JButton(".");
        punto.setActionCommand(Constantes.TAG_punto);
        igual = new JButton("=");
        igual.setActionCommand(Constantes.TAG_igual);
        igual.setBackground(Color.ORANGE);
        panelCientifica.setLayout(new GridLayout(5, 1, 1, 1));
        panelCientifica.add(bSen);
        panelCientifica.add(bCos);
        panelCientifica.add(bTan);
        panelCientifica.add(bLog);
        panelCientifica.add(bLn);
    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configSuperior(), BorderLayout.NORTH);
        container.add(configInferior(), BorderLayout.SOUTH);
        container.add(configCentral(), BorderLayout.CENTER);
    }

    private JPanel configSuperior() {
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.add(pantalla, BorderLayout.CENTER);
        pantalla.setBackground(Color.GRAY);
        pantalla.setForeground(Color.WHITE);

        return panelSuperior;
    }

    private JPanel configInferior() {
        panelInferior.add(estandar);
        panelInferior.add(cientifica);

        return panelInferior;
    }

    private JPanel configCentral() {
        panelCentral.setLayout(new GridLayout(5, 4, 1, 1));
        panelCentral.add(ac);
        panelCentral.add(masMenos);
        panelCentral.add(porcentaje);
        panelCentral.add(division);
        panelCentral.add(b7);
        panelCentral.add(b8);
        panelCentral.add(b9);
        panelCentral.add(multiplicacion);
        panelCentral.add(b4);
        panelCentral.add(b5);
        panelCentral.add(b6);
        panelCentral.add(resta);
        panelCentral.add(b1);
        panelCentral.add(b2);
        panelCentral.add(b3);
        panelCentral.add(suma);
        panelCentral.add(b0);
        panelCentral.add(vacio);
        panelCentral.add(punto);
        panelCentral.add(igual);

        return panelCentral;
    }

    private void acciones() {
        Component[] componentes = panelCentral.getComponents();
        for (Component item : componentes) {
            ((JButton) item).addActionListener(this);
        }

        Component[] componentes1 = panelInferior.getComponents();
        for (Component item : componentes1) {
            ((JButton) item).addActionListener(this);
        }

        Component[] componentes2 = panelCientifica.getComponents();
        for (Component item : componentes2) {
            ((JButton) item).addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case Constantes.TAG_b0:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "0");
                } else {
                    pantalla.setText("0");
                    operando = false;
                }
                break;
            case Constantes.TAG_b1:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "1");
                } else {
                    pantalla.setText("1");
                    operando = false;
                }
                break;
            case Constantes.TAG_b2:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "2");
                } else {
                    pantalla.setText("2");
                    operando = false;
                }
                break;
            case Constantes.TAG_b3:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "3");
                } else {
                    pantalla.setText("3");
                    operando = false;
                }
                break;
            case Constantes.TAG_b4:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "4");
                } else {
                    pantalla.setText("4");
                    operando = false;
                }
                break;
            case Constantes.TAG_b5:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "5");
                } else {
                    pantalla.setText("5");
                    operando = false;
                }
                break;
            case Constantes.TAG_b6:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "6");
                } else {
                    pantalla.setText("6");
                    operando = false;
                }
                break;
            case Constantes.TAG_b7:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "7");
                } else {
                    pantalla.setText("7");
                    operando = false;
                }
                break;
            case Constantes.TAG_b8:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "8");
                } else {
                    pantalla.setText("8");
                    operando = false;
                }
                break;
            case Constantes.TAG_b9:
                if (!operando) {
                    pantalla.setText(pantalla.getText() + "9");
                } else {
                    pantalla.setText("9");
                    operando = false;
                }
                break;
            case Constantes.TAG_ac:
                pantalla.setText("");
                op1 = 0.0;
                op2 = 0.0;
                tipoOperacion = 0;
                punto.setEnabled(true);
                break;
            case Constantes.TAG_cientifica:
                if (!panelCientifica.isShowing()) {
                    container.add(panelCientifica, BorderLayout.WEST);
                }
                pack();
                break;
            case Constantes.TAG_estandar:
                if (panelCientifica.isShowing()) {
                    container.remove(panelCientifica);
                }
                pack();
                break;
            case Constantes.TAG_division:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(pantalla.getText());
                    punto.setEnabled(true);
                    tipoOperacion = 4;
                    break;
                }
            case Constantes.TAG_igual:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    op2 = Double.valueOf(pantalla.getText());

                    switch (tipoOperacion) {
                        case 1:
                            resultado = op1 + op2;
                            break;
                        case 2:
                            resultado = op1 - op2;
                            break;
                        case 3:
                            resultado = op1 * op2;
                            break;
                        case 4:
                            resultado = op1 / op2;
                            break;
                        case 5:
                            resultado = (op1 / 100) * op2;
                            break;
                    }
                    pantalla.setText(Double.toString(resultado));
                    punto.setEnabled(false);
                    break;
                }
            case Constantes.TAG_masMenos:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    Double num;
                    String cadena;
                    cadena = pantalla.getText();
                    num = (-1) * Double.valueOf(cadena);
                    pantalla.setText(num.toString());
                    break;
                }
            case Constantes.TAG_multiplicacion:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(pantalla.getText());
                    punto.setEnabled(true);
                    tipoOperacion = 3;
                    break;
                }
            case Constantes.TAG_vacio:
                break;
            case Constantes.TAG_punto:
                if (pantalla.getText().isEmpty()) {
                    pantalla.setText("0.");
                    punto.setEnabled(false);
                    break;
                } else {
                    pantalla.setText(pantalla.getText() + ".");
                    punto.setEnabled(false);
                    break;
                }
            case Constantes.TAG_resta:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(pantalla.getText());
                    punto.setEnabled(true);
                    tipoOperacion = 2;
                    break;
                }
            case Constantes.TAG_suma:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(pantalla.getText());
                    punto.setEnabled(true);
                    tipoOperacion = 1;
                    break;
                }
            case Constantes.TAG_porcentaje:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(pantalla.getText());
                    punto.setEnabled(true);
                    tipoOperacion = 5;
                    break;
                }
            case Constantes.TAG_sen:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(pantalla.getText());
                    op1 = Math.toRadians(op1);
                    op2 = op1;
                    resultado = Math.sin(op1);
                    pantalla.setText(Double.toString(resultado));
                    punto.setEnabled(false);
                    break;
                }
            case Constantes.TAG_cos:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(pantalla.getText());
                    op1 = Math.toRadians(op1);
                    op2 = op1;
                    resultado = Math.cos(op1);
                    pantalla.setText(Double.toString(resultado));
                    punto.setEnabled(false);
                    break;
                }
            case Constantes.TAG_tan:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(pantalla.getText());
                    op1 = Math.toRadians(op1);
                    op2 = op1;
                    resultado = Math.tan(op1);
                    pantalla.setText(Double.toString(resultado));
                    punto.setEnabled(false);
                    break;
                }
            case Constantes.TAG_log:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(pantalla.getText());
                    op2 = op1;
                    resultado = Math.log10(op1);
                    pantalla.setText(Double.toString(resultado));
                    punto.setEnabled(false);
                    break;
                }
            case Constantes.TAG_ln:
                if (pantalla.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(pantalla.getText());
                    op2 = op1;
                    resultado = Math.log(op1);
                    pantalla.setText(Double.toString(resultado));
                    punto.setEnabled(false);
                    break;
                }

        }
    }

}