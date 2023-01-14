//package com.space.sns.model.entity;
//
//import com.space.sns.model.UserRole;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.SQLDelete;
//import org.hibernate.annotations.Where;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.time.Instant;
//
//@Entity
//@Table(name = "\"user\"")
//@Getter
//@Setter
//@SQLDelete(sql = "UPDATE \"user\" SET removed_at = NOW() WHERE id=?")
//@Where(clause = "deleted_at is NULL")
//public class UserEntity {
//    @Id
//    private Integer id;
//
//    @Column(name = "userName")
//    private String userName;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "role")
//    @Enumerated(EnumType.STRING)
//    private UserRole role = UserRole.USER;
//    @Column(name = "registered_at")
//    private Timestamp registeredAt;
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
//    @Column(name = "deleted_at")
//    private Timestamp deletedAt;
//
//    @PrePersist
//    void registeredAt() {
//        this.registeredAt = Timestamp.from(Instant.now());
//    }
//    @PrePersist
//    void updatedAt() {
//        this.updatedAt = Timestamp.from(Instant.now());
//    }
//
//    public static UserEntity of(String userName, String password) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUserName(userName);
//        userEntity.setPassword(password);
//
//        return userEntity;
//    }
//}
