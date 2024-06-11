package concepts.solidprinciples.dependency.inversion.principle;

public class School {
	
	private final Bus bus;
	
	public School(final Bus bus) {
		this.bus = bus;
	}

	public Bus getBus() {
		return bus;
	}
	
	

}
