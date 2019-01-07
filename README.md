# 디렉토리 구조

## Folder
**bin_spotbugs**: Spotbugs 3.1.7 버전 바이너리 폴더
**result_spotbugs**: Spotbugs 분석 xml이 저장되는 폴더
**result_xml**: 정리된 결과 xml 폴더
**testcases**: 테스트 케이스가 폴더
- Java: 행안부 47개 보안약점-CWE mapping
- juliet-test-suite-master: Juliet TC 컴파일용 디렉토리
- target: 컴파일된 CWE 파일들을 행안부 47개 보안약점 형식으로 분류
- import-classes.bat
	- 컴파일된 클래스를 행안부 47개 보안약점으로 분류해 target 폴더에 저장하는 스크립트
	- copy_dir_tree: Java 폴더에서 행안부 47개 보안약점 트리 구조 복사
	- copy_class: juliet-test-suite-master/target 폴더에서 컴파일된 클래스 가져오기

## File
**analysis_spotbugs.bat**: 보안약점 별로 spotbugs를 구동시키는 script
**findbugs-plugin-new**: 새롭게 개정된 룰셋 jar
**findbugs-plugin-old**: 개선 전 FindSecurityBugs jar
**Pattern_mapping.xml**: 보안 약점 별 분류할 패턴이 정리된 xml
**Pattern_mapping_SB.xml**: Spotbugs 보안 약점 룰만 정리된 xml
**PMD_ruleset**: PMD 룰셋
**sort-spotbugs.py**: result_spotbugs에 있는 xml 파일들을 Pattern_mapping.xml에 저장된 버그 패턴으로 분류하는 스크립트
**statistic.bat**: 전체 bad(), good() 갯수 카운트


# 테스트 진행

## 환경 설정
Java 1.8 버전 이상
Python 3 버전

## 테스트케이스 구성하기

`> cd testcases` : testcases 폴더로 이동
`testcases> import-classes.bat copy_dir_tree` : 디렉토리 구조 복사
`testcases> import-classes.bat copy_class` : 컴파일된 클래스 복사
- **testcases\target** 폴더에 컴파일된 클래스가 정상적으로 생성되었는지 확인

## 테스트 진행하기

`>analysis_spotbugs.bat` : 보안 약점 별 분석 진행
- 분석이 완료된 후에 **result_spotbugs**에 보안 약점 별로 xml 파일이 생성되었는지 확인

`>python sort-spotbugs.py` 
- Pattern_mapping.xml을 기준으로 분류
- 같은 디렉토리에 **시간.xml**로 결과 파일이 생성되었는지 확인

**bin_spotbugs\bin\spotbugs.bat** 을 실행시켜 정리된 xml 파일 확인
- Package prefix -> Class 순으로 버그들을 정렬
- 보안약점.메소드 형식으로 표기되어 정오탐 구별 가능
	- ex) 01.01 SQL 삽입.bad()