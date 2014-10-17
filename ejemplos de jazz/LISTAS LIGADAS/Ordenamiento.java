public class Ordenamiento{
	private void Intercambio(int []v, int i, int j){
		int aux=v[i];
		v[i]=v[j];
		v[j]=aux;
	}
	public void OrdenaIntercambio(int []v){
		int i, j;
		for(i=0;i<indice;i++)
			for(j=1+i;j<=indice;j++)
				if(v[i]>v[j])
					Intercambio(v,i,j);
	}
}