
package hvitclan.com.restful.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "lop")
public class Lop {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "lopid")
	private Long lopId;
	
	@Column
	private String tenLop;
	
	@Column
	@Max(value=10, message= "Lop khong qua 10 hoc sinh")
	private int siSo;

	@OneToMany(mappedBy = "lop",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "lop")
	Set<HocSinh> hocSinhs;
	
	public Long getLopId() {
		return lopId;
	}

	public Set<HocSinh> getHocSinhs() {
		return hocSinhs;
	}

	public void setHocSinhs(Set<HocSinh> hocSinhs) {
		this.hocSinhs = hocSinhs;
	}

	public void setLopId(Long lopId) {
		this.lopId = lopId;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public int getSiSo() {
		return siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}
	
	
}
