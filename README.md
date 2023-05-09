# ■ 앱 이름 : 고마워 동물아

- 개발 환경 : 안드로이드 스튜디오
- 구동 최적화 에뮬레이터 : Nexus 5X API 33
- 기능 요약 : 인텐트(화면전환, 데이터전환), 메뉴 뷰, 대화상자 뷰, 토스트 뷰, 스피너 뷰, DB 컬럼 3개 구현

## ■ 앱 컨셉

 - 이 앱은 자신이 키우고 있는 반려동물에 대한 데이터를 받아들인 뒤 관리하는 앱입니다.
 - 반려동물 용품의 개수나 유통기한 등을 관리할 수 있으며 관련 기능들이 존재합니다.

## ■ 기능 설명

### □ 메인 액티비티

 - 맨 처음 앱을 틀면 반려동물의 이름과 나이를 입력합니다.
 - 여기서 메뉴를 눌러 회전 메뉴(왼쪽회전, 원래대로, 오른쪽회전) 를 누르면 발자국 이미지가 회전됩니다.
 - 입력 후 넘어가면 타이틀에 이름과 나이가 출력됩니다. (인텐트 사용으로 데이터 전달)

### □ 타이틀 액티비티

 - 우선 상단에 이전 액티비티에서 받아온 이름과 나이 데이터가 출력됩니다.
 - 타이틀로 넘어갈 시 토스트로 고마워 (동물이름) 아! 가 출력됩니다. (토스트 사용)
 - 타이틀에서 스피너로 반려동물 종을 선택하면 해당 종이 출력됩니다 (스피너 사용)
 - 타이틀의 첫번째 버튼인 상태 버튼을 눌러 현재 내 동물의 상태를 표시합니다 (대화상자 사용)
 - 타이틀의 두번째 버튼인 동물용품 관리를 눌러 동물용품 관리 액티비티로 이동합니다. (인텐트 사용으로 화면전환)

### □ DB 액티비티

 - 컬럼은 용품이름 / 개수 / 유통기한으로 3개입니다.
 - 초기화 / 입력 / 삭제 / 조회 구현 완료했습니다.
