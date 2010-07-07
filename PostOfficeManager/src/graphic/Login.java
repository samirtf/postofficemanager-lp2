package graphic;

import java.io.*;
import servicosAutenticacaoGerencUsuario.AutenticacaoUsuario;

/**
 * @author Vinícius Souza
 */
public class Login extends javax.swing.JFrame {
	
	
	private AutenticacaoUsuario autenticacao;
    public Login() throws IOException {
    	autenticacao = new AutenticacaoUsuario();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(251, 252, 184));

        jPasswordField2.setBackground(new java.awt.Color(241, 231, 96));
        jPasswordField2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(42, 43, 127));
        jPasswordField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField2.setText("senha");
        jPasswordField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                senhaTexto(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(241, 231, 96));
        jTextField2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(42, 43, 127));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Login");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginTexto(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel2.setForeground(new java.awt.Color(20, 25, 144));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login");

        jButton3.setBackground(new java.awt.Color(241, 231, 96));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton3.setForeground(new java.awt.Color(42, 43, 127));
        jButton3.setText("Cancelar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(241, 231, 96));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton4.setForeground(new java.awt.Color(42, 43, 127));
        jButton4.setText("OK");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirmar(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario/senha errado");
        jLabel1.setVisible(false);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desligarLabel(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(62, 62, 62)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
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

    private void Confirmar(java.awt.event.ActionEvent evt) {                           
    	try {
			if (autenticacao.logaNoSistema(jTextField2.getText(), jPasswordField2.getText())) {
			    setVisible(false);
			    SelecionarGerenciamento selectGerenciamento = new SelecionarGerenciamento(jTextField2.getText());
			    selectGerenciamento.setVisible(true);
			    
			} else {
				jLabel1.setVisible(true);
			}
		} catch (Exception e) {
		}
    }                          

    private void Cancelar(java.awt.event.ActionEvent evt) {                          
        System.exit(0);
    }                         

    private void loginTexto(java.awt.event.MouseEvent evt) {
        if(jTextField2.isCursorSet() && jTextField2.getText().equals("Login")){
            jTextField2.setText("");
        }
        if(jTextField2.isCursorSet() && (jPasswordField2.getText().isEmpty())){
            jPasswordField2.setText("senha");
        }
        desligarLabel(evt);
    }

    private void senhaTexto(java.awt.event.MouseEvent evt) {
        if(jPasswordField2.isCursorSet() && (jTextField2 == null || jTextField2.getText().isEmpty()) ){
            jTextField2.setText("Login");
        }
        if(jPasswordField2.isCursorSet() && jPasswordField2.getText().equals("senha")){
            jPasswordField2.setText("");
        }
        desligarLabel(evt);
    }

    private void desligarLabel(java.awt.event.MouseEvent evt) {
        jLabel1.setVisible(false);
    }

    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
}