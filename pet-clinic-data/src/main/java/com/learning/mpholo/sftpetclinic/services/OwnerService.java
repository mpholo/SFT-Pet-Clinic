package com.learning.mpholo.sftpetclinic.services;

import com.learning.mpholo.sftpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLasName(String lastName);

}
