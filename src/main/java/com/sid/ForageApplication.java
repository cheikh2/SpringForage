package com.sid;

import com.sid.dao.ClientRepository;
import com.sid.dao.VillageRepository;
import com.sid.entities.Client;
import com.sid.entities.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ForageApplication {

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(ForageApplication.class, args);
        /*ApplicationContext ctx = SpringApplication.run(ForageApplication.class, args);
        ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
        clientRepository.save(new Client("Cheikh", "Mbow", "Pire", "33455"));

        clientRepository.findAll().forEach(v->System.out.println(v.getNom()));*/
    }

}
