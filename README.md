# KR

# ASQ-Library

- 이 라이브러리는 안드로이드 Amplify 전용 라이브러리입니다.
- Amplify에서 커스텀 쿼리를 사용할 경우 불가피하게 코드가 길어지는 현상을 막기 위해서 하나의 추상화된 클래스로 Pagination을 만들 수 있는 기능을 제공합니다.
- 단순히 인덱싱에 의존하여 쿼리를 하는 경우에도, filter를 거는 경우에도 동일하게 사용이 가능합니다.

## 주의사항

- document 추상화 메소드에는 limit을 추가하는 것을 권장하지 않습니다. ( 특히 filter를 사용할 경우에는 더더욱 사용하지 않는 것을 권장합니다. ) 쿼리 시간이 길어질 수 있습니다.
- 의도하지 않은 오류가 발생할 경우에는 Issues 탭에 어떤 방식으로 문제가 발생했는지의 경위를 작성해주세요.
- 해당 라이브러리는 RxJava3 + Amplify를 활용하고 있습니다.

## 버전 로그

### 0.0.1

- 라이브러리 최초 추가 및 Pagination 기능 추가

# ENG

## ASQ-Library

- This library is dedicated to Android Amplify.
- If you use custom queries in Amplify, it provides the ability to create a pagination into one abstracted class to prevent inevitable code lengthening.
- It can be used either simply by indexing or by hanging a filter.

## Precautions

- Adding a limit to the document abstraction method is not recommended (especially when using filter). ) Query times can be longer.
- If an unintended error occurs, please write how the problem occurred on the Issues tab.
- The library utilizes RxJava3 + Amplify.

## Version Log

### 0.0.1

- Adding libraries for the first time and adding pagination capabilities
