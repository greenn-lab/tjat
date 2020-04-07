# Testcontainers
테스트에서 docker container 가 필요할 때, 가용할 수 있는 라이브러리(테스트 툴킷 이라기엔 뭔가 부족한가? 그건 잘 모르겠네요.) 가 있어요.  
[https://www.testcontainers.org](https://www.testcontainers.org/) 여기가면 공식문서도 있고 Getting start 도 있고요.   

~~근데, 효용성은... 있는거겠죠. github star 를 3천개나 받았으니깐..~~  
사실, 잘 모르겠어요. 이렇게 쓰는게 의미가 있는건지...  
CI 툴이 빌드 할 때? 초기화된 테스트?  그런 시나리오로 테스트를 하는 것 자체가 좀 회의적이지만.  

자! 우리는 언제 어떤 상황에 맞닥트릴 지 모르는 험난하고 고단한 개발자니까, 전방위적인 경험과 학습이 필요하겠죠?!

지금까지 해오던 스터디 예제를 실제 작동되는 코드로 만들어요. 어플리케이션 배포 상황을 예시해서.

코드를 수정했는데...

[Application.java](../../java/learning/tjat/part3/Application.java)    
[Member.java](../../java/learning/tjat/part3/model/entity/Member.java)  
[Study.java](../../java/learning/tjat/part3/model/entity/Study.java)  
[MemberRepository.java](../../java/learning/tjat/part3/repository/MemberRepository.java)  
[StudyRepository.java](../../java/learning/tjat/part3/repository/StudyRepository.java)  
[MemberService.java](../../java/learning/tjat/part3/service/MemberService.java)  
[StudyService.java](../../java/learning/tjat/part3/service/StudyService.java)  

이렇게 했어요.  
docker container 로 DB를 띄우고, 거기에 위 어플리케이션을 연결해서 띄워 볼거에요. 
