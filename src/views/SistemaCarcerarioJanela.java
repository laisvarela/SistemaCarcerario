package views;

import classes.AtualizavelListener;
import classes.Entidade;
import java.util.ArrayList;
import java.util.Iterator;

public class SistemaCarcerarioJanela extends javax.swing.JFrame {

    private CadastrarGuardaInternalFrame telaCadastroGuarda;
    private CadastrarCelaInternalFrame telaCadastroCela;
    private CadastrarPrisioneiroInternalFrame telaCadastroPrisioneiro;
    private ArrayList<Object> listaGeral = new ArrayList<>();
    private ArrayList<AtualizavelListener> listeners = new ArrayList<>();

    public SistemaCarcerarioJanela() {
        initComponents();
        this.pack();
        telaCadastroGuarda = new CadastrarGuardaInternalFrame(this);
        telaCadastroCela = new CadastrarCelaInternalFrame(this);
        telaCadastroPrisioneiro = new CadastrarPrisioneiroInternalFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        cadastrar_Menu = new javax.swing.JMenu();
        guarda_MenuItem = new javax.swing.JMenuItem();
        prisioneiro_MenuItem = new javax.swing.JMenuItem();
        cela_MenuItem = new javax.swing.JMenuItem();
        opcoes_Menu = new javax.swing.JMenu();
        gerarRelatorio_MenuItem = new javax.swing.JMenuItem();
        sobre_Menu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Carcerário");

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1045, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        cadastrar_Menu.setText("Cadastrar");

        guarda_MenuItem.setText("Guarda");
        guarda_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guarda_MenuItemActionPerformed(evt);
            }
        });
        cadastrar_Menu.add(guarda_MenuItem);

        prisioneiro_MenuItem.setText("Prisioneiro");
        prisioneiro_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiro_MenuItemActionPerformed(evt);
            }
        });
        cadastrar_Menu.add(prisioneiro_MenuItem);

        cela_MenuItem.setText("Cela");
        cela_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cela_MenuItemActionPerformed(evt);
            }
        });
        cadastrar_Menu.add(cela_MenuItem);

        jMenuBar1.add(cadastrar_Menu);

        opcoes_Menu.setText("Opções");

        gerarRelatorio_MenuItem.setText("Gerar Relatório");
        gerarRelatorio_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarRelatorio_MenuItemActionPerformed(evt);
            }
        });
        opcoes_Menu.add(gerarRelatorio_MenuItem);

        jMenuBar1.add(opcoes_Menu);

        sobre_Menu.setText("Sobre");

        jMenuItem6.setText("Documentação");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        sobre_Menu.add(jMenuItem6);

        jMenuBar1.add(sobre_Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Registar listeners (telas que querem ser notificadas)

    public void addListener(AtualizavelListener listener) {
        listeners.add(listener);
    }

    // notificar todas as telas adicionadas
    private void notificarAtualizacao(String tipo) {
        for (AtualizavelListener listener : listeners) {
            listener.dadosAtualizados(tipo);
        }
    }

    public ArrayList<Object> getListaGeral() {
        return listaGeral;
    }

    //passa o objeto e função desejada. 0 - adicionar; 1 - editar; 2 - remover.
    public void atualizarListaGeral(Object item, int funcao, String valor) {
        switch (funcao) {
            case 0 ->
                listaGeral.add(item);
            case 1 ->
                editar(item, valor);
            case 2 ->
                remover(item);
            default ->
                throw new AssertionError();
        }
    }

    public void remover(Object item) {
        if (listaGeral != null && !listaGeral.isEmpty()) {
            // Usando Iterator para remoção segura
            Iterator<Object> iterator = listaGeral.iterator();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                if (item.equals(object)) {
                    iterator.remove();
                    notificarAtualizacao(item.getClass().getSimpleName());
                    System.out.println("Objeto removido: " + item.toString());
                    break;
                }
            }
        }
    }

    public void editar(Object itemNovo, String valor) {
        if (!listaGeral.isEmpty()) {
            for (int i = 0; i < listaGeral.size(); i++) {
                Object item = listaGeral.get(i);
                if (item instanceof Entidade && ((Entidade) item).getId().equals(valor)) {
                    //verifica se são do mesmo tipo
                    if (item.getClass() == itemNovo.getClass()) {
                        listaGeral.set(i, itemNovo);
                        notificarAtualizacao(itemNovo.getClass().getSimpleName());
                        System.out.println("Objeto editado: " + itemNovo.toString());
                        break;
                    }
                }
            }
        }
    }

    private void gerarRelatorio_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarRelatorio_MenuItemActionPerformed

    }//GEN-LAST:event_gerarRelatorio_MenuItemActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void guarda_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guarda_MenuItemActionPerformed
        this.jDesktopPane.removeAll(); // remove todas as telas que estão atualmente ocupando o jDesktopPane
        this.jDesktopPane.add(telaCadastroGuarda); //adiciona no jDesktopPane vazio
        telaCadastroGuarda.setVisible(true); // torna o painel visível 
        telaCadastroGuarda.pack(); // configura as dimensoes do painel        
    }//GEN-LAST:event_guarda_MenuItemActionPerformed

    private void prisioneiro_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiro_MenuItemActionPerformed
        this.jDesktopPane.removeAll();
        this.jDesktopPane.add(telaCadastroPrisioneiro);
        telaCadastroPrisioneiro.setVisible(true);
        telaCadastroPrisioneiro.pack();
    }//GEN-LAST:event_prisioneiro_MenuItemActionPerformed

    private void cela_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cela_MenuItemActionPerformed
        this.jDesktopPane.removeAll();
        this.jDesktopPane.add(telaCadastroCela);
        telaCadastroCela.setVisible(true);
        telaCadastroCela.pack();
    }//GEN-LAST:event_cela_MenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(SistemaCarcerarioJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaCarcerarioJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaCarcerarioJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaCarcerarioJanela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaCarcerarioJanela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cadastrar_Menu;
    private javax.swing.JMenuItem cela_MenuItem;
    private javax.swing.JMenuItem gerarRelatorio_MenuItem;
    private javax.swing.JMenuItem guarda_MenuItem;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu opcoes_Menu;
    private javax.swing.JMenuItem prisioneiro_MenuItem;
    private javax.swing.JMenu sobre_Menu;
    // End of variables declaration//GEN-END:variables
}
