package com.learning.mpholo.sftpetclinic.services;

import com.learning.mpholo.sftpetclinic.model.Owner;

import java.util.Set;

public class OwnerServiceImpl implements  OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override` `
    public Owner findById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return null;
    }

    @Override
    public Owner findByLasName(String lastName) {
        return null;
    }
}
