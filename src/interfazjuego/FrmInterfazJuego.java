/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfazjuego;

import javax.swing.JButton;
import juego.Juego;
import tablero.Carta;
import tablero.Nivel;

/**
 *
 * @author Dylan
 */
public class FrmInterfazJuego extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmInterfazJuego.class.getName());

    private Nivel nivelActual = Nivel.PRINCIPIANTE; 
    private JButton[][] botonesTablero;
    private Juego juego;

    
    
    
    
    /**
     * Creates new form frmVista
     */
    public FrmInterfazJuego() {
        initComponents();
        OrdenBotonesTablero();
        juego = new Juego();
        mostrarBotonesNivel();
        iniciarTiempo();
    }
    
        
    
   //Metodos funcionales
   //Se meten los botones a la matriz
    private void OrdenBotonesTablero(){
        botonesTablero = new JButton[][]{
         {btns33, btns34, btns25, btns26, btns27, btns28, btns49, btns50},
        {btns35, btns36, btns29, btns30, btns31, btns32, btns51, btns52},
        {btns37, btns38, btns1,  btns2,  btns3,  btns4,  btns53, btns54},
        {btns39, btns40, btns5,  btns6,  btns7,  btns8,  btns55, btns56},
        {btns41, btns42, btns9,  btns10, btns11, btns12, btns57, btns58},
        {btns43, btns44, btns13, btns14, btns15, btns16, btns59, btns60},
        {btns45, btns46, btns17, btns18, btns19, btns20, btns61, btns62},
        {btns47, btns48, btns21, btns22, btns23, btns24, btns63, btns64}   
        };
    }
    
   private void actualizarCarta(int fila, int columna) {
    Carta carta = juego.obtenerCarta(fila, columna);
    JButton boton = botonesTablero[fila][columna];
    
    if (carta.isVisible() || carta.isEncontrada()) {
        java.net.URL recurso = getClass().getResource("/imagenes/imagen " + carta.getImagen() + ".jpeg");
        if (recurso != null) {
            boton.setIcon(new javax.swing.ImageIcon(recurso));
        } else {
            boton.setIcon(null);
        }
    } else {
        boton.setIcon(null);
    }
}
    
    private void actualizarTablero() {
    int filas = filaNivel();
    int columnas = columnaNivel();
    for (int fila = 0; fila < filas; fila++) {
        for (int columna = 0; columna < columnas; columna++) {
            actualizarCarta(fila, columna);
        }
    }
}
    
    private void posicionCarta(int fila, int columna){
        juego.seleccionarCarta(fila, columna);
        actualizarCarta(fila,columna);
        actualizarStats();  
        
        if (juego.isBloqueado()) {
        javax.swing.Timer timer = new javax.swing.Timer(2000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juego.ocultarCartas();
                actualizarTablero();
            }
        });
        timer.setRepeats(false);
        timer.start();
        } 
        if (juego.juegoFinalizado()) {
        mostrarPantallaFinal();
        }
    }
    
    private void mostrarBotonesNivel(){
    int filas = filaNivel();
    int columnas = columnaNivel();

    for (int fila = 0; fila < botonesTablero.length; fila++){
        for (int columna = 0; columna < botonesTablero[fila].length; columna++){
            botonesTablero[fila][columna].setVisible(fila < filas && columna < columnas);
        }
    }
}
    
    private void iniciarTiempo(){
    javax.swing.Timer timerReloj = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            juego.getControladorJugador().aumentarTiempo();
            lblValorTiempo.setText(String.valueOf(juego.getTiempo()));
        }
    });
    timerReloj.start();
    }
    
    public int filaNivel(){
        if (nivelActual == Nivel.AVANZADO) {
        return 8;
    }else {
        return 4;
        }
    }
    
    public int columnaNivel(){
        if (nivelActual == Nivel.PRINCIPIANTE) {
        return 4;
    }else {
        return 8;
        }
    }
    
    public void mostrarPantallaFinal(){
       javax.swing.JOptionPane.showMessageDialog(this,
        "--Felicidades, has terminado el juego de parejas--\n\n" +
        "Tu puntaje es: " + juego.getPuntaje() + "\n" +
        "Tus Intentos son: " + juego.getIntentos() + "\n" +
        "Tu Tiempo fue: " + juego.getTiempo() + " segundos",
        "Juego terminado",
        javax.swing.JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public void actualizarStats(){
        lblValorPuntaje.setText(String.valueOf(juego.getPuntaje()));
        lblValorIntentos.setText(String.valueOf(juego.getIntentos()));
        lblValorParejas.setText(juego.getParejas() +"/"+ (nivelActual.getTotalParejas()));
        lblValorTiempo.setText(String.valueOf(juego.getTiempo()));        
    }
    
    public void cambiarNivel(Nivel nuevoNivel){
        nivelActual = nuevoNivel;
        juego.cambiarNivel(nivelActual);
        mostrarBotonesNivel();
        actualizarTablero();
        actualizarStats();
    }
    
    
    
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        rbPrincipiante = new javax.swing.JRadioButton();
        rbIntermedio = new javax.swing.JRadioButton();
        rbAvanzado = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblParejas = new javax.swing.JLabel();
        lblValorTiempo = new javax.swing.JLabel();
        lblValorParejas = new javax.swing.JLabel();
        lblValorPuntaje = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        lblIntentos = new javax.swing.JLabel();
        lblValorIntentos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelTablero = new javax.swing.JPanel();
        btns33 = new javax.swing.JButton();
        btns34 = new javax.swing.JButton();
        btns25 = new javax.swing.JButton();
        btns26 = new javax.swing.JButton();
        btns27 = new javax.swing.JButton();
        btns28 = new javax.swing.JButton();
        btns49 = new javax.swing.JButton();
        btns50 = new javax.swing.JButton();
        btns35 = new javax.swing.JButton();
        btns36 = new javax.swing.JButton();
        btns29 = new javax.swing.JButton();
        btns30 = new javax.swing.JButton();
        btns31 = new javax.swing.JButton();
        btns32 = new javax.swing.JButton();
        btns51 = new javax.swing.JButton();
        btns52 = new javax.swing.JButton();
        btns37 = new javax.swing.JButton();
        btns38 = new javax.swing.JButton();
        btns1 = new javax.swing.JButton();
        btns2 = new javax.swing.JButton();
        btns3 = new javax.swing.JButton();
        btns4 = new javax.swing.JButton();
        btns53 = new javax.swing.JButton();
        btns54 = new javax.swing.JButton();
        btns39 = new javax.swing.JButton();
        btns40 = new javax.swing.JButton();
        btns5 = new javax.swing.JButton();
        btns6 = new javax.swing.JButton();
        btns7 = new javax.swing.JButton();
        btns8 = new javax.swing.JButton();
        btns55 = new javax.swing.JButton();
        btns56 = new javax.swing.JButton();
        btns41 = new javax.swing.JButton();
        btns42 = new javax.swing.JButton();
        btns9 = new javax.swing.JButton();
        btns10 = new javax.swing.JButton();
        btns11 = new javax.swing.JButton();
        btns12 = new javax.swing.JButton();
        btns57 = new javax.swing.JButton();
        btns58 = new javax.swing.JButton();
        btns43 = new javax.swing.JButton();
        btns44 = new javax.swing.JButton();
        btns13 = new javax.swing.JButton();
        btns14 = new javax.swing.JButton();
        btns15 = new javax.swing.JButton();
        btns16 = new javax.swing.JButton();
        btns59 = new javax.swing.JButton();
        btns60 = new javax.swing.JButton();
        btns45 = new javax.swing.JButton();
        btns46 = new javax.swing.JButton();
        btns17 = new javax.swing.JButton();
        btns18 = new javax.swing.JButton();
        btns19 = new javax.swing.JButton();
        btns20 = new javax.swing.JButton();
        btns61 = new javax.swing.JButton();
        btns62 = new javax.swing.JButton();
        btns47 = new javax.swing.JButton();
        btns48 = new javax.swing.JButton();
        btns21 = new javax.swing.JButton();
        btns22 = new javax.swing.JButton();
        btns23 = new javax.swing.JButton();
        btns24 = new javax.swing.JButton();
        btns63 = new javax.swing.JButton();
        btns64 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(204, 204, 204));

        buttonGroup1.add(rbPrincipiante);
        rbPrincipiante.setText("Principiante");
        rbPrincipiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPrincipianteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbIntermedio);
        rbIntermedio.setText("Intermedio");
        rbIntermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIntermedioActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAvanzado);
        rbAvanzado.setText("Avanzado");
        rbAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAvanzadoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("--- Bienvenido al juego de memoria ---");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Dificultad:");

        lblTiempo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTiempo.setText("Tiempo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Puntaje:");

        lblParejas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblParejas.setText("Parejas:");

        lblValorTiempo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValorTiempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblValorParejas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValorParejas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblValorPuntaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValorPuntaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnReiniciar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        lblIntentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIntentos.setText("Intentos:");

        lblValorIntentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValorIntentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbPrincipiante)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbIntermedio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbAvanzado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReiniciar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblValorPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblParejas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblValorParejas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblTiempo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblValorTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblIntentos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblValorIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbPrincipiante)
                    .addComponent(rbIntermedio)
                    .addComponent(rbAvanzado)
                    .addComponent(btnReiniciar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblParejas)
                    .addComponent(lblValorPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorParejas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTiempo)
                    .addComponent(lblValorTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntentos)
                    .addComponent(lblValorIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        panelTablero.setLayout(new java.awt.GridLayout(8, 8));

        btns33.setActionCommand("33");
        btns33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns33ActionPerformed(evt);
            }
        });
        panelTablero.add(btns33);

        btns34.setActionCommand("34");
        btns34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns34ActionPerformed(evt);
            }
        });
        panelTablero.add(btns34);

        btns25.setActionCommand("25");
        btns25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns25ActionPerformed(evt);
            }
        });
        panelTablero.add(btns25);

        btns26.setActionCommand("26");
        btns26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns26ActionPerformed(evt);
            }
        });
        panelTablero.add(btns26);

        btns27.setActionCommand("27");
        btns27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns27ActionPerformed(evt);
            }
        });
        panelTablero.add(btns27);

        btns28.setActionCommand("28");
        btns28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns28ActionPerformed(evt);
            }
        });
        panelTablero.add(btns28);

        btns49.setActionCommand("49");
        btns49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns49ActionPerformed(evt);
            }
        });
        panelTablero.add(btns49);

        btns50.setActionCommand("50");
        btns50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns50ActionPerformed(evt);
            }
        });
        panelTablero.add(btns50);

        btns35.setActionCommand("35");
        btns35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns35ActionPerformed(evt);
            }
        });
        panelTablero.add(btns35);

        btns36.setActionCommand("36");
        btns36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns36ActionPerformed(evt);
            }
        });
        panelTablero.add(btns36);

        btns29.setActionCommand("29");
        btns29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns29ActionPerformed(evt);
            }
        });
        panelTablero.add(btns29);

        btns30.setActionCommand("30");
        btns30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns30ActionPerformed(evt);
            }
        });
        panelTablero.add(btns30);

        btns31.setActionCommand("31");
        btns31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns31ActionPerformed(evt);
            }
        });
        panelTablero.add(btns31);

        btns32.setActionCommand("32");
        btns32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns32ActionPerformed(evt);
            }
        });
        panelTablero.add(btns32);

        btns51.setActionCommand("51");
        btns51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns51ActionPerformed(evt);
            }
        });
        panelTablero.add(btns51);

        btns52.setActionCommand("52");
        btns52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns52ActionPerformed(evt);
            }
        });
        panelTablero.add(btns52);

        btns37.setActionCommand("37");
        btns37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns37ActionPerformed(evt);
            }
        });
        panelTablero.add(btns37);

        btns38.setActionCommand("38");
        btns38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns38ActionPerformed(evt);
            }
        });
        panelTablero.add(btns38);

        btns1.setActionCommand("1");
        btns1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns1ActionPerformed(evt);
            }
        });
        panelTablero.add(btns1);

        btns2.setActionCommand("2");
        btns2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns2ActionPerformed(evt);
            }
        });
        panelTablero.add(btns2);

        btns3.setActionCommand("3");
        btns3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns3ActionPerformed(evt);
            }
        });
        panelTablero.add(btns3);

        btns4.setActionCommand("4");
        btns4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns4ActionPerformed(evt);
            }
        });
        panelTablero.add(btns4);

        btns53.setActionCommand("53");
        btns53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns53ActionPerformed(evt);
            }
        });
        panelTablero.add(btns53);

        btns54.setActionCommand("54");
        btns54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns54ActionPerformed(evt);
            }
        });
        panelTablero.add(btns54);

        btns39.setActionCommand("39");
        btns39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns39ActionPerformed(evt);
            }
        });
        panelTablero.add(btns39);

        btns40.setActionCommand("40");
        btns40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns40ActionPerformed(evt);
            }
        });
        panelTablero.add(btns40);

        btns5.setActionCommand("5");
        btns5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns5ActionPerformed(evt);
            }
        });
        panelTablero.add(btns5);

        btns6.setActionCommand("6");
        btns6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns6ActionPerformed(evt);
            }
        });
        panelTablero.add(btns6);

        btns7.setActionCommand("7");
        btns7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns7ActionPerformed(evt);
            }
        });
        panelTablero.add(btns7);

        btns8.setActionCommand("8");
        btns8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns8ActionPerformed(evt);
            }
        });
        panelTablero.add(btns8);

        btns55.setActionCommand("55");
        btns55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns55ActionPerformed(evt);
            }
        });
        panelTablero.add(btns55);

        btns56.setActionCommand("56");
        btns56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns56ActionPerformed(evt);
            }
        });
        panelTablero.add(btns56);

        btns41.setActionCommand("41");
        btns41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns41ActionPerformed(evt);
            }
        });
        panelTablero.add(btns41);

        btns42.setActionCommand("42");
        btns42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns42ActionPerformed(evt);
            }
        });
        panelTablero.add(btns42);

        btns9.setActionCommand("9");
        btns9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns9ActionPerformed(evt);
            }
        });
        panelTablero.add(btns9);

        btns10.setActionCommand("10");
        btns10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns10ActionPerformed(evt);
            }
        });
        panelTablero.add(btns10);

        btns11.setActionCommand("11");
        btns11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns11ActionPerformed(evt);
            }
        });
        panelTablero.add(btns11);

        btns12.setActionCommand("12");
        btns12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns12ActionPerformed(evt);
            }
        });
        panelTablero.add(btns12);

        btns57.setActionCommand("57");
        btns57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns57ActionPerformed(evt);
            }
        });
        panelTablero.add(btns57);

        btns58.setActionCommand("58");
        btns58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns58ActionPerformed(evt);
            }
        });
        panelTablero.add(btns58);

        btns43.setActionCommand("43");
        btns43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns43ActionPerformed(evt);
            }
        });
        panelTablero.add(btns43);

        btns44.setActionCommand("44");
        btns44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns44ActionPerformed(evt);
            }
        });
        panelTablero.add(btns44);

        btns13.setActionCommand("13");
        btns13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns13ActionPerformed(evt);
            }
        });
        panelTablero.add(btns13);

        btns14.setActionCommand("14");
        btns14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns14ActionPerformed(evt);
            }
        });
        panelTablero.add(btns14);

        btns15.setActionCommand("15");
        btns15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns15ActionPerformed(evt);
            }
        });
        panelTablero.add(btns15);

        btns16.setActionCommand("16");
        btns16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns16ActionPerformed(evt);
            }
        });
        panelTablero.add(btns16);

        btns59.setActionCommand("59");
        btns59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns59ActionPerformed(evt);
            }
        });
        panelTablero.add(btns59);

        btns60.setActionCommand("60");
        btns60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns60ActionPerformed(evt);
            }
        });
        panelTablero.add(btns60);

        btns45.setActionCommand("45");
        btns45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns45ActionPerformed(evt);
            }
        });
        panelTablero.add(btns45);

        btns46.setActionCommand("46");
        btns46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns46ActionPerformed(evt);
            }
        });
        panelTablero.add(btns46);

        btns17.setActionCommand("17");
        btns17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns17ActionPerformed(evt);
            }
        });
        panelTablero.add(btns17);

        btns18.setActionCommand("18");
        btns18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns18ActionPerformed(evt);
            }
        });
        panelTablero.add(btns18);

        btns19.setActionCommand("19");
        btns19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns19ActionPerformed(evt);
            }
        });
        panelTablero.add(btns19);

        btns20.setActionCommand("20");
        btns20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns20ActionPerformed(evt);
            }
        });
        panelTablero.add(btns20);

        btns61.setActionCommand("61");
        btns61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns61ActionPerformed(evt);
            }
        });
        panelTablero.add(btns61);

        btns62.setActionCommand("62");
        btns62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns62ActionPerformed(evt);
            }
        });
        panelTablero.add(btns62);

        btns47.setActionCommand("47");
        btns47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns47ActionPerformed(evt);
            }
        });
        panelTablero.add(btns47);

        btns48.setActionCommand("48");
        btns48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns48ActionPerformed(evt);
            }
        });
        panelTablero.add(btns48);

        btns21.setActionCommand("21");
        btns21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns21ActionPerformed(evt);
            }
        });
        panelTablero.add(btns21);

        btns22.setActionCommand("22");
        btns22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns22ActionPerformed(evt);
            }
        });
        panelTablero.add(btns22);

        btns23.setActionCommand("23");
        btns23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns23ActionPerformed(evt);
            }
        });
        panelTablero.add(btns23);

        btns24.setActionCommand("24");
        btns24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns24ActionPerformed(evt);
            }
        });
        panelTablero.add(btns24);

        btns63.setActionCommand("63");
        btns63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns63ActionPerformed(evt);
            }
        });
        panelTablero.add(btns63);

        btns64.setActionCommand("64");
        btns64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btns64ActionPerformed(evt);
            }
        });
        panelTablero.add(btns64);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        juego.reiniciarPartida();
        actualizarTablero();
        actualizarStats();
        
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void rbAvanzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAvanzadoActionPerformed
        // TODO add your handling code here:
        cambiarNivel(Nivel.AVANZADO);
    }//GEN-LAST:event_rbAvanzadoActionPerformed

    private void rbIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIntermedioActionPerformed
        // TODO add your handling code here:
        cambiarNivel(Nivel.INTERMEDIO);
    }//GEN-LAST:event_rbIntermedioActionPerformed

    private void rbPrincipianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPrincipianteActionPerformed
        // TODO add your handling code here:
        cambiarNivel(Nivel.PRINCIPIANTE);        
    }//GEN-LAST:event_rbPrincipianteActionPerformed

    private void btns4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns4ActionPerformed
        posicionCarta(2, 5);   // btns4
    }//GEN-LAST:event_btns4ActionPerformed

    private void btns7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns7ActionPerformed
        posicionCarta(3, 4);   // btns7
    }//GEN-LAST:event_btns7ActionPerformed

    private void btns16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns16ActionPerformed
        posicionCarta(5, 5);   // btns16
    }//GEN-LAST:event_btns16ActionPerformed

    private void btns23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns23ActionPerformed
        posicionCarta(7, 4);   // btns23
// TODO add your handling code here:
    }//GEN-LAST:event_btns23ActionPerformed

    private void btns1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns1ActionPerformed
        posicionCarta(2, 2);   // btns1
// TODO add your handling code here:
    }//GEN-LAST:event_btns1ActionPerformed

    private void btns26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns26ActionPerformed
        posicionCarta(0, 3);   // btns26
// TODO add your handling code here:
    }//GEN-LAST:event_btns26ActionPerformed

    private void btns34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns34ActionPerformed
        posicionCarta(0, 1);   // btns34
// TODO add your handling code here:
    }//GEN-LAST:event_btns34ActionPerformed

    private void btns64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns64ActionPerformed
        posicionCarta(7, 7);   // btns64
// TODO add your handling code here:
    }//GEN-LAST:event_btns64ActionPerformed

    private void btns11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns11ActionPerformed
        posicionCarta(4, 4);   // btns11
// TODO add your handling code here:
    }//GEN-LAST:event_btns11ActionPerformed

    private void btns33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns33ActionPerformed
        posicionCarta(0, 0);   // btns33
// TODO add your handling code here:
    }//GEN-LAST:event_btns33ActionPerformed

    private void btns42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns42ActionPerformed
        posicionCarta(4, 1);   // btns42
// TODO add your handling code here:
    }//GEN-LAST:event_btns42ActionPerformed

    private void btns46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns46ActionPerformed
        posicionCarta(6, 1);   // btns46
// TODO add your handling code here:
    }//GEN-LAST:event_btns46ActionPerformed

    private void btns25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns25ActionPerformed
        posicionCarta(0, 2);   // btns25
// TODO add your handling code here:
    }//GEN-LAST:event_btns25ActionPerformed

    private void btns27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns27ActionPerformed
        posicionCarta(0, 4);   // btns27
// TODO add your handling code here:
    }//GEN-LAST:event_btns27ActionPerformed

    private void btns28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns28ActionPerformed
        posicionCarta(0, 5);   // btns28
// TODO add your handling code here:
    }//GEN-LAST:event_btns28ActionPerformed

    private void btns49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns49ActionPerformed
        posicionCarta(0, 6);   // btns49
// TODO add your handling code here:
    }//GEN-LAST:event_btns49ActionPerformed

    private void btns50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns50ActionPerformed
        posicionCarta(0, 7);   // btns50
// TODO add your handling code here:
    }//GEN-LAST:event_btns50ActionPerformed

    private void btns35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns35ActionPerformed
        posicionCarta(1, 0);   // btns35
// TODO add your handling code here:
    }//GEN-LAST:event_btns35ActionPerformed

    private void btns36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns36ActionPerformed
        posicionCarta(1, 1);   // btns36
// TODO add your handling code here:
    }//GEN-LAST:event_btns36ActionPerformed

    private void btns29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns29ActionPerformed
        posicionCarta(1, 2);   // btns29
// TODO add your handling code here:
    }//GEN-LAST:event_btns29ActionPerformed

    private void btns30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns30ActionPerformed
        posicionCarta(1, 3);   // btns30
// TODO add your handling code here:
    }//GEN-LAST:event_btns30ActionPerformed

    private void btns31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns31ActionPerformed
        posicionCarta(1, 4);   // btns31
// TODO add your handling code here:
    }//GEN-LAST:event_btns31ActionPerformed

    private void btns32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns32ActionPerformed
        posicionCarta(1, 5);   // btns32
// TODO add your handling code here:
    }//GEN-LAST:event_btns32ActionPerformed

    private void btns51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns51ActionPerformed
        posicionCarta(1, 6);   // btns51
// TODO add your handling code here:
    }//GEN-LAST:event_btns51ActionPerformed

    private void btns52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns52ActionPerformed
        posicionCarta(1, 7);   // btns52
// TODO add your handling code here:
    }//GEN-LAST:event_btns52ActionPerformed

    private void btns37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns37ActionPerformed
        posicionCarta(2, 0);   // btns37
// TODO add your handling code here:
    }//GEN-LAST:event_btns37ActionPerformed

    private void btns38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns38ActionPerformed
        posicionCarta(2, 1);   // btns38
// TODO add your handling code here:
    }//GEN-LAST:event_btns38ActionPerformed

    private void btns2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns2ActionPerformed
        posicionCarta(2, 3);   // btns2
// TODO add your handling code here:
    }//GEN-LAST:event_btns2ActionPerformed

    private void btns3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns3ActionPerformed
        posicionCarta(2, 4);   // btns3
// TODO add your handling code here:
    }//GEN-LAST:event_btns3ActionPerformed

    private void btns53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns53ActionPerformed
        posicionCarta(2, 6);   // btns53
// TODO add your handling code here:
    }//GEN-LAST:event_btns53ActionPerformed

    private void btns54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns54ActionPerformed
        posicionCarta(2, 7);   // btns54
// TODO add your handling code here:
    }//GEN-LAST:event_btns54ActionPerformed

    private void btns39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns39ActionPerformed
        posicionCarta(3, 0);   // btns39
// TODO add your handling code here:
    }//GEN-LAST:event_btns39ActionPerformed

    private void btns40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns40ActionPerformed
        posicionCarta(3, 1);   // btns40
// TODO add your handling code here:
    }//GEN-LAST:event_btns40ActionPerformed

    private void btns5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns5ActionPerformed
        posicionCarta(3, 2);   // btns5
// TODO add your handling code here:
    }//GEN-LAST:event_btns5ActionPerformed

    private void btns6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns6ActionPerformed
        posicionCarta(3, 3);   // btns6
// TODO add your handling code here:
    }//GEN-LAST:event_btns6ActionPerformed

    private void btns8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns8ActionPerformed
        posicionCarta(3, 5);   // btns8
// TODO add your handling code here:
    }//GEN-LAST:event_btns8ActionPerformed

    private void btns55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns55ActionPerformed
        posicionCarta(3, 6);   // btns55
// TODO add your handling code here:
    }//GEN-LAST:event_btns55ActionPerformed

    private void btns56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns56ActionPerformed
        posicionCarta(3, 7);   // btns56
// TODO add your handling code here:
    }//GEN-LAST:event_btns56ActionPerformed

    private void btns41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns41ActionPerformed
        posicionCarta(4, 0);   // btns41
// TODO add your handling code here:
    }//GEN-LAST:event_btns41ActionPerformed

    private void btns9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns9ActionPerformed
        posicionCarta(4, 2);   // btns9
// TODO add your handling code here:
    }//GEN-LAST:event_btns9ActionPerformed

    private void btns10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns10ActionPerformed
        posicionCarta(4, 3);   // btns10
// TODO add your handling code here:
    }//GEN-LAST:event_btns10ActionPerformed

    private void btns12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns12ActionPerformed
        posicionCarta(4, 5);   // btns12
// TODO add your handling code here:
    }//GEN-LAST:event_btns12ActionPerformed

    private void btns57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns57ActionPerformed
        posicionCarta(4, 6);   // btns57
// TODO add your handling code here:
    }//GEN-LAST:event_btns57ActionPerformed

    private void btns58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns58ActionPerformed
        posicionCarta(4, 7);   // btns58
// TODO add your handling code here:
    }//GEN-LAST:event_btns58ActionPerformed

    private void btns43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns43ActionPerformed
        posicionCarta(5, 0);   // btns43
// TODO add your handling code here:
    }//GEN-LAST:event_btns43ActionPerformed

    private void btns44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns44ActionPerformed
        posicionCarta(5, 1);   // btns44
// TODO add your handling code here:
    }//GEN-LAST:event_btns44ActionPerformed

    private void btns17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns17ActionPerformed
        posicionCarta(6, 2);   // btns17
// TODO add your handling code here:
    }//GEN-LAST:event_btns17ActionPerformed

    private void btns13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns13ActionPerformed
        posicionCarta(5, 2);   // btns13
// TODO add your handling code here:
    }//GEN-LAST:event_btns13ActionPerformed

    private void btns14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns14ActionPerformed
        posicionCarta(5, 3);   // btns14
// TODO add your handling code here:
    }//GEN-LAST:event_btns14ActionPerformed

    private void btns15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns15ActionPerformed
        posicionCarta(5, 4);   // btns15
// TODO add your handling code here:
    }//GEN-LAST:event_btns15ActionPerformed

    private void btns59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns59ActionPerformed
        posicionCarta(5, 6);   // btns59
// TODO add your handling code here:
    }//GEN-LAST:event_btns59ActionPerformed

    private void btns60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns60ActionPerformed
        posicionCarta(5, 7);   // btns60
// TODO add your handling code here:
    }//GEN-LAST:event_btns60ActionPerformed

    private void btns45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns45ActionPerformed
        posicionCarta(6, 0);   // btns45
// TODO add your handling code here:
    }//GEN-LAST:event_btns45ActionPerformed

    private void btns18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns18ActionPerformed
        posicionCarta(6, 3);   // btns18
// TODO add your handling code here:
    }//GEN-LAST:event_btns18ActionPerformed

    private void btns19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns19ActionPerformed
        posicionCarta(6, 4);   // btns19
// TODO add your handling code here:
    }//GEN-LAST:event_btns19ActionPerformed

    private void btns20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns20ActionPerformed
        posicionCarta(6, 5);   // btns20
// TODO add your handling code here:
    }//GEN-LAST:event_btns20ActionPerformed

    private void btns61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns61ActionPerformed
        posicionCarta(6, 6);   // btns61
// TODO add your handling code here:
    }//GEN-LAST:event_btns61ActionPerformed

    private void btns62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns62ActionPerformed
        posicionCarta(6, 7);   // btns62
// TODO add your handling code here:
    }//GEN-LAST:event_btns62ActionPerformed

    private void btns47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns47ActionPerformed
        posicionCarta(7, 0);   // btns47
// TODO add your handling code here:
    }//GEN-LAST:event_btns47ActionPerformed

    private void btns48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns48ActionPerformed
        posicionCarta(7, 1);   // btns48
// TODO add your handling code here:
    }//GEN-LAST:event_btns48ActionPerformed

    private void btns21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns21ActionPerformed
        posicionCarta(7, 2);   // btns21
// TODO add your handling code here:
    }//GEN-LAST:event_btns21ActionPerformed

    private void btns22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns22ActionPerformed
        posicionCarta(7, 3);   // btns22
// TODO add your handling code here:
    }//GEN-LAST:event_btns22ActionPerformed

    private void btns24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns24ActionPerformed
        posicionCarta(7, 5);   // btns24
// TODO add your handling code here:
    }//GEN-LAST:event_btns24ActionPerformed

    private void btns63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btns63ActionPerformed
        posicionCarta(7, 6);   // btns63// TODO add your handling code here:
    }//GEN-LAST:event_btns63ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmInterfazJuego().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btns1;
    private javax.swing.JButton btns10;
    private javax.swing.JButton btns11;
    private javax.swing.JButton btns12;
    private javax.swing.JButton btns13;
    private javax.swing.JButton btns14;
    private javax.swing.JButton btns15;
    private javax.swing.JButton btns16;
    private javax.swing.JButton btns17;
    private javax.swing.JButton btns18;
    private javax.swing.JButton btns19;
    private javax.swing.JButton btns2;
    private javax.swing.JButton btns20;
    private javax.swing.JButton btns21;
    private javax.swing.JButton btns22;
    private javax.swing.JButton btns23;
    private javax.swing.JButton btns24;
    private javax.swing.JButton btns25;
    private javax.swing.JButton btns26;
    private javax.swing.JButton btns27;
    private javax.swing.JButton btns28;
    private javax.swing.JButton btns29;
    private javax.swing.JButton btns3;
    private javax.swing.JButton btns30;
    private javax.swing.JButton btns31;
    private javax.swing.JButton btns32;
    private javax.swing.JButton btns33;
    private javax.swing.JButton btns34;
    private javax.swing.JButton btns35;
    private javax.swing.JButton btns36;
    private javax.swing.JButton btns37;
    private javax.swing.JButton btns38;
    private javax.swing.JButton btns39;
    private javax.swing.JButton btns4;
    private javax.swing.JButton btns40;
    private javax.swing.JButton btns41;
    private javax.swing.JButton btns42;
    private javax.swing.JButton btns43;
    private javax.swing.JButton btns44;
    private javax.swing.JButton btns45;
    private javax.swing.JButton btns46;
    private javax.swing.JButton btns47;
    private javax.swing.JButton btns48;
    private javax.swing.JButton btns49;
    private javax.swing.JButton btns5;
    private javax.swing.JButton btns50;
    private javax.swing.JButton btns51;
    private javax.swing.JButton btns52;
    private javax.swing.JButton btns53;
    private javax.swing.JButton btns54;
    private javax.swing.JButton btns55;
    private javax.swing.JButton btns56;
    private javax.swing.JButton btns57;
    private javax.swing.JButton btns58;
    private javax.swing.JButton btns59;
    private javax.swing.JButton btns6;
    private javax.swing.JButton btns60;
    private javax.swing.JButton btns61;
    private javax.swing.JButton btns62;
    private javax.swing.JButton btns63;
    private javax.swing.JButton btns64;
    private javax.swing.JButton btns7;
    private javax.swing.JButton btns8;
    private javax.swing.JButton btns9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblParejas;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblValorIntentos;
    private javax.swing.JLabel lblValorParejas;
    private javax.swing.JLabel lblValorPuntaje;
    private javax.swing.JLabel lblValorTiempo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelTablero;
    private javax.swing.JRadioButton rbAvanzado;
    private javax.swing.JRadioButton rbIntermedio;
    private javax.swing.JRadioButton rbPrincipiante;
    // End of variables declaration//GEN-END:variables
}
