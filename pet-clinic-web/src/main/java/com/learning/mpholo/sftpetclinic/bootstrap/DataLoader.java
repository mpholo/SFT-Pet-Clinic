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
        owner1.setFirstName("Mpholo");
        owner1.setLastName("Leboea");
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Kenalemang");
        owner2.setLastName("Leboea");

        ownerService.save(owner2);

        System.out.println("Loaed Owenr......");

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setLastName("Van Door");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bennie");
        vet2.setLastName("Foo");

        vetService.save(vet2);

        System.out.println("Loaed ......");










    }
}
