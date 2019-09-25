package com.learning.mpholo.sftpetclinic.springdatajpa;

import com.learning.mpholo.sftpetclinic.model.Owner;
import com.learning.mpholo.sftpetclinic.repositories.OwnerRepository;
import com.learning.mpholo.sftpetclinic.repositories.PetRepository;
import com.learning.mpholo.sftpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLasName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner smith  =service.findByLasName(LAST_NAME);
        assertEquals(LAST_NAME,smith.getLastName());

    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1L).build());
        returnedOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners =service.findAll();
        assertNotNull(owners);
        assertEquals(2,returnedOwnerSet.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner= service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner= service.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner owner= service.save(Owner.builder().id(1L).build());
        assertNotNull(owner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerRepository.delete(returnedOwner);
        verify(ownerRepository).delete(any());

    }

    @Test
    void deleteById() {
        ownerRepository.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}