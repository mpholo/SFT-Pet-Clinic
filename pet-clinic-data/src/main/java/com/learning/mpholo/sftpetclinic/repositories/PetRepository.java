package com.learning.mpholo.sftpetclinic.repositories;

import com.learning.mpholo.sftpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
