package com.learning.mpholo.sftpetclinic.repositories;

import com.learning.mpholo.sftpetclinic.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface AbstractCrudRepository<T extends BaseEntity,ID extends  Long>
        extends CrudRepository<T,ID> {
}
