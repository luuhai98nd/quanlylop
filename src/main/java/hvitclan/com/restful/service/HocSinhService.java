package hvitclan.com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hvitclan.com.restful.entites.HocSinh;
import hvitclan.com.restful.repository.HocSinhRepository;

@Service
public class HocSinhService {

	@Autowired
	HocSinhRepository hocSinhRepository;
	
	public List<HocSinh> getAll() {
		return hocSinhRepository.findAll();
	}

	
	public void themHocSinh(HocSinh hocSinh) {
		hocSinhRepository.save(hocSinh);
	}

	public void suaHocSinh(HocSinh hocSinh, Long id) {
		HocSinh hocSinhHienTai = hocSinhRepository.getOne(id);
		hocSinhHienTai.setHoTen(hocSinh.getHoTen());
		hocSinhHienTai.setNgaySinh(hocSinh.getNgaySinh());
		hocSinhHienTai.setDiaChi(hocSinh.getDiaChi());
		hocSinhHienTai.setLop(hocSinh.getLop());
		hocSinhRepository.save(hocSinhHienTai);
	}

	public void xoaHocSinh(Long id) {
		hocSinhRepository.deleteById(id);;
	}

	public HocSinh findOne(Long id) {
		return hocSinhRepository.getOne(id);
	}
	
}
