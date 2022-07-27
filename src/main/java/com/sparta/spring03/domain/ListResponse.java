package com.sparta.spring03.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class ListResponse <B> {
    boolean success= true;
    List<B> dataList;
    String error;
}
