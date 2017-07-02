package ru.chuikov.ObrReiting.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="rights_id",  nullable = false,unique = false)
    private Right right;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usersGroups_id",nullable = false,unique = false)
    private UserGroup group;

    @Column(name = "token")
    private String token;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "mail")
    private String mail;

    //Setters and Getters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Right getRight() {
        return right;
    }
    public void setRight(Right right) {
        this.right = right;
    }
    public UserGroup getGroup() {
        return group;
    }
    public void setGroup(UserGroup group) {
        this.group = group;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    //Constractions
    public User() {
    }
    public User(String token, String login, String password, String mail) {
        this.token = token;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }
    public User(String token, String login, String password) {

        this.token = token;
        this.login = login;
        this.password = password;
    }
    public User(String token, String login) {

        this.token = token;
        this.login = login;
    }
    public User(String token) {

        this.token = token;
    }
    public User(UserGroup group) {

        this.group = group;
    }
    public User(Right right, UserGroup group, String token, String login, String password, String mail) {

        this.right = right;
        this.group = group;
        this.token = token;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }
    public User(Right right, UserGroup group, String token, String login, String password) {

        this.right = right;
        this.group = group;
        this.token = token;
        this.login = login;
        this.password = password;
    }
    public User(Right right, UserGroup group, String token, String login) {

        this.right = right;
        this.group = group;
        this.token = token;
        this.login = login;
    }
    public User(Right right, UserGroup group, String token) {

        this.right = right;
        this.group = group;
        this.token = token;
    }
    public User(Right right, UserGroup group) {

        this.right = right;
        this.group = group;
    }
    public User(Right right) {

        this.right = right;
    }
}
