import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class BabySitterData  {

	public static void main(String[] args) throws IOException  {
		Scanner payrolldata=new Scanner(new File("Payrolldatafile.txt"));
		Scanner personaldata=new Scanner(new File("Personaldatafile.txt"));
	ArrayList<Personaldata>personalrecorddata=new ArrayList<Personaldata>();
	ArrayList<Payrolldata>payrollrecorddata=new ArrayList<Payrolldata>();
	while(personaldata.hasNextLine()) {
	Personaldata personalobj=new Personaldata();
	personalobj.setEmployeeno(Integer.parseInt(personaldata.nextLine().strip()));
	String lines=personaldata.nextLine();
	String[] linesplit=lines.split(",");
	personalobj.setfirstname(linesplit[1]);
	personalobj.setlastname(linesplit[0]);
	personalobj.setStreetaddress(personaldata.nextLine());
	lines=personaldata.nextLine();
	linesplit=lines.split(" ");
	personalobj.setHrbefore9(Double.parseDouble(linesplit[0]));
	personalobj.setHrbetween(Double.parseDouble(linesplit[1]));
	personalobj.setHrmidnight(Double.parseDouble(linesplit[2]));
	if(personaldata.hasNextLine()) {
		personaldata.nextLine();
	}

	personalrecorddata.add(personalobj);
	}
	Collections.sort(personalrecorddata);
	while(payrolldata.hasNextLine()) {
		
		Payrolldata payrollobj= new Payrolldata();
		payrollobj.setEmployeeno(Integer.parseInt(payrolldata.nextLine().strip()));
		payrollobj.setDaysworked(Integer.parseInt(payrolldata.nextLine().strip()));
		for(int i=0; i<payrollobj.getDaysworked(); i++) {
			Integer[]arr=new Integer[4];
			ArrayList<Integer[]>payrolllist=payrollobj.getTimes();
		String line=payrolldata.nextLine();
		String[]splitline=line.split(":| ");
	
		arr[0]=Integer.parseInt(splitline[0]);
		arr[1]=Integer.parseInt(splitline[1]);
		arr[2]=Integer.parseInt(splitline[2]);
		arr[3]=Integer.parseInt(splitline[3]);
		
		payrolllist.add(arr);
		
		}
		if(payrolldata.hasNextLine()) {
		payrolldata.nextLine();
		}
		payrollrecorddata.add(payrollobj);
	}
	boolean payrollfound=false;
	for(Personaldata personalobj: personalrecorddata) {
		for(Payrolldata payrollobj: payrollrecorddata) {
			if(personalobj.getEmployeeno()==payrollobj.getEmployeeno()) {
				System.out.printf("%04d ", personalobj.getEmployeeno());
				System.out.println(personalobj.getfirstname()+" "+personalobj.getlastname());
				System.out.println(personalobj.getStreetaddress());
				System.out.println("Total pay due: "+totalpay(personalobj, payrollobj));
				System.out.println();
				payrollfound=true;
				break;
			}
		}
		if(payrollfound==false) {
		System.out.println(personalobj.getEmployeeno());
		System.out.println(personalobj.getfirstname()+" "+personalobj.getlastname());
		System.out.println(personalobj.getStreetaddress());
		System.out.println("Total pay due: 0");
		System.out.println();
		}
	}
	
	
	
	}
	
	public static double totalpay(Personaldata personalobj, Payrolldata payrollobj){
		double totalpay=0;
		for(int i=0; i<payrollobj.getTimes().size(); i++){
			totalpay+=individualPay(payrollobj.getTimes().get(i), personalobj.getHrbefore9(), personalobj.getHrbetween(), personalobj.getHrmidnight());
			
		}
		return totalpay;
		}
	public static double individualPay(Integer[]arr, double before, double between, double after) {
		int starthr=arr[0];
		int startmin=arr[1];
		int endhour=arr[2];
		int endmin=arr[3];
		double pay=0;
		if(starthr>=6&&starthr<9) {
			if(endhour>=6&&endhour<9) {
				int hours=endhour-starthr;
				int minutes=endmin-startmin;
				 pay=(hours*before)+((minutes*before))/60;
				return pay;
			}
			else {
				int hrs=9-starthr;
				int minutes=0-startmin;
				pay=(hrs*before)+((minutes*before))/60;
				starthr=9;
				startmin=0;
			}
			
		}
		 if(starthr>=9&&starthr<12) {
			 if(endhour>=9&endhour<12) {
				 int hours=endhour-starthr;
				 int minutes=endmin-startmin;
				 pay+=(hours*between)+((minutes*between))/60;
				 return pay;
			 }
			 else {
					int hrs=12-starthr;
					int minutes=0-startmin;
					pay+=(hrs*between)+((minutes*between))/60;
					starthr=0;
					startmin=0;
				}
			 

			 }
		 
			 int hours=endhour-starthr;
			 int minutes=endmin-startmin;
			 pay+=(hours*after)+((minutes*after))/60;
			 return pay;
	}
	
	
	
	
	
	
	
	
}
		