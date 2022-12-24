/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.adaptador.LogAdapter;
import com.mycompany.model.Log;
import java.io.IOException;

/**
 *
 * @author heflain
 */
public class LogService {
    private static LogAdapter logAdapter;
    
    public static LogAdapter getLogAdapter(){
        return logAdapter;
    }

    public static void setLogAdapter(LogAdapter logAdapter) throws IOException {
        if (logAdapter != null) {
            if (LogService.logAdapter == null) {
                LogService.logAdapter = logAdapter;
            } else {
                logAdapter.escrever(LogService.logAdapter.exportaTodos().toArray(new Log[0]));
                LogService.logAdapter = logAdapter;
            }
        }
    }
}
