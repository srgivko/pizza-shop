package by.sivko.pizzashop.loginservice.entitites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "permissions")
@Data
@NoArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "permissions_generator")
    @SequenceGenerator(name="permissions_generator", sequenceName = "permissions_id_seq", allocationSize=1)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String name;
}
