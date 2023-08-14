//실제 DB의 테이블과 매칭될 클래스이며 보통 entity 쿨래스라고도 한다.
//JPA를 사용하시면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는,
//이 entity 클래스의 수정을 통해 작업한다.

package com.example.practice01.domain.posts;

import com.example.practice01.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//롬복-> getter setter 같은 메소드나 생성자 코드를 최소화 시켜주는 코드, 필수x
@Getter//롬복 어노테이션, 클래스 내 모든 필드의 getter 메소드 자동 추가
@NoArgsConstructor// 롬복 어노테이션, 생성자 자동 추가
@Entity //JAP 어노테이션, 테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity {

    @Id// 해당 테이블의 PK 필드, PK는 Long 타입 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙
    private Long id;

    //테이블의 column 어노테이션 궂이 생성하지 않아도 모든 필드는 테이블의 column이 되나,
    //추가적으로 변경이 필요한 옵션이 있을때 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    /*
    public Posts(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    alt+insert 단축키로 쉽게 추가 가능한 title 필드의 생성자와 getter setter 메소드
    롬복을 사용하면 각 필드의 이런 메소드들을 축소가능
    */

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    //column 어노테이션이없어도 테이블의 colum 이다.

    @Builder//롬복 어노테이셔느 빌더 패턴 클래스 생성
    public  Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title =title;
        this.content=content;
    }
}
