package com.sparta.spring03.controller;

import com.sparta.spring03.domain.*;
import com.sparta.spring03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor  //final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@RestController  //view + data를 반환해야 하는 경우 RestController, view만 반환해야 하는 경우 Controller만
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final ResponseService responseService;

    //게시글 작성
    @PostMapping("/api/post")
    public SingleResponse<Board> postBoard(@RequestBody BoardRequestDto boardRequestDto){
        return responseService.getSingRespnse(boardService.postBoard(boardRequestDto));
    }
/*
    //게시글 작성
    @PostMapping("/api/post")
    public SingleResponse<Board> createBoard(@RequestBody BoardRequestDto boardRequestDto){
        Board board = new Board(boardRequestDto);
        return responseService.getSingRespnse(boardRepository.save(board));
    }
*/
    //게시글 전체목록 조회
    @GetMapping("/api/post")
    public ListResponse getBoard() {
        return responseService.getListResponse(boardService.getBoard());
    }

    //게시글 단일 조회
    @GetMapping("/api/post/{id}")
    public SingleResponse getBoardByID(@PathVariable Long id){
        return responseService.getSingRespnse(boardService.getBoardById(id));
    }

    //게시글 비밀번호 확인
    @PostMapping("/api/post/{id}")
    public SingleResponse checkBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto ){
        return responseService.getSingRespnse(boardService.checkBoard(id, boardRequestDto));
    }

    //게시글 수정
    @PutMapping("/api/post/{id}")
    public SingleResponse updateBoard (@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        return responseService.getSingRespnse(boardService.updateBoard(id, boardRequestDto));
    }

/*
    //게시글 수정
    @PutMapping("/api/post/{id}")
    public Long updateBoard (@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto){
        boardService.update(id, boardRequestDto);
        return id;
    }
*/

    //게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public SingleResponse deleteBoard(@PathVariable Long id) {
        return responseService.getSingRespnse(boardService.deleteBoard(id));
    }
}
