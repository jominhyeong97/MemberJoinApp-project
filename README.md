# MemberJoinApp-project

@Join으로 fk관계성 설정,Many설정(lazy...)  -> 디벨롭 옵션: author에도 LIst<post>를 가져보자.@oneToMany(mappedby..)
currenttime, updatetime 을 commonDto로 만들어서 상속으로 구현해보기 단,기본적으로 Entity는 상속이안됨.. 어떻게?
findbyemailAnd~~ 로 여러조건 확인
jpql로 fetchinnerjoin 구현
페이징처리 활용해보기!
@builder.default 많이 활용
yml 분리 및 gitignore 설정
common에 로그 분류작업 클래스(로그컨트롤)
	
postService에서 fk 해놨고 조회시 author id 나올수 있게
