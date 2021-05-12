package com.zup.orange.vaccines.uservaccination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.orange.vaccines.user.UserDto;
import com.zup.orange.vaccines.user.UserService;
import com.zup.orange.vaccines.vaccination.VaccinationService;

@RestController
@RequestMapping("/user-vaccination")
public class UserVaccinationController {

	private final UserService userService;
	private final VaccinationService vaccinationService;
	
	@Autowired
	public UserVaccinationController(UserService userService, VaccinationService vaccinationService) {
		this.userService = userService;
		this.vaccinationService = vaccinationService;
	}
	
//    @GetMapping
//    public ResponseEntity<Page<Library>> getAll(Pageable pageable) {
//        return ResponseEntity.ok(libraryRepository.findAll(pageable));
//    }
//    
	@GetMapping
	public List<UserDto> listUsers() {
		return userService.getUsers();
	}
	
	//https://www.youtube.com/watch?v=8qhaDBCJh6I
	
}
