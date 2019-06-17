package io.github.amdagomes.sd.questao4.node2.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    private int code;
    private String name;

    @Override
    public String toString() {
        return "User{" + "code=" + code + ", name=" + name + '}';
    }
    
}
