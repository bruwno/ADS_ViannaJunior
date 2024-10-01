/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.webtask.aula.controller;

import br.com.webtask.aula.config.security.user.UserLogado;
import br.com.webtask.aula.domain.model.UserClient;
import br.com.webtask.aula.domain.repo.TaskRepo;
import br.com.webtask.aula.domain.repo.UserRepo;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author daves
 */
//@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest //(webEnvironment = WebEnvironment.RANDOM_PORT)
//@WebMvcTest(controllers = TaskController.class)
@AutoConfigureMockMvc
public class TaskControllerTest {
    
    @Autowired
    private MockMvc request;
    
//    @MockBean
//    private TaskService service;
//    
//    @MockBean
//    UserRepo userRepo;
//    
//    @MockBean
//    TaskRepo taskRepo;
//    
    
    @Autowired
    private UserRepo userRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    private PasswordEncoder password;
    
    @BeforeEach
    public void setUp() {
        UserClient uc1 = UserClient.builder().id(1l)
                        .ativo(true).cpf("123").email("admin@admin")
                        .name("admin").senha(password.encode("123")).build();
        uc1 = userRepo.save(uc1);
        System.out.println("Criou o usuário :: "+uc1.getId() );
    }
    
    @AfterEach
    public void tearDown() {
        taskRepo.deleteAll();
        userRepo.deleteAll();
    }

    @Test
    public void TestPaginaCreateTask() throws Exception {
        //cenário
        
        //execução
        ResultActions r = request.perform( MockMvcRequestBuilders.get("/task") );
        
        
        //verificar
        r.andExpect(MockMvcResultMatchers.status().is(302))
         .andDo(MockMvcResultHandlers.print());        
    }
    
    @Test  
    @WithMockUser
    public void TestAcessarPaginaNaoExiste() throws Exception {
        //cenário
        
        //execução
        ResultActions r = request.perform( MockMvcRequestBuilders.get("/abc"));        
        
        //verificar
        r.andExpect(MockMvcResultMatchers.status().isNotFound())
         .andDo(MockMvcResultHandlers.print());
        
    }
   
    @Test
    //@WithMockUser
    public void TestAcessarMinhasTarefas() throws Exception {
        //cenário
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLIENTE"));
        UserLogado ul = new UserLogado("123", "123", grantedAuthorities, 1, "zezin","ze@ze");
        
        //execução
        ResultActions r = request.perform( MockMvcRequestBuilders.get("/task/list")
            .with(SecurityMockMvcRequestPostProcessors.user(ul))
        );
        
        
        //verificar
        r.andExpect(MockMvcResultMatchers.status().isOk())
         .andDo(MockMvcResultHandlers.print());
        
    }
    
    @Test
    //@WithMockUser
    public void TestarSaveTask() throws Exception {
        //cenário
        UserClient uc1 = userRepo.findByCpf("123").get();
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_CLIENTE"));
        UserLogado ul = new UserLogado("123", "123", grantedAuthorities, uc1.getId(), "zezin","ze@ze");
        
        //execução
        ResultActions r = request.perform( MockMvcRequestBuilders.post("/task")
                .with(SecurityMockMvcRequestPostProcessors.user(ul))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .param("taskDescription", "abc")
                .param("plannedDate", "2021-09-28") );
        
        
        //verificar
        r.andExpect(MockMvcResultMatchers.status().isFound())
         .andExpect(MockMvcResultMatchers.redirectedUrl("/home"))
         .andDo(MockMvcResultHandlers.print());
        
    }
    
    
    @Test
    public void TestarLogin() throws Exception {
        //cenário
        
        //execução
        ResultActions r = request.perform( MockMvcRequestBuilders.post("/login")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .param("username", "123")
                .param("password", "123") );
        
        
        //verificar
        r.andExpect(MockMvcResultMatchers.status().isFound());
         //.andExpect(MockMvcResultMatchers.view().name("/home"))
         //.andDo(MockMvcResultHandlers.print());
        
    }
    
}
