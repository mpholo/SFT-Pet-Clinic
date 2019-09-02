package com.learning.mpholo.sftpetclinic.repositories;

import com.learning.mpholo.sftpetclinic.model.Owner;

public interface OwnerRepository extends AbstractCrudRepository<Owner,Long> {

 Owner findByLastName(String lastName);
}
