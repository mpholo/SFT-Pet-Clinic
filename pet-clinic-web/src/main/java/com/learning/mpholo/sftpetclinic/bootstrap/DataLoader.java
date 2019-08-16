package com.learning.mpholo.sftpetclinic.bootstrap;

import com.learning.mpholo.sftpetclinic.model.Owner;
import com.learning.mpholo.sftpetclinic.model.Pet;
import com.learning.mpholo.sftpetclinic.model.PetType;
import com.learning.mpholo.sftpetclinic.model.Vet;
import com.learning.mpholo.sftpetclinic.services.OwnerService;
import com.learning.mpholo.sftpetclinic.services.PetTypeService;
import com.learning.mpholo.sftpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");;
        PetType savedPetTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");;
        PetType savedPetTypeCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mpholo");
        owner1.setLastName("Leboea");
        owner1.setAddress("173 Kwartel,Birch Acres");
        owner1.setCity("Kempton Park");
        owner1.setTelephone("0794417879");

        Pet mpholoPet = new Pet();
        mpholoPet.setPetType(savedPetTypeDog);
        mpholoPet.setOwner(owner1);
        mpholoPet.setBirthDate(LocalDate.of(2007,06,34));
        mpholoPet.setName("Leo");
        owner1.getPets().add(mpholoPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Kenalemang");
        owner2.setLastName("Leboea");
        owner2.setAddress("173 Kwartel,Birch Acres");
        owner2.setCity("Kempton Park");
        owner2.setTelephone("0782874654");

        Pet kenalemangPet = new Pet();
        kenalemangPet.setName("Summy");
        kenalemangPet.setBirthDate(LocalDate.of(2008,9,01));
        kenalemangPet.setOwner(owner2);
        kenalemangPet.setPetType(savedPetTypeCat);
        owner2.getPets().add(kenalemangPet);

        ownerService.save(owner2);

        System.out.println("Load Oweners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setLastName("Van Door");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bennie");
        vet2.setLastName("Foo");

        vetService.save(vet2);

        System.out.println("Loaded Vets ......");










    }
}
