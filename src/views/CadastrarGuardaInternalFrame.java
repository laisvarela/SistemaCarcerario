package views;

import classes.Guarda;
import classes.Turno;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastrarGuardaInternalFrame extends javax.swing.JInternalFrame {

    private Guarda guarda;
    private ArrayList<Guarda> listaGuardas = new ArrayList<>();
    private DefaultTableModel table;
    private DateTimeFormatter formatter;
    private LocalDate dataNasci, dataAdmissao;
    private int linha;
    private String matricula;
    private CadastrarCelaInternalFrame cela = new CadastrarCelaInternalFrame();

    public CadastrarGuardaInternalFrame() {
        initComponents();
        cadastrarGuardaPanel.setVisible(false);
        table = (DefaultTableModel) guardaLista_Table.getModel();
        guardaEditar_Btn.setVisible(false);
        guardaRemover_Btn.setVisible(false);
        editarSalvar_Btn.setVisible(false);
        atualizaTabela();
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrarGuardaPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        guardaNome_TextField = new javax.swing.JTextField();
        guardaDataNasci_FormattedTextField = new javax.swing.JFormattedTextField();
        guardaCPF_FormattedTextField = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        guardaSalvar_Button = new javax.swing.JButton();
        guardaLimpar_Button = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        guardaDataAdmissao_FormattedTextField = new javax.swing.JFormattedTextField();
        guardaMatricula_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        guarda_ComboBox = new javax.swing.JComboBox<>();
        editarSalvar_Btn = new javax.swing.JButton();
        guardaVoltar_Button = new javax.swing.JButton();
        editarGuardaPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        guardaLista_Table = new javax.swing.JTable();
        guardaAdicionar_Btn = new javax.swing.JButton();
        guardaEditar_Btn = new javax.swing.JButton();
        guardaRemover_Btn = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Guarda");

        cadastrarGuardaPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Dados Pessoais");

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de Nascimento:");

        jLabel4.setText("CPF:");

        try {
            guardaDataNasci_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            guardaCPF_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Matrícula:");

        guardaSalvar_Button.setText("Salvar");
        guardaSalvar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaSalvar_ButtonActionPerformed(evt);
            }
        });

        guardaLimpar_Button.setText("Limpar");
        guardaLimpar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaLimpar_ButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Informações");

        jLabel6.setText("Data Admissão:");

        try {
            guardaDataAdmissao_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Turno:");

        guarda_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diurno", "Noturno", " " }));

        editarSalvar_Btn.setText("Salvar");
        editarSalvar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSalvar_BtnActionPerformed(evt);
            }
        });

        guardaVoltar_Button.setText("Voltar");
        guardaVoltar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaVoltar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrarGuardaPanelLayout = new javax.swing.GroupLayout(cadastrarGuardaPanel);
        cadastrarGuardaPanel.setLayout(cadastrarGuardaPanelLayout);
        cadastrarGuardaPanelLayout.setHorizontalGroup(
            cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarGuardaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarGuardaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardaVoltar_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardaLimpar_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarSalvar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardaSalvar_Button))
                    .addGroup(cadastrarGuardaPanelLayout.createSequentialGroup()
                        .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarGuardaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardaMatricula_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guarda_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardaDataAdmissao_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(cadastrarGuardaPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(guardaNome_TextField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastrarGuardaPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(7, 7, 7)
                                    .addComponent(guardaDataNasci_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(guardaCPF_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cadastrarGuardaPanelLayout.setVerticalGroup(
            cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarGuardaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(guardaNome_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(guardaDataNasci_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardaCPF_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(guardaDataAdmissao_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardaMatricula_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(guarda_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardaLimpar_Button)
                    .addComponent(guardaSalvar_Button)
                    .addComponent(editarSalvar_Btn)
                    .addComponent(guardaVoltar_Button))
                .addContainerGap())
        );

        getContentPane().add(cadastrarGuardaPanel, java.awt.BorderLayout.LINE_START);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Lista de Guardas");

        guardaLista_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Matrícula", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        guardaLista_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(guardaLista_Table);

        guardaAdicionar_Btn.setText("Adicionar");
        guardaAdicionar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaAdicionar_BtnActionPerformed(evt);
            }
        });

        guardaEditar_Btn.setText("Editar");
        guardaEditar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaEditar_BtnActionPerformed(evt);
            }
        });

        guardaRemover_Btn.setText("Remover");
        guardaRemover_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaRemover_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editarGuardaPanelLayout = new javax.swing.GroupLayout(editarGuardaPanel);
        editarGuardaPanel.setLayout(editarGuardaPanelLayout);
        editarGuardaPanelLayout.setHorizontalGroup(
            editarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarGuardaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarGuardaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarGuardaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardaAdicionar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardaEditar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardaRemover_Btn)))
                .addContainerGap())
        );
        editarGuardaPanelLayout.setVerticalGroup(
            editarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarGuardaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editarGuardaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardaAdicionar_Btn)
                    .addComponent(guardaEditar_Btn)
                    .addComponent(guardaRemover_Btn))
                .addContainerGap())
        );

        getContentPane().add(editarGuardaPanel, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<Guarda> getListaGuardas() {
        return listaGuardas;
    }

    public void setListaGuardas(ArrayList<Guarda> listaGuardas) {
        this.listaGuardas = listaGuardas;
    }

    private void atualizaTabela() {
        for (Guarda listaGuarda : listaGuardas) {
            table.setValueAt(listaGuarda.getNome(), linha, 0);
            table.setValueAt(listaGuarda.getMatricula(), linha, 1);
            table.setValueAt(listaGuarda.getTurno(), linha, 2);
        }
    }

    private void guardaAdicionar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaAdicionar_BtnActionPerformed
        cadastrarConfig();
    }//GEN-LAST:event_guardaAdicionar_BtnActionPerformed

    private void guardaLimpar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaLimpar_ButtonActionPerformed
        limpar();
    }//GEN-LAST:event_guardaLimpar_ButtonActionPerformed

    private void guardaSalvar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaSalvar_ButtonActionPerformed

        if (verificarCampos()) { // adiciona guarda se todos os campos forem válidos
            try {
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // padrão de formatação para data
                dataNasci = LocalDate.parse(guardaDataNasci_FormattedTextField.getText(), formatter);
                dataAdmissao = LocalDate.parse(guardaDataAdmissao_FormattedTextField.getText(), formatter);
                String turno;
                if (guarda_ComboBox.getSelectedItem().equals("Diurno")) {
                    turno = "DIURNO";
                } else {
                    turno = "NOTURNO";
                }
                if (checarCPF_MatriculaDuplicado(guardaCPF_FormattedTextField.getText(), guardaMatricula_TextField.getText())) {
                    // cria um objeto Guarda passando como parametro os valores informados na tela
                    guarda = new Guarda(guardaMatricula_TextField.getText(), Turno.valueOf(turno), dataAdmissao,
                            guardaNome_TextField.getText(), guardaCPF_FormattedTextField.getText(),
                            dataNasci);

                    // adiciona na lista
                    listaGuardas.add(guarda);

                    // adiciona na tabela
                    table.addRow(new Object[]{guardaNome_TextField.getText(), guardaMatricula_TextField.getText(), turno});

                    cela.atualizarListasGuardas(listaGuardas);
                    
                    JOptionPane.showMessageDialog(null, "Guarda cadastrado com sucesso!");

                    // método para limpar os campos
                    limpar();

                    // configuração visual
                    editarGuardaPanel.setVisible(true);
                    cadastrarGuardaPanel.setVisible(false);
                    guardaEditar_Btn.setVisible(true);
                    guardaRemover_Btn.setVisible(true);
                    this.pack();
                }

            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(null, "Data inválida!");
            }
        } else
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
    }//GEN-LAST:event_guardaSalvar_ButtonActionPerformed

    private void guardaEditar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaEditar_BtnActionPerformed
        linha = guardaLista_Table.getSelectedRow();
        if (linha >= 0) { // uma linha deve estar selecionada para habilitar a tela de editar
            matricula = (String) table.getValueAt(linha, 1);
            for (Guarda listaGuarda : listaGuardas) {
                if (listaGuarda.getMatricula().equals(matricula)) {
                    // preenche os campos com os dados do guarda selecionado
                    guardaNome_TextField.setText(listaGuarda.getNome());
                    dataNasci = listaGuarda.getDataNascimento();
                    guardaDataNasci_FormattedTextField.setValue(dataNasci.format(formatter));
                    guardaMatricula_TextField.setText(listaGuarda.getMatricula());
                    guardaCPF_FormattedTextField.setText(listaGuarda.getCpf());
                    guardaDataAdmissao_FormattedTextField.setValue(dataAdmissao.format(formatter));
                    guarda_ComboBox.setSelectedItem(listaGuarda.getTurno().toString());
                    break;
                }
            }
            // chama o método que deixa enabled apenas os campos que podem ser editados
            editarConfig();
        } else { // senão pede para selecionar um item
            JOptionPane.showMessageDialog(null, "Selecione um item.");
        }

    }//GEN-LAST:event_guardaEditar_BtnActionPerformed

    private void editarSalvar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarSalvar_BtnActionPerformed
        Turno turno;
        if (guarda_ComboBox.getSelectedItem().equals("Diurno")) {
            turno = Turno.DIURNO;
        } else {
            turno = Turno.NOTURNO;
        }
        linha = guardaLista_Table.getSelectedRow();

        if (linha >= 0) {
            for (Guarda listaGuarda : listaGuardas) {
                if (listaGuarda.getMatricula().equals(matricula)) {
                    if (!guardaNome_TextField.getText().isBlank()) {
                        // edita nome e turno no objeto Guarda
                        listaGuarda.setNome(guardaNome_TextField.getText());
                        table.setValueAt(listaGuarda.getNome(), linha, 0);
                        //atualiza lista de guarda em Cela
                        cela.atualizarListasGuardas(listaGuardas);

                        //configuração visual
                        cadastrarGuardaPanel.setVisible(false);
                        editarGuardaPanel.setVisible(true);
                        editarSalvar_Btn.setVisible(false);
                        guardaSalvar_Button.setVisible(true);
                        this.pack();

                    } else {
                        JOptionPane.showMessageDialog(null, "Nome não pode estar vazio!");
                    }
                    if (!listaGuarda.getTurno().equals(turno)) {
                        if (cela.listaGuardaAtribuido(listaGuarda.getMatricula(), "editar")) {
                            listaGuarda.setTurno(turno);
                            table.setValueAt(listaGuarda.getTurno(), linha, 2);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_editarSalvar_BtnActionPerformed

    private void guardaRemover_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaRemover_BtnActionPerformed
        linha = guardaLista_Table.getSelectedRow();
        if (linha >= 0) {
            matricula = (String) table.getValueAt(linha, 1);
            for (Guarda listaGuarda : listaGuardas) {
                if (listaGuarda.getMatricula().equals(matricula)) {
                    if (cela.listaGuardaAtribuido(listaGuarda.getMatricula(), "remover")) {
                        listaGuardas.remove(listaGuarda);
                        table.removeRow(linha);
                        //atualiza lista de guarda em Cela
                        cela.atualizarListasGuardas(listaGuardas);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cela não pode ficar sem guarda! Atualmente, não há outro guarda disponível cadastrado neste turno.");
                    }
                }
            }
        } else
            JOptionPane.showMessageDialog(null, "Selecione um item.");
    }//GEN-LAST:event_guardaRemover_BtnActionPerformed

    private void guardaVoltar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaVoltar_ButtonActionPerformed
        editarGuardaPanel.setVisible(true);
        cadastrarGuardaPanel.setVisible(false);
        this.pack();
    }//GEN-LAST:event_guardaVoltar_ButtonActionPerformed

    // método para limpar campos
    private void limpar() {
        guardaCPF_FormattedTextField.setValue(null);
        guardaDataAdmissao_FormattedTextField.setValue(null);
        guardaDataNasci_FormattedTextField.setValue(null);
        guardaMatricula_TextField.setText(null);
        guardaNome_TextField.setText(null);
    }

    // método para validar se campos estão vazios
    private boolean verificarCampos() {
        // usa replaceAll() nos FormattedTextField para ignorar os caracteres especiais
        return !(guardaNome_TextField.getText().isEmpty()
                || guardaCPF_FormattedTextField.getText().replaceAll("[.-]", "").isBlank()
                || guardaDataNasci_FormattedTextField.getText().replaceAll("/", "").isBlank()
                || guardaMatricula_TextField.getText().isBlank()
                || guardaDataAdmissao_FormattedTextField.getText().replaceAll("/", "").isBlank());
    }

    private void editarConfig() {
        editarGuardaPanel.setVisible(false);
        cadastrarGuardaPanel.setVisible(true);
        guardaDataNasci_FormattedTextField.setEnabled(false);
        guardaCPF_FormattedTextField.setEnabled(false);
        guardaMatricula_TextField.setEnabled(false);
        guardaDataAdmissao_FormattedTextField.setEnabled(false);
        editarSalvar_Btn.setVisible(true);
        guardaSalvar_Button.setVisible(false);
        guardaLimpar_Button.setVisible(false);
        this.pack();
    }

    private void cadastrarConfig() {
        limpar();
        editarGuardaPanel.setVisible(false);
        cadastrarGuardaPanel.setVisible(true);
        guardaDataNasci_FormattedTextField.setEnabled(true);
        guardaCPF_FormattedTextField.setEnabled(true);
        guardaMatricula_TextField.setEnabled(true);
        guardaDataAdmissao_FormattedTextField.setEnabled(true);
        editarSalvar_Btn.setVisible(false);
        guardaSalvar_Button.setVisible(true);
        this.pack();
    }

    private boolean checarCPF_MatriculaDuplicado(String cpf, String matricula) {
        if (guarda != null && listaGuardas != null) {
            for (Guarda g : listaGuardas) {
                if (g.getCpf().equals(cpf)) {
                    JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
                    guardaCPF_FormattedTextField.setValue(null);
                    return false;
                }
                if (g.getMatricula().equals(matricula)) {
                    JOptionPane.showMessageDialog(null, "Matrícula já cadastrada!");
                    guardaMatricula_TextField.setText(null);
                    return false;
                }
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cadastrarGuardaPanel;
    private javax.swing.JPanel editarGuardaPanel;
    private javax.swing.JButton editarSalvar_Btn;
    private javax.swing.JButton guardaAdicionar_Btn;
    private javax.swing.JFormattedTextField guardaCPF_FormattedTextField;
    private javax.swing.JFormattedTextField guardaDataAdmissao_FormattedTextField;
    private javax.swing.JFormattedTextField guardaDataNasci_FormattedTextField;
    private javax.swing.JButton guardaEditar_Btn;
    private javax.swing.JButton guardaLimpar_Button;
    private javax.swing.JTable guardaLista_Table;
    private javax.swing.JTextField guardaMatricula_TextField;
    private javax.swing.JTextField guardaNome_TextField;
    private javax.swing.JButton guardaRemover_Btn;
    private javax.swing.JButton guardaSalvar_Button;
    private javax.swing.JButton guardaVoltar_Button;
    private javax.swing.JComboBox<String> guarda_ComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
