/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import java.awt.CardLayout;

/**
 *
 * @author JotaWind
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        topo = new javax.swing.JPanel();
        baixo = new javax.swing.JPanel();
        esquerda = new javax.swing.JPanel();
        btnNovoCliente = new javax.swing.JButton();
        centro = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        novoCliente1 = new InterfacesGraficas.NovoCliente();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuNovo = new javax.swing.JMenu();
        MenuNovoCliente = new javax.swing.JMenuItem();
        MenuNovoVeiculo = new javax.swing.JMenuItem();
        MenuNovoLocacao = new javax.swing.JMenuItem();
        MenuLista = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(80, 80, 80));
        jPanel1.setLayout(new java.awt.BorderLayout(3, 3));

        topo.setPreferredSize(new java.awt.Dimension(700, 40));

        javax.swing.GroupLayout topoLayout = new javax.swing.GroupLayout(topo);
        topo.setLayout(topoLayout);
        topoLayout.setHorizontalGroup(
            topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        topoLayout.setVerticalGroup(
            topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(topo, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout baixoLayout = new javax.swing.GroupLayout(baixo);
        baixo.setLayout(baixoLayout);
        baixoLayout.setHorizontalGroup(
            baixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        baixoLayout.setVerticalGroup(
            baixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(baixo, java.awt.BorderLayout.PAGE_END);

        btnNovoCliente.setText("Novo Cliente");
        btnNovoCliente.setToolTipText("");
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout esquerdaLayout = new javax.swing.GroupLayout(esquerda);
        esquerda.setLayout(esquerdaLayout);
        esquerdaLayout.setHorizontalGroup(
            esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(esquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        esquerdaLayout.setVerticalGroup(
            esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(esquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoCliente)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jPanel1.add(esquerda, java.awt.BorderLayout.LINE_START);

        centro.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bem vindo!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        centro.add(jPanel3, "card3");
        centro.add(novoCliente1, "novoCliente");

        jPanel1.add(centro, java.awt.BorderLayout.CENTER);

        MenuNovo.setText("Novo");

        MenuNovoCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.META_MASK));
        MenuNovoCliente.setText("Cliente");
        MenuNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNovoClienteActionPerformed(evt);
            }
        });
        MenuNovo.add(MenuNovoCliente);

        MenuNovoVeiculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.META_MASK));
        MenuNovoVeiculo.setText("Veículo");
        MenuNovo.add(MenuNovoVeiculo);

        MenuNovoLocacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.META_MASK));
        MenuNovoLocacao.setText("Locação");
        MenuNovo.add(MenuNovoLocacao);

        jMenuBar1.add(MenuNovo);

        MenuLista.setText("Listas");
        jMenuBar1.add(MenuLista);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNovoClienteActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) centro.getLayout();
        card.show(centro, "novoCliente");
    }//GEN-LAST:event_MenuNovoClienteActionPerformed

    private void btnNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClienteActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout) centro.getLayout();
        card.show(centro, "novoCliente");
    }//GEN-LAST:event_btnNovoClienteActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuLista;
    private javax.swing.JMenu MenuNovo;
    private javax.swing.JMenuItem MenuNovoCliente;
    private javax.swing.JMenuItem MenuNovoLocacao;
    private javax.swing.JMenuItem MenuNovoVeiculo;
    private javax.swing.JPanel baixo;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JPanel centro;
    private javax.swing.JPanel esquerda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private InterfacesGraficas.NovoCliente novoCliente1;
    private javax.swing.JPanel topo;
    // End of variables declaration//GEN-END:variables
}
