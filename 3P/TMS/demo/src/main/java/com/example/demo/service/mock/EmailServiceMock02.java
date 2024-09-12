package com.example.demo.service.mock;

public class EmailServiceMock02 {
    public void sendEmail(String email, String titulo, String corpo) throws Exception {
        throw new Exception("538 - Destinatário inválido!");
    }
}
