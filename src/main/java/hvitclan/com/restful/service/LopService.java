package hvitclan.com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hvitclan.com.restful.entites.Lop;
import hvitclan.com.restful.repository.LopRepository;

@Service
public class LopService {
	@Autowired
	LopRepository lopRepository;
	
	public List<Lop> getAll() {
		return lopRepository.findAll();
	}

	public void add(Lop lop) {
		lopRepository.save(lop);
	}
	
	public void suaLop(Lop lop) {
		Lop lopHienTai = lopRepository.getOne(lop.getLopId());
		lopHienTai.setTenLop(lop.getTenLop());
		lopHienTai.setSiSo(lop.getSiSo());
		lopRepository.save(lopHienTai);
	}
	
	public Lop findOne(Long id) {
		return lopRepository.getOne(id);
	}
}
