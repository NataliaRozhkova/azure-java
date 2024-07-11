package com.example.azurejavaapp;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AzureJavaAppApplication {

    @Autowired
    private  SecretClient client;


    public static void main(String[] args) {
        SpringApplication.run(AzureJavaAppApplication.class, args);
    }

    @GetMapping("/")
    public String sayHello() {

        return String.format("Secret name deep-secret value is  %s!",  client.getSecret("deep-secret").getValue());
    }

}
