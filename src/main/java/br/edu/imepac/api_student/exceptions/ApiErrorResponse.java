package br.edu.imepac.api_student.exceptions;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private int status;
    private String erro;
    private String mensagem;
    private LocalDateTime timestamp;

    public ApiErrorResponse(int status, String erro, String mensagem) {
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
