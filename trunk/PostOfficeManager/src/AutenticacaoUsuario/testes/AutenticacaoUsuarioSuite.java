/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AutenticacaoUsuario;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 17/06/2010
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ErroAutenticacaoUsuarioTest.class, UsuarioTest.class, AutenticacaoUsuarioTest.class, CriptografiaTest.class, BloqueioSistemaTest.class, AutenticacaoUsuarioIFTest.class})
public class AutenticacaoUsuarioSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
