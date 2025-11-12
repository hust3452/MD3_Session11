package ra.demo.Model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true,nullable=false)
    private String userName;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String email;

    private String avatar;
}
