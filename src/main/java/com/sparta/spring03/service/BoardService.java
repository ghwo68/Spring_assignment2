package com.sparta.spring03.service;

import com.sparta.spring03.domain.Board;
import com.sparta.spring03.domain.BoardRepository;
import com.sparta.spring03.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor  //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@Service //서비스임을 명시
public class BoardService {

    // 필요한 정보를 찾을 때 Repository가 있어야함 -> Board의 데이터들이 내림차순으로 정렬되어있음
    private final BoardRepository boardRepository;

    //데이터베이스를 다룰 때 Transactional을 적용하면 데이터 추가, 갱신, 삭제 등으로 이루어진 작업을 처리하던 중 오류가 발생했을 때 모든 작업들을 원상태로 되돌릴 수 있다. (조회도 해야하나?)
    //게시글 수정
    @Transactional
    public Board updateBoard(Long id, BoardRequestDto boardRequestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () ->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(boardRequestDto);
        return board;
    //  return boardRepository.findById(id).get();
    }
/*
    //게시글 수정
    @Transactional
    public Long update(Long id, BoardRequestDto boardRequestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () ->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(boardRequestDto);
        return board.getId();
    }
*/
    //게시글 전체 조회
    @Transactional
    public List<Board> getBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }


    // 게시글 단일 조회
    @Transactional
    public Board getBoardById(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () ->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return board;
    //  return boardRepository.findById(id).get();
    }

    //게시글 작성 (서비스를 어떻게 구현해야하는가?)
    @Transactional
    public Board postBoard(BoardRequestDto boardRequestDto){
        Board board = new Board(boardRequestDto);
        return boardRepository.save(board);
    }

    //게시글 삭제
    @Transactional
    public boolean deleteBoard(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () ->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        boardRepository.deleteById(id);
        return true;
    }

    //비밀번호 확인(post형식?)

    @Transactional
    public boolean checkBoard(Long id, BoardRequestDto boardRequestDto ){
        Board board = boardRepository.findById(id).orElseThrow(
                () ->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        String password = board.getPassword();
        return Objects.equals(password, boardRequestDto.getPassword());


    }


}
//equals 형식?
/*
    Long password = board.getPassword();
        if (!password.equals(boardRequestDto.getPassword())){

 */