public class StringEx3{
	public static void main(String args[]){
		String lyrics = "Woo don't turn around cause we're into me and you Woo don't bring me down cause I'll be your forever  이제 그만 널 잊는다는 게 한참이나 난 외롭겠지만 기다려 니가 오기를 까만 밤이 희게 새도록  기억 속에선 너의 향기가 내 꿈 속에선 너의 목소리 Beautiful lady 내 귓가에 들려오는데  Say I love you come back to me 외로움 속에서 울지 않을게 떠나지마 돌아와줘 널 기다리고 있는 내게로  샤랄라라 샤랄라라 샤랄라 라라라 라라라라 yeah 샤랄라라 샤랄라라 샤랄라 라라라 라 Oh yeah  Woo don't turn around cause we're into me and you Woo don't bring me down cause I'll be your forever  연기처럼 하얗게 번지는 행복했던 너와의 기억이 조금씩 눈물이 되어 나의 뺨에 흘러내릴때  어디선가 넌 날 기억할까 함께 듣던 음악이 흐르면 또 다시 그리워 나에게로 올 것만 같아  Say I love you come back to me 외로움 속에서 울지 않을게 떠나지마 돌아와줘 널 기다리고 있는 내게로  샤랄라라 샤랄라라 샤랄라 라라라 라라라라 yeah 샤랄라라 샤랄라라 샤랄라 라라라 라 Oh yeah";
		String word = "샤랄라";
		int cnt = 0;
		int index = 0;
		
		while(true){
			index = lyrics.indexOf(word,index);
			
			if(index==-1){
				break;
			}else{
				System.out.println(index);
				index = index+word.length();	//문자열에 값이 없으면 -1이 반환되는데 index에다가 word의 길이를 항상 더하면 절대 -1이 되지 않으므로 while의 조건문에 index!=-1을 쓸수가 없었다.
				cnt++;
			}
		}
		System.out.println("샤랄라는 총 "+cnt+"회 나옵니다.");
	}
}