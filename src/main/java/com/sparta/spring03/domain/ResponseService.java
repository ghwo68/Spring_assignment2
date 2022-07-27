package com.sparta.spring03.domain;

import org.springframework.stereotype.Service;

import java.util.List;

// 실수로 Service 패키지에 넣어야 했는데 domain 패키지에 넣어버림..
@Service
public class ResponseService {
    //단일 게시글 조회 Response서비스(success와 error)
    public<B> SingleResponse <B> getSingRespnse(B data){
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.data = data;

        return singleResponse;
    }

    //전체 게시글 조회 Response서비스(success와 error)
    public<B> ListResponse <B> getListResponse(List<B> dataList){
        ListResponse listResponse = new ListResponse();
        listResponse.dataList = dataList;

        return listResponse;
    }

}
