package hvitclan.com.restful.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hvitclan.com.restful.annotation.StringToDate;

@Entity
@Table(name= "hocsinh")
public class HocSinh {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "hocSinhId")
	private Long hocSinhId;
	
	@Column
	@Length(max = 100,message = "Ho ten khong qua 100 ki tu")
	private String hoTen;
	
	@Column
	@StringToDate(message = "Ngay sinh khong dung")
	private String ngaySinh;
	
	@Column
	private String diaChi;
	
	@Column 
	@Length(max = 10, message = "So dien thoai khong qua 10")
	private String sdt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lop_id", foreignKey = @ForeignKey(name = "lop_id"))
	@JsonIgnoreProperties(value = "hocSinhs")
	Lop lop;

	public Long getHocSinhId() {
		return hocSinhId;
	}

	public void setHocSinhId(Long hocSinhId) {
		this.hocSinhId = hocSinhId;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}
	
	
}
