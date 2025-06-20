package view;

import listener.AtualizavelListener;
import model.Cela;
import model.Prisioneiro;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrisioneiroView extends javax.swing.JInternalFrame implements AtualizavelListener {

    DefaultTableModel modelTable, modelCelaTable;
    private Prisioneiro prisioneiro;
    private DateTimeFormatter formatter;
    private LocalDate dataNasci, dataPrisao;
    private SistemaCarcerarioView main;

    public PrisioneiroView(SistemaCarcerarioView main) {
        initComponents();
        this.main = main;
        main.addListener(this);
        this.cadastrarPrisioneiroPanel.setVisible(false);
        modelTable = (DefaultTableModel) prisioneiroLista_Table.getModel();
        modelCelaTable = (DefaultTableModel) prisioneiroCela_Table.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        editarPrisioneiroPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prisioneiroLista_Table = new javax.swing.JTable();
        prisioneiroAdicionar_Btn = new javax.swing.JButton();
        celaEditar_Btn = new javax.swing.JButton();
        celaRemover_Btn = new javax.swing.JButton();
        cadastrarPrisioneiroPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prisioneiroNome_TextField = new javax.swing.JTextField();
        prisioneiroDataNasci_FormattedTextField = new javax.swing.JFormattedTextField();
        prisioneiroCPF_FormattedTextField = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        prisioneiroSalvar_Button = new javax.swing.JButton();
        prisioneiroLimpar_Button = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        prisioneiroPenaFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        prisioneiroDataPrisao_FormattedTextField = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prisioneiroCela_Table = new javax.swing.JTable();
        prisioneiroNumRegistro_TextField = new javax.swing.JTextField();
        prisioneiroVoltar_Button = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Prisioneiro");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Lista de Prisioneiros");

        prisioneiroLista_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Número de Registro", "Pena", "Cela"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(prisioneiroLista_Table);

        prisioneiroAdicionar_Btn.setText("Adicionar");
        prisioneiroAdicionar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroAdicionar_BtnActionPerformed(evt);
            }
        });

        celaEditar_Btn.setText("Editar");

        celaRemover_Btn.setText("Remover");

        javax.swing.GroupLayout editarPrisioneiroPanelLayout = new javax.swing.GroupLayout(editarPrisioneiroPanel);
        editarPrisioneiroPanel.setLayout(editarPrisioneiroPanelLayout);
        editarPrisioneiroPanelLayout.setHorizontalGroup(
            editarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPrisioneiroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarPrisioneiroPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarPrisioneiroPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(prisioneiroAdicionar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaEditar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(celaRemover_Btn)))
                .addContainerGap())
        );
        editarPrisioneiroPanelLayout.setVerticalGroup(
            editarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarPrisioneiroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prisioneiroAdicionar_Btn)
                    .addComponent(celaEditar_Btn)
                    .addComponent(celaRemover_Btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cadastrarPrisioneiroPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Dados Pessoais");

        jLabel2.setText("Nome:");

        jLabel3.setText("Data de Nascimento:");

        jLabel4.setText("CPF:");

        try {
            prisioneiroDataNasci_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            prisioneiroCPF_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Número de Registro:");

        prisioneiroSalvar_Button.setText("Salvar");
        prisioneiroSalvar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroSalvar_ButtonActionPerformed(evt);
            }
        });

        prisioneiroLimpar_Button.setText("Limpar");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Informações");

        jLabel8.setText("Pena:");

        try {
            prisioneiroPenaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Data da Prisão:");

        try {
            prisioneiroDataPrisao_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Selecione a Cela:");

        prisioneiroCela_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Capacidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prisioneiroCela_Table);

        prisioneiroVoltar_Button.setText("Voltar");
        prisioneiroVoltar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroVoltar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrarPrisioneiroPanelLayout = new javax.swing.GroupLayout(cadastrarPrisioneiroPanel);
        cadastrarPrisioneiroPanel.setLayout(cadastrarPrisioneiroPanelLayout);
        cadastrarPrisioneiroPanelLayout.setHorizontalGroup(
            cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(prisioneiroNome_TextField))
                                        .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(7, 7, 7)
                                            .addComponent(prisioneiroDataNasci_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(prisioneiroCPF_FormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                        .addComponent(jLabel7))
                                    .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                                .addComponent(prisioneiroNumRegistro_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prisioneiroPenaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prisioneiroDataPrisao_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 5, Short.MAX_VALUE))))
                    .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                .addComponent(prisioneiroVoltar_Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prisioneiroLimpar_Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prisioneiroSalvar_Button))
                            .addComponent(jSeparator2))))
                .addContainerGap())
        );
        cadastrarPrisioneiroPanelLayout.setVerticalGroup(
            cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(prisioneiroNome_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(prisioneiroDataNasci_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prisioneiroCPF_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(prisioneiroPenaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(prisioneiroDataPrisao_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prisioneiroNumRegistro_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prisioneiroSalvar_Button)
                    .addComponent(prisioneiroLimpar_Button)
                    .addComponent(prisioneiroVoltar_Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editarPrisioneiroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrarPrisioneiroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(editarPrisioneiroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastrarPrisioneiroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void dadosAtualizados(String tipo) {
        if (tipo.equals("Prisioneiro")) {
            atualizaTabela();
        }
    }

    private void atualizaTabela() {

    }
    private void prisioneiroAdicionar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroAdicionar_BtnActionPerformed
        cadastrarPrisioneiroPanel.setVisible(true);
        editarPrisioneiroPanel.setVisible(false);
        this.pack();
    }//GEN-LAST:event_prisioneiroAdicionar_BtnActionPerformed

    private void prisioneiroSalvar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroSalvar_ButtonActionPerformed
        if (verificarCampos()) {
            try {
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // padrão de formatação para data
                dataNasci = LocalDate.parse(prisioneiroDataNasci_FormattedTextField.getText(), formatter);
                dataPrisao = LocalDate.parse(prisioneiroDataPrisao_FormattedTextField.getText(), formatter);
                if (checarCPF_NumDuplicado(prisioneiroCPF_FormattedTextField.getText(), prisioneiroNumRegistro_TextField.getText())) {
                    // cria um objeto Prisioneiro passando como parametro os valores informados na tela
                    

                    // adiciona na tabela
                    modelTable.addRow(new Object[]{prisioneiroNome_TextField.getText(), prisioneiroNumRegistro_TextField.getText(),
                        prisioneiroPenaFormattedTextField.getText()});

                    JOptionPane.showMessageDialog(null, "Prisioneiro cadastrado com sucesso!");

                    // método para limpar os campos
                    limpar();

                    // configuração visual
                    editarPrisioneiroPanel.setVisible(true);
                    cadastrarPrisioneiroPanel.setVisible(false);
                    this.pack();
                }

            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(null, "Data inválida!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
        }
    }//GEN-LAST:event_prisioneiroSalvar_ButtonActionPerformed

    private void prisioneiroVoltar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroVoltar_ButtonActionPerformed
        editarPrisioneiroPanel.setVisible(true);
        cadastrarPrisioneiroPanel.setVisible(false);
        this.pack();
    }//GEN-LAST:event_prisioneiroVoltar_ButtonActionPerformed

    private boolean verificarCampos() {
        return !(prisioneiroNome_TextField.getText().isBlank()
                || prisioneiroDataNasci_FormattedTextField.getText().replaceAll("/", "").isBlank()
                || prisioneiroDataPrisao_FormattedTextField.getText().replaceAll("/", "").isBlank()
                || prisioneiroCPF_FormattedTextField.getText().replaceAll("[.-]", "").isBlank()
                || prisioneiroPenaFormattedTextField.getText().isBlank()
                || prisioneiroNumRegistro_TextField.getText().isBlank());
    }

    private void limpar() {
        prisioneiroNome_TextField.setText(null);
        prisioneiroDataNasci_FormattedTextField.setValue(null);
        prisioneiroDataPrisao_FormattedTextField.setValue(null);
        prisioneiroCPF_FormattedTextField.setValue(null);
        prisioneiroPenaFormattedTextField.setValue(null);
        prisioneiroNumRegistro_TextField.setText(null);
    }

    private void adicionarCela() {
        
    }

    private boolean checarCPF_NumDuplicado(String cpf, String num) {
        /*if (prisioneiro != null && main.getListaGeral() != null) {
            for (Object object : main.getListaGeral()) {
                if (object instanceof Prisioneiro p) {
                    if (p.getCpf().equals(cpf)) {
                        JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
                        prisioneiroCPF_FormattedTextField.setValue(null);
                        return false;
                    }
                    if (p.getNumRegistro().equals(num)) {
                        JOptionPane.showMessageDialog(null, "Número de registro já cadastrado!");
                        prisioneiroNumRegistro_TextField.setText(null);
                        return false;
                    }
                }
            }
        }*/
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cadastrarPrisioneiroPanel;
    private javax.swing.JButton celaEditar_Btn;
    private javax.swing.JButton celaRemover_Btn;
    private javax.swing.JPanel editarPrisioneiroPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton prisioneiroAdicionar_Btn;
    private javax.swing.JFormattedTextField prisioneiroCPF_FormattedTextField;
    private javax.swing.JTable prisioneiroCela_Table;
    private javax.swing.JFormattedTextField prisioneiroDataNasci_FormattedTextField;
    private javax.swing.JFormattedTextField prisioneiroDataPrisao_FormattedTextField;
    private javax.swing.JButton prisioneiroLimpar_Button;
    private javax.swing.JTable prisioneiroLista_Table;
    private javax.swing.JTextField prisioneiroNome_TextField;
    private javax.swing.JTextField prisioneiroNumRegistro_TextField;
    private javax.swing.JFormattedTextField prisioneiroPenaFormattedTextField;
    private javax.swing.JButton prisioneiroSalvar_Button;
    private javax.swing.JButton prisioneiroVoltar_Button;
    // End of variables declaration//GEN-END:variables

}
