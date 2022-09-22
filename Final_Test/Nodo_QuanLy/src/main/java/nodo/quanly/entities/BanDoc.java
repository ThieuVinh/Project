package nodo.quanly.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VINHTQ_BANDOC", indexes = {@Index(name = "VINHTQ_BANDOC_MA_IX", columnList = "MA", unique = true)})
public class BanDoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "banDocSequen", sequenceName = "BANDOC_SEQ_VINHTQS")
    @Column(name = "ID", unique = true, nullable = false, precision = 4)
    private Integer id;

    @Column(name = "MA", unique = true, nullable = false, precision = 4)
    private Integer ma;

    @Column(name = "TEN", length = 50)
    private String ten;

    @Column(name = "SO_DT", length = 11)
    private String soDt;

    @Column(name = "DIA_CHI", length = 50)
    private String diaChi;

    @Column(name = "NGAY_SINH")
    private LocalDateTime ngaySinh;

    @Column(name = "NGAY_TAO_TAI_KHOAN")
    private LocalDateTime ngayTaoTaiKhoan;

    @Column(name = "HANG", length = 10)
    private String hang;

    @JsonIgnore
    @OneToMany(mappedBy = "banDoc")
    private List<MuonSach> muonSachList;
}
