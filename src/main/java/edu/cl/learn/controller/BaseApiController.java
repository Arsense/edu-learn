package edu.cl.learn.controller;

import edu.cl.learn.util.ModelMapperSingle;
import org.modelmapper.ModelMapper;


/**
 * @Author: Clay
 * @Date: 2021/2/12 5:07 下午
 */
public class BaseApiController {

    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();

}
