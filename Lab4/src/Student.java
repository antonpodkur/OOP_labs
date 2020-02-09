class Student {
	private String name;
	private String surname;
	private char sex;
	private int age;
	private String country;
	
	public Student(String name, String surname,char sex, int age, String country){
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
		this.country=country;
	}
	public String getname() {
		return name;
	}
	public String getsurname() {
		return surname;
	}
	public char getsex() {
		return sex;
	}
	public int getage() {
		return age;
	}
	public String getcountry() {
		return country;
	}
}
