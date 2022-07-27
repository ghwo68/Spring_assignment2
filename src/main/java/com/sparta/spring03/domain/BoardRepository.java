package com.sparta.spring03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //수정날짜 기준 최신순으로 정렬
    List<Board> findAllByOrderByModifiedAtDesc();

}
