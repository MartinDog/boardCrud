package boardcrud.service;

import boardcrud.dao.BoardDao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;

    @Value("${app.salt}")
    private String salt;
    public String getBoardId(){
        Long count = boardDao.countBy();
        return count.toString();
    }
    public String getSale(){
        return salt;
    }

}
