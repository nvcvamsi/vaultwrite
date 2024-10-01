package com.hashicorp.quickstart.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

import java.util.Map;

@Component
public class VaultRequest {

    private final VaultTemplate vaultTemplate;

    @Autowired
    public VaultRequest(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    // Method to write a secret
    public void writeSecret(String path, Map<String, String> data) {
        vaultTemplate.opsForVersionedKeyValue("secret").put(path, data);
    }

    // Method to read a secret
    public Map<String, Object> readSecret(String path) {
        Versioned<Map<String, Object>> response = vaultTemplate.opsForVersionedKeyValue("secret").get(path);
        return response.hasData() ? response.getData() : null;
    }
}
