package com.learning.mpholo.sftpetclinic.springdatajpa;

import com.learning.mpholo.sftpetclinic.model.Owner;
import com.learning.mpholo.sftpetclinic.repositories.OwnerRepository;
import com.learning.mpholo.sftpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OnwerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OnwerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Owner findByLasName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
       Set<Owner> owners = new HashSet<>();
       ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Owner owner = ownerRepository.findById(id).orElse(null);
        return owner;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
          ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
