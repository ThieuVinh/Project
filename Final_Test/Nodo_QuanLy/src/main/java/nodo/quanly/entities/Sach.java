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
@Table(name="VINHTQ_SACH", indexes={@Index(name="VINHTQ_SACH_MA_IX", columnList="MA", unique=true)})
public class Sach implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sachSequen", sequenceName = "SACH_SEQ_VINHTQS")
    @Column(name="ID", unique=true, nullable=false, precision=4)
    private Integer id;

    @Column(name="MA", unique=true, nullable=false, precision=4)
    private Integer ma;

    @Column(name="TEN", length=50)
    private String ten;

    @Column(name="CHU_DE", length=50)
    private String chuDe;

    @Column(name="NAM_SAN_XUAT")
    private LocalDateTime namSanXuat;

    @Column(name="MO_TA", length=50)
    private String moTa;

    @Column(name="SO_LUONG_CON_LAI")
    private Integer soLuongConLai;

    @Column(name="SO_LUONG_DANG_MUON")
    private Integer soLuongDangMuon;

    @Column(name="TONG_SO_SACH")
    private Integer tongSoSach;


    @ManyToOne
    @JoinColumn(name="ID_NXB")
    private NhaXuatBan nhaXuatBan;

    @ManyToOne
    @JoinColumn(name="ID_TACGIA")
    private TacGia tacGia;

    @JsonIgnore
    @OneToMany(mappedBy="sach")
    private List<MuonSach> muonSachList;
}
