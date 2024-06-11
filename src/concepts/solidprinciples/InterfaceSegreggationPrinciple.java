package concepts.solidprinciples;

public class InterfaceSegreggationPrinciple {
	
	public static void main(String args[]) {
		
		InterfaceSegreggationPrinciple1 isp1 = new InterfaceSegreggationPrinciple1();
		isp1.turnOnEngineVehicle();
		
		System.out.println();
		
		InterfaceSegreggationPrinciple2 isp2 = new InterfaceSegreggationPrinciple2();
		isp2.turnOnElectricVehicle();
	
	}

}
