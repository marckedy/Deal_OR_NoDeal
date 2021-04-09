/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealOrNoDeal;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class PrincipalDeal extends javax.swing.JFrame {
    
    private ArrayList<Top5>  top;
    private DealOrNoDeal boton;
    private DineroGanado ganar;
    private ArrayList  dinero;
    private ArrayList <Integer> numero;
    private double banco;
    private int primerMaletin = -1;
    private double dineroPrimerMaletin;
    private int rechazos = 0;
    private int numeroDeMaletin = 0;
    
    Jugar jugar = new Jugar();
    
    /**
     * Creates new form PrincipalDeal
     */
    public PrincipalDeal() {
        top = new ArrayList();
        dinero = new ArrayList();
        numero = new ArrayList<Integer>();
        initComponents();
        asignarNumero();
        boton = new DealOrNoDeal(this, true);
        ganar = new DineroGanado(this, true);
        datos();
    }
        
    private void datos(){
        File file = new File("top.dat");
        if(file.exists()){
            try{
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);
                
                top = (ArrayList<Top5>) reader.readObject();
                
                reader.close();
                input.close();
                    
            }catch (IOException e){
                System.out.println("No lo abrio");
            } catch (ClassNotFoundException ex) {
                System.out.println("No lo leyo");
            }
        }else{
            top.add(tops());
            top.add(tops());
            top.add(tops());
            top.add(tops());
            top.add(tops());
        }
    }
    
    private Top5 tops(){
        Top5 t = new Top5("-----", 0.0, "0");
        return t;
    }
    
    private void asignarNumero(){
        dinero.add(edt001.getText());
        dinero.add(edt1.getText());
        dinero.add(edt5.getText());
        dinero.add(edt10.getText());
        dinero.add(edt25.getText());
        dinero.add(edt50.getText());
        dinero.add(edt75.getText());
        dinero.add(edt100.getText());
        dinero.add(edt200.getText());
        dinero.add(edt300.getText());
        dinero.add(edt400.getText());
        dinero.add(edt500.getText());
        dinero.add(edt750.getText());
        dinero.add(edt1000.getText());
        dinero.add(edt5000.getText());
        dinero.add(edt10000.getText());
        dinero.add(edt25000.getText());
        dinero.add(edt50000.getText());
        dinero.add(edt75000.getText());
        dinero.add(edt100000.getText());
        dinero.add(edt200000.getText());
        dinero.add(edt300000.getText());
        dinero.add(edt400000.getText());
        dinero.add(edt500000.getText());
        dinero.add(edt750000.getText());
        dinero.add(edt1000000.getText());
    }
    
    private int aleatorio(){
        Random random = new Random();
        int n=-1;
        
        do{
            n = random.nextInt(26);
            for (int i=0; i<numero.size(); i++) {
                if(numero.get(i) == n){
                    n=-1;
                } 
            }
            if(n != -1){
                numero.add(n);
            }
        }while(n == -1);
        
        return n;
    }
    
    private void taparDinero(int n, int m){
        Color color = new Color(102, 102, 0);
        
        if(m == 1){ 
            color = new Color (255,204,0);
        }
        
        switch (n){
            case 0: pnl0.setBackground(color); break;
            case 1: pnl1.setBackground(color); break;
            case 2: pnl2.setBackground(color); break;
            case 3: pnl3.setBackground(color); break;
            case 4: pnl4.setBackground(color); break;
            case 5: pnl5.setBackground(color); break;
            case 6: pnl6.setBackground(color); break;
            case 7: pnl7.setBackground(color); break;
            case 8: pnl8.setBackground(color); break;
            case 9: pnl9.setBackground(color); break;
            case 10: pnl10.setBackground(color); break;
            case 11: pnl11.setBackground(color); break;
            case 12: pnl12.setBackground(color); break;
            case 13: pnl13.setBackground(color); break;
            case 14: pnl14.setBackground(color); break;
            case 15: pnl15.setBackground(color); break;
            case 16: pnl16.setBackground(color); break;
            case 17: pnl17.setBackground(color); break;
            case 18: pnl18.setBackground(color); break;
            case 19: pnl19.setBackground(color); break;
            case 20: pnl20.setBackground(color); break;
            case 21: pnl21.setBackground(color); break;
            case 22: pnl22.setBackground(color); break;
            case 23: pnl23.setBackground(color); break;
            case 24: pnl24.setBackground(color); break;
            case 25: pnl25.setBackground(color); break;
        }
    }
    
    private double evaluardinero(int n){
        double valor = 0;
        switch (n) {
            case 0: valor = 0.01; break;
            case 1: valor = 1; break;
            case 2: valor = 5; break;
            case 3: valor = 10; break;
            case 4: valor = 25; break;
            case 5: valor = 50; break;
            case 6: valor = 75; break;
            case 7: valor = 100; break;
            case 8: valor = 200; break;
            case 9: valor = 300; break;
            case 10: valor = 400; break;
            case 11: valor = 500; break;
            case 12: valor = 750; break;
            case 13: valor = 1000; break;
            case 14: valor = 5000; break;
            case 15: valor = 10000; break;
            case 16: valor = 25000; break;
            case 17: valor = 50000; break;
            case 18: valor = 75000; break;
            case 19: valor = 100000; break;
            case 20: valor = 200000; break;
            case 21: valor = 300000; break;
            case 22: valor = 400000; break;
            case 23: valor = 500000; break;
            case 24: valor = 750000; break;
            case 25: valor = 1000000; break;
        }
        return valor;
    }
    
    private int ultimoMaletin(){
        int ultimo = 0;
        if (jugar.getJugar1() == 0){
            ultimo = 1;
        }
        
        if (jugar.getJugar2() == 0){
            ultimo = 2;
        }
        
        if (jugar.getJugar3() == 0){
            ultimo = 3;
        }
        
        if (jugar.getJugar4() == 0){
            ultimo = 4;
        }
        
        if (jugar.getJugar5() == 0){
            ultimo = 5;
        }
        
        if (jugar.getJugar6() == 0){
            ultimo = 6;
        }
        
        if (jugar.getJugar7() == 0){
            ultimo = 7;
        }
        
        if (jugar.getJugar8() == 0){
            ultimo = 8;
        }
        
        if (jugar.getJugar9() == 0){
            ultimo = 9;
        }
        
        if (jugar.getJugar10() == 0){
            ultimo = 10;
        }
        
        if (jugar.getJugar11() == 0){
            ultimo = 11;
        }
        
        if (jugar.getJugar12() == 0){
            ultimo = 12;
        }
        
        if (jugar.getJugar13() == 0){
            ultimo = 13;
        }
        
        if (jugar.getJugar14() == 0){
            ultimo = 14;
        }
        
        if (jugar.getJugar15() == 0){
            ultimo = 15;
        }
        
        if (jugar.getJugar16() == 0){
            ultimo = 16;
        }
        
        if (jugar.getJugar17() == 0){
            ultimo = 17;
        }
        
        if (jugar.getJugar18() == 0){
            ultimo = 18;
        }
        
        if (jugar.getJugar19() == 0){
            ultimo = 19;
        }
        
        if (jugar.getJugar20() == 0){
            ultimo = 20;
        }
        
        if (jugar.getJugar21() == 0){
            ultimo = 21;
        }
        
        if (jugar.getJugar22() == 0){
            ultimo = 22;
        }
        
        if (jugar.getJugar23() == 0){
            ultimo = 23;
        }
        
        if (jugar.getJugar24() == 0){
            ultimo = 24;
        }
        
        if (jugar.getJugar25() == 0){
            ultimo = 25;
        }
        
        if (jugar.getJugar26() == 0){
            ultimo = 26;
        }
        
        return ultimo;
    }
    
    private void deal(int num){
        int maletas = jugar.getMaletas();
        int n = jugar.getDeal();
        banco = 0;
        
        
        if (primerMaletin != -1){
            taparDinero(num, 0);
            
            if (n < maletas) {
                n = n+1;
            
                if (n == maletas) {
                    rechazos++;
                    for (int i=1; i<numero.size(); i++){
                        banco = banco + evaluardinero(numero.get(i));
                    }
                
                    int dividir = 27 - numero.size();
                    banco = (3418416.01-banco)/dividir;
                    boton.mostrar(banco);
                    boton.setVisible(true);
                    
                    Model m = boton.modal();
                    
                    if(m == Model.DEAL){
                        JOptionPane.showMessageDialog(this, "Vamos a ver cuanto dinero tenía tu maletín", "Información", JOptionPane.INFORMATION_MESSAGE);
                        dineroPrimerMaletin = evaluardinero(primerMaletin);
                        String imagen = String.format("%d.png", numeroDeMaletin);
                        ganar.maletin(imagen);
                        ganar.dinero(dineroPrimerMaletin, 0);
                        
                        ganar.setVisible(true);
                        compararTop(banco);
                        this.setVisible(false);
                    }
                
                    if(maletas == 1){
                        maletas = 1;
                    }else{
                        maletas = maletas-1;
                    }
                
                    jugar.setMaletas(maletas);
                    n=0;
                }
                jugar.setDeal(n);
            }
        }else{
            taparDinero(num, 1);
            primerMaletin = num;
        }
        
        if(rechazos == 9){
            JOptionPane.showMessageDialog(this, "Has rechazado todas la ofertas, "
                    + "ya solo queda un maletín\nPuedes quedarte con el maletín que escogiste al principio,"
                    + "\no lo puedes cambiar por el maletín que quedó.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres cambiar el maletín?", "Cambiar maletín", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION){
                banco = 0;
                for (int i=0; i<numero.size(); i++){
                        banco = banco + evaluardinero(numero.get(i));
                    }
                banco = (3418416.01-banco);
                dineroPrimerMaletin = banco;
                
                String imagen = String.format("%d.png", ultimoMaletin());
                ganar.maletin(imagen);
                ganar.dinero(dineroPrimerMaletin, 1);
                
                ganar.setVisible(true);
                
            }else{
                dineroPrimerMaletin = evaluardinero(primerMaletin);
                String imagen = String.format("%d.png", numeroDeMaletin);
                ganar.maletin(imagen);
                ganar.dinero(dineroPrimerMaletin, 1);
                
                ganar.setVisible(true);
            }
            compararTop(dineroPrimerMaletin);
            this.setVisible(false);
        }        
    }
    
    private void compararTop(double ganado) {
        int ver = 0;
        String nombre;
        
        for (int i = 0; i < top.size(); i++){
            if(top.get(i).getDinero() < ganado) {
                Top5 otro = new Top5(top.get(i).getNombre(), top.get(i).getDinero(), top.get(i).getDineroRedondeado());
                top.get(i).setDinero(ganado);
                ganado = otro.getDinero();
                
                ver++;
                
                if (ver == 1){
                    JOptionPane.showMessageDialog(this, "Felicidades, ha entrado en los Top 5 de quienes han ganado más dinero", "Información", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(this, "Escriba su nombre para que se guarde y sea reconocido en el Top 5\n"
                        + "Si no quiere escribir su nombre, solo ponga cancelar"
                        + " y aparecerá\nsin nombre", "Información", JOptionPane.INFORMATION_MESSAGE);
                    nombre = JOptionPane.showInputDialog(null, "Escriba su nombre");
                    
                    
                    top.get(i).setNombre(nombre);
                    Top5 t = new Top5(top.get(i).getNombre(), top.get(i).getDinero(), top.get(i).getDineroRedondeado());
                    
                    if(i < 4){
                        if (top.get(i + 1).getDinero() == 0) {
                            top.set(i + 1, otro);
                        } 
                    }
                    
                    top.set(i, t);
                    guardarTop();
                }
        }
            }
    }
    
    private void guardarTop(){
        try{
            File file = new File("top.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);
            

            writer.writeObject(top);

            writer.close();
            output.close();
        
        }catch (IOException e){
            System.out.println("No se pudo");
        }
    }
    
    private String taparMaletin(int num){
        String maleta = "/imagenes/negro.png";
        JOptionPane.showMessageDialog(this, evaluardinero(num), "Maletín", JOptionPane.PLAIN_MESSAGE);
        return maleta;
    }
    
    public double getBanco(){
        return banco;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn21 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        pnl0 = new javax.swing.JPanel();
        edt001 = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        edt1 = new javax.swing.JLabel();
        pnl2 = new javax.swing.JPanel();
        edt5 = new javax.swing.JLabel();
        pnl3 = new javax.swing.JPanel();
        edt10 = new javax.swing.JLabel();
        pnl4 = new javax.swing.JPanel();
        edt25 = new javax.swing.JLabel();
        pnl5 = new javax.swing.JPanel();
        edt50 = new javax.swing.JLabel();
        pnl6 = new javax.swing.JPanel();
        edt75 = new javax.swing.JLabel();
        pnl7 = new javax.swing.JPanel();
        edt100 = new javax.swing.JLabel();
        pnl8 = new javax.swing.JPanel();
        edt200 = new javax.swing.JLabel();
        pnl9 = new javax.swing.JPanel();
        edt300 = new javax.swing.JLabel();
        pnl10 = new javax.swing.JPanel();
        edt400 = new javax.swing.JLabel();
        pnl11 = new javax.swing.JPanel();
        edt500 = new javax.swing.JLabel();
        pnl17 = new javax.swing.JPanel();
        edt50000 = new javax.swing.JLabel();
        pnl14 = new javax.swing.JPanel();
        edt5000 = new javax.swing.JLabel();
        pnl20 = new javax.swing.JPanel();
        edt200000 = new javax.swing.JLabel();
        pnl16 = new javax.swing.JPanel();
        edt25000 = new javax.swing.JLabel();
        pnl15 = new javax.swing.JPanel();
        edt10000 = new javax.swing.JLabel();
        pnl13 = new javax.swing.JPanel();
        edt1000 = new javax.swing.JLabel();
        pnl23 = new javax.swing.JPanel();
        edt500000 = new javax.swing.JLabel();
        pnl19 = new javax.swing.JPanel();
        edt100000 = new javax.swing.JLabel();
        pnl22 = new javax.swing.JPanel();
        edt400000 = new javax.swing.JLabel();
        pnl25 = new javax.swing.JPanel();
        edt1000000 = new javax.swing.JLabel();
        pnl18 = new javax.swing.JPanel();
        edt75000 = new javax.swing.JLabel();
        pnl21 = new javax.swing.JPanel();
        edt300000 = new javax.swing.JLabel();
        pnl24 = new javax.swing.JPanel();
        edt750000 = new javax.swing.JLabel();
        pnl12 = new javax.swing.JPanel();
        edt750 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        menuTop5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/21.png"))); // NOI18N
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        btn24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/24.png"))); // NOI18N
        btn24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24ActionPerformed(evt);
            }
        });

        btn25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/25.png"))); // NOI18N
        btn25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn25ActionPerformed(evt);
            }
        });

        btn23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/23.png"))); // NOI18N
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });

        btn22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/22.png"))); // NOI18N
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        btn26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/26.png"))); // NOI18N
        btn26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn26ActionPerformed(evt);
            }
        });

        btn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/14.png"))); // NOI18N
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/7.png"))); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/20.png"))); // NOI18N
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        btn19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/19.png"))); // NOI18N
        btn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn19ActionPerformed(evt);
            }
        });

        btn18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/18.png"))); // NOI18N
        btn18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn18ActionPerformed(evt);
            }
        });

        btn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/17.png"))); // NOI18N
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });

        btn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/16.png"))); // NOI18N
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });

        btn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/15.png"))); // NOI18N
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });

        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/9.png"))); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/8.png"))); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/12.png"))); // NOI18N
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/11.png"))); // NOI18N
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/10.png"))); // NOI18N
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/13.png"))); // NOI18N
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6.png"))); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/5.png"))); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3.png"))); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        pnl0.setBackground(new java.awt.Color(255, 204, 0));
        pnl0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt001.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt001.setText("$ 0.01");

        javax.swing.GroupLayout pnl0Layout = new javax.swing.GroupLayout(pnl0);
        pnl0.setLayout(pnl0Layout);
        pnl0Layout.setHorizontalGroup(
            pnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl0Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(edt001)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        pnl0Layout.setVerticalGroup(
            pnl0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl0Layout.createSequentialGroup()
                .addComponent(edt001)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl1.setBackground(new java.awt.Color(255, 204, 0));
        pnl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt1.setText("$ 1");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(edt1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addComponent(edt1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl2.setBackground(new java.awt.Color(255, 204, 0));
        pnl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt5.setText("$ 5");

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(edt5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addComponent(edt5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl3.setBackground(new java.awt.Color(255, 204, 0));
        pnl3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt10.setText("$ 10");

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(edt10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addComponent(edt10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl4.setBackground(new java.awt.Color(255, 204, 0));
        pnl4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt25.setText("$ 25");

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(edt25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addComponent(edt25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl5.setBackground(new java.awt.Color(255, 204, 0));
        pnl5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt50.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt50.setText("$ 50");

        javax.swing.GroupLayout pnl5Layout = new javax.swing.GroupLayout(pnl5);
        pnl5.setLayout(pnl5Layout);
        pnl5Layout.setHorizontalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(edt50)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl5Layout.setVerticalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5Layout.createSequentialGroup()
                .addComponent(edt50)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl6.setBackground(new java.awt.Color(255, 204, 0));
        pnl6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt75.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt75.setText("$ 75");

        javax.swing.GroupLayout pnl6Layout = new javax.swing.GroupLayout(pnl6);
        pnl6.setLayout(pnl6Layout);
        pnl6Layout.setHorizontalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(edt75)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl6Layout.setVerticalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addComponent(edt75)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl7.setBackground(new java.awt.Color(255, 204, 0));
        pnl7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt100.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt100.setText("$ 100");

        javax.swing.GroupLayout pnl7Layout = new javax.swing.GroupLayout(pnl7);
        pnl7.setLayout(pnl7Layout);
        pnl7Layout.setHorizontalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl7Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(edt100)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl7Layout.setVerticalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl7Layout.createSequentialGroup()
                .addComponent(edt100)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl8.setBackground(new java.awt.Color(255, 204, 0));
        pnl8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt200.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt200.setText("$ 200");

        javax.swing.GroupLayout pnl8Layout = new javax.swing.GroupLayout(pnl8);
        pnl8.setLayout(pnl8Layout);
        pnl8Layout.setHorizontalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl8Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(edt200)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl8Layout.setVerticalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl8Layout.createSequentialGroup()
                .addComponent(edt200)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl9.setBackground(new java.awt.Color(255, 204, 0));
        pnl9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt300.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt300.setText("$ 300");

        javax.swing.GroupLayout pnl9Layout = new javax.swing.GroupLayout(pnl9);
        pnl9.setLayout(pnl9Layout);
        pnl9Layout.setHorizontalGroup(
            pnl9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl9Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(edt300)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl9Layout.setVerticalGroup(
            pnl9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl9Layout.createSequentialGroup()
                .addComponent(edt300)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl10.setBackground(new java.awt.Color(255, 204, 0));
        pnl10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt400.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt400.setText("$ 400");

        javax.swing.GroupLayout pnl10Layout = new javax.swing.GroupLayout(pnl10);
        pnl10.setLayout(pnl10Layout);
        pnl10Layout.setHorizontalGroup(
            pnl10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl10Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(edt400)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl10Layout.setVerticalGroup(
            pnl10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl10Layout.createSequentialGroup()
                .addComponent(edt400)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl11.setBackground(new java.awt.Color(255, 204, 0));
        pnl11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt500.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt500.setText("$ 500");

        javax.swing.GroupLayout pnl11Layout = new javax.swing.GroupLayout(pnl11);
        pnl11.setLayout(pnl11Layout);
        pnl11Layout.setHorizontalGroup(
            pnl11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl11Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(edt500)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl11Layout.setVerticalGroup(
            pnl11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl11Layout.createSequentialGroup()
                .addComponent(edt500)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl17.setBackground(new java.awt.Color(255, 204, 0));
        pnl17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt50000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt50000.setText("$ 50,000");

        javax.swing.GroupLayout pnl17Layout = new javax.swing.GroupLayout(pnl17);
        pnl17.setLayout(pnl17Layout);
        pnl17Layout.setHorizontalGroup(
            pnl17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt50000)
                .addGap(99, 99, 99))
        );
        pnl17Layout.setVerticalGroup(
            pnl17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl17Layout.createSequentialGroup()
                .addComponent(edt50000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl14.setBackground(new java.awt.Color(255, 204, 0));
        pnl14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt5000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt5000.setText("$ 5,000");

        javax.swing.GroupLayout pnl14Layout = new javax.swing.GroupLayout(pnl14);
        pnl14.setLayout(pnl14Layout);
        pnl14Layout.setHorizontalGroup(
            pnl14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl14Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(edt5000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl14Layout.setVerticalGroup(
            pnl14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl14Layout.createSequentialGroup()
                .addComponent(edt5000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl20.setBackground(new java.awt.Color(255, 204, 0));
        pnl20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt200000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt200000.setText("$ 200,000");

        javax.swing.GroupLayout pnl20Layout = new javax.swing.GroupLayout(pnl20);
        pnl20.setLayout(pnl20Layout);
        pnl20Layout.setHorizontalGroup(
            pnl20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt200000)
                .addGap(90, 90, 90))
        );
        pnl20Layout.setVerticalGroup(
            pnl20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl20Layout.createSequentialGroup()
                .addComponent(edt200000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl16.setBackground(new java.awt.Color(255, 204, 0));
        pnl16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt25000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt25000.setText("$ 25,000");

        javax.swing.GroupLayout pnl16Layout = new javax.swing.GroupLayout(pnl16);
        pnl16.setLayout(pnl16Layout);
        pnl16Layout.setHorizontalGroup(
            pnl16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt25000)
                .addGap(102, 102, 102))
        );
        pnl16Layout.setVerticalGroup(
            pnl16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl16Layout.createSequentialGroup()
                .addComponent(edt25000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl15.setBackground(new java.awt.Color(255, 204, 0));
        pnl15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt10000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt10000.setText("$ 10,000");

        javax.swing.GroupLayout pnl15Layout = new javax.swing.GroupLayout(pnl15);
        pnl15.setLayout(pnl15Layout);
        pnl15Layout.setHorizontalGroup(
            pnl15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl15Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(edt10000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl15Layout.setVerticalGroup(
            pnl15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl15Layout.createSequentialGroup()
                .addComponent(edt10000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl13.setBackground(new java.awt.Color(255, 204, 0));
        pnl13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt1000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt1000.setText("$ 1,000");

        javax.swing.GroupLayout pnl13Layout = new javax.swing.GroupLayout(pnl13);
        pnl13.setLayout(pnl13Layout);
        pnl13Layout.setHorizontalGroup(
            pnl13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt1000)
                .addGap(109, 109, 109))
        );
        pnl13Layout.setVerticalGroup(
            pnl13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl13Layout.createSequentialGroup()
                .addComponent(edt1000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl23.setBackground(new java.awt.Color(255, 204, 0));
        pnl23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt500000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt500000.setText("$ 500,000");

        javax.swing.GroupLayout pnl23Layout = new javax.swing.GroupLayout(pnl23);
        pnl23.setLayout(pnl23Layout);
        pnl23Layout.setHorizontalGroup(
            pnl23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt500000)
                .addGap(88, 88, 88))
        );
        pnl23Layout.setVerticalGroup(
            pnl23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl23Layout.createSequentialGroup()
                .addComponent(edt500000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl19.setBackground(new java.awt.Color(255, 204, 0));
        pnl19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt100000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt100000.setText("$ 100,000");

        javax.swing.GroupLayout pnl19Layout = new javax.swing.GroupLayout(pnl19);
        pnl19.setLayout(pnl19Layout);
        pnl19Layout.setHorizontalGroup(
            pnl19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt100000)
                .addGap(90, 90, 90))
        );
        pnl19Layout.setVerticalGroup(
            pnl19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl19Layout.createSequentialGroup()
                .addComponent(edt100000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl22.setBackground(new java.awt.Color(255, 204, 0));
        pnl22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt400000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt400000.setText("$ 400,000");

        javax.swing.GroupLayout pnl22Layout = new javax.swing.GroupLayout(pnl22);
        pnl22.setLayout(pnl22Layout);
        pnl22Layout.setHorizontalGroup(
            pnl22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt400000)
                .addGap(89, 89, 89))
        );
        pnl22Layout.setVerticalGroup(
            pnl22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl22Layout.createSequentialGroup()
                .addComponent(edt400000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl25.setBackground(new java.awt.Color(255, 204, 0));
        pnl25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt1000000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt1000000.setText("$ 1,000,000");

        javax.swing.GroupLayout pnl25Layout = new javax.swing.GroupLayout(pnl25);
        pnl25.setLayout(pnl25Layout);
        pnl25Layout.setHorizontalGroup(
            pnl25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl25Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(edt1000000)
                .addGap(78, 78, 78))
        );
        pnl25Layout.setVerticalGroup(
            pnl25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl25Layout.createSequentialGroup()
                .addComponent(edt1000000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl18.setBackground(new java.awt.Color(255, 204, 0));
        pnl18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt75000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt75000.setText("$ 75,000");

        javax.swing.GroupLayout pnl18Layout = new javax.swing.GroupLayout(pnl18);
        pnl18.setLayout(pnl18Layout);
        pnl18Layout.setHorizontalGroup(
            pnl18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt75000)
                .addGap(101, 101, 101))
        );
        pnl18Layout.setVerticalGroup(
            pnl18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl18Layout.createSequentialGroup()
                .addComponent(edt75000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl21.setBackground(new java.awt.Color(255, 204, 0));
        pnl21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt300000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt300000.setText("$ 300,000");

        javax.swing.GroupLayout pnl21Layout = new javax.swing.GroupLayout(pnl21);
        pnl21.setLayout(pnl21Layout);
        pnl21Layout.setHorizontalGroup(
            pnl21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt300000)
                .addGap(89, 89, 89))
        );
        pnl21Layout.setVerticalGroup(
            pnl21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl21Layout.createSequentialGroup()
                .addComponent(edt300000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl24.setBackground(new java.awt.Color(255, 204, 0));
        pnl24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt750000.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt750000.setText("$ 750,000");

        javax.swing.GroupLayout pnl24Layout = new javax.swing.GroupLayout(pnl24);
        pnl24.setLayout(pnl24Layout);
        pnl24Layout.setHorizontalGroup(
            pnl24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edt750000)
                .addGap(86, 86, 86))
        );
        pnl24Layout.setVerticalGroup(
            pnl24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl24Layout.createSequentialGroup()
                .addComponent(edt750000)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl12.setBackground(new java.awt.Color(255, 204, 0));
        pnl12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        edt750.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        edt750.setText("$ 750");

        javax.swing.GroupLayout pnl12Layout = new javax.swing.GroupLayout(pnl12);
        pnl12.setLayout(pnl12Layout);
        pnl12Layout.setHorizontalGroup(
            pnl12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl12Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(edt750)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl12Layout.setVerticalGroup(
            pnl12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl12Layout.createSequentialGroup()
                .addComponent(edt750)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Opciones");

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        menuTop5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuTop5.setText("Top 5");
        menuTop5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTop5ActionPerformed(evt);
            }
        });
        jMenu1.add(menuTop5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn16, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn19, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btn24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn25, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl0, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn26)
                            .addComponent(btn22)
                            .addComponent(btn23)
                            .addComponent(btn24)
                            .addComponent(btn25)
                            .addComponent(btn21))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn14)
                            .addComponent(btn15)
                            .addComponent(btn16)
                            .addComponent(btn17)
                            .addComponent(btn18)
                            .addComponent(btn19)
                            .addComponent(btn20))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn13)
                            .addComponent(btn12)
                            .addComponent(btn11)
                            .addComponent(btn7)
                            .addComponent(btn8)
                            .addComponent(btn9)
                            .addComponent(btn10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn2)
                            .addComponent(btn1)
                            .addComponent(btn3)
                            .addComponent(btn4)
                            .addComponent(btn5)
                            .addComponent(btn6))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (jugar.getJugar1()==0){
            int num = aleatorio();
            jugar.setJugar1(1);
            
            if( primerMaletin == -1){
                btn1.setBackground(Color.YELLOW);
                numeroDeMaletin = 1;
            }else{
                btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            
            deal(num);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (jugar.getJugar2()==0){
            int num = aleatorio();
            jugar.setJugar2(1);
            
            if( primerMaletin == -1){
                btn2.setBackground(Color.YELLOW);
                numeroDeMaletin = 2;
            }else{
                btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (jugar.getJugar3()==0){
            int num = aleatorio();
            jugar.setJugar3(1);
                        
            if( primerMaletin == -1){
                btn3.setBackground(Color.YELLOW);
                numeroDeMaletin = 3;
            }else{
                btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (jugar.getJugar4()==0){
            int num = aleatorio();
            jugar.setJugar4(1);

            if( primerMaletin == -1){
                btn4.setBackground(Color.YELLOW);
                numeroDeMaletin = 4;
            }else{
                btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (jugar.getJugar5()==0){
            int num = aleatorio();
            jugar.setJugar5(1);
            
            if( primerMaletin == -1){
                btn5.setBackground(Color.YELLOW);
                numeroDeMaletin = 5;
            }else{
                btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (jugar.getJugar6()==0){
            int num = aleatorio();
            jugar.setJugar6(1);
            
            if( primerMaletin == -1){
                btn6.setBackground(Color.YELLOW);
                numeroDeMaletin = 6;
            }else{
                btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (jugar.getJugar7()==0){
            int num = aleatorio();
            jugar.setJugar7(1);
            
            if( primerMaletin == -1){
                btn7.setBackground(Color.YELLOW);
                numeroDeMaletin = 7;
            }else{
                btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (jugar.getJugar8()==0){
            int num = aleatorio();
            jugar.setJugar8(1);
            
            if( primerMaletin == -1){
                btn8.setBackground(Color.YELLOW);
                numeroDeMaletin = 8;
            }else{
                btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (jugar.getJugar9()==0){
            int num = aleatorio();
            jugar.setJugar9(1);
            
            if( primerMaletin == -1){
                btn9.setBackground(Color.YELLOW);
                numeroDeMaletin = 9;
            }else{
                btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        if (jugar.getJugar10()==0){
            int num = aleatorio();
            jugar.setJugar10(1);
            
            if( primerMaletin == -1){
                btn10.setBackground(Color.YELLOW);
                numeroDeMaletin = 10;
            }else{
                btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        if (jugar.getJugar11()==0){
            int num = aleatorio();
            jugar.setJugar11(1);
            
            if( primerMaletin == -1){
                btn11.setBackground(Color.YELLOW);
                numeroDeMaletin = 11;
            }else{
                btn11.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        if (jugar.getJugar12()==0){
            int num = aleatorio();
            jugar.setJugar12(1);

            if( primerMaletin == -1){
                btn12.setBackground(Color.YELLOW);
                numeroDeMaletin = 12;
            }else{
                btn12.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        if (jugar.getJugar13()==0){
            int num = aleatorio();
            jugar.setJugar13(1);

            if( primerMaletin == -1){
                btn13.setBackground(Color.YELLOW);
                numeroDeMaletin = 13;
            }else{
                btn13.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        if (jugar.getJugar14()==0){
            int num = aleatorio();
            jugar.setJugar14(1);

            if( primerMaletin == -1){
                btn14.setBackground(Color.YELLOW);
                numeroDeMaletin = 14;
            }else{
                btn14.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        if (jugar.getJugar15()==0){
            int num = aleatorio();
            jugar.setJugar15(1);

            if( primerMaletin == -1){
                btn15.setBackground(Color.YELLOW);
                numeroDeMaletin = 15;
            }else{
                btn15.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        if (jugar.getJugar16()==0){
            int num = aleatorio();
            jugar.setJugar16(1);
            
            if( primerMaletin == -1){
                btn16.setBackground(Color.YELLOW);
                numeroDeMaletin = 16;
            }else{
                btn16.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn16ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        if (jugar.getJugar17()==0){
            int num = aleatorio();
            jugar.setJugar17(1);
            
            if( primerMaletin == -1){
                btn17.setBackground(Color.YELLOW);
                numeroDeMaletin = 17;
            }else{
                btn17.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn17ActionPerformed

    private void btn18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn18ActionPerformed
        if (jugar.getJugar18()==0){
            int num = aleatorio();
            jugar.setJugar18(1);
            
            if( primerMaletin == -1){
                btn18.setBackground(Color.YELLOW);
                numeroDeMaletin = 18;
            }else{
                btn18.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn18ActionPerformed

    private void btn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn19ActionPerformed
        if (jugar.getJugar19()==0){
            int num = aleatorio();
            jugar.setJugar19(1);
            
            if( primerMaletin == -1){
                btn19.setBackground(Color.YELLOW);
                numeroDeMaletin = 19;
            }else{
                btn19.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn19ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        if (jugar.getJugar20()==0){
            int num = aleatorio();
            jugar.setJugar20(1);
                        
            if( primerMaletin == -1){
                btn20.setBackground(Color.YELLOW);
                numeroDeMaletin = 20;
            }else{
                btn20.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        if (jugar.getJugar21()==0){
            int num = aleatorio();
            jugar.setJugar21(1);
            
            if( primerMaletin == -1){
                btn21.setBackground(Color.YELLOW);
                numeroDeMaletin = 21;
            }else{
                btn21.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        if (jugar.getJugar22()==0){
            int num = aleatorio();
            jugar.setJugar22(1);
            
            if( primerMaletin == -1){
                btn22.setBackground(Color.YELLOW);
                numeroDeMaletin = 22;
            }else{
                btn22.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        if (jugar.getJugar23()==0){
            int num = aleatorio();
            jugar.setJugar23(1);
            
            if( primerMaletin == -1){
                btn23.setBackground(Color.YELLOW);
                numeroDeMaletin = 23;
            }else{
                btn23.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn23ActionPerformed

    private void btn24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24ActionPerformed
        if (jugar.getJugar24()==0){
            int num = aleatorio();
            jugar.setJugar24(1);
            
            if( primerMaletin == -1){
                btn24.setBackground(Color.YELLOW);
                numeroDeMaletin = 24;
            }else{
                btn24.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn24ActionPerformed

    private void btn25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn25ActionPerformed
        if (jugar.getJugar25()==0){
            int num = aleatorio();
            jugar.setJugar25(1);
            
            if( primerMaletin == -1){
                btn25.setBackground(Color.YELLOW);
                numeroDeMaletin = 25;
            }else{
                btn25.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn25ActionPerformed

    private void btn26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn26ActionPerformed
        if (jugar.getJugar26()==0){
            int num = aleatorio();
            jugar.setJugar26(1);
            
            if( primerMaletin == -1){
                btn26.setBackground(Color.YELLOW);
                numeroDeMaletin = 26;
            }else{
                btn26.setIcon(new javax.swing.ImageIcon(getClass().getResource(taparMaletin(num))));
            }
            
            deal(num);
        }
    }//GEN-LAST:event_btn26ActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        int r = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere salir del juego? ", "Salir", JOptionPane.YES_NO_OPTION);
        if(r == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuTop5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTop5ActionPerformed
        Top5Dialogo top = new Top5Dialogo();
        top.setVisible(true);
    }//GEN-LAST:event_menuTop5ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalDeal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalDeal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JLabel edt001;
    private javax.swing.JLabel edt1;
    private javax.swing.JLabel edt10;
    private javax.swing.JLabel edt100;
    private javax.swing.JLabel edt1000;
    private javax.swing.JLabel edt10000;
    private javax.swing.JLabel edt100000;
    private javax.swing.JLabel edt1000000;
    private javax.swing.JLabel edt200;
    private javax.swing.JLabel edt200000;
    private javax.swing.JLabel edt25;
    private javax.swing.JLabel edt25000;
    private javax.swing.JLabel edt300;
    private javax.swing.JLabel edt300000;
    private javax.swing.JLabel edt400;
    private javax.swing.JLabel edt400000;
    private javax.swing.JLabel edt5;
    private javax.swing.JLabel edt50;
    private javax.swing.JLabel edt500;
    private javax.swing.JLabel edt5000;
    private javax.swing.JLabel edt50000;
    private javax.swing.JLabel edt500000;
    private javax.swing.JLabel edt75;
    private javax.swing.JLabel edt750;
    private javax.swing.JLabel edt75000;
    private javax.swing.JLabel edt750000;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuTop5;
    private javax.swing.JPanel pnl0;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl10;
    private javax.swing.JPanel pnl11;
    private javax.swing.JPanel pnl12;
    private javax.swing.JPanel pnl13;
    private javax.swing.JPanel pnl14;
    private javax.swing.JPanel pnl15;
    private javax.swing.JPanel pnl16;
    private javax.swing.JPanel pnl17;
    private javax.swing.JPanel pnl18;
    private javax.swing.JPanel pnl19;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl20;
    private javax.swing.JPanel pnl21;
    private javax.swing.JPanel pnl22;
    private javax.swing.JPanel pnl23;
    private javax.swing.JPanel pnl24;
    private javax.swing.JPanel pnl25;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnl6;
    private javax.swing.JPanel pnl7;
    private javax.swing.JPanel pnl8;
    private javax.swing.JPanel pnl9;
    // End of variables declaration//GEN-END:variables
}
