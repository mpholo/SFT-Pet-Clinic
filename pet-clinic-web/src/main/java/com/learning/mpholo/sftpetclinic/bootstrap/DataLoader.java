package com.learning.mpholo.sftpetclinic.bootstrap;

import com.learning.mpholo.sftpetclinic.model.Owner;
import com.learning.mpholo.sftpetclinic.model.Vet;
import com.learning.mpholo.sftpetclinic.services.OwnerService;
import com.learning.mpholo.sftpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mpholo");
        owner1.setLastName("Leboea");
        ownerService.save(owner1.getId(),owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Kenalemang");
        owner1.setLastName("Leboea");
        ownerService.save(owner1.getId(),owner1);

        ownerService.save(owner2.getId(),owner2);

        System.out.println("Loaed Onwer......");

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setId(1L);
        vet1.setLastName("Van Door");

        vetService.save(vet1.getId(),vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bennie");
        vet2.setId(2L);
        vet2.setLastName("Foo");

        vetService.save(vet2.getId(),vet2);

        System.out.println("Loaed ......");










    }
}
