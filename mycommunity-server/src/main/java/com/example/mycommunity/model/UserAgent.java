package com.example.mycommunity.model;

import lombok.Data;

@Data
public class UserAgent {
    private Long userId;
    private String email;
    private String uuid;
    private String serverAddr;
    private Integer serverPort;
}
