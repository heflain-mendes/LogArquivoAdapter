/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adaptador;

import com.mycompany.model.Log;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heflain
 */
public class LogCSVAdapter extends LogAdapter {

    public LogCSVAdapter(File file) {
        super(file);
    }

    @Override
    public void escrever(Log... log) throws IOException {
        if (log.length > 0) {
            try (CSVWriter w = new CSVWriter(new FileWriter(file, true))) {
                if (file.length() == 0) {
                    String[] header = {
                        "mensagem",
                        "operacao",
                        "nomecontato",
                        "dataHora",
                        "nomeUsuario"
                    };
                    w.writeNext(header);
                }
                for (int i = 0; i < log.length; i++) {
                    String[] dados = {
                        log[i].getMensagem(),
                        log[i].getOperacao(),
                        log[i].getNomecontato(),
                        log[i].getDataHora(),
                        log[i].getNomeUsuario()
                    };
                    w.writeNext(dados);
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
        try (Reader reader = Files.newBufferedReader(file.toPath())) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String line[];

                //pulando cabeçalho
                csvReader.readNext();

                while ((line = csvReader.readNext()) != null) {
                    listLog.add(
                            new Log(
                                    line[0],
                                    line[1],
                                    line[2],
                                    LocalDateTime.parse(
                                            line[3],
                                            Log.getFormatoDataHora()),
                                    line[4]
                            )
                    );
                }

                
            }
        } catch (IOException ex) {
            throw new IOException(
                    "Falha ao abrir o arquivo: " + file.getAbsoluteFile()
            );
        } finally{
            Files.delete(file.toPath());
        }

        return listLog;
    }

    @Override
    public String toString() {
        return "CSV";
    }   
}
