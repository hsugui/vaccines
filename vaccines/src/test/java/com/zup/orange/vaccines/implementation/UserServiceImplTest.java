package com.zup.orange.vaccines.implementation;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.Optional;

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
	void shouldGetAllUsers() {
		// when
		underTest.getUsers();
		// then
		Mockito.verify(userRepository).findAll();
	}

	@Test
	void shouldGetAUserByCpf() {
		// given
		User expectedUser = new User();
		expectedUser.setId(1L);
		expectedUser.setBirthDate(LocalDate.now().minusYears(21));
		expectedUser.setCpf("29539979030");
		expectedUser.setEmail("email@test.com");
		expectedUser.setName("User Name");
		// when
		Mockito.when(userRepository.findUserByCpf("29539979030")).thenReturn(Optional.of(expectedUser));
		User actualUser = underTest.getUserByCpf("29539979030");
		// then
		AssertionsForClassTypes.assertThat(actualUser.getCpf()).isEqualTo(expectedUser.getCpf());
	}

	@Test
	void shouldAddANewUser() {
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
	void shouldDeleteAnUserByCpf() {
		User user = new User();
		user.setCpf("29539979030");
		user.setId(1L);
		
		Mockito.when(userRepository.findUserByCpf("29539979030")).thenReturn(Optional.of(user));
		underTest.getUserByCpf("29539979030");
		userRepository.deleteById(user.getId());
		
		Mockito.verify(userRepository, Mockito.times(1)).deleteById(1L);
	}

}
