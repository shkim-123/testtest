package day0713.ch07;

public class Ex01_ArrayTest {

	public static void main(String[] args) {
		
		//---------------------------------------------------
		// int형 배열 선언과 동시에 new 예약어를 사용하여 데이터 초기화
		//---------------------------------------------------
		int[] num = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//---------------------------------------------------
		// for문
		// 초기화식: i = 0
		// 조건식: i < num.length, 11 < 10 인 경우 반복 수행 종료
		// 증감식: i 를 1 증가
		//---------------------------------------------------
		for(int i = 0; i < num.length; i++) {
			// num 배열의 인덱스가 i인 데이터 출력
			System.out.println(num[i]); // 1 ~ 10까지 출력
		}
		
		/* ==================================================
		 * 배열(array) 자료형
		 * 자료가 연속으로 나열된 자료 구조(data structure)이다
		 * 
		 * 배열 요소
		 * 배열을 이루는 각각의 자료를 말한다
		 * 배열 요소는 자료형이 모두 같다
		 * 
		 * 배열 선언과 초기화
		 * 자료형[] 배열이름 = new 자료형[개수];
		 * 자료형 배열이름[] = new 자료형[개수];
		 * 
		 * new 예약어를 통해 배열을 생성하며
		 * 배열을 선언하면 선언한 자료형과 배열 길이에 따라 메모리가 할당된다
		 * 
		 * 배열 초기화
		 * 배열을 선언하면 그와 동시에 각 요소의 값이 초기화된다
		 * 정수는 0, 실수는 0.0, 객체 배열은 null로 초기화됨
		 * 
		 * 인덱스 연산자 []
		 * 배열 이름에 []를 사용하는 것을 인덱스 연산이라 한다
		 * 배열 요소가 저장된 메모리 위치를 찾아 주는 역할이다
		 * 변수 이름 -> 변수가 저장된 메모리 위치 찾기
		 * [i]인덱스 연산 -> i번째 요소의 위치를 찾아 해당 위치의 메모리에 값을 넣거나 이미 저장되어 있는 값을 가져와서 사용
		 * 
		 * length 속성
		 * 배열의 길이, 처음에 선언한 배열의 전체 요소 개수를 의미한다
		 * ==================================================
		 */

	}

}