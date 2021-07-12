
public class Personaldata implements Comparable<Personaldata> {
	int employeeno;
	String lastname;
	String firstname;
	String streetaddress;
	double hrbefore9;
	double hrbetween;
	double hrmidnight;
	public Personaldata() {
	hrbefore9=0;
	hrbetween=0;
	hrmidnight=0;
	employeeno=0;
	firstname=null;
	lastname=null;
	streetaddress=null;
}
	public int getEmployeeno() {
		return employeeno;
	}
	public void setEmployeeno(int employeeno) {
		this.employeeno = employeeno;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public double getHrbefore9() {
		return hrbefore9;
	}
	public void setHrbefore9(double hrbefore9) {
		this.hrbefore9 = hrbefore9;
	}
	public double getHrbetween() {
		return hrbetween;
	}
	public void setHrbetween(double hrbetween) {
		this.hrbetween = hrbetween;
	}
	public double getHrmidnight() {
		return hrmidnight;
	}
	public void setHrmidnight(double hrmidnight) {
		this.hrmidnight = hrmidnight;
	}
	@Override
	public int compareTo(Personaldata o) {
		// TODO Auto-generated method stub
		return lastname.compareTo(o.getlastname());
	}
	
}
