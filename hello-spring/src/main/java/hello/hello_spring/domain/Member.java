package hello.hello_spring.domain;

public class Member { //회원객체
    private Long id; //멤버변수
    private String name; //멤버변수

    public Long getId() { //id를 반환(id 생성)
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
