/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.domain.repo;

import br.com.webtask.aula.domain.model.UserClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daves
 */

@DataJpaTest
@ActiveProfiles("test")
public class UserRepoTest {
    
    public UserRepoTest() {
    }
    
    @Autowired
    private UserRepo userRepo;
    
    private UserClient user1 = new UserClient(null, "Gustin", "321", "gu@gu", "123", true, null);
    private UserClient user2 = new UserClient(null, "Pedrin", "555", "ped@ped", "123", true, null);
    
    @BeforeAll
    public static void setUpClass() {       
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    @Transactional
    public void setUp() {        
        userRepo.save(user1);    
        userRepo.save(user2);
    }
    
    @AfterEach
    public void tearDown() {
        userRepo.deleteAll();
    }

    @Test
    public void testSomeMethod() {
        
        //planejar
        UserClient userEsperado = user1;
        
        //executar
        
         UserClient userObtido = userRepo.findByName("Gustin").get();
        
        //verificar
        assertEquals(userEsperado, userObtido);
               
    }
    
    @Test
    @Transactional
    public void testaSaveNovoUser(){
        
        //planejado
        UserClient user2 = new UserClient(null, "Gustin123", "333", "gu123@gu", "123", true, null);
        userRepo.save(user2);
        
        //Executar
        UserClient userObtido = userRepo.findByName("Gustin123").get();
                
        //verificar
        assertEquals(user2, userObtido);        
    }
    
    

    @Test
    public void testBuscarTodos() {
        
        //planejar
        long userEsperado = 2;
        
        //executar
        
         long userObtido = userRepo.count();
        
        //verificar
        assertEquals(userEsperado, userObtido);
                       
    }
    
}
