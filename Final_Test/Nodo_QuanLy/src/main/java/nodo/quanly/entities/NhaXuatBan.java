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
@Table(name="VINHTQ_NHAXUATBAN", indexes={@Index(name="VINHTQ_NHAXUATBAN_MA_IX", columnList="MA", unique=true)})
public class NhaXuatBan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "nhaXuatBanSequen", sequenceName = "NXB_SEQ_VINHTQS")
    @Column(name="ID", unique=true, nullable=false, precision=4)
    private Integer id;

    @Column(name="MA", unique=true, nullable=false, precision=4)
    private Integer ma;

    @Column(name="TEN", length=50)
    private String ten;

    @Column(name="TRANG_THAI", length=20)
    private String trangThai;

    @Column(name="DIA_CHI", length=50)
    private String diaChi;

    @Column(name="MO_TA", length=50)
    private String moTa;

    @JsonIgnore
    @OneToMany(mappedBy="nhaXuatBan")
    private List<Sach> sachList;
}
