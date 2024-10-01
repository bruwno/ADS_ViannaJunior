/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.domain.repo;

import br.com.webtask.aula.domain.model.UserClient;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daves
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserRepoMockTest {
    
    public UserRepoMockTest() {
    }
    
    @MockBean
    private UserRepo userRepo;
    
    private UserClient user1 = new UserClient(null, "Gustin", "321", "gu@gu", "123", false, null);
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
        MockitoAnnotations.initMocks(this);
//        userRepo.save(user1);    
//        userRepo.save(user2);
    }
    
    @AfterEach
    public void tearDown() {
//        userRepo.deleteAll();
    }

    @Test
    public void testSomeMethod() {
        
        //planejar
        UserClient userEsperado = user1;
        
        Mockito.when( userRepo.findByName("Gustin") ).thenReturn( Optional.of(user1) );
        
        //executar        
         UserClient userObtido = userRepo.findByName("Gustin").get();
        
         assertTrue(!userObtido.isAtivo());
         
        //verificar
        //assertEquals(userEsperado, userObtido);
               
    }
    
    
    @Test
    public void testSomeMethodII() {
        
        //planejar
        UserClient userEsperado = user2;
        
        Mockito.when( userRepo.findByName("Pedrin") ).thenReturn( Optional.of(user2) );
        
        //executar        
         UserClient userObtido = userRepo.findByName("Pedrin").get();
        
         assertTrue(userObtido.isAtivo());
         
        //verificar
        //assertEquals(userEsperado, userObtido);
               
    }
    
////    @Test
////    @Transactional
//    public void testaSaveNovoUser(){
//        
//        //planejado
//        UserClient user2 = new UserClient(null, "Gustin123", "333", "gu123@gu", "123", true, null);
//        userRepo.save(user2);
//        
//        //Executar
//        UserClient userObtido = userRepo.findByName("Gustin123").get();
//                
//        //verificar
//        assertEquals(user2, userObtido);
//        
//    }
//    
//    
//
////    @Test
//    public void testBuscarTodos() {
//        
//        //planejar
//        long userEsperado = 2;
//        
//        //executar
//        
//         long userObtido = userRepo.count();
//        
//        //verificar
//        assertEquals(userEsperado, userObtido);
//                       
//    }
//    
}
