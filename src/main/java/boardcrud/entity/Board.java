package boardcrud.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "board")
@DynamicUpdate
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Board {
    @Id
    //게시글 아이디
    private String id;
    @Column(name = "title",nullable = false,length = 100)
    private String title;
    @Column(name = "contents",nullable = false,length = 500)
    @NonNull
    private String contents;
    @Column(name = "password",nullable = false,length = 30)
    private String password;

    @Column(name = "images",nullable = true)
    private String imageUrls;


}
