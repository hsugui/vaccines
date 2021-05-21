package com.zup.orange.vaccines.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zup.orange.vaccines.model.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
//@ActiveProfiles("test")
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void itShouldGetAUserWhenSearchingByTheirCpf() {
		// given
		String userCpf = "49948153057";
		User x = new User();
		x.setName("X");
		x.setBirthDate(LocalDate.now().minusYears(21));
		x.setCpf(userCpf);
		x.setEmail("userxxx@email.com");
		em.persist(x);
//	or	repository.save(x);
		
		// when
		Optional<User> userByCpf = repository.findUserByCpf("49948153057");
		
		// then
		Assertions.assertNotNull(userByCpf);
		Assertions.assertEquals(userCpf, userByCpf.get().getCpf());
	}

}
