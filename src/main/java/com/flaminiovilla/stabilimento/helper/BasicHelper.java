package com.flaminiovilla.stabilimento.helper;

import com.flaminiovilla.stabilimento.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BasicHelper {

    @Autowired
    private BasicRepository basicRepository;

    public Boolean search(String search) {
        return basicRepository.existsByEmail(search);
    }
}