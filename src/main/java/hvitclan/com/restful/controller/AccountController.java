package hvitclan.com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hvitclan.com.restful.entites.Account;
import hvitclan.com.restful.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(value  = "/login")
	public ResponseEntity<?> checkLogin(@RequestBody Account account){
		if(accountService.checkLogin(account)) {
			return new ResponseEntity<>("Đăng nhập thành công",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Tài khoản/Mật khẩu không đúng",HttpStatus.OK);
		}
	}
}
