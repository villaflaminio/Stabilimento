package com.flaminiovilla.stabilimento.service;

import com.flaminiovilla.stabilimento.helper.StabilimentoHelper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StabilimentoServiceImpl implements StabilimentoService {

    @Autowired
    StabilimentoHelper stabilimentoHelper;


    @Override
    public Boolean search(String search) {
        return null;
    }
}
