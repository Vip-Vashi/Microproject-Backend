package com.micro.onlinebiddingsys.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.micro.onlinebiddingsys.model.AdministrativeUser;
import com.micro.onlinebiddingsys.repository.AdminuserRepo;

@SpringBootTest
class AdminServiceImplTest {
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@Mock
	private AdminuserRepo adminuserRepo;
	
	@BeforeEach
	public void set() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveAdministrativeUser() {
	
		 AdministrativeUser admin = new AdministrativeUser();
	        admin.setAdminUserId(1);
	        when(adminuserRepo.save(admin)).thenReturn(admin);

	        AdministrativeUser result = adminServiceImpl.saveAdministrativeUser(admin);
	        assertNotNull(result);
	        assertEquals(1, result.getAdminUserId());
	        verify(adminuserRepo, times(1)).save(admin);
	}

	@Test
	void testGetAdministrativeUserById() {
		AdministrativeUser admin = new AdministrativeUser();
        admin.setAdminUserId(1);
        when(adminuserRepo.findById(1)).thenReturn(admin);

        AdministrativeUser result = adminServiceImpl.getAdministrativeUserById(1);
        assertNotNull(result);
        assertEquals(1, result.getAdminUserId());
        verify(adminuserRepo, times(1)).findById(1);
	}

	@Test
	void testGetAllAdministrativeUsers() {
		 AdministrativeUser admin1 = new AdministrativeUser();
	        admin1.setAdminUserId(1);
	        AdministrativeUser admin2 = new AdministrativeUser();
	        admin2.setAdminUserId(2);
	        List<AdministrativeUser> admins = Arrays.asList(admin1, admin2);
	        when(adminuserRepo.findAll()).thenReturn(admins);

	        List<AdministrativeUser> result = adminServiceImpl.getAllAdministrativeUsers();
	        assertNotNull(result);
	        assertEquals(2, result.size());
	        verify(adminuserRepo, times(1)).findAll();
	}
	  @Test
	     void testDeleteAdministrativeUser() {
	        AdministrativeUser admin = new AdministrativeUser();
	        admin.setAdminUserId(1);
	        when(adminuserRepo.findById(1)).thenReturn(admin);

	        adminServiceImpl.deleteAdministrativeUser(1);
	        verify(adminuserRepo, times(1)).delete(1);
	    }
	@Test
	void testDeleteAdministrativeUserNotPresent() {
		
		  when(adminuserRepo.findById(1)).thenReturn(null);

	        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
	            adminServiceImpl.deleteAdministrativeUser(1);
	        });

	        assertEquals("AdministrativeUser with ID 1 does not exist.", thrown.getMessage());
	}

	@Test
	void testUpdateAdministrativeUser() {
		AdministrativeUser admin = new AdministrativeUser();
        admin.setAdminUserId(1);
        when(adminuserRepo.findById(1)).thenReturn(admin);
        when(adminuserRepo.save(admin)).thenReturn(admin);

        AdministrativeUser result = adminServiceImpl.updateAdministrativeUser(admin);
        assertNotNull(result);
        assertEquals(1, result.getAdminUserId());
        verify(adminuserRepo, times(1)).save(admin);
	}

}
