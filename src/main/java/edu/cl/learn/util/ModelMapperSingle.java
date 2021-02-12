package edu.cl.learn.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * @Author: Clay
 * @Date: 2021/2/12 5:23 下午
 */
public class ModelMapperSingle {
    protected final static ModelMapper modelMapper = new ModelMapper();
    private final static ModelMapperSingle modelMapperSingle = new ModelMapperSingle();

    static {
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static ModelMapper Instance() {
        return modelMapperSingle.modelMapper;
    }
}
