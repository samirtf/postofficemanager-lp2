package graphic;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import correios.util.Agencia;
import correios.util.Encomenda;

/**
 * @author Vinícius Souza
 */
public class NovaEncomenda extends javax.swing.JFrame {
	
	private String nomeDoUsuario;

    public NovaEncomenda(String nomeDoUsuario) {
        initComponents();
        this.nomeDoUsuario = nomeDoUsuario;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 254, 164));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setForeground(new java.awt.Color(28, 35, 129));
        jLabel1.setText("Nova Encomenda");

        jTextField1.setBackground(new java.awt.Color(228, 233, 65));
        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(29, 20, 142));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("CEP do remetente");
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 25));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo1SumirTexto(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(228, 233, 65));
        jTextField2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(29, 20, 142));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("CEP do destinatário");
        jTextField2.setPreferredSize(new java.awt.Dimension(150, 25));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo2SumirTexto(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(228, 233, 65));
        jTextField3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(29, 20, 142));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Cidade");
        jTextField3.setPreferredSize(new java.awt.Dimension(150, 25));
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo3SumirTexto(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(228, 233, 65));
        jTextField4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(29, 20, 142));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Estado");
        jTextField4.setPreferredSize(new java.awt.Dimension(150, 25));
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo4SumirTexto(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(228, 233, 65));
        jTextField5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(29, 20, 142));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("peso (em gramas)");
        jTextField5.setPreferredSize(new java.awt.Dimension(150, 25));
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo5SumirTexto(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13));
        jLabel2.setForeground(new java.awt.Color(18, 10, 101));
        jLabel2.setText("Os campos numéricos");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 13));
        jLabel3.setForeground(new java.awt.Color(18, 10, 101));
        jLabel3.setText("devem conter apenas ");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 13));
        jLabel4.setForeground(new java.awt.Color(18, 10, 101));
        jLabel4.setText("números.");

        jButton1.setBackground(new java.awt.Color(228, 233, 65));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 14));
        jButton1.setForeground(new java.awt.Color(40, 39, 123));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaEncomenda(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(228, 233, 65));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 14));
        jButton2.setForeground(new java.awt.Color(40, 39, 123));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

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
    }

    private void cancelar(java.awt.event.ActionEvent evt) {                          
        setVisible(false);
        (new MenuEncomenda(nomeDoUsuario)).setVisible(true);
    }                         

    private void novaEncomenda(java.awt.event.ActionEvent evt) {  
        Agencia agencia = new Agencia(nomeDoUsuario);
        Encomenda e = agencia.criaEncomendaSimples(jTextField1.getText(), jTextField2.getText(), 
	             (new SimpleDateFormat("ddMMyyyy").format((new GregorianCalendar()).getTime())), 
	             nomeDoUsuario, jTextField3.getText(), jTextField4.getText(), 
	             Double.parseDouble(jTextField5.getText()));
        agencia.addEncomenda(e);
        System.out.println(e.getId()+ " essa eh a encomenda");
        System.out.println(agencia.getEncomendas());
        setVisible(false);
        (new MenuEncomenda(nomeDoUsuario)).setVisible(true);
    }                              

    private void campo1SumirTexto(java.awt.event.MouseEvent evt) {
        if (jTextField1.getText().equals("CEP do remetente") && jTextField1.isCursorSet()) {
            jTextField1.setText("");
        }
    }

    private void campo2SumirTexto(java.awt.event.MouseEvent evt) {
        if (jTextField2.getText().equals("CEP do destinatário") && jTextField2.isCursorSet()) {
            jTextField2.setText("");
        }
    }

    private void campo3SumirTexto(java.awt.event.MouseEvent evt) {
        if (jTextField3.getText().equals("Cidade") && jTextField3.isCursorSet()) {
            jTextField3.setText("");
        }
    }

    private void campo4SumirTexto(java.awt.event.MouseEvent evt) {
        if (jTextField4.getText().equals("Estado") && jTextField4.isCursorSet()) {
            jTextField4.setText("");
        }
    }

    private void campo5SumirTexto(java.awt.event.MouseEvent evt) {
        if (jTextField5.getText().equals("peso (em gramas)") && jTextField5.isCursorSet()) {
            jTextField5.setText("");
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration

}