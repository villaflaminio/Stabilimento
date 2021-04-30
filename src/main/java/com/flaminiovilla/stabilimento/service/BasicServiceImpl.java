package com.flaminiovilla.stabilimento.service;

import com.flaminiovilla.stabilimento.helper.BasicHelper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    BasicHelper basicHelper;


    @Override
    public Boolean search(String search) {
        Preconditions.checkArgument(!Objects.isNull(search));
        return basicHelper.search(search);
    }

}
