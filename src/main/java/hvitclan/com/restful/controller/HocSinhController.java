package hvitclan.com.restful.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hvitclan.com.restful.entites.HocSinh;
import hvitclan.com.restful.entites.Lop;
import hvitclan.com.restful.service.HocSinhService;
import hvitclan.com.restful.service.LopService;
@RestController
@RequestMapping(value = "/hocsinh")
public class HocSinhController {

		@Autowired
		HocSinhService hocSinhService;
		
		@Autowired
		LopService lopService;
		
		@GetMapping(value = "/get")
		public List<HocSinh> home(){
			return hocSinhService.getAll();
		}
		
		@GetMapping(value = "/{id}")
		public HocSinh hocSinhById(@PathVariable("id") Long id) {
			return hocSinhService.findOne(id);
		}
		
		@PostMapping(value = "/create")
		public void add(@Valid @RequestBody HocSinh hocSinh) {
			hocSinhService.themHocSinh(hocSinh);
			Lop lop = lopService.findOne(hocSinh.getLop().getLopId());
			lop.setSiSo(lop.getHocSinhs().size());
			lopService.suaLop(lop);
		}
		
		@PutMapping(value = "/update/{id}")
		public void update(@Valid @RequestBody HocSinh  newhocSinh, @PathVariable Long id) {
			hocSinhService.suaHocSinh(newhocSinh, id);
		}
		
		@DeleteMapping(value = "/delete/{id}")
		public void delete(@PathVariable("id") Long id) {
			HocSinh hocSinh = hocSinhService.findOne(id);
			hocSinhService.xoaHocSinh(id);
			Lop lop = lopService.findOne(hocSinh.getLop().getLopId());
			lop.setSiSo(lop.getHocSinhs().size());
			lopService.suaLop(lop);
		}
}
