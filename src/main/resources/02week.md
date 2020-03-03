# Assertion
검증 내용을 확인할 때 쓰는 거죠.

Assertion 을 활용하기 위해서 테스트 시나리오를 만들어봐요.  
스터디 클래스를 만들고 진행상태를 넣어서 테스트를 하는거에요.
```java
public class Study {
  
  @Getter
  private StudyStatus status;
  
}

public enum StudyStatus {
  DRAFT,
  RUNNING,
  FINISH
}
``` 

스터디 클래스가 `status` 라는 상태 필드를 가지고 있어요.

```java
class StudyTest {
  @Test
  @DisplayName("스터디를 만들어요.")
  void should_create_study() {
    Study study = new Study();

    assertNotNull(study);
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
}
```
`assertEquals` 와 같이 assertion 을 쓰고 마지막 파라미터로 메세지를 던질 수 있어요.  
![](images/IMG04.png)  
예쁘게 설명이 나와요. 테스트를 만들고 한참 후에 다시 코드를 봤을 때나 한참 후에 어떤 부작용으로 테스트가 깨져서 다시 살펴볼 때, 유용하겠죠?!

```java
class StudyTest {
  // ...
  @Test
  @DisplayName("스터디를 만들어요. #2")
  void should_create_study_II() {
    final Study study = new Study();
    
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        () -> "스터디 처음 만들때 DRAFT 라고요!");
  }  
}
```
람다로 `Supplier` 를 넣을 수도 있어요.
`String` 으로 문자를 넣으면 코드가 컴파일 되면서 무조건 문자연산을 해야하는데, 람다를 쓰면 테스트가 깨질 때에만 문자연산이 실행되서 시스템 효율을 높일 수 있대요.
~~굳이 그렇게까지 신경써야 할까 싶기도 하고...~~

`assertTrue(...)`, `assertFalse(...)` ... 등등 있어요.

```java
class StudyTest {
  // ...

  @Test
  @DisplayName("스터디 정원을 설정해요.")
  void should_set_limits() {
    final Study study = new Study(-10);
    
    assertAll(
        () -> assertEquals(StudyStatus.DRAFT, study.getStatus()),
        () -> assertTrue(study.getLimit() > 0)
    );
  }
}
```
만약 이런 테스트가 있으면, 2개의 assertion 이 있는데 첫번째에서 깨지니깐 2번째는 확인도 못해보게 돼요.
그래서 하나가 깨져도 마저 테스트를 실행해주는게 있죠.  
![](images/IMG05.png)  
`2 failures` 라고 나오죠.

```java
class Study {
  private final int limit;
  
  public Study(final int limit) {
    if (limit < 0) {
      throw new IllegalArgumentException("greater then zero.");  
    }
    
    this.limit = limit;
  }

  // ...
}
```
이렇게 정원을 정해서 클래스 인스턴스를 만들게 하고,
```java
class StudyTest {
  // ...
  @Test
  @DisplayName("스터디 정원을 설정해요.#2")
  void should_set_limits_II() {
    
    assertThrows(IllegalArgumentException.class,
        () -> new Study(-10));
    
  }
}
```
이렇게 예외를 받는 테스트도 할 수 있어요. JUnit4 보다 더 편해진 것 같네요!

```java
class StudyTest {
  // ...
  @Test
  @DisplayName("timeout 내에 처리가 되어야해요.")
  void should_finish_in_time() {
    assertTimeout(Duration.ofMillis(100), () -> {
      System.out.println("some execution ...");
      TimeUnit.MILLISECONDS.sleep(200);
    });
  } 
}
```
이렇게 실행하면
![](images/IMG06.png)  
이렇게 100ms 내에 끝나야하는데, 300ms 를 지연시켜서 시간이 초과했다고 오류가 나요.
 
```java
  @Test
  @DisplayName("timeout 내에 처리가 되어야해요.")
  void should_finish_in_time_preemptively() {
    assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
      System.out.println("some execution ...");
      TimeUnit.MILLISECONDS.sleep(200);
    });
  }
```
비슷한데, 이런식으로 preemptively (선제, 선취, 우선순위) 하게 할 수 있는데, timeout 에 우선 순위를 둬서,
테스트 코드를 끝까지 처리하지 못해도 제한된 시간이 지나면 그냥 끝내버리는 거고.
`assertTimeout(...)` 은 그래도 테스트 실행을 끝까지 지켜본다는 차이가 있어요. `assertTimeoutPreemptively(...)` 는 `ThreadLocal` 같은 테스트에는 적합하지 않대요.
아마도 제한된 시간이 지나면 thread 를 죽이는데, `ThreadLocal` 을 이용하면 참조된 메모리 때문에 thread 가 죽질 않아서 그런게 아닐까 싶긴 하네요.
(테스트는 안해 봄;;;)

[AssertJ](https://joel-costigliola.github.io/assertj/) 나 [Hamcrest](http://hamcrest.org/), [Truth](https://truth.dev/) 등등의 Assertion 지원 도구들이 있고, 취향대로 골라 쓰라는 말씀.
아마도 예전엔 AssertJ 를 은근 썼는데, JUnit5 에서 기본적으로 제공하는 assertion 이 다양해져서 굳이 의존성 추가해 가면서 다른 도구를 추가하지 않게 되지 않을까 하는 개인적인 생각이에요.


# 조건에 따라 테스트하기

