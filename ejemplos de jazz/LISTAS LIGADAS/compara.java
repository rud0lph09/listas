class compara{
	public static void main(String[]args){
		String a="Mauricio";
		String b="Perez";
		int c=a.compareTo(b);
		int d=b.compareTo(a);
		System.out.println(c);
		System.out.println(d);

		if(a.compareTo(b)<0){
			System.out.println("Primero va "+a);
		}
		else
			System.out.println("Primero va "+b);
	}
}
