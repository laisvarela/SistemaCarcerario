package view;

import controller.CelaController;
import controller.GuardaController;
import controller.PrisioneiroController;
import java.util.ArrayList;
import listener.AtualizavelListener;
import model.Cela;
import model.Guarda;
import model.Prisioneiro;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CelaView extends javax.swing.JInternalFrame implements AtualizavelListener {

    DefaultListModel<String> modelDiurno = new DefaultListModel<>();
    DefaultListModel<String> modelNoturno = new DefaultListModel<>();
    DefaultTableModel tableModel;
    private Set<Prisioneiro> prisioneiroLista = new HashSet<>();
    private Cela cela;
    private SistemaCarcerarioView main;
    private CelaController celaController;
    private PrisioneiroController prisioneiroController;
    private GuardaController guardaController;

    public CelaView(SistemaCarcerarioView main) {
        initComponents();
        this.main = main;
        main.addListener(this);
        this.celaCadastroPanel.setVisible(false);

        tableModel = (DefaultTableModel) celaTabela_Table.getModel();
        celaGuardaDiurno_List.setModel(modelDiurno);
        celaGuardaNoturno_List.setModel(modelNoturno);
        celaEditarSalvar_Btn.setVisible(false);

        celaController = new CelaController();
        prisioneiroController = new PrisioneiroController();
        guardaController = new GuardaController();
        atualizaTabela();
        isLotado();
        atualizaListaGuardas();
        botoesConfig();
        this.pack();
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
        celaEditarSalvar_Btn = new javax.swing.JButton();
        celaListaPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        celaTabela_Table = new javax.swing.JTable();
        celaAdicionar_Btn = new javax.swing.JButton();
        celaEditar_Btn = new javax.swing.JButton();
        celaRemover_Btn = new javax.swing.JButton();
        celaBuscar_TextField = new javax.swing.JTextField();
        celaBuscar_Btn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Cela");

        celaCadastroPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Número:");

        jLabel2.setText("Capacidade:");

        try {
            celaNumero_FomattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
        celaLimpar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaLimpar_BtnActionPerformed(evt);
            }
        });

        celaVoltar_Btn.setText("Voltar");
        celaVoltar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaVoltar_BtnActionPerformed(evt);
            }
        });

        celaEditarSalvar_Btn.setText("Salvar");
        celaEditarSalvar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaEditarSalvar_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout celaCadastroPanelLayout = new javax.swing.GroupLayout(celaCadastroPanel);
        celaCadastroPanel.setLayout(celaCadastroPanelLayout);
        celaCadastroPanelLayout.setHorizontalGroup(
            celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaNumero_FomattedField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaCapaciade_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(celaCadastroPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(celaVoltar_Btn)
                        .addGap(52, 52, 52)
                        .addComponent(celaLimpar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaEditarSalvar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaSalvar_Btn)))
                .addGap(0, 8, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(celaCadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(celaSalvar_Btn)
                        .addComponent(celaEditarSalvar_Btn)
                        .addComponent(celaLimpar_Btn))
                    .addComponent(celaVoltar_Btn))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lista de Celas");

        celaTabela_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Capacidade", "Guarda Diurno", "Guarda Noturno"
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
        celaEditar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaEditar_BtnActionPerformed(evt);
            }
        });

        celaRemover_Btn.setText("Remover");
        celaRemover_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaRemover_BtnActionPerformed(evt);
            }
        });

        celaBuscar_Btn.setText("Buscar");
        celaBuscar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celaBuscar_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout celaListaPanelLayout = new javax.swing.GroupLayout(celaListaPanel);
        celaListaPanel.setLayout(celaListaPanelLayout);
        celaListaPanelLayout.setHorizontalGroup(
            celaListaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(celaListaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(celaListaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, celaListaPanelLayout.createSequentialGroup()
                        .addComponent(celaBuscar_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaBuscar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(celaRemover_Btn)
                    .addComponent(celaBuscar_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(celaBuscar_Btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(celaListaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(celaCadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(celaListaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(celaCadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // atualiza as listas sempre que ocorre uma alteração
    @Override
    public void dadosAtualizados() {
        atualizaTabela();
        isLotado();
        atualizaListaGuardas();
        botoesConfig();
    }

    // método para atualizar tabela com os dados da cela
    private void atualizaTabela() {
        tableModel.setRowCount(0); // Limpa a tabela
        ArrayList<Cela> celas = celaController.listarCelas();
        for (Cela cela : celas) {
            tableModel.addRow(new Object[]{
                cela.getNumero(),
                cela.getCapacidade(),
                cela.getGuardaDiurno().getMatricula(),
                cela.getGuardaNoturno().getMatricula()
            });
        }
    }

    private void atualizaListaGuardas() {
        modelDiurno.clear();
        modelNoturno.clear();

        ArrayList<Guarda> guardas = guardaController.listarGuardas();

        for (Guarda guarda : guardas) {
            //adiciona na lista apenas se não estiver atribuido
            if (!guarda.isAtribuido()) {
                if (guarda.getTurno().equalsIgnoreCase("diurno")) {
                    modelDiurno.addElement(guarda.getMatricula());
                } else {
                    modelNoturno.addElement(guarda.getMatricula());
                }
            }
        }
    }

    // método para atualizar a lista de prisioneiros
    private boolean isLotado() {
        ArrayList<Prisioneiro> prisioneiros = prisioneiroController.listarPrisioneiros();
        ArrayList<Cela> celas = celaController.listarCelas();

        for (Cela c : celas) {
            for (Prisioneiro p : prisioneiros) {
                if (p.getCela() == c.getNumero()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validarGuardasParaCela() {
        ArrayList<Guarda> guardas = guardaController.listarGuardas();
        int guardasDiurnosDisponiveis = 0;
        int guardasNoturnosDisponiveis = 0;

        for (Guarda g : guardas) {
            if (g != null && !g.isAtribuido() && g.getTurno() != null) {
                if (g.getTurno().equalsIgnoreCase("diurno")) {
                    guardasDiurnosDisponiveis++;
                } else if (g.getTurno().equalsIgnoreCase("noturno")) {
                    guardasNoturnosDisponiveis++;
                }
            }
        }

        if (guardasDiurnosDisponiveis == 0 || guardasNoturnosDisponiveis == 0) {
            String mensagem = "Cadastro de cela bloqueado:\n";

            if (guardasDiurnosDisponiveis == 0) {
                mensagem += "• Não há guardas diurnos disponíveis\n";
            }
            if (guardasNoturnosDisponiveis == 0) {
                mensagem += "• Não há guardas noturnos disponíveis\n";
            }

            mensagem += "\nCadastre guardas antes de criar celas.";

            JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void botoesConfig() {
        boolean guardasValidos = validarGuardasParaCela();

        // Mostra botões apenas se houver guardas válidos
        celaAdicionar_Btn.setVisible(guardasValidos);
        celaEditar_Btn.setVisible(guardasValidos);
    }

    private void celaAdicionar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaAdicionar_BtnActionPerformed
        cadsatrarConfig();
        this.pack();
    }//GEN-LAST:event_celaAdicionar_BtnActionPerformed

    private void celaSalvar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaSalvar_BtnActionPerformed
        Guarda guardaDiurno = new Guarda(null, null, null);
        Guarda guardaNoturno = new Guarda(null, null, null);
        if (!celaNumero_FomattedField.getText().isBlank()) {
            if (!celaGuardaDiurno_List.isSelectionEmpty() && !celaGuardaNoturno_List.isSelectionEmpty()) {
                guardaDiurno.setMatricula(celaGuardaDiurno_List.getSelectedValue());
                guardaNoturno.setMatricula(celaGuardaNoturno_List.getSelectedValue());
                // adiciona novo objeto Cela
                cela = new Cela(Integer.parseInt(celaNumero_FomattedField.getText()),
                        Integer.parseInt(celaCapaciade_ComboBox.getSelectedItem().toString()),
                        guardaDiurno, guardaNoturno, prisioneiroLista, isLotado());

                celaController.cadastrarCela(cela);
                atribuirGuarda(guardaDiurno);
                atribuirGuarda(guardaNoturno);
                main.notificarAtualizacao();
                // adiciona na lista geral
                JOptionPane.showMessageDialog(null, "Cela cadastrada com sucesso!");

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
    private void atribuirGuarda(Guarda guarda) {
        ArrayList<Guarda> guardas = guardaController.listarGuardas();
        for (Guarda g : guardas) {
            if (g.getMatricula().equalsIgnoreCase(guarda.getMatricula())) {
                g.setAtribuido(true);
            }
        }
    }
    private void celaVoltar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaVoltar_BtnActionPerformed
        celaListaPanel.setVisible(true);
        celaCadastroPanel.setVisible(false);
        celaEditarSalvar_Btn.setVisible(false);
        celaEditar_Btn.setVisible(true);
        this.pack();
    }//GEN-LAST:event_celaVoltar_BtnActionPerformed

    private void celaEditarSalvar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaEditarSalvar_BtnActionPerformed
        Guarda diurno, noturno;
        diurno = new Guarda(null, null, null);
        noturno = new Guarda(null, null, null);

        if (!celaGuardaDiurno_List.isSelectionEmpty() && !celaGuardaNoturno_List.isSelectionEmpty()) {
            diurno.setMatricula(celaGuardaDiurno_List.getSelectedValue());
            noturno.setMatricula(celaGuardaNoturno_List.getSelectedValue());

            cela = new Cela(Integer.parseInt(celaNumero_FomattedField.getText()),
                    Integer.parseInt(celaCapaciade_ComboBox.getSelectedItem().toString()),
                    diurno, noturno, prisioneiroLista, isLotado());
            celaController.editarCela(cela);
            main.notificarAtualizacao();
        } else {
            JOptionPane.showMessageDialog(null, "Guarda diurno e noturno precisa ser selecionado.");

        }

    }//GEN-LAST:event_celaEditarSalvar_BtnActionPerformed

    private void celaEditar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaEditar_BtnActionPerformed
        editarConfig();
    }//GEN-LAST:event_celaEditar_BtnActionPerformed

    private void celaLimpar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaLimpar_BtnActionPerformed
        limpar();
    }//GEN-LAST:event_celaLimpar_BtnActionPerformed

    private void celaBuscar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaBuscar_BtnActionPerformed
        if (celaTabela_Table.getRowCount() > 0) {
            if (!celaBuscar_TextField.getText().isBlank()) {
                String celaEncontrada = celaController.buscarCela(celaBuscar_TextField.getText());
                for (int i = 0; i < celaTabela_Table.getRowCount(); i++) {
                    String numTabela = celaTabela_Table.getValueAt(i, 1).toString();
                    if (numTabela.equals(celaEncontrada)) {
                        celaTabela_Table.setRowSelectionInterval(i, i);
                        celaBuscar_TextField.setText("");
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite um número de cela válido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há nenhuma cela cadastrada ainda.");
        }
    }//GEN-LAST:event_celaBuscar_BtnActionPerformed

    private void celaRemover_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celaRemover_BtnActionPerformed
        int linha = celaTabela_Table.getSelectedRow();
        if (linha >= 0) {
            int numeroCela = (Integer) tableModel.getValueAt(linha, 0); 

            // Verifica se há prisioneiros nesta cela
            if (prisioneiroController.existePrisioneiroNaCela(numeroCela)) {
                JOptionPane.showMessageDialog(null,
                        "Não é possível excluir a cela " + numeroCela
                        + " pois há prisioneiros alocados.",
                        "Operação não permitida",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // Confirmação antes de excluir
                int confirmacao = JOptionPane.showConfirmDialog(
                        null,
                        "Deseja realmente excluir a cela " + numeroCela + "?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacao == JOptionPane.YES_OPTION) {
                    celaController.remover(numeroCela);
                    main.notificarAtualizacao();
                    JOptionPane.showMessageDialog(null, "Cela removida com sucesso!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma cela para remover.");
        }
    }//GEN-LAST:event_celaRemover_BtnActionPerformed

    private void editarConfig() {
        celaListaPanel.setVisible(false);
        celaCadastroPanel.setVisible(true);

        celaSalvar_Btn.setVisible(false);
        celaEditarSalvar_Btn.setVisible(true);
        celaLimpar_Btn.setVisible(false);

        celaNumero_FomattedField.setEnabled(false);

        ArrayList<Guarda> guardas = guardaController.listarGuardas();
        int gd = 0, gn = 0;
        for (Guarda g : guardas) {
            if (!g.isAtribuido()) {
                if (g.getTurno().equalsIgnoreCase("diurno")) {
                    gd++;
                } else {
                    gn++;
                }
            }
        }

        if (gd == 0) {
            celaGuardaDiurno_List.setVisible(false);
        } else {
            celaGuardaDiurno_List.setVisible(true);
        }
        if (gn == 0) {
            celaGuardaNoturno_List.setVisible(false);
        } else {
            celaGuardaNoturno_List.setVisible(true);
        }
        this.pack();
    }

    private void cadsatrarConfig() {
        celaListaPanel.setVisible(false);
        celaCadastroPanel.setVisible(true);

        celaSalvar_Btn.setVisible(true);
        celaEditarSalvar_Btn.setVisible(false);
        celaLimpar_Btn.setVisible(true);

        celaNumero_FomattedField.setEnabled(true);

        this.pack();
    }

    private void limpar() {
        celaNumero_FomattedField.setText(null);
        celaCapaciade_ComboBox.setSelectedItem(1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton celaAdicionar_Btn;
    private javax.swing.JButton celaBuscar_Btn;
    private javax.swing.JTextField celaBuscar_TextField;
    private javax.swing.JPanel celaCadastroPanel;
    private javax.swing.JComboBox<String> celaCapaciade_ComboBox;
    private javax.swing.JButton celaEditarSalvar_Btn;
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
