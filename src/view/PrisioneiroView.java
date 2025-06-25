package view;

import controller.CelaController;
import controller.GuardaController;
import controller.PrisioneiroController;
import listener.AtualizavelListener;
import model.Cela;
import model.Prisioneiro;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Guarda;

public class PrisioneiroView extends javax.swing.JInternalFrame implements AtualizavelListener {

    DefaultTableModel modelTable, modelCelaTable;
    private Prisioneiro prisioneiro;
    private Cela cela;
    private DateTimeFormatter formatter;
    private LocalDate dataNasci, dataPrisao;
    private SistemaCarcerarioView main;
    private PrisioneiroController prisioneiroController;
    private CelaController celaController;
    private GuardaController guardaController;

    public PrisioneiroView(SistemaCarcerarioView main) {
        initComponents();
        this.main = main;
        main.addListener(this);
        this.cadastrarPrisioneiroPanel.setVisible(false);
        modelTable = (DefaultTableModel) prisioneiroLista_Table.getModel();
        modelCelaTable = (DefaultTableModel) prisioneiroCela_Table.getModel();
        prisioneiroController = new PrisioneiroController();
        guardaController = new GuardaController();
        celaController = new CelaController();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // padrão de formatação para data
        atualizaTabela();
        botoesConfig();
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        listaPrisioneiroPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prisioneiroLista_Table = new javax.swing.JTable();
        prisioneiroAdicionar_Btn = new javax.swing.JButton();
        prisioneiroEditar_Btn = new javax.swing.JButton();
        prisioneiroRemover_Btn = new javax.swing.JButton();
        prisioneiroBuscar_TextField = new javax.swing.JTextField();
        prisioneiroBuscar_Btn = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        prisioneiroDataPrisao_FormattedTextField = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prisioneiroCela_Table = new javax.swing.JTable();
        prisioneiroNumRegistro_TextField = new javax.swing.JTextField();
        prisioneiroVoltar_Button = new javax.swing.JButton();
        prisioneiroEditarSalvar_Btn = new javax.swing.JButton();
        prisioneiroPena_TextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Prisioneiro");

        listaPrisioneiroPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel10.setText("Lista de Prisioneiros");

        prisioneiroLista_Table.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroLista_Table.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
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
        prisioneiroLista_Table.setGridColor(new java.awt.Color(255, 252, 252));
        prisioneiroLista_Table.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(prisioneiroLista_Table);

        prisioneiroAdicionar_Btn.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroAdicionar_Btn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroAdicionar_Btn.setText("Adicionar");
        prisioneiroAdicionar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroAdicionar_BtnActionPerformed(evt);
            }
        });

        prisioneiroEditar_Btn.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroEditar_Btn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroEditar_Btn.setText("Editar");
        prisioneiroEditar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroEditar_BtnActionPerformed(evt);
            }
        });

        prisioneiroRemover_Btn.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroRemover_Btn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroRemover_Btn.setText("Remover");
        prisioneiroRemover_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroRemover_BtnActionPerformed(evt);
            }
        });

        prisioneiroBuscar_Btn.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroBuscar_Btn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroBuscar_Btn.setForeground(new java.awt.Color(51, 51, 51));
        prisioneiroBuscar_Btn.setText("Buscar");
        prisioneiroBuscar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroBuscar_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listaPrisioneiroPanelLayout = new javax.swing.GroupLayout(listaPrisioneiroPanel);
        listaPrisioneiroPanel.setLayout(listaPrisioneiroPanelLayout);
        listaPrisioneiroPanelLayout.setHorizontalGroup(
            listaPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaPrisioneiroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listaPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listaPrisioneiroPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listaPrisioneiroPanelLayout.createSequentialGroup()
                        .addComponent(prisioneiroBuscar_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prisioneiroBuscar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prisioneiroAdicionar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prisioneiroEditar_Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prisioneiroRemover_Btn)))
                .addContainerGap())
        );
        listaPrisioneiroPanelLayout.setVerticalGroup(
            listaPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaPrisioneiroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listaPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prisioneiroEditar_Btn)
                    .addComponent(prisioneiroRemover_Btn)
                    .addComponent(prisioneiroBuscar_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prisioneiroBuscar_Btn)
                    .addComponent(prisioneiroAdicionar_Btn))
                .addContainerGap())
        );

        cadastrarPrisioneiroPanel.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarPrisioneiroPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Dados Pessoais");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        prisioneiroNome_TextField.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroNome_TextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        prisioneiroDataNasci_FormattedTextField.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroDataNasci_FormattedTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            prisioneiroDataNasci_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        prisioneiroCPF_FormattedTextField.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroCPF_FormattedTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            prisioneiroCPF_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Número de Registro:");

        prisioneiroSalvar_Button.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroSalvar_Button.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroSalvar_Button.setText("Salvar");
        prisioneiroSalvar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroSalvar_ButtonActionPerformed(evt);
            }
        });

        prisioneiroLimpar_Button.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroLimpar_Button.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroLimpar_Button.setText("Limpar");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel7.setText("Informações");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Pena:");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Data da Prisão:");

        prisioneiroDataPrisao_FormattedTextField.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroDataPrisao_FormattedTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            prisioneiroDataPrisao_FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Selecione a Cela:");

        prisioneiroCela_Table.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroCela_Table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prisioneiroCela_Table.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
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
        prisioneiroCela_Table.setGridColor(new java.awt.Color(255, 252, 252));
        prisioneiroCela_Table.setSelectionBackground(new java.awt.Color(0, 153, 153));
        prisioneiroCela_Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(prisioneiroCela_Table);

        prisioneiroNumRegistro_TextField.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroNumRegistro_TextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        prisioneiroVoltar_Button.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroVoltar_Button.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroVoltar_Button.setText("Voltar");
        prisioneiroVoltar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroVoltar_ButtonActionPerformed(evt);
            }
        });

        prisioneiroEditarSalvar_Btn.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroEditarSalvar_Btn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        prisioneiroEditarSalvar_Btn.setText("Salvar");
        prisioneiroEditarSalvar_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisioneiroEditarSalvar_BtnActionPerformed(evt);
            }
        });

        prisioneiroPena_TextField.setBackground(new java.awt.Color(255, 252, 252));
        prisioneiroPena_TextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                                                .addComponent(prisioneiroPena_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prisioneiroDataPrisao_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 17, Short.MAX_VALUE))))
                    .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(cadastrarPrisioneiroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarPrisioneiroPanelLayout.createSequentialGroup()
                                .addComponent(prisioneiroVoltar_Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prisioneiroLimpar_Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prisioneiroEditarSalvar_Btn)
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
                    .addComponent(jLabel6)
                    .addComponent(prisioneiroDataPrisao_FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prisioneiroNumRegistro_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prisioneiroPena_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(prisioneiroVoltar_Button)
                    .addComponent(prisioneiroEditarSalvar_Btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listaPrisioneiroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrarPrisioneiroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(listaPrisioneiroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastrarPrisioneiroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void dadosAtualizados() {
        atualizaTabela();
        botoesConfig();
    }

    private void atualizaTabela() {
        // Limpa a tabela
        modelTable.setRowCount(0);
        modelCelaTable.setRowCount(0);

        ArrayList<Prisioneiro> prisioneiros = prisioneiroController.listarPrisioneiros();
        ArrayList<Cela> celas = celaController.listarCelas();

        //adiciona na tabela de prisioneiro
        for (Prisioneiro prisioneiro : prisioneiros) {
            modelTable.addRow(new Object[]{
                prisioneiro.getNome(),
                prisioneiro.getNumRegistro(),
                prisioneiro.getPena(),
                prisioneiro.getCela()
            });
        }

        //adiciona na tabela de celas 
        for (Cela cela : celas) {
            if (!cela.isLotado()) {
                modelCelaTable.addRow(new Object[]{
                    cela.getNumero(),
                    cela.getCapacidade()
                });
            }
        }

    }

    private boolean validarCelas() {
        ArrayList<Cela> celas = celaController.listarCelas();
        int celasDisponiveis = 0;

        for (Cela c : celas) {
            if (c != null) {
                celasDisponiveis++;
            }
        }

        if (celasDisponiveis == 0 ) {
            String mensagem = "Cadastro de prisioneiro bloqueado: "
                    + "\nNão há celas disponíveis.\n"
                    + "\nCadastre celas antes de cadastrar prisioneiros.";
            JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void botoesConfig() {
        boolean celasValidas = validarCelas();

        // Mostra botões apenas se houver guardas válidos
        prisioneiroAdicionar_Btn.setVisible(celasValidas);
        prisioneiroEditar_Btn.setVisible(celasValidas);
    }
    private void prisioneiroAdicionar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroAdicionar_BtnActionPerformed
        cadastrarConfig();
        this.pack();
    }//GEN-LAST:event_prisioneiroAdicionar_BtnActionPerformed

    private void prisioneiroSalvar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroSalvar_ButtonActionPerformed
        if (validarCampos()) {
            try {
                int linha = prisioneiroCela_Table.getSelectedRow();
                cela = new Cela();
                cela.setNumero(Integer.parseInt(prisioneiroCela_Table.getValueAt(linha, 0).toString()));
                cela.setCapacidade(Integer.parseInt(prisioneiroCela_Table.getValueAt(linha, 1).toString()));

                dataNasci = LocalDate.parse(prisioneiroDataNasci_FormattedTextField.getText(), formatter);
                dataPrisao = LocalDate.parse(prisioneiroDataPrisao_FormattedTextField.getText(), formatter);
                if (checarCPF_NumDuplicado(prisioneiroCPF_FormattedTextField.getText(), prisioneiroNumRegistro_TextField.getText())) {
                    // cria um objeto Prisioneiro passando como parametro os valores informados na tela
                    prisioneiro = new Prisioneiro(Integer.parseInt(prisioneiroNumRegistro_TextField.getText()),
                            dataPrisao, Integer.parseInt(prisioneiroPena_TextField.getText()),
                            cela, prisioneiroNome_TextField.getText(),
                            prisioneiroCPF_FormattedTextField.getText().replaceAll("[-.]", ""), dataNasci);

                    prisioneiroController.cadastrarPrisioneiro(prisioneiro);

                    //notifica todas telas
                    main.notificarAtualizacao();
                    JOptionPane.showMessageDialog(null, "Prisioneiro cadastrado com sucesso!");

                    // método para limpar os campos
                    limpar();

                    // configuração visual
                    listaPrisioneiroPanel.setVisible(true);
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
        cadastrarConfig();
        this.pack();
    }//GEN-LAST:event_prisioneiroVoltar_ButtonActionPerformed

    private void prisioneiroBuscar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroBuscar_BtnActionPerformed
        if (prisioneiroLista_Table.getRowCount() > 0) {
            if (!prisioneiroBuscar_TextField.getText().isBlank()) {
                String prisioneiroEncontrado = prisioneiroController.buscarPrisioneiro(prisioneiroBuscar_TextField.getText());
                for (int i = 0; i < prisioneiroLista_Table.getRowCount(); i++) {
                    String numRegistroTabela = prisioneiroLista_Table.getValueAt(i, 1).toString();
                    if (numRegistroTabela.equals(prisioneiroEncontrado)) {
                        prisioneiroLista_Table.setRowSelectionInterval(i, i);
                        prisioneiroBuscar_TextField.setText("");
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite um número de registro válido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há nenhum prisioneiro cadastrado ainda.");
        }

    }//GEN-LAST:event_prisioneiroBuscar_BtnActionPerformed

    private void prisioneiroEditar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroEditar_BtnActionPerformed
        int linha = prisioneiroLista_Table.getSelectedRow();

        if (linha >= 0) { // uma linha deve estar selecionada para habilitar a tela de editar
            int numRegistro = (Integer) modelTable.getValueAt(linha, 1);
            ArrayList<Prisioneiro> prisioeniros = prisioneiroController.listarPrisioneiros();
            for (Prisioneiro p : prisioeniros) {
                if (p.getNumRegistro() == numRegistro) {
                    dataNasci = p.getDataNascimento();
                    dataPrisao = p.getDataPrisao();
                    String dataNasciFormatado = this.dataNasci.format(formatter);
                    String dataPrisaoFormatado = this.dataPrisao.format(formatter);
                    prisioneiroCPF_FormattedTextField.setText(p.getCpf());
                    prisioneiroDataNasci_FormattedTextField.setText(dataNasciFormatado);
                    prisioneiroNumRegistro_TextField.setText(String.valueOf(p.getNumRegistro()));
                    prisioneiroDataPrisao_FormattedTextField.setText(dataPrisaoFormatado);
                }
            }
            editConfig();
        } else { // senão pede para selecionar um item
            JOptionPane.showMessageDialog(null, "Selecione um item.");
        }
    }//GEN-LAST:event_prisioneiroEditar_BtnActionPerformed

    private void prisioneiroEditarSalvar_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroEditarSalvar_BtnActionPerformed
        cela = new Cela();
        if (validarCampos()) {
            prisioneiro = new Prisioneiro(Integer.parseInt(prisioneiroNumRegistro_TextField.getText()),
                    dataPrisao, Integer.parseInt(prisioneiroPena_TextField.getText()),
                    cela, prisioneiroNome_TextField.getText(),
                    prisioneiroCPF_FormattedTextField.getText().replaceAll("[.-]", ""), dataNasci);

            prisioneiroController.editarPrisioneiro(prisioneiro);
            main.notificarAtualizacao();

            this.pack();
            cadastrarConfig();

        } else {
            JOptionPane.showMessageDialog(null, "Campos devem ser preenchidos.");
        }
    }//GEN-LAST:event_prisioneiroEditarSalvar_BtnActionPerformed

    private void prisioneiroRemover_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisioneiroRemover_BtnActionPerformed
        int linha = prisioneiroLista_Table.getSelectedRow();
        if (linha >= 0) {
            int numRegistro = (Integer) modelTable.getValueAt(linha, 1);
            prisioneiroController.remover(numRegistro);
            main.notificarAtualizacao();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item.");
        }
    }//GEN-LAST:event_prisioneiroRemover_BtnActionPerformed

    private boolean validarCampos() {
        if (prisioneiroCela_Table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma cela na tabela.");
            return false;
        }
        if (prisioneiroPena_TextField.getText().isBlank()
                || Integer.parseInt(prisioneiroPena_TextField.getText()) > 100
                || Integer.parseInt(prisioneiroPena_TextField.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Pena inválida.");
            prisioneiroPena_TextField.setText(null);
            return false;
        }
        return !(prisioneiroNome_TextField.getText().isBlank()
                || prisioneiroDataNasci_FormattedTextField.getText().replaceAll("/", "").isBlank()
                || prisioneiroDataPrisao_FormattedTextField.getText().replaceAll("/", "").isBlank()
                || prisioneiroCPF_FormattedTextField.getText().replaceAll("[.-]", "").isBlank()
                || prisioneiroPena_TextField.getText().isBlank()
                || prisioneiroNumRegistro_TextField.getText().isBlank());
    }

    private void limpar() {
        prisioneiroNome_TextField.setText(null);
        prisioneiroDataNasci_FormattedTextField.setValue(null);
        prisioneiroDataPrisao_FormattedTextField.setValue(null);
        prisioneiroCPF_FormattedTextField.setValue(null);
        prisioneiroPena_TextField.setText(null);
        prisioneiroNumRegistro_TextField.setText(null);
    }

    private void editConfig() {
        cadastrarPrisioneiroPanel.setVisible(true);
        listaPrisioneiroPanel.setVisible(false);

        prisioneiroLimpar_Button.setVisible(false);
        prisioneiroSalvar_Button.setVisible(false);
        prisioneiroEditarSalvar_Btn.setVisible(true);

        prisioneiroDataNasci_FormattedTextField.setEnabled(false);
        prisioneiroCPF_FormattedTextField.setEnabled(false);
        prisioneiroDataPrisao_FormattedTextField.setEnabled(false);
        prisioneiroNumRegistro_TextField.setEnabled(false);
        this.pack();
    }

    private void cadastrarConfig() {
        cadastrarPrisioneiroPanel.setVisible(true);
        listaPrisioneiroPanel.setVisible(false);

        prisioneiroLimpar_Button.setVisible(true);
        prisioneiroSalvar_Button.setVisible(true);
        prisioneiroEditarSalvar_Btn.setVisible(false);

        prisioneiroDataNasci_FormattedTextField.setEnabled(true);
        prisioneiroCPF_FormattedTextField.setEnabled(true);
        prisioneiroDataPrisao_FormattedTextField.setEnabled(true);

        this.pack();
    }

    // método para checar se já existe uma pessoa com este CPF cadastrado no sistema
    private boolean checarCPF_NumDuplicado(String cpf, String num) {
        ArrayList<Prisioneiro> prisioneiros = prisioneiroController.listarPrisioneiros();
        ArrayList<Guarda> guardas = guardaController.listarGuardas();

        for (Prisioneiro p : prisioneiros) {
            if (p.getCpf().equals(cpf.replaceAll("[-.]", ""))) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado no sistema.");
                return false;
            }

            if (String.valueOf(p.getNumRegistro()).equals(num)) {
                JOptionPane.showMessageDialog(null, "Número de Registro já cadastrado no sistema.");
                return false;
            }
        }
        for (Guarda g : guardas) {
            if (g.getCpf().equals(cpf.replaceAll("[-.]", ""))) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado no sistema.");
                return false;
            }
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cadastrarPrisioneiroPanel;
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
    private javax.swing.JPanel listaPrisioneiroPanel;
    private javax.swing.JButton prisioneiroAdicionar_Btn;
    private javax.swing.JButton prisioneiroBuscar_Btn;
    private javax.swing.JTextField prisioneiroBuscar_TextField;
    private javax.swing.JFormattedTextField prisioneiroCPF_FormattedTextField;
    private javax.swing.JTable prisioneiroCela_Table;
    private javax.swing.JFormattedTextField prisioneiroDataNasci_FormattedTextField;
    private javax.swing.JFormattedTextField prisioneiroDataPrisao_FormattedTextField;
    private javax.swing.JButton prisioneiroEditarSalvar_Btn;
    private javax.swing.JButton prisioneiroEditar_Btn;
    private javax.swing.JButton prisioneiroLimpar_Button;
    private javax.swing.JTable prisioneiroLista_Table;
    private javax.swing.JTextField prisioneiroNome_TextField;
    private javax.swing.JTextField prisioneiroNumRegistro_TextField;
    private javax.swing.JTextField prisioneiroPena_TextField;
    private javax.swing.JButton prisioneiroRemover_Btn;
    private javax.swing.JButton prisioneiroSalvar_Button;
    private javax.swing.JButton prisioneiroVoltar_Button;
    // End of variables declaration//GEN-END:variables

}
