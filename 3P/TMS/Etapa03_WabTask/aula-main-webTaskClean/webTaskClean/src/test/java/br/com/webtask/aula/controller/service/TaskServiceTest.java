/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.controller.service;

import br.com.webtask.aula.domain.model.Task;
import br.com.webtask.aula.domain.model.UserClient;
import br.com.webtask.aula.domain.repo.TaskRepo;
import br.com.webtask.aula.domain.repo.UserRepo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author daves
 */

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class TaskServiceTest {
    
        
    @MockBean
    TaskRepo taskrepo;
        
    @MockBean
    UserRepo userrepo;
            
                       
    @InjectMocks         
    TaskService tasks;
        
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws Exception {
       
        //preparar
        //pegar as tarefas do usuário 1
        ArrayList<Task> lista = new ArrayList<>();
        lista.add( new Task(1l, "abc", LocalDate.now(), LocalDate.now().plusDays(1),
                null)  );
        
        
        Mockito.when( taskrepo.findByUserIdOrderByPlannedDateDesc(1))
                .thenReturn( lista );
        Mockito.when(  userrepo.getOne(1l) )
                .thenReturn( new UserClient(1l, "", "", "", "", true, null) );
        
        //executar
        List<Task> lista1 = tasks.minhaLista(1);
        
        
        //validar
        assertEquals(lista, lista1);        
        
    }
    
    
    @Test
    public void testMetodoParaUsuarioNaoExistente() {
       
        //preparar
        //pegar as tarefas do usuário 1
        ArrayList<Task> lista = new ArrayList<>();
        lista.add( new Task(1l, "abc", LocalDate.now(), LocalDate.now().plusDays(1),
                null)  );
        
        Mockito.when(  userrepo.getOne(-1l) )
                .thenReturn( null );
        
        //executar
        try {          
            List<Task> lista1 = tasks.minhaLista(-1);  
            fail("achou a lisa de um usuário que não existe!!!");
        } catch (Exception e) {
            assertTrue(true);
        }
        
        
    }
    
}
