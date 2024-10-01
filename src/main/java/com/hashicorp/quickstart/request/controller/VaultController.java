package com.hashicorp.quickstart.request.controller;

import com.hashicorp.quickstart.request.VaultRequest;
import com.hashicorp.quickstart.request.service.VaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vault")
public class VaultController {

    @Autowired
    private VaultService vaultService;

    @PostMapping("/secrets")
    public String writeSecret(@RequestBody VaultRequest vaultRequest) {
        return vaultService.writeSecret(vaultRequest);
    }

    @GetMapping("/secrets/{key}")
    public String readSecret(@PathVariable String key) {
        return vaultService.readSecret(key);
    }
}
