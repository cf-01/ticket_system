package com.example.toutiao.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DatabaseService {

    @Value("${mysql.path}")
    private String mysqlPath;

    @Value("${mysql.db.name}")
    private String dbName;

    @Value("${mysql.db.user}")
    private String dbUser;

    @Value("${mysql.db.password}")
    private String dbPassword;

    @Value("${backup.path}")
    private String backupPath;

    public String backupDatabase() {
        try {
            ProcessBuilder pbBackup = new ProcessBuilder(
                    mysqlPath + "mysqldump",
                    "--user=" + dbUser,
                    "--password=" + dbPassword,
                    dbName,
                    "--result-file=" + backupPath
            );
            pbBackup.start();
            return "数据备份成功!";
        } catch (IOException e) {
            return "数据备份失败！";
        }
    }

    public String restoreDatabase() {
        try {
            ProcessBuilder pbRestore = new ProcessBuilder(
                    mysqlPath + "mysql",
                    "--user=" + dbUser,
                    "--password=" + dbPassword,
                    dbName,
                    "-e",
                    "source " + backupPath
            );
            pbRestore.start();
            return "数据恢复成功!";
        } catch (IOException e) {
            return "数据恢复失败!";
        }
    }

}
