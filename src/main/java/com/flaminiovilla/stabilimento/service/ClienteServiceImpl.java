package com.flaminiovilla.stabilimento.service;

import com.flaminiovilla.stabilimento.helper.ClienteHelper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteHelper clienteHelper;


    @Override
    public Boolean search(String search) {
       return null;
    }

}
