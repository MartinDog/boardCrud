package boardcrud.controller;

import boardcrud.dao.BoardDao;
import boardcrud.dto.BoardDto;
import boardcrud.entity.Board;
import boardcrud.service.BoardService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardDao boardDao;

    private final BoardService boardService;
    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable(name = "id",required = true) long id){
        Optional<Board> result = boardDao.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        else{
            return ResponseEntity.notFound()
                    .build();
        }
    }
    @PostMapping("/insert")
    public ResponseEntity<String> saveBoard(@RequestBody BoardDto board){

        if(board!=null && !board.isEmpty()){
            String id = boardService.getBoardId();
            Board boardSave = Board.builder()
                    .title(board.getTitle())
                    .id(id)
                    .contents(board.getContents())
                    .password(board.getPassword())
                    .build();
            boardDao.save(boardSave);
            return ResponseEntity.ok(id);
        }

        return ResponseEntity.status(500).build();
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateBoard(@RequestParam(value = "id",required = true)String id,@RequestBody BoardDto board ){
        Optional<Board> boardSave = boardDao.findById(Long.getLong(id));
        if(boardSave.isPresent()){
            Board boardCon = boardSave.get();
            if(boardCon.getPassword().equals(board.getPassword())){
                boardDao.save(boardCon.toBuilder()
                                .title(board.getTitle())
                                .contents(board.getContents())
                                .build());
            }
        }
        return ResponseEntity.status(500).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id")String id){
        if(StringUtils.isNotEmpty(id)) {
            boardDao.deleteById(Long.parseLong(id));
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Board>> getList(){
        List<Board> boardList = boardDao.findAll();
        return ResponseEntity.ok(boardList);
    }
}
