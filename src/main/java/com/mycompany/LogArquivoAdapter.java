/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import com.mycompany.adaptador.LogCSVAdapter;
import com.mycompany.adaptador.LogJSONAdapter;
import com.mycompany.model.Log;
import com.mycompany.servive.LogService;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author heflain
 */
public class LogArquivoAdapter {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        LogService.setLogAdapter(new LogCSVAdapter("teste.csv"));
        Log l = new Log("funciona", "teste", "abel", LocalDateTime.now(), "Heflain");
        LogService.escrever(l);
        LogService.setLogAdapter(new LogJSONAdapter("teste.json"));
        LogService.escrever(l);
        LogService.setLogAdapter(new LogCSVAdapter("teste.csv"));
    }
}
