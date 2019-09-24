package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName="Leboea";

    @BeforeEach
    void setUp() {
      ownerMapService = new OwnerMapService(new PetMapService(),new PetTypeMapService());
      ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());

    }

    @Test
    void findAll() {
        Set<Owner>  owner= ownerMapService.findAll();
        assertEquals(1,owner.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void savedNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveExistingId() {
        Long id=2L;
        Owner  owner2 = Owner.builder().id(id).build();
        Owner ownerSaved = ownerMapService.save(owner2);
        assertEquals(id,ownerSaved.getId());
    }

    @Test
    void delete() {
       Owner deleteOwner =ownerMapService.findById(ownerId);
       ownerMapService.delete(deleteOwner);
       //ownerMapService.findAll().forEach(owner-> System.out.println(owner.getId()));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void findByLasName() {
        Owner owner= ownerMapService.findByLasName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLasNameNotFound() {
        Owner owner= ownerMapService.findByLasName("foo");
        assertNull(owner);

    }
}