package com.gresidence.residence.Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    private static final String LOG_FILE = "payments.log";

    public synchronized void writeLog(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
