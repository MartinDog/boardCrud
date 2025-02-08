package boardcrud.dto;
import io.micrometer.common.util.StringUtils;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BoardDto {
    private long id;
    private String title;
    private String contents;
    private String password;

    public boolean isEmpty(){
        return StringUtils.isEmpty(this.title)
                &&StringUtils.isEmpty(this.contents)
                &&StringUtils.isEmpty(this.password);
    }
}
