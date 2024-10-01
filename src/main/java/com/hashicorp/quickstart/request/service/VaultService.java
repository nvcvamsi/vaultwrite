package com.hashicorp.quickstart.request.service;

import com.hashicorp.quickstart.request.VaultRequest;
import com.hashicorp.quickstart.request.client.VaultClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaultService {

    @Autowired
    private VaultClient vaultClient;

    public String writeSecret(VaultRequest vaultRequest) {
        return vaultClient.writeSecret(vaultRequest.getKey(), vaultRequest.getPassword());
    }

    public String readSecret(String key) {
        return vaultClient.readSecret(key);
    }
}
