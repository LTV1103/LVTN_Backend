package com.learning.lvtn_backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LvtnBackEndApplication {

    public static void main(String[] args) {
        // Load .env file
        Dotenv dotenv = Dotenv.configure()
                .directory("./") // nơi chứa file .env
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
        // Gán giá trị vào System properties để Spring đọc được
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
        // In thử để check (sau khi chạy có thể xóa)
        System.out.println("🔍 Loaded DB_URL = " + System.getProperty("DB_URL"));

        SpringApplication.run(LvtnBackEndApplication.class, args);
    }
}
