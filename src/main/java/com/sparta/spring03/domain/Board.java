package com.sparta.spring03.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Setter를 설정하지 않는 이유는 repository에서 자동으로 설정을 다 해주기 때문에
@NoArgsConstructor //기본생성자 생성
@Getter
@Entity //테이블과 연계, 실제 DB에 매칭되는 클래스를 의미
public class Board extends Timestamped {
    //@Id는 해당 프로퍼티가 테이블의 주키(primary key) 역할을 한다는 것, @GeneratedValue는 주키의 값을 위한 자동 생성 전략을 명시하는데 사용(Auto는 자동 증가 명령)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //컬럼 값이고 반드시 값이 존재해야 함을 나타냄
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    //@JsonIgnore를 붙이면 데이터를 주고받을 때 해당 데이터는 Ignore되어 응답값에 보이지 않게됨
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    //멤버가 4개 들어가는 생성자 주입, 생성자 주입은 생성자의 호출 시점에 1회 호출 되는 것이 보장된다. 그렇기 때문에 주입받은 객체가 변하지 않거나, 반드시 객체의 주입이 필요한 경우에 강제하기 위해 사용할 수 있다.
    public Board(String title, String content, String author, String password){
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Board(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.author = boardRequestDto.getAuthor();
        this.password = boardRequestDto.getPassword();
    }

    public void update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.author = boardRequestDto.getAuthor();
        this.password = boardRequestDto.getPassword();
    }

}
