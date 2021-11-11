package comp125;

public class EmailAddressClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmailAddress email = new EmailAddress("gaurav.gupta", "mq.edu.au");
		System.out.println(email); //should display "gaurav.gupta@mq.edu.au"
		
		EmailAddress email2 = new EmailAddress();
		System.out.println(email2); //should display "tba@gmail.com"
		
		EmailAddress email3 = new EmailAddress("gaurav.gupta", "mq.edu.au");
		System.out.println(email3); //should display "gaurav.gupta@mq.edu.au"
	
		EmailAddress email4 = new EmailAddress("gaurav_gupta", "mq.edu.au");
		System.out.println(email4); //should display "gaurav_gupta@mq.edu.au"
		
		EmailAddress email5 = new EmailAddress("gaurav.gupta", "mq.edu");
		System.out.println(email5); //should display "gaurav.gupta@mq.edu"
		
		System.out.println(email.equals(email3)); //true
		System.out.println(email.equals(email4)); //false. because of username
		System.out.println(email.equals(email5)); //false. because of domain
	}

}
