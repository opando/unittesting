package pe.opm.ut.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Any;

import static org.mockito.Mockito.*;
import pe.opm.ut.ImpuestoDAO;
import pe.opm.ut.ImpuestoService;
import pe.opm.ut.ImpuestoServiceImpl;

public class ImpuestoTest {

	ImpuestoService impuestoService;
	ImpuestoDAO impuestoDAO;
	
	@Before
	public void setUp() throws Exception {
		
		impuestoDAO = mock(ImpuestoDAO.class);
		when(impuestoDAO.getImpuesto("IGV")).thenReturn(0.18);
		
		impuestoService = new ImpuestoServiceImpl(impuestoDAO);
	}

	@Test
	public void calcularImpuestoTest() {
		
	  Assert.assertEquals(180.0, impuestoService.calcularImpuesto(1000.0), 0.1);	  
	  Assert.assertEquals(36.0, impuestoService.calcularImpuesto(200.0), 0.1);
	  Assert.assertEquals(34000.0, impuestoService.calcularImpuesto(200000.0), 0.1);
	  verify(impuestoDAO,times(3)).getImpuesto("IGV");
	  
	}
	
	@Test
	public void calcularImpuestoRentaTest() {
		Assert.assertTrue(true);

	  
	  
	}

}
