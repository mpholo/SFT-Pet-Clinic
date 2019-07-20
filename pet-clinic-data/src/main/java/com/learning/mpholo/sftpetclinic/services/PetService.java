package com.learning.mpholo.sftpetclinic.services;

import com.learning.mpholo.sftpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
