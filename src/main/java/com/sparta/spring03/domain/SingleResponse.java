package com.sparta.spring03.domain;

import lombok.Getter;

@Getter
public class SingleResponse<B>  {
    boolean success = true;
    B data;
    String error;
}
