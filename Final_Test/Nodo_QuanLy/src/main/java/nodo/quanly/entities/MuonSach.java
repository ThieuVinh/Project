package nodo.quanly.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VINHTQ_MUONSACH")
public class MuonSach implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "muonSachSequen", sequenceName = "MUONSACH_SEQ_VINHTQS")
    @Column(name="ID", unique=true, nullable=false, precision=4)
    private Integer id;

    @Column(name="SO_LUONG")
    private Integer soLuong;

    @Column(name="NGAY_GIO_MUON")
    private LocalDateTime ngayGioMuon;

    @Column(name="NGAY_GIO_TRA")
    private LocalDateTime ngayGioTra;

    @Column(name="TRANG_THAI", length=10)
    private String trangThai;

    @Column(name="GHI_CHU", length=50)
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name="ID_BAN_DOC")
    private BanDoc banDoc;

    @ManyToOne
    @JoinColumn(name="ID_SACH")
    private Sach sach;
}
