package com.budzin.service;

import com.budzin.domain.Owner_information;
import com.budzin.domain.Rating;
import com.budzin.repository.Owner_informationRepository;
import com.budzin.repository.RatingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Owner_informationService implements AbstractService<Owner_information, Integer> {

    private final Owner_informationRepository owner_informationRepository;

    public Owner_informationService(Owner_informationRepository owner_informationRepository) {
        this.owner_informationRepository = owner_informationRepository;
    }

    @Override
    public List<Owner_information> getAll() {
        return owner_informationRepository.findAll();
    }

    @Override
    public Owner_information getById(Integer id) {
        return owner_informationRepository.getOne(id);
    }

    @Override
    public Owner_information create(Owner_information owner_information) {
        return owner_informationRepository.save(owner_information);
    }

    @Override
    public Owner_information update(Integer id,Owner_information owner_information) {
        if (owner_informationRepository.findById(id).isPresent()) {
            return owner_informationRepository.save(owner_information);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (owner_informationRepository.findById(id).isPresent()) {
            owner_informationRepository.deleteById(id);
        }
    }
}