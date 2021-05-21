package com.zup.orange.vaccines.implementation;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zup.orange.vaccines.controller.form.UserForm;
import com.zup.orange.vaccines.model.User;
import com.zup.orange.vaccines.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	private UserServiceImpl underTest;

	@BeforeEach
	void setUp() throws Exception {
		underTest = new UserServiceImpl(userRepository);
	}

	@Test
	void canGetAllUsers() {
		// when
		underTest.getUsers();
		// then
		Mockito.verify(userRepository).findAll();
	}

	@Test
	@Disabled
	void testGetUserByCpf() {
		fail("Not yet implemented");
	}

	@Test
	void canAddNewUser() {
		// given
		UserForm userForm = new UserForm("User", "user@email.com", "45466394068", LocalDate.now().minusYears(21));
		User user = userForm.convert();
		
		// when
		underTest.addNewUser(userForm);
		
		//then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		Mockito.verify(userRepository).save(userArgumentCaptor.capture());
		User capturedUser = userArgumentCaptor.getValue();
		AssertionsForClassTypes.assertThat(capturedUser).isEqualTo(user);
	}

	@Test
	@Disabled
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDeleteUser() {
		fail("Not yet implemented");
	}

}
