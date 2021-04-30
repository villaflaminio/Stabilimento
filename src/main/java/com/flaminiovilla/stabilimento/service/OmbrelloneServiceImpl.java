package com.flaminiovilla.stabilimento.service;

import com.flaminiovilla.stabilimento.helper.OmbrelloneHelper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OmbrelloneServiceImpl implements OmbrelloneService {

    @Autowired
    OmbrelloneHelper ombrelloneHelper;


    @Override
    public Boolean search(String search) {
        return null;
    }

}
