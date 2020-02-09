
public class Word {
	int amount_of_loud_sounds=0;
	private String[] lastarrey;
	String name;
	private String mass[] = new String[]{"e","y","u","i","o","a","E","Y","U","I","O","A"};
	
	public Word(String word) {
		this.name = word;
		lastarrey = word.split("");
		for(int i = 0;i<lastarrey.length;i++) {
			//System.out.print(lastarrey[i]+",");
			for(int k=0;k<mass.length;k++) {
				if (lastarrey[i].equals(mass[k])) amount_of_loud_sounds++;
				//System.out.println(lastarrey[i]+" "+mass[k]);
			}
		}
	//	System.out.println(name);
		//System.out.println(amount_of_loud_sounds);
	}
	
	
	public int get_amount_of_loud_sounds() {
		return amount_of_loud_sounds;
	}
}
