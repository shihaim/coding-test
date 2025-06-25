### Kotlin
#### 1. 배열 선언시 차이점
```kotlin
// 초기화 방식도 전혀 다름!!
val a: IntArray = intArrayOf()
val b: Array<Int> = arrayOf()
```
✅ 참고: `Array<Int>`와 `IntArray`는 다릅니다

`IntArray`는 기본형 배열 (`int[]`) 에 대응

`Array<Int>`는 객체 배열 (`Integer[]`) 에 대응

타입 체크할 때는 `IntArray`인지 `Array<Int>`인지 정확하게 구분해야 해요.

#### 2. Null-Safe
termsMap[p[1]]!!처럼 non-null 단정을 사용하거나, safe call로 처리하면 됩니다.  

✅ 방법 1: non-null 단정 (!!)
```kotlin
privacyMap[p[1]] = d.plusMonths(termsMap[p[1]]!!)
```
!!는 null이 아님을 보장할 수 있을 때 사용합니다.   
만약 termsMap[p[1]]가 null이라면 런타임 예외가 발생합니다.

✅ 방법 2: null 체크 후 처리 (?.let)
```kotlin
termsMap[p[1]]?.let { months ->
    privacyMap[p[1]] = d.plusMonths(months)
}
```
더 안전한 방식이며, null일 경우 코드를 실행하지 않습니다.   

✅ 보충 설명
코드의 핵심은 HashMap<String, Long> 타입이지만, get() 메서드의 반환 타입은 Long?입니다.   
이는 Kotlin의 null-safety 기능 덕분에 생기는 일반적인 상황입니다:

```kotlin
val termsMap: HashMap<String, Long> = ...
val value: Long? = termsMap["A"] // 존재하지 않을 수 있기 때문에 Long? 반환
```
