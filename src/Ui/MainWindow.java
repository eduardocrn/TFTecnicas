/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Business.Fachada;
import Data.DAOException;
import Domain.Leilao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class MainWindow extends javax.swing.JFrame {

    private Fachada fachada;
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        fachada = new Fachada();
        this.setLocationRelativeTo(null);
        populaCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovoLeilao = new javax.swing.JButton();
        btnNovoLance = new javax.swing.JButton();
        btnNovoUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLeilao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNovaCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLances = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        btnNovoLeilao.setText("Novo Leilão");
        btnNovoLeilao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoLeilaoActionPerformed(evt);
            }
        });

        btnNovoLance.setText("Novo Lance");
        btnNovoLance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoLanceActionPerformed(evt);
            }
        });

        btnNovoUsuario.setText("Novo Usuário");
        btnNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuarioActionPerformed(evt);
            }
        });

        tableLeilao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Leilão", "Data inicio", "Hora inicio", "Data Fim", "Hora Fim", "Natureza", "Forma", "Valor", "Responsável"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLeilao.setMinimumSize(new java.awt.Dimension(150, 0));
        tableLeilao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLeilaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLeilao);

        jLabel1.setText("Leilões");

        btnNovaCategoria.setText("Nova Categoria");
        btnNovaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Lances");

        tableLances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Data", "Hora", "Valor", "Código Leilão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableLances);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovaCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovoUsuario)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoLance)
                            .addComponent(btnNovoLeilao))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovoUsuario)
                        .addComponent(btnNovaCategoria))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoLeilao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovoLance)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    void populaCampos() {
        try {
            List<Leilao> lista = fachada.buscarTodosLeiloes();
            DefaultTableModel model = (DefaultTableModel) tableLeilao.getModel();
            for (Leilao leilao : lista) {
                model.addRow(new Object[]{
                    leilao.getIdLeilao(), 
                    leilao.getDataInicio(),
                    leilao.getHoraInicio(),
                    leilao.getDataFim(),
                    leilao.getHoraFim(),
                    leilao.getNatureza(),
                    leilao.getFormaLance(),
                    leilao.getValorLote(),
                    leilao.getUsuario().getNome()});    
            }
            
        }catch(DAOException ex) {
            
        }
            
    }
    
    private void btnNovoLanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoLanceActionPerformed
        DlgLance dlgLance = new DlgLance(this, true);
        dlgLance.setVisible(true);
    }//GEN-LAST:event_btnNovoLanceActionPerformed

    private void btnNovoLeilaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoLeilaoActionPerformed
        DlgLeilao leilaoFrame = new DlgLeilao(this, true, fachada);
        leilaoFrame.setVisible(true);
    }//GEN-LAST:event_btnNovoLeilaoActionPerformed

    private void btnNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuarioActionPerformed
        DlgUsuario dlgUsuario = new DlgUsuario(this,true,fachada);
        dlgUsuario.setVisible(true);
        
    }//GEN-LAST:event_btnNovoUsuarioActionPerformed

    private void tableLeilaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLeilaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableLeilaoMouseClicked

    private void btnNovaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaCategoriaActionPerformed
        DlgCategoria dl = new DlgCategoria(this, true, fachada);
        dl.setVisible(true);
    }//GEN-LAST:event_btnNovaCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaCategoria;
    private javax.swing.JButton btnNovoLance;
    private javax.swing.JButton btnNovoLeilao;
    private javax.swing.JButton btnNovoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableLances;
    private javax.swing.JTable tableLeilao;
    // End of variables declaration//GEN-END:variables
}
