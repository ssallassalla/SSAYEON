package com.ssayeon.ssayeon.member.domain;


public enum RoleType {
// APPLICANT 싸피 비인증 사용자, MEMBER 싸피 인증 사용자
 APPLICANT("APPLICANT"), MEMBER("MEMBER"), ADMIN("ADMIN");

 private String name;

 RoleType(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }

 public boolean isNot(String roleType) {
  return !this.name.equals(roleType);
 }
}