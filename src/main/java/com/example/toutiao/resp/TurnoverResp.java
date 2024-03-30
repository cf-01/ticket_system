package com.example.toutiao.resp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TurnoverResp {
    // 营业额
    private BigDecimal sumTurnover;
}
