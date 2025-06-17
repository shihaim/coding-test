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