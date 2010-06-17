package graphic;

/** 
 * @author Vinícius Souza
 */public class SelecionarGerenciamento extends javax.swing.JFrame {

	    /** Creates new form SelecionarGerenciamento */
	    public SelecionarGerenciamento() {
	        initComponents();
	    }

	    
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">
	    private void initComponents() {

	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setBackground(new java.awt.Color(253, 254, 157));
	        setResizable(false);

	        jPanel1.setBackground(new java.awt.Color(253, 254, 180));

	        jLabel1.setBackground(new java.awt.Color(254, 254, 132));
	        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(30, 30, 104));
	        jLabel1.setIcon(new javax.swing.ImageIcon("/home/marcusvso/workspace/PostOfficeManager/files/pomTransparentIcon.png")); // NOI18N
	        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

	        jButton1.setBackground(new java.awt.Color(235, 254, 54));
	        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
	        jButton1.setForeground(new java.awt.Color(43, 37, 117));
	        jButton1.setIcon(new javax.swing.ImageIcon("/home/marcusvso/workspace/PostOfficeManager/files/peopleIcon.png")); // NOI18N
	        jButton1.setText("usuários");
	        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
	        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setBackground(new java.awt.Color(235, 254, 54));
	        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
	        jButton2.setForeground(new java.awt.Color(43, 37, 117));
	        jButton2.setIcon(new javax.swing.ImageIcon("/home/marcusvso/workspace/PostOfficeManager/files/orderIcon.png")); // NOI18N
	        jButton2.setText("encomendas");
	        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(50, 50, 50)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(108, 108, 108)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jLabel1))
	                .addContainerGap(54, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	                        .addComponent(jLabel1)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
	                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
	    }// </editor-fold>

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        
	    }                                        

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        
	    }                                        

	    

	    // Variables declaration - do not modify
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JPanel jPanel1;
	    // End of variables declaration

	


    
    public static void main(String[] args) {
		new SelecionarGerenciamento().setVisible(true);
	}

}
