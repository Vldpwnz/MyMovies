package vlad.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vlad.project.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void returnSavedUserFromDatabase() {
		User user = userServiceImpl.findByUserName("Vlad");
		assertEquals("Vlad", user.getUserName());
		assertEquals(2, user.getId());
	}
	

}
