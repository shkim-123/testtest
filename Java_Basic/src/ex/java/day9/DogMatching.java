package ex.java.day9;

import java.util.Scanner;

public class DogMatching {

	public static void main(String[] args) {
		// 애완견 이름 "곰돌이", "복돌이", "흰둥이", "깨소금", "까만콩"
		// Scanner 와 array를 사용해 매칭되는 문자열 출력
		// 애완견 이름 입력되면 아래 같이 변환해서 출력
		
		Scanner scanner = new Scanner(System.in);
		String[] dogArray = {"곰돌이", "복돌이", "흰둥이", "깨소금", "까만콩"};
		String[] dogName = {"Bear", "Gift", "White", "Sesami", "Black"};
		
		System.out.println("곰돌이, 복돌이, 흰둥이, 깨소금, 까만콩 중 입력해주세요.");
		String sc = scanner.nextLine();
		
		for(int i = 0; i < dogArray.length; i++) {
		/*	if(sc.equals(dogArray[i])) {
				System.out.println(dogName[i]);
			} */
			
			if(sc.indexOf(dogArray[i]) == 0) {
				System.out.println(dogName[i]);
			}
		}
		
	}

}