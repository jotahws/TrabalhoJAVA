/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import java.awt.Color;
import javax.swing.JOptionPane;
import trabjava.Automovel;
import DataAccesObject.AutomovelDAO;
import trabjava.Motocicleta;
import DataAccesObject.MotocicletaDAO;
import trabjava.Categoria;
import trabjava.Estado;
import trabjava.Marca;
import trabjava.ModeloAutomovel;
import trabjava.ModeloMotocicleta;
import trabjava.ModeloVan;
import trabjava.Van;
import DataAccesObject.VanDAO;
import trabjava.Veiculo;

/**
 *
 * @author JotaWind
 */
public class NovoVeiculo extends javax.swing.JPanel {

    public NovoVeiculo() {
        initComponents();

        comboMarca.addItem(Marca.CHEVROLET.toString());
        comboMarca.addItem(Marca.FIAT.toString());
        comboMarca.addItem(Marca.HONDA.toString());
        comboMarca.addItem(Marca.HYUNDAI.toString());
        comboMarca.addItem(Marca.RENAULT.toString());
        comboMarca.addItem(Marca.VOLKSWAGEN.toString());

        comboEstado.addItem(Estado.DISPONIVEL.toString());
        comboEstado.addItem(Estado.LOCADO.toString());
        comboEstado.addItem(Estado.NOVO.toString());
        comboEstado.addItem(Estado.VENDIDO.toString());

        comboCategoria.addItem(Categoria.INTERMEDIARIO.toString());
        comboCategoria.addItem(Categoria.LUXO.toString());
        comboCategoria.addItem(Categoria.POPULAR.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panFields = new javax.swing.JPanel();
        comboMarca = new javax.swing.JComboBox<>();
        lblMarca = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        lblModelo = new javax.swing.JLabel();
        comboModelo = new javax.swing.JComboBox<>();
        btnNovoVeiculo = new javax.swing.JButton();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblValorCompra = new javax.swing.JLabel();
        txtValorCompra = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        lblConcuido = new javax.swing.JLabel();

        setBackground(new java.awt.Color(80, 80, 80));
        setLayout(new java.awt.BorderLayout(0, 1));

        panTitulo.setPreferredSize(new java.awt.Dimension(597, 60));

        lblTitulo.setFont(new java.awt.Font("Al Bayan", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Inserir Novo Veículo");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        add(panTitulo, java.awt.BorderLayout.PAGE_START);

        comboMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMarcaActionPerformed(evt);
            }
        });

        lblMarca.setText("Marca:");

        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado:");

        lblCategoria.setText("Categoria:");

        lblModelo.setText("Modelo:");

        comboModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        btnNovoVeiculo.setText("Cadastrar");
        btnNovoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoVeiculoActionPerformed(evt);
            }
        });

        lblPlaca.setText("Placa:");

        lblValorCompra.setText("Valor de Compra:");

        txtValorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorCompraActionPerformed(evt);
            }
        });

        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });

        lblAno.setText("Ano:");

        lblTipo.setText("Tipo:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Automóvel", "Motocicleta", "Van" }));
        comboTipo.setToolTipText("");
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        lblConcuido.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblConcuido.setForeground(new java.awt.Color(0, 102, 51));
        lblConcuido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConcuido.setToolTipText("");

        javax.swing.GroupLayout panFieldsLayout = new javax.swing.GroupLayout(panFields);
        panFields.setLayout(panFieldsLayout);
        panFieldsLayout.setHorizontalGroup(
            panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConcuido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panFieldsLayout.createSequentialGroup()
                        .addGroup(panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panFieldsLayout.createSequentialGroup()
                                    .addComponent(lblTipo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblAno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblMarca)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panFieldsLayout.createSequentialGroup()
                                    .addComponent(lblCategoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblModelo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblEstado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnNovoVeiculo))
                            .addGroup(panFieldsLayout.createSequentialGroup()
                                .addComponent(lblValorCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panFieldsLayout.setVerticalGroup(
            panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo)
                    .addComponent(lblAno)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelo)
                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorCompra)
                    .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(lblConcuido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panFields, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtValorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorCompraActionPerformed

    private void comboMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMarcaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_comboMarcaActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        comboModelo.removeAllItems();
        if (comboTipo.getSelectedItem() == "Automóvel") {
            comboModelo.addItem(ModeloAutomovel.AMGGT.toString());
            comboModelo.addItem(ModeloAutomovel.Celta.toString());
            comboModelo.addItem(ModeloAutomovel.Clio.toString());
            comboModelo.addItem(ModeloAutomovel.Gol.toString());
            comboModelo.addItem(ModeloAutomovel.HB20.toString());
            comboModelo.addItem(ModeloAutomovel.Onix.toString());
            comboModelo.addItem(ModeloAutomovel.Palio.toString());
            comboModelo.addItem(ModeloAutomovel.Sandero.toString());
            comboModelo.addItem(ModeloAutomovel.Uno.toString());
            comboModelo.addItem(ModeloAutomovel.Up.toString());
        } else if (comboTipo.getSelectedItem() == "Motocicleta") {
            comboModelo.addItem(ModeloMotocicleta.Biz.toString());
            comboModelo.addItem(ModeloMotocicleta.CBR500.toString());
            comboModelo.addItem(ModeloMotocicleta.CG150.toString());
            comboModelo.addItem(ModeloMotocicleta.F800.toString());
        } else if (comboTipo.getSelectedItem() == "Van") {
            comboModelo.addItem(ModeloVan.Ducato.toString());
            comboModelo.addItem(ModeloVan.Kombi.toString());
            comboModelo.addItem(ModeloVan.Sprinter.toString());
            comboModelo.addItem(ModeloVan.Transit.toString());
        }
        /*anotação para fazer combobox com enum: comboNomeVariavel.addItem(ModeloAutomovel.amggt.toString());   */
    }//GEN-LAST:event_comboTipoActionPerformed

    private void btnNovoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoVeiculoActionPerformed
        try {
            if (comboTipo.getSelectedItem() == "Automóvel") {
                Veiculo veiculo = new Automovel(ModeloAutomovel.valueOf(comboModelo.getSelectedItem().toString()), Double.parseDouble(txtValorCompra.getText()), txtPlaca.getText(), Integer.parseInt(txtAno.getText()), Marca.valueOf(comboMarca.getSelectedItem().toString()), Estado.valueOf(comboEstado.getSelectedItem().toString()), Categoria.valueOf(comboCategoria.getSelectedItem().toString()));
                AutomovelDAO autoDao = new AutomovelDAO();
                autoDao.inserirAutomovel((Automovel) veiculo);
            } else if (comboTipo.getSelectedItem() == "Van") {
                Veiculo veiculo = new Van(ModeloVan.valueOf(comboModelo.getSelectedItem().toString()), Double.parseDouble(txtValorCompra.getText()), txtPlaca.getText(), Integer.parseInt(txtAno.getText()), Marca.valueOf(comboMarca.getSelectedItem().toString()), Estado.valueOf(comboEstado.getSelectedItem().toString()), Categoria.valueOf(comboCategoria.getSelectedItem().toString()));
                VanDAO vanDao = new VanDAO();
                vanDao.inserirVan((Van) veiculo);
            } else if (comboTipo.getSelectedItem() == "Motocicleta") {
                Veiculo veiculo = new Motocicleta(ModeloMotocicleta.valueOf(comboModelo.getSelectedItem().toString()), Double.parseDouble(txtValorCompra.getText()), txtPlaca.getText(), Integer.parseInt(txtAno.getText()), Marca.valueOf(comboMarca.getSelectedItem().toString()), Estado.valueOf(comboEstado.getSelectedItem().toString()), Categoria.valueOf(comboCategoria.getSelectedItem().toString()));
                MotocicletaDAO motoDao = new MotocicletaDAO();
                motoDao.inserirMotocicleta((Motocicleta) veiculo);
            }
            lblConcuido.setText("Veículo cadastrado com Sucesso.");
        } catch (RuntimeException ex) {
            lblConcuido.setForeground(Color.red);
            lblConcuido.setText("Erro ao Cadastrar Veículo");
        }
    }//GEN-LAST:event_btnNovoVeiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoVeiculo;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboModelo;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblConcuido;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorCompra;
    private javax.swing.JPanel panFields;
    private javax.swing.JPanel panTitulo;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValorCompra;
    // End of variables declaration//GEN-END:variables
}
