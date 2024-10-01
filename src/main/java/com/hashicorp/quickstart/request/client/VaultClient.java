package com.hashicorp.quickstart.request.client;

import org.springframework.stereotype.Component;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

import java.util.HashMap;
import java.util.Map;

@Component
public class VaultClient {

    private final VaultTemplate vaultTemplate;

    public VaultClient() {
        VaultEndpoint vaultEndpoint = new VaultEndpoint();
        vaultEndpoint.setHost("127.0.0.1");
        vaultEndpoint.setPort(8200);
        vaultEndpoint.setScheme("http");

        this.vaultTemplate = new VaultTemplate(vaultEndpoint, new TokenAuthentication("dev-only-token"));
    }

    public String writeSecret(String key, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("password", password);

        vaultTemplate.opsForVersionedKeyValue("secret").put(key, data);
        return "Secret written successfully.";
    }

    public String readSecret(String key) {
        Versioned<Map<String, Object>> readResponse = vaultTemplate.opsForVersionedKeyValue("secret").get(key);
        return (readResponse != null && readResponse.hasData()) ? readResponse.getData().get("password").toString() : "Secret not found.";
    }
}
