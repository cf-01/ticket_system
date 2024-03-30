package com.example.toutiao.controller;

import com.example.toutiao.base.ToutiaoBaseResponse;
import com.example.toutiao.base.ToutiaoResponseUtil;
import com.example.toutiao.service.Impl.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/backup")
    public ToutiaoBaseResponse<String> backupDatabase() {
        return ToutiaoResponseUtil.success(databaseService.backupDatabase());
    }

    @PostMapping("/restore")
    public ToutiaoBaseResponse<String> restoreDatabase() {
        return ToutiaoResponseUtil.success(databaseService.restoreDatabase());
    }
}
