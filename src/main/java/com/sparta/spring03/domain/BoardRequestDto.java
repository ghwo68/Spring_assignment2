package com.sparta.spring03.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

    /*
    // 매번 생성자를 만들지 않고 바로 사용할수 있도록 Builder를 구현
    @Builder
    public BoardRequestDto(String title, String content, String author, Long password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    // toEntity를 구현하여 Dto에서 Entity로의 변환이 자유롭도록 설정
    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .password(password)
                .build();
    }

     */

}
