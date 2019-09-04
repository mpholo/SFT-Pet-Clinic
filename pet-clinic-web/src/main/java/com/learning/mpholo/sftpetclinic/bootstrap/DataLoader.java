package com.learning.mpholo.sftpetclinic.bootstrap;

import com.learning.mpholo.sftpetclinic.model.*;
import com.learning.mpholo.sftpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final PetService petService;
    private  final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count==0) {
            loadData();
        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");


        PetType cat = new PetType();
        cat.setName("Cat");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Owner owner1 = new Owner();
        owner1.setFirstName("Mpholo");
        owner1.setLastName("Leboea");
        owner1.setAddress("173 Kwartel,Birch Acres");
        owner1.setCity("Kempton Park");
        owner1.setTelephone("0794417879");

        Pet mpholoPet = new Pet();
        mpholoPet.setPetType(dog);
        mpholoPet.setOwner(owner1);
        mpholoPet.setBirthDate(LocalDate.of(2007,06,12));
        mpholoPet.setName("Leo");
        owner1.getPets().add(mpholoPet);

        ownerService.save(owner1);

        Visit dogVisit = new Visit();
        dogVisit.setPets(mpholoPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Annual check up");
        visitService.save(dogVisit);


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
        kenalemangPet.setPetType(cat);
        owner2.getPets().add(kenalemangPet);

        ownerService.save(owner2);

        System.out.println("Load Oweners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setLastName("Van Door");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bennie");
        vet2.setLastName("Foo");
        vet2.getSpecialities().add(surgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets ......");
    }
}
