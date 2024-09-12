package com.example.demo.service.mock;

import com.example.demo.service.EmailService;

public class EmailServiceMock01 extends EmailService {
    public void sendEmail(String email, String titulo, String corpo) throws Exception {
        System.out.println("Email enviado com sucesso");
    }
}