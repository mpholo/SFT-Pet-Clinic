package com.learning.mpholo.sftpetclinic.services;

import com.learning.mpholo.sftpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLasName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
