/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adaptador;

import com.google.gson.Gson;
import com.mycompany.model.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class LogJSONAdapter extends LogAdapter {

    public LogJSONAdapter(File file) {
        super(file);
    }

    @Override
    public void escrever(Log... log) throws IOException {
        if(log.length > 0) {
            try (FileWriter fw = new FileWriter(file, true)) {
                Gson gson = new Gson();
                for (int i = 0; i < log.length; i++) {
                    String json = gson.toJson(log[i]).replaceAll("\n", " ");
                    fw.write(json);
                }
            } catch (IOException ex) {
                throw new IOException(
                        "Falha ao abrir o arquivo: " + file.getAbsoluteFile()
                );
            }
        }
    }

    @Override
    public List<Log> exportaTodos() throws IOException {
        List<Log> listLog = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Gson gson = new Gson();
            String linha = "";
            while (true) {
                linha = br.readLine();

                if (linha != null) {
                    listLog.add(gson.fromJson(linha, Log.class));
                } else {
                    break;
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new IOException(
                    "Falha ao abrir o arquivo: " + file.getAbsoluteFile()
            );
        } finally {
            Files.delete(file.toPath());
        }

        return listLog;
    }

    @Override
    public String toString() {
        return "JSON";
    }
}
