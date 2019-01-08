## 프로젝트 구조

### Folder
`bin_spotbugs\`: Spotbugs 3.1.7 버전 바이너리  
`find-sec-bug`': 개정된 find-sec-bug 플러그인 프로젝트  
`pmd_ruleset`: pmd 커스텀 룰셋 프로젝트  
`result_spotbugs\`: Spotbugs 분석 결과(xml)  
`result_xml\`: 정리된 xml 결과(샘플)  
`testcases\`: 테스트 케이스  
- `Java\`: 행안부 47개 보안약점-CWE mapping
- `juliet-test-suite-master\`: Juliet TC 컴파일용 프로젝트
- `target\`: 컴파일된 CWE 파일들을 행안부 47개 보안약점 형식으로 분류
- `import-classes.bat`
	- 컴파일된 클래스를 행안부 47개 보안약점으로 분류해 target 폴더에 저장하는 스크립트
	- copy_dir_tree: Java 폴더에서 행안부 47개 보안약점 트리 구조 복사
	- copy_class: juliet-test-suite-master/target 폴더에서 컴파일된 클래스 가져오기

### File
`analysis_spotbugs.bat`: 보안약점 별로 spotbugs를 구동시키는 script  
`findbugs-plugin-new.jar`: 새롭게 개정된 룰셋 jar  
`findbugs-plugin-old.jar`: 개선 전 FindSecurityBugs jar  
`Pattern_mapping.xml`: 보안 약점 별 분류할 패턴이 정리된 xml  
`Pattern_mapping_SB.xml`: Spotbugs 보안 약점 룰만 정리된 xml  
`PMD_ruleset.xml`: PMD 룰셋  
`sort-spotbugs.py`: result_spotbugs에 있는 xml 파일들을 Pattern_mapping.xml에 저장된 버그 패턴으로 분류하는 스크립트  
`statistic.bat`: 전체 bad(), good() 갯수 카운트  

## Build

- 사용자가 추가적으로 검출 규칙을 개발하는 경우 프로젝트에서 직접 빌드하여 테스트에 활용할 수 있다.  
각 프로젝트 빌드 방법은 해당 프로젝트의 README.md 파일을 참고하도록 한다.

## Spotbugs 테스트

### 환경 설정
- Java 1.8 버전 이상  
- Python 3 버전  

### 테스트케이스 구성

```sh
PS .> cd testcases
```

`testcases\` 폴더로 이동한다. 스크립트가 상대 경로로 설정되어 있어 `testcases\` 폴더에서 진행하도록 한다.   

```sh
PS .\testcases> import-classes.bat copy_dir_tree
```
`Java\` 폴더를 참조하여 `target\` 폴더를 생성한다. `Java\`에는 행안부 보안 약점과 CWE 취약점이 매핑되어있다.  

```sh
PS .\testcases> import-classes.bat copy_class
```
`.\juliet-test-suite-master\target\classes\testcases\`에서 컴파일된 클래스를 `target\` 폴더로 복사한다.  

### 테스트 진행

```sh
PS .>analysis_spotbugs.bat
```
보안 약점 별로 분석을 진행한다. 스크립트에서 `findbugs-plugin-new.jar`를 플러그인으로 사용한다.  
개정 이전 버전의 FindSecurityBugs로 테스트를 진행할 경우 스크립트에서 플러그인 경로를 아래와 같이 변경한다.  
```
SET PLUGIN=-pluginList %~dp0findsecbugs-plugin-old.jar
```
분석이 완료된 후에 `result_spotbugs\` 에 보안 약점 별로 xml 파일이 생성되었는지 확인한다.  

```sh
PS .>python sort-spotbugs.py
```
`result_spotbugs\` 폴더에 있는 xml 파일들을 `Pattern_mapping.xml`을 기준으로 분류한다.  
분류된 결과는 현재 폴더에 `시간.xml`로 생성된다.  

### 결과 확인
정리된 xml 파일은 spotbugs 바이너리를 통해 확인할 수 있다.
- `시간.xml` 파일을 spotbugs 바이너리로 열기  
- Package prefix -> Class 순으로 버그들을 정렬
- 보안약점.메소드 형식으로 표기되어 정오탐 구별 가능
	- ex) 01.01 SQL 삽입.bad()

## PMD 

- PMD는 이클립스 또는 IntelliJ 등 IDE 플러그인에 `PMD_ruleset.xml` 파일을 추가하여 진행한다.  
PMD의 경우 IDE에서 정오탐을 쉽게 판별할 수 있기 때문에 스크립트를 이용하는 것보다 IDE를 이용하는 것이 편하다.
