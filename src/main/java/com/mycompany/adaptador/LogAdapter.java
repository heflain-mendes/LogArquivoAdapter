/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.adaptador;

import com.mycompany.model.Log;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author heflain
 */
public abstract class LogAdapter {
    protected File file;

    public LogAdapter(String caminhoArquivo) {
        if(caminhoArquivo == null){
            throw new NullPointerException("caminhoArquivo não pode ser null");
        }
        this.file = new File(caminhoArquivo);
    }

    public abstract void escrever(Log... log) throws IOException;
    public abstract List<Log> exportaTodos() throws IOException;
}
