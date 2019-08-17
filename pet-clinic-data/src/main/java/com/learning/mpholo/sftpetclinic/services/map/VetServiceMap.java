package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Speciality;
import com.learning.mpholo.sftpetclinic.model.Vet;
import com.learning.mpholo.sftpetclinic.services.SpecialityService;
import com.learning.mpholo.sftpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long>  implements VetService {

    private SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size()>0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null) {
                   Speciality savedSpeciality= specialityService.save(speciality);
                   speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }
}
