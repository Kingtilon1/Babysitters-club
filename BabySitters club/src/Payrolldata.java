import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Payrolldata {
int employeeno;
int daysworked;
ArrayList<Integer[]>times;
public Payrolldata() {
	employeeno=0;
	daysworked=0;
	times=new ArrayList<Integer[]>();
}
public int getEmployeeno() {
	return employeeno;
}
public void setEmployeeno(int employeeno) {
	this.employeeno = employeeno;
}
public int getDaysworked() {
	return daysworked;
}
public void setDaysworked(int daysworked) {
	this.daysworked = daysworked;
}
public ArrayList<Integer[]> getTimes() {
	return times;
}
public void setTimes(ArrayList<Integer[]> times) {
	this.times = times;
}
}
