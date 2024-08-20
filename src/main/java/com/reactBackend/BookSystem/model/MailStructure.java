package com.reactBackend.BookSystem.model;

import lombok.Data;

@Data
public class MailStructure {

    private String email;
    private String subject;
    private String message;
}
