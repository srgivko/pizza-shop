package by.sivko.pizzashop.mailservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "emails")
@NoArgsConstructor
@Data
public class EMail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mail_generator")
    @SequenceGenerator(name = "mail_generator", sequenceName = "mails_id_seq", allocationSize = 1)
    private Long id;

    @Email
    @NotBlank
    private String sendTo;

    @NotBlank
    private String subject;

    @Column(columnDefinition="TEXT")
    private String text;

    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt;
}
