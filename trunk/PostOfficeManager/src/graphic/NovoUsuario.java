package graphic;

import correios.util.*;

public class NovoUsuario extends javax.swing.JFrame {
	
	private String nomeUsuario;

    /** Creates new form NovoUsuario */
    public NovoUsuario(String nomeUsuario) {
        initComponents();
        jLabel8.setVisible(false);
        this.nomeUsuario = nomeUsuario;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 251, 193));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel1.setForeground(new java.awt.Color(63, 60, 142));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Novo Atendente");

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12));
        jTextField1.setForeground(new java.awt.Color(63, 60, 142));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("login");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginTexto(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(63, 60, 142));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Nome completo");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checarNome(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(63, 60, 142));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("ddMMaaaa");
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTexto(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checarData(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(63, 60, 142));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("XXXXXXXXXXX");
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpfTexto(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checarCPF(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(63, 60, 142));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("X.XX");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salarioTexto(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                checarSalario(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Verdana", 0, 12));
        jPasswordField1.setForeground(new java.awt.Color(63, 60, 142));
        jPasswordField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField1.setText("senha");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                senhaTexto(evt);
            }
        });

        jPasswordField2.setFont(new java.awt.Font("Verdana", 0, 12));
        jPasswordField2.setForeground(new java.awt.Color(63, 60, 142));
        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField2.setText("senha");
        jPasswordField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmaSenhaTexto(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setForeground(new java.awt.Color(63, 60, 142));
        jLabel2.setText("data de nascimento, só numeros");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel3.setForeground(new java.awt.Color(63, 60, 142));
        jLabel3.setText("CPF, só números");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel4.setForeground(new java.awt.Color(63, 60, 142));
        jLabel4.setText("salário, só números separados por vírgula");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel5.setForeground(new java.awt.Color(63, 60, 142));
        jLabel5.setText("Por favo digite uma senha");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(63, 60, 142));
        jLabel6.setText("Por favor confirme a senha");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel7.setForeground(new java.awt.Color(63, 60, 142));
        jLabel7.setText("Nome de usuário");

        jButton1.setBackground(new java.awt.Color(254, 238, 83));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(63, 60, 142));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(254, 238, 83));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(63, 60, 142));
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoUsuario(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 35, 35));
        jLabel8.setText("Verifique os valores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordField2)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void dataTexto(java.awt.event.MouseEvent evt) {
        if (jTextField3.getText().equals("ddMMaaaa")  && jTextField3.isCursorSet()) {
        	jTextField3.setText("");
        }
    }

    private void checarData(java.awt.event.KeyEvent evt) {
        String check = "";
        for (String s: jTextField3.getText().split("")) {
        	if (s.matches("[0-9]") && check.length()<9) {
        		check+=s;
        	}
        }
        jTextField3.setText(check);
    }

    private void checarCPF(java.awt.event.KeyEvent evt) {
    	String check = "";
        for (String s: jTextField4.getText().split("")) {
        	if (s.matches("[0-9]") && check.length()<11) {
        		check+=s;
        	}
        }
        jTextField4.setText(check);
    }

    private void cpfTexto(java.awt.event.MouseEvent evt) {
        if (jTextField4.getText().equals("XXXXXXXXXXX")  && jTextField4.isCursorSet()) {
        	jTextField4.setText("");
        }
    }

    private void checarSalario(java.awt.event.KeyEvent evt) {
    	String check = "";
        for (String s: jTextField5.getText().split("")) {
        	if (s.matches("[0-9]") || s.equals(".")) {
        		check+=s;
        	}
        }
        jTextField5.setText(check);
    }

    private void salarioTexto(java.awt.event.MouseEvent evt) {
        if (jTextField5.getText().equals("X.XX")  && jTextField5.isCursorSet()) {
        	jTextField5.setText("");
        }
    }

    private void loginTexto(java.awt.event.MouseEvent evt) {
    	if (jTextField1.getText().equals("login")  && jTextField1.isCursorSet()) {
        	jTextField1.setText("");
        }
    }

    private void senhaTexto(java.awt.event.MouseEvent evt) {
    	if (jPasswordField1.getText().equals("senha")  && jPasswordField1.isCursorSet()) {
        	jPasswordField1.setText("");
        }
    }

    private void confirmaSenhaTexto(java.awt.event.MouseEvent evt) {
    	if (jPasswordField2.getText().equals("senha")  && jPasswordField2.isCursorSet()) {
        	jPasswordField2.setText("");
        }
    }

    private void cancelar(java.awt.event.ActionEvent evt) {
    	setVisible(false);
    	(new MenuUsuario(nomeUsuario)).setVisible(true);
    }

    private void novoUsuario(java.awt.event.ActionEvent evt) {
    	if (!(VerificaDados.verificaData(jTextField3.getText()) &&
    		  VerificaDados.validaCPF(jTextField4.getText()) &&
    		  VerificaDados.verificaNome(jTextField2.getText()) //&&
    		  )) {
    		jLabel8.setVisible(true);
    		return;
    		
    	}
    }

    private void checarNome(java.awt.event.KeyEvent evt) {
        String check = "";
        for (String s: jTextField2.getText().split("")) {
        	if (s.toLowerCase().matches("[a-z]") || s.equals(" ")) {
        		check+=s;
        	}
        }
        jTextField2.setText(check);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoUsuario("a").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration

}
