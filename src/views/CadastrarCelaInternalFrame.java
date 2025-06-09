package views;

import classes.Cela;
import classes.Guarda;
import classes.Prisioneiro;
import classes.Turno;
import classes.TurnoInvalidoException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastrarCelaInternalFrame extends javax.swing.JInternalFrame {

    private ArrayList<Cela> listaCela = new ArrayList<>();
    private ArrayList<Guarda> listaGuardas = new ArrayList<>();
    private Set<Prisioneiro> listaPrisioneiros = new HashSet<>();
    DefaultListModel<String> modelDiurno = new DefaultListModel<>();
    DefaultListModel<String> modelNoturno = new DefaultListModel<>();
    DefaultTableModel modelTabela;
    private CadastrarGuardaInternalFrame guardas;
    private CadastrarPrisioneiroInternalFrame prisioneiros;
    private Cela cela;

    public CadastrarCelaInternalFrame(CadastrarGuardaInternalFrame guardaFrame, CadastrarPrisioneiroInternalFrame prisioneiroFrame) {
        initComponents();
        this.celaCadastroPanel.setVisible(false);
        this.pack();
        guardas = guardaFrame;
        prisioneiros = prisioneiroFrame;
        modelTabela = (DefaultTableModel) celaTabela_Table.getModel();
        atualizarConjuntoPrisioneiros();
    }

    public CadastrarCelaInternalFrame() {

    }

    public ArrayList<Cela> getListaCela() {
        return listaCela;
    }

    public void setListaCela(ArrayList<Cela> listaCela) {
        this.listaCela = listaCela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        celaCadastroPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        celaNumero_FomattedField = new javax.swing.JFormattedTextField();
        celaCapaciade_ComboBox = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        celaGuardaDiurno_List = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        celaGuardaNoturno_List = new javax.swing.JList<>();
        celaSalvar_Btn = new javax.swing.JButton();
        celaLimpar_Btn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        celaVoltar_Btn = new javax.swing.JButton();
        celaListaPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        celaTabela_Table = new javax.swing.JTable();
        celaAdicionar_Btn = new javax.swing.JButton();
        celaEditar_Btn = new javax.swing.JButton();
        celaRemover_Btn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Cela");

        celaCadastroPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Número:");

        jLabel2.setText("Capacidade:");

        celaNumero_FomattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        celaCapaciade_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel4.setText("Guarda Diurno:");

        jScrollPane1.setViewportView(celaGuardaDiurno_List);

        jLabel5.setText("Guarda Noturno:");

        jScrollPane2.setViewportView(celaGuardaNoturno_List);

        celaSalvar_Btn.setText("Salvar");
        celaSalvar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaSalvar_BtnActionPerformed(evt);
            }
        });

        celaLimpar_Btn.setText("Limpar");

        celaVoltar_Btn.setText("Voltar");
        celaVoltar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaVoltar_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout celaCadastroPanelLayout = new javax.swing.GroupLayout(celaCadastroPanel);
        celaCadastroPanel.setLayout(celaCadastroPanelLayout);
        celaCadastroPanelLayout.setHorizontalGroup(
            celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celaNumero_FomattedField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celaCapaciade_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, celaCadastroPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(celaVoltar_Btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celaLimpar_Btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(celaSalvar_Btn))))
                    .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        celaCadastroPanelLayout.setVerticalGroup(
            celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(celaNumero_FomattedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(celaCapaciade_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celaSalvar_Btn)
                    .addComponent(celaLimpar_Btn)
                    .addComponent(celaVoltar_Btn))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lista de Celas");

        celaTabela_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Capacidade", "Lotada", "Guarda Diurno", "Guarda Noturno"
            }
        ));
        jScrollPane4.setViewportView(celaTabela_Table);

        celaAdicionar_Btn.setText("Adicionar");
        celaAdicionar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaAdicionar_BtnActionPerformed(evt);
            }
        });

        celaEditar_Btn.setText("Editar");

        celaRemover_Btn.setText("Remover");

        javax.swing.GroupLayout celaListaPanelLayout = new javax.swing.GroupLayout(celaListaPanel);
        celaListaPanel.setLayout(celaListaPanelLayout);
        celaListaPanelLayout.setHorizontalGroup(
            celaListaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(celaListaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(celaListaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, celaListaPanelLayout.createSequentialGroup()
                        .addComponent(celaAdicionar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaEditar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaRemover_Btn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        celaListaPanelLayout.setVerticalGroup(
            celaListaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(celaListaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(celaListaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(celaAdicionar_Btn)
                    .addComponent(celaEditar_Btn)
                    .addComponent(celaRemover_Btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(celaListaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(celaCadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(celaListaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(celaCadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // método para atualizar as listas de guarda diurno e guarda noturno
    public void atualizarListasGuardas(ArrayList<Guarda> lista) {
        
        // pega a lista de guardas que é passada como parametro
        if (guardas != null && !lista.isEmpty()) {
            for (Guarda guarda : lista) {
                if (guarda.getTurno().equals(Turno.DIURNO)) {
                    modelDiurno.addElement(guarda.getMatricula());
                } else {
                    modelNoturno.addElement(guarda.getMatricula());
                }
            }
            celaGuardaDiurno_List.setModel(modelDiurno);
            celaGuardaNoturno_List.setModel(modelNoturno);
        }
    }

    public void atualizarTabela() {

    }

    // método para implementar em CadastrarGuardaInternalFrame para verificar se o guarda já está atribuido
    public boolean listaGuardaAtribuido(String matricula, String funcao) {
        //para cada guarda na lista diurno/noturno, se matricula passada por parametro for igual a matricula do item na lista && 
        //lista de guarda diurno/noturno não for vazia, retorna true, ou seja, permite a remoção defiinitva do guarda ou a edição de turno

        if (funcao.equalsIgnoreCase("editar")) {
            for (Guarda guarda : listaGuardas) {
                if (matricula.equals(guarda.getMatricula())) {
                    JOptionPane.showMessageDialog(null, new TurnoInvalidoException().getMsg());
                    return false;
                }
            }
        } else if (funcao.equalsIgnoreCase("remover")) {
            for (Guarda guarda : listaGuardas) {
                if (matricula.equals(guarda.getMatricula()) && !modelNoturno.isEmpty() || !modelDiurno.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void atualizarConjuntoPrisioneiros() {
        if (prisioneiros != null && prisioneiros.getConjuntoPrisioneiros() != null) {
            Iterator<Prisioneiro> iterator = prisioneiros.getConjuntoPrisioneiros().iterator();
            while (iterator.hasNext()) {
                listaPrisioneiros.add(iterator.next());
            }
        }
    }
    private void celaAdicionar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaAdicionar_BtnActionPerformed
        //atualiza 
        atualizarConjuntoPrisioneiros();
        celaListaPanel.setVisible(false);
        celaCadastroPanel.setVisible(true);
        this.pack();
    }//GEN-LAST:event_celaAdicionar_BtnActionPerformed

    private void celaSalvar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaSalvar_BtnActionPerformed
        boolean lotado = false;
        Guarda guardaDiurno = null;
        Guarda guardaNoturno = null;
        if (listaPrisioneiros != null && listaPrisioneiros.size() >= Integer.parseInt(celaCapaciade_ComboBox.getSelectedItem().toString())) {
            lotado = true;
        }
        if (!celaNumero_FomattedField.getText().isBlank()) {
            if (!celaGuardaDiurno_List.isSelectionEmpty() && !celaGuardaNoturno_List.isSelectionEmpty()) {
                

                // adiciona novo objeto Cela
                cela = new Cela(Integer.parseInt(celaNumero_FomattedField.getText()), Integer.parseInt(celaCapaciade_ComboBox.getSelectedItem().toString()),
                        guardaDiurno, guardaNoturno, listaPrisioneiros, lotado);

                JOptionPane.showMessageDialog(null, "Cela cadastrada com sucesso!");

                String lotadoString;
                if (lotado) {
                    lotadoString = "Sim";
                } else {
                    lotadoString = "Não";
                }

                // configuração visual
                celaListaPanel.setVisible(true);
                celaCadastroPanel.setVisible(false);
                this.pack();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione os guardas.");
            }
        } else
            JOptionPane.showMessageDialog(null, "Número de cela deve ser preenchido!");
    }//GEN-LAST:event_celaSalvar_BtnActionPerformed

    private void celaVoltar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaVoltar_BtnActionPerformed
        celaListaPanel.setVisible(true);
        celaCadastroPanel.setVisible(false);
        this.pack();
    }//GEN-LAST:event_celaVoltar_BtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton celaAdicionar_Btn;
    private javax.swing.JPanel celaCadastroPanel;
    private javax.swing.JComboBox<String> celaCapaciade_ComboBox;
    private javax.swing.JButton celaEditar_Btn;
    private javax.swing.JList<String> celaGuardaDiurno_List;
    private javax.swing.JList<String> celaGuardaNoturno_List;
    private javax.swing.JButton celaLimpar_Btn;
    private javax.swing.JPanel celaListaPanel;
    private javax.swing.JFormattedTextField celaNumero_FomattedField;
    private javax.swing.JButton celaRemover_Btn;
    private javax.swing.JButton celaSalvar_Btn;
    private javax.swing.JTable celaTabela_Table;
    private javax.swing.JButton celaVoltar_Btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
