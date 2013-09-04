package pe.opm.ut;

public class ImpuestoServiceImpl implements ImpuestoService {

	private static final String CONSTANT_IGV = "IGV";
	private static final double IGV = 0.18;
	private static final double IGV2 = 0.17;
	private ImpuestoDAO impuestoDAO;
	
		
	public ImpuestoServiceImpl(ImpuestoDAO impuestoDAO) {
		
		this.impuestoDAO = impuestoDAO;
	}
	

	@Override
	public Double calcularImpuesto(Double monto) {
		
		//impuestoDAO
		double igv = impuestoDAO.getImpuesto(CONSTANT_IGV);
		
		
		if (monto > 10000.0) {
			return monto * IGV2;
		}
		
		return monto * igv;
		
		
	}

}
