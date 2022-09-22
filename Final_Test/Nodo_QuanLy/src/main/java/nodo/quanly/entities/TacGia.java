package nodo.quanly.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VINHTQ_TACGIA", indexes={@Index(name="VINHTQ_TACGIA_MA_IX", columnList="MA", unique=true)})
public class TacGia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tacGiaSequen", sequenceName = "TACGIA_SEQ_VINHTQS")
    @Column(name="ID", unique=true, nullable=false, precision=4)
    private Integer id;

    @Column(name="MA", unique=true, nullable=false, precision=4)
    private Integer ma;

    @Column(name="TEN", length=50)
    private String ten;

    @Column(name="SO_DT", length=11)
    private String soDt;

    @Column(name="DIA_CHI", length=50)
    private String diaChi;

    @Column(name="MO_TA", length=50)
    private String moTa;

    @JsonIgnore
    @OneToMany(mappedBy="tacGia")
    private List<Sach> sachList;
}
