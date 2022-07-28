# Spring_assignment2
1. 게시글을 수정할 때는 해당 게시글의 아이디 값을 알아야 하기 때문에 req.param를 통해 주소 마지막에 id값을 사용하였고 또한 수정할 데이터 값을 DTO에 모아 req.body에 담았다.
반면 삭제할 때는 해당 게시글의 아이디 값만 알면 되기 때문에 req.param만 사용하였다.

2. 게시글 비밀번호 확인할 때는 수정할 때와 마찬가지로 req.param과 req.body를 같이 사용하였고 게시글 단일 조회는 삭제와 같이 아이디 값을 주소에 포함된 변수에 담는 req.param만을
사용하였다. 게시글 작성은 기본주소값에 req.body를 통해 작성해야 할 데이터를 담았다. 

3. 최대한 Restful한 API를 구현하려고 노력하였다. URL내에 동사와 대문자가 아닌 post라는 명사와 소문자를 사용하였고 마지막 문자로 /를 포함시키지 않았다. 그러나 
resource의 스토어 이름을 복수 명사 posts로 사용해야 하는데 단수로 표현하였다.

4. 최대한 적절한 관심사 분리가 될 수 있도록 만들었다. Repository에서는 JpaRepository를 상속받도록 함으로써 기본적인 CRUD를 가능하게 하였고 
수정날짜 기준 최신순으로 데이터 리스트를 정렬해 모아놨다. Service에서는 각 게시글에 대한 기능구현이 이루어지도록 만들었다. 게시글 작성부터 조회나 수정 및 삭제까지 서비스 기능에
관한 것들은 다 서비스 클래스에 모아두었다. Controller에서는 Service에서 만든 기능들을 (CRUD)Mapping을 통해 각 주소에 맞게 사용 할 수 있도록 구현하였다.

5. BoradController, BoardRepository, BoardService, ResponseService가 bean에 해당한다. 

6. API 명세서 작성 가이드라인의 Response와 최대한 동일하게 구현하려고 노력하였다.
