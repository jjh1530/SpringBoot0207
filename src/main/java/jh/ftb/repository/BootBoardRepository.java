package jh.ftb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jh.ftb.entity.BootBoard;

@Repository // 생략 가능
public interface BootBoardRepository extends JpaRepository<BootBoard, Long>{  // JpaRepository<entity(테이블), PK의 타입 정보>
	
	//public List<BootBoard> findAll();
	// -> select * from BootBoard
	//pulbic BootBoard findById(Long idx);
	// -> select * from BootBoard Where idx = #{idx}
	//쿼리 메서드 (메소드 이름을 기반으로 JPQL을 생성하는 기능 검색대상은 Entity)
	//public BootBoard findBootBoardByWriter(String writer);  findByWriter도 문제없음
	// -> select * from BootBoard where writer = #{writer}
	
	
	
}
