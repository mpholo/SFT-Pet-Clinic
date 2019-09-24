package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Owner;
import com.learning.mpholo.sftpetclinic.model.Pet;
import com.learning.mpholo.sftpetclinic.services.OwnerService;
import com.learning.mpholo.sftpetclinic.services.PetService;
import com.learning.mpholo.sftpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private PetService petService;
    private PetTypeService petTypeService;


    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner object) {
        if(object!=null) {
            if(object.getPets()!=null) {
               object.getPets().forEach(pet->{

                   if(pet.getPetType().getId()==null) {
                       pet.setPetType(petTypeService.save(pet.getPetType()));
                   } else {
                       throw new RuntimeException("Pet type is required.");
                   }
                   if(pet.getId()==null) {
                       Pet savedPet = petService.save(pet);
                       pet.setId(savedPet.getId());
                   }
               });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Owner findByLasName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner->owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
