package com.contacts.test.util;

import com.orm.SugarRecord;


import java.util.Date;

public class Pupil extends SugarRecord<Pupil> {

    String name;
    String houseStreet;
    String town;
    String postcode;
    String contact;
    Boolean isFacebookFriend;
    Boolean isTheoryPassed;
    Boolean isTestBooked;
    String testBookedDate;
    String testPassed;
    String lessonHad;

    public Pupil() {
    }

    public Pupil(String name, String houseStreet, String town, String postcode, String contact, Boolean isFacebookFriend, Boolean isTheoryPassed, Boolean isTestBooked, String testBookedDate, String testPassed, String lessonHad) {
        this.name = name;
        this.houseStreet = houseStreet;
        this.town = town;
        this.postcode = postcode;
        this.contact = contact;
        this.isFacebookFriend = isFacebookFriend;
        this.isTheoryPassed = isTheoryPassed;
        this.isTestBooked = isTestBooked;
        this.testBookedDate = testBookedDate;
        this.testPassed = testPassed;
        this.lessonHad = lessonHad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseStreet() {
        return houseStreet;
    }

    public void setHouseStreet(String houseStreet) {
        this.houseStreet = houseStreet;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getIsFacebookFriend() {
        return isFacebookFriend;
    }

    public void setIsFacebookFriend(Boolean isFacebookFriend) {
        this.isFacebookFriend = isFacebookFriend;
    }

    public Boolean getIsTheoryPassed() {
        return isTheoryPassed;
    }

    public void setIsTheoryPassed(Boolean isTheoryPassed) {
        this.isTheoryPassed = isTheoryPassed;
    }

    public Boolean getIsTestBooked() {
        return isTestBooked;
    }

    public void setIsTestBooked(Boolean isTestBooked) {
        this.isTestBooked = isTestBooked;
    }

    public String getTestBookedDate() {
        return testBookedDate;
    }

    public void setTestBookedDate(String testBookedDate) {
        this.testBookedDate = testBookedDate;
    }

    public String getTestPassed() {
        return testPassed;
    }

    public void setTestPassed(String testPassed) {
        this.testPassed = testPassed;
    }

    public String getLessonHad() {
        return lessonHad;
    }

    public void setLessonHad(String lessonHad) {
        this.lessonHad = lessonHad;
    }
}
