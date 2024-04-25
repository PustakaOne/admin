package id.ac.ui.cs.pustakaone.admin.model;
import jakarta.persistence.*;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Log")
public class Log {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "action")
    String action;

    @Column(name = "date")
    String date;

    public Log(String action, String date){
        this.id = UUID.randomUUID().toString();
        this.setAction(action);
        this.setDate(date);
    }
}
