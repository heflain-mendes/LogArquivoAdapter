/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author heflain
 */
public class Log {
   private String mensagem;
   private String operacao;
   private String nomeContato;
   private String dataHora;
   private static DateTimeFormatter formatoDataHora;
   private String nomeUsuario;

    public Log(String mensagem, String operacao, String nomecontato, LocalDateTime dataHora, String nomeUsuario) {
        this.mensagem = mensagem;
        this.operacao = operacao;
        this.nomeContato = nomecontato;
        this.dataHora = dataHora.format(formatoDataHora);
        this.nomeUsuario = nomeUsuario;
    }
   
   public static void setFormatoEscritaDataHora( DateTimeFormatter formatoDataHora){
       if(formatoDataHora != null){
           Log.formatoDataHora = formatoDataHora;
       }
   }
   
   public static DateTimeFormatter getFormatoDataHora(){
       if(formatoDataHora != null){
           return formatoDataHora;
       }
       
       return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
   }

    public String getMensagem() {
        return mensagem;
    }

    public String getOperacao() {
        return operacao;
    }

    public String getNomecontato() {
        return nomeContato;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
