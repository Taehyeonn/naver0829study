package bit701.day0906;

public class Ex5_arrMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//최대값, 최소값 구하기
		int[] data;
		int max, min;
		data=new int[] {5,-12,5,8,45,100,315,43,3,7};
	
		max = data[0];
		min = data[0];
		for(int i=0; i<data.length; i++) {
			if(max<data[i]) {
				max=data[i];
			}
			if(min>data[i])
			min=data[i];
		}
		System.out.println("max : "+max);
		System.out.println("min : "+min);
	}
	
	

}
