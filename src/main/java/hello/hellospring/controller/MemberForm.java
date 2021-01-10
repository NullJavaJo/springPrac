package hello.hellospring.controller;

public class MemberForm {

    // html파일의 name 속성에 적힌 이름을 보고 값을 넣어줌
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
