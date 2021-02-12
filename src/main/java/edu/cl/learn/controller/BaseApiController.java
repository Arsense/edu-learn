package edu.cl.learn.controller;

import edu.cl.learn.context.WebContext;
import edu.cl.learn.domain.User;
import edu.cl.learn.util.ModelMapperSingle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: Clay
 * @Date: 2021/2/12 5:07 下午
 */
public class BaseApiController {

    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();

    @Autowired
    protected WebContext webContext;

    protected User getCurrentUser() {
        return webContext.getCurrentUser();
    }



}
