package spo.ifsp.edu.br.projeto_lp2.domain;


import javax.persistence.*;

@Entity
public class Timezone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "timezoneOffset")
    private String offset;
    private String description;

    public Timezone() {
    }
    public Timezone(String offset, String description) {
        this.offset = offset;
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
